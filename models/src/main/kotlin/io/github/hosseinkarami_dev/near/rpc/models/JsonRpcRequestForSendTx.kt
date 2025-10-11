package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForSendTx(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: send_tx
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcSendTransactionRequest,
) {
  /**
   *  * Possible values: send_tx
   */
  @Serializable
  public enum class Method {
    @SerialName("send_tx")
    SEND_TX,
  }
}
