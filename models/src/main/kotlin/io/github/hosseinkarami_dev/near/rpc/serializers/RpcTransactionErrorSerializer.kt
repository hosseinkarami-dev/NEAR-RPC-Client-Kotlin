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
import io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError
import kotlinx.serialization.json.*

object RpcTransactionErrorSerializer : KSerializer<RpcTransactionError> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError") {
        element("INVALID_TRANSACTION", serializer<JsonElement>().descriptor)
        element("DOES_NOT_TRACK_SHARD", serializer<JsonElement>().descriptor)
        element("REQUEST_ROUTED", serializer<JsonElement>().descriptor)
        element("UNKNOWN_TRANSACTION", serializer<JsonElement>().descriptor)
        element("INTERNAL_ERROR", serializer<JsonElement>().descriptor)
        element("TIMEOUT_ERROR", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: RpcTransactionError) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InvalidTransaction -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlinx.serialization.json.JsonElement>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InvalidTransaction.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.DoesNotTrackShard -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.DoesNotTrackShard.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.RequestRouted -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.RequestRouted.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.RequestRouted.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.UnknownTransaction -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.UnknownTransaction.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.UnknownTransaction.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InternalError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InternalError.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InternalError.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.TimeoutError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.TimeoutError.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InvalidTransaction -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InvalidTransaction>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.DoesNotTrackShard -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.DoesNotTrackShard>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.RequestRouted -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.RequestRouted>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.UnknownTransaction -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.UnknownTransaction>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InternalError -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InternalError>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.TimeoutError -> out.encodeSerializableElement(descriptor, 5, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.TimeoutError>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): RpcTransactionError {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    throw SerializationException("Unknown discriminator (primitive) for RpcTransactionError")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing RpcTransactionError")

                is JsonObject -> {
                    val jobj = element
                    val knownVariantNames = setOf("INVALID_TRANSACTION", "DOES_NOT_TRACK_SHARD", "REQUEST_ROUTED", "UNKNOWN_TRANSACTION", "INTERNAL_ERROR", "TIMEOUT_ERROR")
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        if (knownVariantNames.contains(key)) {
                            when (key) {
                            "INVALID_TRANSACTION" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant INVALID_TRANSACTION: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InvalidTransaction>(), obj)
                            }
                            "DOES_NOT_TRACK_SHARD" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant DOES_NOT_TRACK_SHARD: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.DoesNotTrackShard>(), obj)
                            }
                            "REQUEST_ROUTED" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant REQUEST_ROUTED: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.RequestRouted>(), obj)
                            }
                            "UNKNOWN_TRANSACTION" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant UNKNOWN_TRANSACTION: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.UnknownTransaction>(), obj)
                            }
                            "INTERNAL_ERROR" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant INTERNAL_ERROR: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InternalError>(), obj)
                            }
                            "TIMEOUT_ERROR" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant TIMEOUT_ERROR: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.TimeoutError>(), obj)
                            }
                            else -> { /* knownVariantNames.contains(key) guards this branch; shouldn't reach here */ }
                            }
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("name", "info")
                    for (cand in discriminatorCandidates) {
                        val candElem = jobj[cand]
                        if (candElem is JsonPrimitive) {
                            typeField = candElem.contentOrNull
                            if (typeField != null) break
                        }
                    }
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
                            "INVALID_TRANSACTION" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InvalidTransaction>(), jobj)
                            "DOES_NOT_TRACK_SHARD" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.DoesNotTrackShard>(), jobj)
                            "REQUEST_ROUTED" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.RequestRouted>(), jobj)
                            "UNKNOWN_TRANSACTION" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.UnknownTransaction>(), jobj)
                            "INTERNAL_ERROR" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InternalError>(), jobj)
                            "TIMEOUT_ERROR" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.TimeoutError>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("INVALID_TRANSACTION".lowercase() == tfLower || tfLower.contains("INVALID_TRANSACTION".lowercase()) || "INVALID_TRANSACTION".lowercase().contains(tfLower))) { chosenGroupKey = "INVALID_TRANSACTION" }
                        if (chosenGroupKey == null && ("DOES_NOT_TRACK_SHARD".lowercase() == tfLower || tfLower.contains("DOES_NOT_TRACK_SHARD".lowercase()) || "DOES_NOT_TRACK_SHARD".lowercase().contains(tfLower))) { chosenGroupKey = "DOES_NOT_TRACK_SHARD" }
                        if (chosenGroupKey == null && ("REQUEST_ROUTED".lowercase() == tfLower || tfLower.contains("REQUEST_ROUTED".lowercase()) || "REQUEST_ROUTED".lowercase().contains(tfLower))) { chosenGroupKey = "REQUEST_ROUTED" }
                        if (chosenGroupKey == null && ("UNKNOWN_TRANSACTION".lowercase() == tfLower || tfLower.contains("UNKNOWN_TRANSACTION".lowercase()) || "UNKNOWN_TRANSACTION".lowercase().contains(tfLower))) { chosenGroupKey = "UNKNOWN_TRANSACTION" }
                        if (chosenGroupKey == null && ("INTERNAL_ERROR".lowercase() == tfLower || tfLower.contains("INTERNAL_ERROR".lowercase()) || "INTERNAL_ERROR".lowercase().contains(tfLower))) { chosenGroupKey = "INTERNAL_ERROR" }
                        if (chosenGroupKey == null && ("TIMEOUT_ERROR".lowercase() == tfLower || tfLower.contains("TIMEOUT_ERROR".lowercase()) || "TIMEOUT_ERROR".lowercase().contains(tfLower))) { chosenGroupKey = "TIMEOUT_ERROR" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "INVALID_TRANSACTION" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InvalidTransaction>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'INVALID_TRANSACTION' and tf='\$tf'")
                                }
                                "DOES_NOT_TRACK_SHARD" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.DoesNotTrackShard>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DOES_NOT_TRACK_SHARD' and tf='\$tf'")
                                }
                                "REQUEST_ROUTED" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.RequestRouted>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'REQUEST_ROUTED' and tf='\$tf'")
                                }
                                "UNKNOWN_TRANSACTION" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.UnknownTransaction>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'UNKNOWN_TRANSACTION' and tf='\$tf'")
                                }
                                "INTERNAL_ERROR" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InternalError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'INTERNAL_ERROR' and tf='\$tf'")
                                }
                                "TIMEOUT_ERROR" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.TimeoutError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'TIMEOUT_ERROR' and tf='\$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: INVALID_TRANSACTION
                    // group: DOES_NOT_TRACK_SHARD
                    // group: REQUEST_ROUTED
                    // group: UNKNOWN_TRANSACTION
                    // group: INTERNAL_ERROR
                    // group: TIMEOUT_ERROR

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(0)
                    if (jobj.containsKey("name")) requiredMatches.add(1)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(2)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(3)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(4)
                    if (jobj.containsKey("name")) requiredMatches.add(5)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InvalidTransaction>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.DoesNotTrackShard>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.RequestRouted>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.UnknownTransaction>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InternalError>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.TimeoutError>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["info"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["info"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["info"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 3 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["info"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 4 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 5 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InvalidTransaction>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.DoesNotTrackShard>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.RequestRouted>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.UnknownTransaction>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InternalError>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.TimeoutError>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InvalidTransaction>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.DoesNotTrackShard>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.RequestRouted>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.UnknownTransaction>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InternalError>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.TimeoutError>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in RpcTransactionError")
                }
            }
        }
        throw SerializationException("Cannot deserialize RpcTransactionError with non-JSON decoder")
    }
}
