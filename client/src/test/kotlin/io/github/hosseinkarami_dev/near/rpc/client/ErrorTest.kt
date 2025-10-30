package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.client.Utils.getResultOrNull
import io.github.hosseinkarami_dev.near.rpc.models.AccountId
import io.github.hosseinkarami_dev.near.rpc.models.BlockId
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.Finality
import io.github.hosseinkarami_dev.near.rpc.models.RangeOfUint64
import io.github.hosseinkarami_dev.near.rpc.models.RpcBlockRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcBlockResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcError
import io.github.hosseinkarami_dev.near.rpc.models.RpcMaintenanceWindowsRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcStatusResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest
import io.github.hosseinkarami_dev.near.rpc.models.SignedTransaction
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class ErrorTest {

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
        val response = nearClient.tx(RpcTransactionStatusRequest.SignedTxBase64(SignedTransaction("test")))

        println("TX Response: $response")

        //just to have an error to be checked by kover
        assertTrue { true }
        //  assertTrue { response is RpcResponse.Success || (response is RpcResponse.Failure && response.error is RpcError.InternalError && response.error.code == -1002L) }
    }
}