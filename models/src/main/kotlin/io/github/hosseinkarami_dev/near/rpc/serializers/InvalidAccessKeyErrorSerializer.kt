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
import io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError
import kotlinx.serialization.json.*

object InvalidAccessKeyErrorSerializer : KSerializer<InvalidAccessKeyError> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError") {
        element("AccessKeyNotFound", serializer<JsonElement>().descriptor)
        element("ReceiverMismatch", serializer<JsonElement>().descriptor)
        element("MethodNameMismatch", serializer<JsonElement>().descriptor)
        element("RequiresFullAccess", serializer<JsonElement>().descriptor)
        element("NotEnoughAllowance", serializer<JsonElement>().descriptor)
        element("DepositWithFunctionCall", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: InvalidAccessKeyError) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.AccessKeyNotFound -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["AccessKeyNotFound"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.AccessKeyNotFound.AccessKeyNotFoundPayload>(), value.accessKeyNotFound)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.ReceiverMismatch -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["ReceiverMismatch"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.ReceiverMismatch.ReceiverMismatchPayload>(), value.receiverMismatch)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.MethodNameMismatch -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["MethodNameMismatch"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.MethodNameMismatch.MethodNameMismatchPayload>(), value.methodNameMismatch)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.RequiresFullAccess -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("RequiresFullAccess"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.NotEnoughAllowance -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["NotEnoughAllowance"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.NotEnoughAllowance.NotEnoughAllowancePayload>(), value.notEnoughAllowance)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.DepositWithFunctionCall -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("DepositWithFunctionCall"))
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.AccessKeyNotFound -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.AccessKeyNotFound>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.ReceiverMismatch -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.ReceiverMismatch>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.MethodNameMismatch -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.MethodNameMismatch>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.RequiresFullAccess -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.RequiresFullAccess>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.NotEnoughAllowance -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.NotEnoughAllowance>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.DepositWithFunctionCall -> out.encodeSerializableElement(descriptor, 5, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.DepositWithFunctionCall>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): InvalidAccessKeyError {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                        if (s == "RequiresFullAccess") return io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.RequiresFullAccess
                        if (s == "DepositWithFunctionCall") return io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.DepositWithFunctionCall
                    }
                    throw SerializationException("Unknown discriminator (primitive) for InvalidAccessKeyError")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing InvalidAccessKeyError")

                is JsonObject -> {
                    val jobj = element
                    if (jobj["AccessKeyNotFound"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.AccessKeyNotFound(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.AccessKeyNotFound.AccessKeyNotFoundPayload>(), jobj["AccessKeyNotFound"]!!))
                    }
                    if (jobj["ReceiverMismatch"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.ReceiverMismatch(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.ReceiverMismatch.ReceiverMismatchPayload>(), jobj["ReceiverMismatch"]!!))
                    }
                    if (jobj["MethodNameMismatch"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.MethodNameMismatch(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.MethodNameMismatch.MethodNameMismatchPayload>(), jobj["MethodNameMismatch"]!!))
                    }
                    if (jobj["NotEnoughAllowance"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.NotEnoughAllowance(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.NotEnoughAllowance.NotEnoughAllowancePayload>(), jobj["NotEnoughAllowance"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "AccessKeyNotFound" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant AccessKeyNotFound: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.AccessKeyNotFound>(), obj)
                            }
                            "ReceiverMismatch" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant ReceiverMismatch: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.ReceiverMismatch>(), obj)
                            }
                            "MethodNameMismatch" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant MethodNameMismatch: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.MethodNameMismatch>(), obj)
                            }
                            "NotEnoughAllowance" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant NotEnoughAllowance: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.NotEnoughAllowance>(), obj)
                            }
                            "RequiresFullAccess" -> return io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.RequiresFullAccess
                            "DepositWithFunctionCall" -> return io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.DepositWithFunctionCall
                            else -> throw SerializationException("Unknown discriminator key for InvalidAccessKeyError: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("AccessKeyNotFound")
                    for (cand in discriminatorCandidates) {
                        val candElem = jobj[cand]
                        if (candElem is JsonPrimitive) {
                            typeField = candElem.contentOrNull
                            if (typeField != null) break
                        }
                    }
                    if (typeField == null) {
                        val knownVariantNames = setOf("AccessKeyNotFound", "ReceiverMismatch", "MethodNameMismatch", "RequiresFullAccess", "NotEnoughAllowance", "DepositWithFunctionCall")
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
                            "AccessKeyNotFound" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.AccessKeyNotFound>(), jobj)
                            "ReceiverMismatch" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.ReceiverMismatch>(), jobj)
                            "MethodNameMismatch" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.MethodNameMismatch>(), jobj)
                            "RequiresFullAccess" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.RequiresFullAccess>(), jobj)
                            "NotEnoughAllowance" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.NotEnoughAllowance>(), jobj)
                            "DepositWithFunctionCall" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.DepositWithFunctionCall>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("AccessKeyNotFound".lowercase() == tfLower || tfLower.contains("AccessKeyNotFound".lowercase()) || "AccessKeyNotFound".lowercase().contains(tfLower))) { chosenGroupKey = "AccessKeyNotFound" }
                        if (chosenGroupKey == null && ("ReceiverMismatch".lowercase() == tfLower || tfLower.contains("ReceiverMismatch".lowercase()) || "ReceiverMismatch".lowercase().contains(tfLower))) { chosenGroupKey = "ReceiverMismatch" }
                        if (chosenGroupKey == null && ("MethodNameMismatch".lowercase() == tfLower || tfLower.contains("MethodNameMismatch".lowercase()) || "MethodNameMismatch".lowercase().contains(tfLower))) { chosenGroupKey = "MethodNameMismatch" }
                        if (chosenGroupKey == null && ("RequiresFullAccess".lowercase() == tfLower || tfLower.contains("RequiresFullAccess".lowercase()) || "RequiresFullAccess".lowercase().contains(tfLower))) { chosenGroupKey = "RequiresFullAccess" }
                        if (chosenGroupKey == null && ("NotEnoughAllowance".lowercase() == tfLower || tfLower.contains("NotEnoughAllowance".lowercase()) || "NotEnoughAllowance".lowercase().contains(tfLower))) { chosenGroupKey = "NotEnoughAllowance" }
                        if (chosenGroupKey == null && ("DepositWithFunctionCall".lowercase() == tfLower || tfLower.contains("DepositWithFunctionCall".lowercase()) || "DepositWithFunctionCall".lowercase().contains(tfLower))) { chosenGroupKey = "DepositWithFunctionCall" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "AccessKeyNotFound" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.AccessKeyNotFound>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'AccessKeyNotFound' and tf='$tf'")
                                }
                                "ReceiverMismatch" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.ReceiverMismatch>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'ReceiverMismatch' and tf='$tf'")
                                }
                                "MethodNameMismatch" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.MethodNameMismatch>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'MethodNameMismatch' and tf='$tf'")
                                }
                                "RequiresFullAccess" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.RequiresFullAccess>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'RequiresFullAccess' and tf='$tf'")
                                }
                                "NotEnoughAllowance" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.NotEnoughAllowance>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'NotEnoughAllowance' and tf='$tf'")
                                }
                                "DepositWithFunctionCall" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.DepositWithFunctionCall>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DepositWithFunctionCall' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: AccessKeyNotFound
                    // group: ReceiverMismatch
                    // group: MethodNameMismatch
                    // group: RequiresFullAccess
                    // group: NotEnoughAllowance
                    // group: DepositWithFunctionCall

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("AccessKeyNotFound")) requiredMatches.add(0)
                    if (jobj.containsKey("ReceiverMismatch")) requiredMatches.add(1)
                    if (jobj.containsKey("MethodNameMismatch")) requiredMatches.add(2)
                    if (jobj.containsKey("NotEnoughAllowance")) requiredMatches.add(4)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.AccessKeyNotFound>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.ReceiverMismatch>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.MethodNameMismatch>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.RequiresFullAccess>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.NotEnoughAllowance>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.DepositWithFunctionCall>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["AccessKeyNotFound"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["ReceiverMismatch"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["MethodNameMismatch"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 3 }
                    run {
                        var matchCount = 0
                        if (jobj["NotEnoughAllowance"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 4 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 5 }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.AccessKeyNotFound>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.ReceiverMismatch>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.MethodNameMismatch>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.RequiresFullAccess>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.NotEnoughAllowance>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.DepositWithFunctionCall>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.AccessKeyNotFound>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.ReceiverMismatch>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.MethodNameMismatch>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.NotEnoughAllowance>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in InvalidAccessKeyError")
                }
            }
        }
        throw SerializationException("Cannot deserialize InvalidAccessKeyError with non-JSON decoder")
    }
}
