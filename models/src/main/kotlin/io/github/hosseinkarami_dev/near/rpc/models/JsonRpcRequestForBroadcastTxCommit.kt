package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForBroadcastTxCommit(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: broadcast_tx_commit
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcSendTransactionRequest,
) {
  /**
   *  * Possible values: broadcast_tx_commit
   */
  @Serializable
  public enum class Method {
    @SerialName("broadcast_tx_commit")
    BROADCAST_TX_COMMIT,
  }
}
