package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.models.PrepareError
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.junit.Test
import kotlin.test.assertEquals

class PrepareErrorTest {

    private val json = Json { encodeDefaults = true }

    @Test
    fun `test all PrepareError serialization`() {
        val allErrors = listOf(
            PrepareError.Serialization,
            PrepareError.Deserialization,
            PrepareError.InternalMemoryDeclared,
            PrepareError.GasInstrumentation,
            PrepareError.StackHeightInstrumentation,
            PrepareError.Instantiate,
            PrepareError.Memory,
            PrepareError.TooManyFunctions,
            PrepareError.TooManyLocals,
            PrepareError.TooManyTables,
            PrepareError.TooManyTableElements
        )

        for (error in allErrors) {
            val serialized = json.encodeToString<PrepareError>(error)
            println("${error::class.simpleName} serialized: $serialized")

            val deserialized = json.decodeFromString<PrepareError>(serialized)
            assertEquals(error, deserialized, "Failed for ${error::class.simpleName}")
        }
    }

    @Test
    fun `test Serialization PrepareError`() {
        val error: PrepareError = PrepareError.Serialization
        val serialized = json.encodeToString(error)
        println("Serialized: $serialized")

        val deserialized = json.decodeFromString<PrepareError>(serialized)
        assertEquals(error, deserialized)
    }

    @Test
    fun `test Deserialization PrepareError`() {
        val error: PrepareError = PrepareError.Deserialization
        val serialized = json.encodeToString(error)
        println("Serialized: $serialized")

        val deserialized = json.decodeFromString<PrepareError>(serialized)
        assertEquals(error, deserialized)
    }

    @Test
    fun `test InternalMemoryDeclared PrepareError`() {
        val error: PrepareError = PrepareError.InternalMemoryDeclared
        val serialized = json.encodeToString(error)
        println("Serialized: $serialized")

        val deserialized = json.decodeFromString<PrepareError>(serialized)
        assertEquals(error, deserialized)
    }
}