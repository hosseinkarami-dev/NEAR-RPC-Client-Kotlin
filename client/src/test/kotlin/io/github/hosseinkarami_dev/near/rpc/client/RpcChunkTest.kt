package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.client.Utils.getResultOrNull
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.RpcChunkRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcChunkResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.assertNotNull

class RpcChunkTest {

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
        val response = nearClient.chunk(RpcChunkRequest.ChunkHash(CryptoHash("J2VFLWXq9TbzgWKitwT99pZtqxQ1E6hdXLezUyAPrJFn")))
        val result = response.getResultOrNull<RpcChunkResponse>()
        println("Rpc Chunk Response: $result")
        assertNotNull(response is RpcResponse.Success)
    }
}