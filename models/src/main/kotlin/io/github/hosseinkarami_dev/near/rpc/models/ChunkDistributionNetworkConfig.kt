package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Config for the Chunk Distribution Network feature.
 * This allows nodes to push and pull chunks from a central stream.
 * The two benefits of this approach are: (1) less request/response traffic
 * on the peer-to-peer network and (2) lower latency for RPC nodes indexing the chain.
 */
@Serializable
public data class ChunkDistributionNetworkConfig(
  @SerialName("enabled")
  public val enabled: Boolean,
  @SerialName("uris")
  public val uris: ChunkDistributionUris,
)
