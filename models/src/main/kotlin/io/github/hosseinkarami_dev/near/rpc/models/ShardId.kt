package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.ULong
import kotlin.jvm.JvmInline
import kotlinx.serialization.Serializable

/**
 *  * The shard identifier. It may be an arbitrary number - it does not need to be
 * a number in the range 0..NUM_SHARDS. The shard ids do not need to be
 * sequential or contiguous.
 *
 * The shard id is wrapped in a new type to prevent the old pattern of using
 * indices in range 0..NUM_SHARDS and casting to ShardId. Once the transition
 * if fully complete it potentially may be simplified to a regular type alias.
 *  * Minimum: 0.0
 *  * Format: uint64
 */
@Serializable
@JvmInline
public value class ShardId(
  public val `value`: ULong,
)
