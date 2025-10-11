package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlin.ULong
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Describes information about the current epoch validator
 */
@Serializable
public data class CurrentEpochValidatorInfo(
  @SerialName("account_id")
  public val accountId: AccountId,
  @SerialName("is_slashed")
  public val isSlashed: Boolean,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("num_expected_blocks")
  public val numExpectedBlocks: ULong,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("num_expected_chunks")
  public val numExpectedChunks: ULong? = 0.toULong(),
  /**
   *  * Number of chunks this validator was expected to produce in each shard.
   * Each entry in the array corresponds to the shard in the `shards_produced` array.
   */
  @SerialName("num_expected_chunks_per_shard")
  public val numExpectedChunksPerShard: List<ULong>? = listOf(),
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("num_expected_endorsements")
  public val numExpectedEndorsements: ULong? = 0.toULong(),
  /**
   *  * Number of chunks this validator was expected to validate and endorse in each shard.
   * Each entry in the array corresponds to the shard in the `shards_endorsed` array.
   */
  @SerialName("num_expected_endorsements_per_shard")
  public val numExpectedEndorsementsPerShard: List<ULong>? = listOf(),
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("num_produced_blocks")
  public val numProducedBlocks: ULong,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("num_produced_chunks")
  public val numProducedChunks: ULong? = 0.toULong(),
  @SerialName("num_produced_chunks_per_shard")
  public val numProducedChunksPerShard: List<ULong>? = listOf(),
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("num_produced_endorsements")
  public val numProducedEndorsements: ULong? = 0.toULong(),
  @SerialName("num_produced_endorsements_per_shard")
  public val numProducedEndorsementsPerShard: List<ULong>? = listOf(),
  @SerialName("public_key")
  public val publicKey: PublicKey,
  /**
   *  * Shards this validator is assigned to as chunk producer in the current epoch.
   */
  @SerialName("shards")
  public val shards: List<ShardId>,
  /**
   *  * Shards this validator is assigned to as chunk validator in the current epoch.
   */
  @SerialName("shards_endorsed")
  public val shardsEndorsed: List<ShardId>? = listOf(),
  @SerialName("stake")
  public val stake: NearToken,
)
