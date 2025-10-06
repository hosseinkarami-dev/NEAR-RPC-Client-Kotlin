package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.jvm.JvmInline
import kotlinx.serialization.Serializable

/**
 *  * Peer id is the public key.
 */
@Serializable
@JvmInline
public value class PeerId(
  public val `value`: String,
)
