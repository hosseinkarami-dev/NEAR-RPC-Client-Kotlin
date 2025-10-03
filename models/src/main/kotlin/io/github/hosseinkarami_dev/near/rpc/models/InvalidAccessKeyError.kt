package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class InvalidAccessKeyError {
  /**
   *  * The access key identified by the `public_key` doesn't exist for the account
   */
  @Serializable
  public data class AccessKeyNotFound(
    @SerialName("AccessKeyNotFound")
    public val accessKeyNotFound: AccessKeyNotFoundPayload,
  ) : InvalidAccessKeyError() {
    @Serializable
    public data class AccessKeyNotFoundPayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("public_key")
      public val publicKey: PublicKey,
    )
  }

  /**
   *  * Transaction `receiver_id` doesn't match the access key receiver_id
   */
  @Serializable
  public data class ReceiverMismatch(
    @SerialName("ReceiverMismatch")
    public val receiverMismatch: ReceiverMismatchPayload,
  ) : InvalidAccessKeyError() {
    @Serializable
    public data class ReceiverMismatchPayload(
      @SerialName("ak_receiver")
      public val akReceiver: String,
      @SerialName("tx_receiver")
      public val txReceiver: AccountId,
    )
  }

  /**
   *  * Transaction method name isn't allowed by the access key
   */
  @Serializable
  public data class MethodNameMismatch(
    @SerialName("MethodNameMismatch")
    public val methodNameMismatch: MethodNameMismatchPayload,
  ) : InvalidAccessKeyError() {
    @Serializable
    public data class MethodNameMismatchPayload(
      @SerialName("method_name")
      public val methodName: String,
    )
  }

  /**
   *  * Transaction requires a full permission access key.
   *  * Possible values: RequiresFullAccess
   */
  @Serializable
  @SerialName("RequiresFullAccess")
  public object RequiresFullAccess : InvalidAccessKeyError()

  /**
   *  * Access Key does not have enough allowance to cover transaction cost
   */
  @Serializable
  public data class NotEnoughAllowance(
    @SerialName("NotEnoughAllowance")
    public val notEnoughAllowance: NotEnoughAllowancePayload,
  ) : InvalidAccessKeyError() {
    @Serializable
    public data class NotEnoughAllowancePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("allowance")
      public val allowance: NearToken,
      @SerialName("cost")
      public val cost: NearToken,
      @SerialName("public_key")
      public val publicKey: PublicKey,
    )
  }

  /**
   *  * Having a deposit with a function call action is not allowed with a function call access key.
   *  * Possible values: DepositWithFunctionCall
   */
  @Serializable
  @SerialName("DepositWithFunctionCall")
  public object DepositWithFunctionCall : InvalidAccessKeyError()
}
