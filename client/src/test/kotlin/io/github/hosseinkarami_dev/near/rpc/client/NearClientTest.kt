package io.github.hosseinkarami_dev.near.rpc.client

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

class NearClientTest {

    private val httpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }
//
//    private val nearClient = NearClient(
//        httpClient = httpClient,
//        baseUrl = "https://rpc.mainnet.near.org"
//    )

    @Test
    fun testTransactionStatus() = runTest {
    }
}