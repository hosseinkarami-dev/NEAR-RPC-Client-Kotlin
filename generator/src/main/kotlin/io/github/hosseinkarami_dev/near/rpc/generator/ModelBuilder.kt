package io.github.hosseinkarami_dev.near.rpc.generator

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.STRING
import com.squareup.kotlinpoet.TypeAliasSpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asTypeName
import io.github.hosseinkarami_dev.near.rpc.generator.SchemaHelper.generateKdoc
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline
import io.github.hosseinkarami_dev.near.rpc.generator.SchemaHelper.getPrimitiveTypeName
import io.github.hosseinkarami_dev.near.rpc.generator.SchemaHelper.isPrimitiveType
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.booleanOrNull
import java.io.File
import kotlin.collections.forEach

class ModelBuilder(
    private val spec: OpenApiSpec,
    private val packageName: String,
    private val output: File
) {
    fun buildModels() {
        val builtTypes = mutableSetOf<String>()

        spec.components.schemas.forEach { (name, schema) ->
            val className = toPascalCase(name)
            if (builtTypes.contains(className)) return@forEach

            val fileBuilder = FileSpec.builder(packageName, className)

            buildSchemaRecursive(
                fileBuilder = fileBuilder,
                className = className,
                schema = schema,
                builtTypes = builtTypes
            )

            // write the top-level file
            fileBuilder.build().writeTo(output)
        }
    }

    fun buildSchemaRecursive(
        fileBuilder: FileSpec.Builder,
        className: String,
        schema: Schema,
        builtTypes: MutableSet<String>
    ) {
        if (builtTypes.contains(className)) return

        val topSchema = if (!schema.ref.isNullOrBlank()) {
            val refName = schema.ref.substringAfterLast("/")
            spec.components.schemas[refName] ?: schema
        } else schema

        fun markBuilt(name: String) {
            builtTypes.add(name)
        }

        //handles RpcHealthResponse - like ones
        if (schema.enum?.all { it == null } == true && schema.nullable == true) {
            val typeAliasBuilder =
                TypeAliasSpec.builder(className, Unit::class.asTypeName().copy(nullable = true))
                    .addModifiers(KModifier.PUBLIC)
            schema.generateKdoc()?.let { typeAliasBuilder.addKdoc(it) }

            fileBuilder.addTypeAlias(typeAliasBuilder.build())
            return
        }

        // 1) enum top-level
        if (!topSchema.enum.isNullOrEmpty()) {
            val nonNullLiterals = topSchema.enum.filterNotNull()
            if (nonNullLiterals.isEmpty()) {
                val objBuilder = TypeSpec.objectBuilder(className).addAnnotation(Serializable::class)
                topSchema.generateKdoc()?.let { objBuilder.addKdoc(it) }
                fileBuilder.addType(objBuilder.build())
                markBuilt(className)
                return
            }

            val enumBuilder = TypeSpec.enumBuilder(className).addAnnotation(Serializable::class)
            topSchema.generateKdoc()?.let { enumBuilder.addKdoc(it) }
            val used = mutableMapOf<String, Int>()
            topSchema.enum.filterNotNull().forEach { lit ->
                var constName = toConstantName(lit)
                val c = used.getOrDefault(constName, 0)
                if (c > 0) constName = "${constName}_$c"
                used[constName] = c + 1
                val ann = AnnotationSpec.builder(SerialName::class).addMember("%S", lit).build()
                enumBuilder.addEnumConstant(
                    constName,
                    TypeSpec.anonymousClassBuilder().addAnnotation(ann).build()
                )
            }
            fileBuilder.addType(enumBuilder.build())
            markBuilt(className)
            return
        }

        // 2) oneOf/anyOf
        val combinedList = (topSchema.oneOf ?: emptyList()) + (topSchema.anyOf ?: emptyList())
        if (combinedList.isNotEmpty()) {
            buildCombinedSchema(fileBuilder, className, topSchema, builtTypes)
            return
        }

        // 3) allOf
        if (!topSchema.allOf.isNullOrEmpty()) {
            val (mergedProps, mergedRequired) = mergeAllOfInto(topSchema)

            if (mergedProps.isEmpty()) {
                val primTypeName = topSchema.allOf.asSequence()
                    .map { item ->
                        val resolved =
                            if (!item.ref.isNullOrBlank()) spec.components.schemas[item.ref.substringAfterLast(
                                "/"
                            )] ?: item else item
                        if (resolved.isPrimitiveType()) resolved.getPrimitiveTypeName() else null
                    }
                    .firstOrNull { it != null }

                if (primTypeName != null) {
                    val ctor =
                        FunSpec.constructorBuilder().addParameter("value", primTypeName).build()
                    val cbBuilder = TypeSpec.classBuilder(className)
                        .addModifiers(KModifier.VALUE)
                        .addAnnotation(Serializable::class)
                        .addAnnotation(JvmInline::class)
                        .primaryConstructor(ctor)
                        .addProperty(
                            PropertySpec.builder("value", primTypeName).initializer("value").build()
                        )
                    topSchema.generateKdoc()?.let { cbBuilder.addKdoc(it) }

                    fileBuilder.addType(cbBuilder.build())
                    markBuilt(className)
                    return
                }
            }

            buildObjectFromProps(
                fileBuilder,
                className,
                mergedProps,
                mergedRequired.toMutableSet(),
                builtTypes,
                topSchema
            )
            return
        }

        // 4) object
        if (topSchema.type == "object" && !topSchema.properties.isNullOrEmpty()) {
            buildObjectFromProps(
                fileBuilder,
                className,
                topSchema.properties,
                topSchema.required?.toMutableSet() ?: mutableSetOf(),
                builtTypes,
                topSchema
            )
            return
        }

        // 5) array wrapper
        if (topSchema.type == "array" && topSchema.items != null) {
            val itemSchema =
                if (!topSchema.items.ref.isNullOrBlank()) spec.components.schemas[topSchema.items.ref.substringAfterLast(
                    "/"
                )] ?: topSchema.items else topSchema.items
            val itemClassName = "${className}Item"
            buildSchemaRecursive(fileBuilder, itemClassName, itemSchema, builtTypes)
            val listType = ClassName("kotlin.collections", "List").parameterizedBy(
                ClassName(
                    packageName,
                    itemClassName
                )
            )
            val ctor = FunSpec.constructorBuilder().addParameter("items", listType).build()
            val classBuilder = TypeSpec.classBuilder(className)
                .addModifiers(KModifier.DATA)
                .addAnnotation(Serializable::class)
                .primaryConstructor(ctor)
                .addProperty(PropertySpec.builder("items", listType).initializer("items").build())
            topSchema.generateKdoc()?.let { classBuilder.addKdoc(it) }
            fileBuilder.addType(classBuilder.build())
            markBuilt(className)
            return
        }

        // 6) primitive fallback
        if (topSchema.isPrimitiveType()) {
            val prim = topSchema.getPrimitiveTypeName() ?: STRING
            val ctor = FunSpec.constructorBuilder().addParameter("value", prim).build()
            val cbBuilder = TypeSpec.classBuilder(className)
                .addModifiers(KModifier.VALUE)
                .addAnnotation(Serializable::class)
                .addAnnotation(JvmInline::class)
                .primaryConstructor(ctor)
                .addProperty(PropertySpec.builder("value", prim).initializer("value").build())
            topSchema.generateKdoc()?.let { cbBuilder.addKdoc(it) }
            fileBuilder.addType(cbBuilder.build())
            markBuilt(className)
            return
        }

        // fallback JsonElement wrapper
        val ctor = FunSpec.constructorBuilder()
            .addParameter("value", ClassName("kotlinx.serialization.json", "JsonElement")).build()
        val cbBuilder = TypeSpec.classBuilder(className)
            .addModifiers(KModifier.DATA)
            .addAnnotation(Serializable::class)
            .primaryConstructor(ctor)
            .addProperty(
                PropertySpec.builder(
                    "value",
                    ClassName("kotlinx.serialization.json", "JsonElement")
                ).initializer("value").build()
            )
        topSchema.generateKdoc()?.let { cbBuilder.addKdoc(it) }
        fileBuilder.addType(cbBuilder.build())
        markBuilt(className)
    }

    fun buildCombinedSchema(
        fileBuilder: FileSpec.Builder,
        className: String,
        schema: Schema,
        builtTypes: MutableSet<String>
    ) {
        val variants = mutableListOf<Schema>()
        schema.oneOf?.let { variants.addAll(it) }
        schema.anyOf?.let { variants.addAll(it) }
        if (variants.isEmpty()) return

        if (variants.size == 1) {
            val v = variants.first()
            val (mergedProps, mergedRequired) = mergeAllOfInto(v)
            buildObjectFromProps(
                fileBuilder,
                className,
                mergedProps,
                mergedRequired.toMutableSet(),
                builtTypes,
                v
            )
            return
        }

        val sealedBuilder = TypeSpec.classBuilder(className).addModifiers(KModifier.SEALED)
            .addAnnotation(Serializable::class)
        schema.generateKdoc()?.let { sealedBuilder.addKdoc(it) }

        val topLevelProps = schema.properties ?: emptyMap()
        val topLevelRequired = schema.required ?: emptyList()

        //to-do building abstract variables (currently not being implemented in this version


        //
        variants.forEachIndexed { idx, v ->
            // Merge allOf inside this variant (important)
            val (variantMergedProps, variantMergedRequired) = mergeAllOfInto(v)
            val effectiveProps = variantMergedProps.ifEmpty { (v.properties ?: emptyMap()) }
            val effectiveRequired = variantMergedRequired.ifEmpty { (v.required ?: emptyList()) }


            val candidate = effectiveProps.entries.find { (_, prop) ->
                prop.enum?.isNotEmpty() == true
            }
            val typeLiteral = candidate?.value?.enum?.firstOrNull()

            val variantTitle = v.title ?: typeLiteral ?: when {
                !v.ref.isNullOrBlank() -> v.ref.substringAfterLast("/")
                v.enum?.isNotEmpty() == true -> v.enum.filterNotNull().first()
                v.properties?.isNotEmpty() == true -> v.properties.keys.first()
                else -> "Variant${idx + 1}"
            }

            val subclassName = toPascalCase(variantTitle)


            val subBuilder = TypeSpec.classBuilder(subclassName).addAnnotation(Serializable::class)
                .superclass(ClassName(fileBuilder.build().packageName, className))
            v.generateKdoc()?.let { subBuilder.addKdoc(it) }

            val subCtor = FunSpec.constructorBuilder()
            val nestedTypes = mutableListOf<TypeSpec>()

            if (v.isPrimitiveType()) {
                // determine primitive Kotlin type (uses SchemaHelper.getPrimitiveTypeName)
                val prim = v.getPrimitiveTypeName() ?: STRING
                // add constructor param + property "value"
                subCtor.addParameter("value", prim)
                subBuilder.addProperty(
                    PropertySpec.builder("value", prim)
                        .initializer("value")
                        .build()
                )
                v.generateKdoc()?.let { subBuilder.addKdoc(it) }
                // finalize subclass and attach to sealed parent
                subBuilder.primaryConstructor(subCtor.build())
                sealedBuilder.addType(subBuilder.build())
                return@forEachIndexed
            }

            // If this variant is just a $ref (e.g. oneOf: { $ref: ... })
            if (!v.ref.isNullOrBlank()) {
                val ref = v.ref.substringAfterLast("/")
                val refClass = toPascalCase(ref)
                val refSchema = spec.components.schemas[ref]

                // ensure referenced type is generated as a top-level file (same as before)
                if (refSchema != null && !builtTypes.contains(refClass)) {
                    val refFileBuilder = FileSpec.builder(packageName, refClass)
                    buildSchemaRecursive(refFileBuilder, refClass, refSchema, builtTypes)
                    refFileBuilder.build().writeTo(output)
                }

                // If we have top-level props (e.g. block_hash / block_height) AND the referenced schema is an object
                // with properties (or becomes one after mergeAllOfInto) -> inline its props into this subclass.
                val canInlineRef = refSchema != null && (
                        (refSchema.type == "object" && !refSchema.properties.isNullOrEmpty())
                                || (!mergeAllOfInto(refSchema).first.isEmpty())
                        )

                if (topLevelProps.isNotEmpty() && canInlineRef) {
                    // merge allOf inside the referenced schema then get effective props
                    val (refMergedProps, refMergedRequired) = mergeAllOfInto(refSchema)
                    val refEffectiveProps =
                        refMergedProps.ifEmpty { refSchema.properties ?: emptyMap() }

                    // add referenced props directly to subclass ctor + properties
                    refEffectiveProps.forEach { (pn, ps) ->
                        val isReq =
                            refMergedRequired.contains(pn) || (refSchema.required?.contains(pn) == true)
                        val t = resolveTypeForSchema(
                            ps,
                            subclassName,
                            nestedTypes,
                            pn,
                            isReq,
                            fileBuilder,
                            builtTypes
                        )
                        val localized = localizeType(t, nestedTypes)
                        val paramName = toCamelCase(pn)

                        val paramBuilder = ParameterSpec.builder(paramName, localized)
                        val dv = defaultValueLiteralForSchema(ps, localized)
                        if (dv != null) {
                            paramBuilder.defaultValue("%L", dv)
                        } else if (localized.isNullable) {
                            paramBuilder.defaultValue("%L", "null")
                        }
                        subCtor.addParameter(paramBuilder.build())

                        val pBuilder = PropertySpec.builder(paramName, localized)
                            .initializer("%N", paramName)
                            .addAnnotation(
                                AnnotationSpec.builder(SerialName::class).addMember("%S", pn)
                                    .build()
                            )
                        ps.generateKdoc()?.let { pBuilder.addKdoc(it) }
                        subBuilder.addProperty(pBuilder.build())
                    }

                    // add any nested types discovered while resolving ref props
                    nestedTypes.forEach { subBuilder.addType(it) }

                    // add top-level common props from parent schema (avoid duplicates)
                    topLevelProps.forEach { (pname, pschemaRaw) ->
                        if (refEffectiveProps.containsKey(pname)) return@forEach
                        val isReq = topLevelRequired.contains(pname)
                        val t = resolveTypeForSchema(
                            pschemaRaw,
                            className,
                            nestedTypes,
                            pname,
                            isReq,
                            fileBuilder,
                            builtTypes
                        )
                        val localized = localizeType(t, nestedTypes)
                        val paramName = toCamelCase(pname)

                        val paramBuilder = ParameterSpec.builder(paramName, localized)
                        val dv = defaultValueLiteralForSchema(pschemaRaw, localized)
                        if (dv != null) {
                            paramBuilder.defaultValue("%L", dv)
                        } else if (localized.isNullable) {
                            paramBuilder.defaultValue("%L", "null")
                        }
                        subCtor.addParameter(paramBuilder.build())

                        val pBuilder = PropertySpec.builder(paramName, localized)
                            .initializer("%N", paramName)
                            .addAnnotation(
                                AnnotationSpec.builder(SerialName::class).addMember("%S", pname)
                                    .build()
                            )
                        pschemaRaw.generateKdoc()?.let { pBuilder.addKdoc(it) }
                        subBuilder.addProperty(pBuilder.build())
                    }

                    // finalize subclass and skip further processing for this variant
                    subBuilder.primaryConstructor(subCtor.build())
                    sealedBuilder.addType(subBuilder.build())
                    return@forEachIndexed
                } else {
                    // fallback: keep previous behavior — create a single 'value' param of referenced type
                    val valueType = ClassName(fileBuilder.build().packageName, refClass)
                    subCtor.addParameter("value", valueType)
                    subBuilder.addProperty(
                        PropertySpec.builder("value", valueType).initializer("value").build()
                    )
                }
            }
            // special-case: single-property object (e.g. { "X": { ... } })
            else if (effectiveProps.size == 1) {
                val (caseKey, caseSchema) = effectiveProps.entries.first()

                // fallback to the old behavior (single-property wrapper) if the case value is not an object
                val innerTypeRaw = resolveTypeForSchema(
                    caseSchema,
                    subclassName,
                    nestedTypes,
                    caseKey,
                    true,
                    fileBuilder,
                    builtTypes
                )
                val innerType = localizeType(innerTypeRaw, nestedTypes)
                val paramName = toCamelCase(caseKey)

                val paramBuilder = ParameterSpec.builder(paramName, innerType)
                val dv = defaultValueLiteralForSchema(caseSchema, innerType)
                if (dv != null) {
                    paramBuilder.defaultValue("%L", dv)
                } else if (innerType.isNullable) {
                    paramBuilder.defaultValue("%L", "null")
                }
                subCtor.addParameter(paramBuilder.build())

                val pb = PropertySpec.builder(paramName, innerType).initializer("%N", paramName)
                caseSchema.generateKdoc()?.let { pb.addKdoc(it) }
                pb.addAnnotation(AnnotationSpec.builder(SerialName::class).addMember("%S", caseKey).build())
                subBuilder.addProperty(pb.build())
            }
            // enum string literal variants (keeps them as objects under sealed)
            else if (v.type == "string" && !v.enum.isNullOrEmpty()) {
                val nonNullEnum = v.enum.filterNotNull()
                if (topLevelProps.isEmpty()) {
                    nonNullEnum.forEach { lit ->
                        val objName = toPascalCase(lit)
                        val objBuilder =
                            TypeSpec.objectBuilder(objName).addAnnotation(Serializable::class)
                                .addAnnotation(
                                    AnnotationSpec.builder(SerialName::class)
                                        .addMember("%S", lit).build()
                                ).superclass(
                                    ClassName(
                                        fileBuilder.build().packageName,
                                        className
                                    )
                                )
                        v.generateKdoc()?.let { objBuilder.addKdoc(it) }
                        sealedBuilder.addType(objBuilder.build())
                    }
                    return@forEachIndexed
                }
            }
            // ---- lift multi-property variant into subclass directly (no Payload nested class) ----
            else if (effectiveProps.isNotEmpty() && effectiveProps.size > 1) {
                // Use variantTitle (already computed above) as the base for the subclass name
                val variantSimpleName = toPascalCase(variantTitle)
                val specificSubBuilder = TypeSpec.classBuilder("${variantSimpleName}")
                    .addAnnotation(Serializable::class)
                    .superclass(ClassName(fileBuilder.build().packageName, className))
                v.generateKdoc()?.let { specificSubBuilder.addKdoc(it) }

                val specificCtor = FunSpec.constructorBuilder()

                // For each property of the variant, resolve type and add as constructor param + property
                effectiveProps.forEach { (pn, ps) ->
                    val isReq = effectiveRequired.contains(pn)
                    val t = resolveTypeForSchema(
                        ps,
                        variantSimpleName,
                        nestedTypes,
                        pn,
                        isReq,
                        fileBuilder,
                        builtTypes
                    )
                    val localized = localizeType(t, nestedTypes)
                    val paramName = toCamelCase(pn)

                    val paramBuilder = ParameterSpec.builder(paramName, localized)
                    val dv = defaultValueLiteralForSchema(ps, localized)
                    if (dv != null) {
                        paramBuilder.defaultValue("%L", dv)
                    } else if (localized.isNullable) {
                        paramBuilder.defaultValue("%L", "null")
                    }
                    specificCtor.addParameter(paramBuilder.build())

                    val pBuilder = PropertySpec.builder(paramName, localized)
                        .initializer("%N", paramName)
                        .addAnnotation(
                            AnnotationSpec.builder(SerialName::class).addMember("%S", pn)
                                .build()
                        )
                    ps.generateKdoc()?.let { pBuilder.addKdoc(it) }
                    specificSubBuilder.addProperty(pBuilder.build())
                }

                // Add any nested types that were collected while resolving variant properties
                nestedTypes.forEach { specificSubBuilder.addType(it) }

                // Also lift top-level (parent) properties into this subclass just like before
                topLevelProps.forEach { (pname, pschemaRaw) ->

                    //avoid duplicate props
                    if (effectiveProps.containsKey(pname)) return@forEach

                    val isReq = topLevelRequired.contains(pname)
                    val t = resolveTypeForSchema(
                        pschemaRaw,
                        className,
                        nestedTypes,
                        pname,
                        isReq,
                        fileBuilder,
                        builtTypes
                    )
                    val localized = localizeType(t, nestedTypes)
                    val paramName = toCamelCase(pname)

                    val paramBuilder = ParameterSpec.builder(paramName, localized)
                    val dv = defaultValueLiteralForSchema(pschemaRaw, localized)
                    if (dv != null) {
                        paramBuilder.defaultValue("%L", dv)
                    } else if (localized.isNullable) {
                        paramBuilder.defaultValue("%L", "null")
                    }
                    specificCtor.addParameter(paramBuilder.build())

                    val pBuilder = PropertySpec.builder(paramName, localized)
                        .initializer("%N", paramName)
                        .addAnnotation(
                            AnnotationSpec.builder(SerialName::class).addMember("%S", pname)
                                .build()
                        )
                    pschemaRaw.generateKdoc()?.let { pBuilder.addKdoc(it) }
                    specificSubBuilder.addProperty(pBuilder.build())
                }

                specificSubBuilder.primaryConstructor(specificCtor.build())
                sealedBuilder.addType(specificSubBuilder.build())

                // IMPORTANT: stop processing this variant further (avoid also adding the generic subBuilder)
                return@forEachIndexed
            }

            // general case: build a payload data class from effectiveProps
            else {
                val payloadName = "${toPascalCase(variantTitle)}Payload"
                val payloadCtor = FunSpec.constructorBuilder()
                val payloadBuilder =
                    TypeSpec.classBuilder(payloadName).addModifiers(KModifier.DATA)
                        .addAnnotation(Serializable::class)
                v.generateKdoc()?.let { payloadBuilder.addKdoc(it) }

                effectiveProps.forEach { (pn, ps) ->
                    val isReq = effectiveRequired.contains(pn)
                    val t = resolveTypeForSchema(
                        ps,
                        subclassName,
                        nestedTypes,
                        pn,
                        isReq,
                        fileBuilder,
                        builtTypes
                    )
                    val paramName = toCamelCase(pn)

                    val paramBuilder = ParameterSpec.builder(paramName, t)
                    val dv = defaultValueLiteralForSchema(ps, t)
                    if (dv != null) {
                        paramBuilder.defaultValue("%L", dv)
                    } else if (t.isNullable) {
                        paramBuilder.defaultValue("%L", "null")
                    }
                    payloadCtor.addParameter(paramBuilder.build())

                    val pBuilder = PropertySpec.builder(paramName, t).initializer("%N", paramName)
                        .addAnnotation(
                            AnnotationSpec.builder(SerialName::class).addMember("%S", pn)
                                .build()
                        )
                    ps.generateKdoc()?.let { pBuilder.addKdoc(it) }
                    payloadBuilder.addProperty(pBuilder.build())
                }

                if (effectiveProps.isNotEmpty()) {
                    payloadBuilder.primaryConstructor(payloadCtor.build())
                    subBuilder.addType(payloadBuilder.build())
                    val payloadType = ClassName(
                        fileBuilder.build().packageName,
                        className,
                        subclassName,
                        payloadName
                    )
                    subCtor.addParameter("payload", payloadType)
                    subBuilder.addProperty(
                        PropertySpec.builder("payload", payloadType).initializer("payload")
                            .build()
                    )
                }
            }

            // add any nested types collected
            nestedTypes.forEach { subBuilder.addType(it) }

            // now add top-level (common) properties from the parent 'schema' to this subclass
            topLevelProps.forEach { (pname, pschemaRaw) ->

                //avoid duplicate props
                if (effectiveProps.containsKey(pname)) return@forEach

                val isReq = topLevelRequired.contains(pname)
                val t = resolveTypeForSchema(
                    pschemaRaw,
                    className,
                    nestedTypes,
                    pname,
                    isReq,
                    fileBuilder,
                    builtTypes
                )
                val paramName = toCamelCase(pname)

                val paramBuilder = ParameterSpec.builder(paramName, t)
                val dv = defaultValueLiteralForSchema(pschemaRaw, t)
                if (dv != null) {
                    paramBuilder.defaultValue("%L", dv)
                } else if (t.isNullable) {
                    paramBuilder.defaultValue("%L", "null")
                }
                subCtor.addParameter(paramBuilder.build())

                val pb = PropertySpec.builder(paramName, t).initializer("%N", paramName)
                    .addAnnotation(
                        AnnotationSpec.builder(SerialName::class).addMember("%S", pname).build()
                    )
                pschemaRaw.generateKdoc()?.let { pb.addKdoc(it) }
                subBuilder.addProperty(pb.build())
            }

            subBuilder.primaryConstructor(subCtor.build())
            sealedBuilder.addType(subBuilder.build())
        }

        fileBuilder.addType(sealedBuilder.build())
        builtTypes.add(className)
    }

    fun buildObjectFromProps(
        fileBuilder: FileSpec.Builder,
        className: String,
        propsMap: Map<String, Schema>,
        requiredSet: MutableSet<String>,
        builtTypes: MutableSet<String>,
        parentSchema: Schema? = null
    ) {
        if (builtTypes.contains(className)) return

        val nested = mutableListOf<TypeSpec>()
        val ctor = FunSpec.constructorBuilder()
        val classBuilder = TypeSpec.classBuilder(className).addModifiers(KModifier.DATA)
            .addAnnotation(Serializable::class)
        parentSchema?.generateKdoc()?.let { classBuilder.addKdoc(it) }

        propsMap.forEach { (pname, pschemaRaw) ->
            // resolve property-level $ref if present by deref'ing and ensuring top-level file
            if (!pschemaRaw.ref.isNullOrBlank()) {
                val refName = pschemaRaw.ref.substringAfterLast("/")
                val refClass = toPascalCase(refName)
                val refSchema = spec.components.schemas[refName]
                if (refSchema != null && !builtTypes.contains(refClass)) {
                    val refFileBuilder = FileSpec.builder(packageName, refClass)
                    buildSchemaRecursive(refFileBuilder, refClass, refSchema, builtTypes)
                    refFileBuilder.build().writeTo(output)
                }
                val propType = ClassName(
                    fileBuilder.build().packageName,
                    refClass
                ).copy(nullable = !requiredSet.contains(pname) || (pschemaRaw.nullable == true))

                val paramName = toCamelCase(pname)
                val paramBuilder = ParameterSpec.builder(paramName, propType)
                val dv = defaultValueLiteralForSchema(pschemaRaw, propType)
                if (dv != null) {
                    paramBuilder.defaultValue("%L", dv)
                } else if (propType.isNullable) {
                    paramBuilder.defaultValue("%L", "null")
                }
                ctor.addParameter(paramBuilder.build())

                val pBuilder = PropertySpec.builder(paramName, propType)
                    .initializer("%N", paramName)
                    .addAnnotation(
                        AnnotationSpec.builder(SerialName::class).addMember("%S", pname).build()
                    )
                pschemaRaw.generateKdoc()?.let { pBuilder.addKdoc(it) }
                classBuilder.addProperty(pBuilder.build())
                return@forEach
            }

            // handle allOf single-ref shortcut
            if (!pschemaRaw.allOf.isNullOrEmpty()) {
                val refItem = pschemaRaw.allOf.firstOrNull { !it.ref.isNullOrBlank() }
                if (refItem != null) {
                    val refName = refItem.ref!!.substringAfterLast("/")
                    val refClass = toPascalCase(refName)
                    val refSchema = spec.components.schemas[refName]
                    if (refSchema != null && !builtTypes.contains(refClass)) {
                        val refFileBuilder = FileSpec.builder(packageName, refClass)
                        buildSchemaRecursive(refFileBuilder, refClass, refSchema, builtTypes)
                        refFileBuilder.build().writeTo(output)
                    }
                    val propType = ClassName(
                        fileBuilder.build().packageName,
                        refClass
                    ).copy(nullable = !requiredSet.contains(pname) || (pschemaRaw.nullable == true))

                    val paramName = toCamelCase(pname)
                    val paramBuilder = ParameterSpec.builder(paramName, propType)
                    val dv = defaultValueLiteralForSchema(pschemaRaw, propType)
                    if (dv != null) {
                        paramBuilder.defaultValue("%L", dv)
                    } else if (propType.isNullable) {
                        paramBuilder.defaultValue("%L", "null")
                    }
                    ctor.addParameter(paramBuilder.build())

                    val pBuilder = PropertySpec.builder(paramName, propType)
                        .initializer("%N", paramName)
                        .addAnnotation(
                            AnnotationSpec.builder(SerialName::class).addMember("%S", pname)
                                .build()
                        )
                    pschemaRaw.generateKdoc()?.let { pBuilder.addKdoc(it) }
                    classBuilder.addProperty(pBuilder.build())
                    return@forEach
                }
            }

            // else resolve with our inline resolver
            val resolvedType = resolveTypeForSchema(
                pschemaRaw,
                className,
                nested,
                pname,
                requiredSet.contains(pname),
                fileBuilder,
                builtTypes
            )
            val paramName = toCamelCase(pname)
            val paramBuilder = ParameterSpec.builder(paramName, resolvedType)
            val dv = defaultValueLiteralForSchema(pschemaRaw, resolvedType)
            if (dv != null) {
                paramBuilder.defaultValue("%L", dv)
            } else if (resolvedType.isNullable) {
                paramBuilder.defaultValue("%L", "null")
            }
            ctor.addParameter(paramBuilder.build())

            val pBuilder = PropertySpec.builder(paramName, resolvedType)
                .initializer("%N", paramName).addAnnotation(
                    AnnotationSpec.builder(SerialName::class).addMember("%S", pname).build()
                )
            pschemaRaw.generateKdoc()?.let { pBuilder.addKdoc(it) }
            classBuilder.addProperty(pBuilder.build())
        }

        nested.forEach { classBuilder.addType(it) }
        classBuilder.primaryConstructor(ctor.build())
        fileBuilder.addType(classBuilder.build())
        builtTypes.add(className)
    }

    fun mergeAllOfInto(schema: Schema): Pair<LinkedHashMap<String, Schema>, MutableList<String>> {
        val mergedProps = linkedMapOf<String, Schema>()
        val mergedRequired = mutableListOf<String>()

        (schema.allOf ?: emptyList()).forEach { item ->
            val resolved = if (!item.ref.isNullOrBlank()) {
                spec.components.schemas[item.ref.substringAfterLast("/")] ?: item
            } else item
            resolved.properties?.forEach { (k, v) -> mergedProps[k] = v }
            resolved.required?.forEach { r -> if (!mergedRequired.contains(r)) mergedRequired.add(r) }
        }

        schema.properties?.forEach { (k, v) -> mergedProps[k] = v }
        schema.required?.forEach { r -> if (!mergedRequired.contains(r)) mergedRequired.add(r) }

        return mergedProps to mergedRequired
    }

    fun resolveTypeForSchema(
        ctxSchema: Schema,
        parentClassForNested: String,
        nestedCollector: MutableList<TypeSpec>,
        propNameForNested: String,
        isRequired: Boolean,
        fileBuilder: FileSpec.Builder,
        builtTypes: MutableSet<String>,
    ): TypeName {

        // treat an "empty object" schema (i.e. {}) as JsonElement
        if ((ctxSchema.type == null || ctxSchema.type == "object")
            && (ctxSchema.properties == null || ctxSchema.properties.isEmpty())
            && (ctxSchema.allOf.isNullOrEmpty())
            && (ctxSchema.anyOf.isNullOrEmpty())
            && (ctxSchema.oneOf.isNullOrEmpty())
            && ctxSchema.ref.isNullOrBlank()
            && (ctxSchema.patternProperties.isNullOrEmpty())
            // Only treat as "empty object" when additionalProperties is absent (null) or explicitly false.
            && (ctxSchema.additionalProperties == null || ctxSchema.additionalProperties == false)
        ) {
            // Respect nullability: if the prop is not required or schema.nullable == true => nullable type
            return ClassName("kotlinx.serialization.json", "JsonElement")
                .copy(nullable = !isRequired || (ctxSchema.nullable == true))
        }

        if (!ctxSchema.patternProperties.isNullOrEmpty()) {
            val pp = ctxSchema.patternProperties
            if (pp.size == 1) {
                val entry = pp.entries.first()
                val valueSchema = entry.value
                val valueType = resolveTypeForSchema(
                    valueSchema,
                    parentClassForNested,
                    nestedCollector,
                    propNameForNested + "Value",
                    true,
                    fileBuilder,
                    builtTypes
                )
                val keyType = ClassName("kotlin", "String")
                val mapType =
                    ClassName("kotlin.collections", "Map").parameterizedBy(keyType, valueType)
                return mapType.copy(nullable = !isRequired || (ctxSchema.nullable == true))
            } else {
                val keyType = ClassName("kotlin", "String")
                val valueType = ClassName("kotlinx.serialization.json", "JsonElement")
                val mapType =
                    ClassName("kotlin.collections", "Map").parameterizedBy(keyType, valueType)
                return mapType.copy(nullable = !isRequired || (ctxSchema.nullable == true))
            }
        }

        if (ctxSchema.type == "object" && ctxSchema.additionalProperties != false && ctxSchema.additionalProperties != null) {
            val addPropSchema = ctxSchema.additionalProperties

            // resolve value type for map entries — naming nested with suffix "Value"
            val valueType = resolveTypeForSchema(
                addPropSchema as Schema,
                parentClassForNested,
                nestedCollector,
                propNameForNested + "Value",
                true,
                fileBuilder,
                builtTypes
            )

            val keyType = ClassName("kotlin", "String")
            val mapType = ClassName("kotlin.collections", "Map").parameterizedBy(keyType, valueType)
            return mapType.copy(nullable = !isRequired || (ctxSchema.nullable == true))
        }

        if (!ctxSchema.allOf.isNullOrEmpty()) {
            val refItem = ctxSchema.allOf.firstOrNull { !it.ref.isNullOrBlank() }
            if (refItem != null) {
                val ref = refItem.ref!!.substringAfterLast("/")
                val refClass = toPascalCase(ref)
                val refSchema = spec.components.schemas[ref]
                if (refSchema != null && !builtTypes.contains(refClass)) {
                    val refFileBuilder = FileSpec.builder(packageName, refClass)
                    buildSchemaRecursive(refFileBuilder, refClass, refSchema, builtTypes)
                    refFileBuilder.build().writeTo(output)
                }
                return ClassName(
                    fileBuilder.build().packageName,
                    refClass
                ).copy(nullable = !isRequired || (ctxSchema.nullable == true))
            }
        }

        if (!ctxSchema.ref.isNullOrBlank()) {
            val ref = ctxSchema.ref.substringAfterLast("/")
            val refClass = toPascalCase(ref)
            val refSchema = spec.components.schemas[ref]
            if (refSchema != null && !builtTypes.contains(refClass)) {
                val refFileBuilder = FileSpec.builder(packageName, refClass)
                buildSchemaRecursive(refFileBuilder, refClass, refSchema, builtTypes)
                refFileBuilder.build().writeTo(output)
            }
            return ClassName(
                fileBuilder.build().packageName,
                refClass
            ).copy(nullable = !isRequired || (ctxSchema.nullable == true))
        }

        val variantsInner = (ctxSchema.anyOf ?: emptyList()) + (ctxSchema.oneOf ?: emptyList())
        if (variantsInner.size == 2) {
            val refVariant = variantsInner.find { !it.ref.isNullOrBlank() }
            val nullVariant = variantsInner.find { v ->
                (v.enum?.size == 1 && v.enum[0] == null) || (v.nullable == true) || (v.type == "null")
            }
            if (refVariant != null && nullVariant != null) {
                val ref = refVariant.ref!!.substringAfterLast("/")
                val refClass = toPascalCase(ref)
                val refSchema = spec.components.schemas[ref]
                if (refSchema != null && !builtTypes.contains(refClass)) {
                    val refFileBuilder = FileSpec.builder(packageName, refClass)
                    buildSchemaRecursive(refFileBuilder, refClass, refSchema, builtTypes)
                    refFileBuilder.build().writeTo(output)
                }
                return ClassName(fileBuilder.build().packageName, refClass)
                    .copy(nullable = true)
            }
        }

        if (ctxSchema.type == "array" && ctxSchema.items != null) {
            val inner = resolveTypeForSchema(
                ctxSchema.items,
                parentClassForNested,
                nestedCollector,
                propNameForNested + "Item",
                true,
                fileBuilder,
                builtTypes
            )

            val listType = ClassName("kotlin.collections", "List").parameterizedBy(inner)
            return listType.copy(nullable = !isRequired || (ctxSchema.nullable == true))
        }

        if (ctxSchema.isPrimitiveType()) {
            val prim = ctxSchema.getPrimitiveTypeName() ?: STRING
            return prim.copy(nullable = !isRequired || (ctxSchema.nullable == true))
        }

        val nonNullLits = ctxSchema.enum?.filterNotNull() ?: emptyList()
        if (nonNullLits.isNotEmpty()) {
            val enumName = toPascalCase(propNameForNested)
            val enumBuilder = TypeSpec.enumBuilder(enumName).addAnnotation(Serializable::class)
            ctxSchema.generateKdoc()?.let { enumBuilder.addKdoc(it) }
            val used = mutableMapOf<String, Int>()
            nonNullLits.forEach { lit ->
                var constName = toConstantName(lit)
                val c = used.getOrDefault(constName, 0)
                if (c > 0) constName = "${constName}_$c"
                used[constName] = c + 1
                val ann = AnnotationSpec.builder(SerialName::class).addMember("%S", lit).build()
                enumBuilder.addEnumConstant(
                    constName,
                    TypeSpec.anonymousClassBuilder().addAnnotation(ann).build()
                )
            }
            nestedCollector.add(enumBuilder.build())
            return ClassName(fileBuilder.build().packageName, parentClassForNested, enumName).copy(
                nullable = !isRequired || (ctxSchema.nullable == true)
            )
        }

        // inline object
        val payloadName = "${toPascalCase(propNameForNested)}Payload"
        val payloadCtor = FunSpec.constructorBuilder()
        val payloadBuilder = TypeSpec.classBuilder(payloadName).addModifiers(KModifier.DATA)
            .addAnnotation(Serializable::class)
        ctxSchema.generateKdoc()?.let { payloadBuilder.addKdoc(it) }

        ctxSchema.properties?.forEach { (pn, ps) ->
            val iIsReq = ctxSchema.required?.contains(pn) == true
            val nestedType = resolveTypeForSchema(
                ps,
                parentClassForNested,
                nestedCollector,
                pn,
                iIsReq,
                fileBuilder,
                builtTypes
            )
            // use ParameterSpec so we can attach default if present
            val paramName = toCamelCase(pn)
            val paramBuilder = ParameterSpec.builder(paramName, nestedType)
            val dv = defaultValueLiteralForSchema(ps, nestedType)
            if (dv != null) {
                paramBuilder.defaultValue("%L", dv)
            } else if (nestedType.isNullable) {
                paramBuilder.defaultValue("%L", "null")
            }
            payloadCtor.addParameter(paramBuilder.build())

            val propBuilder = PropertySpec.builder(toCamelCase(pn), nestedType)
                .initializer(toCamelCase(pn))
                .addAnnotation(
                    AnnotationSpec.builder(SerialName::class).addMember("%S", pn).build()
                )
            ps.generateKdoc()?.let { propBuilder.addKdoc(it) }
            payloadBuilder.addProperty(propBuilder.build())
        }

        payloadBuilder.primaryConstructor(payloadCtor.build())
        nestedCollector.add(payloadBuilder.build())
        return ClassName(fileBuilder.build().packageName, parentClassForNested, payloadName).copy(
            nullable = !isRequired || (ctxSchema.nullable == true)
        )
    }

    fun localizeType(type: TypeName, nestedTypes: List<TypeSpec>): TypeName {
        if (type is ClassName) {
            val match = nestedTypes.firstOrNull { it.name == type.simpleName }
            if (match != null) {
                return ClassName("", type.simpleName)
            }
        }
        return type
    }

    private fun defaultValueLiteralForSchema(schema: Schema?, typeHint: TypeName? = null): String? {
        if (schema == null) return null
        val def = schema.default ?: return null

        val baseLit = jsonElementToKotlinLiteral(def) ?: return null

        if (baseLit == "null") return "null"

        // --- SIMPLE GUARD: if default is an object that matches a oneOf-variant keyed form
        // (e.g. {"V2": { ... }}) for a schema that has oneOf variants, ignore the default.
        // This avoids trying to synthesize deep nested typed constructors for such cases.
        if (def is JsonObject && typeHint is ClassName) {
            val refSchema = spec.components.schemas[typeHint.simpleName]
            if (refSchema != null && !refSchema.oneOf.isNullOrEmpty()) {
                // collect all variant property keys (e.g. "V0","V1","V2", or other variant names)
                val variantKeys = refSchema.oneOf
                    .flatMap { it.properties?.keys ?: emptySet() }
                    .toSet()
                // if the default object contains at least one key that matches a variant key,
                // treat this default as "nested typed" and IGNORE it (return null).
                if (def.keys.any { it in variantKeys }) {
                    return null
                }
            }
        }
        // --- end guard

        if (typeHint is ClassName) {
            // 1) kotlin primitive types
            if (typeHint.packageName == "kotlin") {
                return when (typeHint.simpleName) {
                    "Long" -> {
                        val intRegex = Regex("^-?\\d+\$")
                        if (intRegex.matches(baseLit)) "${baseLit}L" else baseLit
                    }
                    "Int", "Short", "Byte" -> baseLit
                    "Double", "Float" -> baseLit
                    "Boolean" -> baseLit
                    "String", "Char" -> baseLit
                    else -> baseLit
                }
            }

            val refSchema = spec.components.schemas[typeHint.simpleName]
            if (refSchema != null) {
                if (def is JsonObject && !refSchema.properties.isNullOrEmpty()) {
                    val assignments = mutableListOf<String>()
                    for ((propName, propSchema) in refSchema.properties) {
                        val jsonVal = def[propName] ?: continue
                        val lit = jsonElementToKotlinLiteral(jsonVal) ?: return null

                        val finalLit = if (propSchema.isPrimitiveType()) {
                            val prim = propSchema.getPrimitiveTypeName()
                            val intRegex = Regex("^-?\\d+\$")
                            when {
                                prim.toString().endsWith("Long") && intRegex.matches(lit) -> "${lit}L"
                                prim.toString().endsWith("Int") && intRegex.matches(lit) -> "${lit}.toInt()"
                                else -> lit
                            }
                        } else {
                            lit
                        }

                        assignments.add("${toCamelCase(propName)} = $finalLit")
                    }
                    if (assignments.isEmpty()) return null
                    return "${typeHint.simpleName}(" + assignments.joinToString(", ") + ")"
                }

                val rawString: String? = when (def) {
                    is JsonPrimitive -> if (def.isString) def.content else null
                    else -> null
                }
                val oneOfList = refSchema.oneOf ?: emptyList()
                if (rawString != null && oneOfList.isNotEmpty()) {
                    val match = oneOfList.firstOrNull { v -> v.enum?.any { it == rawString } == true }
                    if (match != null) {
                        val objName = toPascalCase(rawString)
                        return "${typeHint.simpleName}.$objName"
                    }
                }

                val topEnum = refSchema.enum?.filterNotNull()
                if (!topEnum.isNullOrEmpty() && rawString != null) {
                    val constName = toConstantName(rawString)
                    return "${typeHint.simpleName}.$constName"
                }

                val primType = try { refSchema.getPrimitiveTypeName() } catch (_: Throwable) { null }
                if (primType != null) {
                    val primStr = primType.toString()
                    val intRegex = Regex("^-?\\d+\$")
                    return when {
                        primStr.endsWith("Long") && intRegex.matches(baseLit) -> "${typeHint.simpleName}(${baseLit}L)"
                        primStr.endsWith("Int") && intRegex.matches(baseLit) -> "${typeHint.simpleName}(${baseLit}.toInt())"
                        primStr.endsWith("String") -> "${typeHint.simpleName}(${baseLit})"
                        primStr.endsWith("Boolean") -> "${typeHint.simpleName}(${baseLit})"
                        else -> "${typeHint.simpleName}(${baseLit})"
                    }
                }

                return "${typeHint.simpleName}(${baseLit})"
            }

            return null
        }

        return baseLit
    }

    private fun jsonElementToKotlinLiteral(el: JsonElement?): String? {
        if (el == null) return null

        return when (el) {
            is JsonNull -> "null"
            is JsonPrimitive -> {
                val content = el.content
                when {
                    el.booleanOrNull != null -> content // true/false
                    el.isString -> "\"" + content.replace("\"", "\\\"") + "\"" // quoted string
                    else -> content // numeric-like
                }
            }
            is JsonArray -> {
                val items = el.mapNotNull { jsonElementToKotlinLiteral(it) }
                if (items.size != el.size) return null
                "listOf(" + items.joinToString(", ") + ")"
            }
            is JsonObject -> {
                val pairs = mutableListOf<String>()
                for ((k, v) in el) {
                    val vLit = jsonElementToKotlinLiteral(v) ?: return null
                    val keyEsc = k.replace("\"", "\\\"")
                    pairs.add("\"$keyEsc\" to $vLit")
                }
                "mapOf(" + pairs.joinToString(", ") + ")"
            }
        }
    }

}
