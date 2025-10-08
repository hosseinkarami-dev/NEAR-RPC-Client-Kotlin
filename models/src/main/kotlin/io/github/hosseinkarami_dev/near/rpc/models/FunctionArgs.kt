package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.jvm.JvmInline
import kotlinx.serialization.Serializable

/**
 *  * This type is used to mark function arguments.
 *
 * NOTE: The main reason for this to exist (except the type-safety) is that the value is
 * transparently serialized and deserialized as a base64-encoded string when serde is used
 * (serde_json).
 *  * Format: bytes
 */
@Serializable
@JvmInline
public value class FunctionArgs(
  public val `value`: String,
)
