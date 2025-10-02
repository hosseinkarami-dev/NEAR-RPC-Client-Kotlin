package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
public data class ShardLayoutV2(
  @SerialName("boundary_accounts")
  public val boundaryAccounts: List<AccountId>,
  @SerialName("id_to_index_map")
  public val idToIndexMap: JsonElement,
  @SerialName("index_to_id_map")
  public val indexToIdMap: JsonElement,
  @SerialName("shard_ids")
  public val shardIds: List<ShardId>,
  @SerialName("shards_parent_map")
  public val shardsParentMap: JsonElement?,
  @SerialName("shards_split_map")
  public val shardsSplitMap: JsonElement?,
  @SerialName("version")
  public val version: Int,
)
