package io.github.hosseinkarami_dev.near.rpc.generator

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertTrue

class ModelsGenerationTest {
//
//    @Test
//    fun `models directory should not be empty`() {
//        val modelsDir = File(MODELS_DIR)
//        assertTrue(modelsDir.exists(), "Models directory should exist")
//        assertTrue(modelsDir.listFiles()?.isNotEmpty() == true, "Models directory should contain generated files")
//    }
//
//    @Test
//    fun `at least one model file should be generated`() {
//        val modelsDir = File(MODELS_DIR)
//        val kotlinFiles = modelsDir.listFiles { file -> file.extension == "kt" } ?: emptyArray()
//        assertTrue(kotlinFiles.isNotEmpty(), "Models directory should contain at least one generated .kt file")
//    }
//
//    @Test
//    fun `all generated model files should not be empty`() {
//        val modelsDir = File(MODELS_DIR)
//        val kotlinFiles = modelsDir.walkTopDown().filter { it.isFile && it.extension == "kt" }
//        kotlinFiles.forEach { file ->
//            assertTrue(file.readText().isNotBlank(), "${file.name} should not be empty")
//        }
//    }

//    @Test
//    fun `generated model files should compile without errors`() {
//        val modelsDir = File(MODELS_DIR)
//        val kotlinFiles = modelsDir.walkTopDown().filter { it.isFile && it.extension == "kt" }.toList()
//        assert(kotlinFiles.isNotEmpty()) { "No model files found in $MODELS_DIR" }
//
//        val compiler = K2JVMCompiler()
//        val args = arrayOf(
//            "-classpath", System.getProperty("java.class.path"),
//            *kotlinFiles.map { it.absolutePath }.toTypedArray()
//        )
//
//        val exitCode = compiler.exec(System.err, *args).code
//        assertEquals(0, exitCode, "Generated model files should compile without errors")
//    }

    companion object {
        const val MODELS_DIR = "../models/src/main/kotlin/io/github/hosseinkarami_dev/near/rpc/models"
    }
}