package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.ULong
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * This action allows to execute the inner actions behalf of the defined sender.
 */
@Serializable
public data class DelegateAction(
  /**
   *  * List of actions to be executed.
   *
   * With the meta transactions MVP defined in NEP-366, nested
   * DelegateActions are not allowed. A separate type is used to enforce it.
   */
  @SerialName("actions")
  public val actions: List<NonDelegateAction>,
  /**
   *  * The maximal height of the block in the blockchain below which the given DelegateAction is valid.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_block_height")
  public val maxBlockHeight: ULong,
  /**
   *  * Nonce to ensure that the same delegate action is not sent twice by a
   * relayer and should match for given account's `public_key`.
   * After this action is processed it will increment.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("nonce")
  public val nonce: ULong,
  /**
   *  * Public key used to sign this delegated action.
   */
  @SerialName("public_key")
  public val publicKey: PublicKey,
  /**
   *  * Receiver of the delegated actions.
   */
  @SerialName("receiver_id")
  public val receiverId: AccountId,
  /**
   *  * Signer of the delegated actions
   */
  @SerialName("sender_id")
  public val senderId: AccountId,
)
