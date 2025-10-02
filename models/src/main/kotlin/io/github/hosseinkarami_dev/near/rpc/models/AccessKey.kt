package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Access key provides limited access to an account. Each access key belongs to some account and
 * is identified by a unique (within the account) public key. One account may have large number of
 * access keys. Access keys allow to act on behalf of the account by restricting transactions
 * that can be issued.
 * `account_id,public_key` is a key in the state
 */
@Serializable
public data class AccessKey(
  /**
   *  * Nonce for this access key, used for tx nonce generation. When access key is created, nonce
   * is set to `(block_height - 1) * 1e6` to avoid tx hash collision on access key re-creation.
   * See <https://github.com/near/nearcore/issues/3779> for more details.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("nonce")
  public val nonce: Long,
  /**
   *  * Defines permissions for this access key.
   */
  @SerialName("permission")
  public val permission: AccessKeyPermission,
)
