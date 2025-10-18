package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
public data class RpcSplitStorageInfoRequest(
  public val `value`: JsonElement,
)
