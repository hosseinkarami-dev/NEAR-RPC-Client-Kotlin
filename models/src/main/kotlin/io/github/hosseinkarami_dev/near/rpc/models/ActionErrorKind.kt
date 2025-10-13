package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.ActionErrorKindSerializer
import kotlin.String
import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = ActionErrorKindSerializer::class)
public sealed class ActionErrorKind {
  /**
   *  * Happens when CreateAccount action tries to create an account with account_id which is already exists in the storage
   */
  @Serializable
  public data class AccountAlreadyExists(
    @SerialName("AccountAlreadyExists")
    public val accountAlreadyExists: AccountAlreadyExistsPayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class AccountAlreadyExistsPayload(
      @SerialName("account_id")
      public val accountId: AccountId,
    )
  }

  /**
   *  * Happens when TX receiver_id doesn't exist (but action is not Action::CreateAccount)
   */
  @Serializable
  public data class AccountDoesNotExist(
    @SerialName("AccountDoesNotExist")
    public val accountDoesNotExist: AccountDoesNotExistPayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class AccountDoesNotExistPayload(
      @SerialName("account_id")
      public val accountId: AccountId,
    )
  }

  /**
   *  * A top-level account ID can only be created by registrar.
   */
  @Serializable
  public data class CreateAccountOnlyByRegistrar(
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

  /**
   *  * A newly created account must be under a namespace of the creator account
   */
  @Serializable
  public data class CreateAccountNotAllowed(
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

  /**
   *  * Administrative actions like `DeployContract`, `Stake`, `AddKey`, `DeleteKey`. can be proceed only if sender=receiver
   * or the first TX action is a `CreateAccount` action
   */
  @Serializable
  public data class ActorNoPermission(
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

  /**
   *  * Account tries to remove an access key that doesn't exist
   */
  @Serializable
  public data class DeleteKeyDoesNotExist(
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

  /**
   *  * The public key is already used for an existing access key
   */
  @Serializable
  public data class AddKeyAlreadyExists(
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

  /**
   *  * Account is staking and can not be deleted
   */
  @Serializable
  public data class DeleteAccountStaking(
    @SerialName("DeleteAccountStaking")
    public val deleteAccountStaking: DeleteAccountStakingPayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class DeleteAccountStakingPayload(
      @SerialName("account_id")
      public val accountId: AccountId,
    )
  }

  /**
   *  * ActionReceipt can't be completed, because the remaining balance will not be enough to cover storage.
   */
  @Serializable
  public data class LackBalanceForState(
    @SerialName("LackBalanceForState")
    public val lackBalanceForState: LackBalanceForStatePayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class LackBalanceForStatePayload(
      /**
       *  * An account which needs balance
       */
      @SerialName("account_id")
      public val accountId: AccountId,
      /**
       *  * Balance required to complete an action.
       */
      @SerialName("amount")
      public val amount: NearToken,
    )
  }

  /**
   *  * Account is not yet staked, but tries to unstake
   */
  @Serializable
  public data class TriesToUnstake(
    @SerialName("TriesToUnstake")
    public val triesToUnstake: TriesToUnstakePayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class TriesToUnstakePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
    )
  }

  /**
   *  * The account doesn't have enough balance to increase the stake.
   */
  @Serializable
  public data class TriesToStake(
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
  public data class InsufficientStake(
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

  /**
   *  * An error occurred during a `FunctionCall` Action, parameter is debug message.
   */
  @Serializable
  public data class FunctionCallError(
    @SerialName("FunctionCallError")
    public val functionCallError: io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError,
  ) : ActionErrorKind()

  /**
   *  * Error occurs when a new `ActionReceipt` created by the `FunctionCall` action fails
   * receipt validation.
   */
  @Serializable
  public data class NewReceiptValidationError(
    @SerialName("NewReceiptValidationError")
    public val newReceiptValidationError: ReceiptValidationError,
  ) : ActionErrorKind()

  /**
   *  * Error occurs when a `CreateAccount` action is called on a NEAR-implicit or ETH-implicit account.
   * See NEAR-implicit account creation NEP: <https://github.com/nearprotocol/NEPs/pull/71>.
   * Also, see ETH-implicit account creation NEP: <https://github.com/near/NEPs/issues/518>.
   *
   * TODO(#8598): This error is named very poorly. A better name would be
   * `OnlyNamedAccountCreationAllowed`.
   */
  @Serializable
  public data class OnlyImplicitAccountCreationAllowed(
    @SerialName("OnlyImplicitAccountCreationAllowed")
    public val onlyImplicitAccountCreationAllowed: OnlyImplicitAccountCreationAllowedPayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class OnlyImplicitAccountCreationAllowedPayload(
      @SerialName("account_id")
      public val accountId: AccountId,
    )
  }

  /**
   *  * Delete account whose state is large is temporarily banned.
   */
  @Serializable
  public data class DeleteAccountWithLargeState(
    @SerialName("DeleteAccountWithLargeState")
    public val deleteAccountWithLargeState: DeleteAccountWithLargeStatePayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class DeleteAccountWithLargeStatePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
    )
  }

  /**
   *  * Signature does not match the provided actions and given signer public key.
   *  * Possible values: DelegateActionInvalidSignature
   */
  @Serializable
  @SerialName("DelegateActionInvalidSignature")
  public data class DelegateActionInvalidSignature(
    public val `value`: String = "DelegateActionInvalidSignature",
  ) : ActionErrorKind()

  /**
   *  * Receiver of the transaction doesn't match Sender of the delegate action
   */
  @Serializable
  public data class DelegateActionSenderDoesNotMatchTxReceiver(
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

  /**
   *  * Delegate action has expired. `max_block_height` is less than actual block height.
   *  * Possible values: DelegateActionExpired
   */
  @Serializable
  @SerialName("DelegateActionExpired")
  public data class DelegateActionExpired(
    public val `value`: String = "DelegateActionExpired",
  ) : ActionErrorKind()

  /**
   *  * The given public key doesn't exist for Sender account
   */
  @Serializable
  public data class DelegateActionAccessKeyError(
    @SerialName("DelegateActionAccessKeyError")
    public val delegateActionAccessKeyError: InvalidAccessKeyError,
  ) : ActionErrorKind()

  /**
   *  * DelegateAction nonce must be greater sender[public_key].nonce
   */
  @Serializable
  public data class DelegateActionInvalidNonce(
    @SerialName("DelegateActionInvalidNonce")
    public val delegateActionInvalidNonce: DelegateActionInvalidNoncePayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class DelegateActionInvalidNoncePayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("ak_nonce")
      public val akNonce: ULong,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("delegate_nonce")
      public val delegateNonce: ULong,
    )
  }

  /**
   *  * DelegateAction nonce is larger than the upper bound given by the block height
   */
  @Serializable
  public data class DelegateActionNonceTooLarge(
    @SerialName("DelegateActionNonceTooLarge")
    public val delegateActionNonceTooLarge: DelegateActionNonceTooLargePayload,
  ) : ActionErrorKind() {
    @Serializable
    public data class DelegateActionNonceTooLargePayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("delegate_nonce")
      public val delegateNonce: ULong,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("upper_bound")
      public val upperBound: ULong,
    )
  }

  @Serializable
  public data class GlobalContractDoesNotExist(
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
