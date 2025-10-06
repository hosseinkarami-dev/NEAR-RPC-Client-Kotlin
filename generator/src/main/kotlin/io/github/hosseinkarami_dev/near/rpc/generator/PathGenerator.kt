package io.github.hosseinkarami_dev.near.rpc.generator

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.UNIT
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import java.io.File
import kotlin.collections.iterator

// PathGenerator: generates a NearClient class with typed suspend functions for each operation.
object PathGenerator {

    fun generateNearClientFile(
        spec: OpenApiSpec,
        output: File,
        clientPackage: String,
        modelsPackage: String,
        clientClassName: String = "NearClient"
    ) {
        val httpClientClass = ClassName("io.ktor.client", "HttpClient")
        val stringClass = ClassName("kotlin", "String")
        val jsonClass = ClassName("kotlinx.serialization.json", "Json")
        val uuidClass = ClassName("java.util", "UUID")

        val rpcResponseClass = ClassName(clientPackage, "RpcResponse")
        val rpcErrorClass = ClassName(clientPackage, "RpcError")
        val jsonRpcEnvelopeClass = ClassName(clientPackage, "JsonRpcEnvelope")

        val classBuilder = TypeSpec.classBuilder(clientClassName)
            .addModifiers(KModifier.PUBLIC)

        val ctor = FunSpec.constructorBuilder()
            .addParameter("httpClient", httpClientClass)
            .addParameter("baseUrl", stringClass)
            .addParameter(
                ParameterSpec.builder("json", jsonClass)
                    .defaultValue("%T { ignoreUnknownKeys = true }", jsonClass)
                    .build()
            )
            .build()
        classBuilder.primaryConstructor(ctor)

        classBuilder.addProperty(
            PropertySpec.builder("httpClient", httpClientClass)
                .addModifiers(KModifier.PRIVATE)
                .initializer("httpClient")
                .build()
        )
        classBuilder.addProperty(
            PropertySpec.builder("baseUrl", stringClass)
                .addModifiers(KModifier.PRIVATE)
                .initializer("baseUrl")
                .build()
        )
        classBuilder.addProperty(
            PropertySpec.builder("json", jsonClass)
                .addModifiers(KModifier.PRIVATE)
                .initializer("json")
                .build()
        )

        val nextIdFun = FunSpec.builder("nextId")
            .addModifiers(KModifier.PRIVATE)
            .returns(stringClass)
            .addCode("return %T.randomUUID().toString()\n", uuidClass)
            .build()
        classBuilder.addFunction(nextIdFun)

        for ((path, pathItem) in spec.paths) {
            val op = pathItem.post ?: pathItem.get ?: continue
            val rawOperationId = op.operationId
            val methodName = rawOperationId.camelCase()

            val reqWrapperStr = extractRequestType(op, modelsPackage)
            val respWrapperStr = extractResponseType(op, modelsPackage)
            val respWrapperRef = extractResponseWrapperRef(op)

            if (reqWrapperStr == null || respWrapperStr == null) {
                continue
            }

            val reqWrapperClassName = toClassNameOrBestGuess(reqWrapperStr)
            val respWrapperClassName = toClassNameOrBestGuess(respWrapperStr)

            val resultTypeStr = extractResultInnerTypeForOperation(op, spec, modelsPackage)
                ?: guessResultTypeFromResponseWrapperName(respWrapperStr, modelsPackage, spec)

            val resultTypeName = resultTypeStr?.let { toTypeName(it) } ?: ClassName("kotlinx.serialization.json", "JsonElement")

            val paramsTypeStr = resolveParamsTypeFromOperation(op, spec, modelsPackage)
            val isUnitOnly = paramsTypeStr == "Unit"
            val hasParams = paramsTypeStr != null && !isUnitOnly
            val paramsTypeName = if (hasParams) toTypeName(paramsTypeStr) else UNIT
            val paramsNullable = if (hasParams) paramsAreNullableFromOperation(op, spec) else true

            val funBuilder = FunSpec.builder(methodName)
                .addModifiers(KModifier.PUBLIC, KModifier.SUSPEND)
                .returns(rpcResponseClass.parameterizedBy(resultTypeName))

            if (hasParams) {
                if (paramsNullable) {
                    val nullableType = paramsTypeName.copy(nullable = true)
                    funBuilder.addParameter(
                        ParameterSpec.builder("params", nullableType)
                            .defaultValue("null")
                            .build()
                    )
                } else {
                    funBuilder.addParameter(
                        ParameterSpec.builder("params", paramsTypeName).build()
                    )
                }
            }

            val summary = op.summary?.trim().takeIf { !it.isNullOrBlank() }
            val description = op.description?.trim().takeIf { !it.isNullOrBlank() }
            val mainParts = mutableListOf<String>()
            if (summary != null) mainParts.add(summary)
            if (description != null) mainParts.add(description)
            if (mainParts.isEmpty()) mainParts.add("Execute the JSON-RPC operation `$rawOperationId`.")

            val seeLine = "path: $path (method: ${if (pathItem.post != null) "post" else "get"}) — operationId: $rawOperationId"
            val paramDesc = when {
                !hasParams -> "This method does not require params; `params` will be sent as `null` in the JSON-RPC request."
                paramsNullable -> "Request parameters (optional): `${paramsTypeStr}` — pass `null` or omit to send no params."
                else -> "Request parameters: `${paramsTypeStr}` (required)."
            }
            funBuilder.addKdoc(
                "%L\n\n@see %L\n\n@param params %L\n@return Response: `%T`.\n",
                mainParts.joinToString("\n\n"),
                seeLine,
                paramDesc,
                rpcResponseClass.parameterizedBy(resultTypeName)
            )

            val containsDeprecatedTag = (summary?.contains("[Deprecated]") == true) || (description?.contains("[Deprecated]") == true)
            val isDeprecated = containsDeprecatedTag

            if (isDeprecated) {
                val depMessage = buildString {
                    if (summary != null) append(summary)
                    else append(description)
                    append(" — deprecated.")
                }

                val replacerRegex = Regex("Consider using ([a-zA-Z0-9_]+) instead", RegexOption.IGNORE_CASE)
                val replacerSource = (description ?: summary ?: "")
                val replaceExpr = replacerRegex.find(replacerSource)?.groups?.get(1)?.value?.let { raw ->
                    val replacementMethod = raw.camelCase()
                    "${replacementMethod}(params)"
                }

                val depBuilder = AnnotationSpec.builder(Deprecated::class)
                    .addMember("message = %S", depMessage)
                    .apply {
                        if (replaceExpr != null) {
                            addMember("replaceWith = %L", CodeBlock.of("ReplaceWith(%S)", replaceExpr))
                        }
                    }
                    .addMember("level = %T.%L", ClassName("kotlin", "DeprecationLevel"), "WARNING")
                    .build()

                funBuilder.addAnnotation(depBuilder)
            }

            val methodEnumClass = ClassName(reqWrapperClassName.packageName, reqWrapperClassName.simpleName, "Method")
            val constantName = rawOperationId.constantName()

            val cb = CodeBlock.builder()
            cb.addStatement("val request = %T(", reqWrapperClassName)
            cb.addStatement("  id = nextId(),")
            cb.addStatement("  jsonrpc = %S,", "2.0")
            cb.addStatement("  method = %T.%L,", methodEnumClass, constantName)
            if (hasParams) {
                cb.addStatement("  params = params")
            } else {
                cb.addStatement("  params = null")
            }
            cb.addStatement(")")

            cb.addStatement("val httpResponse = httpClient.post(baseUrl) {")
            cb.addStatement("    contentType(%T.Application.Json)", ClassName("io.ktor.http", "ContentType"))
            cb.addStatement("    setBody(json.encodeToString(%T.serializer(), request))", reqWrapperClassName)
            cb.addStatement("  }")

            cb.addStatement("val respBody = httpResponse.bodyAsText()")

            // ------------------ robust decode: prefer using response-wrapper schema ref when present
            if (respWrapperRef != null) {
                val localErrorClass = ClassName(modelsPackage, "LocalError")

                cb.addStatement("try {")
                // Use the exact response-wrapper schema referenced by the operation (modelsPackage + wrapper name)
                cb.addStatement("val decoded = json.decodeFromString(%T.serializer(), respBody)", respWrapperClassName)
                // Map sealed variants to RpcResponse
                cb.addStatement("return when (decoded) {")
                cb.addStatement("  is %T.Result -> %T.Success(decoded.result)", respWrapperClassName, rpcResponseClass)
                cb.addStatement("  is %T.Error -> %T.Failure(decoded.error)", respWrapperClassName, rpcResponseClass)
                cb.addStatement("}")
                cb.addStatement("} catch(e: Exception) {")
                cb.addStatement("return RpcResponse.Failure(localToRpcError(e, -1001L))")
                cb.addStatement("}")
            }

            funBuilder.addCode(cb.build())
            classBuilder.addFunction(funBuilder.build())
        }

        val fileSpec = FileSpec.builder(clientPackage, clientClassName)
            .addImport("io.ktor.client.request", "post", "setBody")
            .addImport("io.ktor.client.statement", "bodyAsText")
            .addImport("io.ktor.http", "ContentType", "contentType")
            .addImport("kotlinx.serialization.json", "Json")
            .addImport("kotlinx.serialization.builtins", "serializer")
            .addImport("kotlinx.serialization.builtins", "ListSerializer")
            .addImport("io.ktor.client.statement", "bodyAsText")
            .addType(classBuilder.build())
            .build()

        fileSpec.writeTo(output)
        println("✅ Routes Generated Successfully to $output")
    }

