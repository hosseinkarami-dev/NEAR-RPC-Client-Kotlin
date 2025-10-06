package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * URIs for the Chunk Distribution Network feature.
 */
@Serializable
public data class ChunkDistributionUris(
  /**
   *  * URI for pulling chunks from the stream.
   */
  @SerialName("get")
  public val `get`: String,
  /**
   *  * URI for publishing chunks to the stream.
   */
  @SerialName("set")
  public val `set`: String,
)
