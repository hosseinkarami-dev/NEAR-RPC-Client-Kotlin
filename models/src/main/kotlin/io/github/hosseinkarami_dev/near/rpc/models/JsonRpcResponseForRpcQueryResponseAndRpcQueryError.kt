package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcQueryResponseAndRpcQueryErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcQueryResponseAndRpcQueryErrorSerializer::class)
public sealed class JsonRpcResponseForRpcQueryResponseAndRpcQueryError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcQueryResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcQueryResponseAndRpcQueryError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcQueryError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcQueryResponseAndRpcQueryError()
}
