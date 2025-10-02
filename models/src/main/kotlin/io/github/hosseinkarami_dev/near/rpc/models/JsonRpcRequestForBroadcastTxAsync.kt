package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForBroadcastTxAsync(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcSendTransactionRequest,
) {
  @Serializable
  public enum class Method {
    @SerialName("broadcast_tx_async")
    BROADCAST_TX_ASYNC,
  }
}
