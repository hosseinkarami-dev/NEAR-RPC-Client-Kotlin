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
import io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus
import kotlinx.serialization.json.*

object FinalExecutionStatusSerializer : KSerializer<FinalExecutionStatus> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus") {
        element("NotStarted", serializer<JsonElement>().descriptor)
        element("Started", serializer<JsonElement>().descriptor)
        element("Failure", serializer<JsonElement>().descriptor)
        element("SuccessValue", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: FinalExecutionStatus) {
        if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.NotStarted -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("NotStarted"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Started -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("Started"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Failure -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["Failure"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError>(), value.failure)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.SuccessValue -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["SuccessValue"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.String>(), value.successValue)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.NotStarted -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.NotStarted>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Started -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Started>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Failure -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Failure>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.SuccessValue -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.SuccessValue>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): FinalExecutionStatus {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                        if (s == "NotStarted") return io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.NotStarted
                        if (s == "Started") return io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Started
                    }
                    throw SerializationException("Unknown discriminator (primitive) for FinalExecutionStatus")
                }
                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing FinalExecutionStatus")
                is JsonObject -> {
                    val jobj = element
                    if (jobj["Failure"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Failure(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError>(), jobj["Failure"]!!))
                    }
                    if (jobj["SuccessValue"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.SuccessValue(decoder.json.decodeFromJsonElement(serializer<kotlin.String>(), jobj["SuccessValue"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "Failure" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant Failure: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Failure>(), obj)
                            }
                            "SuccessValue" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant SuccessValue: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.SuccessValue>(), obj)
                            }
                            "NotStarted" -> return io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.NotStarted
                            "Started" -> return io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Started
                            else -> throw SerializationException("Unknown discriminator key for FinalExecutionStatus: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("changes_type")
                    for (cand in discriminatorCandidates) {
                        val candElem = jobj[cand]
                        if (candElem is JsonPrimitive) {
                            typeField = candElem.contentOrNull
                            if (typeField != null) break
                        }
                    }
                    if (typeField == null) {
                        val knownVariantNames = setOf("NotStarted", "Started", "Failure", "SuccessValue")
                        for ((k, v) in jobj.entries) {
                            if (v is JsonPrimitive && v.isString) {
                                val s = v.content
                                if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
                            }
                        }
                    }
                    if (typeField == null) throw SerializationException("Missing discriminator (one of changes_type) or recognizable variant in FinalExecutionStatus")
                    val tf = typeField.trim()

                    // try exact match of full variant name first
                    val tfFull = tf
                    when (tfFull) {
                        "NotStarted" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.NotStarted>(), jobj)
                        "Started" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Started>(), jobj)
                        "Failure" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Failure>(), jobj)
                        "SuccessValue" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.SuccessValue>(), jobj)
                        else -> { /* fallthrough to grouped handling */ }
                    }

                    // grouped handling by base token (e.g. account_changes -> ...by_block_id / ...by_finality / ...by_sync_checkpoint)
                    val tfLower = tf.lowercase()
                    // select candidate group based on contains/equals heuristics
                    var chosenGroupKey: String? = null
                    if (chosenGroupKey == null && ("NotStarted".lowercase() == tfLower || tfLower.contains("NotStarted".lowercase()) || "NotStarted".lowercase().contains(tfLower))) { chosenGroupKey = "NotStarted" }
                    if (chosenGroupKey == null && ("Started".lowercase() == tfLower || tfLower.contains("Started".lowercase()) || "Started".lowercase().contains(tfLower))) { chosenGroupKey = "Started" }
                    if (chosenGroupKey == null && ("Failure".lowercase() == tfLower || tfLower.contains("Failure".lowercase()) || "Failure".lowercase().contains(tfLower))) { chosenGroupKey = "Failure" }
                    if (chosenGroupKey == null && ("SuccessValue".lowercase() == tfLower || tfLower.contains("SuccessValue".lowercase()) || "SuccessValue".lowercase().contains(tfLower))) { chosenGroupKey = "SuccessValue" }
                    if (chosenGroupKey != null) {
                        when (chosenGroupKey) {
                            "NotStarted" -> {
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.NotStarted>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'NotStarted' and tf='$tf'")
                            }
                            "Started" -> {
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Started>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'Started' and tf='$tf'")
                            }
                            "Failure" -> {
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Failure>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'Failure' and tf='$tf'")
                            }
                            "SuccessValue" -> {
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.SuccessValue>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'SuccessValue' and tf='$tf'")
                            }
                            else -> { /* no group matched */ }
                        }
                    }

                    // fallback: try required-field matching and scoring heuristics
                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("Failure")) requiredMatches.add(2)
                    if (jobj.containsKey("SuccessValue")) requiredMatches.add(3)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.NotStarted>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Started>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Failure>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.SuccessValue>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 0 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 1 }
                    run {
                        var matchCount = 0
                        if (jobj["Failure"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["SuccessValue"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 3 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.NotStarted>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Started>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Failure>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.SuccessValue>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    // last resort: try decoding each data-class variant
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Failure>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.SuccessValue>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in FinalExecutionStatus")
                }
            }
        }
        throw SerializationException("Cannot deserialize FinalExecutionStatus with non-JSON decoder")
    }
}
