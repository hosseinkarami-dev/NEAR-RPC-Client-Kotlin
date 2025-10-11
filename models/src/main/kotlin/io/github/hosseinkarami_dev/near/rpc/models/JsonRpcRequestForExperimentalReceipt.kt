package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForExperimentalReceipt(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: EXPERIMENTAL_receipt
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcReceiptRequest,
) {
  /**
   *  * Possible values: EXPERIMENTAL_receipt
   */
  @Serializable
  public enum class Method {
    @SerialName("EXPERIMENTAL_receipt")
    EXPERIMENTAL_RECEIPT,
  }
}
