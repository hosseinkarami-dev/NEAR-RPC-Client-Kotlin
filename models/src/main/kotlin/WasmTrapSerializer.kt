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
import io.github.hosseinkarami_dev.near.rpc.models.WasmTrap
import kotlinx.serialization.json.*

object WasmTrapSerializer : KSerializer<WasmTrap> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.WasmTrap") {
        element("Unreachable", serializer<JsonElement>().descriptor)
        element("IncorrectCallIndirectSignature", serializer<JsonElement>().descriptor)
        element("MemoryOutOfBounds", serializer<JsonElement>().descriptor)
        element("CallIndirectOOB", serializer<JsonElement>().descriptor)
        element("IllegalArithmetic", serializer<JsonElement>().descriptor)
        element("MisalignedAtomicAccess", serializer<JsonElement>().descriptor)
        element("IndirectCallToNull", serializer<JsonElement>().descriptor)
        element("StackOverflow", serializer<JsonElement>().descriptor)
        element("GenericTrap", serializer<JsonElement>().descriptor)
    }

    // --- helper functions ---
    private fun <T> tryDecode(json: Json, serExpr: KSerializer<T>, elem: JsonElement): T = json.decodeFromJsonElement(serExpr, elem)

    override fun serialize(encoder: Encoder, value: WasmTrap) {
        if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.Unreachable -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("Unreachable"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IncorrectCallIndirectSignature -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("IncorrectCallIndirectSignature"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MemoryOutOfBounds -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("MemoryOutOfBounds"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.CallIndirectOOB -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("CallIndirectOOB"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IllegalArithmetic -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("IllegalArithmetic"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MisalignedAtomicAccess -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("MisalignedAtomicAccess"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IndirectCallToNull -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("IndirectCallToNull"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.StackOverflow -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("StackOverflow"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.GenericTrap -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("GenericTrap"))
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.Unreachable -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.Unreachable>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IncorrectCallIndirectSignature -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IncorrectCallIndirectSignature>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MemoryOutOfBounds -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MemoryOutOfBounds>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.CallIndirectOOB -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.CallIndirectOOB>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IllegalArithmetic -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IllegalArithmetic>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MisalignedAtomicAccess -> out.encodeSerializableElement(descriptor, 5, serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MisalignedAtomicAccess>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IndirectCallToNull -> out.encodeSerializableElement(descriptor, 6, serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IndirectCallToNull>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.StackOverflow -> out.encodeSerializableElement(descriptor, 7, serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.StackOverflow>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.GenericTrap -> out.encodeSerializableElement(descriptor, 8, serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.GenericTrap>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): WasmTrap {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                        if (s == "Unreachable") return io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.Unreachable
                        if (s == "IncorrectCallIndirectSignature") return io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IncorrectCallIndirectSignature
                        if (s == "MemoryOutOfBounds") return io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MemoryOutOfBounds
                        if (s == "CallIndirectOOB") return io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.CallIndirectOOB
                        if (s == "IllegalArithmetic") return io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IllegalArithmetic
                        if (s == "MisalignedAtomicAccess") return io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MisalignedAtomicAccess
                        if (s == "IndirectCallToNull") return io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IndirectCallToNull
                        if (s == "StackOverflow") return io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.StackOverflow
                        if (s == "GenericTrap") return io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.GenericTrap
                    }
                    throw SerializationException("Unknown discriminator (primitive) for WasmTrap")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing WasmTrap")

                is JsonObject -> {
                    val jobj = element
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "Unreachable" -> return io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.Unreachable
                            "IncorrectCallIndirectSignature" -> return io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IncorrectCallIndirectSignature
                            "MemoryOutOfBounds" -> return io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MemoryOutOfBounds
                            "CallIndirectOOB" -> return io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.CallIndirectOOB
                            "IllegalArithmetic" -> return io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IllegalArithmetic
                            "MisalignedAtomicAccess" -> return io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MisalignedAtomicAccess
                            "IndirectCallToNull" -> return io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IndirectCallToNull
                            "StackOverflow" -> return io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.StackOverflow
                            "GenericTrap" -> return io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.GenericTrap
                            else -> throw SerializationException("Unknown discriminator key for WasmTrap: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = emptyList<String>()
                    if (typeField == null) {
                        val knownVariantNames = setOf("Unreachable", "IncorrectCallIndirectSignature", "MemoryOutOfBounds", "CallIndirectOOB", "IllegalArithmetic", "MisalignedAtomicAccess", "IndirectCallToNull", "StackOverflow", "GenericTrap")
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
                            "Unreachable" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.Unreachable>(), jobj)
                            "IncorrectCallIndirectSignature" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IncorrectCallIndirectSignature>(), jobj)
                            "MemoryOutOfBounds" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MemoryOutOfBounds>(), jobj)
                            "CallIndirectOOB" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.CallIndirectOOB>(), jobj)
                            "IllegalArithmetic" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IllegalArithmetic>(), jobj)
                            "MisalignedAtomicAccess" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MisalignedAtomicAccess>(), jobj)
                            "IndirectCallToNull" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IndirectCallToNull>(), jobj)
                            "StackOverflow" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.StackOverflow>(), jobj)
                            "GenericTrap" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.GenericTrap>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("Unreachable".lowercase() == tfLower || tfLower.contains("Unreachable".lowercase()) || "Unreachable".lowercase().contains(tfLower))) { chosenGroupKey = "Unreachable" }
                        if (chosenGroupKey == null && ("IncorrectCallIndirectSignature".lowercase() == tfLower || tfLower.contains("IncorrectCallIndirectSignature".lowercase()) || "IncorrectCallIndirectSignature".lowercase().contains(tfLower))) { chosenGroupKey = "IncorrectCallIndirectSignature" }
                        if (chosenGroupKey == null && ("MemoryOutOfBounds".lowercase() == tfLower || tfLower.contains("MemoryOutOfBounds".lowercase()) || "MemoryOutOfBounds".lowercase().contains(tfLower))) { chosenGroupKey = "MemoryOutOfBounds" }
                        if (chosenGroupKey == null && ("CallIndirectOOB".lowercase() == tfLower || tfLower.contains("CallIndirectOOB".lowercase()) || "CallIndirectOOB".lowercase().contains(tfLower))) { chosenGroupKey = "CallIndirectOOB" }
                        if (chosenGroupKey == null && ("IllegalArithmetic".lowercase() == tfLower || tfLower.contains("IllegalArithmetic".lowercase()) || "IllegalArithmetic".lowercase().contains(tfLower))) { chosenGroupKey = "IllegalArithmetic" }
                        if (chosenGroupKey == null && ("MisalignedAtomicAccess".lowercase() == tfLower || tfLower.contains("MisalignedAtomicAccess".lowercase()) || "MisalignedAtomicAccess".lowercase().contains(tfLower))) { chosenGroupKey = "MisalignedAtomicAccess" }
                        if (chosenGroupKey == null && ("IndirectCallToNull".lowercase() == tfLower || tfLower.contains("IndirectCallToNull".lowercase()) || "IndirectCallToNull".lowercase().contains(tfLower))) { chosenGroupKey = "IndirectCallToNull" }
                        if (chosenGroupKey == null && ("StackOverflow".lowercase() == tfLower || tfLower.contains("StackOverflow".lowercase()) || "StackOverflow".lowercase().contains(tfLower))) { chosenGroupKey = "StackOverflow" }
                        if (chosenGroupKey == null && ("GenericTrap".lowercase() == tfLower || tfLower.contains("GenericTrap".lowercase()) || "GenericTrap".lowercase().contains(tfLower))) { chosenGroupKey = "GenericTrap" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "Unreachable" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.Unreachable>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Unreachable' and tf='$tf'")
                                }
                                "IncorrectCallIndirectSignature" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IncorrectCallIndirectSignature>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'IncorrectCallIndirectSignature' and tf='$tf'")
                                }
                                "MemoryOutOfBounds" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MemoryOutOfBounds>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'MemoryOutOfBounds' and tf='$tf'")
                                }
                                "CallIndirectOOB" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.CallIndirectOOB>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'CallIndirectOOB' and tf='$tf'")
                                }
                                "IllegalArithmetic" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IllegalArithmetic>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'IllegalArithmetic' and tf='$tf'")
                                }
                                "MisalignedAtomicAccess" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MisalignedAtomicAccess>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'MisalignedAtomicAccess' and tf='$tf'")
                                }
                                "IndirectCallToNull" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IndirectCallToNull>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'IndirectCallToNull' and tf='$tf'")
                                }
                                "StackOverflow" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.StackOverflow>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'StackOverflow' and tf='$tf'")
                                }
                                "GenericTrap" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.GenericTrap>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'GenericTrap' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: Unreachable
                    // group: IncorrectCallIndirectSignature
                    // group: MemoryOutOfBounds
                    // group: CallIndirectOOB
                    // group: IllegalArithmetic
                    // group: MisalignedAtomicAccess
                    // group: IndirectCallToNull
                    // group: StackOverflow
                    // group: GenericTrap

                    val requiredMatches = mutableListOf<Int>()
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.Unreachable>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IncorrectCallIndirectSignature>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MemoryOutOfBounds>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.CallIndirectOOB>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IllegalArithmetic>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MisalignedAtomicAccess>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IndirectCallToNull>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.StackOverflow>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.GenericTrap>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 0 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 1 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 2 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 3 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 4 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 5 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 6 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 7 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 8 }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.Unreachable>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IncorrectCallIndirectSignature>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MemoryOutOfBounds>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.CallIndirectOOB>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IllegalArithmetic>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MisalignedAtomicAccess>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IndirectCallToNull>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.StackOverflow>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.GenericTrap>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    throw SerializationException("Missing discriminator or recognizable variant in WasmTrap")
                }
            }
        }
        throw SerializationException("Cannot deserialize WasmTrap with non-JSON decoder")
    }
}
