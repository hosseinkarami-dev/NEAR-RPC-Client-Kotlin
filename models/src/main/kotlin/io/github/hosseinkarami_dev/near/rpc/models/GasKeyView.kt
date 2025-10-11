package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.UInt
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class GasKeyView(
  @SerialName("balance")
  public val balance: NearToken,
  /**
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("num_nonces")
  public val numNonces: UInt,
  @SerialName("permission")
  public val permission: AccessKeyPermissionView,
)
