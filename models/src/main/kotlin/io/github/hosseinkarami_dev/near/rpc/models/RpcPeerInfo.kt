package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcPeerInfo(
  @SerialName("account_id")
  public val accountId: AccountId?,
  @SerialName("addr")
  public val addr: String?,
  @SerialName("id")
  public val id: PeerId,
)
