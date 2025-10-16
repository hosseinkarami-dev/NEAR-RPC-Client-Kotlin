package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForExperimentalTxStatus(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: EXPERIMENTAL_tx_status
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcTransactionStatusRequest,
) {
  /**
   *  * Possible values: EXPERIMENTAL_tx_status
   */
  @Serializable
  public enum class Method {
    @SerialName("EXPERIMENTAL_tx_status")
    EXPERIMENTAL_TX_STATUS,
  }
}
