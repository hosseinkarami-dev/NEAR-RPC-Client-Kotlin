package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.ULong
import kotlin.UShort
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Stores the congestion level of a shard. More info about congestion [here](https://near.github.io/nearcore/architecture/how/receipt-congestion.html?highlight=congestion#receipt-congestion)
 */
@Serializable
public data class CongestionInfoView(
  /**
   *  * Minimum: 0.0
   *  * Maximum: 65535.0
   *  * Format: uint16
   */
  @SerialName("allowed_shard")
  public val allowedShard: UShort,
  @SerialName("buffered_receipts_gas")
  public val bufferedReceiptsGas: String,
  @SerialName("delayed_receipts_gas")
  public val delayedReceiptsGas: String,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("receipt_bytes")
  public val receiptBytes: ULong,
)
