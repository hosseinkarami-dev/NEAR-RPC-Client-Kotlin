package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsErrorSerializer
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsErrorSerializer::class)
public sealed class JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: List<RangeOfUint64>,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcMaintenanceWindowsError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError()
}
