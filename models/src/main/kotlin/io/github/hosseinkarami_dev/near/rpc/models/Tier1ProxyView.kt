package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Tier1ProxyView(
  @SerialName("addr")
  public val addr: String,
  @SerialName("peer_id")
  public val peerId: PublicKey,
)
