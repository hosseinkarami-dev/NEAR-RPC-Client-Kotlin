package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForStatus(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: status
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcStatusRequest,
) {
  /**
   *  * Possible values: status
   */
  @Serializable
  public enum class Method {
    @SerialName("status")
    STATUS,
  }
}
