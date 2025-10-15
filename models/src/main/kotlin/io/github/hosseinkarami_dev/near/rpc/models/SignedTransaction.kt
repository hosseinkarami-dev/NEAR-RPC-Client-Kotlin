package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.jvm.JvmInline
import kotlinx.serialization.Serializable

/**
 *  * Format: byte
 */
@Serializable
@JvmInline
public value class SignedTransaction(
  public val `value`: String,
)
