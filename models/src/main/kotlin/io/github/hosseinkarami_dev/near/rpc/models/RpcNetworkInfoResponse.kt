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
  @SerialName("known_producers")
  public val knownProducers: List<RpcKnownProducer>,
  @SerialName("num_active_peers")
  public val numActivePeers: Int,
  @SerialName("peer_max_count")
  public val peerMaxCount: Int,
  @SerialName("received_bytes_per_sec")
  public val receivedBytesPerSec: Long,
  @SerialName("sent_bytes_per_sec")
  public val sentBytesPerSec: Long,
)
