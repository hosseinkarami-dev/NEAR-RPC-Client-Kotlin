package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForExperimentalCongestionLevel(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: EXPERIMENTAL_congestion_level
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcCongestionLevelRequest,
) {
  /**
   *  * Possible values: EXPERIMENTAL_congestion_level
   */
  @Serializable
  public enum class Method {
    @SerialName("EXPERIMENTAL_congestion_level")
    EXPERIMENTAL_CONGESTION_LEVEL,
  }
}
