package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView
import io.github.hosseinkarami_dev.near.rpc.models.NearToken
import io.github.hosseinkarami_dev.near.rpc.serializers.AccessKeyPermissionViewSerializer
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.test.Test
import kotlin.test.assertEquals

class AccessKeyPermissionViewTest {

    private val json = Json { prettyPrint = true }

    @Test
    fun `FullAccess serialization and deserialization`() {
        val original: AccessKeyPermissionView = AccessKeyPermissionView.FullAccess()

        // Serialize
        val serialized = json.encodeToString(AccessKeyPermissionViewSerializer, original)
        println("Serialized FullAccess: $serialized")
        assertEquals("\"FullAccess\"", serialized)

        // Deserialize
        val deserialized = json.decodeFromString(AccessKeyPermissionViewSerializer, serialized)
        assertEquals(original, deserialized)
    }

    @Test
    fun `FunctionCall serialization and deserialization`() {
        val original: AccessKeyPermissionView = AccessKeyPermissionView.FunctionCall(
            AccessKeyPermissionView.FunctionCall.FunctionCallPayload(
                allowance = null,
                methodNames = listOf("transfer", "stake"),
                receiverId = "alice.near"
            )
        )

        // Serialize
        val serialized = json.encodeToString(AccessKeyPermissionViewSerializer, original)
        println("Serialized FunctionCall: $serialized")

        // Deserialize
        val deserialized = json.decodeFromString(AccessKeyPermissionViewSerializer, serialized)
        assertEquals(original, deserialized)
    }
}