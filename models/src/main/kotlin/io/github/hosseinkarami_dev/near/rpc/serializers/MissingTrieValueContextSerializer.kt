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
import io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext
import kotlinx.serialization.json.*

object MissingTrieValueContextSerializer : KSerializer<MissingTrieValueContext> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext") {
        element("TrieIterator", serializer<JsonElement>().descriptor)
        element("TriePrefetchingStorage", serializer<JsonElement>().descriptor)
        element("TrieMemoryPartialStorage", serializer<JsonElement>().descriptor)
        element("TrieStorage", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: MissingTrieValueContext) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieIterator -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("TrieIterator"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TriePrefetchingStorage -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("TriePrefetchingStorage"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieMemoryPartialStorage -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("TrieMemoryPartialStorage"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieStorage -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("TrieStorage"))
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieIterator -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieIterator>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TriePrefetchingStorage -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TriePrefetchingStorage>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieMemoryPartialStorage -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieMemoryPartialStorage>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieStorage -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieStorage>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): MissingTrieValueContext {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                        if (s == "TrieIterator") return io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieIterator
                        if (s == "TriePrefetchingStorage") return io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TriePrefetchingStorage
                        if (s == "TrieMemoryPartialStorage") return io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieMemoryPartialStorage
                        if (s == "TrieStorage") return io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieStorage
                    }
                    throw SerializationException("Unknown discriminator (primitive) for MissingTrieValueContext")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing MissingTrieValueContext")

                is JsonObject -> {
                    val jobj = element
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "TrieIterator" -> return io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieIterator
                            "TriePrefetchingStorage" -> return io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TriePrefetchingStorage
                            "TrieMemoryPartialStorage" -> return io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieMemoryPartialStorage
                            "TrieStorage" -> return io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieStorage
                            else -> throw SerializationException("Unknown discriminator key for MissingTrieValueContext: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = emptyList<String>()
                    if (typeField == null) {
                        val knownVariantNames = setOf("TrieIterator", "TriePrefetchingStorage", "TrieMemoryPartialStorage", "TrieStorage")
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
                            "TrieIterator" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieIterator>(), jobj)
                            "TriePrefetchingStorage" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TriePrefetchingStorage>(), jobj)
                            "TrieMemoryPartialStorage" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieMemoryPartialStorage>(), jobj)
                            "TrieStorage" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieStorage>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("TrieIterator".lowercase() == tfLower || tfLower.contains("TrieIterator".lowercase()) || "TrieIterator".lowercase().contains(tfLower))) { chosenGroupKey = "TrieIterator" }
                        if (chosenGroupKey == null && ("TriePrefetchingStorage".lowercase() == tfLower || tfLower.contains("TriePrefetchingStorage".lowercase()) || "TriePrefetchingStorage".lowercase().contains(tfLower))) { chosenGroupKey = "TriePrefetchingStorage" }
                        if (chosenGroupKey == null && ("TrieMemoryPartialStorage".lowercase() == tfLower || tfLower.contains("TrieMemoryPartialStorage".lowercase()) || "TrieMemoryPartialStorage".lowercase().contains(tfLower))) { chosenGroupKey = "TrieMemoryPartialStorage" }
                        if (chosenGroupKey == null && ("TrieStorage".lowercase() == tfLower || tfLower.contains("TrieStorage".lowercase()) || "TrieStorage".lowercase().contains(tfLower))) { chosenGroupKey = "TrieStorage" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "TrieIterator" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieIterator>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'TrieIterator' and tf='$tf'")
                                }
                                "TriePrefetchingStorage" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TriePrefetchingStorage>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'TriePrefetchingStorage' and tf='$tf'")
                                }
                                "TrieMemoryPartialStorage" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieMemoryPartialStorage>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'TrieMemoryPartialStorage' and tf='$tf'")
                                }
                                "TrieStorage" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieStorage>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'TrieStorage' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: TrieIterator
                    // group: TriePrefetchingStorage
                    // group: TrieMemoryPartialStorage
                    // group: TrieStorage

                    val requiredMatches = mutableListOf<Int>()
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieIterator>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TriePrefetchingStorage>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieMemoryPartialStorage>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieStorage>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 0 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 1 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 2 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 3 }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieIterator>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TriePrefetchingStorage>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieMemoryPartialStorage>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieStorage>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    throw SerializationException("Missing discriminator or recognizable variant in MissingTrieValueContext")
                }
            }
        }
        throw SerializationException("Cannot deserialize MissingTrieValueContext with non-JSON decoder")
    }
}
