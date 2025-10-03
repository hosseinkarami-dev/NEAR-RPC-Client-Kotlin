package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
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
  public val apply: Int,
  /**
   *  * Maximum number of "apply parts" tasks that can be performed in parallel
   * during catchup. We set this to a very low value to avoid overloading the
   * node while it is still performing normal tasks.
   *  * Minimum: 0.0
   *  * Maximum: 255.0
   *  * Format: uint8
   */
  @SerialName("apply_during_catchup")
  public val applyDuringCatchup: Int,
  /**
   *  * Maximum number of outstanding requests for decentralized state sync.
   *  * Minimum: 0.0
   *  * Maximum: 255.0
   *  * Format: uint8
   */
  @SerialName("peer_downloads")
  public val peerDownloads: Int,
  /**
   *  * The maximum parallelism to use per shard. This is mostly for fairness, because
   * the actual rate limiting is done by the TaskTrackers, but this is useful for
   * balancing the shards a little.
   *  * Minimum: 0.0
   *  * Maximum: 255.0
   *  * Format: uint8
   */
  @SerialName("per_shard")
  public val perShard: Int,
) {
  init {
    require((apply?.toDouble() ?: 0.0) >= 0.0) { "SyncConcurrency.apply must be >= 0.0" }}
  init {
    require((apply?.toDouble() ?: 0.0) <= 255.0) { "SyncConcurrency.apply must be <= 255.0" }}
  init {
    require((applyDuringCatchup?.toDouble() ?: 0.0) >= 0.0) { "SyncConcurrency.applyDuringCatchup must be >= 0.0" }}
  init {
    require((applyDuringCatchup?.toDouble() ?: 0.0) <= 255.0) { "SyncConcurrency.applyDuringCatchup must be <= 255.0" }}
  init {
    require((peerDownloads?.toDouble() ?: 0.0) >= 0.0) { "SyncConcurrency.peerDownloads must be >= 0.0" }}
  init {
    require((peerDownloads?.toDouble() ?: 0.0) <= 255.0) { "SyncConcurrency.peerDownloads must be <= 255.0" }}
  init {
    require((perShard?.toDouble() ?: 0.0) >= 0.0) { "SyncConcurrency.perShard must be >= 0.0" }}
  init {
    require((perShard?.toDouble() ?: 0.0) <= 255.0) { "SyncConcurrency.perShard must be <= 255.0" }}
}
