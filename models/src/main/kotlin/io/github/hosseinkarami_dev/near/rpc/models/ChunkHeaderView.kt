package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ChunkHeaderView(
  @SerialName("balance_burnt")
  public val balanceBurnt: NearToken,
  @SerialName("bandwidth_requests")
  public val bandwidthRequests: BandwidthRequests?,
  @SerialName("chunk_hash")
  public val chunkHash: CryptoHash,
  @SerialName("congestion_info")
  public val congestionInfo: CongestionInfoView?,
  @SerialName("encoded_length")
  public val encodedLength: Long,
  @SerialName("encoded_merkle_root")
  public val encodedMerkleRoot: CryptoHash,
  @SerialName("gas_limit")
  public val gasLimit: NearGas,
  @SerialName("gas_used")
  public val gasUsed: NearGas,
  @SerialName("height_created")
  public val heightCreated: Long,
  @SerialName("height_included")
  public val heightIncluded: Long,
  @SerialName("outcome_root")
  public val outcomeRoot: CryptoHash,
  @SerialName("outgoing_receipts_root")
  public val outgoingReceiptsRoot: CryptoHash,
  @SerialName("prev_block_hash")
  public val prevBlockHash: CryptoHash,
  @SerialName("prev_state_root")
  public val prevStateRoot: CryptoHash,
  @SerialName("rent_paid")
  public val rentPaid: NearToken?,
  @SerialName("shard_id")
  public val shardId: ShardId,
  @SerialName("signature")
  public val signature: Signature,
  @SerialName("tx_root")
  public val txRoot: CryptoHash,
  @SerialName("validator_proposals")
  public val validatorProposals: List<ValidatorStakeView>,
  @SerialName("validator_reward")
  public val validatorReward: NearToken?,
)
