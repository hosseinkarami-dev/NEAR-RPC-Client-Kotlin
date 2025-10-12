package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class MissingTrieValue(
  @SerialName("context")
  public val context: MissingTrieValueContext,
  @SerialName("hash")
  public val hash: CryptoHash,
)
