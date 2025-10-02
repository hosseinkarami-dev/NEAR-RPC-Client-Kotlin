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
  public val coldHeadHeight: Long?,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("final_head_height")
  public val finalHeadHeight: Long?,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("head_height")
  public val headHeight: Long?,
  /**
   *  * Nullable: true
   */
  @SerialName("hot_db_kind")
  public val hotDbKind: String?,
)
