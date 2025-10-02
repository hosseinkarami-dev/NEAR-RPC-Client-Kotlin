package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ValidatorStakeView(
  @SerialName("account_id")
  public val accountId: AccountId,
  @SerialName("public_key")
  public val publicKey: PublicKey,
  @SerialName("stake")
  public val stake: NearToken,
  @SerialName("validator_stake_struct_version")
  public val validatorStakeStructVersion: ValidatorStakeStructVersion,
) {
  @Serializable
  public enum class ValidatorStakeStructVersion {
    @SerialName("V1")
    V1,
  }
}