    // ------------------- helper utilities -------------------

    private fun toTypeName(typeString: String): TypeName {
        if (typeString.endsWith("?")) {
            val inner = typeString.removeSuffix("?")
            return toTypeName(inner).copy(nullable = true)
        }

        if (typeString.startsWith("List<") && typeString.endsWith(">")) {
            val inner = typeString.removePrefix("List<").removeSuffix(">")
            val innerType = toTypeName(inner)
            return ClassName("kotlin.collections", "List").parameterizedBy(innerType)
        }

        return when {
            typeString == "Unit" -> UNIT
            typeString == "String" -> ClassName("kotlin", "String")
            typeString == "Int" -> ClassName("kotlin", "Int")
            typeString == "Double" -> ClassName("kotlin", "Double")
            typeString == "Boolean" -> ClassName("kotlin", "Boolean")
            typeString == "JsonElement" -> ClassName("kotlinx.serialization.json", "JsonElement")
            else -> {
                val lastDot = typeString.lastIndexOf('.')
                if (lastDot > 0) {
                    val pkg = typeString.substring(0, lastDot)
                    val simple = typeString.substring(lastDot + 1)
                    ClassName(pkg, simple)
                } else {
                    ClassName.bestGuess(typeString)
                }
            }
        }
    }

    private fun toClassNameOrBestGuess(typeString: String): ClassName {
        val lastDot = typeString.lastIndexOf('.')
        return if (lastDot > 0) {
            val pkg = typeString.substring(0, lastDot)
            val simple = typeString.substring(lastDot + 1)
            ClassName(pkg, simple)
        } else {
            ClassName.bestGuess(typeString)
        }
    }

