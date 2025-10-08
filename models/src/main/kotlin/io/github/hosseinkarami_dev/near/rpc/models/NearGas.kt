package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.ULong
import kotlin.jvm.JvmInline
import kotlinx.serialization.Serializable

/**
 *  * Minimum: 0.0
 *  * Format: uint64
 */
@Serializable
@JvmInline
public value class NearGas(
  public val `value`: ULong,
)
