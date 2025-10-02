package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class AccountDataView(
  @SerialName("account_key")
  public val accountKey: PublicKey,
  @SerialName("peer_id")
  public val peerId: PublicKey,
  @SerialName("proxies")
  public val proxies: List<Tier1ProxyView>,
  @SerialName("timestamp")
  public val timestamp: String,
)
