package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class BandwidthRequests(
  @SerialName("V1")
  public val v1: BandwidthRequestsV1,
)
