package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcError {
  @Serializable
  public class Result(
    @SerialName("result")
    public val result: RpcStateChangesInBlockByTypeResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcError()

  @Serializable
  public class Error(
    @SerialName("error")
    public val error: RpcError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcError()
}
