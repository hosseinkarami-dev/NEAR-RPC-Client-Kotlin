package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.GlobalContractDeployModeSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = GlobalContractDeployModeSerializer::class)
public sealed class GlobalContractDeployMode {
  /**
   *  * Contract is deployed under its code hash.
   * Users will be able reference it by that hash.
   * This effectively makes the contract immutable.
   *  * Possible values: CodeHash
   */
  @Serializable
  @SerialName("CodeHash")
  public data class CodeHash(
    public val `value`: String = "CodeHash",
  ) : GlobalContractDeployMode()

  /**
   *  * Contract is deployed under the owner account id.
   * Users will be able reference it by that account id.
   * This allows the owner to update the contract for all its users.
   *  * Possible values: AccountId
   */
  @Serializable
  @SerialName("AccountId")
  public data class AccountId(
    public val `value`: String = "AccountId",
  ) : GlobalContractDeployMode()
}
