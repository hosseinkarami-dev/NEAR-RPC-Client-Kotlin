package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlin.Long
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class CurrentEpochValidatorInfo(
  @SerialName("account_id")
  public val accountId: AccountId,
  @SerialName("is_slashed")
  public val isSlashed: Boolean,
  @SerialName("num_expected_blocks")
  public val numExpectedBlocks: Long,
  @SerialName("num_expected_chunks")
  public val numExpectedChunks: Long?,
  @SerialName("num_expected_chunks_per_shard")
  public val numExpectedChunksPerShard: List<Long>,
  @SerialName("num_expected_endorsements")
  public val numExpectedEndorsements: Long?,
  @SerialName("num_expected_endorsements_per_shard")
  public val numExpectedEndorsementsPerShard: List<Long>,
  @SerialName("num_produced_blocks")
  public val numProducedBlocks: Long,
  @SerialName("num_produced_chunks")
  public val numProducedChunks: Long?,
  @SerialName("num_produced_chunks_per_shard")
  public val numProducedChunksPerShard: List<Long>,
  @SerialName("num_produced_endorsements")
  public val numProducedEndorsements: Long?,
  @SerialName("num_produced_endorsements_per_shard")
  public val numProducedEndorsementsPerShard: List<Long>,
  @SerialName("public_key")
  public val publicKey: PublicKey,
  @SerialName("shards")
  public val shards: List<ShardId>,
  @SerialName("shards_endorsed")
  public val shardsEndorsed: List<ShardId>,
  @SerialName("stake")
  public val stake: NearToken,
)
