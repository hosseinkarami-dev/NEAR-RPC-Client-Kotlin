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
import io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode
import kotlinx.serialization.json.*

object GlobalContractDeployModeSerializer : KSerializer<GlobalContractDeployMode> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode") {
        element("CodeHash", serializer<JsonElement>().descriptor)
        element("AccountId", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: GlobalContractDeployMode) {
        if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.CodeHash -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("CodeHash"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.AccountId -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("AccountId"))
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.CodeHash -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.CodeHash>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.AccountId -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.AccountId>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): GlobalContractDeployMode {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                        if (s == "CodeHash") return io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.CodeHash
                        if (s == "AccountId") return io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.AccountId
                    }
                    throw SerializationException("Unknown discriminator (primitive) for GlobalContractDeployMode")
                }
                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing GlobalContractDeployMode")
                is JsonObject -> {
                    val jobj = element
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "CodeHash" -> return io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.CodeHash
                            "AccountId" -> return io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.AccountId
                            else -> throw SerializationException("Unknown discriminator key for GlobalContractDeployMode: " + key)
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
                        val knownVariantNames = setOf("CodeHash", "AccountId")
                        for ((k, v) in jobj.entries) {
                            if (v is JsonPrimitive && v.isString) {
                                val s = v.content
                                if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
                            }
                        }
                    }
                    if (typeField == null) throw SerializationException("Missing discriminator (one of changes_type) or recognizable variant in GlobalContractDeployMode")
                    val tf = typeField.trim()

                    // try exact match of full variant name first
                    val tfFull = tf
                    when (tfFull) {
                        "CodeHash" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.CodeHash>(), jobj)
                        "AccountId" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.AccountId>(), jobj)
                        else -> { /* fallthrough to grouped handling */ }
                    }

                    // grouped handling by base token (e.g. account_changes -> ...by_block_id / ...by_finality / ...by_sync_checkpoint)
                    val tfLower = tf.lowercase()
                    // select candidate group based on contains/equals heuristics
                    var chosenGroupKey: String? = null
                    if (chosenGroupKey == null && ("CodeHash".lowercase() == tfLower || tfLower.contains("CodeHash".lowercase()) || "CodeHash".lowercase().contains(tfLower))) { chosenGroupKey = "CodeHash" }
                    if (chosenGroupKey == null && ("AccountId".lowercase() == tfLower || tfLower.contains("AccountId".lowercase()) || "AccountId".lowercase().contains(tfLower))) { chosenGroupKey = "AccountId" }
                    if (chosenGroupKey != null) {
                        when (chosenGroupKey) {
                            "CodeHash" -> {
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.CodeHash>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'CodeHash' and tf='$tf'")
                            }
                            "AccountId" -> {
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.AccountId>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'AccountId' and tf='$tf'")
                            }
                            else -> { /* no group matched */ }
                        }
                    }

                    // fallback: try required-field matching and scoring heuristics
                    val requiredMatches = mutableListOf<Int>()
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.CodeHash>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.AccountId>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 0 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 1 }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.CodeHash>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.AccountId>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    // last resort: try decoding each data-class variant
                    throw SerializationException("Missing discriminator or recognizable variant in GlobalContractDeployMode")
                }
            }
        }
        throw SerializationException("Cannot deserialize GlobalContractDeployMode with non-JSON decoder")
    }
}
