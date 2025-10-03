package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Contains main info about the block.
 */
@Serializable
public data class BlockHeaderView(
  @SerialName("approvals")
  public val approvals: List<Signature?>,
  @SerialName("block_body_hash")
  public val blockBodyHash: CryptoHash? = null,
  @SerialName("block_merkle_root")
  public val blockMerkleRoot: CryptoHash,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("block_ordinal")
  public val blockOrdinal: Long? = null,
  @SerialName("challenges_result")
  public val challengesResult: List<SlashedValidator>,
  @SerialName("challenges_root")
  public val challengesRoot: CryptoHash,
  /**
   *  * Nullable: true
   */
  @SerialName("chunk_endorsements")
  public val chunkEndorsements: List<List<Int>>? = null,
  @SerialName("chunk_headers_root")
  public val chunkHeadersRoot: CryptoHash,
  @SerialName("chunk_mask")
  public val chunkMask: List<Boolean>,
  @SerialName("chunk_receipts_root")
  public val chunkReceiptsRoot: CryptoHash,
  @SerialName("chunk_tx_root")
  public val chunkTxRoot: CryptoHash,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("chunks_included")
  public val chunksIncluded: Long,
  @SerialName("epoch_id")
  public val epochId: CryptoHash,
  @SerialName("epoch_sync_data_hash")
  public val epochSyncDataHash: CryptoHash? = null,
  @SerialName("gas_price")
  public val gasPrice: NearToken,
  @SerialName("hash")
  public val hash: CryptoHash,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("height")
  public val height: Long,
  @SerialName("last_ds_final_block")
  public val lastDsFinalBlock: CryptoHash,
  @SerialName("last_final_block")
  public val lastFinalBlock: CryptoHash,
  /**
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("latest_protocol_version")
  public val latestProtocolVersion: Int,
  @SerialName("next_bp_hash")
  public val nextBpHash: CryptoHash,
  @SerialName("next_epoch_id")
  public val nextEpochId: CryptoHash,
  @SerialName("outcome_root")
  public val outcomeRoot: CryptoHash,
  /**
   *  * The hash of the previous Block
   */
  @SerialName("prev_hash")
  public val prevHash: CryptoHash,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("prev_height")
  public val prevHeight: Long? = null,
  @SerialName("prev_state_root")
  public val prevStateRoot: CryptoHash,
  @SerialName("random_value")
  public val randomValue: CryptoHash,
  /**
   *  * TODO(2271): deprecated.
   */
  @SerialName("rent_paid")
  public val rentPaid: NearToken? = NearToken("0"),
  /**
   *  * Signature of the block producer.
   */
  @SerialName("signature")
  public val signature: Signature,
  /**
   *  * Legacy json number. Should not be used.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("timestamp")
  public val timestamp: Long,
  @SerialName("timestamp_nanosec")
  public val timestampNanosec: String,
  @SerialName("total_supply")
  public val totalSupply: NearToken,
  @SerialName("validator_proposals")
  public val validatorProposals: List<ValidatorStakeView>,
  /**
   *  * TODO(2271): deprecated.
   */
  @SerialName("validator_reward")
  public val validatorReward: NearToken? = NearToken("0"),
)
