package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Information about a Producer: its account name, peer_id and a list of connected peers that
 * the node can use to send message for this producer.
 */
@Serializable
public data class KnownProducerView(
  @SerialName("account_id")
  public val accountId: AccountId,
  /**
   *  * Nullable: true
   */
  @SerialName("next_hops")
  public val nextHops: List<PublicKey>,
  @SerialName("peer_id")
  public val peerId: PublicKey,
)
