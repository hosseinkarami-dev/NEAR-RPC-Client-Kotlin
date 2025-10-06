package io.github.hosseinkarami_dev.near.rpc.generator.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import io.github.hosseinkarami_dev.near.rpc.generator.serializers.AdditionalPropertiesSerializer

/**
 * Lightweight Kotlin models for the parts of OpenAPI we consume.
 * Keep these intentionally permissive — we treat many fields as optional
 * because the upstream spec is large and heterogeneous.
 */

@Serializable
data class OpenApiSpec(
    val openapi: String,
    val info: Info,
    val paths: Map<String, PathItem> = emptyMap(),
    val components: Components = Components(emptyMap())
)

@Serializable
data class Info(
    val title: String,
    val version: String
)

@Serializable
data class PathItem(
    // we only care about GET/POST operations for JSON-RPC mapping
    val post: Operation? = null,
    val get: Operation? = null
)

@Serializable
data class Operation(
    val summary: String? = null,
    val operationId: String,
    val description: String? = null,
    val requestBody: RequestBody? = null,
    val responses: Map<String, Response> = emptyMap()
)

@Serializable
data class RequestBody(
    val content: Map<String, MediaType> = emptyMap()
)

@Serializable
data class MediaType(
    // we keep schema raw as JsonElement for flexible analysis
    val schema: JsonElement? = null
)

@Serializable
data class Response(
    val description: String? = null,
    val content: Map<String, MediaType>? = null
)

@Serializable
data class Components(
    val schemas: Map<String, Schema> = emptyMap()
)

/**
 * A permissive Schema model that covers the common OpenAPI constructs we need:
 * - type, properties, items, oneOf/anyOf/allOf, enum, nullable, format, description, min/max
 * - and $ref (mapped to `ref`)
 *
 * We keep fields nullable/defaulted so decoding of the NEAR spec is robust.
 */
@Serializable
data class Schema(
    val title: String? = null,
    val type: String? = null,
    val properties: Map<String, Schema>? = null,
    @SerialName("\$ref")
    val ref: String? = null,
    val items: Schema? = null,
    val oneOf: List<Schema>? = null,
    val anyOf: List<Schema>? = null,
    val allOf: List<Schema>? = null,
    val enum: List<String?>? = null,
    val nullable: Boolean? = null,
    val description: String? = null,
    val format: String? = null,
    val minimum: Double? = null,
    val maximum: Double? = null,
    val maxItems: Int? = null,
    val minItems: Int? = null,
    @Serializable(with = AdditionalPropertiesSerializer::class)
    val additionalProperties: Any? = null,
    val patternProperties: Map<String, Schema>? = null,
    val required: List<String>? = null,
    val default: JsonElement? = null,
    @SerialName("\$schema")
    val schemaNote: String? = null,
)