package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForHealth(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: health
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcHealthRequest,
) {
  /**
   *  * Possible values: health
   */
  @Serializable
  public enum class Method {
    @SerialName("health")
    HEALTH,
  }
}
