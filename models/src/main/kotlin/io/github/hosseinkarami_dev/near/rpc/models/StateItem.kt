package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Item of the state, key and value are serialized in base64 and proof for inclusion of given state item.
 */
@Serializable
public data class StateItem(
  @SerialName("key")
  public val key: StoreKey,
  @SerialName("value")
  public val `value`: StoreValue,
)
