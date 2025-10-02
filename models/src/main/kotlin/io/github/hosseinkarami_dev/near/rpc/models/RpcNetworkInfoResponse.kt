package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.Long
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcNetworkInfoResponse(
  @SerialName("active_peers")
  public val activePeers: List<RpcPeerInfo>,
  /**
   *  * Accounts of known block and chunk producers from routing table.
   */
  @SerialName("known_producers")
  public val knownProducers: List<RpcKnownProducer>,
  /**
   *  * Minimum: 0.0
   *  * Format: uint
   */
  @SerialName("num_active_peers")
  public val numActivePeers: Int,
  /**
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("peer_max_count")
  public val peerMaxCount: Int,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("received_bytes_per_sec")
  public val receivedBytesPerSec: Long,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("sent_bytes_per_sec")
  public val sentBytesPerSec: Long,
)
