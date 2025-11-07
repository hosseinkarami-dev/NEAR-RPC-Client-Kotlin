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
import io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission
import kotlinx.serialization.json.*

object AccessKeyPermissionSerializer : KSerializer<AccessKeyPermission> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission") {
        element("FunctionCall", serializer<JsonElement>().descriptor)
        element("FullAccess", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: AccessKeyPermission) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FunctionCall -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["FunctionCall"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallPermission>(), value.functionCall)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FullAccess -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("FullAccess"))
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FunctionCall -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FunctionCall>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FullAccess -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FullAccess>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): AccessKeyPermission {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                        if (s == "FullAccess") return io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FullAccess
                    }
                    throw SerializationException("Unknown discriminator (primitive) for AccessKeyPermission")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing AccessKeyPermission")

                is JsonObject -> {
                    val jobj = element
                    val knownVariantNames = setOf("FunctionCall", "FullAccess")
                    if (jobj["FunctionCall"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FunctionCall(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallPermission>(), jobj["FunctionCall"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        if (knownVariantNames.contains(key)) {
                            when (key) {
                            "FunctionCall" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant FunctionCall: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FunctionCall>(), obj)
                            }
                            "FullAccess" -> return io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FullAccess
                            else -> { /* knownVariantNames.contains(key) guards this branch; shouldn't reach here */ }
                            }
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = emptyList<String>()
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
                            "FunctionCall" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FunctionCall>(), jobj)
                            "FullAccess" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FullAccess>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("FunctionCall".lowercase() == tfLower || tfLower.contains("FunctionCall".lowercase()) || "FunctionCall".lowercase().contains(tfLower))) { chosenGroupKey = "FunctionCall" }
                        if (chosenGroupKey == null && ("FullAccess".lowercase() == tfLower || tfLower.contains("FullAccess".lowercase()) || "FullAccess".lowercase().contains(tfLower))) { chosenGroupKey = "FullAccess" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "FunctionCall" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FunctionCall>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'FunctionCall' and tf='\$tf'")
                                }
                                "FullAccess" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FullAccess>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'FullAccess' and tf='\$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: FunctionCall
                    // group: FullAccess

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("FunctionCall")) requiredMatches.add(0)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FunctionCall>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FullAccess>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["FunctionCall"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 1 }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FunctionCall>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FullAccess>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FunctionCall>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in AccessKeyPermission")
                }
            }
        }
        throw SerializationException("Cannot deserialize AccessKeyPermission with non-JSON decoder")
    }
}
