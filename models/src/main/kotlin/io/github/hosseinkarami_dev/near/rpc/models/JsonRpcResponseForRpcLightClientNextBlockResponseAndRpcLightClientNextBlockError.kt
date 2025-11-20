package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcLightClientNextBlockErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcLightClientNextBlockErrorSerializer::class)
public sealed class JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcLightClientNextBlockError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcLightClientNextBlockResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcLightClientNextBlockError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcLightClientNextBlockError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcLightClientNextBlockError()
}
