package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.NonDelegateActionSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * An Action that can be included in a transaction or receipt, excluding delegate actions. This type represents all possible action types except DelegateAction to prevent infinite recursion in meta-transactions.
 */
@Serializable(with = NonDelegateActionSerializer::class)
public sealed class NonDelegateAction {
  /**
   *  * Create an (sub)account using a transaction `receiver_id` as an ID for
   * a new account ID must pass validation rules described here
   * <https://nomicon.io/DataStructures/Account>.
   */
  @Serializable
  public data class CreateAccount(
    @SerialName("CreateAccount")
    public val createAccount: CreateAccountAction,
  ) : NonDelegateAction()

  /**
   *  * Sets a Wasm code to a receiver_id
   */
  @Serializable
  public data class DeployContract(
    @SerialName("DeployContract")
    public val deployContract: DeployContractAction,
  ) : NonDelegateAction()

  @Serializable
  public data class FunctionCall(
    @SerialName("FunctionCall")
    public val functionCall: FunctionCallAction,
  ) : NonDelegateAction()

  @Serializable
  public data class Transfer(
    @SerialName("Transfer")
    public val transfer: TransferAction,
  ) : NonDelegateAction()

  @Serializable
  public data class Stake(
    @SerialName("Stake")
    public val stake: StakeAction,
  ) : NonDelegateAction()

  @Serializable
  public data class AddKey(
    @SerialName("AddKey")
    public val addKey: AddKeyAction,
  ) : NonDelegateAction()

  @Serializable
  public data class DeleteKey(
    @SerialName("DeleteKey")
    public val deleteKey: DeleteKeyAction,
  ) : NonDelegateAction()

  @Serializable
  public data class DeleteAccount(
    @SerialName("DeleteAccount")
    public val deleteAccount: DeleteAccountAction,
  ) : NonDelegateAction()

  @Serializable
  public data class DeployGlobalContract(
    @SerialName("DeployGlobalContract")
    public val deployGlobalContract: DeployGlobalContractAction,
  ) : NonDelegateAction()

  @Serializable
  public data class UseGlobalContract(
    @SerialName("UseGlobalContract")
    public val useGlobalContract: UseGlobalContractAction,
  ) : NonDelegateAction()

  @Serializable
  public data class DeterministicStateInit(
    @SerialName("DeterministicStateInit")
    public val deterministicStateInit: DeterministicStateInitAction,
  ) : NonDelegateAction()
}
