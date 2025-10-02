package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.jvm.JvmInline
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
public value class AccountId(
  public val `value`: String,
)
