package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class ActionErrorKind {
  @Serializable
  public class AccountAlreadyExists(
    @SerialName("AccountAlreadyExists")
    public val accountAlreadyExists: AccountAlreadyExistsPayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class AccountAlreadyExistsPayload(
      @SerialName("account_id")
      public val accountId: AccountId,
    )
  }

  @Serializable
  public class AccountDoesNotExist(
    @SerialName("AccountDoesNotExist")
    public val accountDoesNotExist: AccountDoesNotExistPayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class AccountDoesNotExistPayload(
      @SerialName("account_id")
      public val accountId: AccountId,
    )
  }

  @Serializable
  public class CreateAccountOnlyByRegistrar(
    @SerialName("CreateAccountOnlyByRegistrar")
    public val createAccountOnlyByRegistrar: CreateAccountOnlyByRegistrarPayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class CreateAccountOnlyByRegistrarPayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("predecessor_id")
      public val predecessorId: AccountId,
      @SerialName("registrar_account_id")
      public val registrarAccountId: AccountId,
    )
  }

  @Serializable
  public class CreateAccountNotAllowed(
    @SerialName("CreateAccountNotAllowed")
    public val createAccountNotAllowed: CreateAccountNotAllowedPayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class CreateAccountNotAllowedPayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("predecessor_id")
      public val predecessorId: AccountId,
    )
  }

  @Serializable
  public class ActorNoPermission(
    @SerialName("ActorNoPermission")
    public val actorNoPermission: ActorNoPermissionPayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class ActorNoPermissionPayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("actor_id")
      public val actorId: AccountId,
    )
  }

  @Serializable
  public class DeleteKeyDoesNotExist(
    @SerialName("DeleteKeyDoesNotExist")
    public val deleteKeyDoesNotExist: DeleteKeyDoesNotExistPayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class DeleteKeyDoesNotExistPayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("public_key")
      public val publicKey: PublicKey,
    )
  }

  @Serializable
  public class AddKeyAlreadyExists(
    @SerialName("AddKeyAlreadyExists")
    public val addKeyAlreadyExists: AddKeyAlreadyExistsPayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class AddKeyAlreadyExistsPayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("public_key")
      public val publicKey: PublicKey,
    )
  }

  @Serializable
  public class DeleteAccountStaking(
    @SerialName("DeleteAccountStaking")
    public val deleteAccountStaking: DeleteAccountStakingPayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class DeleteAccountStakingPayload(
      @SerialName("account_id")
      public val accountId: AccountId,
    )
  }

  @Serializable
  public class LackBalanceForState(
    @SerialName("LackBalanceForState")
    public val lackBalanceForState: LackBalanceForStatePayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class LackBalanceForStatePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("amount")
      public val amount: NearToken,
    )
  }

  @Serializable
  public class TriesToUnstake(
    @SerialName("TriesToUnstake")
    public val triesToUnstake: TriesToUnstakePayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class TriesToUnstakePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
    )
  }

  @Serializable
  public class TriesToStake(
    @SerialName("TriesToStake")
    public val triesToStake: TriesToStakePayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class TriesToStakePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("balance")
      public val balance: NearToken,
      @SerialName("locked")
      public val locked: NearToken,
      @SerialName("stake")
      public val stake: NearToken,
    )
  }

  @Serializable
  public class InsufficientStake(
    @SerialName("InsufficientStake")
    public val insufficientStake: InsufficientStakePayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class InsufficientStakePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("minimum_stake")
      public val minimumStake: NearToken,
      @SerialName("stake")
      public val stake: NearToken,
    )
  }

  @Serializable
  public class FunctionCallError(
    @SerialName("FunctionCallError")
    public val functionCallError: io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError,
  ) : ActionErrorKind()

  @Serializable
  public class NewReceiptValidationError(
    @SerialName("NewReceiptValidationError")
    public val newReceiptValidationError: ReceiptValidationError,
  ) : ActionErrorKind()

  @Serializable
  public class OnlyImplicitAccountCreationAllowed(
    @SerialName("OnlyImplicitAccountCreationAllowed")
    public val onlyImplicitAccountCreationAllowed: OnlyImplicitAccountCreationAllowedPayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class OnlyImplicitAccountCreationAllowedPayload(
      @SerialName("account_id")
      public val accountId: AccountId,
    )
  }

  @Serializable
  public class DeleteAccountWithLargeState(
    @SerialName("DeleteAccountWithLargeState")
    public val deleteAccountWithLargeState: DeleteAccountWithLargeStatePayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class DeleteAccountWithLargeStatePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
    )
  }

  @Serializable
  @SerialName("DelegateActionInvalidSignature")
  public object DelegateActionInvalidSignature : ActionErrorKind()

  @Serializable
  public class DelegateActionSenderDoesNotMatchTxReceiver(
    @SerialName("DelegateActionSenderDoesNotMatchTxReceiver")
    public val delegateActionSenderDoesNotMatchTxReceiver:
        DelegateActionSenderDoesNotMatchTxReceiverPayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class DelegateActionSenderDoesNotMatchTxReceiverPayload(
      @SerialName("receiver_id")
      public val receiverId: AccountId,
      @SerialName("sender_id")
      public val senderId: AccountId,
    )
  }

  @Serializable
  @SerialName("DelegateActionExpired")
  public object DelegateActionExpired : ActionErrorKind()

  @Serializable
  public class DelegateActionAccessKeyError(
    @SerialName("DelegateActionAccessKeyError")
    public val delegateActionAccessKeyError: InvalidAccessKeyError,
  ) : ActionErrorKind()

  @Serializable
  public class DelegateActionInvalidNonce(
    @SerialName("DelegateActionInvalidNonce")
    public val delegateActionInvalidNonce: DelegateActionInvalidNoncePayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class DelegateActionInvalidNoncePayload(
      @SerialName("ak_nonce")
      public val akNonce: Long,
      @SerialName("delegate_nonce")
      public val delegateNonce: Long,
    )
  }

  @Serializable
  public class DelegateActionNonceTooLarge(
    @SerialName("DelegateActionNonceTooLarge")
    public val delegateActionNonceTooLarge: DelegateActionNonceTooLargePayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class DelegateActionNonceTooLargePayload(
      @SerialName("delegate_nonce")
      public val delegateNonce: Long,
      @SerialName("upper_bound")
      public val upperBound: Long,
    )
  }

  @Serializable
  public class GlobalContractDoesNotExist(
    @SerialName("GlobalContractDoesNotExist")
    public val globalContractDoesNotExist: GlobalContractDoesNotExistPayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class GlobalContractDoesNotExistPayload(
      @SerialName("identifier")
      public val identifier: GlobalContractIdentifier,
    )
  }
}
