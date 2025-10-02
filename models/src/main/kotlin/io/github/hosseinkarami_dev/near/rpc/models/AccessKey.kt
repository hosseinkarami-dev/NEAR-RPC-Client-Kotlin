package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class AccessKey(
  @SerialName("nonce")
  public val nonce: Long,
  @SerialName("permission")
  public val permission: AccessKeyPermission,
)
