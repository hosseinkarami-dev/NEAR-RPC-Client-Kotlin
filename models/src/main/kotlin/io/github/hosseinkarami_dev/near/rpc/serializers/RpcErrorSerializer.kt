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
import io.github.hosseinkarami_dev.near.rpc.models.RpcError
import kotlinx.serialization.json.*

object RpcErrorSerializer : KSerializer<RpcError> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcError") {
        element("REQUEST_VALIDATION_ERROR", serializer<JsonElement>().descriptor)
        element("HANDLER_ERROR", serializer<JsonElement>().descriptor)
        element("INTERNAL_ERROR", serializer<JsonElement>().descriptor)
    }

    // --- helper functions ---
    private fun <T> tryDecode(json: Json, serExpr: KSerializer<T>, elem: JsonElement): T = json.decodeFromJsonElement(serExpr, elem)

    override fun serialize(encoder: Encoder, value: RpcError) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.RpcError.RequestValidationError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcRequestValidationErrorKind>(), value.cause)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.RequestValidationError.Name>(), value.name)
                    map["code"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.Long>(), value.code)
                    if (value.data != null) {
                        map["data"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlinx.serialization.json.JsonElement?>(), value.data)
                    }
                    map["message"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.String>(), value.message)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcError.HandlerError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlinx.serialization.json.JsonElement>(), value.cause)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.HandlerError.Name>(), value.name)
                    map["code"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.Long>(), value.code)
                    if (value.data != null) {
                        map["data"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlinx.serialization.json.JsonElement?>(), value.data)
                    }
                    map["message"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.String>(), value.message)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcError.InternalError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlinx.serialization.json.JsonElement>(), value.cause)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.InternalError.Name>(), value.name)
                    map["code"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.Long>(), value.code)
                    if (value.data != null) {
                        map["data"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlinx.serialization.json.JsonElement?>(), value.data)
                    }
                    map["message"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.String>(), value.message)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.RpcError.RequestValidationError -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.RequestValidationError>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcError.HandlerError -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.HandlerError>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcError.InternalError -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.InternalError>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): RpcError {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    throw SerializationException("Unknown discriminator (primitive) for RpcError")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing RpcError")

                is JsonObject -> {
                    val jobj = element
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "REQUEST_VALIDATION_ERROR" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant REQUEST_VALIDATION_ERROR: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.RequestValidationError>(), obj)
                            }
                            "HANDLER_ERROR" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant HANDLER_ERROR: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.HandlerError>(), obj)
                            }
                            "INTERNAL_ERROR" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant INTERNAL_ERROR: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.InternalError>(), obj)
                            }
                            else -> throw SerializationException("Unknown discriminator key for RpcError: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("name")
                    for (cand in discriminatorCandidates) {
                        val candElem = jobj[cand]
                        if (candElem is JsonPrimitive) {
                            typeField = candElem.contentOrNull
                            if (typeField != null) break
                        }
                    }
                    if (typeField == null) {
                        val knownVariantNames = setOf("REQUEST_VALIDATION_ERROR", "HANDLER_ERROR", "INTERNAL_ERROR")
                        for ((k, v) in jobj.entries) {
                            if (v is JsonPrimitive && v.isString) {
                                val s = v.content
                                if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
                            }
                        }
                    }

                    if (typeField != null) {
                        val tf = typeField.trim()
                        // try exact match of full variant name first
                        when (tf) {
                            "REQUEST_VALIDATION_ERROR" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.RequestValidationError>(), jobj)
                            "HANDLER_ERROR" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.HandlerError>(), jobj)
                            "INTERNAL_ERROR" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.InternalError>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("REQUEST_VALIDATION_ERROR".lowercase() == tfLower || tfLower.contains("REQUEST_VALIDATION_ERROR".lowercase()) || "REQUEST_VALIDATION_ERROR".lowercase().contains(tfLower))) { chosenGroupKey = "REQUEST_VALIDATION_ERROR" }
                        if (chosenGroupKey == null && ("HANDLER_ERROR".lowercase() == tfLower || tfLower.contains("HANDLER_ERROR".lowercase()) || "HANDLER_ERROR".lowercase().contains(tfLower))) { chosenGroupKey = "HANDLER_ERROR" }
                        if (chosenGroupKey == null && ("INTERNAL_ERROR".lowercase() == tfLower || tfLower.contains("INTERNAL_ERROR".lowercase()) || "INTERNAL_ERROR".lowercase().contains(tfLower))) { chosenGroupKey = "INTERNAL_ERROR" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "REQUEST_VALIDATION_ERROR" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.RequestValidationError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'REQUEST_VALIDATION_ERROR' and tf='$tf'")
                                }
                                "HANDLER_ERROR" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.HandlerError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'HANDLER_ERROR' and tf='$tf'")
                                }
                                "INTERNAL_ERROR" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.InternalError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'INTERNAL_ERROR' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: REQUEST_VALIDATION_ERROR
                    // group: HANDLER_ERROR
                    // group: INTERNAL_ERROR

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("cause") && jobj.containsKey("name") && jobj.containsKey("code") && jobj.containsKey("message")) requiredMatches.add(0)
                    if (jobj.containsKey("cause") && jobj.containsKey("name") && jobj.containsKey("code") && jobj.containsKey("message")) requiredMatches.add(1)
                    if (jobj.containsKey("cause") && jobj.containsKey("name") && jobj.containsKey("code") && jobj.containsKey("message")) requiredMatches.add(2)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.RequestValidationError>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.HandlerError>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.InternalError>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["cause"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        if (jobj["code"] != null) matchCount++
                        if (jobj["data"] != null) matchCount++
                        if (jobj["message"] != null) matchCount++
                        val score = matchCount.toDouble() / 5.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["cause"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        if (jobj["code"] != null) matchCount++
                        if (jobj["data"] != null) matchCount++
                        if (jobj["message"] != null) matchCount++
                        val score = matchCount.toDouble() / 5.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["cause"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        if (jobj["code"] != null) matchCount++
                        if (jobj["data"] != null) matchCount++
                        if (jobj["message"] != null) matchCount++
                        val score = matchCount.toDouble() / 5.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.RequestValidationError>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.HandlerError>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.InternalError>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.RequestValidationError>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.HandlerError>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcError.InternalError>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in RpcError")
                }
            }
        }
        throw SerializationException("Cannot deserialize RpcError with non-JSON decoder")
    }
}
