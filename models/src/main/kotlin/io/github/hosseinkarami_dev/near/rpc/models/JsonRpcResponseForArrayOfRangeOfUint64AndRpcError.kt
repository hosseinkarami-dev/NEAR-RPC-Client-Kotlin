package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForArrayOfRangeOfUint64AndRpcErrorSerializer
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForArrayOfRangeOfUint64AndRpcErrorSerializer::class)
public sealed class JsonRpcResponseForArrayOfRangeOfUint64AndRpcError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: List<RangeOfUint64>,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForArrayOfRangeOfUint64AndRpcError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: RpcError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForArrayOfRangeOfUint64AndRpcError()
}
