package io.github.hosseinkarami_dev.near.rpc.client

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class RpcError(
    val code: Int,
    val message: String,
    val data: JsonElement? = null
)