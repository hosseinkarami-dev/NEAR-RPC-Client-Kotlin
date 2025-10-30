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
import io.github.hosseinkarami_dev.near.rpc.models.PrepareError
import kotlinx.serialization.json.*

object PrepareErrorSerializer : KSerializer<PrepareError> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.PrepareError") {
        element("Serialization", serializer<JsonElement>().descriptor)
        element("Deserialization", serializer<JsonElement>().descriptor)
        element("InternalMemoryDeclared", serializer<JsonElement>().descriptor)
        element("GasInstrumentation", serializer<JsonElement>().descriptor)
        element("StackHeightInstrumentation", serializer<JsonElement>().descriptor)
        element("Instantiate", serializer<JsonElement>().descriptor)
        element("Memory", serializer<JsonElement>().descriptor)
        element("TooManyFunctions", serializer<JsonElement>().descriptor)
        element("TooManyLocals", serializer<JsonElement>().descriptor)
        element("TooManyTables", serializer<JsonElement>().descriptor)
        element("TooManyTableElements", serializer<JsonElement>().descriptor)
    }

    // --- helper functions ---
    private fun <T> tryDecode(json: Json, serExpr: KSerializer<T>, elem: JsonElement): T = json.decodeFromJsonElement(serExpr, elem)

    override fun serialize(encoder: Encoder, value: PrepareError) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Serialization -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("Serialization"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Deserialization -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("Deserialization"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.PrepareError.InternalMemoryDeclared -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("InternalMemoryDeclared"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.PrepareError.GasInstrumentation -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("GasInstrumentation"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.PrepareError.StackHeightInstrumentation -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("StackHeightInstrumentation"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Instantiate -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("Instantiate"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Memory -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("Memory"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyFunctions -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("TooManyFunctions"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyLocals -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("TooManyLocals"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyTables -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("TooManyTables"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyTableElements -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("TooManyTableElements"))
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Serialization -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Serialization>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Deserialization -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Deserialization>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.PrepareError.InternalMemoryDeclared -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.InternalMemoryDeclared>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.PrepareError.GasInstrumentation -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.GasInstrumentation>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.PrepareError.StackHeightInstrumentation -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.StackHeightInstrumentation>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Instantiate -> out.encodeSerializableElement(descriptor, 5, serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Instantiate>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Memory -> out.encodeSerializableElement(descriptor, 6, serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Memory>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyFunctions -> out.encodeSerializableElement(descriptor, 7, serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyFunctions>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyLocals -> out.encodeSerializableElement(descriptor, 8, serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyLocals>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyTables -> out.encodeSerializableElement(descriptor, 9, serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyTables>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyTableElements -> out.encodeSerializableElement(descriptor, 10, serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyTableElements>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): PrepareError {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                        if (s == "Serialization") return io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Serialization
                        if (s == "Deserialization") return io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Deserialization
                        if (s == "InternalMemoryDeclared") return io.github.hosseinkarami_dev.near.rpc.models.PrepareError.InternalMemoryDeclared
                        if (s == "GasInstrumentation") return io.github.hosseinkarami_dev.near.rpc.models.PrepareError.GasInstrumentation
                        if (s == "StackHeightInstrumentation") return io.github.hosseinkarami_dev.near.rpc.models.PrepareError.StackHeightInstrumentation
                        if (s == "Instantiate") return io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Instantiate
                        if (s == "Memory") return io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Memory
                        if (s == "TooManyFunctions") return io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyFunctions
                        if (s == "TooManyLocals") return io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyLocals
                        if (s == "TooManyTables") return io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyTables
                        if (s == "TooManyTableElements") return io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyTableElements
                    }
                    throw SerializationException("Unknown discriminator (primitive) for PrepareError")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing PrepareError")

                is JsonObject -> {
                    val jobj = element
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "Serialization" -> return io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Serialization
                            "Deserialization" -> return io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Deserialization
                            "InternalMemoryDeclared" -> return io.github.hosseinkarami_dev.near.rpc.models.PrepareError.InternalMemoryDeclared
                            "GasInstrumentation" -> return io.github.hosseinkarami_dev.near.rpc.models.PrepareError.GasInstrumentation
                            "StackHeightInstrumentation" -> return io.github.hosseinkarami_dev.near.rpc.models.PrepareError.StackHeightInstrumentation
                            "Instantiate" -> return io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Instantiate
                            "Memory" -> return io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Memory
                            "TooManyFunctions" -> return io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyFunctions
                            "TooManyLocals" -> return io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyLocals
                            "TooManyTables" -> return io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyTables
                            "TooManyTableElements" -> return io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyTableElements
                            else -> throw SerializationException("Unknown discriminator key for PrepareError: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = emptyList<String>()
                    if (typeField == null) {
                        val knownVariantNames = setOf("Serialization", "Deserialization", "InternalMemoryDeclared", "GasInstrumentation", "StackHeightInstrumentation", "Instantiate", "Memory", "TooManyFunctions", "TooManyLocals", "TooManyTables", "TooManyTableElements")
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
                            "Serialization" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Serialization>(), jobj)
                            "Deserialization" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Deserialization>(), jobj)
                            "InternalMemoryDeclared" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.InternalMemoryDeclared>(), jobj)
                            "GasInstrumentation" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.GasInstrumentation>(), jobj)
                            "StackHeightInstrumentation" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.StackHeightInstrumentation>(), jobj)
                            "Instantiate" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Instantiate>(), jobj)
                            "Memory" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Memory>(), jobj)
                            "TooManyFunctions" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyFunctions>(), jobj)
                            "TooManyLocals" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyLocals>(), jobj)
                            "TooManyTables" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyTables>(), jobj)
                            "TooManyTableElements" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyTableElements>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("Serialization".lowercase() == tfLower || tfLower.contains("Serialization".lowercase()) || "Serialization".lowercase().contains(tfLower))) { chosenGroupKey = "Serialization" }
                        if (chosenGroupKey == null && ("Deserialization".lowercase() == tfLower || tfLower.contains("Deserialization".lowercase()) || "Deserialization".lowercase().contains(tfLower))) { chosenGroupKey = "Deserialization" }
                        if (chosenGroupKey == null && ("InternalMemoryDeclared".lowercase() == tfLower || tfLower.contains("InternalMemoryDeclared".lowercase()) || "InternalMemoryDeclared".lowercase().contains(tfLower))) { chosenGroupKey = "InternalMemoryDeclared" }
                        if (chosenGroupKey == null && ("GasInstrumentation".lowercase() == tfLower || tfLower.contains("GasInstrumentation".lowercase()) || "GasInstrumentation".lowercase().contains(tfLower))) { chosenGroupKey = "GasInstrumentation" }
                        if (chosenGroupKey == null && ("StackHeightInstrumentation".lowercase() == tfLower || tfLower.contains("StackHeightInstrumentation".lowercase()) || "StackHeightInstrumentation".lowercase().contains(tfLower))) { chosenGroupKey = "StackHeightInstrumentation" }
                        if (chosenGroupKey == null && ("Instantiate".lowercase() == tfLower || tfLower.contains("Instantiate".lowercase()) || "Instantiate".lowercase().contains(tfLower))) { chosenGroupKey = "Instantiate" }
                        if (chosenGroupKey == null && ("Memory".lowercase() == tfLower || tfLower.contains("Memory".lowercase()) || "Memory".lowercase().contains(tfLower))) { chosenGroupKey = "Memory" }
                        if (chosenGroupKey == null && ("TooManyFunctions".lowercase() == tfLower || tfLower.contains("TooManyFunctions".lowercase()) || "TooManyFunctions".lowercase().contains(tfLower))) { chosenGroupKey = "TooManyFunctions" }
                        if (chosenGroupKey == null && ("TooManyLocals".lowercase() == tfLower || tfLower.contains("TooManyLocals".lowercase()) || "TooManyLocals".lowercase().contains(tfLower))) { chosenGroupKey = "TooManyLocals" }
                        if (chosenGroupKey == null && ("TooManyTables".lowercase() == tfLower || tfLower.contains("TooManyTables".lowercase()) || "TooManyTables".lowercase().contains(tfLower))) { chosenGroupKey = "TooManyTables" }
                        if (chosenGroupKey == null && ("TooManyTableElements".lowercase() == tfLower || tfLower.contains("TooManyTableElements".lowercase()) || "TooManyTableElements".lowercase().contains(tfLower))) { chosenGroupKey = "TooManyTableElements" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "Serialization" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Serialization>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Serialization' and tf='$tf'")
                                }
                                "Deserialization" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Deserialization>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Deserialization' and tf='$tf'")
                                }
                                "InternalMemoryDeclared" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.InternalMemoryDeclared>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InternalMemoryDeclared' and tf='$tf'")
                                }
                                "GasInstrumentation" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.GasInstrumentation>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'GasInstrumentation' and tf='$tf'")
                                }
                                "StackHeightInstrumentation" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.StackHeightInstrumentation>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'StackHeightInstrumentation' and tf='$tf'")
                                }
                                "Instantiate" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Instantiate>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Instantiate' and tf='$tf'")
                                }
                                "Memory" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Memory>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Memory' and tf='$tf'")
                                }
                                "TooManyFunctions" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyFunctions>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'TooManyFunctions' and tf='$tf'")
                                }
                                "TooManyLocals" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyLocals>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'TooManyLocals' and tf='$tf'")
                                }
                                "TooManyTables" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyTables>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'TooManyTables' and tf='$tf'")
                                }
                                "TooManyTableElements" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyTableElements>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'TooManyTableElements' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: Serialization
                    // group: Deserialization
                    // group: InternalMemoryDeclared
                    // group: GasInstrumentation
                    // group: StackHeightInstrumentation
                    // group: Instantiate
                    // group: Memory
                    // group: TooManyFunctions
                    // group: TooManyLocals
                    // group: TooManyTables
                    // group: TooManyTableElements

                    val requiredMatches = mutableListOf<Int>()
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Serialization>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Deserialization>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.InternalMemoryDeclared>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.GasInstrumentation>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.StackHeightInstrumentation>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Instantiate>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Memory>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyFunctions>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyLocals>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyTables>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyTableElements>(), jobj)
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
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 9 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 10 }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Serialization>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Deserialization>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.InternalMemoryDeclared>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.GasInstrumentation>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.StackHeightInstrumentation>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Instantiate>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.Memory>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyFunctions>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyLocals>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyTables>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError.TooManyTableElements>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    throw SerializationException("Missing discriminator or recognizable variant in PrepareError")
                }
            }
        }
        throw SerializationException("Cannot deserialize PrepareError with non-JSON decoder")
    }
}
