package io.github.hosseinkarami_dev.near.rpc.generator

import com.squareup.kotlinpoet.ANY
import com.squareup.kotlinpoet.BOOLEAN
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.DOUBLE
import com.squareup.kotlinpoet.INT
import com.squareup.kotlinpoet.LONG
import com.squareup.kotlinpoet.MAP
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.STRING
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asClassName
import com.squareup.kotlinpoet.asTypeName
import kotlin.collections.isNullOrEmpty

object SchemaHelper {

    //Property Analysis

    fun Schema.generateKdoc(): CodeBlock? {
        val schema = this
        return buildString {
            schema.description?.let { append(" * $it\n") }
            schema.minimum?.let { append(" * Minimum: $it\n") }
            schema.maximum?.let { append(" * Maximum: $it\n") }
            schema.format?.let { append(" * Format: $it\n") }
            schema.minItems?.let { append(" * Min Items: $it\n") }
            schema.maxItems?.let { append(" * Max Items: $it\n") }
            schema.nullable?.let { append(" * Nullable: $it\n") }
            schema.schemaNote?.let { append(" * Schema: $it\n") }
            schema.enum?.let { vals ->
                append(" * Possible values: ${vals.joinToString(", ") { v -> v ?: "null" }}\n")
            }
        }.takeIf { it.isNotBlank() }?.let { CodeBlock.of("%L", it.replace("%", "%%")) }
    }

    fun Schema.getPrimitiveTypeName(): TypeName? = when (type) {
        "string" -> STRING
        "boolean" -> BOOLEAN
        "number" -> DOUBLE
        "integer" -> when (format) {
            "uint64", "int64", "long" -> LONG
            "uint32", "int32" -> INT
            "uint16", "uint8", "uint" -> INT
            else -> INT
        }

        else -> null
    }

    fun resolveType(schema: Schema): TypeName {
        if (!schema.allOf.isNullOrEmpty()) {
            val types = schema.allOf.map { resolveType(it) }
            if (types.size == 1) return types.first()
            return ANY
        }

        // Handle anyOf / oneOf
        val combinators = schema.anyOf ?: schema.oneOf
        if (!combinators.isNullOrEmpty()) {
            var nullable = false
            val candidates = mutableListOf<TypeName>()
            combinators.forEach { candidate ->
                if (candidate.enum?.size == 1 && candidate.enum.contains(null)) {
                    nullable = true
                } else {
                    candidates += resolveType(candidate)
                }
            }
            val baseType = when (candidates.size) {
                0 -> ANY
                1 -> candidates.first()
                else -> ANY
            }
            return if (nullable || schema.nullable == true) baseType.copy(nullable = true) else baseType
        }

        val baseType: TypeName = when {
            schema.ref != null -> {
                val refClassName = schema.ref.substringAfterLast("/")
                ClassName("org.near.generator.models", refClassName)
            }

            schema.enum != null -> String::class.asTypeName()
            schema.isPrimitiveType() -> schema.getPrimitiveTypeName()!!
            schema.type == "array" -> {
                val itemType = schema.items?.let { resolveType(it) } ?: ANY
                List::class.asClassName().parameterizedBy(itemType)
            }

            schema.type == "object" -> {
                MAP.parameterizedBy(String::class.asTypeName(), ANY)
            }

            else -> ANY
        }

        return if (schema.nullable == true) baseType.copy(nullable = true) else baseType
    }

    fun Schema.isPrimitiveType() = getPrimitiveTypeName() != null && enum.isNullOrEmpty()

}