package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ValidatorInfo(
  @SerialName("account_id")
  public val accountId: AccountId,
)
