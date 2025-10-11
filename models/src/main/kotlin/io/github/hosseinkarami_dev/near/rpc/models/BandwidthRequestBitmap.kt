package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.UByte
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Bitmap which describes which values from the predefined list are being requested.
 * The nth bit is set to 1 when the nth value from the list is being requested.
 */
@Serializable
public data class BandwidthRequestBitmap(
  /**
   *  * Min Items: 5
   *  * Max Items: 5
   */
  @SerialName("data")
  public val `data`: List<UByte>,
) {
  init {
    require((`data`?.size ?: 0) >= 5) { "BandwidthRequestBitmap.data must contain at least 5 items (minItems = 5)" }}
  init {
    require((`data`?.size ?: 0) <= 5) { "BandwidthRequestBitmap.data must contain no more than 5 items (maxItems = 5)" }}
}
