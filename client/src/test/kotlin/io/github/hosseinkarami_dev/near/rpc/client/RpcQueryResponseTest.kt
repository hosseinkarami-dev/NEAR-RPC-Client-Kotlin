package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.models.AccessKeyInfoView
import io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView
import io.github.hosseinkarami_dev.near.rpc.models.AccessKeyView
import io.github.hosseinkarami_dev.near.rpc.models.AccountId
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.NearToken
import io.github.hosseinkarami_dev.near.rpc.models.PublicKey
import io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse
import io.github.hosseinkarami_dev.near.rpc.models.StateItem
import io.github.hosseinkarami_dev.near.rpc.models.StoreKey
import io.github.hosseinkarami_dev.near.rpc.models.StoreValue
import io.github.hosseinkarami_dev.near.rpc.serializers.RpcQueryResponseSerializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RpcQueryResponseTest {

    private val json = Json { encodeDefaults = true; ignoreUnknownKeys = false }

    @Test
    fun `test AccountView serialization and deserialization`() {
        val model = RpcQueryResponse.AccountView(
            amount = NearToken("1000"),
            codeHash = CryptoHash("hash123"),
            globalContractAccountId = AccountId("account.near"),
            globalContractHash = CryptoHash("gchash"),
            locked = NearToken("0"),
            storagePaidAt = 1uL,
            storageUsage = 1234uL,
            blockHash = CryptoHash("bh123"),
            blockHeight = 999uL
        )

        val encoded = json.encodeToString(RpcQueryResponseSerializer, model)
        val decoded = json.decodeFromString(RpcQueryResponseSerializer, encoded)

        assertEquals(model, decoded)
    }

    @Test
    fun `test ContractCodeView serialization and deserialization`() {
        val model = RpcQueryResponse.ContractCodeView(
            codeBase64 = "YWJjMTIz",
            hash = CryptoHash("hashABC"),
            blockHash = CryptoHash("bhXYZ"),
            blockHeight = 50uL
        )

        val encoded = json.encodeToString(RpcQueryResponseSerializer, model)
        val decoded = json.decodeFromString(RpcQueryResponseSerializer, encoded)

        assertEquals(model, decoded)
    }

    @Test
    fun `test ViewStateResult serialization and deserialization`() {
        val model = RpcQueryResponse.ViewStateResult(
            proof = listOf("proof1", "proof2"),
            values = listOf(StateItem(StoreKey("key1"), StoreValue("value1"))),
            blockHash = CryptoHash("hash987"),
            blockHeight = 88uL
        )

        val encoded = json.encodeToString(RpcQueryResponseSerializer, model)
        val decoded = json.decodeFromString(RpcQueryResponseSerializer, encoded)

        assertEquals(model, decoded)
    }

    @Test
    fun `test CallResult serialization and deserialization`() {
        val model = RpcQueryResponse.CallResult(
            logs = listOf("log1", "log2"),
            result = listOf(1u, 2u, 3u),
            blockHash = CryptoHash("block123"),
            blockHeight = 777uL
        )

        val encoded = json.encodeToString(RpcQueryResponseSerializer, model)
        val decoded = json.decodeFromString(RpcQueryResponseSerializer, encoded)

        assertEquals(model, decoded)
    }

    @Test
    fun `test AccessKeyView serialization and deserialization`() {
        val permission = AccessKeyPermissionView.FullAccess()

        val model = RpcQueryResponse.AccessKeyView(
            nonce = 1234uL,
            permission = permission,
            blockHash = CryptoHash("block555"),
            blockHeight = 80uL
        )

        val encoded = json.encodeToString(RpcQueryResponseSerializer, model)
        val decoded = json.decodeFromString(RpcQueryResponseSerializer, encoded)

        assertEquals(model, decoded)
    }

    @Test
    fun `test AccessKeyList serialization and deserialization`() {
        val accessKeyInfo = AccessKeyInfoView(
            publicKey = PublicKey("ed25519:abc"),
            accessKey = AccessKeyView(
                nonce = 10uL,
                permission = AccessKeyPermissionView.FullAccess()
            )
        )

        val model = RpcQueryResponse.AccessKeyList(
            keys = listOf(accessKeyInfo),
            blockHash = CryptoHash("hashList"),
            blockHeight = 600uL
        )

        val encoded = json.encodeToString(RpcQueryResponseSerializer, model)
        val decoded = json.decodeFromString(RpcQueryResponseSerializer, encoded)

        assertEquals(model, decoded)
    }
}
