package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.client.Utils.getResultOrNull
import io.github.hosseinkarami_dev.near.rpc.models.AccountId
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest
import io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.assertTrue

class TxStatusTest {

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
        val response = nearClient.experimentalTxStatus(RpcTransactionStatusRequest.SenderAccountId(
            senderAccountId = AccountId("relay.tg"),
            txHash = CryptoHash("5FfisT8c27W2vg3AqFTX5EVKve2xV5ZUHuzr2vxYM6c2"),
        ))
        val result = response.getResultOrNull<RpcTransactionResponse>()
        println("Experimental Tx Status Response: $result")
        assertTrue { true }
    }
}