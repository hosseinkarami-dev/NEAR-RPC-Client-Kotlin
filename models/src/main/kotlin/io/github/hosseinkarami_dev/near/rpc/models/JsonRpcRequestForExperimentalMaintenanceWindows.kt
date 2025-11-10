package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForExperimentalMaintenanceWindows(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: EXPERIMENTAL_maintenance_windows
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcMaintenanceWindowsRequest,
) {
  /**
   *  * Possible values: EXPERIMENTAL_maintenance_windows
   */
  @Serializable
  public enum class Method {
    @SerialName("EXPERIMENTAL_maintenance_windows")
    EXPERIMENTAL_MAINTENANCE_WINDOWS,
  }
}
