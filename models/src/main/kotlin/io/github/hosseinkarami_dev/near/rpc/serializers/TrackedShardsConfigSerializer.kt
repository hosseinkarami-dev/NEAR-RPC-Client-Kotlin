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
import io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig
import kotlinx.serialization.json.*

object TrackedShardsConfigSerializer : KSerializer<TrackedShardsConfig> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig") {
        element("NoShards", serializer<JsonElement>().descriptor)
        element("Shards", serializer<JsonElement>().descriptor)
        element("AllShards", serializer<JsonElement>().descriptor)
        element("ShadowValidator", serializer<JsonElement>().descriptor)
        element("Schedule", serializer<JsonElement>().descriptor)
        element("Accounts", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: TrackedShardsConfig) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.NoShards -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("NoShards"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Shards -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["Shards"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardUId>()), value.shards)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.AllShards -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("AllShards"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.ShadowValidator -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["ShadowValidator"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.shadowValidator)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Schedule -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["Schedule"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardId>())), value.schedule)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Accounts -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["Accounts"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>()), value.accounts)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.NoShards -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.NoShards>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Shards -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Shards>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.AllShards -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.AllShards>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.ShadowValidator -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.ShadowValidator>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Schedule -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Schedule>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Accounts -> out.encodeSerializableElement(descriptor, 5, serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Accounts>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): TrackedShardsConfig {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                        if (s == "NoShards") return io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.NoShards
                        if (s == "AllShards") return io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.AllShards
                    }
                    throw SerializationException("Unknown discriminator (primitive) for TrackedShardsConfig")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing TrackedShardsConfig")

                is JsonObject -> {
                    val jobj = element
                    if (jobj["Shards"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Shards(decoder.json.decodeFromJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardUId>()), jobj["Shards"]!!))
                    }
                    if (jobj["ShadowValidator"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.ShadowValidator(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), jobj["ShadowValidator"]!!))
                    }
                    if (jobj["Schedule"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Schedule(decoder.json.decodeFromJsonElement(ListSerializer(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardId>())), jobj["Schedule"]!!))
                    }
                    if (jobj["Accounts"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Accounts(decoder.json.decodeFromJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>()), jobj["Accounts"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "Shards" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant Shards: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Shards>(), obj)
                            }
                            "ShadowValidator" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant ShadowValidator: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.ShadowValidator>(), obj)
                            }
                            "Schedule" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant Schedule: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Schedule>(), obj)
                            }
                            "Accounts" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant Accounts: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Accounts>(), obj)
                            }
                            "NoShards" -> return io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.NoShards
                            "AllShards" -> return io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.AllShards
                            else -> throw SerializationException("Unknown discriminator key for TrackedShardsConfig: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = emptyList<String>()
                    if (typeField == null) {
                        val knownVariantNames = setOf("NoShards", "Shards", "AllShards", "ShadowValidator", "Schedule", "Accounts")
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
                            "NoShards" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.NoShards>(), jobj)
                            "Shards" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Shards>(), jobj)
                            "AllShards" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.AllShards>(), jobj)
                            "ShadowValidator" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.ShadowValidator>(), jobj)
                            "Schedule" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Schedule>(), jobj)
                            "Accounts" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Accounts>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("NoShards".lowercase() == tfLower || tfLower.contains("NoShards".lowercase()) || "NoShards".lowercase().contains(tfLower))) { chosenGroupKey = "NoShards" }
                        if (chosenGroupKey == null && ("Shards".lowercase() == tfLower || tfLower.contains("Shards".lowercase()) || "Shards".lowercase().contains(tfLower))) { chosenGroupKey = "Shards" }
                        if (chosenGroupKey == null && ("AllShards".lowercase() == tfLower || tfLower.contains("AllShards".lowercase()) || "AllShards".lowercase().contains(tfLower))) { chosenGroupKey = "AllShards" }
                        if (chosenGroupKey == null && ("ShadowValidator".lowercase() == tfLower || tfLower.contains("ShadowValidator".lowercase()) || "ShadowValidator".lowercase().contains(tfLower))) { chosenGroupKey = "ShadowValidator" }
                        if (chosenGroupKey == null && ("Schedule".lowercase() == tfLower || tfLower.contains("Schedule".lowercase()) || "Schedule".lowercase().contains(tfLower))) { chosenGroupKey = "Schedule" }
                        if (chosenGroupKey == null && ("Accounts".lowercase() == tfLower || tfLower.contains("Accounts".lowercase()) || "Accounts".lowercase().contains(tfLower))) { chosenGroupKey = "Accounts" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "NoShards" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.NoShards>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'NoShards' and tf='$tf'")
                                }
                                "Shards" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Shards>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Shards' and tf='$tf'")
                                }
                                "AllShards" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.AllShards>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'AllShards' and tf='$tf'")
                                }
                                "ShadowValidator" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.ShadowValidator>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'ShadowValidator' and tf='$tf'")
                                }
                                "Schedule" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Schedule>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Schedule' and tf='$tf'")
                                }
                                "Accounts" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Accounts>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Accounts' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: NoShards
                    // group: Shards
                    // group: AllShards
                    // group: ShadowValidator
                    // group: Schedule
                    // group: Accounts

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("Shards")) requiredMatches.add(1)
                    if (jobj.containsKey("ShadowValidator")) requiredMatches.add(3)
                    if (jobj.containsKey("Schedule")) requiredMatches.add(4)
                    if (jobj.containsKey("Accounts")) requiredMatches.add(5)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.NoShards>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Shards>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.AllShards>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.ShadowValidator>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Schedule>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Accounts>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 0 }
                    run {
                        var matchCount = 0
                        if (jobj["Shards"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 2 }
                    run {
                        var matchCount = 0
                        if (jobj["ShadowValidator"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 3 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["Schedule"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 4 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["Accounts"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 5 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.NoShards>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Shards>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.AllShards>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.ShadowValidator>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Schedule>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Accounts>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Shards>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.ShadowValidator>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Schedule>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Accounts>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in TrackedShardsConfig")
                }
            }
        }
        throw SerializationException("Cannot deserialize TrackedShardsConfig with non-JSON decoder")
    }
}
