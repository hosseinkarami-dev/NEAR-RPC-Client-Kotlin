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
import io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError
import kotlinx.serialization.json.*

object FunctionCallErrorSerializer : KSerializer<FunctionCallError> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError") {
        element("WasmUnknownError", serializer<JsonElement>().descriptor)
        element("_EVMError", serializer<JsonElement>().descriptor)
        element("CompilationError", serializer<JsonElement>().descriptor)
        element("LinkError", serializer<JsonElement>().descriptor)
        element("MethodResolveError", serializer<JsonElement>().descriptor)
        element("WasmTrap", serializer<JsonElement>().descriptor)
        element("HostError", serializer<JsonElement>().descriptor)
        element("ExecutionError", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: FunctionCallError) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmUnknownError -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("WasmUnknownError"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.EVMError -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("_EVMError"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.CompilationError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["CompilationError"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError>(), value.compilationError)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.LinkError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["LinkError"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.LinkError.LinkErrorPayload>(), value.linkError)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.MethodResolveError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["MethodResolveError"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.MethodResolveError>(), value.methodResolveError)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmTrap -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["WasmTrap"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap>(), value.wasmTrap)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.HostError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["HostError"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError>(), value.hostError)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.ExecutionError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["ExecutionError"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.String>(), value.executionError)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmUnknownError -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmUnknownError>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.EVMError -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.EVMError>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.CompilationError -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.CompilationError>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.LinkError -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.LinkError>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.MethodResolveError -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.MethodResolveError>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmTrap -> out.encodeSerializableElement(descriptor, 5, serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmTrap>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.HostError -> out.encodeSerializableElement(descriptor, 6, serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.HostError>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.ExecutionError -> out.encodeSerializableElement(descriptor, 7, serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.ExecutionError>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): FunctionCallError {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                        if (s == "WasmUnknownError") return io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmUnknownError
                        if (s == "_EVMError") return io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.EVMError
                    }
                    throw SerializationException("Unknown discriminator (primitive) for FunctionCallError")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing FunctionCallError")

                is JsonObject -> {
                    val jobj = element
                    if (jobj["CompilationError"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.CompilationError(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError>(), jobj["CompilationError"]!!))
                    }
                    if (jobj["LinkError"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.LinkError(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.LinkError.LinkErrorPayload>(), jobj["LinkError"]!!))
                    }
                    if (jobj["MethodResolveError"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.MethodResolveError(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.MethodResolveError>(), jobj["MethodResolveError"]!!))
                    }
                    if (jobj["WasmTrap"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmTrap(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap>(), jobj["WasmTrap"]!!))
                    }
                    if (jobj["HostError"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.HostError(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError>(), jobj["HostError"]!!))
                    }
                    if (jobj["ExecutionError"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.ExecutionError(decoder.json.decodeFromJsonElement(serializer<kotlin.String>(), jobj["ExecutionError"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "CompilationError" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant CompilationError: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.CompilationError>(), obj)
                            }
                            "LinkError" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant LinkError: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.LinkError>(), obj)
                            }
                            "MethodResolveError" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant MethodResolveError: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.MethodResolveError>(), obj)
                            }
                            "WasmTrap" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant WasmTrap: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmTrap>(), obj)
                            }
                            "HostError" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant HostError: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.HostError>(), obj)
                            }
                            "ExecutionError" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant ExecutionError: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.ExecutionError>(), obj)
                            }
                            "WasmUnknownError" -> return io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmUnknownError
                            "_EVMError" -> return io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.EVMError
                            else -> throw SerializationException("Unknown discriminator key for FunctionCallError: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("LinkError")
                    for (cand in discriminatorCandidates) {
                        val candElem = jobj[cand]
                        if (candElem is JsonPrimitive) {
                            typeField = candElem.contentOrNull
                            if (typeField != null) break
                        }
                    }
                    if (typeField == null) {
                        val knownVariantNames = setOf("WasmUnknownError", "_EVMError", "CompilationError", "LinkError", "MethodResolveError", "WasmTrap", "HostError", "ExecutionError")
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
                            "WasmUnknownError" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmUnknownError>(), jobj)
                            "_EVMError" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.EVMError>(), jobj)
                            "CompilationError" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.CompilationError>(), jobj)
                            "LinkError" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.LinkError>(), jobj)
                            "MethodResolveError" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.MethodResolveError>(), jobj)
                            "WasmTrap" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmTrap>(), jobj)
                            "HostError" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.HostError>(), jobj)
                            "ExecutionError" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.ExecutionError>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("WasmUnknownError".lowercase() == tfLower || tfLower.contains("WasmUnknownError".lowercase()) || "WasmUnknownError".lowercase().contains(tfLower))) { chosenGroupKey = "WasmUnknownError" }
                        if (chosenGroupKey == null && ("_EVMError".lowercase() == tfLower || tfLower.contains("_EVMError".lowercase()) || "_EVMError".lowercase().contains(tfLower))) { chosenGroupKey = "_EVMError" }
                        if (chosenGroupKey == null && ("CompilationError".lowercase() == tfLower || tfLower.contains("CompilationError".lowercase()) || "CompilationError".lowercase().contains(tfLower))) { chosenGroupKey = "CompilationError" }
                        if (chosenGroupKey == null && ("LinkError".lowercase() == tfLower || tfLower.contains("LinkError".lowercase()) || "LinkError".lowercase().contains(tfLower))) { chosenGroupKey = "LinkError" }
                        if (chosenGroupKey == null && ("MethodResolveError".lowercase() == tfLower || tfLower.contains("MethodResolveError".lowercase()) || "MethodResolveError".lowercase().contains(tfLower))) { chosenGroupKey = "MethodResolveError" }
                        if (chosenGroupKey == null && ("WasmTrap".lowercase() == tfLower || tfLower.contains("WasmTrap".lowercase()) || "WasmTrap".lowercase().contains(tfLower))) { chosenGroupKey = "WasmTrap" }
                        if (chosenGroupKey == null && ("HostError".lowercase() == tfLower || tfLower.contains("HostError".lowercase()) || "HostError".lowercase().contains(tfLower))) { chosenGroupKey = "HostError" }
                        if (chosenGroupKey == null && ("ExecutionError".lowercase() == tfLower || tfLower.contains("ExecutionError".lowercase()) || "ExecutionError".lowercase().contains(tfLower))) { chosenGroupKey = "ExecutionError" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "WasmUnknownError" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmUnknownError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'WasmUnknownError' and tf='$tf'")
                                }
                                "_EVMError" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.EVMError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token '_EVMError' and tf='$tf'")
                                }
                                "CompilationError" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.CompilationError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'CompilationError' and tf='$tf'")
                                }
                                "LinkError" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.LinkError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'LinkError' and tf='$tf'")
                                }
                                "MethodResolveError" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.MethodResolveError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'MethodResolveError' and tf='$tf'")
                                }
                                "WasmTrap" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmTrap>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'WasmTrap' and tf='$tf'")
                                }
                                "HostError" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.HostError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'HostError' and tf='$tf'")
                                }
                                "ExecutionError" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.ExecutionError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'ExecutionError' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: WasmUnknownError
                    // group: _EVMError
                    // group: CompilationError
                    // group: LinkError
                    // group: MethodResolveError
                    // group: WasmTrap
                    // group: HostError
                    // group: ExecutionError

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("CompilationError")) requiredMatches.add(2)
                    if (jobj.containsKey("LinkError")) requiredMatches.add(3)
                    if (jobj.containsKey("MethodResolveError")) requiredMatches.add(4)
                    if (jobj.containsKey("WasmTrap")) requiredMatches.add(5)
                    if (jobj.containsKey("HostError")) requiredMatches.add(6)
                    if (jobj.containsKey("ExecutionError")) requiredMatches.add(7)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmUnknownError>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.EVMError>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.CompilationError>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.LinkError>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.MethodResolveError>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmTrap>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.HostError>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.ExecutionError>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 0 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 1 }
                    run {
                        var matchCount = 0
                        if (jobj["CompilationError"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["LinkError"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 3 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["MethodResolveError"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 4 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["WasmTrap"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 5 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["HostError"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 6 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["ExecutionError"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 7 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmUnknownError>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.EVMError>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.CompilationError>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.LinkError>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.MethodResolveError>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmTrap>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.HostError>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.ExecutionError>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.CompilationError>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.LinkError>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.MethodResolveError>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmTrap>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.HostError>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.ExecutionError>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in FunctionCallError")
                }
            }
        }
        throw SerializationException("Cannot deserialize FunctionCallError with non-JSON decoder")
    }
}
