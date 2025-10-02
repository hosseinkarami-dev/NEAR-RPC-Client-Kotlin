package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class BlockHeaderView(
  @SerialName("approvals")
  public val approvals: List<Signature?>,
  @SerialName("block_body_hash")
  public val blockBodyHash: CryptoHash?,
  @SerialName("block_merkle_root")
  public val blockMerkleRoot: CryptoHash,
  @SerialName("block_ordinal")
  public val blockOrdinal: Long?,
  @SerialName("challenges_result")
  public val challengesResult: List<SlashedValidator>,
  @SerialName("challenges_root")
  public val challengesRoot: CryptoHash,
  @SerialName("chunk_endorsements")
  public val chunkEndorsements: List<List<Int>>,
  @SerialName("chunk_headers_root")
  public val chunkHeadersRoot: CryptoHash,
  @SerialName("chunk_mask")
  public val chunkMask: List<Boolean>,
  @SerialName("chunk_receipts_root")
  public val chunkReceiptsRoot: CryptoHash,
  @SerialName("chunk_tx_root")
  public val chunkTxRoot: CryptoHash,
  @SerialName("chunks_included")
  public val chunksIncluded: Long,
  @SerialName("epoch_id")
  public val epochId: CryptoHash,
  @SerialName("epoch_sync_data_hash")
  public val epochSyncDataHash: CryptoHash?,
  @SerialName("gas_price")
  public val gasPrice: NearToken,
  @SerialName("hash")
  public val hash: CryptoHash,
  @SerialName("height")
  public val height: Long,
  @SerialName("last_ds_final_block")
  public val lastDsFinalBlock: CryptoHash,
  @SerialName("last_final_block")
  public val lastFinalBlock: CryptoHash,
  @SerialName("latest_protocol_version")
  public val latestProtocolVersion: Int,
  @SerialName("next_bp_hash")
  public val nextBpHash: CryptoHash,
  @SerialName("next_epoch_id")
  public val nextEpochId: CryptoHash,
  @SerialName("outcome_root")
  public val outcomeRoot: CryptoHash,
  @SerialName("prev_hash")
  public val prevHash: CryptoHash,
  @SerialName("prev_height")
  public val prevHeight: Long?,
  @SerialName("prev_state_root")
  public val prevStateRoot: CryptoHash,
  @SerialName("random_value")
  public val randomValue: CryptoHash,
  @SerialName("rent_paid")
  public val rentPaid: NearToken?,
  @SerialName("signature")
  public val signature: Signature,
  @SerialName("timestamp")
  public val timestamp: Long,
  @SerialName("timestamp_nanosec")
  public val timestampNanosec: String,
  @SerialName("total_supply")
  public val totalSupply: NearToken,
  @SerialName("validator_proposals")
  public val validatorProposals: List<ValidatorStakeView>,
  @SerialName("validator_reward")
  public val validatorReward: NearToken?,
)
