package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class NetworkInfoView(
  @SerialName("connected_peers")
  public val connectedPeers: List<PeerInfoView>,
  @SerialName("known_producers")
  public val knownProducers: List<KnownProducerView>,
  /**
   *  * Minimum: 0.0
   *  * Format: uint
   */
  @SerialName("num_connected_peers")
  public val numConnectedPeers: Int,
  /**
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("peer_max_count")
  public val peerMaxCount: Int,
  @SerialName("tier1_accounts_data")
  public val tier1AccountsData: List<AccountDataView>,
  @SerialName("tier1_accounts_keys")
  public val tier1AccountsKeys: List<PublicKey>,
  @SerialName("tier1_connections")
  public val tier1Connections: List<PeerInfoView>,
) {
  init {
    require((numConnectedPeers?.toDouble() ?: 0.0) >= 0.0) { "NetworkInfoView.numConnectedPeers must be >= 0.0" }}
  init {
    require((peerMaxCount?.toDouble() ?: 0.0) >= 0.0) { "NetworkInfoView.peerMaxCount must be >= 0.0" }}
}
