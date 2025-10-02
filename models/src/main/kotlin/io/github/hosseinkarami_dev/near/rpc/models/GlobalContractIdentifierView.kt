package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.Serializable

@Serializable
public sealed class GlobalContractIdentifierView {
  @Serializable
  public class CryptoHash(
    public val `value`: io.github.hosseinkarami_dev.near.rpc.models.CryptoHash,
  ) : GlobalContractIdentifierView()

  @Serializable
  public class AccountId(
    public val `value`: io.github.hosseinkarami_dev.near.rpc.models.AccountId,
  ) : GlobalContractIdentifierView()
}
