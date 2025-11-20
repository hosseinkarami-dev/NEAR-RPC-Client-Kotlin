package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcTransactionResponseAndRpcTransactionErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcTransactionResponseAndRpcTransactionErrorSerializer::class)
public sealed class JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcTransactionResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcTransactionError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError()
}
