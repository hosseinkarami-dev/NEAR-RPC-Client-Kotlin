package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForChunk(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: chunk
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcChunkRequest,
) {
  /**
   *  * Possible values: chunk
   */
  @Serializable
  public enum class Method {
    @SerialName("chunk")
    CHUNK,
  }
}
