package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class ReceiptValidationError {
  @Serializable
  public class InvalidPredecessorId(
    @SerialName("InvalidPredecessorId")
    public val invalidPredecessorId: InvalidPredecessorIdPayload,
  ) : ReceiptValidationError() {
    @Serializable
    public data class InvalidPredecessorIdPayload(
      @SerialName("account_id")
      public val accountId: String,
    )
  }

  @Serializable
  public class InvalidReceiverId(
    @SerialName("InvalidReceiverId")
    public val invalidReceiverId: InvalidReceiverIdPayload,
  ) : ReceiptValidationError() {
    @Serializable
    public data class InvalidReceiverIdPayload(
      @SerialName("account_id")
      public val accountId: String,
    )
  }

  @Serializable
  public class InvalidSignerId(
    @SerialName("InvalidSignerId")
    public val invalidSignerId: InvalidSignerIdPayload,
  ) : ReceiptValidationError() {
    @Serializable
    public data class InvalidSignerIdPayload(
      @SerialName("account_id")
      public val accountId: String,
    )
  }

  @Serializable
  public class InvalidDataReceiverId(
    @SerialName("InvalidDataReceiverId")
    public val invalidDataReceiverId: InvalidDataReceiverIdPayload,
  ) : ReceiptValidationError() {
    @Serializable
    public data class InvalidDataReceiverIdPayload(
      @SerialName("account_id")
      public val accountId: String,
    )
  }

  @Serializable
  public class ReturnedValueLengthExceeded(
    @SerialName("ReturnedValueLengthExceeded")
    public val returnedValueLengthExceeded: ReturnedValueLengthExceededPayload,
  ) : ReceiptValidationError() {
    @Serializable
    public data class ReturnedValueLengthExceededPayload(
      @SerialName("length")
      public val length: Long,
      @SerialName("limit")
      public val limit: Long,
    )
  }

  @Serializable
  public class NumberInputDataDependenciesExceeded(
    @SerialName("NumberInputDataDependenciesExceeded")
    public val numberInputDataDependenciesExceeded: NumberInputDataDependenciesExceededPayload,
  ) : ReceiptValidationError() {
    @Serializable
    public data class NumberInputDataDependenciesExceededPayload(
      @SerialName("limit")
      public val limit: Long,
      @SerialName("number_of_input_data_dependencies")
      public val numberOfInputDataDependencies: Long,
    )
  }

  @Serializable
  public class ActionsValidation(
    @SerialName("ActionsValidation")
    public val actionsValidation: ActionsValidationError,
  ) : ReceiptValidationError()

  @Serializable
  public class ReceiptSizeExceeded(
    @SerialName("ReceiptSizeExceeded")
    public val receiptSizeExceeded: ReceiptSizeExceededPayload,
  ) : ReceiptValidationError() {
    @Serializable
    public data class ReceiptSizeExceededPayload(
      @SerialName("limit")
      public val limit: Long,
      @SerialName("size")
      public val size: Long,
    )
  }
}
