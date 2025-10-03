package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Contains the split storage information.
 */
@Serializable
public data class RpcSplitStorageInfoResponse(
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("cold_head_height")
  public val coldHeadHeight: Long? = null,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("final_head_height")
  public val finalHeadHeight: Long? = null,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("head_height")
  public val headHeight: Long? = null,
  /**
   *  * Nullable: true
   */
  @SerialName("hot_db_kind")
  public val hotDbKind: String? = null,
) {
  init {
    require((coldHeadHeight?.toDouble() ?: 0.0) >= 0.0) { "RpcSplitStorageInfoResponse.coldHeadHeight must be >= 0.0" }}
  init {
    require((finalHeadHeight?.toDouble() ?: 0.0) >= 0.0) { "RpcSplitStorageInfoResponse.finalHeadHeight must be >= 0.0" }}
  init {
    require((headHeight?.toDouble() ?: 0.0) >= 0.0) { "RpcSplitStorageInfoResponse.headHeight must be >= 0.0" }}
}
