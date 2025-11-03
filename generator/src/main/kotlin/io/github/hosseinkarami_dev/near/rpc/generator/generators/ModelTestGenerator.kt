package io.github.hosseinkarami_dev.near.rpc.generator.generators

import io.github.hosseinkarami_dev.near.rpc.generator.OpenApiSpec
import io.github.hosseinkarami_dev.near.rpc.generator.pascalCase
import java.io.File

object ModelTestGenerator {

    /**
     * Generate tests for all schemas found in the spec.components.schemas map.
     */

    fun generateTestsForModels(
        spec: OpenApiSpec,
        output: File,
        modelsPackage: String,
        testsPackage: String
    ) {
        val schemas = spec.components.schemas.keys.sorted()

        val fileContent = buildString {
            appendLine("package $testsPackage")
            appendLine()
            appendLine("import kotlin.test.Test")
            appendLine("import kotlin.test.assertEquals")
            appendLine("import kotlin.test.assertNotNull")
            appendLine("import kotlin.test.fail")
            appendLine("import kotlinx.serialization.json.Json")
            appendLine("import kotlinx.serialization.decodeFromString")
            appendLine("import kotlinx.serialization.encodeToString")
            appendLine("import java.io.File")
            appendLine()
            appendLine("/**")
            appendLine(" * Generated model (de)serialization tests.")
            appendLine(" * For each schema we try to load `src/test/resources/mock/<SchemaName>.json`")
            appendLine(" * If the file does not exist the test will fail and indicate which file is missing")
            appendLine(" */")
            appendLine("class ModelSerializationTests {")
            appendLine()
            appendLine("    private val json = Json { ignoreUnknownKeys = true }")
            appendLine()
            appendLine("    private fun loadMockJson(filename: String): String? {")
            appendLine("        val f = File(\"src/test/resources/mock/\$filename\")")
            appendLine("        return if (f.exists()) f.readText() else null")
            appendLine("    }")
            appendLine()

            for (schemaName in schemas) {
                val className = schemaName.pascalCase()
                val fileName = "${schemaName.pascalCase()}.json"
                appendLine("    @Test")
                appendLine("    fun test${className}EncodeDecode() {")
                appendLine("        val data = loadMockJson(\"$fileName\")")
                appendLine("        assertNotNull(data, \"Mock file $fileName does not exist!\")")
                appendLine()
                appendLine("        try {")
                appendLine("            val decoded = json.decodeFromString($modelsPackage.$className.serializer(), data)")
                appendLine("            val encoded = json.encodeToString($modelsPackage.$className.serializer(), decoded)")
                appendLine("            val decoded2 = json.decodeFromString($modelsPackage.$className.serializer(), encoded)")
                appendLine("            assertEquals(decoded, decoded2)")
                appendLine("        } catch (e: Exception) {")
                appendLine("            e.printStackTrace()")
                appendLine("            fail(\"Serialization test failed for $className: \${e.message}\")")
                appendLine("        }")
                appendLine("    }")
                appendLine()
            }

            appendLine("}")
        }

        // write to file
        val testFile = File(output, "ModelSerializationTests.kt")
        testFile.parentFile.mkdirs()
        testFile.writeText(fileContent)
        println("✅ Model serialization tests generated at: ${testFile.absolutePath}")
    }
}