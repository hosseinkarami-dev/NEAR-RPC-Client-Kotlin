package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcErrorSerializer::class)
public sealed class JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcStateChangesInBlockResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: RpcError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcError()
}
