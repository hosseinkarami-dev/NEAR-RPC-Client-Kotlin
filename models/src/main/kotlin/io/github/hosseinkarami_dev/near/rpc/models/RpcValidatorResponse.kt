package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Information about this epoch validators and next epoch validators
 */
@Serializable
public data class RpcValidatorResponse(
  /**
   *  * Fishermen for the current epoch
   */
  @SerialName("current_fishermen")
  public val currentFishermen: List<ValidatorStakeView>,
  /**
   *  * Proposals in the current epoch
   */
  @SerialName("current_proposals")
  public val currentProposals: List<ValidatorStakeView>,
  /**
   *  * Validators for the current epoch
   */
  @SerialName("current_validators")
  public val currentValidators: List<CurrentEpochValidatorInfo>,
  /**
   *  * Epoch height
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("epoch_height")
  public val epochHeight: Long,
  /**
   *  * Epoch start block height
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("epoch_start_height")
  public val epochStartHeight: Long,
  /**
   *  * Fishermen for the next epoch
   */
  @SerialName("next_fishermen")
  public val nextFishermen: List<ValidatorStakeView>,
  /**
   *  * Validators for the next epoch
   */
  @SerialName("next_validators")
  public val nextValidators: List<NextEpochValidatorInfo>,
  /**
   *  * Kickout in the previous epoch
   */
  @SerialName("prev_epoch_kickout")
  public val prevEpochKickout: List<ValidatorKickoutView>,
) {
  init {
    require((epochHeight?.toDouble() ?: 0.0) >= 0.0) { "RpcValidatorResponse.epochHeight must be >= 0.0" }}
  init {
    require((epochStartHeight?.toDouble() ?: 0.0) >= 0.0) { "RpcValidatorResponse.epochStartHeight must be >= 0.0" }}
}
