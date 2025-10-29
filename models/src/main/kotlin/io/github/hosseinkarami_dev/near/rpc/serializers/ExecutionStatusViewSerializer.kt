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
import io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView
import kotlinx.serialization.json.*

object ExecutionStatusViewSerializer : KSerializer<ExecutionStatusView> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView") {
        element("Unknown", serializer<JsonElement>().descriptor)
        element("Failure", serializer<JsonElement>().descriptor)
        element("SuccessValue", serializer<JsonElement>().descriptor)
        element("SuccessReceiptId", serializer<JsonElement>().descriptor)
    }

    // --- helper functions ---
    private fun <T> tryDecode(json: Json, serExpr: KSerializer<T>, elem: JsonElement): T = json.decodeFromJsonElement(serExpr, elem)

    override fun serialize(encoder: Encoder, value: ExecutionStatusView) {
        if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Unknown -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("Unknown"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Failure -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["Failure"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError>(), value.failure)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessValue -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["SuccessValue"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.String>(), value.successValue)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessReceiptId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["SuccessReceiptId"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.successReceiptId)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Unknown -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Unknown>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Failure -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Failure>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessValue -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessValue>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessReceiptId -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessReceiptId>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): ExecutionStatusView {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                        if (s == "Unknown") return io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Unknown
                    }
                    throw SerializationException("Unknown discriminator (primitive) for ExecutionStatusView")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing ExecutionStatusView")

                is JsonObject -> {
                    val jobj = element
                    if (jobj["Failure"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Failure(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError>(), jobj["Failure"]!!))
                    }
                    if (jobj["SuccessValue"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessValue(decoder.json.decodeFromJsonElement(serializer<kotlin.String>(), jobj["SuccessValue"]!!))
                    }
                    if (jobj["SuccessReceiptId"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessReceiptId(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), jobj["SuccessReceiptId"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "Failure" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant Failure: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Failure>(), obj)
                            }
                            "SuccessValue" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant SuccessValue: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessValue>(), obj)
                            }
                            "SuccessReceiptId" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant SuccessReceiptId: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessReceiptId>(), obj)
                            }
                            "Unknown" -> return io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Unknown
                            else -> throw SerializationException("Unknown discriminator key for ExecutionStatusView: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("SuccessValue")
                    for (cand in discriminatorCandidates) {
                        val candElem = jobj[cand]
                        if (candElem is JsonPrimitive) {
                            typeField = candElem.contentOrNull
                            if (typeField != null) break
                        }
                    }
                    if (typeField == null) {
                        val knownVariantNames = setOf("Unknown", "Failure", "SuccessValue", "SuccessReceiptId")
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
                            "Unknown" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Unknown>(), jobj)
                            "Failure" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Failure>(), jobj)
                            "SuccessValue" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessValue>(), jobj)
                            "SuccessReceiptId" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessReceiptId>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("Unknown".lowercase() == tfLower || tfLower.contains("Unknown".lowercase()) || "Unknown".lowercase().contains(tfLower))) { chosenGroupKey = "Unknown" }
                        if (chosenGroupKey == null && ("Failure".lowercase() == tfLower || tfLower.contains("Failure".lowercase()) || "Failure".lowercase().contains(tfLower))) { chosenGroupKey = "Failure" }
                        if (chosenGroupKey == null && ("SuccessValue".lowercase() == tfLower || tfLower.contains("SuccessValue".lowercase()) || "SuccessValue".lowercase().contains(tfLower))) { chosenGroupKey = "SuccessValue" }
                        if (chosenGroupKey == null && ("SuccessReceiptId".lowercase() == tfLower || tfLower.contains("SuccessReceiptId".lowercase()) || "SuccessReceiptId".lowercase().contains(tfLower))) { chosenGroupKey = "SuccessReceiptId" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "Unknown" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Unknown>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Unknown' and tf='$tf'")
                                }
                                "Failure" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Failure>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Failure' and tf='$tf'")
                                }
                                "SuccessValue" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessValue>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'SuccessValue' and tf='$tf'")
                                }
                                "SuccessReceiptId" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessReceiptId>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'SuccessReceiptId' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: Unknown
                    // group: Failure
                    // group: SuccessValue
                    // group: SuccessReceiptId

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("Failure")) requiredMatches.add(1)
                    if (jobj.containsKey("SuccessValue")) requiredMatches.add(2)
                    if (jobj.containsKey("SuccessReceiptId")) requiredMatches.add(3)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Unknown>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Failure>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessValue>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessReceiptId>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 0 }
                    run {
                        var matchCount = 0
                        if (jobj["Failure"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["SuccessValue"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["SuccessReceiptId"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 3 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Unknown>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Failure>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessValue>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessReceiptId>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Failure>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessValue>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessReceiptId>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in ExecutionStatusView")
                }
            }
        }
        throw SerializationException("Cannot deserialize ExecutionStatusView with non-JSON decoder")
    }
}
