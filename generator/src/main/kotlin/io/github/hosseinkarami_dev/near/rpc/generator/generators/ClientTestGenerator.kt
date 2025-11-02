package io.github.hosseinkarami_dev.near.rpc.generator.generators

import io.github.hosseinkarami_dev.near.rpc.generator.OpenApiSpec
import io.github.hosseinkarami_dev.near.rpc.generator.Operation
import io.github.hosseinkarami_dev.near.rpc.generator.Schema
import io.github.hosseinkarami_dev.near.rpc.generator.camelCase
import io.github.hosseinkarami_dev.near.rpc.generator.pascalCase
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import java.io.File

object ClientTestGenerator {

    data class MethodInfo(
        val methodName: String,
        val requestType: String,
        val responseType: String,
        val operation: Operation
    )

    fun generateTestsForClient(
        spec: OpenApiSpec,
        output: File,
        testsPackage: String,
        clientPackage: String,
        modelsPackage: String
    ) {
        // collect operations together with types and keep the Operation itself
        val methods = spec.paths.flatMap { (_, pathItem) ->
            listOfNotNull(
                extractOperationInfo(pathItem.post),
                extractOperationInfo(pathItem.get)
            )
        }

        val fileContent = buildString {
            appendLine("package $testsPackage")
            appendLine()
            appendLine("import kotlin.test.Test")
            appendLine("import kotlin.test.assertNotNull")
            appendLine("import kotlin.test.fail")
            appendLine("import io.ktor.client.*")
            appendLine("import io.ktor.client.engine.mock.*")
            appendLine("import io.ktor.client.plugins.contentnegotiation.*")
            appendLine("import io.ktor.serialization.kotlinx.json.*")
            appendLine("import io.ktor.http.*")
            appendLine("import kotlinx.coroutines.test.runTest")
            appendLine("import kotlinx.serialization.json.Json")
            appendLine("import kotlinx.serialization.decodeFromString")
            appendLine("import java.io.File")
            appendLine()
            appendLine("/**")
            appendLine(" * Generated client unit tests using mock JSON from src/test/resources/mock/")
            appendLine(" */")
            appendLine("class NearClientUnitTests {")
            appendLine()
            appendLine("    private val json = Json { ignoreUnknownKeys = true }")
            appendLine()
            appendLine("    private fun loadMockJson(filename: String): String? {")
            appendLine("        val f = File(\"src/test/resources/mock/\$filename\")")
            appendLine("        return if (f.exists()) f.readText() else null")
            appendLine("    }")
            appendLine()

            for ((methodName, requestType, responseType, op) in methods) {
                val capitalizedMethod = methodName.pascalCase()
                val requestFile = "${requestType.pascalCase()}.json"
//                val successFile = "${responseType.pascalCase()}.json"
//                val errorFile = "${responseType.pascalCase()}_Error.json"

                appendLine("    @Test")
                appendLine("    fun test${capitalizedMethod}() = runTest {")
//                appendLine("        val requestData = loadMockJson(\"$requestFile\")")
//                appendLine("        assertNotNull(requestData, \"Mock request file $requestFile does not exist!\")")
//                appendLine()
                appendLine("        val data = loadMockJson(\"$requestFile\")")
                appendLine("        assertNotNull(data, \"Mock file $requestFile does not exist!\")")
                appendLine()
//                appendLine("        val errorData = loadMockJson(\"$errorFile\")")
//                appendLine("        assertNotNull(errorData, \"Mock error file $errorFile does not exist!\")")
                appendLine()
                appendLine("        val mockEngine = MockEngine { req ->")
                appendLine("            when (req.url.fullPath) {")
                appendLine("                else -> respond(data, headers = headersOf(\"Content-Type\" to listOf(ContentType.Application.Json.toString())))")
                appendLine("            }")
                appendLine("        }")
                appendLine()
                appendLine("        val client = HttpClient(mockEngine) {")
                appendLine("            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }")
                appendLine("        }")
                appendLine()
                appendLine("        val nearClient = $clientPackage.NearClient(client, \"http://mock\", json)")
                appendLine()
                appendLine("        try {")
                // decode wrapper request
                appendLine("            val requestObj = json.decodeFromString($modelsPackage.${requestType.pascalCase()}.serializer(), data)")

                // determine whether the generated client method has a parameter or is no-arg
                // replicate the resolve logic: if resolveParamsTypeFromOperation returns non-null and not Unit => has params
                val hasParams = resolveParamsTypeFromOperationForTest(op, spec, modelsPackage) != null &&
                        resolveParamsTypeFromOperationForTest(op, spec, modelsPackage) != "Unit"

                if (hasParams) {
                    // safe to call with requestObj.params (some request wrappers may use `params: JsonElement` etc.)
                    appendLine("            val response = nearClient.${methodName.camelCase()}(requestObj.params)")
                } else {
                    // method signature has no parameter — call no-arg
                    appendLine("            val response = nearClient.${methodName.camelCase()}()")
                }

                appendLine("            assertNotNull(response)")
                appendLine("        } catch (e: Exception) {")
                appendLine("            fail(\"Test for $capitalizedMethod failed: \${e.message}\")")
                appendLine("        }")
                appendLine("    }")
                appendLine()
            }

            appendLine("}")
        }

        output.mkdirs()
        File(output, "NearClientUnitTests.kt").writeText(fileContent)
        println("✅ Client unit tests generated at: ${File(output, "NearClientUnitTests.kt").absolutePath}")
    }

