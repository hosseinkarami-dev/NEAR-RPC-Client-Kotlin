package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Double
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcCongestionLevelResponse(
  @SerialName("congestion_level")
  public val congestionLevel: Double,
)
