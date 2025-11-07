package io.github.hosseinkarami_dev.near.rpc.generator.generators

import io.github.hosseinkarami_dev.near.rpc.generator.OpenApiSpec
import io.github.hosseinkarami_dev.near.rpc.generator.Schema
import io.github.hosseinkarami_dev.near.rpc.generator.pascalCase
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import java.io.File
import kotlin.math.absoluteValue
import kotlin.random.Random

object MockGenerator {
    private val json = Json { prettyPrint = true; encodeDefaults = true }
    private const val MAX_DEPTH = 30

    fun generate(spec: OpenApiSpec, targetDirs: List<File>) {
        val schemas = spec.components.schemas
        if (schemas.isEmpty()) {
            println("No schemas found in OpenAPI spec")
            return
        }

        targetDirs.forEach { it.mkdirs() }

        var success = 0
        var failed = 0

        for ((schemaName, _) in schemas.toSortedMap()) {
            try {
                val sample = generateSampleForSchemaName(schemaName, spec)
                val fileName = schemaName.pascalCase() + ".json"
                val text = json.encodeToString(JsonElement.serializer(), sample ?: JsonNull)
                targetDirs.forEach { dir -> File(dir, fileName).writeText(text) }
                success++
            } catch (t: Throwable) {
                println("❌ Failed to generate $schemaName test: ${t.message}")
                t.printStackTrace()
                failed++
            }
        }

        println("✨ Mock generation complete! success=$success failed=$failed")
        targetDirs.forEach { println("  - ${it.absolutePath}") }
    }

    private fun generateSampleForSchemaName(schemaName: String, spec: OpenApiSpec): JsonElement? {
        val schema = spec.components.schemas[schemaName] ?: return JsonNull
        return generateSample(schema, spec, 0, mutableSetOf())
    }

    private fun resolveRef(ref: String?, spec: OpenApiSpec): Schema? {
        if (ref == null) return null
        val name = if (ref.startsWith("#/components/schemas/")) ref.removePrefix("#/components/schemas/") else ref
        return spec.components.schemas[name]
    }

    /**
     * Resolve $ref chain until a non-ref schema or loop is encountered.
     */
    private fun resolveRefDeep(schema: Schema?, spec: OpenApiSpec, seen: MutableSet<String> = mutableSetOf()): Schema? {
        if (schema == null) return null
        var cur = schema
        while (true) {
            val r = cur?.ref ?: break
            if (seen.contains(r)) break
            seen.add(r)
            val next = resolveRef(r, spec) ?: break
            cur = next
        }
        return cur
    }

