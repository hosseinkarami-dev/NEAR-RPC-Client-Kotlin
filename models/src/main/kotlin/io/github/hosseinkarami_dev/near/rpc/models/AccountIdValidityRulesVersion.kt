package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.jvm.JvmInline
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
public value class AccountIdValidityRulesVersion(
  public val `value`: Int,
)
