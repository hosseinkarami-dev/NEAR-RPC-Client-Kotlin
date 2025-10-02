package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * `BandwidthRequest` describes the size of receipts that a shard would like to send to another shard.
 * When a shard wants to send a lot of receipts to another shard, it needs to create a request and wait
 * for a bandwidth grant from the bandwidth scheduler.
 */
@Serializable
public data class BandwidthRequest(
  /**
   *  * Bitmap which describes what values of bandwidth are requested.
   */
  @SerialName("requested_values_bitmap")
  public val requestedValuesBitmap: BandwidthRequestBitmap,
  /**
   *  * Requesting bandwidth to this shard.
   *  * Minimum: 0.0
   *  * Maximum: 65535.0
   *  * Format: uint16
   */
  @SerialName("to_shard")
  public val toShard: Int,
)
