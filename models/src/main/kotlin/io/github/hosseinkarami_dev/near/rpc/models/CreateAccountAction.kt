package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.jvm.JvmInline
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 *  * Create account action
 */
@Serializable
@JvmInline
public value class CreateAccountAction(
  public val `value`: JsonElement,
)
