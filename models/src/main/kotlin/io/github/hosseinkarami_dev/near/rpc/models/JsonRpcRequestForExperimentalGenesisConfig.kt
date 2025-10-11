package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForExperimentalGenesisConfig(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: EXPERIMENTAL_genesis_config
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: GenesisConfigRequest,
) {
  /**
   *  * Possible values: EXPERIMENTAL_genesis_config
   */
  @Serializable
  public enum class Method {
    @SerialName("EXPERIMENTAL_genesis_config")
    EXPERIMENTAL_GENESIS_CONFIG,
  }
}
