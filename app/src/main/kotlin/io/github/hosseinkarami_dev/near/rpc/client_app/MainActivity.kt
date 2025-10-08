package io.github.hosseinkarami_dev.near.rpc.client_app

import android.os.Bundle
import androidx.core.app.ComponentActivity
import io.github.hosseinkarami_dev.near.rpc.client.NearClient
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

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
//
//        lifecycleScope.launch {
//            val response = nearClient.tx(
//                RpcTransactionStatusRequest.SignedTxBase64(
//                signedTxBase64 = SignedTransaction("FtzDPgG7BnX3g6WV7w951TZ1UErFahfp6NwQKiTE9dMp"),
//                waitUntil = TxExecutionStatus.Final
//            ))
// //           val response = nearClient.status()
////            val response = nearClient.gasPrice(RpcGasPriceRequest(blockId = null))
//
//            when (response) {
//                is RpcResponse.Failure -> {
//                    println("Error: ${response.error}")
//                }
//
//                is RpcResponse.Success -> {
//                    val result = response.result
//                    println("Result: $result")
//
//                }
//            }
//        }
    }
}