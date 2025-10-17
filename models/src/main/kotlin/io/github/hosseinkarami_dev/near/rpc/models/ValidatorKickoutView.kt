package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ValidatorKickoutView(
  @SerialName("account_id")
  public val accountId: AccountId,
  @SerialName("reason")
  public val reason: ValidatorKickoutReason,
)
