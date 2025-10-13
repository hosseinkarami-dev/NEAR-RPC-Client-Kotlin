package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RangeOfUint64(
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("end")
  public val end: ULong,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("start")
  public val start: ULong,
)
