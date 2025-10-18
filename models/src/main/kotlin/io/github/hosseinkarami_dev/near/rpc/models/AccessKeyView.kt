package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Describes access key permission scope and nonce.
 */
@Serializable
public data class AccessKeyView(
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("nonce")
  public val nonce: ULong,
  @SerialName("permission")
  public val permission: AccessKeyPermissionView,
)
