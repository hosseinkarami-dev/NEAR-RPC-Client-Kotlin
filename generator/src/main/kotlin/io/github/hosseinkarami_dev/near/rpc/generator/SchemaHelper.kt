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

    fun Schema.isPrimitiveType() = getPrimitiveTypeName() != null && enum.isNullOrEmpty()

}