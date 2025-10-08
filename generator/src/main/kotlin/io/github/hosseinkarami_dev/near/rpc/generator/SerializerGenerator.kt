import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import io.github.hosseinkarami_dev.near.rpc.generator.SealedInfo
import io.github.hosseinkarami_dev.near.rpc.generator.VariantInfo
import kotlinx.serialization.SerializationException

import java.io.File

object SerializerGenerator {
    @JvmStatic
    fun generateFromSealedInfos(
        sealedInfos: List<SealedInfo>,
        serializerPackage: String,
        output: File,
        discriminatorFields: List<String> = listOf("type", "name")
    ) {
        if (!output.exists()) output.mkdirs()
        if (sealedInfos.isEmpty()) return

        for (info in sealedInfos) {
            try {
                val fileSpec = generateSealedClassSerializer(info, serializerPackage, discriminatorFields)
                fileSpec.writeTo(output)
            } catch (ex: Exception) {
                System.err.println("Failed generating serializer for ${info.className}: ${ex.message}")
                throw RuntimeException("Generation failed for ${info.className}", ex)
            }
        }

        println("✅ Serializers Generated Successfully to $output")
    }

    fun generateSealedClassSerializer(
        info: SealedInfo,
        serializerPackage: String,
        discriminatorFields: List<String> = listOf("type", "name")
    ): FileSpec {
        val modelsPkg = info.packageName
        val clsName = info.className
        val serializerName = "${clsName}Serializer"

        val modelClass = ClassName(modelsPkg, clsName)
        val kSerializerOfModel =
            ClassName("kotlinx.serialization", "KSerializer").parameterizedBy(modelClass)
        val serialDescriptor = ClassName("kotlinx.serialization.descriptors", "SerialDescriptor")

        fun typeNameFor(typeStr: String?, ownerVariant: String? = null): TypeName {
            val raw = sanitizeType(typeStr)
            val kotlinPrimitives = mapOf(
                "String" to ClassName("kotlin", "String"),
                "Int" to ClassName("kotlin", "Int"),
                "Long" to ClassName("kotlin", "Long"),
                "Double" to ClassName("kotlin", "Double"),
                "Float" to ClassName("kotlin", "Float"),
                "Boolean" to ClassName("kotlin", "Boolean"),
                "Byte" to ClassName("kotlin", "Byte"),
                "Short" to ClassName("kotlin", "Short"),
                "Char" to ClassName("kotlin", "Char"),
                "Any" to ClassName("kotlin", "Any")
            )

            val listRegex = Regex("^(?:[\\w\\.]+\\.)?(?:List|MutableList|ArrayList)\\s*<\\s*(.+)\\s*>")
            val mapRegex = Regex("^(?:[\\w\\.]+\\.)?(?:Map|MutableMap)\\s*<\\s*([^,]+)\\s*,\\s*(.+)\\s*>")

            listRegex.matchEntire(raw)?.let { m ->
                val inner = typeNameFor(m.groups[1]!!.value, ownerVariant)
                return ClassName("kotlin.collections", "List").parameterizedBy(inner)
            }

            mapRegex.matchEntire(raw)?.let { m ->
                val k = typeNameFor(m.groups[1]!!.value, ownerVariant)
                val v = typeNameFor(m.groups[2]!!.value, ownerVariant)
                return ClassName("kotlin.collections", "Map").parameterizedBy(k, v)
            }

            kotlinPrimitives[raw]?.let { return it }

            if (raw.contains('.')) return ClassName.bestGuess(raw)

            if (!ownerVariant.isNullOrBlank()) {
                try {
                    return ClassName(modelsPkg, clsName, ownerVariant, raw)
                } catch (_: IllegalArgumentException) {
                }
            }

            return try {
                ClassName(modelsPkg, raw)
            } catch (_: IllegalArgumentException) {
                ClassName.bestGuess(raw)
            }
        }

        fun serializerExpressionFor(typeStr: String?, ownerVariant: String? = null): CodeBlock {
            val raw = sanitizeType(typeStr)
            val nullable = (typeStr ?: "").trim().endsWith("?")

            val listRegex = Regex("^(?:[\\w\\.]+\\.)?(?:List|MutableList|ArrayList)\\s*<\\s*(.+)\\s*>")
            val mapRegex = Regex("^(?:[\\w\\.]+\\.)?(?:Map|MutableMap)\\s*<\\s*([^,]+)\\s*,\\s*(.+)\\s*>")

            listRegex.matchEntire(raw)?.let { m ->
                val inner = m.groups[1]!!.value
                val innerSer = serializerExpressionFor(inner, ownerVariant)
                val innerType = typeNameFor(inner, ownerVariant)
                return if (nullable) CodeBlock.of("serializer<%T?>()", ClassName("kotlin.collections", "List").parameterizedBy(innerType))
                else CodeBlock.of("%T(%L)", ClassName("kotlinx.serialization.builtins", "ListSerializer"), innerSer)
            }

            mapRegex.matchEntire(raw)?.let { m ->
                val k = m.groups[1]!!.value
                val v = m.groups[2]!!.value
                val ks = serializerExpressionFor(k, ownerVariant)
                val vs = serializerExpressionFor(v, ownerVariant)
                val kType = typeNameFor(k, ownerVariant)
                val vType = typeNameFor(v, ownerVariant)
                return if (nullable) CodeBlock.of("serializer<%T?>()", ClassName("kotlin.collections", "Map").parameterizedBy(kType, vType))
                else CodeBlock.of("%T(%L, %L)", ClassName("kotlinx.serialization.builtins", "MapSerializer"), ks, vs)
            }

            val primitives = setOf("String","Int","Long","Double","Float","Boolean","Byte","Short","Char","Any")
            if (primitives.contains(raw)) return CodeBlock.of("serializer<%T${if (nullable) "?" else ""}>()", ClassName("kotlin", raw))

            if (raw.contains('.')) {
                val cn = ClassName.bestGuess(raw)
                return CodeBlock.of("serializer<%T${if (nullable) "?" else ""}>()", cn)
            }

            if (!ownerVariant.isNullOrBlank()) {
                try {
                    val nested = ClassName(modelsPkg, clsName, ownerVariant, raw)
                    return CodeBlock.of("serializer<%T${if (nullable) "?" else ""}>()", nested)
                } catch (_: IllegalArgumentException) { }
            }

            val cn = ClassName(modelsPkg, raw)
            return CodeBlock.of("serializer<%T${if (nullable) "?" else ""}>()", cn)
        }

        val dataVariants = info.variants.filter { it.kind == VariantInfo.Kind.DATA_CLASS }
        val keyToVariants = mutableMapOf<String, MutableList<Int>>()
        dataVariants.forEachIndexed { i, v -> v.props.forEach { p -> keyToVariants.computeIfAbsent(p.serialName) { mutableListOf() }.add(i) } }
        val dataVariantHasUniqueKey = dataVariants.mapIndexed { idx, v -> v.props.any { p -> keyToVariants[p.serialName]?.size == 1 } }
        // fieldBased == true when every data-variant has at least one property that is unique to it
        val fieldBased = dataVariants.isNotEmpty() && dataVariantHasUniqueKey.all { it } && dataVariants.isNotEmpty()

        // Map variantName -> unique key (the first unique property serialName, or null)
        val uniqueKeyByVariantName = mutableMapOf<String, String?>()
        dataVariants.forEach { v ->
            val unique = v.props.firstOrNull { p -> keyToVariants[p.serialName]?.size == 1 }?.serialName
            uniqueKeyByVariantName[v.name] = unique
        }

        val objBuilder = TypeSpec.objectBuilder(serializerName)
            .addSuperinterface(kSerializerOfModel)

        val descriptorProp = PropertySpec.builder("descriptor", serialDescriptor)
            .addModifiers(KModifier.OVERRIDE)
            .initializer("%M(%S)", MemberName("kotlinx.serialization.descriptors", "buildClassSerialDescriptor"), "$modelsPkg.$clsName")
            .build()
        objBuilder.addProperty(descriptorProp)

        fun buildSerializeCaseForDataVariant(v: VariantInfo): CodeBlock {
            val cb = CodeBlock.builder()
            val variantClass = ClassName(modelsPkg, clsName, v.name)
            cb.beginControlFlow("is %T ->", variantClass)

            // --- single-value (primitive) payload
            if (v.props.size == 1 && v.props[0].name == "value") {
                val p = v.props[0]
                val ser = serializerExpressionFor(p.type, v.name)
                cb.addStatement("val payloadJson = jsonEncoder.json.encodeToJsonElement(%L, value.%L)", ser, p.name)

                if (fieldBased) {
                    val uniq = uniqueKeyByVariantName[v.name] ?: "value"
                    if (uniq == p.serialName) {
                        cb.addStatement("jsonEncoder.encodeJsonElement(payloadJson)")
                    } else {
                        cb.addStatement(
                            "val payloadObj = %T(mapOf(%S to payloadJson))",
                            ClassName("kotlinx.serialization.json", "JsonObject"),
                            uniq
                        )
                        cb.addStatement("jsonEncoder.encodeJsonElement(payloadObj)")
                    }
                } else {
                    cb.addStatement("jsonEncoder.encodeJsonElement(payloadJson)")
                }

                cb.endControlFlow()
                return cb.build()
            }
            // --- multi-field payload
            // build mutable map and add entries conditionally for nullable fields
            cb.add("val map = %T<String, %T>()\n", ClassName("kotlin.collections", "mutableMapOf"), ClassName("kotlinx.serialization.json", "JsonElement"))
            v.props.forEach { p ->
                val ser = serializerExpressionFor(p.type, v.name)
                val nullable = p.type.trim().endsWith("?")
                if (nullable) {
                    cb.beginControlFlow("if (value.%L != null)", p.name)
                    cb.addStatement("map[%S] = jsonEncoder.json.encodeToJsonElement(%L, value.%L)", p.serialName, ser, p.name)
                    cb.endControlFlow()
                } else {
                    cb.addStatement("map[%S] = jsonEncoder.json.encodeToJsonElement(%L, value.%L)", p.serialName, ser, p.name)
                }
            }
            cb.addStatement("val payload = %T(map)", ClassName("kotlinx.serialization.json", "JsonObject"))
            cb.addStatement("jsonEncoder.encodeJsonElement(payload)")
            cb.endControlFlow()
            return cb.build()
        }

        // ---------- serialize ----------
        val serializeFun = FunSpec.builder("serialize")
            .addModifiers(KModifier.OVERRIDE)
            .addParameter("encoder", ClassName("kotlinx.serialization.encoding", "Encoder"))
            .addParameter("value", modelClass)
            .returns(Unit::class)

        val scb = CodeBlock.builder()
        scb.beginControlFlow("if (encoder is %T)", ClassName("kotlinx.serialization.json", "JsonEncoder"))
        scb.addStatement("val jsonEncoder = encoder")

        scb.beginControlFlow("when (value)")
        info.variants.filter { it.kind == VariantInfo.Kind.OBJECT }.forEach { v ->
            scb.beginControlFlow("%T.%L ->", modelClass, v.name)
            scb.addStatement("jsonEncoder.encodeJsonElement(%T(%S))", ClassName("kotlinx.serialization.json", "JsonPrimitive"), v.serialName)
            scb.endControlFlow()
        }
        info.variants.filter { it.kind == VariantInfo.Kind.DATA_CLASS }.forEach { v -> scb.add(buildSerializeCaseForDataVariant(v)) }
        scb.endControlFlow()
        scb.addStatement("return")
        scb.endControlFlow()

        scb.addStatement("val out = encoder.beginStructure(descriptor)")
        scb.beginControlFlow("when (value)")
        var idx = 0
        for (v in info.variants) {
            if (v.kind == VariantInfo.Kind.OBJECT) {
                scb.addStatement("%T.%L -> out.encodeStringElement(descriptor, %L, %S)", modelClass, v.name, idx, v.serialName)
            } else {
                val variantClass = ClassName(modelsPkg, clsName, v.name)
                val p = v.props.firstOrNull()
                if (p != null) {
                    val ser = serializerExpressionFor(p.type, v.name)
                    scb.addStatement("is %T -> out.encodeSerializableElement(descriptor, %L, %L, value.%L)", variantClass, idx, ser, p.name)
                } else {
                    val varSer = CodeBlock.of("serializer<%T>()", variantClass)
                    scb.addStatement("is %T -> out.encodeSerializableElement(descriptor, %L, %L, value)", variantClass, idx, varSer)
                }
            }
            idx++
        }
        scb.endControlFlow()
        scb.addStatement("out.endStructure(descriptor)")

        serializeFun.addCode(scb.build())
        objBuilder.addFunction(serializeFun.build())

        // ---------- deserialize ----------
        val deserializeFun = FunSpec.builder("deserialize")
            .addModifiers(KModifier.OVERRIDE)
            .addParameter("decoder", ClassName("kotlinx.serialization.encoding", "Decoder"))
            .returns(modelClass)

        val dcb = CodeBlock.builder()
        dcb.beginControlFlow("if (decoder is %T)", ClassName("kotlinx.serialization.json", "JsonDecoder"))
        dcb.addStatement("val element = decoder.decodeJsonElement()")

        dcb.beginControlFlow("when (element)")

        // JsonPrimitive branch: try single-value variants first
        dcb.beginControlFlow("is %T ->", ClassName("kotlinx.serialization.json", "JsonPrimitive"))
        val singleValueVariants = info.variants.filter { it.kind == VariantInfo.Kind.DATA_CLASS && it.props.size == 1 && it.props[0].name == "value" }
        if (singleValueVariants.isNotEmpty()) {
            for (v in singleValueVariants) {
                val variantClass = ClassName(modelsPkg, clsName, v.name)
                val ser = serializerExpressionFor(v.props[0].type, v.name)
                dcb.beginControlFlow("try")
                dcb.addStatement("val payload = decoder.json.decodeFromJsonElement(%L, element)", ser)
                dcb.addStatement("return %T(payload)", variantClass)
                dcb.nextControlFlow("catch (_: %T)", Exception::class)
                dcb.addStatement("// not this variant — try next")
                dcb.endControlFlow()
            }
        }

        dcb.beginControlFlow("if (element.isString)")
        dcb.addStatement("val s = element.content")
        info.variants.filter { it.kind == VariantInfo.Kind.OBJECT }.forEach { v ->
            dcb.addStatement("if (s == %S) return %T.%L", v.serialName, modelClass, v.name)
        }
        dcb.addStatement("throw %T(%S + s)", SerializationException::class, "Unknown discriminator string for $clsName: ")
        dcb.endControlFlow()
        dcb.endControlFlow() // end primitive

        // JsonArray branch
        dcb.beginControlFlow("is %T ->", ClassName("kotlinx.serialization.json", "JsonArray"))
        dcb.addStatement("throw %T(%S)", SerializationException::class, "Unexpected JSON array while deserializing $clsName")
        dcb.endControlFlow()

        // JsonObject branch
        dcb.beginControlFlow("is %T ->", ClassName("kotlinx.serialization.json", "JsonObject"))
        dcb.addStatement("val jobj = element")

        // ---------- new: field-based detection ----------
        if (fieldBased) {
            dcb.addStatement("// fieldBased union: detect variant by unique field presence")
            for (v in dataVariants) {
                val unique = uniqueKeyByVariantName[v.name]
                if (!unique.isNullOrBlank()) {
                    dcb.beginControlFlow("if (jobj[%S] != null)", unique)
                    // single-value variant that uses 'value' property
                    if (v.props.size == 1 && v.props[0].name == "value") {
                        val ser = serializerExpressionFor(v.props[0].type, v.name)
                        dcb.addStatement("return %T(decoder.json.decodeFromJsonElement(%L, jobj[%S]!!))", ClassName(modelsPkg, clsName, v.name), ser, unique)
                    } else {
                        val decodeNames = mutableListOf<String>()
                        v.props.forEach { p ->
                            val ser = serializerExpressionFor(p.type, v.name)
                            val varName = p.name + "Val"
                            val nullable = p.type.trim().endsWith("?")
                            if (nullable) {
                                dcb.addStatement("val %L = jobj[%S]?.let { decoder.json.decodeFromJsonElement(%L, it) }", varName, p.serialName, ser)
                            } else {
                                dcb.addStatement("val %L = decoder.json.decodeFromJsonElement(%L, jobj[%S] ?: throw %T(%S + %S))", varName, ser, p.serialName, SerializationException::class, "Missing field '${p.serialName}' for variant ", v.name)
                            }
                            decodeNames += varName
                        }
                        dcb.addStatement("return %T(${decodeNames.joinToString(", ")})", ClassName(modelsPkg, clsName, v.name))
                    }
                    dcb.endControlFlow()
                }
            }
        }

        // wrapper-style with single-key
        dcb.beginControlFlow("if (jobj.size == 1)")
        dcb.addStatement("val entry = jobj.entries.first()")
        dcb.addStatement("val key = entry.key")
        dcb.addStatement("val valueElem = entry.value")

        dcb.beginControlFlow("when (key)")
        for (v in info.variants.filter { it.kind == VariantInfo.Kind.DATA_CLASS }) {
            val variantClass = ClassName(modelsPkg, clsName, v.name)
            if (v.props.size == 1 && v.props[0].name == "value") {
                val ser = serializerExpressionFor(v.props[0].type, v.name)
                dcb.beginControlFlow("%S ->", v.serialName)
                // valueElem is the payload (primitive or object) — decode directly
                dcb.addStatement("return %T(decoder.json.decodeFromJsonElement(%L, valueElem))", variantClass, ser)
                dcb.endControlFlow()
            } else {
                dcb.beginControlFlow("%S ->", v.serialName)
                dcb.addStatement("val obj = valueElem as? %T ?: throw %T(%S + key)", ClassName("kotlinx.serialization.json", "JsonObject"), SerializationException::class, "Expected object payload for variant ")
                val decodeNames = mutableListOf<String>()
                v.props.forEach { p ->
                    val ser = serializerExpressionFor(p.type, v.name)
                    val varName = p.name + "Val"
                    val nullable = p.type.trim().endsWith("?")
                    if (nullable) {
                        dcb.addStatement("val %L = obj[%S]?.let { decoder.json.decodeFromJsonElement(%L, it) }", varName, p.serialName, ser)
                    } else {
                        dcb.addStatement("val %L = decoder.json.decodeFromJsonElement(%L, obj[%S] ?: throw %T(%S + key))", varName, ser, p.serialName, SerializationException::class, "Missing field '${p.serialName}' for variant ")
                    }
                    decodeNames += varName
                }
                dcb.addStatement("return %T(${decodeNames.joinToString(", ")})", variantClass)
                dcb.endControlFlow()
            }
        }
        for (v in info.variants.filter { it.kind == VariantInfo.Kind.OBJECT }) {
            dcb.beginControlFlow("%S ->", v.serialName)
            dcb.addStatement("return %T.%L", modelClass, v.name)
            dcb.endControlFlow()
        }

        dcb.addStatement("else -> throw %T(%S + key)", SerializationException::class, "Unknown discriminator key for $clsName: ")
        dcb.endControlFlow() // end when(key)
        dcb.endControlFlow() // end if (jobj.size == 1)

        // flat-style: try configured discriminators first, then heuristic fallback
        dcb.beginControlFlow("else")

        // inject discriminator candidates (from generator param)
        val discListLiteral = discriminatorFields.joinToString(", ") { "\"$it\"" }
        dcb.addStatement("val discriminatorCandidates = listOf($discListLiteral)")

        dcb.addStatement("var typeField: String? = null")
        // try configured candidates
        dcb.beginControlFlow("for (cand in discriminatorCandidates)")
        dcb.addStatement("typeField = jobj[cand]?.jsonPrimitive?.contentOrNull")
        dcb.addStatement("if (typeField != null) break")
        dcb.endControlFlow()

        // heuristic: if still null, look for any string value matching a known variant serialName
        val variantNamesList = info.variants.joinToString(", ") { "\"${it.serialName}\"" }
        dcb.addStatement("if (typeField == null) {")
        dcb.addStatement("  val knownVariantNames = setOf($variantNamesList)")
        dcb.addStatement("  for ((k, v) in jobj.entries) {")
        dcb.beginControlFlow("    if (v is %T && v.jsonPrimitive.isString)", ClassName("kotlinx.serialization.json", "JsonElement"))
        dcb.addStatement("      val s = (v as %T).jsonPrimitive.content", ClassName("kotlinx.serialization.json", "JsonElement"))
        dcb.addStatement("      if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }")
        dcb.endControlFlow()
        dcb.addStatement("  }")
        dcb.addStatement("}")

        // still null -> error
        dcb.addStatement("if (typeField == null) throw %T(%S)", SerializationException::class, "Missing discriminator (one of ${discriminatorFields.joinToString("/")}) or recognizable variant in $clsName")

        // normalize typeField for safe matching
        dcb.addStatement("val tf = typeField.trim()")

        // now dispatch based on tf; match against generated variant serialNames
        dcb.beginControlFlow("when (tf)")
        for (v in info.variants.filter { it.kind == VariantInfo.Kind.DATA_CLASS }) {
            dcb.beginControlFlow("%S ->", v.serialName)
            if (v.props.size == 1 && v.props[0].name == "value") {
                val ser = serializerExpressionFor(v.props[0].type, v.name)
                dcb.addStatement("val payloadElem = jobj[%S] ?: throw %T(%S + tf)", "value", SerializationException::class, "Missing field 'value' for variant ")
                dcb.addStatement("return %T(decoder.json.decodeFromJsonElement(%L, payloadElem))", ClassName(modelsPkg, clsName, v.name), ser)
            } else {
                val variantClassName = ClassName(modelsPkg, clsName, v.name)
                val variantSerializerCb = CodeBlock.of("serializer<%T>()", variantClassName)
                dcb.addStatement("return decoder.json.decodeFromJsonElement(%L, jobj)", variantSerializerCb)
            }
            dcb.endControlFlow()
        }
        for (v in info.variants.filter { it.kind == VariantInfo.Kind.OBJECT }) {
            dcb.addStatement("%S -> return %T.%L", v.serialName, modelClass, v.name)
        }
        dcb.addStatement("else -> throw %T(%S + tf)", SerializationException::class, "Unknown type discriminator for $clsName: ")
        dcb.endControlFlow() // end when(typeField)
        dcb.endControlFlow() // end else(flat)

        dcb.endControlFlow() // end is JsonObject
        dcb.endControlFlow() // end when(element)
        dcb.endControlFlow() // end if (decoder is JsonDecoder)

        dcb.addStatement("throw %T(%S)", SerializationException::class, "Cannot deserialize $clsName with non-JSON decoder")

        deserializeFun.addCode(dcb.build())
        objBuilder.addFunction(deserializeFun.build())

        val fileSpecBuilder = FileSpec.builder(serializerPackage, serializerName)
            .addType(objBuilder.build())
        fileSpecBuilder.addImport("kotlinx.serialization", "serializer")
        // add json helper imports unconditionally (safe)
        fileSpecBuilder.addImport("kotlinx.serialization.json", "jsonPrimitive")
        fileSpecBuilder.addImport("kotlinx.serialization.json", "contentOrNull")
        return fileSpecBuilder.build()
    }

    private fun sanitizeType(raw: String?): String {
        if (raw == null) return ""
        var s = raw.trim()
        val eqIndex = s.indexOf('=')
        if (eqIndex >= 0) s = s.substring(0, eqIndex).trimEnd()
        s = s.trimEnd { it == ',' || it == ')' || it == ']' }
        while (s.endsWith("?")) s = s.dropLast(1).trimEnd()
        if (s.startsWith("`") && s.endsWith("`") && s.length > 1) s = s.substring(1, s.length - 1)
        return s.trim()
    }
}