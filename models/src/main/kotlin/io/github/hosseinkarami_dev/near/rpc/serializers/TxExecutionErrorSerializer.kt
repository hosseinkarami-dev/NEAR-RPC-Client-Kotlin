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
import io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError
import kotlinx.serialization.json.*

object TxExecutionErrorSerializer : KSerializer<TxExecutionError> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError") {
        element("ActionError", serializer<JsonElement>().descriptor)
        element("InvalidTxError", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: TxExecutionError) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.ActionError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["ActionError"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionError>(), value.actionError)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.InvalidTxError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["InvalidTxError"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError>(), value.invalidTxError)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.ActionError -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.ActionError>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.InvalidTxError -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.InvalidTxError>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): TxExecutionError {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    throw SerializationException("Unknown discriminator (primitive) for TxExecutionError")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing TxExecutionError")

                is JsonObject -> {
                    val jobj = element
                    val knownVariantNames = setOf("ActionError", "InvalidTxError")
                    if (jobj["ActionError"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.ActionError(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionError>(), jobj["ActionError"]!!))
                    }
                    if (jobj["InvalidTxError"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.InvalidTxError(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError>(), jobj["InvalidTxError"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        if (knownVariantNames.contains(key)) {
                            when (key) {
                            "ActionError" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant ActionError: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.ActionError>(), obj)
                            }
                            "InvalidTxError" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant InvalidTxError: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.InvalidTxError>(), obj)
                            }
                            else -> { /* knownVariantNames.contains(key) guards this branch; shouldn't reach here */ }
                            }
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = emptyList<String>()
                    if (typeField == null) {
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
                            "ActionError" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.ActionError>(), jobj)
                            "InvalidTxError" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.InvalidTxError>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("ActionError".lowercase() == tfLower || tfLower.contains("ActionError".lowercase()) || "ActionError".lowercase().contains(tfLower))) { chosenGroupKey = "ActionError" }
                        if (chosenGroupKey == null && ("InvalidTxError".lowercase() == tfLower || tfLower.contains("InvalidTxError".lowercase()) || "InvalidTxError".lowercase().contains(tfLower))) { chosenGroupKey = "InvalidTxError" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "ActionError" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.ActionError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'ActionError' and tf='\$tf'")
                                }
                                "InvalidTxError" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.InvalidTxError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InvalidTxError' and tf='\$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: ActionError
                    // group: InvalidTxError

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("ActionError")) requiredMatches.add(0)
                    if (jobj.containsKey("InvalidTxError")) requiredMatches.add(1)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.ActionError>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.InvalidTxError>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["ActionError"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["InvalidTxError"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.ActionError>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.InvalidTxError>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.ActionError>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.InvalidTxError>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in TxExecutionError")
                }
            }
        }
        throw SerializationException("Cannot deserialize TxExecutionError with non-JSON decoder")
    }
}
