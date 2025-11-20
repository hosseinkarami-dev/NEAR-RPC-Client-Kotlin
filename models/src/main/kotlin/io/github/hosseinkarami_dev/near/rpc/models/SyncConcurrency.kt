package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.UByte
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class SyncConcurrency(
  /**
   *  * Maximum number of "apply parts" tasks that can be performed in parallel.
   * This is a very disk-heavy task and therefore we set this to a low limit,
   * or else the rocksdb contention makes the whole server freeze up.
   *  * Minimum: 0.0
   *  * Maximum: 255.0
   *  * Format: uint8
   */
  @SerialName("apply")
  public val apply: UByte? = null,
  /**
   *  * Maximum number of "apply parts" tasks that can be performed in parallel
   * during catchup. We set this to a very low value to avoid overloading the
   * node while it is still performing normal tasks.
   *  * Minimum: 0.0
   *  * Maximum: 255.0
   *  * Format: uint8
   */
  @SerialName("apply_during_catchup")
  public val applyDuringCatchup: UByte? = null,
  /**
   *  * Maximum number of outstanding requests for decentralized state sync.
   *  * Minimum: 0.0
   *  * Maximum: 255.0
   *  * Format: uint8
   */
  @SerialName("peer_downloads")
  public val peerDownloads: UByte? = null,
  /**
   *  * The maximum parallelism to use per shard. This is mostly for fairness, because
   * the actual rate limiting is done by the TaskTrackers, but this is useful for
   * balancing the shards a little.
   *  * Minimum: 0.0
   *  * Maximum: 255.0
   *  * Format: uint8
   */
  @SerialName("per_shard")
  public val perShard: UByte? = null,
)
