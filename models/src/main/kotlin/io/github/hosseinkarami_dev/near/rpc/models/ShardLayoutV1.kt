package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShardLayoutV1(
  @SerialName("boundary_accounts")
  public val boundaryAccounts: List<AccountId>,
  @SerialName("shards_split_map")
  public val shardsSplitMap: List<List<ShardId>>,
  @SerialName("to_parent_shard_map")
  public val toParentShardMap: List<ShardId>,
  @SerialName("version")
  public val version: Int,
)
