package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ValidatorStakeViewV1(
  @SerialName("account_id")
  public val accountId: AccountId,
  @SerialName("public_key")
  public val publicKey: PublicKey,
  @SerialName("stake")
  public val stake: NearToken,
)
