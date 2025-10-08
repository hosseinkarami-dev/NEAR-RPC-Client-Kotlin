package io.github.hosseinkarami_dev.near.rpc.client_app

import android.os.Bundle
import androidx.core.app.ComponentActivity
import androidx.lifecycle.lifecycleScope
import io.github.hosseinkarami_dev.near.rpc.client.NearClient
import io.github.hosseinkarami_dev.near.rpc.client.RpcResponse
import io.github.hosseinkarami_dev.near.rpc.client.Utils.getResultOrNull
import io.github.hosseinkarami_dev.near.rpc.models.BlockId
import io.github.hosseinkarami_dev.near.rpc.models.RpcBlockRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcBlockResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
                val response = nearClient.block(
                    RpcBlockRequest.BlockId(BlockId.BlockHeight(167440515.toULong()))
                )

                when (response) {
                    is RpcResponse.Failure -> {
                        println("Error: ${response.error}")
                    }

                    is RpcResponse.Success -> {
                        val result = response.getResultOrNull<RpcBlockResponse>()
                        println("Result: $result")

                    }
            }
        }
    }
}