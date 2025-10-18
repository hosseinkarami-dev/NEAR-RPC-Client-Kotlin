package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForMaintenanceWindows(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: maintenance_windows
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcMaintenanceWindowsRequest,
) {
  /**
   *  * Possible values: maintenance_windows
   */
  @Serializable
  public enum class Method {
    @SerialName("maintenance_windows")
    MAINTENANCE_WINDOWS,
  }
}
