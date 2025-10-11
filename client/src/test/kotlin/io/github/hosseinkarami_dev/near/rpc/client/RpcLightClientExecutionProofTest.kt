package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.client.Utils.getResultOrNull
import io.github.hosseinkarami_dev.near.rpc.models.AccountId
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.assertTrue

class RpcLightClientExecutionProofTest {

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
        val response = nearClient.lightClientProof(RpcLightClientExecutionProofRequest.Transaction(
            senderId = AccountId("relay.tg"),
            type = RpcLightClientExecutionProofRequest.Transaction.Type.TRANSACTION,
            lightClientHead = CryptoHash("5sqMdW5jG6Q33xoY4bJ8AnKJWTCpcV9gPfzfyjUzPV3r"),
            transactionHash = CryptoHash("5FfisT8c27W2vg3AqFTX5EVKve2xV5ZUHuzr2vxYM6c2")
        ))
        val result = response.getResultOrNull<RpcLightClientExecutionProofResponse>()
        println("Light Client Proof Response: $result")
        assertTrue { response is RpcResponse.Failure }
    }
}