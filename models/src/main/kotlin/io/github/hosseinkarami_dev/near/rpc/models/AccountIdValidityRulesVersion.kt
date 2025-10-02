package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.jvm.JvmInline
import kotlinx.serialization.Serializable

/**
 *  * Minimum: 0.0
 *  * Maximum: 255.0
 *  * Format: uint8
 */
@Serializable
@JvmInline
public value class AccountIdValidityRulesVersion(
  public val `value`: Int,
)
