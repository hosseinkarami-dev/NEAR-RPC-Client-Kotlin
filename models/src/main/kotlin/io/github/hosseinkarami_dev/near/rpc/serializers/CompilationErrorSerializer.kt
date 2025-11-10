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
import io.github.hosseinkarami_dev.near.rpc.models.CompilationError
import kotlinx.serialization.json.*

object CompilationErrorSerializer : KSerializer<CompilationError> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.CompilationError") {
        element("CodeDoesNotExist", serializer<JsonElement>().descriptor)
        element("PrepareError", serializer<JsonElement>().descriptor)
        element("WasmerCompileError", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: CompilationError) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.CompilationError.CodeDoesNotExist -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["CodeDoesNotExist"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.CodeDoesNotExist.CodeDoesNotExistPayload>(), value.codeDoesNotExist)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.CompilationError.PrepareError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["PrepareError"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError>(), value.prepareError)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.CompilationError.WasmerCompileError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["WasmerCompileError"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.WasmerCompileError.WasmerCompileErrorPayload>(), value.wasmerCompileError)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.CompilationError.CodeDoesNotExist -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.CodeDoesNotExist>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.CompilationError.PrepareError -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.PrepareError>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.CompilationError.WasmerCompileError -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.WasmerCompileError>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): CompilationError {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    throw SerializationException("Unknown discriminator (primitive) for CompilationError")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing CompilationError")

                is JsonObject -> {
                    val jobj = element
                    val knownVariantNames = setOf("CodeDoesNotExist", "PrepareError", "WasmerCompileError")
                    if (jobj["CodeDoesNotExist"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.CompilationError.CodeDoesNotExist(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.CodeDoesNotExist.CodeDoesNotExistPayload>(), jobj["CodeDoesNotExist"]!!))
                    }
                    if (jobj["PrepareError"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.CompilationError.PrepareError(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError>(), jobj["PrepareError"]!!))
                    }
                    if (jobj["WasmerCompileError"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.CompilationError.WasmerCompileError(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.WasmerCompileError.WasmerCompileErrorPayload>(), jobj["WasmerCompileError"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        if (knownVariantNames.contains(key)) {
                            when (key) {
                            "CodeDoesNotExist" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant CodeDoesNotExist: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.CodeDoesNotExist>(), obj)
                            }
                            "PrepareError" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant PrepareError: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.PrepareError>(), obj)
                            }
                            "WasmerCompileError" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant WasmerCompileError: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.WasmerCompileError>(), obj)
                            }
                            else -> { /* knownVariantNames.contains(key) guards this branch; shouldn't reach here */ }
                            }
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("CodeDoesNotExist")
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
                            "CodeDoesNotExist" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.CodeDoesNotExist>(), jobj)
                            "PrepareError" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.PrepareError>(), jobj)
                            "WasmerCompileError" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.WasmerCompileError>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("CodeDoesNotExist".lowercase() == tfLower || tfLower.contains("CodeDoesNotExist".lowercase()) || "CodeDoesNotExist".lowercase().contains(tfLower))) { chosenGroupKey = "CodeDoesNotExist" }
                        if (chosenGroupKey == null && ("PrepareError".lowercase() == tfLower || tfLower.contains("PrepareError".lowercase()) || "PrepareError".lowercase().contains(tfLower))) { chosenGroupKey = "PrepareError" }
                        if (chosenGroupKey == null && ("WasmerCompileError".lowercase() == tfLower || tfLower.contains("WasmerCompileError".lowercase()) || "WasmerCompileError".lowercase().contains(tfLower))) { chosenGroupKey = "WasmerCompileError" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "CodeDoesNotExist" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.CodeDoesNotExist>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'CodeDoesNotExist' and tf='\$tf'")
                                }
                                "PrepareError" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.PrepareError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'PrepareError' and tf='\$tf'")
                                }
                                "WasmerCompileError" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.WasmerCompileError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'WasmerCompileError' and tf='\$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: CodeDoesNotExist
                    // group: PrepareError
                    // group: WasmerCompileError

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("CodeDoesNotExist")) requiredMatches.add(0)
                    if (jobj.containsKey("PrepareError")) requiredMatches.add(1)
                    if (jobj.containsKey("WasmerCompileError")) requiredMatches.add(2)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.CodeDoesNotExist>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.PrepareError>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.WasmerCompileError>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["CodeDoesNotExist"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["PrepareError"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["WasmerCompileError"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.CodeDoesNotExist>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.PrepareError>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.WasmerCompileError>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.CodeDoesNotExist>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.PrepareError>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.WasmerCompileError>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in CompilationError")
                }
            }
        }
        throw SerializationException("Cannot deserialize CompilationError with non-JSON decoder")
    }
}
