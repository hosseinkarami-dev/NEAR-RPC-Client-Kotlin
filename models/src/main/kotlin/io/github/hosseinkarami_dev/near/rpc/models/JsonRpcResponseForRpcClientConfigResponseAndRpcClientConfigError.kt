package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcClientConfigResponseAndRpcClientConfigErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcClientConfigResponseAndRpcClientConfigErrorSerializer::class)
public sealed class JsonRpcResponseForRpcClientConfigResponseAndRpcClientConfigError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcClientConfigResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcClientConfigResponseAndRpcClientConfigError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcClientConfigError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcClientConfigResponseAndRpcClientConfigError()
}
