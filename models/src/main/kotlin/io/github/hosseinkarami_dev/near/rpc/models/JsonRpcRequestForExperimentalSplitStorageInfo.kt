package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForExperimentalSplitStorageInfo(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: EXPERIMENTAL_split_storage_info
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcSplitStorageInfoRequest,
) {
  /**
   *  * Possible values: EXPERIMENTAL_split_storage_info
   */
  @Serializable
  public enum class Method {
    @SerialName("EXPERIMENTAL_split_storage_info")
    EXPERIMENTAL_SPLIT_STORAGE_INFO,
  }
}
