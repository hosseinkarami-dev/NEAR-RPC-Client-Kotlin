package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Height and hash of a block
 */
@Serializable
public data class BlockStatusView(
  @SerialName("hash")
  public val hash: CryptoHash,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("height")
  public val height: Long,
) {
  init {
    require((height?.toDouble() ?: 0.0) >= 0.0) { "BlockStatusView.height must be >= 0.0" }}
}
