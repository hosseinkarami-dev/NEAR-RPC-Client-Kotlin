package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Counterpart to `ShardLayoutV2` composed of maps with string keys to aid
 * serde serialization.
 */
@Serializable
public data class ShardLayoutV2(
  @SerialName("boundary_accounts")
  public val boundaryAccounts: List<AccountId>,
  @SerialName("id_to_index_map")
  public val idToIndexMap: Map<String, Int>,
  @SerialName("index_to_id_map")
  public val indexToIdMap: Map<String, ShardId>,
  @SerialName("shard_ids")
  public val shardIds: List<ShardId>,
  /**
   *  * Nullable: true
   */
  @SerialName("shards_parent_map")
  public val shardsParentMap: Map<String, ShardId>? = null,
  /**
   *  * Nullable: true
   */
  @SerialName("shards_split_map")
  public val shardsSplitMap: Map<String, List<ShardId>>? = null,
  /**
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("version")
  public val version: Int,
)
