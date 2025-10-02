package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShardUId(
  @SerialName("shard_id")
  public val shardId: Int,
  @SerialName("version")
  public val version: Int,
)
