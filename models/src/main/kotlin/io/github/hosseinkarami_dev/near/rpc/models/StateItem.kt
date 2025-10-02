package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class StateItem(
  @SerialName("key")
  public val key: StoreKey,
  @SerialName("value")
  public val `value`: StoreValue,
)