    private fun extractRequestType(op: Operation, modelsPackage: String): String? {
        val rb = op.requestBody ?: return null
        val media = rb.content["application/json"] ?: rb.content.values.firstOrNull()
        val schema = media?.schema ?: return null
        return schemaTypeName(schema, modelsPackage)
    }

    private fun extractResponseType(op: Operation, modelsPackage: String): String? {
        val candidate = op.responses["200"] ?: op.responses["201"] ?: op.responses["default"]
        ?: op.responses.values.firstOrNull()
        val media = candidate?.content?.get("application/json") ?: candidate?.content?.values?.firstOrNull()
        val schema = media?.schema
        return schemaTypeName(schema, modelsPackage)
    }

    private fun extractResponseWrapperRef(op: Operation): String? {
        val candidate = op.responses["200"] ?: op.responses["201"] ?: op.responses["default"]
        ?: op.responses.values.firstOrNull()
        val media = candidate?.content?.get("application/json") ?: candidate?.content?.values?.firstOrNull()
        val schema = media?.schema ?: return null
        return schema.jsonObject["\$ref"]?.jsonPrimitive?.contentOrNull
    }

    private fun schemaTypeName(schema: JsonElement?, modelsPackage: String): String? {
        if (schema == null) return null
        val obj = schema.jsonObject
        val ref = obj["\$ref"]?.jsonPrimitive?.contentOrNull
        if (ref != null) {
            val name = ref.substringAfterLast('/')
            return "$modelsPackage.${name.pascalCase()}"
        }
        val title = obj["title"]?.jsonPrimitive?.contentOrNull
        if (title != null) {
            return "$modelsPackage.${title.pascalCase()}"
        }
        val type = obj["type"]?.jsonPrimitive?.contentOrNull
        when (type) {
            "string" -> return "String"
            "integer" -> return "Int"
            "number" -> return "Double"
            "boolean" -> return "Boolean"
            "array" -> {
                val items = obj["items"]
                if (items != null && items.jsonObject["\$ref"] != null) {
                    val itemRef = items.jsonObject["\$ref"]!!.jsonPrimitive.content
                    val itemName = itemRef.substringAfterLast('/')
                    return "List<$modelsPackage.${itemName.pascalCase()}>"
                }
                return "List<JsonElement>"
            }
        }
        return null
    }

