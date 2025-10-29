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
import io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView
import kotlinx.serialization.json.*

object ReceiptEnumViewSerializer : KSerializer<ReceiptEnumView> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView") {
        element("Action", serializer<JsonElement>().descriptor)
        element("Data", serializer<JsonElement>().descriptor)
        element("GlobalContractDistribution", serializer<JsonElement>().descriptor)
    }

    // --- helper functions ---
    private fun <T> tryDecode(json: Json, serExpr: KSerializer<T>, elem: JsonElement): T = json.decodeFromJsonElement(serExpr, elem)

    override fun serialize(encoder: Encoder, value: ReceiptEnumView) {
        if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Action -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["Action"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Action.ActionPayload>(), value.action)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Data -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["Data"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Data.DataPayload>(), value.data)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.GlobalContractDistribution -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["GlobalContractDistribution"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.GlobalContractDistribution.GlobalContractDistributionPayload>(), value.globalContractDistribution)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Action -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Action>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Data -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Data>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.GlobalContractDistribution -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.GlobalContractDistribution>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): ReceiptEnumView {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    throw SerializationException("Unknown discriminator (primitive) for ReceiptEnumView")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing ReceiptEnumView")

                is JsonObject -> {
                    val jobj = element
                    if (jobj["Action"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Action(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Action.ActionPayload>(), jobj["Action"]!!))
                    }
                    if (jobj["Data"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Data(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Data.DataPayload>(), jobj["Data"]!!))
                    }
                    if (jobj["GlobalContractDistribution"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.GlobalContractDistribution(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.GlobalContractDistribution.GlobalContractDistributionPayload>(), jobj["GlobalContractDistribution"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "Action" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant Action: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Action>(), obj)
                            }
                            "Data" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant Data: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Data>(), obj)
                            }
                            "GlobalContractDistribution" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant GlobalContractDistribution: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.GlobalContractDistribution>(), obj)
                            }
                            else -> throw SerializationException("Unknown discriminator key for ReceiptEnumView: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("Action")
                    for (cand in discriminatorCandidates) {
                        val candElem = jobj[cand]
                        if (candElem is JsonPrimitive) {
                            typeField = candElem.contentOrNull
                            if (typeField != null) break
                        }
                    }
                    if (typeField == null) {
                        val knownVariantNames = setOf("Action", "Data", "GlobalContractDistribution")
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
                            "Action" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Action>(), jobj)
                            "Data" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Data>(), jobj)
                            "GlobalContractDistribution" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.GlobalContractDistribution>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("Action".lowercase() == tfLower || tfLower.contains("Action".lowercase()) || "Action".lowercase().contains(tfLower))) { chosenGroupKey = "Action" }
                        if (chosenGroupKey == null && ("Data".lowercase() == tfLower || tfLower.contains("Data".lowercase()) || "Data".lowercase().contains(tfLower))) { chosenGroupKey = "Data" }
                        if (chosenGroupKey == null && ("GlobalContractDistribution".lowercase() == tfLower || tfLower.contains("GlobalContractDistribution".lowercase()) || "GlobalContractDistribution".lowercase().contains(tfLower))) { chosenGroupKey = "GlobalContractDistribution" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "Action" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Action>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Action' and tf='$tf'")
                                }
                                "Data" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Data>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Data' and tf='$tf'")
                                }
                                "GlobalContractDistribution" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.GlobalContractDistribution>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'GlobalContractDistribution' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: Action
                    // group: Data
                    // group: GlobalContractDistribution

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("Action")) requiredMatches.add(0)
                    if (jobj.containsKey("Data")) requiredMatches.add(1)
                    if (jobj.containsKey("GlobalContractDistribution")) requiredMatches.add(2)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Action>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Data>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.GlobalContractDistribution>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["Action"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["Data"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["GlobalContractDistribution"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Action>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Data>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.GlobalContractDistribution>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Action>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Data>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.GlobalContractDistribution>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in ReceiptEnumView")
                }
            }
        }
        throw SerializationException("Cannot deserialize ReceiptEnumView with non-JSON decoder")
    }
}
