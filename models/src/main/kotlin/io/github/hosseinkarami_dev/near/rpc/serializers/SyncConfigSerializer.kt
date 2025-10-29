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
import io.github.hosseinkarami_dev.near.rpc.models.SyncConfig
import kotlinx.serialization.json.*

object SyncConfigSerializer : KSerializer<SyncConfig> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.SyncConfig") {
        element("Peers", serializer<JsonElement>().descriptor)
        element("ExternalStorage", serializer<JsonElement>().descriptor)
    }

    // --- helper functions ---
    private fun <T> tryDecode(json: Json, serExpr: KSerializer<T>, elem: JsonElement): T = json.decodeFromJsonElement(serExpr, elem)

    override fun serialize(encoder: Encoder, value: SyncConfig) {
        if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.Peers -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("Peers"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.ExternalStorage -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["ExternalStorage"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageConfig>(), value.externalStorage)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.Peers -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.Peers>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.ExternalStorage -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.ExternalStorage>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): SyncConfig {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                        if (s == "Peers") return io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.Peers
                    }
                    throw SerializationException("Unknown discriminator (primitive) for SyncConfig")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing SyncConfig")

                is JsonObject -> {
                    val jobj = element
                    if (jobj["ExternalStorage"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.ExternalStorage(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageConfig>(), jobj["ExternalStorage"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "ExternalStorage" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant ExternalStorage: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.ExternalStorage>(), obj)
                            }
                            "Peers" -> return io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.Peers
                            else -> throw SerializationException("Unknown discriminator key for SyncConfig: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = emptyList<String>()
                    if (typeField == null) {
                        val knownVariantNames = setOf("Peers", "ExternalStorage")
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
                            "Peers" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.Peers>(), jobj)
                            "ExternalStorage" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.ExternalStorage>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("Peers".lowercase() == tfLower || tfLower.contains("Peers".lowercase()) || "Peers".lowercase().contains(tfLower))) { chosenGroupKey = "Peers" }
                        if (chosenGroupKey == null && ("ExternalStorage".lowercase() == tfLower || tfLower.contains("ExternalStorage".lowercase()) || "ExternalStorage".lowercase().contains(tfLower))) { chosenGroupKey = "ExternalStorage" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "Peers" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.Peers>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Peers' and tf='$tf'")
                                }
                                "ExternalStorage" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.ExternalStorage>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'ExternalStorage' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: Peers
                    // group: ExternalStorage

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("ExternalStorage")) requiredMatches.add(1)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.Peers>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.ExternalStorage>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 0 }
                    run {
                        var matchCount = 0
                        if (jobj["ExternalStorage"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.Peers>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.ExternalStorage>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.ExternalStorage>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in SyncConfig")
                }
            }
        }
        throw SerializationException("Cannot deserialize SyncConfig with non-JSON decoder")
    }
}
