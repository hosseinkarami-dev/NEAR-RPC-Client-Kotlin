package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShardLayoutV0(
  @SerialName("num_shards")
  public val numShards: Long,
  @SerialName("version")
  public val version: Int,
)
