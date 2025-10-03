package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlinx.serialization.Serializable

@Serializable
public sealed class BlockId {
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @Serializable
  public data class BlockHeight(
    public val `value`: Long,
  ) : BlockId()

  @Serializable
  public data class CryptoHash(
    public val `value`: io.github.hosseinkarami_dev.near.rpc.models.CryptoHash,
  ) : BlockId()
}
