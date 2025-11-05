package io.github.hosseinkarami_dev.near.rpc.client_app.presentation.ui.request

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.hosseinkarami_dev.near.rpc.client.ErrorResult
import io.github.hosseinkarami_dev.near.rpc.client.NearClient
import io.github.hosseinkarami_dev.near.rpc.client.RpcResponse
import io.github.hosseinkarami_dev.near.rpc.client_app.data.UserPreferencesRepository
import io.github.hosseinkarami_dev.near.rpc.models.AccountId
import io.github.hosseinkarami_dev.near.rpc.models.BlockId
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.EpochId
import io.github.hosseinkarami_dev.near.rpc.models.RpcBlockRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcGasPriceRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientNextBlockRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest
import io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus
import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

enum class KeyboardInputType {
    TEXT,
    NUMBER
}

data class ParameterItem(
    val name: String,
    val description: String,
    val required: Boolean,
    val keyboardType: KeyboardInputType = KeyboardInputType.TEXT
)

class RequestViewModel(
    private val httpClient: HttpClient,
    private val userPreferencesRepository: UserPreferencesRepository,
    val endpointName: String,
    val descriptionResId: Int
) : ViewModel() {

    var response by mutableStateOf<RpcResponse<*>?>(null)
    var isLoading by mutableStateOf(false)
        private set

    val parameters: List<ParameterItem> = when (endpointName) {
        "block" -> listOf(
            ParameterItem(
                "block_height",
                "The height of the block",
                required = true,
                keyboardType = KeyboardInputType.NUMBER
            )
        )

        "block_effects" -> listOf(
            ParameterItem(
                "block_height",
                "The height of the block",
                required = true,
                keyboardType = KeyboardInputType.NUMBER
            )
        )

        "chunk" -> listOf(ParameterItem("chunk_hash", "The Hash of the chunk", required = true))

        "transaction_status" -> listOf(
            ParameterItem("sender_account_id", "The sender account address", required = true),
            ParameterItem("tx_hash", "The hash of the transaction", required = true),
        )

        "network_info" -> listOf()

        "view_account" -> listOf(
            ParameterItem(
                "block_id",
                "The height of the block",
                required = true,
                keyboardType = KeyboardInputType.NUMBER
            ),
            ParameterItem("account_id", "The account", required = true),
        )

        "next_light_client_block" -> listOf(
            ParameterItem(
                "last_block_hash",
                "The last block hash",
                required = true
            )
        )

        "transaction" -> listOf(
            ParameterItem(
                "tx_hash",
                "The hash of the transaction",
                required = true
            ),
            ParameterItem("sender_account_id", "The sender account", required = true),
            ParameterItem("wait_until", "one of: executed, none, executed_optimistic, final, included, included_final", required = false),
        )

        "gas_price" -> listOf(
            ParameterItem(
                "block_id",
                "Can be empty for latest",
                required = false,
                keyboardType = KeyboardInputType.NUMBER
            )
        )

        "validators" -> listOf(
            ParameterItem(
                "epoch_id",
                "Can be empty for latest",
                required = false
            )
        )

        else -> emptyList()
    }

    fun sendRequest(params: Map<String, String>) {
        viewModelScope.launch {
            isLoading = true
            val currentNetworkUrl =
                userPreferencesRepository.userPreferencesFlow.first().network.url
            val nearClient = NearClient(httpClient, currentNetworkUrl)
            try {
                response = when (endpointName) {
                    "view_account" -> {
                        val blockId = params["block_id"]!!
                        val accountId = params["account_id"]!!
                        val requestType =
                            RpcQueryRequest.ViewAccountByBlockId.RequestType.VIEW_ACCOUNT
                        val request =
                            RpcQueryRequest.ViewAccountByBlockId(
                                blockId = BlockId.BlockHeight(blockId.toULong()),
                                requestType = requestType,
                                accountId = AccountId(accountId)
                            )

                        nearClient.query(request)
                    }

                    "transaction_status" -> {
                        val senderAccountId = params["sender_account_id"]!!
                        val cryptoHash = params["tx_hash"]!!
                        val request = RpcTransactionStatusRequest.SenderAccountId(
                            senderAccountId = AccountId(senderAccountId),
                            txHash = CryptoHash(cryptoHash)
                        )
                        nearClient.experimentalTxStatus(request)
                    }

                    "block" -> {
                        val blockId = params["block_height"]!!
                        val request =
                            RpcBlockRequest.BlockId(blockId = BlockId.BlockHeight(blockId.toULong()))
                        nearClient.block(request)
                    }

                    "network_info" -> {
                        nearClient.networkInfo()
                    }

                    "health" -> nearClient.health()

                    "block_effects" -> {
                        val blockHeight = params["block_height"]!!.toULong()
                        val request = RpcStateChangesInBlockRequest.BlockId(
                            blockId = BlockId.BlockHeight(blockHeight)
                        )
                        nearClient.blockEffects(request)
                    }

                    "next_light_client_block" -> {
                        val blockHash = params["last_block_hash"]!!
                        val request = RpcLightClientNextBlockRequest(
                            lastBlockHash = CryptoHash(blockHash)
                        )
                        nearClient.nextLightClientBlock(request)
                    }

                    "transaction" -> {
                        val senderAccountId = params["sender_account_id"]!!
                        val txHash = params["tx_hash"]!!
                        val waitUntil = params["wait_until"]

                        nearClient.tx(
                            RpcTransactionStatusRequest.SenderAccountId(
                                senderAccountId = AccountId(senderAccountId),
                                txHash = CryptoHash(txHash),
                                waitUntil = when (waitUntil?.lowercase()) {
                                    "executed" -> TxExecutionStatus.Executed
                                    "none" -> TxExecutionStatus.None
                                    "executed_optimistic" -> TxExecutionStatus.ExecutedOptimistic
                                    "final" -> TxExecutionStatus.Final
                                    "included" -> TxExecutionStatus.Included
                                    "included_final" -> TxExecutionStatus.IncludedFinal
                                    else -> null
                                }
                            )
                        )
                    }

                    "gas_price" -> {
                        val blockId = params["block_id"]
                        val request =
                            RpcGasPriceRequest(blockId = blockId?.let { BlockId.BlockHeight(it.toULong()) })
                        nearClient.gasPrice(request)
                    }

                    "status" -> {
                        nearClient.status()
                    }

                    "validators" -> {
                        val epochId = params["epoch_id"]
                        val request = if (epochId != null) {
                            RpcValidatorRequest.EpochId(epochId = EpochId(epochId))
                        } else
                            RpcValidatorRequest.Latest

                        nearClient.validators(request)
                    }

                    else -> RpcResponse.Failure(ErrorResult.Unknown("Endpoint not implemented."))
                }
            } finally {
                isLoading = false
            }
        }
    }

    fun clearResponse() {
        response = null
    }
}
