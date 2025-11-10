package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.jvm.JvmInline
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
@JvmInline
public value class RpcSplitStorageInfoRequest(
  public val `value`: JsonElement,
)
