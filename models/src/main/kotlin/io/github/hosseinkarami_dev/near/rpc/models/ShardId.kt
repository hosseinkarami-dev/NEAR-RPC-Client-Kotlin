package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlin.jvm.JvmInline
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
public value class ShardId(
  public val `value`: Long,
)
