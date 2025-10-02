package io.github.hosseinkarami_dev.near.rpc.client_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import io.github.hosseinkarami_dev.near.rpc.client.NearClient
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch
import io.github.hosseinkarami_dev.near.rpc.client.RpcResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcGasPriceRequest

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val httpClient = HttpClient(CIO) {
            install(ContentNegotiation) {
                json()
            }
        }

        val nearClient = NearClient(
            httpClient = httpClient,
            baseUrl = "https://rpc.mainnet.near.org" // or testnet: https://rpc.testnet.near.org
        )

        lifecycleScope.launch {
            val response = nearClient.gasPrice(RpcGasPriceRequest(blockId = null))

            when (response) {
                is RpcResponse.Failure -> {
                    println("Error: ${response.error.code} ${response.error.message}")
                }

                is RpcResponse.Success -> {
                    val result = response.result
                    println("Result: $result")

                }
            }
        }
    }
}