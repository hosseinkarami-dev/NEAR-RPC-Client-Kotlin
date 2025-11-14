package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.ActionViewSerializer
import kotlin.String
import kotlin.UInt
import kotlin.collections.Map
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = ActionViewSerializer::class)
public sealed class ActionView {
  /**
   *  * Possible values: CreateAccount
   */
  @Serializable
  @SerialName("CreateAccount")
  public data object CreateAccount : ActionView()

  @Serializable
  public data class DeployContract(
    @SerialName("DeployContract")
    public val deployContract: DeployContractPayload,
  ) : ActionView() {
    @Serializable
    public data class DeployContractPayload(
      /**
       *  * Format: bytes
       */
      @SerialName("code")
      public val code: String,
    )
  }

  @Serializable
  public data class FunctionCall(
    @SerialName("FunctionCall")
    public val functionCall: FunctionCallPayload,
  ) : ActionView() {
    @Serializable
    public data class FunctionCallPayload(
      @SerialName("args")
      public val args: FunctionArgs,
      @SerialName("deposit")
      public val deposit: NearToken,
      @SerialName("gas")
      public val gas: NearGas,
      @SerialName("method_name")
      public val methodName: String,
    )
  }

  @Serializable
  public data class Transfer(
    @SerialName("Transfer")
    public val transfer: TransferPayload,
  ) : ActionView() {
    @Serializable
    public data class TransferPayload(
      @SerialName("deposit")
      public val deposit: NearToken,
    )
  }

  @Serializable
  public data class Stake(
    @SerialName("Stake")
    public val stake: StakePayload,
  ) : ActionView() {
    @Serializable
    public data class StakePayload(
      @SerialName("public_key")
      public val publicKey: PublicKey,
      @SerialName("stake")
      public val stake: NearToken,
    )
  }

  @Serializable
  public data class AddKey(
    @SerialName("AddKey")
    public val addKey: AddKeyPayload,
  ) : ActionView() {
    @Serializable
    public data class AddKeyPayload(
      @SerialName("access_key")
      public val accessKey: AccessKeyView,
      @SerialName("public_key")
      public val publicKey: PublicKey,
    )
  }

  @Serializable
  public data class DeleteKey(
    @SerialName("DeleteKey")
    public val deleteKey: DeleteKeyPayload,
  ) : ActionView() {
    @Serializable
    public data class DeleteKeyPayload(
      @SerialName("public_key")
      public val publicKey: PublicKey,
    )
  }

  @Serializable
  public data class DeleteAccount(
    @SerialName("DeleteAccount")
    public val deleteAccount: DeleteAccountPayload,
  ) : ActionView() {
    @Serializable
    public data class DeleteAccountPayload(
      @SerialName("beneficiary_id")
      public val beneficiaryId: AccountId,
    )
  }

  @Serializable
  public data class Delegate(
    @SerialName("Delegate")
    public val `delegate`: DelegatePayload,
  ) : ActionView() {
    @Serializable
    public data class DelegatePayload(
      @SerialName("delegate_action")
      public val delegateAction: DelegateAction,
      @SerialName("signature")
      public val signature: Signature,
    )
  }

  @Serializable
  public data class DeployGlobalContract(
    @SerialName("DeployGlobalContract")
    public val deployGlobalContract: DeployGlobalContractPayload,
  ) : ActionView() {
    @Serializable
    public data class DeployGlobalContractPayload(
      /**
       *  * Format: bytes
       */
      @SerialName("code")
      public val code: String,
    )
  }

  @Serializable
  public data class DeployGlobalContractByAccountId(
    @SerialName("DeployGlobalContractByAccountId")
    public val deployGlobalContractByAccountId: DeployGlobalContractByAccountIdPayload,
  ) : ActionView() {
    @Serializable
    public data class DeployGlobalContractByAccountIdPayload(
      /**
       *  * Format: bytes
       */
      @SerialName("code")
      public val code: String,
    )
  }

  @Serializable
  public data class UseGlobalContract(
    @SerialName("UseGlobalContract")
    public val useGlobalContract: UseGlobalContractPayload,
  ) : ActionView() {
    @Serializable
    public data class UseGlobalContractPayload(
      @SerialName("code_hash")
      public val codeHash: CryptoHash,
    )
  }

  @Serializable
  public data class UseGlobalContractByAccountId(
    @SerialName("UseGlobalContractByAccountId")
    public val useGlobalContractByAccountId: UseGlobalContractByAccountIdPayload,
  ) : ActionView() {
    @Serializable
    public data class UseGlobalContractByAccountIdPayload(
      @SerialName("account_id")
      public val accountId: AccountId,
    )
  }

  @Serializable
  public data class DeterministicStateInit(
    @SerialName("DeterministicStateInit")
    public val deterministicStateInit: DeterministicStateInitPayload,
  ) : ActionView() {
    @Serializable
    public data class DeterministicStateInitPayload(
      @SerialName("code")
      public val code: GlobalContractIdentifierView,
      @SerialName("data")
      public val `data`: Map<String, String>,
      @SerialName("deposit")
      public val deposit: NearToken,
    )
  }

  @Serializable
  public data class AddGasKey(
    @SerialName("AddGasKey")
    public val addGasKey: AddGasKeyPayload,
  ) : ActionView() {
    @Serializable
    public data class AddGasKeyPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint32
       */
      @SerialName("num_nonces")
      public val numNonces: UInt,
      @SerialName("permission")
      public val permission: AccessKeyPermissionView,
      @SerialName("public_key")
      public val publicKey: PublicKey,
    )
  }

  @Serializable
  public data class DeleteGasKey(
    @SerialName("DeleteGasKey")
    public val deleteGasKey: DeleteGasKeyPayload,
  ) : ActionView() {
    @Serializable
    public data class DeleteGasKeyPayload(
      @SerialName("public_key")
      public val publicKey: PublicKey,
    )
  }

  @Serializable
  public data class TransferToGasKey(
    @SerialName("TransferToGasKey")
    public val transferToGasKey: TransferToGasKeyPayload,
  ) : ActionView() {
    @Serializable
    public data class TransferToGasKeyPayload(
      @SerialName("amount")
      public val amount: NearToken,
      @SerialName("public_key")
      public val publicKey: PublicKey,
    )
  }
}
