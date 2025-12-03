package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.UInt
import kotlin.collections.List
import kotlin.collections.Map
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Counterpart to `ShardLayoutV3` composed of maps with string keys to aid
 * serde serialization.
 */
@Serializable
public data class ShardLayoutV3(
  @SerialName("boundary_accounts")
  public val boundaryAccounts: List<AccountId>,
  @SerialName("id_to_index_map")
  public val idToIndexMap: Map<String, UInt>,
  @SerialName("last_split")
  public val lastSplit: ShardId,
  @SerialName("shard_ids")
  public val shardIds: List<ShardId>,
  @SerialName("shards_split_map")
  public val shardsSplitMap: Map<String, List<ShardId>>,
)
