package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.UInt
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Gas key is like an access key, except it stores a balance separately, and transactions signed
 * with it deduct their cost from the gas key balance instead of the account balance.
 */
@Serializable
public data class GasKey(
  /**
   *  * The balance of the gas key.
   */
  @SerialName("balance")
  public val balance: NearToken,
  /**
   *  * The number of nonces this gas key has.
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("num_nonces")
  public val numNonces: UInt,
  /**
   *  * Defines the permissions for this gas key.
   * If this is a `FunctionCallPermission`, the allowance must be None (unlimited).
   */
  @SerialName("permission")
  public val permission: AccessKeyPermission,
)
