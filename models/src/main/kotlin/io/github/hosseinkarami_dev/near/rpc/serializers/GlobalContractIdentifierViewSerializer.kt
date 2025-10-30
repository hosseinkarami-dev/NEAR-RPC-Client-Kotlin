package io.github.hosseinkarami_dev.near.rpc.serializers

import  kotlinx.serialization.KSerializer
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
import io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView
import kotlinx.serialization.json.*

object GlobalContractIdentifierViewSerializer : KSerializer<GlobalContractIdentifierView> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView") {
        element("CryptoHash", serializer<JsonElement>().descriptor)
        element("AccountId", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: GlobalContractIdentifierView) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.CryptoHash -> {
                    val innerElem = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.value)
                    jsonEncoder.encodeJsonElement(innerElem)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId -> {
                    val innerElem = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.value)
                    jsonEncoder.encodeJsonElement(innerElem)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.CryptoHash -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.CryptoHash>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): GlobalContractIdentifierView {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    try {
                        val payload = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), element)
                        return io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.CryptoHash(payload)
                    } catch (_: Exception) { }
                    try {
                        val payload = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), element)
                        return io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId(payload)
                    } catch (_: Exception) { }
                    throw SerializationException("Unknown discriminator (primitive) for GlobalContractIdentifierView")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing GlobalContractIdentifierView")

                is JsonObject -> {
                    val jobj = element
                    if (jobj["CryptoHash"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.CryptoHash(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), jobj["CryptoHash"]!!))
                    }
                    if (jobj["AccountId"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), jobj["AccountId"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "CryptoHash" -> {
                                return io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.CryptoHash(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), valueElem))
                            }
                            "AccountId" -> {
                                return io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), valueElem))
                            }
                            else -> throw SerializationException("Unknown discriminator key for GlobalContractIdentifierView: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = emptyList<String>()
                    if (typeField == null) {
                        val knownVariantNames = setOf("CryptoHash", "AccountId")
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
                            "CryptoHash" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.CryptoHash>(), jobj)
                            "AccountId" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("CryptoHash".lowercase() == tfLower || tfLower.contains("CryptoHash".lowercase()) || "CryptoHash".lowercase().contains(tfLower))) { chosenGroupKey = "CryptoHash" }
                        if (chosenGroupKey == null && ("AccountId".lowercase() == tfLower || tfLower.contains("AccountId".lowercase()) || "AccountId".lowercase().contains(tfLower))) { chosenGroupKey = "AccountId" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "CryptoHash" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.CryptoHash>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'CryptoHash' and tf='$tf'")
                                }
                                "AccountId" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'AccountId' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: CryptoHash
                    // group: AccountId

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("CryptoHash")) requiredMatches.add(0)
                    if (jobj.containsKey("AccountId")) requiredMatches.add(1)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.CryptoHash>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["CryptoHash"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["AccountId"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.CryptoHash>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.CryptoHash>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in GlobalContractIdentifierView")
                }
            }
        }
        throw SerializationException("Cannot deserialize GlobalContractIdentifierView with non-JSON decoder")
    }
}
