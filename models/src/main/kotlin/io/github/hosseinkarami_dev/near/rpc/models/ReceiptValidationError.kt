package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.ReceiptValidationErrorSerializer
import kotlin.String
import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Describes the error for validating a receipt.
 */
@Serializable(with = ReceiptValidationErrorSerializer::class)
public sealed class ReceiptValidationError {
  /**
   *  * The `predecessor_id` of a Receipt is not valid.
   */
  @Serializable
  public data class InvalidPredecessorId(
    @SerialName("InvalidPredecessorId")
    public val invalidPredecessorId: InvalidPredecessorIdPayload,
  ) : ReceiptValidationError() {
    @Serializable
    public data class InvalidPredecessorIdPayload(
      @SerialName("account_id")
      public val accountId: String,
    )
  }

  /**
   *  * The `receiver_id` of a Receipt is not valid.
   */
  @Serializable
  public data class InvalidReceiverId(
    @SerialName("InvalidReceiverId")
    public val invalidReceiverId: InvalidReceiverIdPayload,
  ) : ReceiptValidationError() {
    @Serializable
    public data class InvalidReceiverIdPayload(
      @SerialName("account_id")
      public val accountId: String,
    )
  }

  /**
   *  * The `signer_id` of an ActionReceipt is not valid.
   */
  @Serializable
  public data class InvalidSignerId(
    @SerialName("InvalidSignerId")
    public val invalidSignerId: InvalidSignerIdPayload,
  ) : ReceiptValidationError() {
    @Serializable
    public data class InvalidSignerIdPayload(
      @SerialName("account_id")
      public val accountId: String,
    )
  }

  /**
   *  * The `receiver_id` of a DataReceiver within an ActionReceipt is not valid.
   */
  @Serializable
  public data class InvalidDataReceiverId(
    @SerialName("InvalidDataReceiverId")
    public val invalidDataReceiverId: InvalidDataReceiverIdPayload,
  ) : ReceiptValidationError() {
    @Serializable
    public data class InvalidDataReceiverIdPayload(
      @SerialName("account_id")
      public val accountId: String,
    )
  }

  /**
   *  * The length of the returned data exceeded the limit in a DataReceipt.
   */
  @Serializable
  public data class ReturnedValueLengthExceeded(
    @SerialName("ReturnedValueLengthExceeded")
    public val returnedValueLengthExceeded: ReturnedValueLengthExceededPayload,
  ) : ReceiptValidationError() {
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
   *  * The number of input data dependencies exceeds the limit in an ActionReceipt.
   */
  @Serializable
  public data class NumberInputDataDependenciesExceeded(
    @SerialName("NumberInputDataDependenciesExceeded")
    public val numberInputDataDependenciesExceeded: NumberInputDataDependenciesExceededPayload,
  ) : ReceiptValidationError() {
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
   *  * An error occurred while validating actions of an ActionReceipt.
   */
  @Serializable
  public data class ActionsValidation(
    @SerialName("ActionsValidation")
    public val actionsValidation: ActionsValidationError,
  ) : ReceiptValidationError()

  /**
   *  * Receipt is bigger than the limit.
   */
  @Serializable
  public data class ReceiptSizeExceeded(
    @SerialName("ReceiptSizeExceeded")
    public val receiptSizeExceeded: ReceiptSizeExceededPayload,
  ) : ReceiptValidationError() {
    @Serializable
    public data class ReceiptSizeExceededPayload(
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
   *  * The `refund_to` of an ActionReceipt is not valid.
   */
  @Serializable
  public data class InvalidRefundTo(
    @SerialName("InvalidRefundTo")
    public val invalidRefundTo: InvalidRefundToPayload,
  ) : ReceiptValidationError() {
    @Serializable
    public data class InvalidRefundToPayload(
      @SerialName("account_id")
      public val accountId: String,
    )
  }
}
