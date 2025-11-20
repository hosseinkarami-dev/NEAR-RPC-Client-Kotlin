package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.GenesisConfig
import io.github.hosseinkarami_dev.near.rpc.models.GenesisConfigError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBlock
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBlockEffects
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBroadcastTxAsync
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBroadcastTxCommit
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForChanges
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForChunk
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForClientConfig
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalChanges
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalChangesInBlock
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalCongestionLevel
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalGenesisConfig
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalLightClientBlockProof
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalLightClientProof
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalMaintenanceWindows
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalProtocolConfig
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalReceipt
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalSplitStorageInfo
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalTxStatus
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalValidatorsOrdered
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForGasPrice
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForGenesisConfig
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForHealth
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForLightClientProof
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForMaintenanceWindows
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForNetworkInfo
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForNextLightClientBlock
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForQuery
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForSendTx
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForStatus
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForTx
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForValidators
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForArrayOfValidatorStakeViewAndRpcValidatorError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForCryptoHashAndRpcTransactionError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForGenesisConfigAndGenesisConfigError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForNullableRpcHealthResponseAndRpcStatusError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcBlockResponseAndRpcBlockError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcChunkResponseAndRpcChunkError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcClientConfigResponseAndRpcClientConfigError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcGasPriceResponseAndRpcGasPriceError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientBlockProofResponseAndRpcLightClientProofError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcLightClientProofError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcLightClientNextBlockError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcNetworkInfoResponseAndRpcNetworkInfoError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcProtocolConfigResponseAndRpcProtocolConfigError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcQueryResponseAndRpcQueryError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcReceiptResponseAndRpcReceiptError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcStateChangesError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcStateChangesError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcStatusResponseAndRpcStatusError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcValidatorError
import io.github.hosseinkarami_dev.near.rpc.models.RangeOfUint64
import io.github.hosseinkarami_dev.near.rpc.models.RpcBlockError
import io.github.hosseinkarami_dev.near.rpc.models.RpcBlockRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcBlockResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError
import io.github.hosseinkarami_dev.near.rpc.models.RpcChunkRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcChunkResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcClientConfigError
import io.github.hosseinkarami_dev.near.rpc.models.RpcClientConfigResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcCongestionLevelRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcCongestionLevelResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcGasPriceError
import io.github.hosseinkarami_dev.near.rpc.models.RpcGasPriceRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcGasPriceResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcHealthResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientBlockProofRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientBlockProofResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientNextBlockError
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientNextBlockRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientNextBlockResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientProofError
import io.github.hosseinkarami_dev.near.rpc.models.RpcMaintenanceWindowsError
import io.github.hosseinkarami_dev.near.rpc.models.RpcMaintenanceWindowsRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcNetworkInfoError
import io.github.hosseinkarami_dev.near.rpc.models.RpcNetworkInfoResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigError
import io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError
import io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptError
import io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcSendTransactionRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcSplitStorageInfoError
import io.github.hosseinkarami_dev.near.rpc.models.RpcSplitStorageInfoRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcSplitStorageInfoResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesError
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError
import io.github.hosseinkarami_dev.near.rpc.models.RpcStatusResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError
import io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorError
import io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorsOrderedRequest
import io.github.hosseinkarami_dev.near.rpc.models.ValidatorStakeView
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import java.util.UUID
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject

