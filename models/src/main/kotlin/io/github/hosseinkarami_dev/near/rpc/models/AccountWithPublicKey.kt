package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Account ID with its public key.
 */
@Serializable
public data class AccountWithPublicKey(
  @SerialName("account_id")
  public val accountId: AccountId,
  @SerialName("public_key")
  public val publicKey: PublicKey,
)
