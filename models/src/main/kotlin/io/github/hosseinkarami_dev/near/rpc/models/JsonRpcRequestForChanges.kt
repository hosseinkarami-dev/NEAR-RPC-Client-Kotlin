package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForChanges(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: changes
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcStateChangesInBlockByTypeRequest,
) {
  /**
   *  * Possible values: changes
   */
  @Serializable
  public enum class Method {
    @SerialName("changes")
    CHANGES,
  }
}
