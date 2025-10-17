package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForClientConfig(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: client_config
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcClientConfigRequest,
) {
  /**
   *  * Possible values: client_config
   */
  @Serializable
  public enum class Method {
    @SerialName("client_config")
    CLIENT_CONFIG,
  }
}
