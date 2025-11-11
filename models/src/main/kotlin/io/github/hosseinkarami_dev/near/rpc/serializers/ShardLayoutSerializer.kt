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
import io.github.hosseinkarami_dev.near.rpc.models.ShardLayout
import kotlinx.serialization.json.*

object ShardLayoutSerializer : KSerializer<ShardLayout> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ShardLayout") {
        element("V0", serializer<JsonElement>().descriptor)
        element("V1", serializer<JsonElement>().descriptor)
        element("V2", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: ShardLayout) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V0 -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["V0"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV0>(), value.v0)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V1 -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["V1"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV1>(), value.v1)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V2 -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["V2"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV2>(), value.v2)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V0 -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V0>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V1 -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V1>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V2 -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V2>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): ShardLayout {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    throw SerializationException("Unknown discriminator (primitive) for ShardLayout")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing ShardLayout")

                is JsonObject -> {
                    val jobj = element
                    val knownVariantNames = setOf("V0", "V1", "V2")
                    if (jobj["V0"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V0(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV0>(), jobj["V0"]!!))
                    }
                    if (jobj["V1"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V1(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV1>(), jobj["V1"]!!))
                    }
                    if (jobj["V2"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V2(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV2>(), jobj["V2"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        if (knownVariantNames.contains(key)) {
                            when (key) {
                            "V0" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant V0: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V0>(), obj)
                            }
                            "V1" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant V1: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V1>(), obj)
                            }
                            "V2" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant V2: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V2>(), obj)
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
                            "V0" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V0>(), jobj)
                            "V1" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V1>(), jobj)
                            "V2" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V2>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("V0".lowercase() == tfLower || tfLower.contains("V0".lowercase()) || "V0".lowercase().contains(tfLower))) { chosenGroupKey = "V0" }
                        if (chosenGroupKey == null && ("V1".lowercase() == tfLower || tfLower.contains("V1".lowercase()) || "V1".lowercase().contains(tfLower))) { chosenGroupKey = "V1" }
                        if (chosenGroupKey == null && ("V2".lowercase() == tfLower || tfLower.contains("V2".lowercase()) || "V2".lowercase().contains(tfLower))) { chosenGroupKey = "V2" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "V0" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V0>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'V0' and tf='\$tf'")
                                }
                                "V1" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V1>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'V1' and tf='\$tf'")
                                }
                                "V2" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V2>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'V2' and tf='\$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: V0
                    // group: V1
                    // group: V2

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("V0")) requiredMatches.add(0)
                    if (jobj.containsKey("V1")) requiredMatches.add(1)
                    if (jobj.containsKey("V2")) requiredMatches.add(2)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V0>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V1>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V2>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["V0"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["V1"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["V2"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V0>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V1>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V2>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V0>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V1>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V2>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in ShardLayout")
                }
            }
        }
        throw SerializationException("Cannot deserialize ShardLayout with non-JSON decoder")
    }
}
