package io.github.hosseinkarami_dev.near.rpc.generator

import io.github.hosseinkarami_dev.near.rpc.generator.ModelsGenerationTest.Companion.MODELS_DIR
import org.jetbrains.kotlin.cli.jvm.K2JVMCompiler
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue
import java.io.File
import kotlin.test.assertEquals

class NearClientGenerationTest {

    @Test
    fun `client file should be generated`() {
        val clientFile = File(NEAR_CLIENT_LOCATION)
        assertTrue(clientFile.exists(), "NearClient.kt should be generated")
    }

    @Test
    fun `generated client should contain correct class name`() {
        val clientFile = File(NEAR_CLIENT_LOCATION)
        val content = clientFile.readText()
        assertTrue("class NearClient" in content, "Generated client should contain NearClient class")
    }

    companion object {
        private const val NEAR_CLIENT_LOCATION = "../client/src/main/kotlin/io/github/hosseinkarami_dev/near/rpc/client/NearClient.kt"
    }
}