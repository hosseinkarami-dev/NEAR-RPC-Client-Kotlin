package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.GlobalContractIdentifierViewSerializer
import kotlinx.serialization.Serializable

@Serializable(with = GlobalContractIdentifierViewSerializer::class)
public sealed class GlobalContractIdentifierView {
  @Serializable
  public data class CryptoHash(
    public val `value`: io.github.hosseinkarami_dev.near.rpc.models.CryptoHash,
  ) : GlobalContractIdentifierView()

  @Serializable
  public data class AccountId(
    public val `value`: io.github.hosseinkarami_dev.near.rpc.models.AccountId,
  ) : GlobalContractIdentifierView()
}
