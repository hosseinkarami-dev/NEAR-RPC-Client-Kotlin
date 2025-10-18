package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class MerklePathItem(
  @SerialName("direction")
  public val direction: Direction,
  @SerialName("hash")
  public val hash: CryptoHash,
)
