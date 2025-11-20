package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcGasPriceResponseAndRpcGasPriceErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcGasPriceResponseAndRpcGasPriceErrorSerializer::class)
public sealed class JsonRpcResponseForRpcGasPriceResponseAndRpcGasPriceError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcGasPriceResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcGasPriceResponseAndRpcGasPriceError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcGasPriceError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcGasPriceResponseAndRpcGasPriceError()
}
