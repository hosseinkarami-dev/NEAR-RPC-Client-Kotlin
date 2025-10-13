package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.HostErrorSerializer
import kotlin.String
import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = HostErrorSerializer::class)
public sealed class HostError {
  /**
   *  * String encoding is bad UTF-16 sequence
   *  * Possible values: BadUTF16
   */
  @Serializable
  @SerialName("BadUTF16")
  public data class BadUTF16(
    public val `value`: String = "BadUTF16",
  ) : HostError()

  /**
   *  * String encoding is bad UTF-8 sequence
   *  * Possible values: BadUTF8
   */
  @Serializable
  @SerialName("BadUTF8")
  public data class BadUTF8(
    public val `value`: String = "BadUTF8",
  ) : HostError()

  /**
   *  * Exceeded the prepaid gas
   *  * Possible values: GasExceeded
   */
  @Serializable
  @SerialName("GasExceeded")
  public data class GasExceeded(
    public val `value`: String = "GasExceeded",
  ) : HostError()

  /**
   *  * Exceeded the maximum amount of gas allowed to burn per contract
   *  * Possible values: GasLimitExceeded
   */
  @Serializable
  @SerialName("GasLimitExceeded")
  public data class GasLimitExceeded(
    public val `value`: String = "GasLimitExceeded",
  ) : HostError()

  /**
   *  * Exceeded the account balance
   *  * Possible values: BalanceExceeded
   */
  @Serializable
  @SerialName("BalanceExceeded")
  public data class BalanceExceeded(
    public val `value`: String = "BalanceExceeded",
  ) : HostError()

  /**
   *  * Tried to call an empty method name
   *  * Possible values: EmptyMethodName
   */
  @Serializable
  @SerialName("EmptyMethodName")
  public data class EmptyMethodName(
    public val `value`: String = "EmptyMethodName",
  ) : HostError()

  /**
   *  * Smart contract panicked
   */
  @Serializable
  public data class GuestPanic(
    @SerialName("GuestPanic")
    public val guestPanic: GuestPanicPayload,
  ) : HostError() {
    @Serializable
    public data class GuestPanicPayload(
      @SerialName("panic_msg")
      public val panicMsg: String,
    )
  }

  /**
   *  * IntegerOverflow happened during a contract execution
   *  * Possible values: IntegerOverflow
   */
  @Serializable
  @SerialName("IntegerOverflow")
  public data class IntegerOverflow(
    public val `value`: String = "IntegerOverflow",
  ) : HostError()

