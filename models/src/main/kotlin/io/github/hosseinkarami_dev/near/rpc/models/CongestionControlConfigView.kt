package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Double
import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class CongestionControlConfigView(
  @SerialName("allowed_shard_outgoing_gas")
  public val allowedShardOutgoingGas: NearGas,
  @SerialName("max_congestion_incoming_gas")
  public val maxCongestionIncomingGas: NearGas,
  @SerialName("max_congestion_memory_consumption")
  public val maxCongestionMemoryConsumption: Long,
  @SerialName("max_congestion_missed_chunks")
  public val maxCongestionMissedChunks: Long,
  @SerialName("max_congestion_outgoing_gas")
  public val maxCongestionOutgoingGas: NearGas,
  @SerialName("max_outgoing_gas")
  public val maxOutgoingGas: NearGas,
  @SerialName("max_tx_gas")
  public val maxTxGas: NearGas,
  @SerialName("min_outgoing_gas")
  public val minOutgoingGas: NearGas,
  @SerialName("min_tx_gas")
  public val minTxGas: NearGas,
  @SerialName("outgoing_receipts_big_size_limit")
  public val outgoingReceiptsBigSizeLimit: Long,
  @SerialName("outgoing_receipts_usual_size_limit")
  public val outgoingReceiptsUsualSizeLimit: Long,
  @SerialName("reject_tx_congestion_threshold")
  public val rejectTxCongestionThreshold: Double,
)
