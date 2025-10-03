package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * A part of a state for the current head of a light client. More info [here](https://nomicon.io/ChainSpec/LightClient).
 */
@Serializable
public data class BlockHeaderInnerLiteView(
  /**
   *  * The merkle root of all the block hashes
   */
  @SerialName("block_merkle_root")
  public val blockMerkleRoot: CryptoHash,
  /**
   *  * The epoch to which the block that is the current known head belongs
   */
  @SerialName("epoch_id")
  public val epochId: CryptoHash,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("height")
  public val height: Long,
  /**
   *  * The hash of the block producers set for the next epoch
   */
  @SerialName("next_bp_hash")
  public val nextBpHash: CryptoHash,
  /**
   *  * The epoch that will follow the current epoch
   */
  @SerialName("next_epoch_id")
  public val nextEpochId: CryptoHash,
  @SerialName("outcome_root")
  public val outcomeRoot: CryptoHash,
  @SerialName("prev_state_root")
  public val prevStateRoot: CryptoHash,
  /**
   *  * Legacy json number. Should not be used.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("timestamp")
  public val timestamp: Long,
  @SerialName("timestamp_nanosec")
  public val timestampNanosec: String,
) {
  init {
    require((height?.toDouble() ?: 0.0) >= 0.0) { "BlockHeaderInnerLiteView.height must be >= 0.0" }}
  init {
    require((timestamp?.toDouble() ?: 0.0) >= 0.0) { "BlockHeaderInnerLiteView.timestamp must be >= 0.0" }}
}
