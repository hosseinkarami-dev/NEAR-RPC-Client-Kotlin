package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ExecutionMetadataView(
  /**
   *  * Nullable: true
   */
  @SerialName("gas_profile")
  public val gasProfile: List<CostGasUsed>? = null,
  /**
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("version")
  public val version: Int,
) {
  init {
    require((version?.toDouble() ?: 0.0) >= 0.0) { "ExecutionMetadataView.version must be >= 0.0" }}
}
