package io.github.hosseinkarami_dev.near.rpc.generator

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

// --- Assumes OpenApiSpec, Operation, PathItem, Schema classes exist in your generator infra
// --- Adjust imports / types for your spec parser accordingly.

object PathGenerator {

    /**
     * Generate a NearClient class file implementing typed suspend functions for each operation.
     *
     * @param spec parsed OpenApi spec
     * @param outputDir directory to write generated file(s)
     * @param clientPackage package for the generated client (where RpcResponse/RpcError also reside)
     * @param modelsPackage package where the generated models live (JsonRpcRequestForX, JsonRpcEnvelope, responses)
     * @param clientClassName generated class name (default "NearClient")
     */
    fun generateNearClientFile(
        spec: OpenApiSpec,
        outputDir: File,
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

        // primary constructor(httpClient: HttpClient, baseUrl: String, json: Json = Json { ignoreUnknownKeys = true })
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

        // properties
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

        // nextId helper (returns String UUID)
        val nextIdFun = FunSpec.builder("nextId")
            .addModifiers(KModifier.PRIVATE)
            .returns(stringClass)
            .addCode("return %T.randomUUID().toString()\n", uuidClass)
            .build()
        classBuilder.addFunction(nextIdFun)

        // Iterate operations (prefer POST then GET)
        for ((path, pathItem) in spec.paths) {
            val op = pathItem.post ?: pathItem.get ?: continue
            val rawOperationId = op.operationId
            val methodName = rawOperationId.camelCase()

            // determine wrapper request/response types from spec
            val reqWrapperStr = extractRequestType(op, modelsPackage) // e.g. org.near.rpc_models.JsonRpcRequestForStatus
            val respWrapperStr = extractResponseType(op, modelsPackage) // e.g. org.near.rpc_models.JsonRpcResponse_for_RpcStatusResponse...

            if (reqWrapperStr == null || respWrapperStr == null) {
                // skip when we can't determine both request wrapper and response wrapper
                continue
            }

            val reqWrapperClassName = toClassNameOrBestGuess(reqWrapperStr)

            val resultTypeStr = extractResultInnerTypeForOperation(op, spec, modelsPackage)
                ?: guessResultTypeFromResponseWrapperName(respWrapperStr, modelsPackage)

            val resultTypeName = resultTypeStr?.let { toTypeName(it) } ?: ClassName("kotlinx.serialization.json", "JsonElement")

            // Determine params type (params inside the wrapper) so function signature can have typed param
            val paramsTypeStr = resolveParamsTypeFromOperation(op, spec, modelsPackage)
            val isUnitOnly = paramsTypeStr == "Unit"
            val hasParams = paramsTypeStr != null && !isUnitOnly
            val paramsTypeName = if (hasParams) toTypeName(paramsTypeStr) else UNIT
            val paramsNullable = if (hasParams) paramsAreNullableFromOperation(op, spec) else true

            // Build function
            val funBuilder = FunSpec.builder(methodName)
                .addModifiers(KModifier.PUBLIC, KModifier.SUSPEND)
                .returns(rpcResponseClass.parameterizedBy(resultTypeName))

            // Add params param if needed
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

            // KDoc
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

            // Build CodeBlock: create request wrapper, post, read body, decode envelope(result serializer), handle errors
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

            // HTTP POST with encoded request body
            cb.addStatement("val httpResponse = try {")
            cb.addStatement("  httpClient.post(baseUrl) {")
            cb.addStatement("    contentType(%T.Application.Json)", ClassName("io.ktor.http", "ContentType"))
            cb.addStatement("    setBody(json.encodeToString(%T.serializer(), request))", reqWrapperClassName)
            cb.addStatement("  }")
            cb.addStatement("} catch (e: Exception) {")
            cb.addStatement("  return %T.Failure(%T(-1000, \"Network error: \${e.message}\"))", rpcResponseClass, rpcErrorClass)
            cb.addStatement("}")

            // Read body text
            cb.addStatement("val respBody = try {")
            cb.addStatement("  httpResponse.bodyAsText()")
            cb.addStatement("} catch (e: Exception) {")
            cb.addStatement("  return %T.Failure(%T(-1001, \"Could not read body: \${e.message}\"))", rpcResponseClass, rpcErrorClass)
            cb.addStatement("}")

            // ------------------ robust envelope decode ------------------
            if (resultTypeStr != null && resultTypeStr.startsWith("List<")) {
                // List case: might be "List<...>" or "List<...>?"
                val innerRaw = resultTypeStr.removePrefix("List<").removeSuffix(">").removeSuffix("?")
                val innerClass = toClassNameOrBestGuess(innerRaw)
                val listSerializer = ClassName("kotlinx.serialization.builtins", "ListSerializer")

                cb.addStatement("val envelope = try {")
                cb.addStatement("  json.decodeFromString(%T.serializer(%T(%T.serializer())), respBody)", jsonRpcEnvelopeClass, listSerializer, innerClass)
                cb.addStatement("} catch (e: Exception) {")
                cb.addStatement("  return %T.Failure(%T(-1002, \"Invalid JSON-RPC envelope: \${e.message}\"))", rpcResponseClass, rpcErrorClass)
                cb.addStatement("}")
            } else {
                // Non-list case: ensure we call .serializer() on the non-nullable class name
                val serializerClassName = if (resultTypeStr != null) {
                    // strip trailing ? if present
                    val clean = if (resultTypeStr.endsWith("?")) resultTypeStr.removeSuffix("?") else resultTypeStr
                    toClassNameOrBestGuess(clean)
                } else {
                    ClassName("kotlinx.serialization.json", "JsonElement")
                }

                cb.addStatement("val envelope = try {")
                cb.addStatement("  json.decodeFromString(%T.serializer(%T.serializer()), respBody)", jsonRpcEnvelopeClass, serializerClassName)
                cb.addStatement("} catch (e: Exception) {")
                cb.addStatement("  return %T.Failure(%T(-1002, \"Invalid JSON-RPC envelope: \${e.message}\"))", rpcResponseClass, rpcErrorClass)
                cb.addStatement("}")
            }

            // Handle error/result
            cb.addStatement("envelope.error?.let { return %T.Failure(it) }", rpcResponseClass)
            cb.addStatement("val result = envelope.result ?: return %T.Failure(%T(-1003, \"Missing result field\"))", rpcResponseClass, rpcErrorClass)
            cb.addStatement("return %T.Success(result)", rpcResponseClass)

            funBuilder.addCode(cb.build())

            classBuilder.addFunction(funBuilder.build())
        }

        // Build file with imports
        val fileSpec = FileSpec.builder(clientPackage, clientClassName)
            // .addComment("Auto-generated by PathGenerator. Do not edit by hand.")
            .addImport("io.ktor.client.request", "post", "setBody")
            .addImport("io.ktor.client.statement", "bodyAsText")
            .addImport("io.ktor.http", "ContentType", "contentType")
            .addImport("kotlinx.serialization.json", "Json")
            .addImport("kotlinx.serialization.builtins", "serializer")
            .addImport("kotlinx.serialization.builtins", "ListSerializer")
            .addImport("io.ktor.client.statement", "bodyAsText")
            .addType(classBuilder.build())
            .build()

        fileSpec.writeTo(outputDir)
        println("✅ Routes Generated Successfully to $outputDir")
    }

