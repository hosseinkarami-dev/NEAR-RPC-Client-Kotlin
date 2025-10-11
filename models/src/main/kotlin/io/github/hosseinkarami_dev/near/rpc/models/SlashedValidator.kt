package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class SlashedValidator(
  @SerialName("account_id")
  public val accountId: AccountId,
  @SerialName("is_double_sign")
  public val isDoubleSign: Boolean,
)
