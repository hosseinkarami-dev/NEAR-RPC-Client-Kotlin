package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.Serializable

@Serializable
public sealed class BlockId {
  @Serializable
  public class BlockHeight() : BlockId()

  @Serializable
  public class CryptoHash(
    public val `value`: io.github.hosseinkarami_dev.near.rpc.models.CryptoHash,
  ) : BlockId()
}