    private fun generateSample(schema: Schema?, spec: OpenApiSpec, depth: Int, seen: MutableSet<String>): JsonElement? {
        if (schema == null) return JsonNull
        if (depth > MAX_DEPTH) return JsonNull
        schema.default?.let { return it }

        val resolvedRoot = resolveRefDeep(schema, spec, seen.toMutableSet()) ?: schema

        // If wrapper has allOf -> generate sample for allOf subs and also include inline properties
        resolvedRoot.allOf?.let { all ->
            return generateSampleAllOf(all, resolvedRoot, spec, depth + 1, seen)
        }

        // If wrapper has oneOf / anyOf -> handle similarly (pick variant + merge inline props)
        val variants = (resolvedRoot.oneOf ?: resolvedRoot.anyOf)?.toList()
        if (!variants.isNullOrEmpty()) {
            return generateSampleOneOfAnyOf(variants, resolvedRoot, spec, depth + 1, seen)
        }

        // Enum -> pick first value
        resolvedRoot.enum?.firstOrNull()?.let { return JsonPrimitive(it) }

        // Array -> generate items respecting minItems/maxItems when present
        resolvedRoot.items?.let { item ->
            val size = when {
                resolvedRoot.minItems != null -> resolvedRoot.minItems
                resolvedRoot.maxItems != null -> maxOf(1, resolvedRoot.maxItems)
                else -> 1
            }

            val list = mutableListOf<JsonElement>()
            for (i in 0 until maxOf(0, size)) {
                val elem = generateSample(item, spec, depth + 1, seen.toMutableSet()) ?: fallbackValue(item)
                list.add(elem)
            }
            return JsonArray(list)
        }

        // Object-like -> generate properties, additionalProperties, patternProperties
        val isObject = resolvedRoot.type == "object" || resolvedRoot.properties != null ||
                resolvedRoot.additionalProperties != null || resolvedRoot.patternProperties != null

        if (isObject) {
            val props = resolvedRoot.properties ?: emptyMap()
            val obj = buildJsonObject {
                for ((propName, propSchema) in props) {
                    val child = generateSample(propSchema, spec, depth + 1, seen.toMutableSet())
                    put(propName, child ?: fallbackValue(propSchema))
                }

                // additionalProperties: if it's a Schema, generate one example
                when (val addp = resolvedRoot.additionalProperties) {
                    is Schema -> {
                        val addVal = generateSample(addp, spec, depth + 1, seen.toMutableSet()) ?: JsonPrimitive("s")
                        put("additionalProp1", addVal)
                    }
                }

                // patternProperties -> produce one example per pattern (best-effort)
                resolvedRoot.patternProperties?.forEach { (pattern, patternSchema) ->
                    val key = when (pattern) {
                        "^\\d+$" -> Random.nextInt(0, 999).toString()
                        "^[a-zA-Z_][a-zA-Z0-9_]*$" -> listOf("key_a", "item_1", "field_x").random()
                        else -> "generated_key_${pattern.hashCode().absoluteValue % 1000}"
                    }
                    val v = generateSample(patternSchema, spec, depth + 1, seen.toMutableSet()) ?: JsonPrimitive("s")
                    put(key, v)
                }
            }
            return obj
        }

        // Primitives (use declared minimum/maximum where available for numeric types)
        return when (resolvedRoot.type) {
            "string" -> JsonPrimitive("s")
            "integer" -> {
                // prefer minimum if present, else 0
                val min = resolvedRoot.minimum?.let { toIntSafely(it) } ?: 0
                JsonPrimitive(min)
            }
            "number" -> {
                val min = resolvedRoot.minimum?.let { toDoubleSafely(it) } ?: 0.0
                JsonPrimitive(min)
            }
            "boolean" -> JsonPrimitive(true)
            else -> JsonNull
        }
    }

