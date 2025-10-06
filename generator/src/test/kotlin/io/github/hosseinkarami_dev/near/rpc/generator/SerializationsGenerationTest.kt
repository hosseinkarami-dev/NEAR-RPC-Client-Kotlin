package io.github.hosseinkarami_dev.near.rpc.generator

import org.jetbrains.kotlin.cli.jvm.K2JVMCompiler
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SerializationsGenerationTest {

    @Test
    fun `all generated serialization files should not be empty`() {
        val serializations = File(SERIALIZATIONS_DIR)
        val kotlinFiles = serializations.walkTopDown().filter { it.isFile && it.extension == "kt" }
        kotlinFiles.forEach { file ->
            assertTrue(file.readText().isNotBlank(), "${file.name} should not be empty")
        }
    }

    @Test
    fun `generated serialization files should compile without errors`() {
        val serializationsDir = File(SERIALIZATIONS_DIR)
        val kotlinFiles = serializationsDir.walkTopDown().filter { it.isFile && it.extension == "kt" }.toList()
        assert(kotlinFiles.isNotEmpty()) { "No serialization files found in $SERIALIZATIONS_DIR" }

        val compiler = K2JVMCompiler()
        val args = arrayOf(
            "-classpath", System.getProperty("java.class.path"),
            *kotlinFiles.map { it.absolutePath }.toTypedArray()
        )

        val exitCode = compiler.exec(System.err, *args).code
        assertEquals(0, exitCode, "Generated serialization files should compile without errors")
    }

    companion object {
        const val SERIALIZATIONS_DIR = "../models/src/main/kotlin/io/github/hosseinkarami_dev/near/rpc/serializations"
    }
}