package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class GlobalContractIdentifier {
  @Serializable
  public class CodeHash(
    @SerialName("CodeHash")
    public val codeHash: CryptoHash,
  ) : GlobalContractIdentifier()

  @Serializable
  public class AccountId(
    @SerialName("AccountId")
    public val accountId: io.github.hosseinkarami_dev.near.rpc.models.AccountId,
  ) : GlobalContractIdentifier()
}
