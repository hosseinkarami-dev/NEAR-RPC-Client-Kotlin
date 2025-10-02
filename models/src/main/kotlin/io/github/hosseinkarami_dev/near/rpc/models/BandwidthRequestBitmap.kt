package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class BandwidthRequestBitmap(
  @SerialName("data")
  public val `data`: List<Int>,
)
