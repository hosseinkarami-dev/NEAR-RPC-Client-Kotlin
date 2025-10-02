package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ChunkDistributionUris(
  @SerialName("get")
  public val `get`: String,
  @SerialName("set")
  public val `set`: String,
)
