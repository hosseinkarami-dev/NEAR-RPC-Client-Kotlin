package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RangeOfUint64(
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("end")
  public val end: Long,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("start")
  public val start: Long,
)
