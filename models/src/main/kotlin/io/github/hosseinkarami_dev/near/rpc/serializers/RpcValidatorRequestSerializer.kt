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
import io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest
import kotlinx.serialization.json.*

object RpcValidatorRequestSerializer : KSerializer<RpcValidatorRequest> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest") {
        element("latest", serializer<JsonElement>().descriptor)
        element("epoch_id", serializer<JsonElement>().descriptor)
        element("block_id", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: RpcValidatorRequest) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.Latest -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("latest"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.EpochId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["epoch_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.EpochId>(), value.epochId)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.BlockId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>(), value.blockId)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.Latest -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.Latest>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.EpochId -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.EpochId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.BlockId -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.BlockId>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): RpcValidatorRequest {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                        if (s == "latest") return io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.Latest
                    }
                    throw SerializationException("Unknown discriminator (primitive) for RpcValidatorRequest")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing RpcValidatorRequest")

                is JsonObject -> {
                    val jobj = element
                    if (jobj["epoch_id"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.EpochId(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.EpochId>(), jobj["epoch_id"]!!))
                    }
                    if (jobj["block_id"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.BlockId(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>(), jobj["block_id"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "epoch_id" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant epoch_id: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.EpochId>(), obj)
                            }
                            "block_id" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant block_id: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.BlockId>(), obj)
                            }
                            "latest" -> return io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.Latest
                            else -> throw SerializationException("Unknown discriminator key for RpcValidatorRequest: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = emptyList<String>()
                    if (typeField == null) {
                        val knownVariantNames = setOf("latest", "epoch_id", "block_id")
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
                            "latest" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.Latest>(), jobj)
                            "epoch_id" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.EpochId>(), jobj)
                            "block_id" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.BlockId>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("latest".lowercase() == tfLower || tfLower.contains("latest".lowercase()) || "latest".lowercase().contains(tfLower))) { chosenGroupKey = "latest" }
                        if (chosenGroupKey == null && ("epoch_id".lowercase() == tfLower || tfLower.contains("epoch_id".lowercase()) || "epoch_id".lowercase().contains(tfLower))) { chosenGroupKey = "epoch_id" }
                        if (chosenGroupKey == null && ("block_id".lowercase() == tfLower || tfLower.contains("block_id".lowercase()) || "block_id".lowercase().contains(tfLower))) { chosenGroupKey = "block_id" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "latest" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.Latest>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'latest' and tf='$tf'")
                                }
                                "epoch_id" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.EpochId>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'epoch_id' and tf='$tf'")
                                }
                                "block_id" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.BlockId>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'block_id' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: latest
                    // group: epoch_id
                    // group: block_id

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("epoch_id")) requiredMatches.add(1)
                    if (jobj.containsKey("block_id")) requiredMatches.add(2)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.Latest>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.EpochId>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.BlockId>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 0 }
                    run {
                        var matchCount = 0
                        if (jobj["epoch_id"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["block_id"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.Latest>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.EpochId>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.BlockId>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.EpochId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.BlockId>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in RpcValidatorRequest")
                }
            }
        }
        throw SerializationException("Cannot deserialize RpcValidatorRequest with non-JSON decoder")
    }
}
