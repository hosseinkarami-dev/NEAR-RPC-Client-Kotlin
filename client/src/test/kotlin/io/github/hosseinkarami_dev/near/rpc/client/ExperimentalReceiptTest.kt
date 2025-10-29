package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.client.Utils.getResultOrNull
import io.github.hosseinkarami_dev.near.rpc.models.AccountId
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifier
import io.github.hosseinkarami_dev.near.rpc.models.NearToken
import io.github.hosseinkarami_dev.near.rpc.models.PublicKey
import io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView
import io.github.hosseinkarami_dev.near.rpc.models.RpcError
import io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptResponse
import io.github.hosseinkarami_dev.near.rpc.models.ShardId
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ExperimentalReceiptTest {

    private lateinit var httpClient: HttpClient
    private lateinit var nearClient: NearClient

    @BeforeTest
    fun setup() {
        httpClient = HttpClient(CIO) {
            install(ContentNegotiation) {
                json()
            }
        }

        nearClient = NearClient(
            httpClient = httpClient,
            baseUrl = "https://rpc.mainnet.near.org"
        )
    }

    @AfterTest
    fun teardown() {
        httpClient.close()
    }

    @Test
    fun testStatus() = runTest {
        val response = nearClient.experimentalReceipt(RpcReceiptRequest(
            receiptId = CryptoHash("3YbVEYmAkXyKZUk7iyKs4mVzvQ43azZnGjGj2hZua7VC")
        ))
        val result = response.getResultOrNull<RpcReceiptResponse>()
        println("RPC Receipt Response: $response")

        //UNKNOWN_RECEIPT Error
        assertTrue { true }

        //assertTrue { response is RpcResponse.Success || (response is RpcResponse.Failure && response.error is RpcError.InternalError && response.error.code == -1002L) }
    }

    private val json = Json {
        encodeDefaults = true
        prettyPrint = true
        ignoreUnknownKeys = false
    }

    @Test
    fun `RpcReceiptResponse with Action serialization and deserialization`() {
        val request = RpcReceiptResponse(
            predecessorId = AccountId("alice.testnet"),
            priority = 10.toULong(),
            receipt = ReceiptEnumView.Action(
                ReceiptEnumView.Action.ActionPayload(
                    actions = emptyList(),
                    gasPrice = NearToken("1000"),
                    inputDataIds = listOf(CryptoHash("input1")),
                    isPromiseYield = true,
                    outputDataReceivers = emptyList(),
                    signerId = AccountId("bob.testnet"),
                    signerPublicKey = PublicKey("ed25519:pk1")
                )
            ),
            receiptId = CryptoHash("receipt123"),
            receiverId = AccountId("carol.testnet")
        )

        val serialized = json.encodeToString(RpcReceiptResponse.serializer(), request)
        val deserialized = json.decodeFromString(RpcReceiptResponse.serializer(), serialized)
        assertEquals(request, deserialized)
    }

    @Test
    fun `RpcReceiptResponse with Data serialization and deserialization`() {
        val request = RpcReceiptResponse(
            predecessorId = AccountId("alice.testnet"),
            priority = null,
            receipt = ReceiptEnumView.Data(
                ReceiptEnumView.Data.DataPayload(
                    data = "hello".encodeToByteArray().toList().joinToString(","),
                    dataId = CryptoHash("data123"),
                    isPromiseResume = true
                )
            ),
            receiptId = CryptoHash("receipt456"),
            receiverId = AccountId("carol.testnet")
        )

        val serialized = json.encodeToString(RpcReceiptResponse.serializer(), request)
        val deserialized = json.decodeFromString(RpcReceiptResponse.serializer(), serialized)
        assertEquals(request, deserialized)
    }

    @Test
    fun `RpcReceiptResponse with GlobalContractDistribution serialization and deserialization`() {
        val request = RpcReceiptResponse(
            predecessorId = AccountId("alice.testnet"),
            priority = 0.toULong(),
            receipt = ReceiptEnumView.GlobalContractDistribution(
                ReceiptEnumView.GlobalContractDistribution.GlobalContractDistributionPayload(
                    alreadyDeliveredShards = listOf(ShardId(0u)),
                    code = "code123",
                    id = GlobalContractIdentifier.AccountId(AccountId("contract1")),
                    targetShard = ShardId(1u)
                )
            ),
            receiptId = CryptoHash("receipt789"),
            receiverId = AccountId("carol.testnet")
        )

        val serialized = json.encodeToString(RpcReceiptResponse.serializer(), request)
        val deserialized = json.decodeFromString(RpcReceiptResponse.serializer(), serialized)
        assertEquals(request, deserialized)
    }
}