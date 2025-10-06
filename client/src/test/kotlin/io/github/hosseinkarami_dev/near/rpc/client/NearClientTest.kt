package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.models.AccountId
import io.github.hosseinkarami_dev.near.rpc.models.BlockId
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.EpochId
import io.github.hosseinkarami_dev.near.rpc.models.Finality
import io.github.hosseinkarami_dev.near.rpc.models.GenesisConfig
import io.github.hosseinkarami_dev.near.rpc.models.RpcBlockRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcGasPriceRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcMaintenanceWindowsRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcNetworkInfoResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcStatusResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest
import org.junit.jupiter.api.Test
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
//        val response = nearClient.query(
//            RpcQueryRequest.ViewAccessKeyListByFinality(
//                finality = Finality.FINAL,
//                accountId = AccountId("neardome2340.near"),
//             //   publicKey = PublicKey("ed25519:EddTahJwZpJjYPPmat7DBm1m2vdrFBzVv7e3T4hzkENd"),
//                requestType = RpcQueryRequest.ViewAccessKeyListByFinality.RequestType.VIEW_ACCESS_KEY_LIST
//            )
//        )

//        val response = nearClient.experimentalMaintenanceWindows(
//            RpcMaintenanceWindowsRequest(
//                AccountId("neardome2340.near")
//            )
//        )
//
//        println(response)
//
//        when (response) {
//            is RpcResponse.Failure -> {
//                println(response.error)
//                println("hiiiiiiiii")
//            }
//
//            is RpcResponse.Success -> {
////               val accessKeyList = response.getResultOrNull<RpcQueryResponse.AccountView>()
////               println(accessKeyList)
//            }
//        }

        val response = nearClient.genesisConfig()

        when (response) {
            is RpcResponse.Failure -> {
                println(response.error)
            }

            is RpcResponse.Success<*> -> {
                println(response)

            }
        }


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
//
//        when (response) {
//            is RpcResponse.Failure -> {
//                println("Error: ${response.error.code} ${response.error.message}")
//                assert(false)
//            }
//
//            is RpcResponse.Success -> {
//                println("Result: ${response.result}")
//                assert(true)
//            }
//        }
    }
}