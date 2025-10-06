package io.github.hosseinkarami_dev.near.rpc.generator

import io.github.hosseinkarami_dev.near.rpc.generator.models.OpenApiSpec
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json

fun fetchOpenApiSpec(openApiUrl: String): OpenApiSpec = runBlocking {
    HttpClient(CIO).use { client ->
        val response: HttpResponse = client.get(openApiUrl)

        if (response.status != HttpStatusCode.OK) {
            error("Failed to fetch OpenAPI spec: ${response.status}")
        }
        Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }.decodeFromString(OpenApiSpec.serializer(), response.bodyAsText())
    }
}