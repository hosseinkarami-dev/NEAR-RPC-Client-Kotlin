package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.models.RpcError

sealed class RpcResponse<out T> {
    data class Success<T>(val result: T): RpcResponse<T>()
    data class Failure(val error: RpcError): RpcResponse<Nothing>()
}