public class NearClient(
    private val httpClient: HttpClient,
    private val baseUrl: String,
    private val json: Json = Json { ignoreUnknownKeys = true },
) {
    private fun nextId(): String = UUID.randomUUID().toString()

    /**
     * [Deprecated] Returns changes for a given account, contract or contract code for given block height or hash. Consider using changes instead.
     *
     * @see path: /EXPERIMENTAL_changes (method: post) — operationId: EXPERIMENTAL_changes
     *
     * @param rpcStateChangesInBlockByTypeRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest` (required).
     * @return Response: `RpcResponse<RpcStateChangesInBlockResponse>`.
     */
    @Deprecated(
        message = "[Deprecated] Returns changes for a given account, contract or contract code for given block height or hash. Consider using changes instead. — deprecated.",
        replaceWith = ReplaceWith("changes(rpcStateChangesInBlockByTypeRequest)"),
        level = DeprecationLevel.WARNING,
    )
    public suspend fun experimentalChanges(rpcStateChangesInBlockByTypeRequest: RpcStateChangesInBlockByTypeRequest): RpcResponse<RpcStateChangesInBlockResponse> {
        val request = JsonRpcRequestForExperimentalChanges(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForExperimentalChanges.Method.EXPERIMENTAL_CHANGES,
            params = rpcStateChangesInBlockByTypeRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForExperimentalChanges.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcStateChangesError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcStateChangesError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcStateChangesError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcStateChangesError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcStateChangesError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcStateChangesError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * [Deprecated] Returns changes in block for given block height or hash over all transactions for all the types. Includes changes like account_touched, access_key_touched, data_touched, contract_code_touched. Consider using block_effects instead
     *
     * @see path: /EXPERIMENTAL_changes_in_block (method: post) — operationId: EXPERIMENTAL_changes_in_block
     *
     * @param rpcStateChangesInBlockRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest` (required).
     * @return Response: `RpcResponse<RpcStateChangesInBlockByTypeResponse>`.
     */
    @Deprecated(
        message = "[Deprecated] Returns changes in block for given block height or hash over all transactions for all the types. Includes changes like account_touched, access_key_touched, data_touched, contract_code_touched. Consider using block_effects instead — deprecated.",
        replaceWith = ReplaceWith("blockEffects(rpcStateChangesInBlockRequest)"),
        level = DeprecationLevel.WARNING,
    )
    public suspend fun experimentalChangesInBlock(rpcStateChangesInBlockRequest: RpcStateChangesInBlockRequest): RpcResponse<RpcStateChangesInBlockByTypeResponse> {
        val request = JsonRpcRequestForExperimentalChangesInBlock(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForExperimentalChangesInBlock.Method.EXPERIMENTAL_CHANGES_IN_BLOCK,
            params = rpcStateChangesInBlockRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForExperimentalChangesInBlock.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcStateChangesError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcStateChangesError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcStateChangesError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcStateChangesError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcStateChangesError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcStateChangesError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Queries the congestion level of a shard. More info about congestion [here](https://near.github.io/nearcore/architecture/how/receipt-congestion.html?highlight=congestion#receipt-congestion)
     *
     * @see path: /EXPERIMENTAL_congestion_level (method: post) — operationId: EXPERIMENTAL_congestion_level
     *
     * @param rpcCongestionLevelRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcCongestionLevelRequest` (required).
     * @return Response: `RpcResponse<RpcCongestionLevelResponse>`.
     */
    public suspend fun experimentalCongestionLevel(rpcCongestionLevelRequest: RpcCongestionLevelRequest): RpcResponse<RpcCongestionLevelResponse> {
        val request = JsonRpcRequestForExperimentalCongestionLevel(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForExperimentalCongestionLevel.Method.EXPERIMENTAL_CONGESTION_LEVEL,
            params = rpcCongestionLevelRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForExperimentalCongestionLevel.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcChunkError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcChunkError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcChunkError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * [Deprecated] Get initial state and parameters for the genesis block. Consider genesis_config instead.
     *
     * @see path: /EXPERIMENTAL_genesis_config (method: post) — operationId: EXPERIMENTAL_genesis_config
     *
     * @param unit This method does not require params; the generator will send a default instance of the params wrapper in the JSON-RPC request.
     * @return Response: `RpcResponse<GenesisConfig>`.
     */
    @Deprecated(
        message = "[Deprecated] Get initial state and parameters for the genesis block. Consider genesis_config instead. — deprecated.",
        level = DeprecationLevel.WARNING,
    )
    public suspend fun experimentalGenesisConfig(): RpcResponse<GenesisConfig> {
        val request = JsonRpcRequestForExperimentalGenesisConfig(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForExperimentalGenesisConfig.Method.EXPERIMENTAL_GENESIS_CONFIG,
            params = null
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForExperimentalGenesisConfig.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(GenesisConfigError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(GenesisConfigError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForGenesisConfigAndGenesisConfigError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForGenesisConfigAndGenesisConfigError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForGenesisConfigAndGenesisConfigError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(GenesisConfigError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Returns the proofs for a transaction execution.
     *
     * @see path: /EXPERIMENTAL_light_client_block_proof (method: post) — operationId: EXPERIMENTAL_light_client_block_proof
     *
     * @param rpcLightClientBlockProofRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientBlockProofRequest` (required).
     * @return Response: `RpcResponse<RpcLightClientBlockProofResponse>`.
     */
    public suspend fun experimentalLightClientBlockProof(rpcLightClientBlockProofRequest: RpcLightClientBlockProofRequest): RpcResponse<RpcLightClientBlockProofResponse> {
        val request = JsonRpcRequestForExperimentalLightClientBlockProof(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForExperimentalLightClientBlockProof.Method.EXPERIMENTAL_LIGHT_CLIENT_BLOCK_PROOF,
            params = rpcLightClientBlockProofRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForExperimentalLightClientBlockProof.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcLightClientProofError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcLightClientProofError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcLightClientBlockProofResponseAndRpcLightClientProofError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcLightClientBlockProofResponseAndRpcLightClientProofError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcLightClientBlockProofResponseAndRpcLightClientProofError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcLightClientProofError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Returns the proofs for a transaction execution.
     *
     * @see path: /EXPERIMENTAL_light_client_proof (method: post) — operationId: EXPERIMENTAL_light_client_proof
     *
     * @param rpcLightClientExecutionProofRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest` (required).
     * @return Response: `RpcResponse<RpcLightClientExecutionProofResponse>`.
     */
    public suspend fun experimentalLightClientProof(rpcLightClientExecutionProofRequest: RpcLightClientExecutionProofRequest): RpcResponse<RpcLightClientExecutionProofResponse> {
        val request = JsonRpcRequestForExperimentalLightClientProof(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForExperimentalLightClientProof.Method.EXPERIMENTAL_LIGHT_CLIENT_PROOF,
            params = rpcLightClientExecutionProofRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForExperimentalLightClientProof.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcLightClientProofError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcLightClientProofError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcLightClientProofError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcLightClientProofError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcLightClientProofError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcLightClientProofError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * [Deprecated] Returns the future windows for maintenance in current epoch for the specified account. In the maintenance windows, the node will not be block producer or chunk producer. Consider using maintenance_windows instead.
     *
     * @see path: /EXPERIMENTAL_maintenance_windows (method: post) — operationId: EXPERIMENTAL_maintenance_windows
     *
     * @param rpcMaintenanceWindowsRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcMaintenanceWindowsRequest` (required).
     * @return Response: `RpcResponse<List<RangeOfUint64>>`.
     */
    @Deprecated(
        message = "[Deprecated] Returns the future windows for maintenance in current epoch for the specified account. In the maintenance windows, the node will not be block producer or chunk producer. Consider using maintenance_windows instead. — deprecated.",
        replaceWith = ReplaceWith("maintenanceWindows(rpcMaintenanceWindowsRequest)"),
        level = DeprecationLevel.WARNING,
    )
    public suspend fun experimentalMaintenanceWindows(rpcMaintenanceWindowsRequest: RpcMaintenanceWindowsRequest): RpcResponse<List<RangeOfUint64>> {
        val request = JsonRpcRequestForExperimentalMaintenanceWindows(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForExperimentalMaintenanceWindows.Method.EXPERIMENTAL_MAINTENANCE_WINDOWS,
            params = rpcMaintenanceWindowsRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForExperimentalMaintenanceWindows.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcMaintenanceWindowsError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcMaintenanceWindowsError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcMaintenanceWindowsError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * A configuration that defines the protocol-level parameters such as gas/storage costs, limits, feature flags, other settings
     *
     * @see path: /EXPERIMENTAL_protocol_config (method: post) — operationId: EXPERIMENTAL_protocol_config
     *
     * @param rpcProtocolConfigRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest` (required).
     * @return Response: `RpcResponse<RpcProtocolConfigResponse>`.
     */
    public suspend fun experimentalProtocolConfig(rpcProtocolConfigRequest: RpcProtocolConfigRequest): RpcResponse<RpcProtocolConfigResponse> {
        val request = JsonRpcRequestForExperimentalProtocolConfig(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForExperimentalProtocolConfig.Method.EXPERIMENTAL_PROTOCOL_CONFIG,
            params = rpcProtocolConfigRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForExperimentalProtocolConfig.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcProtocolConfigError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcProtocolConfigError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcProtocolConfigResponseAndRpcProtocolConfigError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcProtocolConfigResponseAndRpcProtocolConfigError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcProtocolConfigResponseAndRpcProtocolConfigError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcProtocolConfigError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Fetches a receipt by its ID (as is, without a status or execution outcome)
     *
     * @see path: /EXPERIMENTAL_receipt (method: post) — operationId: EXPERIMENTAL_receipt
     *
     * @param rpcReceiptRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptRequest` (required).
     * @return Response: `RpcResponse<RpcReceiptResponse>`.
     */
    public suspend fun experimentalReceipt(rpcReceiptRequest: RpcReceiptRequest): RpcResponse<RpcReceiptResponse> {
        val request = JsonRpcRequestForExperimentalReceipt(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForExperimentalReceipt.Method.EXPERIMENTAL_RECEIPT,
            params = rpcReceiptRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForExperimentalReceipt.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcReceiptError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcReceiptError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcReceiptResponseAndRpcReceiptError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcReceiptResponseAndRpcReceiptError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcReceiptResponseAndRpcReceiptError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcReceiptError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Contains the split storage information. More info on split storage [here](https://near-nodes.io/archival/split-storage-archival)
     *
     * @see path: /EXPERIMENTAL_split_storage_info (method: post) — operationId: EXPERIMENTAL_split_storage_info
     *
     * @param unit This method does not require params; the generator will send a default instance of the params wrapper in the JSON-RPC request.
     * @return Response: `RpcResponse<RpcSplitStorageInfoResponse>`.
     */
    public suspend fun experimentalSplitStorageInfo(): RpcResponse<RpcSplitStorageInfoResponse> {
        val request = JsonRpcRequestForExperimentalSplitStorageInfo(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForExperimentalSplitStorageInfo.Method.EXPERIMENTAL_SPLIT_STORAGE_INFO,
            params = RpcSplitStorageInfoRequest(value = JsonObject(emptyMap()))
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForExperimentalSplitStorageInfo.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcSplitStorageInfoError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcSplitStorageInfoError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcSplitStorageInfoError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Queries status of a transaction by hash, returning the final transaction result and details of all receipts.
     *
     * @see path: /EXPERIMENTAL_tx_status (method: post) — operationId: EXPERIMENTAL_tx_status
     *
     * @param rpcTransactionStatusRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest` (required).
     * @return Response: `RpcResponse<RpcTransactionResponse>`.
     */
    public suspend fun experimentalTxStatus(rpcTransactionStatusRequest: RpcTransactionStatusRequest): RpcResponse<RpcTransactionResponse> {
        val request = JsonRpcRequestForExperimentalTxStatus(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForExperimentalTxStatus.Method.EXPERIMENTAL_TX_STATUS,
            params = rpcTransactionStatusRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForExperimentalTxStatus.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcTransactionError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcTransactionError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcTransactionError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Returns the current epoch validators ordered in the block producer order with repetition. This endpoint is solely used for bridge currently and is not intended for other external use cases.
     *
     * @see path: /EXPERIMENTAL_validators_ordered (method: post) — operationId: EXPERIMENTAL_validators_ordered
     *
     * @param rpcValidatorsOrderedRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorsOrderedRequest` (required).
     * @return Response: `RpcResponse<List<ValidatorStakeView>>`.
     */
    public suspend fun experimentalValidatorsOrdered(rpcValidatorsOrderedRequest: RpcValidatorsOrderedRequest): RpcResponse<List<ValidatorStakeView>> {
        val request = JsonRpcRequestForExperimentalValidatorsOrdered(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForExperimentalValidatorsOrdered.Method.EXPERIMENTAL_VALIDATORS_ORDERED,
            params = rpcValidatorsOrderedRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForExperimentalValidatorsOrdered.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcValidatorError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcValidatorError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForArrayOfValidatorStakeViewAndRpcValidatorError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForArrayOfValidatorStakeViewAndRpcValidatorError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForArrayOfValidatorStakeViewAndRpcValidatorError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcValidatorError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Returns block details for given height or hash
     *
     * @see path: /block (method: post) — operationId: block
     *
     * @param rpcBlockRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcBlockRequest` (required).
     * @return Response: `RpcResponse<RpcBlockResponse>`.
     */
    public suspend fun block(rpcBlockRequest: RpcBlockRequest): RpcResponse<RpcBlockResponse> {
        val request = JsonRpcRequestForBlock(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForBlock.Method.BLOCK,
            params = rpcBlockRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForBlock.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcBlockError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcBlockError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcBlockResponseAndRpcBlockError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcBlockResponseAndRpcBlockError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcBlockResponseAndRpcBlockError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcBlockError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Returns changes in block for given block height or hash over all transactions for all the types. Includes changes like account_touched, access_key_touched, data_touched, contract_code_touched.
     *
     * @see path: /block_effects (method: post) — operationId: block_effects
     *
     * @param rpcStateChangesInBlockRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest` (required).
     * @return Response: `RpcResponse<RpcStateChangesInBlockByTypeResponse>`.
     */
    public suspend fun blockEffects(rpcStateChangesInBlockRequest: RpcStateChangesInBlockRequest): RpcResponse<RpcStateChangesInBlockByTypeResponse> {
        val request = JsonRpcRequestForBlockEffects(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForBlockEffects.Method.BLOCK_EFFECTS,
            params = rpcStateChangesInBlockRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForBlockEffects.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcStateChangesError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcStateChangesError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcStateChangesError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcStateChangesError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcStateChangesError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcStateChangesError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * [Deprecated] Sends a transaction and immediately returns transaction hash. Consider using send_tx instead.
     *
     * @see path: /broadcast_tx_async (method: post) — operationId: broadcast_tx_async
     *
     * @param rpcSendTransactionRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcSendTransactionRequest` (required).
     * @return Response: `RpcResponse<CryptoHash>`.
     */
    @Deprecated(
        message = "[Deprecated] Sends a transaction and immediately returns transaction hash. Consider using send_tx instead. — deprecated.",
        replaceWith = ReplaceWith("sendTx(rpcSendTransactionRequest)"),
        level = DeprecationLevel.WARNING,
    )
    public suspend fun broadcastTxAsync(rpcSendTransactionRequest: RpcSendTransactionRequest): RpcResponse<CryptoHash> {
        val request = JsonRpcRequestForBroadcastTxAsync(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForBroadcastTxAsync.Method.BROADCAST_TX_ASYNC,
            params = rpcSendTransactionRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForBroadcastTxAsync.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcTransactionError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcTransactionError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForCryptoHashAndRpcTransactionError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForCryptoHashAndRpcTransactionError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForCryptoHashAndRpcTransactionError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcTransactionError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * [Deprecated] Sends a transaction and waits until transaction is fully complete. (Has a 10 second timeout). Consider using send_tx instead.
     *
     * @see path: /broadcast_tx_commit (method: post) — operationId: broadcast_tx_commit
     *
     * @param rpcSendTransactionRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcSendTransactionRequest` (required).
     * @return Response: `RpcResponse<RpcTransactionResponse>`.
     */
    @Deprecated(
        message = "[Deprecated] Sends a transaction and waits until transaction is fully complete. (Has a 10 second timeout). Consider using send_tx instead. — deprecated.",
        replaceWith = ReplaceWith("sendTx(rpcSendTransactionRequest)"),
        level = DeprecationLevel.WARNING,
    )
    public suspend fun broadcastTxCommit(rpcSendTransactionRequest: RpcSendTransactionRequest): RpcResponse<RpcTransactionResponse> {
        val request = JsonRpcRequestForBroadcastTxCommit(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForBroadcastTxCommit.Method.BROADCAST_TX_COMMIT,
            params = rpcSendTransactionRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForBroadcastTxCommit.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcTransactionError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcTransactionError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcTransactionError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Returns changes for a given account, contract or contract code for given block height or hash.
     *
     * @see path: /changes (method: post) — operationId: changes
     *
     * @param rpcStateChangesInBlockByTypeRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest` (required).
     * @return Response: `RpcResponse<RpcStateChangesInBlockResponse>`.
     */
    public suspend fun changes(rpcStateChangesInBlockByTypeRequest: RpcStateChangesInBlockByTypeRequest): RpcResponse<RpcStateChangesInBlockResponse> {
        val request = JsonRpcRequestForChanges(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForChanges.Method.CHANGES,
            params = rpcStateChangesInBlockByTypeRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForChanges.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcStateChangesError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcStateChangesError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcStateChangesError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcStateChangesError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcStateChangesError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcStateChangesError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Returns details of a specific chunk. You can run a block details query to get a valid chunk hash.
     *
     * @see path: /chunk (method: post) — operationId: chunk
     *
     * @param rpcChunkRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcChunkRequest` (required).
     * @return Response: `RpcResponse<RpcChunkResponse>`.
     */
    public suspend fun chunk(rpcChunkRequest: RpcChunkRequest): RpcResponse<RpcChunkResponse> {
        val request = JsonRpcRequestForChunk(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForChunk.Method.CHUNK,
            params = rpcChunkRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForChunk.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcChunkError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcChunkError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcChunkResponseAndRpcChunkError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcChunkResponseAndRpcChunkError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcChunkResponseAndRpcChunkError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcChunkError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Queries client node configuration
     *
     * @see path: /client_config (method: post) — operationId: client_config
     *
     * @param unit This method does not require params; the generator will send a default instance of the params wrapper in the JSON-RPC request.
     * @return Response: `RpcResponse<RpcClientConfigResponse>`.
     */
    public suspend fun clientConfig(): RpcResponse<RpcClientConfigResponse> {
        val request = JsonRpcRequestForClientConfig(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForClientConfig.Method.CLIENT_CONFIG,
            params = null
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForClientConfig.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcClientConfigError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcClientConfigError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcClientConfigResponseAndRpcClientConfigError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcClientConfigResponseAndRpcClientConfigError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcClientConfigResponseAndRpcClientConfigError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcClientConfigError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Returns gas price for a specific block_height or block_hash. Using [null] will return the most recent block's gas price.
     *
     * @see path: /gas_price (method: post) — operationId: gas_price
     *
     * @param rpcGasPriceRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcGasPriceRequest` (required).
     * @return Response: `RpcResponse<RpcGasPriceResponse>`.
     */
    public suspend fun gasPrice(rpcGasPriceRequest: RpcGasPriceRequest): RpcResponse<RpcGasPriceResponse> {
        val request = JsonRpcRequestForGasPrice(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForGasPrice.Method.GAS_PRICE,
            params = rpcGasPriceRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForGasPrice.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcGasPriceError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcGasPriceError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcGasPriceResponseAndRpcGasPriceError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcGasPriceResponseAndRpcGasPriceError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcGasPriceResponseAndRpcGasPriceError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcGasPriceError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Get initial state and parameters for the genesis block
     *
     * @see path: /genesis_config (method: post) — operationId: genesis_config
     *
     * @param unit This method does not require params; the generator will send a default instance of the params wrapper in the JSON-RPC request.
     * @return Response: `RpcResponse<GenesisConfig>`.
     */
    public suspend fun genesisConfig(): RpcResponse<GenesisConfig> {
        val request = JsonRpcRequestForGenesisConfig(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForGenesisConfig.Method.GENESIS_CONFIG,
            params = null
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForGenesisConfig.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(GenesisConfigError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(GenesisConfigError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForGenesisConfigAndGenesisConfigError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForGenesisConfigAndGenesisConfigError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForGenesisConfigAndGenesisConfigError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(GenesisConfigError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Returns the current health status of the RPC node the client connects to.
     *
     * @see path: /health (method: post) — operationId: health
     *
     * @param unit This method does not require params; the generator will send a default instance of the params wrapper in the JSON-RPC request.
     * @return Response: `RpcResponse<RpcHealthResponse?>`.
     */
    public suspend fun health(): RpcResponse<RpcHealthResponse?> {
        val request = JsonRpcRequestForHealth(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForHealth.Method.HEALTH,
            params = null
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForHealth.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcStatusError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcStatusError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForNullableRpcHealthResponseAndRpcStatusError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForNullableRpcHealthResponseAndRpcStatusError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForNullableRpcHealthResponseAndRpcStatusError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcStatusError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Returns the proofs for a transaction execution.
     *
     * @see path: /light_client_proof (method: post) — operationId: light_client_proof
     *
     * @param rpcLightClientExecutionProofRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest` (required).
     * @return Response: `RpcResponse<RpcLightClientExecutionProofResponse>`.
     */
    public suspend fun lightClientProof(rpcLightClientExecutionProofRequest: RpcLightClientExecutionProofRequest): RpcResponse<RpcLightClientExecutionProofResponse> {
        val request = JsonRpcRequestForLightClientProof(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForLightClientProof.Method.LIGHT_CLIENT_PROOF,
            params = rpcLightClientExecutionProofRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForLightClientProof.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcLightClientProofError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcLightClientProofError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcLightClientProofError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcLightClientProofError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcLightClientProofError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcLightClientProofError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Returns the future windows for maintenance in current epoch for the specified account. In the maintenance windows, the node will not be block producer or chunk producer.
     *
     * @see path: /maintenance_windows (method: post) — operationId: maintenance_windows
     *
     * @param rpcMaintenanceWindowsRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcMaintenanceWindowsRequest` (required).
     * @return Response: `RpcResponse<List<RangeOfUint64>>`.
     */
    public suspend fun maintenanceWindows(rpcMaintenanceWindowsRequest: RpcMaintenanceWindowsRequest): RpcResponse<List<RangeOfUint64>> {
        val request = JsonRpcRequestForMaintenanceWindows(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForMaintenanceWindows.Method.MAINTENANCE_WINDOWS,
            params = rpcMaintenanceWindowsRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForMaintenanceWindows.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcMaintenanceWindowsError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcMaintenanceWindowsError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcMaintenanceWindowsError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Queries the current state of node network connections. This includes information about active peers, transmitted data, known producers, etc.
     *
     * @see path: /network_info (method: post) — operationId: network_info
     *
     * @param unit This method does not require params; the generator will send a default instance of the params wrapper in the JSON-RPC request.
     * @return Response: `RpcResponse<RpcNetworkInfoResponse>`.
     */
    public suspend fun networkInfo(): RpcResponse<RpcNetworkInfoResponse> {
        val request = JsonRpcRequestForNetworkInfo(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForNetworkInfo.Method.NETWORK_INFO,
            params = null
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForNetworkInfo.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcNetworkInfoError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcNetworkInfoError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcNetworkInfoResponseAndRpcNetworkInfoError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcNetworkInfoResponseAndRpcNetworkInfoError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcNetworkInfoResponseAndRpcNetworkInfoError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcNetworkInfoError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Returns the next light client block.
     *
     * @see path: /next_light_client_block (method: post) — operationId: next_light_client_block
     *
     * @param rpcLightClientNextBlockRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientNextBlockRequest` (required).
     * @return Response: `RpcResponse<RpcLightClientNextBlockResponse>`.
     */
    public suspend fun nextLightClientBlock(rpcLightClientNextBlockRequest: RpcLightClientNextBlockRequest): RpcResponse<RpcLightClientNextBlockResponse> {
        val request = JsonRpcRequestForNextLightClientBlock(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForNextLightClientBlock.Method.NEXT_LIGHT_CLIENT_BLOCK,
            params = rpcLightClientNextBlockRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForNextLightClientBlock.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcLightClientNextBlockError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcLightClientNextBlockError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcLightClientNextBlockError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcLightClientNextBlockError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcLightClientNextBlockError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcLightClientNextBlockError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * This module allows you to make generic requests to the network.
     *
     * The `RpcQueryRequest` struct takes in a [`BlockReference`](https://docs.rs/near-primitives/0.12.0/near_primitives/types/enum.BlockReference.html) and a [`QueryRequest`](https://docs.rs/near-primitives/0.12.0/near_primitives/views/enum.QueryRequest.html).
     *
     * The `BlockReference` enum allows you to specify a block by `Finality`, `BlockId` or `SyncCheckpoint`.
     *
     * The `QueryRequest` enum provides multiple variants for performing the following actions:
     *  - View an account's details
     *  - View a contract's code
     *  - View the state of an account
     *  - View the `AccessKey` of an account
     *  - View the `AccessKeyList` of an account
     *  - Call a function in a contract deployed on the network.
     *
     * @see path: /query (method: post) — operationId: query
     *
     * @param rpcQueryRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest` (required).
     * @return Response: `RpcResponse<RpcQueryResponse>`.
     */
    public suspend fun query(rpcQueryRequest: RpcQueryRequest): RpcResponse<RpcQueryResponse> {
        val request = JsonRpcRequestForQuery(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForQuery.Method.QUERY,
            params = rpcQueryRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForQuery.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcQueryError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcQueryError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcQueryResponseAndRpcQueryError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcQueryResponseAndRpcQueryError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcQueryResponseAndRpcQueryError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcQueryError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Sends transaction. Returns the guaranteed execution status and the results the blockchain can provide at the moment.
     *
     * @see path: /send_tx (method: post) — operationId: send_tx
     *
     * @param rpcSendTransactionRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcSendTransactionRequest` (required).
     * @return Response: `RpcResponse<RpcTransactionResponse>`.
     */
    public suspend fun sendTx(rpcSendTransactionRequest: RpcSendTransactionRequest): RpcResponse<RpcTransactionResponse> {
        val request = JsonRpcRequestForSendTx(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForSendTx.Method.SEND_TX,
            params = rpcSendTransactionRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForSendTx.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcTransactionError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcTransactionError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcTransactionError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Requests the status of the connected RPC node. This includes information about sync status, nearcore node version, protocol version, the current set of validators, etc.
     *
     * @see path: /status (method: post) — operationId: status
     *
     * @param unit This method does not require params; the generator will send a default instance of the params wrapper in the JSON-RPC request.
     * @return Response: `RpcResponse<RpcStatusResponse>`.
     */
    public suspend fun status(): RpcResponse<RpcStatusResponse> {
        val request = JsonRpcRequestForStatus(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForStatus.Method.STATUS,
            params = null
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForStatus.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcStatusError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcStatusError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcStatusResponseAndRpcStatusError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcStatusResponseAndRpcStatusError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcStatusResponseAndRpcStatusError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcStatusError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Queries status of a transaction by hash and returns the final transaction result.
     *
     * @see path: /tx (method: post) — operationId: tx
     *
     * @param rpcTransactionStatusRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest` (required).
     * @return Response: `RpcResponse<RpcTransactionResponse>`.
     */
    public suspend fun tx(rpcTransactionStatusRequest: RpcTransactionStatusRequest): RpcResponse<RpcTransactionResponse> {
        val request = JsonRpcRequestForTx(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForTx.Method.TX,
            params = rpcTransactionStatusRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForTx.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcTransactionError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcTransactionError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcTransactionError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }

    /**
     * Queries active validators on the network. Returns details and the state of validation on the blockchain.
     *
     * @see path: /validators (method: post) — operationId: validators
     *
     * @param rpcValidatorRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest` (required).
     * @return Response: `RpcResponse<RpcValidatorResponse>`.
     */
    public suspend fun validators(rpcValidatorRequest: RpcValidatorRequest): RpcResponse<RpcValidatorResponse> {
        val request = JsonRpcRequestForValidators(
            id = nextId(),
            jsonrpc = "2.0",
            method = JsonRpcRequestForValidators.Method.VALIDATORS,
            params = rpcValidatorRequest
        )

        try {
            val httpResponse = httpClient.post(baseUrl) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(JsonRpcRequestForValidators.serializer(), request))
            }

            val status = httpResponse.status.value
            val respBody = httpResponse.bodyAsText()

            if (status !in 200..299) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    if (root.containsKey("error")) {
                        val rpcErr = json.decodeFromString(RpcValidatorError.serializer(), root["error"].toString())
                        return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                    }
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl!!.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcValidatorError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Http(status, respBody))
            }

            try {
                val decoded = json.decodeFromString(JsonRpcResponseForRpcValidatorResponseAndRpcValidatorError.serializer(), respBody)
                return when (decoded) {
                    is JsonRpcResponseForRpcValidatorResponseAndRpcValidatorError.Result -> RpcResponse.Success(decoded.result)
                    is JsonRpcResponseForRpcValidatorResponseAndRpcValidatorError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
                }
            } catch (serEx: Exception) {
                try {
                    val root = json.parseToJsonElement(respBody).jsonObject
                    val resultEl = root["result"]
                    if (resultEl?.jsonObject?.containsKey("error") == true) {
                        val errJson = resultEl.jsonObject["error"].toString()
                        val rpcErr = runCatching { json.decodeFromString(RpcValidatorError.serializer(), errJson) }.getOrNull()
                        return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                    }
                } catch (_: Exception) { /* ignore parse error */ }
                return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
            }
        } catch (e: Throwable) {
            val mapped = when (e) {
                is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
                is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
                is java.io.IOException -> ErrorResult.Network(e)
                else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
            }
            return RpcResponse.Failure(mapped)
        }
    }
}
