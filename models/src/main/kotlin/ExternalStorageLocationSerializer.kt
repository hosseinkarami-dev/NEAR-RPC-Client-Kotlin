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
import io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation
import kotlinx.serialization.json.*

object ExternalStorageLocationSerializer : KSerializer<ExternalStorageLocation> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation") {
        element("S3", serializer<JsonElement>().descriptor)
        element("Filesystem", serializer<JsonElement>().descriptor)
        element("GCS", serializer<JsonElement>().descriptor)
    }

    // --- helper functions ---
    private fun <T> tryDecode(json: Json, serExpr: KSerializer<T>, elem: JsonElement): T = json.decodeFromJsonElement(serExpr, elem)

    override fun serialize(encoder: Encoder, value: ExternalStorageLocation) {
        if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.S3 -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["S3"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.S3.S3Payload>(), value.s3)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Filesystem -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["Filesystem"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Filesystem.FilesystemPayload>(), value.filesystem)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Gcs -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["GCS"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Gcs.GcsPayload>(), value.gcs)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.S3 -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.S3>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Filesystem -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Filesystem>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Gcs -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Gcs>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): ExternalStorageLocation {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    throw SerializationException("Unknown discriminator (primitive) for ExternalStorageLocation")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing ExternalStorageLocation")

                is JsonObject -> {
                    val jobj = element
                    if (jobj["S3"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.S3(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.S3.S3Payload>(), jobj["S3"]!!))
                    }
                    if (jobj["Filesystem"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Filesystem(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Filesystem.FilesystemPayload>(), jobj["Filesystem"]!!))
                    }
                    if (jobj["GCS"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Gcs(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Gcs.GcsPayload>(), jobj["GCS"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "S3" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant S3: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.S3>(), obj)
                            }
                            "Filesystem" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant Filesystem: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Filesystem>(), obj)
                            }
                            "GCS" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant GCS: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Gcs>(), obj)
                            }
                            else -> throw SerializationException("Unknown discriminator key for ExternalStorageLocation: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("S3")
                    for (cand in discriminatorCandidates) {
                        val candElem = jobj[cand]
                        if (candElem is JsonPrimitive) {
                            typeField = candElem.contentOrNull
                            if (typeField != null) break
                        }
                    }
                    if (typeField == null) {
                        val knownVariantNames = setOf("S3", "Filesystem", "GCS")
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
                            "S3" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.S3>(), jobj)
                            "Filesystem" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Filesystem>(), jobj)
                            "GCS" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Gcs>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("S3".lowercase() == tfLower || tfLower.contains("S3".lowercase()) || "S3".lowercase().contains(tfLower))) { chosenGroupKey = "S3" }
                        if (chosenGroupKey == null && ("Filesystem".lowercase() == tfLower || tfLower.contains("Filesystem".lowercase()) || "Filesystem".lowercase().contains(tfLower))) { chosenGroupKey = "Filesystem" }
                        if (chosenGroupKey == null && ("GCS".lowercase() == tfLower || tfLower.contains("GCS".lowercase()) || "GCS".lowercase().contains(tfLower))) { chosenGroupKey = "GCS" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "S3" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.S3>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'S3' and tf='$tf'")
                                }
                                "Filesystem" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Filesystem>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Filesystem' and tf='$tf'")
                                }
                                "GCS" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Gcs>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'GCS' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: S3
                    // group: Filesystem
                    // group: GCS

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("S3")) requiredMatches.add(0)
                    if (jobj.containsKey("Filesystem")) requiredMatches.add(1)
                    if (jobj.containsKey("GCS")) requiredMatches.add(2)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.S3>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Filesystem>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Gcs>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["S3"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["Filesystem"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["GCS"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.S3>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Filesystem>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Gcs>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.S3>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Filesystem>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Gcs>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in ExternalStorageLocation")
                }
            }
        }
        throw SerializationException("Cannot deserialize ExternalStorageLocation with non-JSON decoder")
    }
}
