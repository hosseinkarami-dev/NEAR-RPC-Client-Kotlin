package io.github.hosseinkarami_dev.examples

import io.github.hosseinkarami_dev.near.rpc.client.ErrorResult
import io.github.hosseinkarami_dev.near.rpc.client.NearClient
import io.github.hosseinkarami_dev.near.rpc.client.RpcResponse
import io.github.hosseinkarami_dev.near.rpc.client.Utils.getResultOrNull
import io.github.hosseinkarami_dev.near.rpc.models.AccountId
import io.github.hosseinkarami_dev.near.rpc.models.BlockId
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.Finality
import io.github.hosseinkarami_dev.near.rpc.models.FunctionArgs
import io.github.hosseinkarami_dev.near.rpc.models.RpcBlockRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcBlockResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientNextBlockRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientNextBlockResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorsOrderedRequest
import io.github.hosseinkarami_dev.near.rpc.models.ValidatorStakeView
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json

fun main() = runBlocking {
    val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    val nearClient = NearClient(
        httpClient = httpClient,
        baseUrl = "https://rpc.mainnet.near.org"
    )

    // Block Details
    when (val response = nearClient.block(
        RpcBlockRequest.BlockId(BlockId.CryptoHash(CryptoHash("FnoNA3ZfnxFNQAytRAsauewqA4FuV4ZxQs6UXjpQAXpp")))
    )) {
        is RpcResponse.Failure -> {
            generateError(response.error)
        }

        is RpcResponse.Success -> {
            val result = response.getResultOrNull<RpcBlockResponse>()
            println("Result: $result")

        }
    }

    //View Account
    when (val response = nearClient.query(
        RpcQueryRequest.ViewAccountByFinality(
            finality = Finality.FINAL,
            accountId = AccountId("wrap.near"),
            requestType = RpcQueryRequest.ViewAccountByFinality.RequestType.VIEW_ACCOUNT
        )
    )) {
        is RpcResponse.Failure -> {
            generateError(response.error)
        }

        is RpcResponse.Success -> {
            val result = response.getResultOrNull<RpcQueryResponse>()
            println("Result: $result")

        }
    }

    //Transaction Status
    when (val response = nearClient.tx(
        RpcTransactionStatusRequest.SenderAccountId(
            senderAccountId = AccountId("sweat-relayer.near"),
            txHash = CryptoHash("B4PGu3RicwMrjhv4k4MGaUhnZrTqPrrRu5gH9jxtHH4J")
        )
    )) {
        is RpcResponse.Failure -> {
            generateError(response.error)
        }

        is RpcResponse.Success -> {
            val result = response.getResultOrNull<RpcTransactionResponse>()
            println("Result: $result")

        }
    }

    //Call Function
    when (val response = nearClient.query(
        RpcQueryRequest.CallFunctionByFinality(
            finality = Finality.FINAL,
            accountId = AccountId("wrap.near"),
            methodName = "ft_balance_of2",
            argsBase64 = FunctionArgs("eyJhY2NvdW50X2lkIjoiZnJvbC5uZWFyIn0K"),
            requestType = RpcQueryRequest.CallFunctionByFinality.RequestType.CALL_FUNCTION
        )
    )) {
        is RpcResponse.Failure -> {
            generateError(response.error)
        }

        is RpcResponse.Success -> {
            val result = response.getResultOrNull<RpcTransactionResponse>()
            println("Result: $result")

        }
    }

    //Next Light Client Block
    when (val response = nearClient.nextLightClientBlock(
        RpcLightClientNextBlockRequest(
            lastBlockHash = CryptoHash("4GoYYrySh93RJZmTnKo7mFnXi2PMPXUJ6GW2sU4xt4MB")
        )
    )) {
        is RpcResponse.Failure -> {
            generateError(response.error)
        }

        is RpcResponse.Success -> {
            val result = response.getResultOrNull<RpcLightClientNextBlockResponse>()
            println("Result: $result")

        }
    }

    // Experimental Validators Ordered
    when (val response = nearClient.experimentalValidatorsOrdered(
        RpcValidatorsOrderedRequest(
            BlockId.BlockHeight(167697415U)
        )
    )) {
        is RpcResponse.Failure -> {
            generateError(response.error)
        }

        is RpcResponse.Success -> {
            val result = response.getResultOrNull<List<ValidatorStakeView>>()
            println("Result: $result")

        }
    }

    // Experimental Changes in Block
    when (val response = nearClient.experimentalChangesInBlock(
        RpcStateChangesInBlockRequest.Finality(
            Finality.FINAL
        )
    )
    ) {
        is RpcResponse.Failure -> {
            generateError(response.error)
        }

        is RpcResponse.Success -> {
            val result = response.getResultOrNull<RpcStateChangesInBlockByTypeResponse>()
            println("Result: $result")

        }
    }

    httpClient.close()
}

fun generateError(error: ErrorResult) {
    when (error) {
        is ErrorResult.Rpc<*> -> {
            println("❌ RPC Error: ${error.error.toString()}")
        }

        is ErrorResult.Http -> {
            println("❌ HTTP Error: Status ${error.statusCode}, body: ${error.body}")
        }

        is ErrorResult.Timeout -> {
            println("⏳ Timeout Error: ${error.cause?.message}")
        }

        is ErrorResult.Network -> {
            println("🌐 Network Error: ${error.cause.message}")
        }

        is ErrorResult.Deserialization -> {
            println("🔄 Deserialization Error: ${error.cause.message}, raw body: ${error.rawBody}")
        }

        is ErrorResult.Cancellation -> {
            println("🚫 Request Cancelled: ${error.cause?.message}")
        }

        is ErrorResult.Unknown -> {
            println("❓ Unknown Error: ${error.message}, cause: ${error.cause?.message}")
        }

        is ErrorResult.RpcRuntime -> {
            println("⚠️ Runtime RPC Error: ${error.error}")
        }
    }
}