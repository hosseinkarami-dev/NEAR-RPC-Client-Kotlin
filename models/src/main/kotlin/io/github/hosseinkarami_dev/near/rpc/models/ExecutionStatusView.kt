package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.ExecutionStatusViewSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = ExecutionStatusViewSerializer::class)
public sealed class ExecutionStatusView {
  /**
   *  * The execution is pending or unknown.
   *  * Possible values: Unknown
   */
  @Serializable
  @SerialName("Unknown")
  public data class Unknown(
    public val `value`: String = "Unknown",
  ) : ExecutionStatusView()

  /**
   *  * The execution has failed.
   */
  @Serializable
  public data class Failure(
    @SerialName("Failure")
    public val failure: TxExecutionError,
  ) : ExecutionStatusView()

  /**
   *  * The final action succeeded and returned some value or an empty vec encoded in base64.
   */
  @Serializable
  public data class SuccessValue(
    @SerialName("SuccessValue")
    public val successValue: String,
  ) : ExecutionStatusView()

  /**
   *  * The final action of the receipt returned a promise or the signed transaction was converted
   * to a receipt. Contains the receipt_id of the generated receipt.
   */
  @Serializable
  public data class SuccessReceiptId(
    @SerialName("SuccessReceiptId")
    public val successReceiptId: CryptoHash,
  ) : ExecutionStatusView()
}
