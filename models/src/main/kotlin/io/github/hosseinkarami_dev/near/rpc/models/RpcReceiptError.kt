package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcReceiptErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = RpcReceiptErrorSerializer::class)
public sealed class RpcReceiptError {
  @Serializable
  public data class InternalError(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: INTERNAL_ERROR
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcReceiptError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("error_message")
      public val errorMessage: String,
    )

    /**
     *  * Possible values: INTERNAL_ERROR
     */
    @Serializable
    public enum class Name {
      @SerialName("INTERNAL_ERROR")
      INTERNAL_ERROR,
    }
  }

  @Serializable
  public data class UnknownReceipt(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: UNKNOWN_RECEIPT
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcReceiptError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("receipt_id")
      public val receiptId: CryptoHash,
    )

    /**
     *  * Possible values: UNKNOWN_RECEIPT
     */
    @Serializable
    public enum class Name {
      @SerialName("UNKNOWN_RECEIPT")
      UNKNOWN_RECEIPT,
    }
  }
}
