package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForTx(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: tx
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcTransactionStatusRequest,
) {
  /**
   *  * Possible values: tx
   */
  @Serializable
  public enum class Method {
    @SerialName("tx")
    TX,
  }
}
