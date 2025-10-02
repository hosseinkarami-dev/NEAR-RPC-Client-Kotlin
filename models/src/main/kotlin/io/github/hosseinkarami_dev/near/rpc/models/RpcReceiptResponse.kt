package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcReceiptResponse(
  @SerialName("predecessor_id")
  public val predecessorId: AccountId,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("priority")
  public val priority: Long?,
  @SerialName("receipt")
  public val receipt: ReceiptEnumView,
  @SerialName("receipt_id")
  public val receiptId: CryptoHash,
  @SerialName("receiver_id")
  public val receiverId: AccountId,
)
