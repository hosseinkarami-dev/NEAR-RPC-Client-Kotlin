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
  public val accountId: AccountId?,
  @SerialName("addr")
  public val addr: String,
  @SerialName("archival")
  public val archival: Boolean,
  @SerialName("block_hash")
  public val blockHash: CryptoHash?,
  @SerialName("connection_established_time_millis")
  public val connectionEstablishedTimeMillis: Long,
  @SerialName("height")
  public val height: Long?,
  @SerialName("is_highest_block_invalid")
  public val isHighestBlockInvalid: Boolean,
  @SerialName("is_outbound_peer")
  public val isOutboundPeer: Boolean,
  @SerialName("last_time_peer_requested_millis")
  public val lastTimePeerRequestedMillis: Long,
  @SerialName("last_time_received_message_millis")
  public val lastTimeReceivedMessageMillis: Long,
  @SerialName("nonce")
  public val nonce: Long,
  @SerialName("peer_id")
  public val peerId: PublicKey,
  @SerialName("received_bytes_per_sec")
  public val receivedBytesPerSec: Long,
  @SerialName("sent_bytes_per_sec")
  public val sentBytesPerSec: Long,
  @SerialName("tracked_shards")
  public val trackedShards: List<ShardId>,
)
