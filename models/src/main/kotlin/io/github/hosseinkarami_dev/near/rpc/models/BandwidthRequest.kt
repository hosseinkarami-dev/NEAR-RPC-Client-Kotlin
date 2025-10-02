package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class BandwidthRequest(
  @SerialName("requested_values_bitmap")
  public val requestedValuesBitmap: BandwidthRequestBitmap,
  @SerialName("to_shard")
  public val toShard: Int,
)
