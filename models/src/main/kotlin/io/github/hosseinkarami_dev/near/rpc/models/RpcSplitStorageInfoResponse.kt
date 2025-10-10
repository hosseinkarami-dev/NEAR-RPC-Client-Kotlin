package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.ULong
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
  public val coldHeadHeight: ULong? = null,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("final_head_height")
  public val finalHeadHeight: ULong? = null,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("head_height")
  public val headHeight: ULong? = null,
  /**
   *  * Nullable: true
   */
  @SerialName("hot_db_kind")
  public val hotDbKind: String? = null,
)
