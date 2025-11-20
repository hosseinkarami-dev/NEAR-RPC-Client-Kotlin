package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcStateChangesErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcStateChangesErrorSerializer::class)
public sealed class JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcStateChangesError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcStateChangesInBlockResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcStateChangesError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcStateChangesError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcStateChangesError()
}
