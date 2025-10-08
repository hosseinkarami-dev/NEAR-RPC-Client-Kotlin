package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.jvm.JvmInline
import kotlinx.serialization.Serializable

/**
 *  * This type is used to mark keys (arrays of bytes) that are queried from store.
 *
 * NOTE: Currently, this type is only used in the view_client and RPC to be able to transparently
 * pretty-serialize the bytes arrays as base64-encoded strings (see `serialize.rs`).
 *  * Format: bytes
 */
@Serializable
@JvmInline
public value class StoreKey(
  public val `value`: String,
)
