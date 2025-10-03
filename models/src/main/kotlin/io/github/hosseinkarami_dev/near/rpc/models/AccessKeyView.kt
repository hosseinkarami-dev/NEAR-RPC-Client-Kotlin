package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
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
  public val nonce: Long,
  @SerialName("permission")
  public val permission: AccessKeyPermissionView,
) {
  init {
    require((nonce?.toDouble() ?: 0.0) >= 0.0) { "AccessKeyView.nonce must be >= 0.0" }}
}
