package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class NonDelegateAction {
  @Serializable
  public class CreateAccount(
    @SerialName("CreateAccount")
    public val createAccount: CreateAccountAction,
  ) : NonDelegateAction()

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
