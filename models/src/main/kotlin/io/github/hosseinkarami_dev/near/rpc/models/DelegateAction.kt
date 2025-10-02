package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class DelegateAction(
  @SerialName("actions")
  public val actions: List<NonDelegateAction>,
  @SerialName("max_block_height")
  public val maxBlockHeight: Long,
  @SerialName("nonce")
  public val nonce: Long,
  @SerialName("public_key")
  public val publicKey: PublicKey,
  @SerialName("receiver_id")
  public val receiverId: AccountId,
  @SerialName("sender_id")
  public val senderId: AccountId,
)
