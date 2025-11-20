package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcChunkResponseAndRpcChunkErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcChunkResponseAndRpcChunkErrorSerializer::class)
public sealed class JsonRpcResponseForRpcChunkResponseAndRpcChunkError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcChunkResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcChunkResponseAndRpcChunkError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcChunkError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcChunkResponseAndRpcChunkError()
}
