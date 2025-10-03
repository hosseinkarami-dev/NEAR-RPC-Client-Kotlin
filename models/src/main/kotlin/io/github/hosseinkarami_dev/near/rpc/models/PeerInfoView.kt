package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PeerInfoView(
  @SerialName("account_id")
  public val accountId: AccountId? = null,
  @SerialName("addr")
  public val addr: String,
  @SerialName("archival")
  public val archival: Boolean,
  @SerialName("block_hash")
  public val blockHash: CryptoHash? = null,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("connection_established_time_millis")
  public val connectionEstablishedTimeMillis: Long,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("height")
  public val height: Long? = null,
  @SerialName("is_highest_block_invalid")
  public val isHighestBlockInvalid: Boolean,
  @SerialName("is_outbound_peer")
  public val isOutboundPeer: Boolean,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("last_time_peer_requested_millis")
  public val lastTimePeerRequestedMillis: Long,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("last_time_received_message_millis")
  public val lastTimeReceivedMessageMillis: Long,
  /**
   *  * Connection nonce.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("nonce")
  public val nonce: Long,
  @SerialName("peer_id")
  public val peerId: PublicKey,
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
  @SerialName("tracked_shards")
  public val trackedShards: List<ShardId>,
) {
  init {
    require((connectionEstablishedTimeMillis?.toDouble() ?: 0.0) >= 0.0) { "PeerInfoView.connectionEstablishedTimeMillis must be >= 0.0" }}
  init {
    require((height?.toDouble() ?: 0.0) >= 0.0) { "PeerInfoView.height must be >= 0.0" }}
  init {
    require((lastTimePeerRequestedMillis?.toDouble() ?: 0.0) >= 0.0) { "PeerInfoView.lastTimePeerRequestedMillis must be >= 0.0" }}
  init {
    require((lastTimeReceivedMessageMillis?.toDouble() ?: 0.0) >= 0.0) { "PeerInfoView.lastTimeReceivedMessageMillis must be >= 0.0" }}
  init {
    require((nonce?.toDouble() ?: 0.0) >= 0.0) { "PeerInfoView.nonce must be >= 0.0" }}
  init {
    require((receivedBytesPerSec?.toDouble() ?: 0.0) >= 0.0) { "PeerInfoView.receivedBytesPerSec must be >= 0.0" }}
  init {
    require((sentBytesPerSec?.toDouble() ?: 0.0) >= 0.0) { "PeerInfoView.sentBytesPerSec must be >= 0.0" }}
}
