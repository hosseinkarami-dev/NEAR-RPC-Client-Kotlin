package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.models.RpcError

sealed class ErrorResult {
    data class Rpc(val error: RpcError): ErrorResult()
    data class UnknownError(val message: String): ErrorResult()
}