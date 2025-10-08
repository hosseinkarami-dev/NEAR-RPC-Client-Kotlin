package io.github.hosseinkarami_dev.near.rpc.client

//import io.github.hosseinkarami_dev.near.rpc.models.RpcError
//import kotlinx.serialization.json.JsonPrimitive
//
//object Utils {
//    inline fun <reified T> RpcResponse<*>.getResultOrNull(): T? = (this as? RpcResponse.Success<*>)?.result as T?
//}
//
//fun localToRpcError(e: Throwable, localCode: Long = -1002L): RpcError.InternalError {
//    return RpcError.InternalError(
//        cause = JsonPrimitive(e::class.simpleName ?: "LocalException"),
//        name = RpcError.InternalError.Name.INTERNAL_ERROR,
//        code = localCode,
//        `data` = null,
//        message = e.message ?: "Local error: ${e::class.simpleName}"
//    )
//}