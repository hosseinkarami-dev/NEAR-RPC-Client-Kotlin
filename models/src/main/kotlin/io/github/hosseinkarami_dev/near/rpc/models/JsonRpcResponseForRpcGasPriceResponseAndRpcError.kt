package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcGasPriceResponseAndRpcErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcGasPriceResponseAndRpcErrorSerializer::class)
public sealed class JsonRpcResponseForRpcGasPriceResponseAndRpcError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcGasPriceResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcGasPriceResponseAndRpcError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: RpcError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcGasPriceResponseAndRpcError()
}
