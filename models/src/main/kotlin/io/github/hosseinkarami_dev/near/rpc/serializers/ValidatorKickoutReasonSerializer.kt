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
import io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason
import kotlinx.serialization.json.*

object ValidatorKickoutReasonSerializer : KSerializer<ValidatorKickoutReason> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason") {
        element("_UnusedSlashed", serializer<JsonElement>().descriptor)
        element("NotEnoughBlocks", serializer<JsonElement>().descriptor)
        element("NotEnoughChunks", serializer<JsonElement>().descriptor)
        element("Unstaked", serializer<JsonElement>().descriptor)
        element("NotEnoughStake", serializer<JsonElement>().descriptor)
        element("DidNotGetASeat", serializer<JsonElement>().descriptor)
        element("NotEnoughChunkEndorsements", serializer<JsonElement>().descriptor)
        element("ProtocolVersionTooOld", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: ValidatorKickoutReason) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.UnusedSlashed -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("_UnusedSlashed"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughBlocks -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["NotEnoughBlocks"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughBlocks.NotEnoughBlocksPayload>(), value.notEnoughBlocks)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunks -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["NotEnoughChunks"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunks.NotEnoughChunksPayload>(), value.notEnoughChunks)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.Unstaked -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("Unstaked"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughStake -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["NotEnoughStake"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughStake.NotEnoughStakePayload>(), value.notEnoughStake)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.DidNotGetASeat -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("DidNotGetASeat"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunkEndorsements -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["NotEnoughChunkEndorsements"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunkEndorsements.NotEnoughChunkEndorsementsPayload>(), value.notEnoughChunkEndorsements)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.ProtocolVersionTooOld -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["ProtocolVersionTooOld"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.ProtocolVersionTooOld.ProtocolVersionTooOldPayload>(), value.protocolVersionTooOld)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.UnusedSlashed -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.UnusedSlashed>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughBlocks -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughBlocks>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunks -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunks>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.Unstaked -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.Unstaked>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughStake -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughStake>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.DidNotGetASeat -> out.encodeSerializableElement(descriptor, 5, serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.DidNotGetASeat>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunkEndorsements -> out.encodeSerializableElement(descriptor, 6, serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunkEndorsements>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.ProtocolVersionTooOld -> out.encodeSerializableElement(descriptor, 7, serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.ProtocolVersionTooOld>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): ValidatorKickoutReason {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                        if (s == "_UnusedSlashed") return io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.UnusedSlashed
                        if (s == "Unstaked") return io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.Unstaked
                        if (s == "DidNotGetASeat") return io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.DidNotGetASeat
                    }
                    throw SerializationException("Unknown discriminator (primitive) for ValidatorKickoutReason")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing ValidatorKickoutReason")

                is JsonObject -> {
                    val jobj = element
                    if (jobj["NotEnoughBlocks"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughBlocks(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughBlocks.NotEnoughBlocksPayload>(), jobj["NotEnoughBlocks"]!!))
                    }
                    if (jobj["NotEnoughChunks"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunks(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunks.NotEnoughChunksPayload>(), jobj["NotEnoughChunks"]!!))
                    }
                    if (jobj["NotEnoughStake"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughStake(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughStake.NotEnoughStakePayload>(), jobj["NotEnoughStake"]!!))
                    }
                    if (jobj["NotEnoughChunkEndorsements"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunkEndorsements(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunkEndorsements.NotEnoughChunkEndorsementsPayload>(), jobj["NotEnoughChunkEndorsements"]!!))
                    }
                    if (jobj["ProtocolVersionTooOld"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.ProtocolVersionTooOld(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.ProtocolVersionTooOld.ProtocolVersionTooOldPayload>(), jobj["ProtocolVersionTooOld"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "NotEnoughBlocks" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant NotEnoughBlocks: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughBlocks>(), obj)
                            }
                            "NotEnoughChunks" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant NotEnoughChunks: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunks>(), obj)
                            }
                            "NotEnoughStake" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant NotEnoughStake: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughStake>(), obj)
                            }
                            "NotEnoughChunkEndorsements" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant NotEnoughChunkEndorsements: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunkEndorsements>(), obj)
                            }
                            "ProtocolVersionTooOld" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant ProtocolVersionTooOld: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.ProtocolVersionTooOld>(), obj)
                            }
                            "_UnusedSlashed" -> return io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.UnusedSlashed
                            "Unstaked" -> return io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.Unstaked
                            "DidNotGetASeat" -> return io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.DidNotGetASeat
                            else -> throw SerializationException("Unknown discriminator key for ValidatorKickoutReason: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("NotEnoughBlocks")
                    for (cand in discriminatorCandidates) {
                        val candElem = jobj[cand]
                        if (candElem is JsonPrimitive) {
                            typeField = candElem.contentOrNull
                            if (typeField != null) break
                        }
                    }
                    if (typeField == null) {
                        val knownVariantNames = setOf("_UnusedSlashed", "NotEnoughBlocks", "NotEnoughChunks", "Unstaked", "NotEnoughStake", "DidNotGetASeat", "NotEnoughChunkEndorsements", "ProtocolVersionTooOld")
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
                            "_UnusedSlashed" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.UnusedSlashed>(), jobj)
                            "NotEnoughBlocks" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughBlocks>(), jobj)
                            "NotEnoughChunks" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunks>(), jobj)
                            "Unstaked" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.Unstaked>(), jobj)
                            "NotEnoughStake" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughStake>(), jobj)
                            "DidNotGetASeat" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.DidNotGetASeat>(), jobj)
                            "NotEnoughChunkEndorsements" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunkEndorsements>(), jobj)
                            "ProtocolVersionTooOld" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.ProtocolVersionTooOld>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("_UnusedSlashed".lowercase() == tfLower || tfLower.contains("_UnusedSlashed".lowercase()) || "_UnusedSlashed".lowercase().contains(tfLower))) { chosenGroupKey = "_UnusedSlashed" }
                        if (chosenGroupKey == null && ("NotEnoughBlocks".lowercase() == tfLower || tfLower.contains("NotEnoughBlocks".lowercase()) || "NotEnoughBlocks".lowercase().contains(tfLower))) { chosenGroupKey = "NotEnoughBlocks" }
                        if (chosenGroupKey == null && ("NotEnoughChunks".lowercase() == tfLower || tfLower.contains("NotEnoughChunks".lowercase()) || "NotEnoughChunks".lowercase().contains(tfLower))) { chosenGroupKey = "NotEnoughChunks" }
                        if (chosenGroupKey == null && ("Unstaked".lowercase() == tfLower || tfLower.contains("Unstaked".lowercase()) || "Unstaked".lowercase().contains(tfLower))) { chosenGroupKey = "Unstaked" }
                        if (chosenGroupKey == null && ("NotEnoughStake".lowercase() == tfLower || tfLower.contains("NotEnoughStake".lowercase()) || "NotEnoughStake".lowercase().contains(tfLower))) { chosenGroupKey = "NotEnoughStake" }
                        if (chosenGroupKey == null && ("DidNotGetASeat".lowercase() == tfLower || tfLower.contains("DidNotGetASeat".lowercase()) || "DidNotGetASeat".lowercase().contains(tfLower))) { chosenGroupKey = "DidNotGetASeat" }
                        if (chosenGroupKey == null && ("NotEnoughChunkEndorsements".lowercase() == tfLower || tfLower.contains("NotEnoughChunkEndorsements".lowercase()) || "NotEnoughChunkEndorsements".lowercase().contains(tfLower))) { chosenGroupKey = "NotEnoughChunkEndorsements" }
                        if (chosenGroupKey == null && ("ProtocolVersionTooOld".lowercase() == tfLower || tfLower.contains("ProtocolVersionTooOld".lowercase()) || "ProtocolVersionTooOld".lowercase().contains(tfLower))) { chosenGroupKey = "ProtocolVersionTooOld" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "_UnusedSlashed" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.UnusedSlashed>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token '_UnusedSlashed' and tf='$tf'")
                                }
                                "NotEnoughBlocks" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughBlocks>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'NotEnoughBlocks' and tf='$tf'")
                                }
                                "NotEnoughChunks" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunks>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'NotEnoughChunks' and tf='$tf'")
                                }
                                "Unstaked" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.Unstaked>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Unstaked' and tf='$tf'")
                                }
                                "NotEnoughStake" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughStake>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'NotEnoughStake' and tf='$tf'")
                                }
                                "DidNotGetASeat" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.DidNotGetASeat>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DidNotGetASeat' and tf='$tf'")
                                }
                                "NotEnoughChunkEndorsements" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunkEndorsements>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'NotEnoughChunkEndorsements' and tf='$tf'")
                                }
                                "ProtocolVersionTooOld" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.ProtocolVersionTooOld>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'ProtocolVersionTooOld' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: _UnusedSlashed
                    // group: NotEnoughBlocks
                    // group: NotEnoughChunks
                    // group: Unstaked
                    // group: NotEnoughStake
                    // group: DidNotGetASeat
                    // group: NotEnoughChunkEndorsements
                    // group: ProtocolVersionTooOld

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("NotEnoughBlocks")) requiredMatches.add(1)
                    if (jobj.containsKey("NotEnoughChunks")) requiredMatches.add(2)
                    if (jobj.containsKey("NotEnoughStake")) requiredMatches.add(4)
                    if (jobj.containsKey("NotEnoughChunkEndorsements")) requiredMatches.add(6)
                    if (jobj.containsKey("ProtocolVersionTooOld")) requiredMatches.add(7)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.UnusedSlashed>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughBlocks>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunks>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.Unstaked>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughStake>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.DidNotGetASeat>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunkEndorsements>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.ProtocolVersionTooOld>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 0 }
                    run {
                        var matchCount = 0
                        if (jobj["NotEnoughBlocks"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["NotEnoughChunks"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 3 }
                    run {
                        var matchCount = 0
                        if (jobj["NotEnoughStake"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 4 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 5 }
                    run {
                        var matchCount = 0
                        if (jobj["NotEnoughChunkEndorsements"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 6 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["ProtocolVersionTooOld"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 7 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.UnusedSlashed>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughBlocks>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunks>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.Unstaked>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughStake>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.DidNotGetASeat>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunkEndorsements>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.ProtocolVersionTooOld>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughBlocks>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunks>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughStake>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.NotEnoughChunkEndorsements>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.ProtocolVersionTooOld>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in ValidatorKickoutReason")
                }
            }
        }
        throw SerializationException("Cannot deserialize ValidatorKickoutReason with non-JSON decoder")
    }
}
