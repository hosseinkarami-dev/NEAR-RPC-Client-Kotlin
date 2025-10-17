package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.ULong
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Contains main info about the chunk.
 */
@Serializable
public data class ChunkHeaderView(
  @SerialName("balance_burnt")
  public val balanceBurnt: NearToken,
  @SerialName("bandwidth_requests")
  public val bandwidthRequests: BandwidthRequests? = null,
  @SerialName("chunk_hash")
  public val chunkHash: CryptoHash,
  @SerialName("congestion_info")
  public val congestionInfo: CongestionInfoView? = null,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("encoded_length")
  public val encodedLength: ULong,
  @SerialName("encoded_merkle_root")
  public val encodedMerkleRoot: CryptoHash,
  @SerialName("gas_limit")
  public val gasLimit: NearGas,
  @SerialName("gas_used")
  public val gasUsed: NearGas,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("height_created")
  public val heightCreated: ULong,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("height_included")
  public val heightIncluded: ULong,
  @SerialName("outcome_root")
  public val outcomeRoot: CryptoHash,
  @SerialName("outgoing_receipts_root")
  public val outgoingReceiptsRoot: CryptoHash,
  @SerialName("prev_block_hash")
  public val prevBlockHash: CryptoHash,
  @SerialName("prev_state_root")
  public val prevStateRoot: CryptoHash,
  /**
   *  * TODO(2271): deprecated.
   */
  @SerialName("rent_paid")
  public val rentPaid: NearToken? = NearToken("0"),
  @SerialName("shard_id")
  public val shardId: ShardId,
  @SerialName("signature")
  public val signature: Signature,
  @SerialName("tx_root")
  public val txRoot: CryptoHash,
  @SerialName("validator_proposals")
  public val validatorProposals: List<ValidatorStakeView>,
  /**
   *  * TODO(2271): deprecated.
   */
  @SerialName("validator_reward")
  public val validatorReward: NearToken? = NearToken("0"),
)
