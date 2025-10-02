package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class ActionsValidationError {
  @Serializable
  @SerialName("DeleteActionMustBeFinal")
  public object DeleteActionMustBeFinal : ActionsValidationError()

  @Serializable
  public class TotalPrepaidGasExceeded(
    @SerialName("TotalPrepaidGasExceeded")
    public val totalPrepaidGasExceeded: TotalPrepaidGasExceededPayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class TotalPrepaidGasExceededPayload(
      @SerialName("limit")
      public val limit: NearGas,
      @SerialName("total_prepaid_gas")
      public val totalPrepaidGas: NearGas,
    )
  }

  @Serializable
  public class TotalNumberOfActionsExceeded(
    @SerialName("TotalNumberOfActionsExceeded")
    public val totalNumberOfActionsExceeded: TotalNumberOfActionsExceededPayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class TotalNumberOfActionsExceededPayload(
      @SerialName("limit")
      public val limit: Long,
      @SerialName("total_number_of_actions")
      public val totalNumberOfActions: Long,
    )
  }

  @Serializable
  public class AddKeyMethodNamesNumberOfBytesExceeded(
    @SerialName("AddKeyMethodNamesNumberOfBytesExceeded")
    public val addKeyMethodNamesNumberOfBytesExceeded:
        AddKeyMethodNamesNumberOfBytesExceededPayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class AddKeyMethodNamesNumberOfBytesExceededPayload(
      @SerialName("limit")
      public val limit: Long,
      @SerialName("total_number_of_bytes")
      public val totalNumberOfBytes: Long,
    )
  }

  @Serializable
  public class AddKeyMethodNameLengthExceeded(
    @SerialName("AddKeyMethodNameLengthExceeded")
    public val addKeyMethodNameLengthExceeded: AddKeyMethodNameLengthExceededPayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class AddKeyMethodNameLengthExceededPayload(
      @SerialName("length")
      public val length: Long,
      @SerialName("limit")
      public val limit: Long,
    )
  }

  @Serializable
  @SerialName("IntegerOverflow")
  public object IntegerOverflow : ActionsValidationError()

  @Serializable
  public class InvalidAccountId(
    @SerialName("InvalidAccountId")
    public val invalidAccountId: InvalidAccountIdPayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class InvalidAccountIdPayload(
      @SerialName("account_id")
      public val accountId: String,
    )
  }

  @Serializable
  public class ContractSizeExceeded(
    @SerialName("ContractSizeExceeded")
    public val contractSizeExceeded: ContractSizeExceededPayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class ContractSizeExceededPayload(
      @SerialName("limit")
      public val limit: Long,
      @SerialName("size")
      public val size: Long,
    )
  }

  @Serializable
  public class FunctionCallMethodNameLengthExceeded(
    @SerialName("FunctionCallMethodNameLengthExceeded")
    public val functionCallMethodNameLengthExceeded: FunctionCallMethodNameLengthExceededPayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class FunctionCallMethodNameLengthExceededPayload(
      @SerialName("length")
      public val length: Long,
      @SerialName("limit")
      public val limit: Long,
    )
  }

  @Serializable
  public class FunctionCallArgumentsLengthExceeded(
    @SerialName("FunctionCallArgumentsLengthExceeded")
    public val functionCallArgumentsLengthExceeded: FunctionCallArgumentsLengthExceededPayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class FunctionCallArgumentsLengthExceededPayload(
      @SerialName("length")
      public val length: Long,
      @SerialName("limit")
      public val limit: Long,
    )
  }

  @Serializable
  public class UnsuitableStakingKey(
    @SerialName("UnsuitableStakingKey")
    public val unsuitableStakingKey: UnsuitableStakingKeyPayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class UnsuitableStakingKeyPayload(
      @SerialName("public_key")
      public val publicKey: PublicKey,
    )
  }

  @Serializable
  @SerialName("FunctionCallZeroAttachedGas")
  public object FunctionCallZeroAttachedGas : ActionsValidationError()

  @Serializable
  @SerialName("DelegateActionMustBeOnlyOne")
  public object DelegateActionMustBeOnlyOne : ActionsValidationError()

  @Serializable
  public class UnsupportedProtocolFeature(
    @SerialName("UnsupportedProtocolFeature")
    public val unsupportedProtocolFeature: UnsupportedProtocolFeaturePayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class UnsupportedProtocolFeaturePayload(
      @SerialName("protocol_feature")
      public val protocolFeature: String,
      @SerialName("version")
      public val version: Int,
    )
  }

  @Serializable
  public class InvalidDeterministicStateInitReceiver(
    @SerialName("InvalidDeterministicStateInitReceiver")
    public val invalidDeterministicStateInitReceiver: InvalidDeterministicStateInitReceiverPayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class InvalidDeterministicStateInitReceiverPayload(
      @SerialName("derived_id")
      public val derivedId: AccountId,
      @SerialName("receiver_id")
      public val receiverId: AccountId,
    )
  }

  @Serializable
  public class DeterministicStateInitKeyLengthExceeded(
    @SerialName("DeterministicStateInitKeyLengthExceeded")
    public val deterministicStateInitKeyLengthExceeded:
        DeterministicStateInitKeyLengthExceededPayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class DeterministicStateInitKeyLengthExceededPayload(
      @SerialName("length")
      public val length: Long,
      @SerialName("limit")
      public val limit: Long,
    )
  }

  @Serializable
  public class DeterministicStateInitValueLengthExceeded(
    @SerialName("DeterministicStateInitValueLengthExceeded")
    public val deterministicStateInitValueLengthExceeded:
        DeterministicStateInitValueLengthExceededPayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class DeterministicStateInitValueLengthExceededPayload(
      @SerialName("length")
      public val length: Long,
      @SerialName("limit")
      public val limit: Long,
    )
  }
}
