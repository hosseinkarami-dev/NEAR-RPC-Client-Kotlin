package io.github.hosseinkarami_dev.near.rpc.client

object Utils {
    inline fun <reified T> RpcResponse<*>.getResultOrNull(): T? = (this as? RpcResponse.Success<*>)?.result as T?
    inline fun <reified E : ErrorResult> RpcResponse<*>.getErrorOrNull(): E? = (this as? RpcResponse.Failure)?.error as? E
}