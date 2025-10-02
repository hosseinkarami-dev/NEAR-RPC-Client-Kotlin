package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class AccessKeyList(
  @SerialName("keys")
  public val keys: List<AccessKeyInfoView>,
)
