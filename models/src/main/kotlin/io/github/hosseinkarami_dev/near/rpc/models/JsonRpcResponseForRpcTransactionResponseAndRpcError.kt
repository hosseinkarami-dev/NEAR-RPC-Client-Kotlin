package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class JsonRpcResponseForRpcTransactionResponseAndRpcError {
  @Serializable
  public class Result(
    @SerialName("result")
    public val result: RpcTransactionResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcTransactionResponseAndRpcError()

  @Serializable
  public class Error(
    @SerialName("error")
    public val error: RpcError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcTransactionResponseAndRpcError()
}
