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
import io.github.hosseinkarami_dev.near.rpc.models.BlockId
import kotlinx.serialization.json.*

object BlockIdSerializer : KSerializer<BlockId> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.BlockId") {
        element("block_height", serializer<JsonElement>().descriptor)
        element("CryptoHash", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: BlockId) {
        if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.BlockId.BlockHeight -> {
                    val innerElem = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.ULong>(), value.value)
                    jsonEncoder.encodeJsonElement(innerElem)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.BlockId.CryptoHash -> {
                    val innerElem = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.value)
                    jsonEncoder.encodeJsonElement(innerElem)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.BlockId.BlockHeight -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId.BlockHeight>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.BlockId.CryptoHash -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId.CryptoHash>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): BlockId {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    try {
                        val payload = decoder.json.decodeFromJsonElement(serializer<kotlin.ULong>(), element)
                        return io.github.hosseinkarami_dev.near.rpc.models.BlockId.BlockHeight(payload)
                    } catch (_: Exception) { }
                    try {
                        val payload = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), element)
                        return io.github.hosseinkarami_dev.near.rpc.models.BlockId.CryptoHash(payload)
                    } catch (_: Exception) { }
                    throw SerializationException("Unknown discriminator (primitive) for BlockId")
                }
                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing BlockId")
                is JsonObject -> {
                    val jobj = element
                    if (jobj["block_height"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.BlockId.BlockHeight(decoder.json.decodeFromJsonElement(serializer<kotlin.ULong>(), jobj["block_height"]!!))
                    }
                    if (jobj["CryptoHash"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.BlockId.CryptoHash(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), jobj["CryptoHash"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "block_height" -> {
                                return io.github.hosseinkarami_dev.near.rpc.models.BlockId.BlockHeight(decoder.json.decodeFromJsonElement(serializer<kotlin.ULong>(), valueElem))
                            }
                            "CryptoHash" -> {
                                return io.github.hosseinkarami_dev.near.rpc.models.BlockId.CryptoHash(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), valueElem))
                            }
                            else -> throw SerializationException("Unknown discriminator key for BlockId: " + key)
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
                        val knownVariantNames = setOf("block_height", "CryptoHash")
                        for ((k, v) in jobj.entries) {
                            if (v is JsonPrimitive && v.isString) {
                                val s = v.content
                                if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
                            }
                        }
                    }
                    if (typeField == null) throw SerializationException("Missing discriminator (one of changes_type) or recognizable variant in BlockId")
                    val tf = typeField.trim()

                    // try exact match of full variant name first
                    val tfFull = tf
                    when (tfFull) {
                        "block_height" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId.BlockHeight>(), jobj)
                        "CryptoHash" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId.CryptoHash>(), jobj)
                        else -> { /* fallthrough to grouped handling */ }
                    }

                    // grouped handling by base token (e.g. account_changes -> ...by_block_id / ...by_finality / ...by_sync_checkpoint)
                    val tfLower = tf.lowercase()
                    // select candidate group based on contains/equals heuristics
                    var chosenGroupKey: String? = null
                    if (chosenGroupKey == null && ("block_height".lowercase() == tfLower || tfLower.contains("block_height".lowercase()) || "block_height".lowercase().contains(tfLower))) { chosenGroupKey = "block_height" }
                    if (chosenGroupKey == null && ("CryptoHash".lowercase() == tfLower || tfLower.contains("CryptoHash".lowercase()) || "CryptoHash".lowercase().contains(tfLower))) { chosenGroupKey = "CryptoHash" }
                    if (chosenGroupKey != null) {
                        when (chosenGroupKey) {
                            "block_height" -> {
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId.BlockHeight>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'block_height' and tf='$tf'")
                            }
                            "CryptoHash" -> {
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId.CryptoHash>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'CryptoHash' and tf='$tf'")
                            }
                            else -> { /* no group matched */ }
                        }
                    }

                    // fallback: try required-field matching and scoring heuristics
                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("block_height")) requiredMatches.add(0)
                    if (jobj.containsKey("CryptoHash")) requiredMatches.add(1)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId.BlockHeight>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId.CryptoHash>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["block_height"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["CryptoHash"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId.BlockHeight>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId.CryptoHash>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    // last resort: try decoding each data-class variant
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId.BlockHeight>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId.CryptoHash>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in BlockId")
                }
            }
        }
        throw SerializationException("Cannot deserialize BlockId with non-JSON decoder")
    }
}
