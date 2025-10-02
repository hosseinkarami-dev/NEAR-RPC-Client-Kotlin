package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * An Action that can be included in a transaction or receipt, excluding delegate actions. This type represents all possible action types except DelegateAction to prevent infinite recursion in meta-transactions.
 */
@Serializable
public sealed class NonDelegateAction {
  /**
   *  * Create an (sub)account using a transaction `receiver_id` as an ID for
   * a new account ID must pass validation rules described here
   * <https://nomicon.io/DataStructures/Account>.
   */
  @Serializable
  public class CreateAccount(
    @SerialName("CreateAccount")
    public val createAccount: CreateAccountAction,
  ) : NonDelegateAction()

  /**
   *  * Sets a Wasm code to a receiver_id
   */
  @Serializable
  public class DeployContract(
    @SerialName("DeployContract")
    public val deployContract: DeployContractAction,
  ) : NonDelegateAction()

  @Serializable
  public class FunctionCall(
    @SerialName("FunctionCall")
    public val functionCall: FunctionCallAction,
  ) : NonDelegateAction()

  @Serializable
  public class Transfer(
    @SerialName("Transfer")
    public val transfer: TransferAction,
  ) : NonDelegateAction()

  @Serializable
  public class Stake(
    @SerialName("Stake")
    public val stake: StakeAction,
  ) : NonDelegateAction()

  @Serializable
  public class AddKey(
    @SerialName("AddKey")
    public val addKey: AddKeyAction,
  ) : NonDelegateAction()

  @Serializable
  public class DeleteKey(
    @SerialName("DeleteKey")
    public val deleteKey: DeleteKeyAction,
  ) : NonDelegateAction()

  @Serializable
  public class DeleteAccount(
    @SerialName("DeleteAccount")
    public val deleteAccount: DeleteAccountAction,
  ) : NonDelegateAction()

  @Serializable
  public class DeployGlobalContract(
    @SerialName("DeployGlobalContract")
    public val deployGlobalContract: DeployGlobalContractAction,
  ) : NonDelegateAction()

  @Serializable
  public class UseGlobalContract(
    @SerialName("UseGlobalContract")
    public val useGlobalContract: UseGlobalContractAction,
  ) : NonDelegateAction()

  @Serializable
  public class DeterministicStateInit(
    @SerialName("DeterministicStateInit")
    public val deterministicStateInit: DeterministicStateInitAction,
  ) : NonDelegateAction()
}
