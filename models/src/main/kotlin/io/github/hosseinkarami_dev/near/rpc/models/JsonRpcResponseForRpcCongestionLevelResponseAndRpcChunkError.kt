package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkErrorSerializer::class)
public sealed class JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcCongestionLevelResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcChunkError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkError()
}
