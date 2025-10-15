package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForNullableRpcHealthResponseAndRpcErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForNullableRpcHealthResponseAndRpcErrorSerializer::class)
public sealed class JsonRpcResponseForNullableRpcHealthResponseAndRpcError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcHealthResponse? = null,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForNullableRpcHealthResponseAndRpcError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: RpcError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForNullableRpcHealthResponseAndRpcError()
}
