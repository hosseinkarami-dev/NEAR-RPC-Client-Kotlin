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
import io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus
import kotlinx.serialization.json.*

object TxExecutionStatusSerializer : KSerializer<TxExecutionStatus> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus") {
        element("NONE", serializer<JsonElement>().descriptor)
        element("INCLUDED", serializer<JsonElement>().descriptor)
        element("EXECUTED_OPTIMISTIC", serializer<JsonElement>().descriptor)
        element("INCLUDED_FINAL", serializer<JsonElement>().descriptor)
        element("EXECUTED", serializer<JsonElement>().descriptor)
        element("FINAL", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: TxExecutionStatus) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.None -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("NONE"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Included -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("INCLUDED"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.ExecutedOptimistic -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("EXECUTED_OPTIMISTIC"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.IncludedFinal -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("INCLUDED_FINAL"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Executed -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("EXECUTED"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Final -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("FINAL"))
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.None -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.None>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Included -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Included>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.ExecutedOptimistic -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.ExecutedOptimistic>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.IncludedFinal -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.IncludedFinal>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Executed -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Executed>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Final -> out.encodeSerializableElement(descriptor, 5, serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Final>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): TxExecutionStatus {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                        if (s == "NONE") return io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.None
                        if (s == "INCLUDED") return io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Included
                        if (s == "EXECUTED_OPTIMISTIC") return io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.ExecutedOptimistic
                        if (s == "INCLUDED_FINAL") return io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.IncludedFinal
                        if (s == "EXECUTED") return io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Executed
                        if (s == "FINAL") return io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Final
                    }
                    throw SerializationException("Unknown discriminator (primitive) for TxExecutionStatus")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing TxExecutionStatus")

                is JsonObject -> {
                    val jobj = element
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "NONE" -> return io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.None
                            "INCLUDED" -> return io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Included
                            "EXECUTED_OPTIMISTIC" -> return io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.ExecutedOptimistic
                            "INCLUDED_FINAL" -> return io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.IncludedFinal
                            "EXECUTED" -> return io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Executed
                            "FINAL" -> return io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Final
                            else -> throw SerializationException("Unknown discriminator key for TxExecutionStatus: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = emptyList<String>()
                    if (typeField == null) {
                        val knownVariantNames = setOf("NONE", "INCLUDED", "EXECUTED_OPTIMISTIC", "INCLUDED_FINAL", "EXECUTED", "FINAL")
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
                            "NONE" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.None>(), jobj)
                            "INCLUDED" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Included>(), jobj)
                            "EXECUTED_OPTIMISTIC" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.ExecutedOptimistic>(), jobj)
                            "INCLUDED_FINAL" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.IncludedFinal>(), jobj)
                            "EXECUTED" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Executed>(), jobj)
                            "FINAL" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Final>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("NONE".lowercase() == tfLower || tfLower.contains("NONE".lowercase()) || "NONE".lowercase().contains(tfLower))) { chosenGroupKey = "NONE" }
                        if (chosenGroupKey == null && ("INCLUDED".lowercase() == tfLower || tfLower.contains("INCLUDED".lowercase()) || "INCLUDED".lowercase().contains(tfLower))) { chosenGroupKey = "INCLUDED" }
                        if (chosenGroupKey == null && ("EXECUTED_OPTIMISTIC".lowercase() == tfLower || tfLower.contains("EXECUTED_OPTIMISTIC".lowercase()) || "EXECUTED_OPTIMISTIC".lowercase().contains(tfLower))) { chosenGroupKey = "EXECUTED_OPTIMISTIC" }
                        if (chosenGroupKey == null && ("INCLUDED_FINAL".lowercase() == tfLower || tfLower.contains("INCLUDED_FINAL".lowercase()) || "INCLUDED_FINAL".lowercase().contains(tfLower))) { chosenGroupKey = "INCLUDED_FINAL" }
                        if (chosenGroupKey == null && ("EXECUTED".lowercase() == tfLower || tfLower.contains("EXECUTED".lowercase()) || "EXECUTED".lowercase().contains(tfLower))) { chosenGroupKey = "EXECUTED" }
                        if (chosenGroupKey == null && ("FINAL".lowercase() == tfLower || tfLower.contains("FINAL".lowercase()) || "FINAL".lowercase().contains(tfLower))) { chosenGroupKey = "FINAL" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "NONE" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.None>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'NONE' and tf='$tf'")
                                }
                                "INCLUDED" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Included>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'INCLUDED' and tf='$tf'")
                                }
                                "EXECUTED_OPTIMISTIC" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.ExecutedOptimistic>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'EXECUTED_OPTIMISTIC' and tf='$tf'")
                                }
                                "INCLUDED_FINAL" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.IncludedFinal>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'INCLUDED_FINAL' and tf='$tf'")
                                }
                                "EXECUTED" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Executed>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'EXECUTED' and tf='$tf'")
                                }
                                "FINAL" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Final>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'FINAL' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: NONE
                    // group: INCLUDED
                    // group: EXECUTED_OPTIMISTIC
                    // group: INCLUDED_FINAL
                    // group: EXECUTED
                    // group: FINAL

                    val requiredMatches = mutableListOf<Int>()
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.None>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Included>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.ExecutedOptimistic>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.IncludedFinal>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Executed>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Final>(), jobj)
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
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.None>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Included>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.ExecutedOptimistic>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.IncludedFinal>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Executed>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Final>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    throw SerializationException("Missing discriminator or recognizable variant in TxExecutionStatus")
                }
            }
        }
        throw SerializationException("Cannot deserialize TxExecutionStatus with non-JSON decoder")
    }
}
