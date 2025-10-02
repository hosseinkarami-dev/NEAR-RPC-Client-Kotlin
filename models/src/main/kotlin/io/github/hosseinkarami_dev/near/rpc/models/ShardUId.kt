package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * `ShardUId` is a unique representation for shards from different shard layouts.
 *
 * Comparing to `ShardId`, which is just an ordinal number ranging from 0 to NUM_SHARDS-1,
 * `ShardUId` provides a way to unique identify shards when shard layouts may change across epochs.
 * This is important because we store states indexed by shards in our database, so we need a
 * way to unique identify shard even when shards change across epochs.
 * Another difference between `ShardUId` and `ShardId` is that `ShardUId` should only exist in
 * a node's internal state while `ShardId` can be exposed to outside APIs and used in protocol
 * level information (for example, `ShardChunkHeader` contains `ShardId` instead of `ShardUId`)
 */
@Serializable
public data class ShardUId(
  /**
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("shard_id")
  public val shardId: Int,
  /**
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("version")
  public val version: Int,
)
