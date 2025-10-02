package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class CongestionInfoView(
  @SerialName("allowed_shard")
  public val allowedShard: Int,
  @SerialName("buffered_receipts_gas")
  public val bufferedReceiptsGas: String,
  @SerialName("delayed_receipts_gas")
  public val delayedReceiptsGas: String,
  @SerialName("receipt_bytes")
  public val receiptBytes: Long,
)
