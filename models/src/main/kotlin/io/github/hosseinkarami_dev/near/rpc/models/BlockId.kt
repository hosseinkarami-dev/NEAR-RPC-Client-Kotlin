package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.Serializable

@Serializable
public sealed class BlockId {
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @Serializable
  public class BlockHeight() : BlockId()

  @Serializable
  public class CryptoHash(
    public val `value`: io.github.hosseinkarami_dev.near.rpc.models.CryptoHash,
  ) : BlockId()
}
