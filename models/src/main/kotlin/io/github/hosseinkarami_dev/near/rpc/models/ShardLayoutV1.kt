package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShardLayoutV1(
  /**
   *  * The boundary accounts are the accounts on boundaries between shards.
   * Each shard contains a range of accounts from one boundary account to
   * another - or the smallest or largest account possible. The total
   * number of shards is equal to the number of boundary accounts plus 1.
   */
  @SerialName("boundary_accounts")
  public val boundaryAccounts: List<AccountId>,
  /**
   *  * Maps shards from the last shard layout to shards that it splits to in this shard layout,
   * Useful for constructing states for the shards.
   * None for the genesis shard layout
   *  * Nullable: true
   */
  @SerialName("shards_split_map")
  public val shardsSplitMap: List<List<ShardId>>,
  /**
   *  * Maps shard in this shard layout to their parent shard
   * Since shard_ids always range from 0 to num_shards - 1, we use vec instead of a hashmap
   *  * Nullable: true
   */
  @SerialName("to_parent_shard_map")
  public val toParentShardMap: List<ShardId>,
  /**
   *  * Version of the shard layout, this is useful for uniquely identify the shard layout
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("version")
  public val version: Int,
)