    private fun resolveParamsTypeFromOperation(
        op: Operation,
        spec: OpenApiSpec,
        modelsPackage: String
    ): String? {
        val rb = op.requestBody ?: return null
        val media = rb.content["application/json"] ?: rb.content.values.firstOrNull() ?: return null
        val schemaEl = media.schema ?: return null

        val wrapperRef = schemaEl.jsonObject["\$ref"]?.jsonPrimitive?.contentOrNull ?: return null
        val wrapperName = wrapperRef.substringAfterLast('/')
        val wrapperSchema = spec.components.schemas[wrapperName] ?: return null

        val paramsSchema = wrapperSchema.properties?.get("params") ?: return null

        paramsSchema.ref?.let { pRef ->
            val pName = pRef.substringAfterLast('/')
            val pSchema = spec.components.schemas[pName]
            if (pSchema != null) {
                if ((pSchema.enum != null && pSchema.enum.size == 1 && pSchema.enum[0] == null) || pSchema.nullable == true) {
                    return "Unit"
                }
                return "$modelsPackage.${pName.pascalCase()}"
            }
            return "$modelsPackage.${pName.pascalCase()}"
        }

        if (paramsSchema.type == "array") {
            val item = paramsSchema.items
            if (item?.ref != null) {
                val itemName = item.ref.substringAfterLast('/')
                return "List<$modelsPackage.${itemName.pascalCase()}>"
            }
            return "List<JsonElement>"
        }

        when (paramsSchema.type) {
            "string" -> return "String"
            "integer" -> return "Int"
            "number" -> return "Double"
            "boolean" -> return "Boolean"
            "object" -> return "JsonElement"
        }

        if (paramsSchema.enum != null && paramsSchema.enum.size == 1 && paramsSchema.enum[0] == null) {
            return "Unit"
        }

        return null
    }

    private fun paramsAreNullableFromOperation(op: Operation, spec: OpenApiSpec): Boolean {
        val rb = op.requestBody ?: return true
        val media = rb.content["application/json"] ?: rb.content.values.firstOrNull() ?: return true
        val schemaEl = media.schema ?: return true

        val wrapperRef = schemaEl.jsonObject["\$ref"]?.jsonPrimitive?.contentOrNull ?: return true
        val wrapperName = wrapperRef.substringAfterLast('/')
        val wrapperSchema = spec.components.schemas[wrapperName] ?: return true

        val paramsSchema = wrapperSchema.properties?.get("params") ?: return true

        paramsSchema.ref?.let { pRef ->
            val pName = pRef.substringAfterLast('/')
            val pSchema = spec.components.schemas[pName] ?: return false
            if (pSchema.nullable == true) return true
            if (pSchema.enum != null && pSchema.enum.size == 1 && pSchema.enum[0] == null) return true
            return false
        }

        if (paramsSchema.nullable == true) return true
        if (paramsSchema.enum != null && paramsSchema.enum.size == 1 && paramsSchema.enum[0] == null) return true

        return false
    }

