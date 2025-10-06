package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.jvm.JvmInline
import kotlinx.serialization.Serializable

/**
 *  * Epoch identifier -- wrapped hash, to make it easier to distinguish.
 * EpochId of epoch T is the hash of last block in T-2
 * EpochId of first two epochs is 0
 */
@Serializable
@JvmInline
public value class EpochId(
  public val `value`: String,
)
