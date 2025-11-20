package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Double
import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * The configuration for congestion control. More info about congestion [here](https://near.github.io/nearcore/architecture/how/receipt-congestion.html?highlight=congestion#receipt-congestion)
 */
@Serializable
public data class CongestionControlConfigView(
  /**
   *  * How much gas the chosen allowed shard can send to a 100%% congested shard.
   *
   * See [`CongestionControlConfig`] for more details.
   */
  @SerialName("allowed_shard_outgoing_gas")
  public val allowedShardOutgoingGas: NearGas? = null,
  /**
   *  * How much gas in delayed receipts of a shard is 100%% incoming congestion.
   *
   * See [`CongestionControlConfig`] for more details.
   */
  @SerialName("max_congestion_incoming_gas")
  public val maxCongestionIncomingGas: NearGas? = null,
  /**
   *  * How much memory space of all delayed and buffered receipts in a shard is
   * considered 100%% congested.
   *
   * See [`CongestionControlConfig`] for more details.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_congestion_memory_consumption")
  public val maxCongestionMemoryConsumption: ULong? = null,
  /**
   *  * How many missed chunks in a row in a shard is considered 100%% congested.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_congestion_missed_chunks")
  public val maxCongestionMissedChunks: ULong? = null,
  /**
   *  * How much gas in outgoing buffered receipts of a shard is 100%% congested.
   *
   * Outgoing congestion contributes to overall congestion, which reduces how
   * much other shards are allowed to forward to this shard.
   */
  @SerialName("max_congestion_outgoing_gas")
  public val maxCongestionOutgoingGas: NearGas? = null,
  /**
   *  * The maximum amount of gas attached to receipts a shard can forward to
   * another shard per chunk.
   *
   * See [`CongestionControlConfig`] for more details.
   */
  @SerialName("max_outgoing_gas")
  public val maxOutgoingGas: NearGas? = null,
  /**
   *  * The maximum amount of gas in a chunk spent on converting new transactions to
   * receipts.
   *
   * See [`CongestionControlConfig`] for more details.
   */
  @SerialName("max_tx_gas")
  public val maxTxGas: NearGas? = null,
  /**
   *  * The minimum gas each shard can send to a shard that is not fully congested.
   *
   * See [`CongestionControlConfig`] for more details.
   */
  @SerialName("min_outgoing_gas")
  public val minOutgoingGas: NearGas? = null,
  /**
   *  * The minimum amount of gas in a chunk spent on converting new transactions
   * to receipts, as long as the receiving shard is not congested.
   *
   * See [`CongestionControlConfig`] for more details.
   */
  @SerialName("min_tx_gas")
  public val minTxGas: NearGas? = null,
  /**
   *  * Large size limit for outgoing receipts to a shard, used when it's safe
   * to send a lot of receipts without making the state witness too large.
   * It limits the total sum of outgoing receipts, not individual receipts.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("outgoing_receipts_big_size_limit")
  public val outgoingReceiptsBigSizeLimit: ULong? = null,
  /**
   *  * The standard size limit for outgoing receipts aimed at a single shard.
   * This limit is pretty small to keep the size of source_receipt_proofs under control.
   * It limits the total sum of outgoing receipts, not individual receipts.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("outgoing_receipts_usual_size_limit")
  public val outgoingReceiptsUsualSizeLimit: ULong? = null,
  /**
   *  * How much congestion a shard can tolerate before it stops all shards from
   * accepting new transactions with the receiver set to the congested shard.
   *  * Format: double
   */
  @SerialName("reject_tx_congestion_threshold")
  public val rejectTxCongestionThreshold: Double? = null,
)
