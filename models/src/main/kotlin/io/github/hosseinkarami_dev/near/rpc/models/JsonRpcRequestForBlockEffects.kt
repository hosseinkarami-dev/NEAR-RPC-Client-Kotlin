package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForBlockEffects(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: block_effects
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcStateChangesInBlockRequest,
) {
  /**
   *  * Possible values: block_effects
   */
  @Serializable
  public enum class Method {
    @SerialName("block_effects")
    BLOCK_EFFECTS,
  }
}
