package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Account info for validators
 */
@Serializable
public data class AccountInfo(
  @SerialName("account_id")
  public val accountId: AccountId,
  @SerialName("amount")
  public val amount: NearToken,
  @SerialName("public_key")
  public val publicKey: PublicKey,
)
