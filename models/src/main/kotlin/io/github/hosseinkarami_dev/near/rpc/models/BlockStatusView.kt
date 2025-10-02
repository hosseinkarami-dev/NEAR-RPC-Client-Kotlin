package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class BlockStatusView(
  @SerialName("hash")
  public val hash: CryptoHash,
  @SerialName("height")
  public val height: Long,
)
