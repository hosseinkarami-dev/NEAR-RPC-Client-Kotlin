package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus
import kotlinx.serialization.SerializationException
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TxExecutionStatusSerializerTest {

    private val json = Json { }

    @Test
    fun `serialize each variant to expected JSON string`() {
        val cases: List<Pair<TxExecutionStatus, String>> = listOf(
            TxExecutionStatus.None to "\"NONE\"",
            TxExecutionStatus.Included to "\"INCLUDED\"",
            TxExecutionStatus.ExecutedOptimistic to "\"EXECUTED_OPTIMISTIC\"",
            TxExecutionStatus.IncludedFinal to "\"INCLUDED_FINAL\"",
            TxExecutionStatus.Executed to "\"EXECUTED\"",
            TxExecutionStatus.Final to "\"FINAL\""
        )

        for ((variant, expectedJson) in cases) {
            val actual = json.encodeToString<TxExecutionStatus>(variant)
            assertEquals(expectedJson, actual, "serialization failed for $variant")
        }
    }

    @Test
    fun `deserialize each string to expected variant`() {
        val cases: List<Pair<String, TxExecutionStatus>> = listOf(
            "\"NONE\"" to TxExecutionStatus.None,
            "\"INCLUDED\"" to TxExecutionStatus.Included,
            "\"EXECUTED_OPTIMISTIC\"" to TxExecutionStatus.ExecutedOptimistic,
            "\"INCLUDED_FINAL\"" to TxExecutionStatus.IncludedFinal,
            "\"EXECUTED\"" to TxExecutionStatus.Executed,
            "\"FINAL\"" to TxExecutionStatus.Final
        )

        for ((jsonStr, expectedVariant) in cases) {
            val actual = json.decodeFromString<TxExecutionStatus>(jsonStr)
            assertEquals(expectedVariant, actual, "deserialization failed for $jsonStr")
        }
    }

    @Test
    fun `round trip serialize - deserialize returns same instance`() {
        val variants: List<TxExecutionStatus> = listOf(
            TxExecutionStatus.None,
            TxExecutionStatus.Included,
            TxExecutionStatus.ExecutedOptimistic,
            TxExecutionStatus.IncludedFinal,
            TxExecutionStatus.Executed,
            TxExecutionStatus.Final
        )

        for (variant in variants) {
            val s = json.encodeToString<TxExecutionStatus>(variant)
            val parsed = json.decodeFromString<TxExecutionStatus>(s)
            assertEquals(variant, parsed, "round-trip failed for $variant")
        }
    }

    @Test
    fun `unknown string should throw SerializationException`() {
        assertFailsWith<SerializationException> {
            json.decodeFromString<TxExecutionStatus>("\"UNKNOWN_VALUE\"")
        }
    }
}
