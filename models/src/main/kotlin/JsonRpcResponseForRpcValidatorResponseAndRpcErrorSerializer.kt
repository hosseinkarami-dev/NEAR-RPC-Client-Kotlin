package io.github.hosseinkarami_dev.near.rpc.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.serializer
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError
import kotlinx.serialization.json.*

object JsonRpcResponseForRpcValidatorResponseAndRpcErrorSerializer : KSerializer<JsonRpcResponseForRpcValidatorResponseAndRpcError> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError") {
        element("result", serializer<JsonElement>().descriptor)
        element("error", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: JsonRpcResponseForRpcValidatorResponseAndRpcError) {
        if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.Result -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["result"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorResponse>(), value.result)
                    map["id"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.String>(), value.id)
                    map["jsonrpc"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.String>(), value.jsonrpc)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.Error -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["error"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError>(), value.error)
                    map["id"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.String>(), value.id)
                    map["jsonrpc"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.String>(), value.jsonrpc)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.Result -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.Result>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.Error -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.Error>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): JsonRpcResponseForRpcValidatorResponseAndRpcError {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    throw SerializationException("Unknown discriminator (primitive) for JsonRpcResponseForRpcValidatorResponseAndRpcError")
                }
                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing JsonRpcResponseForRpcValidatorResponseAndRpcError")
                is JsonObject -> {
                    val jobj = element
                    if (jobj["result"] != null) {
                        val resultVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorResponse>(), jobj["result"] ?: throw SerializationException("Missing field 'result' for variant Result"))
                        val idVal = decoder.json.decodeFromJsonElement(serializer<kotlin.String>(), jobj["id"] ?: throw SerializationException("Missing field 'id' for variant Result"))
                        val jsonrpcVal = decoder.json.decodeFromJsonElement(serializer<kotlin.String>(), jobj["jsonrpc"] ?: throw SerializationException("Missing field 'jsonrpc' for variant Result"))
                        return io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.Result(resultVal, idVal, jsonrpcVal)
                    }
                    if (jobj["error"] != null) {
                        val errorVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError>(), jobj["error"] ?: throw SerializationException("Missing field 'error' for variant Error"))
                        val idVal = decoder.json.decodeFromJsonElement(serializer<kotlin.String>(), jobj["id"] ?: throw SerializationException("Missing field 'id' for variant Error"))
                        val jsonrpcVal = decoder.json.decodeFromJsonElement(serializer<kotlin.String>(), jobj["jsonrpc"] ?: throw SerializationException("Missing field 'jsonrpc' for variant Error"))
                        return io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.Error(errorVal, idVal, jsonrpcVal)
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "result" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant result: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.Result>(), obj)
                            }
                            "error" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant error: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.Error>(), obj)
                            }
                            else -> throw SerializationException("Unknown discriminator key for JsonRpcResponseForRpcValidatorResponseAndRpcError: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("changes_type")
                    for (cand in discriminatorCandidates) {
                        val candElem = jobj[cand]
                        if (candElem is JsonPrimitive) {
                            typeField = candElem.contentOrNull
                            if (typeField != null) break
                        }
                    }
                    if (typeField == null) {
                        val knownVariantNames = setOf("result", "error")
                        for ((k, v) in jobj.entries) {
                            if (v is JsonPrimitive && v.isString) {
                                val s = v.content
                                if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
                            }
                        }
                    }
                    if (typeField == null) throw SerializationException("Missing discriminator (one of changes_type) or recognizable variant in JsonRpcResponseForRpcValidatorResponseAndRpcError")
                    val tf = typeField.trim()

                    // try exact match of full variant name first
                    val tfFull = tf
                    when (tfFull) {
                        "result" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.Result>(), jobj)
                        "error" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.Error>(), jobj)
                        else -> { /* fallthrough to grouped handling */ }
                    }

                    // grouped handling by base token (e.g. account_changes -> ...by_block_id / ...by_finality / ...by_sync_checkpoint)
                    val tfLower = tf.lowercase()
                    // select candidate group based on contains/equals heuristics
                    var chosenGroupKey: String? = null
                    if (chosenGroupKey == null && ("result".lowercase() == tfLower || tfLower.contains("result".lowercase()) || "result".lowercase().contains(tfLower))) { chosenGroupKey = "result" }
                    if (chosenGroupKey == null && ("error".lowercase() == tfLower || tfLower.contains("error".lowercase()) || "error".lowercase().contains(tfLower))) { chosenGroupKey = "error" }
                    if (chosenGroupKey != null) {
                        when (chosenGroupKey) {
                            "result" -> {
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.Result>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'result' and tf='$tf'")
                            }
                            "error" -> {
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.Error>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'error' and tf='$tf'")
                            }
                            else -> { /* no group matched */ }
                        }
                    }

                    // fallback: try required-field matching and scoring heuristics
                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("result") && jobj.containsKey("id") && jobj.containsKey("jsonrpc")) requiredMatches.add(0)
                    if (jobj.containsKey("error") && jobj.containsKey("id") && jobj.containsKey("jsonrpc")) requiredMatches.add(1)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.Result>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.Error>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["result"] != null) matchCount++
                        if (jobj["id"] != null) matchCount++
                        if (jobj["jsonrpc"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["error"] != null) matchCount++
                        if (jobj["id"] != null) matchCount++
                        if (jobj["jsonrpc"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.Result>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.Error>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    // last resort: try decoding each data-class variant
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.Result>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.Error>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in JsonRpcResponseForRpcValidatorResponseAndRpcError")
                }
            }
        }
        throw SerializationException("Cannot deserialize JsonRpcResponseForRpcValidatorResponseAndRpcError with non-JSON decoder")
    }
}
