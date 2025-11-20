package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcReceiptResponseAndRpcReceiptErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcReceiptResponseAndRpcReceiptErrorSerializer::class)
public sealed class JsonRpcResponseForRpcReceiptResponseAndRpcReceiptError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcReceiptResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcReceiptResponseAndRpcReceiptError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcReceiptError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcReceiptResponseAndRpcReceiptError()
}
