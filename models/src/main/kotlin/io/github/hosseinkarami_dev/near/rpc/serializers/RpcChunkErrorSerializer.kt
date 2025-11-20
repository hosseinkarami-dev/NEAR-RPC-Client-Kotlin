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
import io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError
import kotlinx.serialization.json.*

object RpcChunkErrorSerializer : KSerializer<RpcChunkError> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError") {
        element("INTERNAL_ERROR", serializer<JsonElement>().descriptor)
        element("UNKNOWN_BLOCK", serializer<JsonElement>().descriptor)
        element("INVALID_SHARD_ID", serializer<JsonElement>().descriptor)
        element("UNKNOWN_CHUNK", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: RpcChunkError) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InternalError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InternalError.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InternalError.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownBlock -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlinx.serialization.json.JsonElement>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownBlock.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InvalidShardId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InvalidShardId.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InvalidShardId.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownChunk -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownChunk.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownChunk.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InternalError -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InternalError>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownBlock -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownBlock>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InvalidShardId -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InvalidShardId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownChunk -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownChunk>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): RpcChunkError {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    throw SerializationException("Unknown discriminator (primitive) for RpcChunkError")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing RpcChunkError")

                is JsonObject -> {
                    val jobj = element
                    val knownVariantNames = setOf("INTERNAL_ERROR", "UNKNOWN_BLOCK", "INVALID_SHARD_ID", "UNKNOWN_CHUNK")
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        if (knownVariantNames.contains(key)) {
                            when (key) {
                            "INTERNAL_ERROR" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant INTERNAL_ERROR: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InternalError>(), obj)
                            }
                            "UNKNOWN_BLOCK" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant UNKNOWN_BLOCK: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownBlock>(), obj)
                            }
                            "INVALID_SHARD_ID" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant INVALID_SHARD_ID: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InvalidShardId>(), obj)
                            }
                            "UNKNOWN_CHUNK" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant UNKNOWN_CHUNK: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownChunk>(), obj)
                            }
                            else -> { /* knownVariantNames.contains(key) guards this branch; shouldn't reach here */ }
                            }
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("info", "name")
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
                            "INTERNAL_ERROR" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InternalError>(), jobj)
                            "UNKNOWN_BLOCK" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownBlock>(), jobj)
                            "INVALID_SHARD_ID" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InvalidShardId>(), jobj)
                            "UNKNOWN_CHUNK" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownChunk>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("INTERNAL_ERROR".lowercase() == tfLower || tfLower.contains("INTERNAL_ERROR".lowercase()) || "INTERNAL_ERROR".lowercase().contains(tfLower))) { chosenGroupKey = "INTERNAL_ERROR" }
                        if (chosenGroupKey == null && ("UNKNOWN_BLOCK".lowercase() == tfLower || tfLower.contains("UNKNOWN_BLOCK".lowercase()) || "UNKNOWN_BLOCK".lowercase().contains(tfLower))) { chosenGroupKey = "UNKNOWN_BLOCK" }
                        if (chosenGroupKey == null && ("INVALID_SHARD_ID".lowercase() == tfLower || tfLower.contains("INVALID_SHARD_ID".lowercase()) || "INVALID_SHARD_ID".lowercase().contains(tfLower))) { chosenGroupKey = "INVALID_SHARD_ID" }
                        if (chosenGroupKey == null && ("UNKNOWN_CHUNK".lowercase() == tfLower || tfLower.contains("UNKNOWN_CHUNK".lowercase()) || "UNKNOWN_CHUNK".lowercase().contains(tfLower))) { chosenGroupKey = "UNKNOWN_CHUNK" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "INTERNAL_ERROR" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InternalError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'INTERNAL_ERROR' and tf='\$tf'")
                                }
                                "UNKNOWN_BLOCK" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownBlock>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'UNKNOWN_BLOCK' and tf='\$tf'")
                                }
                                "INVALID_SHARD_ID" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InvalidShardId>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'INVALID_SHARD_ID' and tf='\$tf'")
                                }
                                "UNKNOWN_CHUNK" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownChunk>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'UNKNOWN_CHUNK' and tf='\$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: INTERNAL_ERROR
                    // group: UNKNOWN_BLOCK
                    // group: INVALID_SHARD_ID
                    // group: UNKNOWN_CHUNK

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(0)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(1)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(2)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(3)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InternalError>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownBlock>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InvalidShardId>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownChunk>(), jobj)
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
                        if (jobj["info"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
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
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InternalError>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownBlock>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InvalidShardId>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownChunk>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InternalError>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownBlock>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InvalidShardId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownChunk>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in RpcChunkError")
                }
            }
        }
        throw SerializationException("Cannot deserialize RpcChunkError with non-JSON decoder")
    }
}
