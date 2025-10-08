package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.BlockIdSerializer
import kotlin.ULong
import kotlinx.serialization.Serializable

@Serializable(with = BlockIdSerializer::class)
public sealed class BlockId {
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @Serializable
  public data class BlockHeight(
    public val `value`: ULong,
  ) : BlockId()

  @Serializable
  public data class CryptoHash(
    public val `value`: io.github.hosseinkarami_dev.near.rpc.models.CryptoHash,
  ) : BlockId()
}
