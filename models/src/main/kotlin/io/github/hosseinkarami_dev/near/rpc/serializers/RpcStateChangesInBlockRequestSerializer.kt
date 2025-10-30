package io.github.hosseinkarami_dev.near.rpc.serializers

import  kotlinx.serialization.KSerializer
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
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest
import kotlinx.serialization.json.*

object RpcStateChangesInBlockRequestSerializer : KSerializer<RpcStateChangesInBlockRequest> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest") {
        element("block_id", serializer<JsonElement>().descriptor)
        element("finality", serializer<JsonElement>().descriptor)
        element("sync_checkpoint", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: RpcStateChangesInBlockRequest) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.BlockId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>(), value.blockId)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.Finality -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.Finality>(), value.finality)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.SyncCheckpoint -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint>(), value.syncCheckpoint)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.BlockId -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.BlockId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.Finality -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.Finality>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.SyncCheckpoint -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.SyncCheckpoint>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): RpcStateChangesInBlockRequest {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    throw SerializationException("Unknown discriminator (primitive) for RpcStateChangesInBlockRequest")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing RpcStateChangesInBlockRequest")

                is JsonObject -> {
                    val jobj = element
                    if (jobj["block_id"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.BlockId(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>(), jobj["block_id"]!!))
                    }
                    if (jobj["finality"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.Finality(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.Finality>(), jobj["finality"]!!))
                    }
                    if (jobj["sync_checkpoint"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.SyncCheckpoint(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint>(), jobj["sync_checkpoint"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "block_id" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant block_id: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.BlockId>(), obj)
                            }
                            "finality" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant finality: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.Finality>(), obj)
                            }
                            "sync_checkpoint" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant sync_checkpoint: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.SyncCheckpoint>(), obj)
                            }
                            else -> throw SerializationException("Unknown discriminator key for RpcStateChangesInBlockRequest: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = emptyList<String>()
                    if (typeField == null) {
                        val knownVariantNames = setOf("block_id", "finality", "sync_checkpoint")
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
                            "block_id" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.BlockId>(), jobj)
                            "finality" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.Finality>(), jobj)
                            "sync_checkpoint" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.SyncCheckpoint>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("block_id".lowercase() == tfLower || tfLower.contains("block_id".lowercase()) || "block_id".lowercase().contains(tfLower))) { chosenGroupKey = "block_id" }
                        if (chosenGroupKey == null && ("finality".lowercase() == tfLower || tfLower.contains("finality".lowercase()) || "finality".lowercase().contains(tfLower))) { chosenGroupKey = "finality" }
                        if (chosenGroupKey == null && ("sync_checkpoint".lowercase() == tfLower || tfLower.contains("sync_checkpoint".lowercase()) || "sync_checkpoint".lowercase().contains(tfLower))) { chosenGroupKey = "sync_checkpoint" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "block_id" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.BlockId>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'block_id' and tf='$tf'")
                                }
                                "finality" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.Finality>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'finality' and tf='$tf'")
                                }
                                "sync_checkpoint" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.SyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'sync_checkpoint' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: block_id
                    // group: finality
                    // group: sync_checkpoint

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("block_id")) requiredMatches.add(0)
                    if (jobj.containsKey("finality")) requiredMatches.add(1)
                    if (jobj.containsKey("sync_checkpoint")) requiredMatches.add(2)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.BlockId>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.Finality>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.SyncCheckpoint>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["block_id"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["finality"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["sync_checkpoint"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.BlockId>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.Finality>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.SyncCheckpoint>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.BlockId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.Finality>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.SyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in RpcStateChangesInBlockRequest")
                }
            }
        }
        throw SerializationException("Cannot deserialize RpcStateChangesInBlockRequest with non-JSON decoder")
    }
}