    // ------------------- helper utilities (same as earlier) -------------------

    private fun toTypeName(typeString: String): TypeName {
        // handle trailing nullable "?"
        if (typeString.endsWith("?")) {
            val inner = typeString.removeSuffix("?")
            return toTypeName(inner).copy(nullable = true)
        }

        // List<T> case
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

    private fun schemaTypeName(schema: JsonElement?, modelsPackage: String): String? {
        if (schema == null) return null
        val obj = schema.jsonObject
        val ref = obj["\$ref"]?.jsonPrimitive?.contentOrNull
        if (ref != null) {
            val name = ref.substringAfterLast('/')
            return "$modelsPackage.${toPascalCase(name)}"
        }
        val title = obj["title"]?.jsonPrimitive?.contentOrNull
        if (title != null) {
            return "$modelsPackage.${toPascalCase(title)}"
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
            return "$modelsPackage.${toPascalCase(pName)}"
        }

        if (paramsSchema.type == "array") {
            val item = paramsSchema.items
            if (item?.ref != null) {
                val itemName = item.ref.substringAfterLast('/')
                return "List<$modelsPackage.${toPascalCase(itemName)}>"
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

        if (paramsSchema.nullable == true) return true
        if (paramsSchema.enum != null && paramsSchema.enum.size == 1 && paramsSchema.enum[0] == null) return true

        paramsSchema.ref?.let { pRef ->
            val pName = pRef.substringAfterLast('/')
            val pSchema = spec.components.schemas[pName] ?: return false
            if (pSchema.nullable == true) return true
            if (pSchema.enum != null && pSchema.enum.size == 1 && pSchema.enum[0] == null) return true
            return false
        }

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
        val wrapperSchema = spec.components.schemas[wrapperName] ?: return guessResultTypeFromResponseWrapperName(wrapperRef, modelsPackage)

        // helper lambda to inspect a subschema for properties.result
        fun inspectForResult(schemaObj: Schema?): String? {
            if (schemaObj == null) return null
            val resultProp = schemaObj.properties?.get("result") ?: return null

            // case: result is a $ref to some schema
            resultProp.ref?.let { ref ->
                val innerName = ref.substringAfterLast('/')
                return "$modelsPackage.${toPascalCase(innerName)}"
            }

            if (resultProp.anyOf != null) {
                val variants = resultProp.anyOf
                val refVariant = variants.find { !it.ref.isNullOrBlank() || (it.type == "array" && it.items?.ref != null) }
                val nullVariant = variants.find { v ->
                    (v.enum?.size == 1 && v.enum[0] == null) || (v.nullable == true) || (v.type == "null")
                }
                if (refVariant != null && nullVariant != null) {
                    // case: refVariant is a direct $ref to a schema
                    if (!refVariant.ref.isNullOrBlank()) {
                        val ref = refVariant.ref.substringAfterLast("/")
                        val refClass = ref.pascalCase()
                        return "$modelsPackage.${refClass}?"
                    }

                    // case: refVariant is an array of $ref (items.ref)
                    if (refVariant.type == "array" && refVariant.items?.ref != null) {
                        val itemRef = refVariant.items.ref.substringAfterLast("/")
                        val itemClass = itemRef.pascalCase()
                        return "List<$modelsPackage.${itemClass}>?"
                    }
                }
            }


            // case: result is array of items.$ref
            if (resultProp.type == "array") {
                val items = resultProp.items
                if (items?.ref != null) {
                    val itemName = items.ref.substringAfterLast('/')
                    return "List<$modelsPackage.${toPascalCase(itemName)}>"
                }
                return "List<JsonElement>"
            }

            // primitives/object fallback
            return when (resultProp.type) {
                "string" -> "String"
                "integer" -> "Int"
                "number" -> "Double"
                "boolean" -> "Boolean"
                "object" -> "JsonElement"
                else -> null
            }
        }

        // 1) check top-level wrapper schema itself
        inspectForResult(wrapperSchema)?.let { return it }

        // 2) if wrapper uses oneOf/anyOf/allOf, inspect each alternative
        wrapperSchema.oneOf?.forEach { altNameOrRef ->
            // altNameOrRef might be a $ref or an inline schema object in your parsed model
            val altSchema = if (altNameOrRef.ref != null) {
                val alt = altNameOrRef.ref.substringAfterLast('/')
                spec.components.schemas[alt]
            } else {
                altNameOrRef
            }
            inspectForResult(altSchema)?.let { return it }
        }

        // fallback to regex-based guess
        return guessResultTypeFromResponseWrapperName(wrapperRef, modelsPackage)
    }


    // utilities: camelCase, pascalCase, constantName helpers
    private fun String.camelCase(): String {
        val parts = this.split(Regex("[^A-Za-z0-9]+")).filter { it.isNotEmpty() }
        if (parts.isEmpty()) return this
        return parts.first().lowercase() + parts.drop(1).joinToString("") { it.replaceFirstChar { c -> c.uppercase() } }
    }

    private fun String.pascalCase(): String {
        return this.split(Regex("[^A-Za-z0-9]+")).joinToString("") { it.replaceFirstChar { c -> c.uppercase() } }
    }

    private fun String.constantName(): String {
        return this.replace(Regex("[^A-Za-z0-9]+"), "_").uppercase()
    }

    private fun guessResultTypeFromResponseWrapperName(respWrapper: String, modelsPackage: String): String? {
        val name = respWrapper.substringAfterLast('.')
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