    private fun extractResultInnerTypeForOperation(
        op: Operation,
        spec: OpenApiSpec,
        modelsPackage: String
    ): String? {
        val candidate = op.responses["200"] ?: op.responses["201"] ?: op.responses["default"]
        ?: op.responses.values.firstOrNull()
        val media = candidate?.content?.get("application/json") ?: candidate?.content?.values?.firstOrNull()
        val schema = media?.schema ?: return null

        val wrapperRef = schema.jsonObject["\$ref"]?.jsonPrimitive?.contentOrNull ?: return null
        val wrapperName = wrapperRef.substringAfterLast('/')
        val wrapperSchema = spec.components.schemas[wrapperName] ?: return guessResultTypeFromResponseWrapperName(wrapperRef, modelsPackage, spec)

        fun inspectForResult(schemaObj: Schema?): String? {
            if (schemaObj == null) return null
            val resultProp = schemaObj.properties?.get("result") ?: return null

            resultProp.ref?.let { ref ->
                val innerName = ref.substringAfterLast('/')
                return "$modelsPackage.${innerName.pascalCase()}"
            }

            if (resultProp.anyOf != null) {
                val variants = resultProp.anyOf
                val refVariant = variants.find { !it.ref.isNullOrBlank() || (it.type == "array" && it.items?.ref != null) }
                val nullVariant = variants.find { v ->
                    (v.enum?.size == 1 && v.enum[0] == null) || (v.nullable == true) || (v.type == "null")
                }
                if (refVariant != null && nullVariant != null) {
                    if (!refVariant.ref.isNullOrBlank()) {
                        val ref = refVariant.ref.substringAfterLast("/")
                        val refClass = ref.pascalCase()
                        return "$modelsPackage.${refClass}?"
                    }

                    if (refVariant.type == "array" && refVariant.items?.ref != null) {
                        val itemRef = refVariant.items.ref.substringAfterLast("/")
                        val itemClass = itemRef.pascalCase()
                        return "List<$modelsPackage.${itemClass}>?"
                    }
                }
            }

            if (resultProp.type == "array") {
                val items = resultProp.items
                if (items?.ref != null) {
                    val itemName = items.ref.substringAfterLast('/')
                    return "List<$modelsPackage.${itemName.pascalCase()}>"
                }
                return "List<JsonElement>"
            }

            return when (resultProp.type) {
                "string" -> "String"
                "integer" -> "Int"
                "number" -> "Double"
                "boolean" -> "Boolean"
                "object" -> "JsonElement"
                else -> null
            }
        }

        inspectForResult(wrapperSchema)?.let { return it }

        wrapperSchema.oneOf?.forEach { altNameOrRef ->
            val altSchema = if (altNameOrRef.ref != null) {
                val alt = altNameOrRef.ref.substringAfterLast('/')
                spec.components.schemas[alt]
            } else {
                altNameOrRef
            }
            inspectForResult(altSchema)?.let { return it }
        }

        return guessResultTypeFromResponseWrapperName(wrapperRef, modelsPackage, spec)
    }

    private fun guessResultTypeFromResponseWrapperName(
        respWrapper: String,
        modelsPackage: String,
        spec: OpenApiSpec
    ): String? {
        val wrapperName = when {
            respWrapper.contains("#/components/schemas/") -> respWrapper.substringAfterLast('/')
            respWrapper.contains('.') -> respWrapper.substringAfterLast('.')
            else -> respWrapper
        }

        val wrapperSchema = spec.components.schemas[wrapperName]

        fun extractFromSchema(schema: Schema?): String? {
            if (schema == null) return null

            val resultProp = schema.properties?.get("result")
            resultProp?.ref?.let { ref ->
                val inner = ref.substringAfterLast('/')
                return "$modelsPackage.${inner.pascalCase()}"
            }

            if (resultProp?.type == "array" && resultProp.items?.ref != null) {
                val item = resultProp.items.ref.substringAfterLast('/')
                return "List<$modelsPackage.${item.pascalCase()}>"
            }

            resultProp?.type?.let { t ->
                return when (t) {
                    "string" -> "String"
                    "integer" -> "Int"
                    "number" -> "Double"
                    "boolean" -> "Boolean"
                    "object" -> "kotlinx.serialization.json.JsonElement"
                    else -> null
                }
            }

            val variants = mutableListOf<Schema?>()
            schema.oneOf?.let { variants.addAll(it) }
            schema.anyOf?.let { variants.addAll(it) }
            schema.allOf?.let { variants.addAll(it) }

            for (variant in variants) {
                variant?.ref?.let { vref ->
                    val vname = vref.substringAfterLast('/')
                    val vschema = spec.components.schemas[vname]
                    extractFromSchema(vschema)?.let { return it }
                } ?: run {
                    extractFromSchema(variant)?.let { return it }
                }
            }

            return null
        }

        extractFromSchema(wrapperSchema)?.let { return it }

        val name = wrapperName
        val prefix = "JsonRpcResponse_for_"
        val suffix = "_and_RpcError"
        if (name.startsWith(prefix) && name.endsWith(suffix)) {
            val inner = name.removePrefix(prefix).removeSuffix(suffix)
            return "$modelsPackage.${inner.pascalCase()}"
        }

        val altMatch = Regex("JsonRpcResponseFor(.+)AndRpcError").find(name)
        if (altMatch != null) {
            val innerRaw = altMatch.groupValues[1]
            return "$modelsPackage.${innerRaw.pascalCase()}"
        }

        return null
    }
}
