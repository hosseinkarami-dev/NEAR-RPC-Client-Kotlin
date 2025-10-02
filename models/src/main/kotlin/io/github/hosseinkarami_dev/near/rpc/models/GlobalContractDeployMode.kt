package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class GlobalContractDeployMode {
  /**
   *  * Contract is deployed under its code hash.
   * Users will be able reference it by that hash.
   * This effectively makes the contract immutable.
   *  * Possible values: CodeHash
   */
  @Serializable
  @SerialName("CodeHash")
  public object CodeHash : GlobalContractDeployMode()

  /**
   *  * Contract is deployed under the owner account id.
   * Users will be able reference it by that account id.
   * This allows the owner to update the contract for all its users.
   *  * Possible values: AccountId
   */
  @Serializable
  @SerialName("AccountId")
  public object AccountId : GlobalContractDeployMode()
}
