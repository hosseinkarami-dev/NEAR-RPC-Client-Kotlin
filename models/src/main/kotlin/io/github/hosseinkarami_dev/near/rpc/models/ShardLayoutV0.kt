package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * A shard layout that maps accounts evenly across all shards -- by calculate the hash of account
 * id and mod number of shards. This is added to capture the old `account_id_to_shard_id` algorithm,
 * to keep backward compatibility for some existing tests.
 * `parent_shards` for `ShardLayoutV1` is always `None`, meaning it can only be the first shard layout
 * a chain uses.
 */
@Serializable
public data class ShardLayoutV0(
  /**
   *  * Map accounts evenly across all shards
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("num_shards")
  public val numShards: Long,
  /**
   *  * Version of the shard layout, this is useful for uniquely identify the shard layout
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("version")
  public val version: Int,
) {
  init {
    require((numShards?.toDouble() ?: 0.0) >= 0.0) { "ShardLayoutV0.numShards must be >= 0.0" }}
  init {
    require((version?.toDouble() ?: 0.0) >= 0.0) { "ShardLayoutV0.version must be >= 0.0" }}
}
