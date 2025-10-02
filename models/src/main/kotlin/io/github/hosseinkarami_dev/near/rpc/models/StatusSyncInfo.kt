package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class StatusSyncInfo(
  @SerialName("earliest_block_hash")
  public val earliestBlockHash: CryptoHash? = null,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("earliest_block_height")
  public val earliestBlockHeight: Long?,
  /**
   *  * Nullable: true
   */
  @SerialName("earliest_block_time")
  public val earliestBlockTime: String?,
  @SerialName("epoch_id")
  public val epochId: EpochId? = null,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("epoch_start_height")
  public val epochStartHeight: Long?,
  @SerialName("latest_block_hash")
  public val latestBlockHash: CryptoHash,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("latest_block_height")
  public val latestBlockHeight: Long,
  @SerialName("latest_block_time")
  public val latestBlockTime: String,
  @SerialName("latest_state_root")
  public val latestStateRoot: CryptoHash,
  @SerialName("syncing")
  public val syncing: Boolean,
)
