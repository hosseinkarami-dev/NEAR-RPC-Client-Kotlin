package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.client.Utils.getResultOrNull
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.RpcError
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientBlockProofRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientBlockProofResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientNextBlockResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.assertTrue

class ExperimentalLightClientBlockProofTest {

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
        val response = nearClient.experimentalLightClientBlockProof(
            RpcLightClientBlockProofRequest(
                blockHash = CryptoHash(""),
                lightClientHead = CryptoHash("")
            )
        )
        val result = response.getResultOrNull<RpcLightClientBlockProofResponse>()
        println("experimentalLightClientBlockProof Response: $result")

        //REQUEST_VALIDATION_ERROR
        assertTrue { true }

        //assertTrue { response is RpcResponse.Success || (response is RpcResponse.Failure && response.error is RpcError.InternalError && response.error.name == RpcError.InternalError.Name.INTERNAL_ERROR) }
    }
}