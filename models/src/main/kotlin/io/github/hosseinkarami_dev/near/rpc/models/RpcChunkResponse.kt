package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcChunkResponse(
  @SerialName("author")
  public val author: AccountId,
  @SerialName("header")
  public val `header`: ChunkHeaderView,
  @SerialName("receipts")
  public val receipts: List<ReceiptView>,
  @SerialName("transactions")
  public val transactions: List<SignedTransactionView>,
)
