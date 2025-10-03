package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
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
