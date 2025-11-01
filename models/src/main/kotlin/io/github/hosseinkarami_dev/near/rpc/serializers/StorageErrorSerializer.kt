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
import io.github.hosseinkarami_dev.near.rpc.models.StorageError
import kotlinx.serialization.json.*

object StorageErrorSerializer : KSerializer<StorageError> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.StorageError") {
        element("StorageInternalError", serializer<JsonElement>().descriptor)
        element("MissingTrieValue", serializer<JsonElement>().descriptor)
        element("UnexpectedTrieValue", serializer<JsonElement>().descriptor)
        element("StorageInconsistentState", serializer<JsonElement>().descriptor)
        element("FlatStorageBlockNotSupported", serializer<JsonElement>().descriptor)
        element("MemTrieLoadingError", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: StorageError) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInternalError -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("StorageInternalError"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StorageError.MissingTrieValue -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["MissingTrieValue"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValue>(), value.missingTrieValue)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StorageError.UnexpectedTrieValue -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("UnexpectedTrieValue"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInconsistentState -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["StorageInconsistentState"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.String>(), value.storageInconsistentState)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StorageError.FlatStorageBlockNotSupported -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["FlatStorageBlockNotSupported"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.String>(), value.flatStorageBlockNotSupported)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StorageError.MemTrieLoadingError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["MemTrieLoadingError"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.String>(), value.memTrieLoadingError)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInternalError -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInternalError>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StorageError.MissingTrieValue -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.MissingTrieValue>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StorageError.UnexpectedTrieValue -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.UnexpectedTrieValue>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInconsistentState -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInconsistentState>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StorageError.FlatStorageBlockNotSupported -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.FlatStorageBlockNotSupported>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StorageError.MemTrieLoadingError -> out.encodeSerializableElement(descriptor, 5, serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.MemTrieLoadingError>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): StorageError {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                        if (s == "StorageInternalError") return io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInternalError
                        if (s == "UnexpectedTrieValue") return io.github.hosseinkarami_dev.near.rpc.models.StorageError.UnexpectedTrieValue
                    }
                    throw SerializationException("Unknown discriminator (primitive) for StorageError")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing StorageError")

                is JsonObject -> {
                    val jobj = element
                    if (jobj["MissingTrieValue"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.StorageError.MissingTrieValue(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValue>(), jobj["MissingTrieValue"]!!))
                    }
                    if (jobj["StorageInconsistentState"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInconsistentState(decoder.json.decodeFromJsonElement(serializer<kotlin.String>(), jobj["StorageInconsistentState"]!!))
                    }
                    if (jobj["FlatStorageBlockNotSupported"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.StorageError.FlatStorageBlockNotSupported(decoder.json.decodeFromJsonElement(serializer<kotlin.String>(), jobj["FlatStorageBlockNotSupported"]!!))
                    }
                    if (jobj["MemTrieLoadingError"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.StorageError.MemTrieLoadingError(decoder.json.decodeFromJsonElement(serializer<kotlin.String>(), jobj["MemTrieLoadingError"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "MissingTrieValue" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant MissingTrieValue: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.MissingTrieValue>(), obj)
                            }
                            "StorageInconsistentState" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant StorageInconsistentState: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInconsistentState>(), obj)
                            }
                            "FlatStorageBlockNotSupported" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant FlatStorageBlockNotSupported: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.FlatStorageBlockNotSupported>(), obj)
                            }
                            "MemTrieLoadingError" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant MemTrieLoadingError: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.MemTrieLoadingError>(), obj)
                            }
                            "StorageInternalError" -> return io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInternalError
                            "UnexpectedTrieValue" -> return io.github.hosseinkarami_dev.near.rpc.models.StorageError.UnexpectedTrieValue
                            else -> throw SerializationException("Unknown discriminator key for StorageError: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("StorageInconsistentState")
                    for (cand in discriminatorCandidates) {
                        val candElem = jobj[cand]
                        if (candElem is JsonPrimitive) {
                            typeField = candElem.contentOrNull
                            if (typeField != null) break
                        }
                    }
                    if (typeField == null) {
                        val knownVariantNames = setOf("StorageInternalError", "MissingTrieValue", "UnexpectedTrieValue", "StorageInconsistentState", "FlatStorageBlockNotSupported", "MemTrieLoadingError")
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
                            "StorageInternalError" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInternalError>(), jobj)
                            "MissingTrieValue" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.MissingTrieValue>(), jobj)
                            "UnexpectedTrieValue" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.UnexpectedTrieValue>(), jobj)
                            "StorageInconsistentState" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInconsistentState>(), jobj)
                            "FlatStorageBlockNotSupported" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.FlatStorageBlockNotSupported>(), jobj)
                            "MemTrieLoadingError" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.MemTrieLoadingError>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("StorageInternalError".lowercase() == tfLower || tfLower.contains("StorageInternalError".lowercase()) || "StorageInternalError".lowercase().contains(tfLower))) { chosenGroupKey = "StorageInternalError" }
                        if (chosenGroupKey == null && ("MissingTrieValue".lowercase() == tfLower || tfLower.contains("MissingTrieValue".lowercase()) || "MissingTrieValue".lowercase().contains(tfLower))) { chosenGroupKey = "MissingTrieValue" }
                        if (chosenGroupKey == null && ("UnexpectedTrieValue".lowercase() == tfLower || tfLower.contains("UnexpectedTrieValue".lowercase()) || "UnexpectedTrieValue".lowercase().contains(tfLower))) { chosenGroupKey = "UnexpectedTrieValue" }
                        if (chosenGroupKey == null && ("StorageInconsistentState".lowercase() == tfLower || tfLower.contains("StorageInconsistentState".lowercase()) || "StorageInconsistentState".lowercase().contains(tfLower))) { chosenGroupKey = "StorageInconsistentState" }
                        if (chosenGroupKey == null && ("FlatStorageBlockNotSupported".lowercase() == tfLower || tfLower.contains("FlatStorageBlockNotSupported".lowercase()) || "FlatStorageBlockNotSupported".lowercase().contains(tfLower))) { chosenGroupKey = "FlatStorageBlockNotSupported" }
                        if (chosenGroupKey == null && ("MemTrieLoadingError".lowercase() == tfLower || tfLower.contains("MemTrieLoadingError".lowercase()) || "MemTrieLoadingError".lowercase().contains(tfLower))) { chosenGroupKey = "MemTrieLoadingError" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "StorageInternalError" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInternalError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'StorageInternalError' and tf='$tf'")
                                }
                                "MissingTrieValue" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.MissingTrieValue>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'MissingTrieValue' and tf='$tf'")
                                }
                                "UnexpectedTrieValue" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.UnexpectedTrieValue>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'UnexpectedTrieValue' and tf='$tf'")
                                }
                                "StorageInconsistentState" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInconsistentState>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'StorageInconsistentState' and tf='$tf'")
                                }
                                "FlatStorageBlockNotSupported" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.FlatStorageBlockNotSupported>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'FlatStorageBlockNotSupported' and tf='$tf'")
                                }
                                "MemTrieLoadingError" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.MemTrieLoadingError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'MemTrieLoadingError' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: StorageInternalError
                    // group: MissingTrieValue
                    // group: UnexpectedTrieValue
                    // group: StorageInconsistentState
                    // group: FlatStorageBlockNotSupported
                    // group: MemTrieLoadingError

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("MissingTrieValue")) requiredMatches.add(1)
                    if (jobj.containsKey("StorageInconsistentState")) requiredMatches.add(3)
                    if (jobj.containsKey("FlatStorageBlockNotSupported")) requiredMatches.add(4)
                    if (jobj.containsKey("MemTrieLoadingError")) requiredMatches.add(5)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInternalError>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.MissingTrieValue>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.UnexpectedTrieValue>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInconsistentState>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.FlatStorageBlockNotSupported>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.MemTrieLoadingError>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 0 }
                    run {
                        var matchCount = 0
                        if (jobj["MissingTrieValue"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 2 }
                    run {
                        var matchCount = 0
                        if (jobj["StorageInconsistentState"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 3 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["FlatStorageBlockNotSupported"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 4 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["MemTrieLoadingError"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 5 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInternalError>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.MissingTrieValue>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.UnexpectedTrieValue>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInconsistentState>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.FlatStorageBlockNotSupported>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.MemTrieLoadingError>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.MissingTrieValue>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInconsistentState>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.FlatStorageBlockNotSupported>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.MemTrieLoadingError>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in StorageError")
                }
            }
        }
        throw SerializationException("Cannot deserialize StorageError with non-JSON decoder")
    }
}
