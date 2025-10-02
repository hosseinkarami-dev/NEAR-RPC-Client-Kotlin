package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class InvalidAccessKeyError {
  @Serializable
  public class AccessKeyNotFound(
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

  @Serializable
  public class ReceiverMismatch(
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

  @Serializable
  public class MethodNameMismatch(
    @SerialName("MethodNameMismatch")
    public val methodNameMismatch: MethodNameMismatchPayload,
  ) : InvalidAccessKeyError() {
    @Serializable
    public data class MethodNameMismatchPayload(
      @SerialName("method_name")
      public val methodName: String,
    )
  }

  @Serializable
  @SerialName("RequiresFullAccess")
  public object RequiresFullAccess : InvalidAccessKeyError()

  @Serializable
  public class NotEnoughAllowance(
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

  @Serializable
  @SerialName("DepositWithFunctionCall")
  public object DepositWithFunctionCall : InvalidAccessKeyError()
}
