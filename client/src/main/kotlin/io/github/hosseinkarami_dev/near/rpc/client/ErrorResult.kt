package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.models.RpcError

sealed class ErrorResult {
    data class Rpc(val error: RpcError): ErrorResult()
    data class RpcRuntime(val error: String): ErrorResult()

    data class Http(
        val statusCode: Int,
        val body: String? = null
    ): ErrorResult()

    data class Timeout(val cause: Throwable? = null): ErrorResult()
    data class Network(val cause: Throwable): ErrorResult()
    data class Deserialization(val cause: Throwable, val rawBody: String? = null): ErrorResult()
    data class Cancellation(val cause: Throwable? = null): ErrorResult()

    // fallback for anything unexpected
    data class Unknown(val message: String? = null, val cause: Throwable? = null): ErrorResult()
}