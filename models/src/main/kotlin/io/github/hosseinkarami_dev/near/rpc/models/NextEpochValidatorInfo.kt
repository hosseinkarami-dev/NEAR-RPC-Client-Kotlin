package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class NextEpochValidatorInfo(
  @SerialName("account_id")
  public val accountId: AccountId,
  @SerialName("public_key")
  public val publicKey: PublicKey,
  @SerialName("shards")
  public val shards: List<ShardId>,
  @SerialName("stake")
  public val stake: NearToken,
)
