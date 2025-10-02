package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class AccountCreationConfigView(
  @SerialName("min_allowed_top_level_account_length")
  public val minAllowedTopLevelAccountLength: Int,
  @SerialName("registrar_account_id")
  public val registrarAccountId: AccountId,
)
