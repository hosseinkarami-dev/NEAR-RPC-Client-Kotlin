package io.github.hosseinkarami_dev.near.rpc.generator

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json

private const val OPENAPI_URL =
    "https://raw.githubusercontent.com/near/nearcore/master/chain/jsonrpc/openapi/openapi.json"

fun fetchOpenApiSpec(): OpenApiSpec = runBlocking {
    HttpClient(CIO).use { client ->
        val response: HttpResponse = client.get(OPENAPI_URL)

        if (response.status != HttpStatusCode.OK) {
            error("Failed to fetch OpenAPI spec: ${response.status}")
        }
        Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }.decodeFromString(OpenApiSpec.serializer(), response.bodyAsText())
    }
}