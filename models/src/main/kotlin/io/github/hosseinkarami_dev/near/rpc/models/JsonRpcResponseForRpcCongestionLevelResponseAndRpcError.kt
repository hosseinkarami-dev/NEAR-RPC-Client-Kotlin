package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcCongestionLevelResponseAndRpcErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcCongestionLevelResponseAndRpcErrorSerializer::class)
public sealed class JsonRpcResponseForRpcCongestionLevelResponseAndRpcError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcCongestionLevelResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcCongestionLevelResponseAndRpcError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: RpcError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcCongestionLevelResponseAndRpcError()
}
