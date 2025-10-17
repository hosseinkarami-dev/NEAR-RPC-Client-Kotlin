package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForQuery(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: query
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcQueryRequest,
) {
  /**
   *  * Possible values: query
   */
  @Serializable
  public enum class Method {
    @SerialName("query")
    QUERY,
  }
}
