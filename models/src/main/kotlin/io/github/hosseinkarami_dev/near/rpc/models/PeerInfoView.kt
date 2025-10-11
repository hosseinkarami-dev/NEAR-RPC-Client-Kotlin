package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlin.String
import kotlin.ULong
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
  public val connectionEstablishedTimeMillis: ULong,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("height")
  public val height: ULong? = null,
  @SerialName("is_highest_block_invalid")
  public val isHighestBlockInvalid: Boolean,
  @SerialName("is_outbound_peer")
  public val isOutboundPeer: Boolean,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("last_time_peer_requested_millis")
  public val lastTimePeerRequestedMillis: ULong,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("last_time_received_message_millis")
  public val lastTimeReceivedMessageMillis: ULong,
  /**
   *  * Connection nonce.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("nonce")
  public val nonce: ULong,
  @SerialName("peer_id")
  public val peerId: PublicKey,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("received_bytes_per_sec")
  public val receivedBytesPerSec: ULong,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("sent_bytes_per_sec")
  public val sentBytesPerSec: ULong,
  @SerialName("tracked_shards")
  public val trackedShards: List<ShardId>,
)
