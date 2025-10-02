package io.github.hosseinkarami_dev.near.rpc.client

import kotlinx.serialization.Serializable

@Serializable
data class JsonRpcEnvelope<T>(
    val jsonrpc: String,
    val id: String? = null,
    val result: T? = null,
    val error: RpcError? = null
)