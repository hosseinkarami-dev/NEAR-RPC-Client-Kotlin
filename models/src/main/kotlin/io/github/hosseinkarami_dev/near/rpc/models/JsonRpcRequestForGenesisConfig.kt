package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForGenesisConfig(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: genesis_config
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: GenesisConfigRequest,
) {
  /**
   *  * Possible values: genesis_config
   */
  @Serializable
  public enum class Method {
    @SerialName("genesis_config")
    GENESIS_CONFIG,
  }
}
