package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class HostError {
  @Serializable
  @SerialName("BadUTF16")
  public object BadUTF16 : HostError()

  @Serializable
  @SerialName("BadUTF8")
  public object BadUTF8 : HostError()

  @Serializable
  @SerialName("GasExceeded")
  public object GasExceeded : HostError()

  @Serializable
  @SerialName("GasLimitExceeded")
  public object GasLimitExceeded : HostError()

  @Serializable
  @SerialName("BalanceExceeded")
  public object BalanceExceeded : HostError()

  @Serializable
  @SerialName("EmptyMethodName")
  public object EmptyMethodName : HostError()

  @Serializable
  public class GuestPanic(
    @SerialName("GuestPanic")
    public val guestPanic: GuestPanicPayload,
  ) : HostError() {
    @Serializable
    public data class GuestPanicPayload(
      @SerialName("panic_msg")
      public val panicMsg: String,
    )
  }

  @Serializable
  @SerialName("IntegerOverflow")
  public object IntegerOverflow : HostError()

  @Serializable
  public class InvalidPromiseIndex(
    @SerialName("InvalidPromiseIndex")
    public val invalidPromiseIndex: InvalidPromiseIndexPayload,
  ) : HostError() {
    @Serializable
    public data class InvalidPromiseIndexPayload(
      @SerialName("promise_idx")
      public val promiseIdx: Long,
    )
  }

  @Serializable
  @SerialName("CannotAppendActionToJointPromise")
  public object CannotAppendActionToJointPromise : HostError()

  @Serializable
  @SerialName("CannotReturnJointPromise")
  public object CannotReturnJointPromise : HostError()

  @Serializable
  public class InvalidPromiseResultIndex(
    @SerialName("InvalidPromiseResultIndex")
    public val invalidPromiseResultIndex: InvalidPromiseResultIndexPayload,
  ) : HostError() {
    @Serializable
    public data class InvalidPromiseResultIndexPayload(
      @SerialName("result_idx")
      public val resultIdx: Long,
    )
  }

  @Serializable
  public class InvalidRegisterId(
    @SerialName("InvalidRegisterId")
    public val invalidRegisterId: InvalidRegisterIdPayload,
  ) : HostError() {
    @Serializable
    public data class InvalidRegisterIdPayload(
      @SerialName("register_id")
      public val registerId: Long,
    )
  }

  @Serializable
  public class IteratorWasInvalidated(
    @SerialName("IteratorWasInvalidated")
    public val iteratorWasInvalidated: IteratorWasInvalidatedPayload,
  ) : HostError() {
    @Serializable
    public data class IteratorWasInvalidatedPayload(
      @SerialName("iterator_index")
      public val iteratorIndex: Long,
    )
  }

  @Serializable
  @SerialName("MemoryAccessViolation")
  public object MemoryAccessViolation : HostError()

  @Serializable
  public class InvalidReceiptIndex(
    @SerialName("InvalidReceiptIndex")
    public val invalidReceiptIndex: InvalidReceiptIndexPayload,
  ) : HostError() {
    @Serializable
    public data class InvalidReceiptIndexPayload(
      @SerialName("receipt_index")
      public val receiptIndex: Long,
    )
  }

  @Serializable
  public class InvalidIteratorIndex(
    @SerialName("InvalidIteratorIndex")
    public val invalidIteratorIndex: InvalidIteratorIndexPayload,
  ) : HostError() {
    @Serializable
    public data class InvalidIteratorIndexPayload(
      @SerialName("iterator_index")
      public val iteratorIndex: Long,
    )
  }

  @Serializable
  @SerialName("InvalidAccountId")
  public object InvalidAccountId : HostError()

  @Serializable
  @SerialName("InvalidMethodName")
  public object InvalidMethodName : HostError()

  @Serializable
  @SerialName("InvalidPublicKey")
  public object InvalidPublicKey : HostError()

  @Serializable
  public class ProhibitedInView(
    @SerialName("ProhibitedInView")
    public val prohibitedInView: ProhibitedInViewPayload,
  ) : HostError() {
    @Serializable
    public data class ProhibitedInViewPayload(
      @SerialName("method_name")
      public val methodName: String,
    )
  }

  @Serializable
  public class NumberOfLogsExceeded(
    @SerialName("NumberOfLogsExceeded")
    public val numberOfLogsExceeded: NumberOfLogsExceededPayload,
  ) : HostError() {
    @Serializable
    public data class NumberOfLogsExceededPayload(
      @SerialName("limit")
      public val limit: Long,
    )
  }

  @Serializable
  public class KeyLengthExceeded(
    @SerialName("KeyLengthExceeded")
    public val keyLengthExceeded: KeyLengthExceededPayload,
  ) : HostError() {
    @Serializable
    public data class KeyLengthExceededPayload(
      @SerialName("length")
      public val length: Long,
      @SerialName("limit")
      public val limit: Long,
    )
  }

  @Serializable
  public class ValueLengthExceeded(
    @SerialName("ValueLengthExceeded")
    public val valueLengthExceeded: ValueLengthExceededPayload,
  ) : HostError() {
    @Serializable
    public data class ValueLengthExceededPayload(
      @SerialName("length")
      public val length: Long,
      @SerialName("limit")
      public val limit: Long,
    )
  }

  @Serializable
  public class TotalLogLengthExceeded(
    @SerialName("TotalLogLengthExceeded")
    public val totalLogLengthExceeded: TotalLogLengthExceededPayload,
  ) : HostError() {
    @Serializable
    public data class TotalLogLengthExceededPayload(
      @SerialName("length")
      public val length: Long,
      @SerialName("limit")
      public val limit: Long,
    )
  }

  @Serializable
  public class NumberPromisesExceeded(
    @SerialName("NumberPromisesExceeded")
    public val numberPromisesExceeded: NumberPromisesExceededPayload,
  ) : HostError() {
    @Serializable
    public data class NumberPromisesExceededPayload(
      @SerialName("limit")
      public val limit: Long,
      @SerialName("number_of_promises")
      public val numberOfPromises: Long,
    )
  }

  @Serializable
  public class NumberInputDataDependenciesExceeded(
    @SerialName("NumberInputDataDependenciesExceeded")
    public val numberInputDataDependenciesExceeded: NumberInputDataDependenciesExceededPayload,
  ) : HostError() {
    @Serializable
    public data class NumberInputDataDependenciesExceededPayload(
      @SerialName("limit")
      public val limit: Long,
      @SerialName("number_of_input_data_dependencies")
      public val numberOfInputDataDependencies: Long,
    )
  }

  @Serializable
  public class ReturnedValueLengthExceeded(
    @SerialName("ReturnedValueLengthExceeded")
    public val returnedValueLengthExceeded: ReturnedValueLengthExceededPayload,
  ) : HostError() {
    @Serializable
    public data class ReturnedValueLengthExceededPayload(
      @SerialName("length")
      public val length: Long,
      @SerialName("limit")
      public val limit: Long,
    )
  }

  @Serializable
  public class ContractSizeExceeded(
    @SerialName("ContractSizeExceeded")
    public val contractSizeExceeded: ContractSizeExceededPayload,
  ) : HostError() {
    @Serializable
    public data class ContractSizeExceededPayload(
      @SerialName("limit")
      public val limit: Long,
      @SerialName("size")
      public val size: Long,
    )
  }

  @Serializable
  public class Deprecated(
    @SerialName("Deprecated")
    public val deprecated: DeprecatedPayload,
  ) : HostError() {
    @Serializable
    public data class DeprecatedPayload(
      @SerialName("method_name")
      public val methodName: String,
    )
  }

  @Serializable
  public class ECRecoverError(
    @SerialName("ECRecoverError")
    public val eCRecoverError: ECRecoverErrorPayload,
  ) : HostError() {
    @Serializable
    public data class ECRecoverErrorPayload(
      @SerialName("msg")
      public val msg: String,
    )
  }

  @Serializable
  public class AltBn128InvalidInput(
    @SerialName("AltBn128InvalidInput")
    public val altBn128InvalidInput: AltBn128InvalidInputPayload,
  ) : HostError() {
    @Serializable
    public data class AltBn128InvalidInputPayload(
      @SerialName("msg")
      public val msg: String,
    )
  }

  @Serializable
  public class Ed25519VerifyInvalidInput(
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
