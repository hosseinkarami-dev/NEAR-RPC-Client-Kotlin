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
import io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError
import kotlinx.serialization.json.*

object ReceiptValidationErrorSerializer : KSerializer<ReceiptValidationError> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError") {
        element("InvalidPredecessorId", serializer<JsonElement>().descriptor)
        element("InvalidReceiverId", serializer<JsonElement>().descriptor)
        element("InvalidSignerId", serializer<JsonElement>().descriptor)
        element("InvalidDataReceiverId", serializer<JsonElement>().descriptor)
        element("ReturnedValueLengthExceeded", serializer<JsonElement>().descriptor)
        element("NumberInputDataDependenciesExceeded", serializer<JsonElement>().descriptor)
        element("ActionsValidation", serializer<JsonElement>().descriptor)
        element("ReceiptSizeExceeded", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: ReceiptValidationError) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidPredecessorId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["InvalidPredecessorId"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidPredecessorId.InvalidPredecessorIdPayload>(), value.invalidPredecessorId)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidReceiverId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["InvalidReceiverId"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidReceiverId.InvalidReceiverIdPayload>(), value.invalidReceiverId)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidSignerId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["InvalidSignerId"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidSignerId.InvalidSignerIdPayload>(), value.invalidSignerId)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidDataReceiverId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["InvalidDataReceiverId"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidDataReceiverId.InvalidDataReceiverIdPayload>(), value.invalidDataReceiverId)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReturnedValueLengthExceeded -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["ReturnedValueLengthExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReturnedValueLengthExceeded.ReturnedValueLengthExceededPayload>(), value.returnedValueLengthExceeded)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.NumberInputDataDependenciesExceeded -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["NumberInputDataDependenciesExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.NumberInputDataDependenciesExceeded.NumberInputDataDependenciesExceededPayload>(), value.numberInputDataDependenciesExceeded)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ActionsValidation -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["ActionsValidation"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError>(), value.actionsValidation)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReceiptSizeExceeded -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["ReceiptSizeExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReceiptSizeExceeded.ReceiptSizeExceededPayload>(), value.receiptSizeExceeded)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidPredecessorId -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidPredecessorId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidReceiverId -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidReceiverId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidSignerId -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidSignerId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidDataReceiverId -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidDataReceiverId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReturnedValueLengthExceeded -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReturnedValueLengthExceeded>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.NumberInputDataDependenciesExceeded -> out.encodeSerializableElement(descriptor, 5, serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.NumberInputDataDependenciesExceeded>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ActionsValidation -> out.encodeSerializableElement(descriptor, 6, serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ActionsValidation>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReceiptSizeExceeded -> out.encodeSerializableElement(descriptor, 7, serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReceiptSizeExceeded>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): ReceiptValidationError {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    throw SerializationException("Unknown discriminator (primitive) for ReceiptValidationError")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing ReceiptValidationError")

                is JsonObject -> {
                    val jobj = element
                    if (jobj["InvalidPredecessorId"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidPredecessorId(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidPredecessorId.InvalidPredecessorIdPayload>(), jobj["InvalidPredecessorId"]!!))
                    }
                    if (jobj["InvalidReceiverId"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidReceiverId(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidReceiverId.InvalidReceiverIdPayload>(), jobj["InvalidReceiverId"]!!))
                    }
                    if (jobj["InvalidSignerId"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidSignerId(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidSignerId.InvalidSignerIdPayload>(), jobj["InvalidSignerId"]!!))
                    }
                    if (jobj["InvalidDataReceiverId"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidDataReceiverId(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidDataReceiverId.InvalidDataReceiverIdPayload>(), jobj["InvalidDataReceiverId"]!!))
                    }
                    if (jobj["ReturnedValueLengthExceeded"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReturnedValueLengthExceeded(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReturnedValueLengthExceeded.ReturnedValueLengthExceededPayload>(), jobj["ReturnedValueLengthExceeded"]!!))
                    }
                    if (jobj["NumberInputDataDependenciesExceeded"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.NumberInputDataDependenciesExceeded(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.NumberInputDataDependenciesExceeded.NumberInputDataDependenciesExceededPayload>(), jobj["NumberInputDataDependenciesExceeded"]!!))
                    }
                    if (jobj["ActionsValidation"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ActionsValidation(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError>(), jobj["ActionsValidation"]!!))
                    }
                    if (jobj["ReceiptSizeExceeded"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReceiptSizeExceeded(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReceiptSizeExceeded.ReceiptSizeExceededPayload>(), jobj["ReceiptSizeExceeded"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "InvalidPredecessorId" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant InvalidPredecessorId: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidPredecessorId>(), obj)
                            }
                            "InvalidReceiverId" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant InvalidReceiverId: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidReceiverId>(), obj)
                            }
                            "InvalidSignerId" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant InvalidSignerId: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidSignerId>(), obj)
                            }
                            "InvalidDataReceiverId" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant InvalidDataReceiverId: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidDataReceiverId>(), obj)
                            }
                            "ReturnedValueLengthExceeded" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant ReturnedValueLengthExceeded: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReturnedValueLengthExceeded>(), obj)
                            }
                            "NumberInputDataDependenciesExceeded" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant NumberInputDataDependenciesExceeded: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.NumberInputDataDependenciesExceeded>(), obj)
                            }
                            "ActionsValidation" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant ActionsValidation: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ActionsValidation>(), obj)
                            }
                            "ReceiptSizeExceeded" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant ReceiptSizeExceeded: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReceiptSizeExceeded>(), obj)
                            }
                            else -> throw SerializationException("Unknown discriminator key for ReceiptValidationError: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("InvalidPredecessorId")
                    for (cand in discriminatorCandidates) {
                        val candElem = jobj[cand]
                        if (candElem is JsonPrimitive) {
                            typeField = candElem.contentOrNull
                            if (typeField != null) break
                        }
                    }
                    if (typeField == null) {
                        val knownVariantNames = setOf("InvalidPredecessorId", "InvalidReceiverId", "InvalidSignerId", "InvalidDataReceiverId", "ReturnedValueLengthExceeded", "NumberInputDataDependenciesExceeded", "ActionsValidation", "ReceiptSizeExceeded")
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
                            "InvalidPredecessorId" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidPredecessorId>(), jobj)
                            "InvalidReceiverId" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidReceiverId>(), jobj)
                            "InvalidSignerId" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidSignerId>(), jobj)
                            "InvalidDataReceiverId" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidDataReceiverId>(), jobj)
                            "ReturnedValueLengthExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReturnedValueLengthExceeded>(), jobj)
                            "NumberInputDataDependenciesExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.NumberInputDataDependenciesExceeded>(), jobj)
                            "ActionsValidation" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ActionsValidation>(), jobj)
                            "ReceiptSizeExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReceiptSizeExceeded>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("InvalidPredecessorId".lowercase() == tfLower || tfLower.contains("InvalidPredecessorId".lowercase()) || "InvalidPredecessorId".lowercase().contains(tfLower))) { chosenGroupKey = "InvalidPredecessorId" }
                        if (chosenGroupKey == null && ("InvalidReceiverId".lowercase() == tfLower || tfLower.contains("InvalidReceiverId".lowercase()) || "InvalidReceiverId".lowercase().contains(tfLower))) { chosenGroupKey = "InvalidReceiverId" }
                        if (chosenGroupKey == null && ("InvalidSignerId".lowercase() == tfLower || tfLower.contains("InvalidSignerId".lowercase()) || "InvalidSignerId".lowercase().contains(tfLower))) { chosenGroupKey = "InvalidSignerId" }
                        if (chosenGroupKey == null && ("InvalidDataReceiverId".lowercase() == tfLower || tfLower.contains("InvalidDataReceiverId".lowercase()) || "InvalidDataReceiverId".lowercase().contains(tfLower))) { chosenGroupKey = "InvalidDataReceiverId" }
                        if (chosenGroupKey == null && ("ReturnedValueLengthExceeded".lowercase() == tfLower || tfLower.contains("ReturnedValueLengthExceeded".lowercase()) || "ReturnedValueLengthExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "ReturnedValueLengthExceeded" }
                        if (chosenGroupKey == null && ("NumberInputDataDependenciesExceeded".lowercase() == tfLower || tfLower.contains("NumberInputDataDependenciesExceeded".lowercase()) || "NumberInputDataDependenciesExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "NumberInputDataDependenciesExceeded" }
                        if (chosenGroupKey == null && ("ActionsValidation".lowercase() == tfLower || tfLower.contains("ActionsValidation".lowercase()) || "ActionsValidation".lowercase().contains(tfLower))) { chosenGroupKey = "ActionsValidation" }
                        if (chosenGroupKey == null && ("ReceiptSizeExceeded".lowercase() == tfLower || tfLower.contains("ReceiptSizeExceeded".lowercase()) || "ReceiptSizeExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "ReceiptSizeExceeded" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "InvalidPredecessorId" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidPredecessorId>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InvalidPredecessorId' and tf='$tf'")
                                }
                                "InvalidReceiverId" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidReceiverId>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InvalidReceiverId' and tf='$tf'")
                                }
                                "InvalidSignerId" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidSignerId>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InvalidSignerId' and tf='$tf'")
                                }
                                "InvalidDataReceiverId" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidDataReceiverId>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InvalidDataReceiverId' and tf='$tf'")
                                }
                                "ReturnedValueLengthExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReturnedValueLengthExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'ReturnedValueLengthExceeded' and tf='$tf'")
                                }
                                "NumberInputDataDependenciesExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.NumberInputDataDependenciesExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'NumberInputDataDependenciesExceeded' and tf='$tf'")
                                }
                                "ActionsValidation" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ActionsValidation>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'ActionsValidation' and tf='$tf'")
                                }
                                "ReceiptSizeExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReceiptSizeExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'ReceiptSizeExceeded' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: InvalidPredecessorId
                    // group: InvalidReceiverId
                    // group: InvalidSignerId
                    // group: InvalidDataReceiverId
                    // group: ReturnedValueLengthExceeded
                    // group: NumberInputDataDependenciesExceeded
                    // group: ActionsValidation
                    // group: ReceiptSizeExceeded

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("InvalidPredecessorId")) requiredMatches.add(0)
                    if (jobj.containsKey("InvalidReceiverId")) requiredMatches.add(1)
                    if (jobj.containsKey("InvalidSignerId")) requiredMatches.add(2)
                    if (jobj.containsKey("InvalidDataReceiverId")) requiredMatches.add(3)
                    if (jobj.containsKey("ReturnedValueLengthExceeded")) requiredMatches.add(4)
                    if (jobj.containsKey("NumberInputDataDependenciesExceeded")) requiredMatches.add(5)
                    if (jobj.containsKey("ActionsValidation")) requiredMatches.add(6)
                    if (jobj.containsKey("ReceiptSizeExceeded")) requiredMatches.add(7)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidPredecessorId>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidReceiverId>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidSignerId>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidDataReceiverId>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReturnedValueLengthExceeded>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.NumberInputDataDependenciesExceeded>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ActionsValidation>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReceiptSizeExceeded>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["InvalidPredecessorId"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["InvalidReceiverId"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["InvalidSignerId"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["InvalidDataReceiverId"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 3 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["ReturnedValueLengthExceeded"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 4 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["NumberInputDataDependenciesExceeded"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 5 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["ActionsValidation"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 6 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["ReceiptSizeExceeded"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 7 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidPredecessorId>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidReceiverId>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidSignerId>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidDataReceiverId>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReturnedValueLengthExceeded>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.NumberInputDataDependenciesExceeded>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ActionsValidation>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReceiptSizeExceeded>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidPredecessorId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidReceiverId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidSignerId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.InvalidDataReceiverId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReturnedValueLengthExceeded>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.NumberInputDataDependenciesExceeded>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ActionsValidation>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.ReceiptSizeExceeded>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in ReceiptValidationError")
                }
            }
        }
        throw SerializationException("Cannot deserialize ReceiptValidationError with non-JSON decoder")
    }
}
