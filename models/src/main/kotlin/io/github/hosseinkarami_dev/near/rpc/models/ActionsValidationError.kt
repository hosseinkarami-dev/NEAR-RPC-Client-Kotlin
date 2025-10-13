package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.ActionsValidationErrorSerializer
import kotlin.String
import kotlin.UInt
import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Describes the error for validating a list of actions.
 */
@Serializable(with = ActionsValidationErrorSerializer::class)
public sealed class ActionsValidationError {
  /**
   *  * The delete action must be a final action in transaction
   *  * Possible values: DeleteActionMustBeFinal
   */
  @Serializable
  @SerialName("DeleteActionMustBeFinal")
  public data class DeleteActionMustBeFinal(
    public val `value`: String = "DeleteActionMustBeFinal",
  ) : ActionsValidationError()

  /**
   *  * The total prepaid gas (for all given actions) exceeded the limit.
   */
  @Serializable
  public data class TotalPrepaidGasExceeded(
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

  /**
   *  * The number of actions exceeded the given limit.
   */
  @Serializable
  public data class TotalNumberOfActionsExceeded(
    @SerialName("TotalNumberOfActionsExceeded")
    public val totalNumberOfActionsExceeded: TotalNumberOfActionsExceededPayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class TotalNumberOfActionsExceededPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("limit")
      public val limit: ULong,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("total_number_of_actions")
      public val totalNumberOfActions: ULong,
    )
  }

  /**
   *  * The total number of bytes of the method names exceeded the limit in a Add Key action.
   */
  @Serializable
  public data class AddKeyMethodNamesNumberOfBytesExceeded(
    @SerialName("AddKeyMethodNamesNumberOfBytesExceeded")
    public val addKeyMethodNamesNumberOfBytesExceeded:
        AddKeyMethodNamesNumberOfBytesExceededPayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class AddKeyMethodNamesNumberOfBytesExceededPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("limit")
      public val limit: ULong,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("total_number_of_bytes")
      public val totalNumberOfBytes: ULong,
    )
  }

  /**
   *  * The length of some method name exceeded the limit in a Add Key action.
   */
  @Serializable
  public data class AddKeyMethodNameLengthExceeded(
    @SerialName("AddKeyMethodNameLengthExceeded")
    public val addKeyMethodNameLengthExceeded: AddKeyMethodNameLengthExceededPayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class AddKeyMethodNameLengthExceededPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("length")
      public val length: ULong,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("limit")
      public val limit: ULong,
    )
  }

  /**
   *  * Integer overflow during a compute.
   *  * Possible values: IntegerOverflow
   */
  @Serializable
  @SerialName("IntegerOverflow")
  public data class IntegerOverflow(
    public val `value`: String = "IntegerOverflow",
  ) : ActionsValidationError()

  /**
   *  * Invalid account ID.
   */
  @Serializable
  public data class InvalidAccountId(
    @SerialName("InvalidAccountId")
    public val invalidAccountId: InvalidAccountIdPayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class InvalidAccountIdPayload(
      @SerialName("account_id")
      public val accountId: String,
    )
  }

  /**
   *  * The size of the contract code exceeded the limit in a DeployContract action.
   */
  @Serializable
  public data class ContractSizeExceeded(
    @SerialName("ContractSizeExceeded")
    public val contractSizeExceeded: ContractSizeExceededPayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class ContractSizeExceededPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("limit")
      public val limit: ULong,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("size")
      public val size: ULong,
    )
  }

  /**
   *  * The length of the method name exceeded the limit in a Function Call action.
   */
  @Serializable
  public data class FunctionCallMethodNameLengthExceeded(
    @SerialName("FunctionCallMethodNameLengthExceeded")
    public val functionCallMethodNameLengthExceeded: FunctionCallMethodNameLengthExceededPayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class FunctionCallMethodNameLengthExceededPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("length")
      public val length: ULong,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("limit")
      public val limit: ULong,
    )
  }

  /**
   *  * The length of the arguments exceeded the limit in a Function Call action.
   */
  @Serializable
  public data class FunctionCallArgumentsLengthExceeded(
    @SerialName("FunctionCallArgumentsLengthExceeded")
    public val functionCallArgumentsLengthExceeded: FunctionCallArgumentsLengthExceededPayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class FunctionCallArgumentsLengthExceededPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("length")
      public val length: ULong,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("limit")
      public val limit: ULong,
    )
  }

  /**
   *  * An attempt to stake with a public key that is not convertible to ristretto.
   */
  @Serializable
  public data class UnsuitableStakingKey(
    @SerialName("UnsuitableStakingKey")
    public val unsuitableStakingKey: UnsuitableStakingKeyPayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class UnsuitableStakingKeyPayload(
      @SerialName("public_key")
      public val publicKey: PublicKey,
    )
  }

  /**
   *  * The attached amount of gas in a FunctionCall action has to be a positive number.
   *  * Possible values: FunctionCallZeroAttachedGas
   */
  @Serializable
  @SerialName("FunctionCallZeroAttachedGas")
  public data class FunctionCallZeroAttachedGas(
    public val `value`: String = "FunctionCallZeroAttachedGas",
  ) : ActionsValidationError()

  /**
   *  * There should be the only one DelegateAction
   *  * Possible values: DelegateActionMustBeOnlyOne
   */
  @Serializable
  @SerialName("DelegateActionMustBeOnlyOne")
  public data class DelegateActionMustBeOnlyOne(
    public val `value`: String = "DelegateActionMustBeOnlyOne",
  ) : ActionsValidationError()

  /**
   *  * The transaction includes a feature that the current protocol version
   * does not support.
   *
   * Note: we stringify the protocol feature name instead of using
   * `ProtocolFeature` here because we don't want to leak the internals of
   * that type into observable borsh serialization.
   */
  @Serializable
  public data class UnsupportedProtocolFeature(
    @SerialName("UnsupportedProtocolFeature")
    public val unsupportedProtocolFeature: UnsupportedProtocolFeaturePayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class UnsupportedProtocolFeaturePayload(
      @SerialName("protocol_feature")
      public val protocolFeature: String,
      /**
       *  * Minimum: 0.0
       *  * Format: uint32
       */
      @SerialName("version")
      public val version: UInt,
    )
  }

  @Serializable
  public data class InvalidDeterministicStateInitReceiver(
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
  public data class DeterministicStateInitKeyLengthExceeded(
    @SerialName("DeterministicStateInitKeyLengthExceeded")
    public val deterministicStateInitKeyLengthExceeded:
        DeterministicStateInitKeyLengthExceededPayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class DeterministicStateInitKeyLengthExceededPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("length")
      public val length: ULong,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("limit")
      public val limit: ULong,
    )
  }

  @Serializable
  public data class DeterministicStateInitValueLengthExceeded(
    @SerialName("DeterministicStateInitValueLengthExceeded")
    public val deterministicStateInitValueLengthExceeded:
        DeterministicStateInitValueLengthExceededPayload,
  ) : ActionsValidationError() {
    @Serializable
    public data class DeterministicStateInitValueLengthExceededPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("length")
      public val length: ULong,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("limit")
      public val limit: ULong,
    )
  }
}
