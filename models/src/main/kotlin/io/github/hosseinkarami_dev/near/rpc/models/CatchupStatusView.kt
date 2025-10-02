package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Status of the [catchup](https://near.github.io/nearcore/architecture/how/sync.html#catchup) process
 */
@Serializable
public data class CatchupStatusView(
  @SerialName("blocks_to_catchup")
  public val blocksToCatchup: List<BlockStatusView>,
  @SerialName("shard_sync_status")
  public val shardSyncStatus: Map<String, String>,
  @SerialName("sync_block_hash")
  public val syncBlockHash: CryptoHash,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("sync_block_height")
  public val syncBlockHeight: Long,
)
