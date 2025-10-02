package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ChunkDistributionNetworkConfig(
  @SerialName("enabled")
  public val enabled: Boolean,
  @SerialName("uris")
  public val uris: ChunkDistributionUris,
)
