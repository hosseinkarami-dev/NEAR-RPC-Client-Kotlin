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
import io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError
import kotlinx.serialization.json.*

object RpcStatusErrorSerializer : KSerializer<RpcStatusError> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError") {
        element("NODE_IS_SYNCING", serializer<JsonElement>().descriptor)
        element("NO_NEW_BLOCKS", serializer<JsonElement>().descriptor)
        element("EPOCH_OUT_OF_BOUNDS", serializer<JsonElement>().descriptor)
        element("INTERNAL_ERROR", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: RpcStatusError) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NodeIsSyncing -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NodeIsSyncing.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NoNewBlocks -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NoNewBlocks.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NoNewBlocks.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.EpochOutOfBounds -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.EpochOutOfBounds.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.EpochOutOfBounds.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.InternalError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.InternalError.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.InternalError.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NodeIsSyncing -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NodeIsSyncing>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NoNewBlocks -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NoNewBlocks>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.EpochOutOfBounds -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.EpochOutOfBounds>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.InternalError -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.InternalError>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): RpcStatusError {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    throw SerializationException("Unknown discriminator (primitive) for RpcStatusError")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing RpcStatusError")

                is JsonObject -> {
                    val jobj = element
                    val knownVariantNames = setOf("NODE_IS_SYNCING", "NO_NEW_BLOCKS", "EPOCH_OUT_OF_BOUNDS", "INTERNAL_ERROR")
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        if (knownVariantNames.contains(key)) {
                            when (key) {
                            "NODE_IS_SYNCING" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant NODE_IS_SYNCING: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NodeIsSyncing>(), obj)
                            }
                            "NO_NEW_BLOCKS" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant NO_NEW_BLOCKS: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NoNewBlocks>(), obj)
                            }
                            "EPOCH_OUT_OF_BOUNDS" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant EPOCH_OUT_OF_BOUNDS: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.EpochOutOfBounds>(), obj)
                            }
                            "INTERNAL_ERROR" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant INTERNAL_ERROR: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.InternalError>(), obj)
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
                            "NODE_IS_SYNCING" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NodeIsSyncing>(), jobj)
                            "NO_NEW_BLOCKS" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NoNewBlocks>(), jobj)
                            "EPOCH_OUT_OF_BOUNDS" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.EpochOutOfBounds>(), jobj)
                            "INTERNAL_ERROR" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.InternalError>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("NODE_IS_SYNCING".lowercase() == tfLower || tfLower.contains("NODE_IS_SYNCING".lowercase()) || "NODE_IS_SYNCING".lowercase().contains(tfLower))) { chosenGroupKey = "NODE_IS_SYNCING" }
                        if (chosenGroupKey == null && ("NO_NEW_BLOCKS".lowercase() == tfLower || tfLower.contains("NO_NEW_BLOCKS".lowercase()) || "NO_NEW_BLOCKS".lowercase().contains(tfLower))) { chosenGroupKey = "NO_NEW_BLOCKS" }
                        if (chosenGroupKey == null && ("EPOCH_OUT_OF_BOUNDS".lowercase() == tfLower || tfLower.contains("EPOCH_OUT_OF_BOUNDS".lowercase()) || "EPOCH_OUT_OF_BOUNDS".lowercase().contains(tfLower))) { chosenGroupKey = "EPOCH_OUT_OF_BOUNDS" }
                        if (chosenGroupKey == null && ("INTERNAL_ERROR".lowercase() == tfLower || tfLower.contains("INTERNAL_ERROR".lowercase()) || "INTERNAL_ERROR".lowercase().contains(tfLower))) { chosenGroupKey = "INTERNAL_ERROR" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "NODE_IS_SYNCING" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NodeIsSyncing>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'NODE_IS_SYNCING' and tf='\$tf'")
                                }
                                "NO_NEW_BLOCKS" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NoNewBlocks>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'NO_NEW_BLOCKS' and tf='\$tf'")
                                }
                                "EPOCH_OUT_OF_BOUNDS" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.EpochOutOfBounds>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'EPOCH_OUT_OF_BOUNDS' and tf='\$tf'")
                                }
                                "INTERNAL_ERROR" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.InternalError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'INTERNAL_ERROR' and tf='\$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: NODE_IS_SYNCING
                    // group: NO_NEW_BLOCKS
                    // group: EPOCH_OUT_OF_BOUNDS
                    // group: INTERNAL_ERROR

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("name")) requiredMatches.add(0)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(1)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(2)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(3)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NodeIsSyncing>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NoNewBlocks>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.EpochOutOfBounds>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.InternalError>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
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
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NodeIsSyncing>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NoNewBlocks>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.EpochOutOfBounds>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.InternalError>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NodeIsSyncing>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NoNewBlocks>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.EpochOutOfBounds>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.InternalError>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in RpcStatusError")
                }
            }
        }
        throw SerializationException("Cannot deserialize RpcStatusError with non-JSON decoder")
    }
}
