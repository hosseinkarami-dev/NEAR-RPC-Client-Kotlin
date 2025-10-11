package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForNextLightClientBlock(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: next_light_client_block
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcLightClientNextBlockRequest,
) {
  /**
   *  * Possible values: next_light_client_block
   */
  @Serializable
  public enum class Method {
    @SerialName("next_light_client_block")
    NEXT_LIGHT_CLIENT_BLOCK,
  }
}
