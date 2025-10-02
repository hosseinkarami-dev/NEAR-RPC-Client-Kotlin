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
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcCongestionLevelRequest,
) {
  @Serializable
  public enum class Method {
    @SerialName("EXPERIMENTAL_congestion_level")
    EXPERIMENTAL_CONGESTION_LEVEL,
  }
}