    private fun generateSampleAllOf(
        all: List<Schema>,
        parentSchema: Schema,
        spec: OpenApiSpec,
        depth: Int,
        seen: MutableSet<String>
    ): JsonElement {
        val mergedFromSubs = mutableMapOf<String, JsonElement>()
        var primitiveFromSubs: JsonElement? = null

        for ((i, sub) in all.withIndex()) {
            val resolvedSub = resolveRefDeep(sub, spec, seen.toMutableSet()) ?: sub
            val sample = generateSample(resolvedSub, spec, depth + 1, seen.toMutableSet())
            if (sample != null && sample !is JsonObject) {
                // keep track of primitive (but don't immediately return — we must consider inline parent props)
                primitiveFromSubs = sample
            }
            if (sample is JsonObject) {
                for ((k, v) in sample) mergedFromSubs[k] = v
            }
        }

        // Generate inline parent properties and merge them (parent props should override subs on collision)
        val parentProps = parentSchema.properties ?: emptyMap()
        val mergedFromParentProps = mutableMapOf<String, JsonElement>()
        for ((propName, propSchema) in parentProps) {
            val valGenerated = generateSample(propSchema, spec, depth + 1, seen.toMutableSet()) ?: fallbackValue(propSchema)
            mergedFromParentProps[propName] = valGenerated
        }

        // If no object parts and parent props empty but we have a primitive -> return primitive (e.g., FullAccess)
        if (mergedFromSubs.isEmpty() && mergedFromParentProps.isEmpty() && primitiveFromSubs != null) {
            return primitiveFromSubs
        }

        // Merge subs + parent props (parent props take precedence)
        val finalMap = mutableMapOf<String, JsonElement>()
        finalMap.putAll(mergedFromSubs)
        finalMap.putAll(mergedFromParentProps)

        return if (finalMap.isNotEmpty()) {
            buildJsonObject { finalMap.forEach { (k, v) -> put(k, v) } }
        } else {
            // fallback: return empty object to indicate presence
            buildJsonObject {}
        }
    }
    private fun generateSampleOneOfAnyOf(
        variants: List<Schema>,
        parent: Schema,
        spec: OpenApiSpec,
        depth: Int,
        seen: MutableSet<String>
    ): JsonElement {
        // order: prefer ref, then enum, then those with properties/allOf/oneOf
        val ordered = variants.sortedWith(
            compareByDescending<Schema> { it.ref != null }
                .thenByDescending { it.enum?.isNotEmpty() == true }
                .thenByDescending { (it.properties?.isNotEmpty() == true) || (it.allOf?.isNotEmpty() == true) || (it.oneOf?.isNotEmpty() == true) }
        )

        val parentProps = parent.properties ?: emptyMap()
        // Try variants
        for ((idx, v) in ordered.withIndex()) {
            val resolved = resolveRefDeep(v, spec, seen.toMutableSet()) ?: v
            val sample = when {
                !resolved.enum.isNullOrEmpty() -> JsonPrimitive(resolved.enum.first())
                else -> generateSample(resolved, spec, depth + 1, seen.toMutableSet())
            }

            if (sample == null) continue

            // If primitive
            if (sample is JsonPrimitive) {
                // If parent has no inline props, return primitive directly (e.g., FullAccess)
                if (parentProps.isEmpty()) {
                    return sample
                } else {
                    // Parent has inline properties — preserve them and include the primitive under a synthetic key `_variant`.
                    // (Note: variant was primitive here, so we cannot merge its named properties directly.)
                    val merged = mutableMapOf<String, JsonElement>()
                    // generate parent props values
                    for ((pn, ps) in parentProps) {
                        merged[pn] = generateSample(ps, spec, depth + 1, seen.toMutableSet()) ?: fallbackValue(ps)
                    }
                    // keep variant value visible
                    merged["_variant"] = sample
                    return buildJsonObject { merged.forEach { (k, v) -> put(k, v) } }
                }
            }

            // If non-empty object -> merge with parent inline props (variant overrides parent)
            if (sample is JsonObject && sample.isNotEmpty()) {
                val merged = mutableMapOf<String, JsonElement>()
                // start with parent props (common)
                for ((pn, ps) in parentProps) {
                    merged[pn] = generateSample(ps, spec, depth + 1, seen.toMutableSet()) ?: fallbackValue(ps)
                }
                // overlay variant properties (they take precedence over parent's values)
                sample.forEach { (k, v) -> merged[k] = v }
                return buildJsonObject { merged.forEach { (k, v) -> put(k, v) } }
            }

            // if sample is empty object -> try next variant
        }

        // Fallback: try to merge parent inline properties with the first variant's declared properties (not generated)
        val first = resolveRefDeep(variants.first(), spec, seen.toMutableSet()) ?: variants.first()
        val mergedProps = (parent.properties ?: emptyMap()) + (first.properties ?: emptyMap())
        val mergedReq = ((parent.required ?: emptyList()) + (first.required ?: emptyList())).distinct()
        val mergedSchema = Schema(type = "object", properties = mergedProps, required = mergedReq.ifEmpty { null })
        val fallback = generateSample(mergedSchema, spec, depth + 1, seen.toMutableSet())
        return fallback ?: buildJsonObject {}
    }

    private fun fallbackValue(schema: Schema?): JsonElement = when (schema?.type) {
        "array" -> JsonArray(emptyList())
        "object" -> buildJsonObject {}
        "integer" -> JsonPrimitive(0)
        "number" -> JsonPrimitive(0.0)
        "boolean" -> JsonPrimitive(true)
        else -> JsonPrimitive("s")
    }

    // small helpers to safely convert possible numeric minimum/maximum values that might be Double or Int
    private fun toIntSafely(value: Any): Int {
        return when (value) {
            is Int -> value
            is Long -> value.toInt()
            is Double -> value.toInt()
            is Float -> value.toInt()
            is Number -> value.toInt()
            else -> 0
        }
    }

    private fun toDoubleSafely(value: Any): Double {
        return when (value) {
            is Double -> value
            is Float -> value.toDouble()
            is Int -> value.toDouble()
            is Long -> value.toDouble()
            is Number -> value.toDouble()
            else -> 0.0
        }
    }
}
