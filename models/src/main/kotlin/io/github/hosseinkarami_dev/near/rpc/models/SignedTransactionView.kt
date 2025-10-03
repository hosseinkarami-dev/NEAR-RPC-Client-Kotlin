package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class SignedTransactionView(
  @SerialName("actions")
  public val actions: List<ActionView>,
  @SerialName("hash")
  public val hash: CryptoHash,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("nonce")
  public val nonce: Long,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("priority_fee")
  public val priorityFee: Long? = 0L,
  @SerialName("public_key")
  public val publicKey: PublicKey,
  @SerialName("receiver_id")
  public val receiverId: AccountId,
  @SerialName("signature")
  public val signature: Signature,
  @SerialName("signer_id")
  public val signerId: AccountId,
)