    // --------------- helpers (copied/adapted from ClientGenerator logic) ---------------

    private fun extractOperationInfo(operation: Operation?): MethodInfo? {
        if (operation == null) return null
        val methodName = operation.operationId
        val requestType = operation.requestBody?.content?.values?.firstOrNull()?.schema?.let { extractRefName(it) } ?: "UnknownRequest"
        val responseType = operation.responses["200"]?.content?.values?.firstOrNull()?.schema?.let { extractRefName(it) } ?: "UnknownResponse"
        return MethodInfo(methodName, requestType, responseType, operation)
    }

    private fun extractRefName(schema: JsonElement): String? {
        return schema.jsonObject["\$ref"]?.jsonPrimitive?.content?.substringAfterLast("/")
    }

    /**
     * A light-weight replica of resolveParamsTypeFromOperation used for the test generator.
     * It returns:
     *   - "Unit" if params are treated as empty/no-params
     *   - "$modelsPackage.SomeModel" for referenced types
     *   - primitive / List types similarly
     *   - null if there is no params information
     *
     * This is intentionally a local copy so the test generator can decide whether the generated client method will have a parameter.
     */
    private fun resolveParamsTypeFromOperationForTest(
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

        fun isEmptyObject(schema: Schema?): Boolean {
            if (schema == null) return false
            return schema.type == "object" &&
                    (schema.properties == null || schema.properties.isEmpty()) &&
                    schema.anyOf == null && schema.oneOf == null && schema.allOf == null
        }

        paramsSchema.ref?.let { pRef ->
            val pName = pRef.substringAfterLast('/')
            val pSchema = spec.components.schemas[pName]
            if (pSchema != null) {
                if (pSchema.nullable == true) return "Unit"
                if (pSchema.enum != null && pSchema.enum.size == 1 && pSchema.enum[0] == null) return "Unit"
                if (isEmptyObject(pSchema)) return "Unit"
                return "$modelsPackage.${pName.pascalCase()}"
            }
            return "$modelsPackage.${pName.pascalCase()}"
        }

        if (paramsSchema.enum != null && paramsSchema.enum.size == 1 && paramsSchema.enum[0] == null) {
            return "Unit"
        }

        if (paramsSchema.nullable == true) return "Unit"

        if (paramsSchema.type == "array") {
            val item = paramsSchema.items
            if (item?.ref != null) {
                val itemName = item.ref.substringAfterLast('/')
                return "List<$modelsPackage.${itemName.pascalCase()}>"
            }
            return "List<kotlinx.serialization.json.JsonElement>"
        }

        if (paramsSchema.type == "object") {
            val isEmptyInlineObject =
                (paramsSchema.properties == null || paramsSchema.properties.isEmpty()) &&
                        paramsSchema.anyOf == null && paramsSchema.oneOf == null && paramsSchema.allOf == null
            if (isEmptyInlineObject) return "Unit"
            return "kotlinx.serialization.json.JsonElement"
        }

        return when (paramsSchema.type) {
            "string" -> "String"
            "integer" -> "Int"
            "number" -> "Double"
            "boolean" -> "Boolean"
            else -> null
        }
    }
}
