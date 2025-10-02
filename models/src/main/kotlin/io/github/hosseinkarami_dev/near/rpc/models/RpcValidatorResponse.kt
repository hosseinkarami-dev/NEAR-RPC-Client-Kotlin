package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcValidatorResponse(
  @SerialName("current_fishermen")
  public val currentFishermen: List<ValidatorStakeView>,
  @SerialName("current_proposals")
  public val currentProposals: List<ValidatorStakeView>,
  @SerialName("current_validators")
  public val currentValidators: List<CurrentEpochValidatorInfo>,
  @SerialName("epoch_height")
  public val epochHeight: Long,
  @SerialName("epoch_start_height")
  public val epochStartHeight: Long,
  @SerialName("next_fishermen")
  public val nextFishermen: List<ValidatorStakeView>,
  @SerialName("next_validators")
  public val nextValidators: List<NextEpochValidatorInfo>,
  @SerialName("prev_epoch_kickout")
  public val prevEpochKickout: List<ValidatorKickoutView>,
)
