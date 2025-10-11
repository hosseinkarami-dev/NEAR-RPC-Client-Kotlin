package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForNetworkInfo(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: network_info
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcNetworkInfoRequest,
) {
  /**
   *  * Possible values: network_info
   */
  @Serializable
  public enum class Method {
    @SerialName("network_info")
    NETWORK_INFO,
  }
}
