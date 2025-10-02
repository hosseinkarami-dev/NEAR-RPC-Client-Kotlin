package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class BlockHeaderInnerLiteView(
  @SerialName("block_merkle_root")
  public val blockMerkleRoot: CryptoHash,
  @SerialName("epoch_id")
  public val epochId: CryptoHash,
  @SerialName("height")
  public val height: Long,
  @SerialName("next_bp_hash")
  public val nextBpHash: CryptoHash,
  @SerialName("next_epoch_id")
  public val nextEpochId: CryptoHash,
  @SerialName("outcome_root")
  public val outcomeRoot: CryptoHash,
  @SerialName("prev_state_root")
  public val prevStateRoot: CryptoHash,
  @SerialName("timestamp")
  public val timestamp: Long,
  @SerialName("timestamp_nanosec")
  public val timestampNanosec: String,
)
