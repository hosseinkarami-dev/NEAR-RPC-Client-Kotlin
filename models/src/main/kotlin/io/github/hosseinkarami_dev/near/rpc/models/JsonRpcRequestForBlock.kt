package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForBlock(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: block
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcBlockRequest,
) {
  /**
   *  * Possible values: block
   */
  @Serializable
  public enum class Method {
    @SerialName("block")
    BLOCK,
  }
}
