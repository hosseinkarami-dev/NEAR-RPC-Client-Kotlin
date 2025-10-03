package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.models.AccountId
import io.github.hosseinkarami_dev.near.rpc.models.Finality
import io.github.hosseinkarami_dev.near.rpc.models.RpcGasPriceRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest
import org.junit.jupiter.api.Test
import io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest
import io.github.hosseinkarami_dev.near.rpc.models.SignedTransaction
import io.github.hosseinkarami_dev.near.rpc.models.StoreKey
import io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.test.runTest

class NearClientTest {

    private val httpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

    private val nearClient = NearClient(
        httpClient = httpClient,
        baseUrl = "https://rpc.mainnet.near.org"
    )

    @Test
    fun testTransactionStatus() = runTest {
        val response = nearClient.networkInfo()
        //val response = nearClient.status()
//        val response = nearClient.changes(
//            RpcStateChangesInBlockByTypeRequest.DataChangesByFinality(
//                changesType = RpcStateChangesInBlockByTypeRequest.DataChangesByFinality.ChangesType.DATA_CHANGES,
//                finality = Finality.FINAL,
//                accountIds = listOf(AccountId("contract.rpc-examples.testnet")),
//                keyPrefixBase64 = StoreKey("c29tZV9wcmVmaXg="),
//            )
//        )
//        val response = nearClient.tx(
//            RpcTransactionStatusRequest.SignedTxBase64(
//                signedTxBase64 = SignedTransaction("FtzDPgG7BnX3g6WV7w951TZ1UErFahfp6NwQKiTE9dMp"),
//                waitUntil = null,
//            //    waitUntil = TxExecutionStatus.Final
//            )
//        )

        when (response) {
            is RpcResponse.Failure -> {
                println("Error: ${response.error.code} ${response.error.message}")
                assert(false)
            }

            is RpcResponse.Success -> {
                println("Result: ${response.result}")
                assert(true)
            }
        }
    }
}