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
import io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView
import kotlinx.serialization.json.*

object AccessKeyPermissionViewSerializer : KSerializer<AccessKeyPermissionView> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView") {
        element("FullAccess", serializer<JsonElement>().descriptor)
        element("FunctionCall", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: AccessKeyPermissionView) {
        if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FullAccess -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("FullAccess"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FunctionCall -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["FunctionCall"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FunctionCall.FunctionCallPayload>(), value.functionCall)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FullAccess -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FullAccess>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FunctionCall -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FunctionCall>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): AccessKeyPermissionView {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                        if (s == "FullAccess") return io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FullAccess
                    }
                    throw SerializationException("Unknown discriminator (primitive) for AccessKeyPermissionView")
                }
                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing AccessKeyPermissionView")
                is JsonObject -> {
                    val jobj = element
                    if (jobj["FunctionCall"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FunctionCall(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FunctionCall.FunctionCallPayload>(), jobj["FunctionCall"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "FunctionCall" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant FunctionCall: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FunctionCall>(), obj)
                            }
                            "FullAccess" -> return io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FullAccess
                            else -> throw SerializationException("Unknown discriminator key for AccessKeyPermissionView: " + key)
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
                        val knownVariantNames = setOf("FullAccess", "FunctionCall")
                        for ((k, v) in jobj.entries) {
                            if (v is JsonPrimitive && v.isString) {
                                val s = v.content
                                if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
                            }
                        }
                    }
                    if (typeField == null) throw SerializationException("Missing discriminator (one of changes_type) or recognizable variant in AccessKeyPermissionView")
                    val tf = typeField.trim()

                    // try exact match of full variant name first
                    val tfFull = tf
                    when (tfFull) {
                        "FullAccess" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FullAccess>(), jobj)
                        "FunctionCall" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FunctionCall>(), jobj)
                        else -> { /* fallthrough to grouped handling */ }
                    }

                    // grouped handling by base token (e.g. account_changes -> ...by_block_id / ...by_finality / ...by_sync_checkpoint)
                    val tfLower = tf.lowercase()
                    // select candidate group based on contains/equals heuristics
                    var chosenGroupKey: String? = null
                    if (chosenGroupKey == null && ("FullAccess".lowercase() == tfLower || tfLower.contains("FullAccess".lowercase()) || "FullAccess".lowercase().contains(tfLower))) { chosenGroupKey = "FullAccess" }
                    if (chosenGroupKey == null && ("FunctionCall".lowercase() == tfLower || tfLower.contains("FunctionCall".lowercase()) || "FunctionCall".lowercase().contains(tfLower))) { chosenGroupKey = "FunctionCall" }
                    if (chosenGroupKey != null) {
                        when (chosenGroupKey) {
                            "FullAccess" -> {
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FullAccess>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'FullAccess' and tf='$tf'")
                            }
                            "FunctionCall" -> {
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FunctionCall>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'FunctionCall' and tf='$tf'")
                            }
                            else -> { /* no group matched */ }
                        }
                    }

                    // fallback: try required-field matching and scoring heuristics
                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("FunctionCall")) requiredMatches.add(1)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FullAccess>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FunctionCall>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 0 }
                    run {
                        var matchCount = 0
                        if (jobj["FunctionCall"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FullAccess>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FunctionCall>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    // last resort: try decoding each data-class variant
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FunctionCall>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in AccessKeyPermissionView")
                }
            }
        }
        throw SerializationException("Cannot deserialize AccessKeyPermissionView with non-JSON decoder")
    }
}