  /**
   *  * `promise_idx` does not correspond to existing promises
   */
  @Serializable
  public data class InvalidPromiseIndex(
    @SerialName("InvalidPromiseIndex")
    public val invalidPromiseIndex: InvalidPromiseIndexPayload,
  ) : HostError() {
    @Serializable
    public data class InvalidPromiseIndexPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("promise_idx")
      public val promiseIdx: ULong,
    )
  }

  /**
   *  * Actions can only be appended to non-joint promise.
   *  * Possible values: CannotAppendActionToJointPromise
   */
  @Serializable
  @SerialName("CannotAppendActionToJointPromise")
  public data class CannotAppendActionToJointPromise(
    public val `value`: String = "CannotAppendActionToJointPromise",
  ) : HostError()

  /**
   *  * Returning joint promise is currently prohibited
   *  * Possible values: CannotReturnJointPromise
   */
  @Serializable
  @SerialName("CannotReturnJointPromise")
  public data class CannotReturnJointPromise(
    public val `value`: String = "CannotReturnJointPromise",
  ) : HostError()

  /**
   *  * Accessed invalid promise result index
   */
  @Serializable
  public data class InvalidPromiseResultIndex(
    @SerialName("InvalidPromiseResultIndex")
    public val invalidPromiseResultIndex: InvalidPromiseResultIndexPayload,
  ) : HostError() {
    @Serializable
    public data class InvalidPromiseResultIndexPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("result_idx")
      public val resultIdx: ULong,
    )
  }

  /**
   *  * Accessed invalid register id
   */
  @Serializable
  public data class InvalidRegisterId(
    @SerialName("InvalidRegisterId")
    public val invalidRegisterId: InvalidRegisterIdPayload,
  ) : HostError() {
    @Serializable
    public data class InvalidRegisterIdPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("register_id")
      public val registerId: ULong,
    )
  }

  /**
   *  * Iterator `iterator_index` was invalidated after its creation by performing a mutable operation on trie
   */
  @Serializable
  public data class IteratorWasInvalidated(
    @SerialName("IteratorWasInvalidated")
    public val iteratorWasInvalidated: IteratorWasInvalidatedPayload,
  ) : HostError() {
    @Serializable
    public data class IteratorWasInvalidatedPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("iterator_index")
      public val iteratorIndex: ULong,
    )
  }

  /**
   *  * Accessed memory outside the bounds
   *  * Possible values: MemoryAccessViolation
   */
  @Serializable
  @SerialName("MemoryAccessViolation")
  public data class MemoryAccessViolation(
    public val `value`: String = "MemoryAccessViolation",
  ) : HostError()

  /**
   *  * VM Logic returned an invalid receipt index
   */
  @Serializable
  public data class InvalidReceiptIndex(
    @SerialName("InvalidReceiptIndex")
    public val invalidReceiptIndex: InvalidReceiptIndexPayload,
  ) : HostError() {
    @Serializable
    public data class InvalidReceiptIndexPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("receipt_index")
      public val receiptIndex: ULong,
    )
  }

  /**
   *  * Iterator index `iterator_index` does not exist
   */
  @Serializable
  public data class InvalidIteratorIndex(
    @SerialName("InvalidIteratorIndex")
    public val invalidIteratorIndex: InvalidIteratorIndexPayload,
  ) : HostError() {
    @Serializable
    public data class InvalidIteratorIndexPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("iterator_index")
      public val iteratorIndex: ULong,
    )
  }

  /**
   *  * VM Logic returned an invalid account id
   *  * Possible values: InvalidAccountId
   */
  @Serializable
  @SerialName("InvalidAccountId")
  public data class InvalidAccountId(
    public val `value`: String = "InvalidAccountId",
  ) : HostError()

  /**
   *  * VM Logic returned an invalid method name
   *  * Possible values: InvalidMethodName
   */
  @Serializable
  @SerialName("InvalidMethodName")
  public data class InvalidMethodName(
    public val `value`: String = "InvalidMethodName",
  ) : HostError()

  /**
   *  * VM Logic provided an invalid public key
   *  * Possible values: InvalidPublicKey
   */
  @Serializable
  @SerialName("InvalidPublicKey")
  public data class InvalidPublicKey(
    public val `value`: String = "InvalidPublicKey",
  ) : HostError()

  /**
   *  * `method_name` is not allowed in view calls
   */
  @Serializable
  public data class ProhibitedInView(
    @SerialName("ProhibitedInView")
    public val prohibitedInView: ProhibitedInViewPayload,
  ) : HostError() {
    @Serializable
    public data class ProhibitedInViewPayload(
      @SerialName("method_name")
      public val methodName: String,
    )
  }

  /**
   *  * The total number of logs will exceed the limit.
   */
  @Serializable
  public data class NumberOfLogsExceeded(
    @SerialName("NumberOfLogsExceeded")
    public val numberOfLogsExceeded: NumberOfLogsExceededPayload,
  ) : HostError() {
    @Serializable
    public data class NumberOfLogsExceededPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("limit")
      public val limit: ULong,
    )
  }

  /**
   *  * The storage key length exceeded the limit.
   */
  @Serializable
  public data class KeyLengthExceeded(
    @SerialName("KeyLengthExceeded")
    public val keyLengthExceeded: KeyLengthExceededPayload,
  ) : HostError() {
    @Serializable
    public data class KeyLengthExceededPayload(
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
   *  * The storage value length exceeded the limit.
   */
  @Serializable
  public data class ValueLengthExceeded(
    @SerialName("ValueLengthExceeded")
    public val valueLengthExceeded: ValueLengthExceededPayload,
  ) : HostError() {
    @Serializable
    public data class ValueLengthExceededPayload(
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
   *  * The total log length exceeded the limit.
   */
  @Serializable
  public data class TotalLogLengthExceeded(
    @SerialName("TotalLogLengthExceeded")
    public val totalLogLengthExceeded: TotalLogLengthExceededPayload,
  ) : HostError() {
    @Serializable
    public data class TotalLogLengthExceededPayload(
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
   *  * The maximum number of promises within a FunctionCall exceeded the limit.
   */
  @Serializable
  public data class NumberPromisesExceeded(
    @SerialName("NumberPromisesExceeded")
    public val numberPromisesExceeded: NumberPromisesExceededPayload,
  ) : HostError() {
    @Serializable
    public data class NumberPromisesExceededPayload(
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
      @SerialName("number_of_promises")
      public val numberOfPromises: ULong,
    )
  }

  /**
   *  * The maximum number of input data dependencies exceeded the limit.
   */
  @Serializable
  public data class NumberInputDataDependenciesExceeded(
    @SerialName("NumberInputDataDependenciesExceeded")
    public val numberInputDataDependenciesExceeded: NumberInputDataDependenciesExceededPayload,
  ) : HostError() {
    @Serializable
    public data class NumberInputDataDependenciesExceededPayload(
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
      @SerialName("number_of_input_data_dependencies")
      public val numberOfInputDataDependencies: ULong,
    )
  }

  /**
   *  * The returned value length exceeded the limit.
   */
  @Serializable
  public data class ReturnedValueLengthExceeded(
    @SerialName("ReturnedValueLengthExceeded")
    public val returnedValueLengthExceeded: ReturnedValueLengthExceededPayload,
  ) : HostError() {
    @Serializable
    public data class ReturnedValueLengthExceededPayload(
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
   *  * The contract size for DeployContract action exceeded the limit.
   */
  @Serializable
  public data class ContractSizeExceeded(
    @SerialName("ContractSizeExceeded")
    public val contractSizeExceeded: ContractSizeExceededPayload,
  ) : HostError() {
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
   *  * The host function was deprecated.
   */
  @Serializable
  public data class Deprecated(
    @SerialName("Deprecated")
    public val deprecated: DeprecatedPayload,
  ) : HostError() {
    @Serializable
    public data class DeprecatedPayload(
      @SerialName("method_name")
      public val methodName: String,
    )
  }

  /**
   *  * General errors for ECDSA recover.
   */
  @Serializable
  public data class ECRecoverError(
    @SerialName("ECRecoverError")
    public val eCRecoverError: ECRecoverErrorPayload,
  ) : HostError() {
    @Serializable
    public data class ECRecoverErrorPayload(
      @SerialName("msg")
      public val msg: String,
    )
  }

  /**
   *  * Invalid input to alt_bn128 family of functions (e.g., point which isn't
   * on the curve).
   */
  @Serializable
  public data class AltBn128InvalidInput(
    @SerialName("AltBn128InvalidInput")
    public val altBn128InvalidInput: AltBn128InvalidInputPayload,
  ) : HostError() {
    @Serializable
    public data class AltBn128InvalidInputPayload(
      @SerialName("msg")
      public val msg: String,
    )
  }

  /**
   *  * Invalid input to ed25519 signature verification function (e.g. signature cannot be
   * derived from bytes).
   */
  @Serializable
  public data class Ed25519VerifyInvalidInput(
    @SerialName("Ed25519VerifyInvalidInput")
    public val ed25519VerifyInvalidInput: Ed25519VerifyInvalidInputPayload,
  ) : HostError() {
    @Serializable
    public data class Ed25519VerifyInvalidInputPayload(
      @SerialName("msg")
      public val msg: String,
    )
  }
}
