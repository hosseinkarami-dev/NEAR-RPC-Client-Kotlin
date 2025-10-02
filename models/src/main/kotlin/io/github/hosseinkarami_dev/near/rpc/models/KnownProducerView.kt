package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class KnownProducerView(
  @SerialName("account_id")
  public val accountId: AccountId,
  @SerialName("next_hops")
  public val nextHops: List<PublicKey>,
  @SerialName("peer_id")
  public val peerId: PublicKey,
)
