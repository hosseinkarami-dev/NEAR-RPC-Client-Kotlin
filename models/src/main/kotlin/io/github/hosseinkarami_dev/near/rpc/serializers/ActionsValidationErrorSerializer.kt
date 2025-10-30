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
import io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError
import kotlinx.serialization.json.*

object ActionsValidationErrorSerializer : KSerializer<ActionsValidationError> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError") {
        element("DeleteActionMustBeFinal", serializer<JsonElement>().descriptor)
        element("TotalPrepaidGasExceeded", serializer<JsonElement>().descriptor)
        element("TotalNumberOfActionsExceeded", serializer<JsonElement>().descriptor)
        element("AddKeyMethodNamesNumberOfBytesExceeded", serializer<JsonElement>().descriptor)
        element("AddKeyMethodNameLengthExceeded", serializer<JsonElement>().descriptor)
        element("IntegerOverflow", serializer<JsonElement>().descriptor)
        element("InvalidAccountId", serializer<JsonElement>().descriptor)
        element("ContractSizeExceeded", serializer<JsonElement>().descriptor)
        element("FunctionCallMethodNameLengthExceeded", serializer<JsonElement>().descriptor)
        element("FunctionCallArgumentsLengthExceeded", serializer<JsonElement>().descriptor)
        element("UnsuitableStakingKey", serializer<JsonElement>().descriptor)
        element("FunctionCallZeroAttachedGas", serializer<JsonElement>().descriptor)
        element("DelegateActionMustBeOnlyOne", serializer<JsonElement>().descriptor)
        element("UnsupportedProtocolFeature", serializer<JsonElement>().descriptor)
        element("InvalidDeterministicStateInitReceiver", serializer<JsonElement>().descriptor)
        element("DeterministicStateInitKeyLengthExceeded", serializer<JsonElement>().descriptor)
        element("DeterministicStateInitValueLengthExceeded", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: ActionsValidationError) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeleteActionMustBeFinal -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("DeleteActionMustBeFinal"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalPrepaidGasExceeded -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["TotalPrepaidGasExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalPrepaidGasExceeded.TotalPrepaidGasExceededPayload>(), value.totalPrepaidGasExceeded)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalNumberOfActionsExceeded -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["TotalNumberOfActionsExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalNumberOfActionsExceeded.TotalNumberOfActionsExceededPayload>(), value.totalNumberOfActionsExceeded)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNamesNumberOfBytesExceeded -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["AddKeyMethodNamesNumberOfBytesExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNamesNumberOfBytesExceeded.AddKeyMethodNamesNumberOfBytesExceededPayload>(), value.addKeyMethodNamesNumberOfBytesExceeded)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNameLengthExceeded -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["AddKeyMethodNameLengthExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNameLengthExceeded.AddKeyMethodNameLengthExceededPayload>(), value.addKeyMethodNameLengthExceeded)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.IntegerOverflow -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("IntegerOverflow"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidAccountId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["InvalidAccountId"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidAccountId.InvalidAccountIdPayload>(), value.invalidAccountId)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.ContractSizeExceeded -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["ContractSizeExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.ContractSizeExceeded.ContractSizeExceededPayload>(), value.contractSizeExceeded)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallMethodNameLengthExceeded -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["FunctionCallMethodNameLengthExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallMethodNameLengthExceeded.FunctionCallMethodNameLengthExceededPayload>(), value.functionCallMethodNameLengthExceeded)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallArgumentsLengthExceeded -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["FunctionCallArgumentsLengthExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallArgumentsLengthExceeded.FunctionCallArgumentsLengthExceededPayload>(), value.functionCallArgumentsLengthExceeded)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsuitableStakingKey -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["UnsuitableStakingKey"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsuitableStakingKey.UnsuitableStakingKeyPayload>(), value.unsuitableStakingKey)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallZeroAttachedGas -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("FunctionCallZeroAttachedGas"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DelegateActionMustBeOnlyOne -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("DelegateActionMustBeOnlyOne"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsupportedProtocolFeature -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["UnsupportedProtocolFeature"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsupportedProtocolFeature.UnsupportedProtocolFeaturePayload>(), value.unsupportedProtocolFeature)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidDeterministicStateInitReceiver -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["InvalidDeterministicStateInitReceiver"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidDeterministicStateInitReceiver.InvalidDeterministicStateInitReceiverPayload>(), value.invalidDeterministicStateInitReceiver)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitKeyLengthExceeded -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["DeterministicStateInitKeyLengthExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitKeyLengthExceeded.DeterministicStateInitKeyLengthExceededPayload>(), value.deterministicStateInitKeyLengthExceeded)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitValueLengthExceeded -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["DeterministicStateInitValueLengthExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitValueLengthExceeded.DeterministicStateInitValueLengthExceededPayload>(), value.deterministicStateInitValueLengthExceeded)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeleteActionMustBeFinal -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeleteActionMustBeFinal>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalPrepaidGasExceeded -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalPrepaidGasExceeded>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalNumberOfActionsExceeded -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalNumberOfActionsExceeded>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNamesNumberOfBytesExceeded -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNamesNumberOfBytesExceeded>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNameLengthExceeded -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNameLengthExceeded>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.IntegerOverflow -> out.encodeSerializableElement(descriptor, 5, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.IntegerOverflow>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidAccountId -> out.encodeSerializableElement(descriptor, 6, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidAccountId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.ContractSizeExceeded -> out.encodeSerializableElement(descriptor, 7, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.ContractSizeExceeded>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallMethodNameLengthExceeded -> out.encodeSerializableElement(descriptor, 8, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallMethodNameLengthExceeded>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallArgumentsLengthExceeded -> out.encodeSerializableElement(descriptor, 9, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallArgumentsLengthExceeded>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsuitableStakingKey -> out.encodeSerializableElement(descriptor, 10, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsuitableStakingKey>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallZeroAttachedGas -> out.encodeSerializableElement(descriptor, 11, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallZeroAttachedGas>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DelegateActionMustBeOnlyOne -> out.encodeSerializableElement(descriptor, 12, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DelegateActionMustBeOnlyOne>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsupportedProtocolFeature -> out.encodeSerializableElement(descriptor, 13, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsupportedProtocolFeature>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidDeterministicStateInitReceiver -> out.encodeSerializableElement(descriptor, 14, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidDeterministicStateInitReceiver>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitKeyLengthExceeded -> out.encodeSerializableElement(descriptor, 15, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitKeyLengthExceeded>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitValueLengthExceeded -> out.encodeSerializableElement(descriptor, 16, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitValueLengthExceeded>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): ActionsValidationError {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                        if (s == "DeleteActionMustBeFinal") return io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeleteActionMustBeFinal
                        if (s == "IntegerOverflow") return io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.IntegerOverflow
                        if (s == "FunctionCallZeroAttachedGas") return io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallZeroAttachedGas
                        if (s == "DelegateActionMustBeOnlyOne") return io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DelegateActionMustBeOnlyOne
                    }
                    throw SerializationException("Unknown discriminator (primitive) for ActionsValidationError")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing ActionsValidationError")

                is JsonObject -> {
                    val jobj = element
                    if (jobj["TotalPrepaidGasExceeded"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalPrepaidGasExceeded(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalPrepaidGasExceeded.TotalPrepaidGasExceededPayload>(), jobj["TotalPrepaidGasExceeded"]!!))
                    }
                    if (jobj["TotalNumberOfActionsExceeded"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalNumberOfActionsExceeded(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalNumberOfActionsExceeded.TotalNumberOfActionsExceededPayload>(), jobj["TotalNumberOfActionsExceeded"]!!))
                    }
                    if (jobj["AddKeyMethodNamesNumberOfBytesExceeded"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNamesNumberOfBytesExceeded(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNamesNumberOfBytesExceeded.AddKeyMethodNamesNumberOfBytesExceededPayload>(), jobj["AddKeyMethodNamesNumberOfBytesExceeded"]!!))
                    }
                    if (jobj["AddKeyMethodNameLengthExceeded"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNameLengthExceeded(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNameLengthExceeded.AddKeyMethodNameLengthExceededPayload>(), jobj["AddKeyMethodNameLengthExceeded"]!!))
                    }
                    if (jobj["InvalidAccountId"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidAccountId(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidAccountId.InvalidAccountIdPayload>(), jobj["InvalidAccountId"]!!))
                    }
                    if (jobj["ContractSizeExceeded"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.ContractSizeExceeded(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.ContractSizeExceeded.ContractSizeExceededPayload>(), jobj["ContractSizeExceeded"]!!))
                    }
                    if (jobj["FunctionCallMethodNameLengthExceeded"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallMethodNameLengthExceeded(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallMethodNameLengthExceeded.FunctionCallMethodNameLengthExceededPayload>(), jobj["FunctionCallMethodNameLengthExceeded"]!!))
                    }
                    if (jobj["FunctionCallArgumentsLengthExceeded"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallArgumentsLengthExceeded(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallArgumentsLengthExceeded.FunctionCallArgumentsLengthExceededPayload>(), jobj["FunctionCallArgumentsLengthExceeded"]!!))
                    }
                    if (jobj["UnsuitableStakingKey"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsuitableStakingKey(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsuitableStakingKey.UnsuitableStakingKeyPayload>(), jobj["UnsuitableStakingKey"]!!))
                    }
                    if (jobj["UnsupportedProtocolFeature"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsupportedProtocolFeature(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsupportedProtocolFeature.UnsupportedProtocolFeaturePayload>(), jobj["UnsupportedProtocolFeature"]!!))
                    }
                    if (jobj["InvalidDeterministicStateInitReceiver"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidDeterministicStateInitReceiver(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidDeterministicStateInitReceiver.InvalidDeterministicStateInitReceiverPayload>(), jobj["InvalidDeterministicStateInitReceiver"]!!))
                    }
                    if (jobj["DeterministicStateInitKeyLengthExceeded"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitKeyLengthExceeded(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitKeyLengthExceeded.DeterministicStateInitKeyLengthExceededPayload>(), jobj["DeterministicStateInitKeyLengthExceeded"]!!))
                    }
                    if (jobj["DeterministicStateInitValueLengthExceeded"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitValueLengthExceeded(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitValueLengthExceeded.DeterministicStateInitValueLengthExceededPayload>(), jobj["DeterministicStateInitValueLengthExceeded"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "TotalPrepaidGasExceeded" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant TotalPrepaidGasExceeded: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalPrepaidGasExceeded>(), obj)
                            }
                            "TotalNumberOfActionsExceeded" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant TotalNumberOfActionsExceeded: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalNumberOfActionsExceeded>(), obj)
                            }
                            "AddKeyMethodNamesNumberOfBytesExceeded" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant AddKeyMethodNamesNumberOfBytesExceeded: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNamesNumberOfBytesExceeded>(), obj)
                            }
                            "AddKeyMethodNameLengthExceeded" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant AddKeyMethodNameLengthExceeded: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNameLengthExceeded>(), obj)
                            }
                            "InvalidAccountId" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant InvalidAccountId: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidAccountId>(), obj)
                            }
                            "ContractSizeExceeded" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant ContractSizeExceeded: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.ContractSizeExceeded>(), obj)
                            }
                            "FunctionCallMethodNameLengthExceeded" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant FunctionCallMethodNameLengthExceeded: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallMethodNameLengthExceeded>(), obj)
                            }
                            "FunctionCallArgumentsLengthExceeded" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant FunctionCallArgumentsLengthExceeded: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallArgumentsLengthExceeded>(), obj)
                            }
                            "UnsuitableStakingKey" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant UnsuitableStakingKey: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsuitableStakingKey>(), obj)
                            }
                            "UnsupportedProtocolFeature" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant UnsupportedProtocolFeature: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsupportedProtocolFeature>(), obj)
                            }
                            "InvalidDeterministicStateInitReceiver" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant InvalidDeterministicStateInitReceiver: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidDeterministicStateInitReceiver>(), obj)
                            }
                            "DeterministicStateInitKeyLengthExceeded" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant DeterministicStateInitKeyLengthExceeded: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitKeyLengthExceeded>(), obj)
                            }
                            "DeterministicStateInitValueLengthExceeded" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant DeterministicStateInitValueLengthExceeded: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitValueLengthExceeded>(), obj)
                            }
                            "DeleteActionMustBeFinal" -> return io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeleteActionMustBeFinal
                            "IntegerOverflow" -> return io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.IntegerOverflow
                            "FunctionCallZeroAttachedGas" -> return io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallZeroAttachedGas
                            "DelegateActionMustBeOnlyOne" -> return io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DelegateActionMustBeOnlyOne
                            else -> throw SerializationException("Unknown discriminator key for ActionsValidationError: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("TotalPrepaidGasExceeded")
                    for (cand in discriminatorCandidates) {
                        val candElem = jobj[cand]
                        if (candElem is JsonPrimitive) {
                            typeField = candElem.contentOrNull
                            if (typeField != null) break
                        }
                    }
                    if (typeField == null) {
                        val knownVariantNames = setOf("DeleteActionMustBeFinal", "TotalPrepaidGasExceeded", "TotalNumberOfActionsExceeded", "AddKeyMethodNamesNumberOfBytesExceeded", "AddKeyMethodNameLengthExceeded", "IntegerOverflow", "InvalidAccountId", "ContractSizeExceeded", "FunctionCallMethodNameLengthExceeded", "FunctionCallArgumentsLengthExceeded", "UnsuitableStakingKey", "FunctionCallZeroAttachedGas", "DelegateActionMustBeOnlyOne", "UnsupportedProtocolFeature", "InvalidDeterministicStateInitReceiver", "DeterministicStateInitKeyLengthExceeded", "DeterministicStateInitValueLengthExceeded")
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
                            "DeleteActionMustBeFinal" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeleteActionMustBeFinal>(), jobj)
                            "TotalPrepaidGasExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalPrepaidGasExceeded>(), jobj)
                            "TotalNumberOfActionsExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalNumberOfActionsExceeded>(), jobj)
                            "AddKeyMethodNamesNumberOfBytesExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNamesNumberOfBytesExceeded>(), jobj)
                            "AddKeyMethodNameLengthExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNameLengthExceeded>(), jobj)
                            "IntegerOverflow" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.IntegerOverflow>(), jobj)
                            "InvalidAccountId" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidAccountId>(), jobj)
                            "ContractSizeExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.ContractSizeExceeded>(), jobj)
                            "FunctionCallMethodNameLengthExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallMethodNameLengthExceeded>(), jobj)
                            "FunctionCallArgumentsLengthExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallArgumentsLengthExceeded>(), jobj)
                            "UnsuitableStakingKey" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsuitableStakingKey>(), jobj)
                            "FunctionCallZeroAttachedGas" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallZeroAttachedGas>(), jobj)
                            "DelegateActionMustBeOnlyOne" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DelegateActionMustBeOnlyOne>(), jobj)
                            "UnsupportedProtocolFeature" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsupportedProtocolFeature>(), jobj)
                            "InvalidDeterministicStateInitReceiver" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidDeterministicStateInitReceiver>(), jobj)
                            "DeterministicStateInitKeyLengthExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitKeyLengthExceeded>(), jobj)
                            "DeterministicStateInitValueLengthExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitValueLengthExceeded>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("DeleteActionMustBeFinal".lowercase() == tfLower || tfLower.contains("DeleteActionMustBeFinal".lowercase()) || "DeleteActionMustBeFinal".lowercase().contains(tfLower))) { chosenGroupKey = "DeleteActionMustBeFinal" }
                        if (chosenGroupKey == null && ("TotalPrepaidGasExceeded".lowercase() == tfLower || tfLower.contains("TotalPrepaidGasExceeded".lowercase()) || "TotalPrepaidGasExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "TotalPrepaidGasExceeded" }
                        if (chosenGroupKey == null && ("TotalNumberOfActionsExceeded".lowercase() == tfLower || tfLower.contains("TotalNumberOfActionsExceeded".lowercase()) || "TotalNumberOfActionsExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "TotalNumberOfActionsExceeded" }
                        if (chosenGroupKey == null && ("AddKeyMethodNamesNumberOfBytesExceeded".lowercase() == tfLower || tfLower.contains("AddKeyMethodNamesNumberOfBytesExceeded".lowercase()) || "AddKeyMethodNamesNumberOfBytesExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "AddKeyMethodNamesNumberOfBytesExceeded" }
                        if (chosenGroupKey == null && ("AddKeyMethodNameLengthExceeded".lowercase() == tfLower || tfLower.contains("AddKeyMethodNameLengthExceeded".lowercase()) || "AddKeyMethodNameLengthExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "AddKeyMethodNameLengthExceeded" }
                        if (chosenGroupKey == null && ("IntegerOverflow".lowercase() == tfLower || tfLower.contains("IntegerOverflow".lowercase()) || "IntegerOverflow".lowercase().contains(tfLower))) { chosenGroupKey = "IntegerOverflow" }
                        if (chosenGroupKey == null && ("InvalidAccountId".lowercase() == tfLower || tfLower.contains("InvalidAccountId".lowercase()) || "InvalidAccountId".lowercase().contains(tfLower))) { chosenGroupKey = "InvalidAccountId" }
                        if (chosenGroupKey == null && ("ContractSizeExceeded".lowercase() == tfLower || tfLower.contains("ContractSizeExceeded".lowercase()) || "ContractSizeExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "ContractSizeExceeded" }
                        if (chosenGroupKey == null && ("FunctionCallMethodNameLengthExceeded".lowercase() == tfLower || tfLower.contains("FunctionCallMethodNameLengthExceeded".lowercase()) || "FunctionCallMethodNameLengthExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "FunctionCallMethodNameLengthExceeded" }
                        if (chosenGroupKey == null && ("FunctionCallArgumentsLengthExceeded".lowercase() == tfLower || tfLower.contains("FunctionCallArgumentsLengthExceeded".lowercase()) || "FunctionCallArgumentsLengthExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "FunctionCallArgumentsLengthExceeded" }
                        if (chosenGroupKey == null && ("UnsuitableStakingKey".lowercase() == tfLower || tfLower.contains("UnsuitableStakingKey".lowercase()) || "UnsuitableStakingKey".lowercase().contains(tfLower))) { chosenGroupKey = "UnsuitableStakingKey" }
                        if (chosenGroupKey == null && ("FunctionCallZeroAttachedGas".lowercase() == tfLower || tfLower.contains("FunctionCallZeroAttachedGas".lowercase()) || "FunctionCallZeroAttachedGas".lowercase().contains(tfLower))) { chosenGroupKey = "FunctionCallZeroAttachedGas" }
                        if (chosenGroupKey == null && ("DelegateActionMustBeOnlyOne".lowercase() == tfLower || tfLower.contains("DelegateActionMustBeOnlyOne".lowercase()) || "DelegateActionMustBeOnlyOne".lowercase().contains(tfLower))) { chosenGroupKey = "DelegateActionMustBeOnlyOne" }
                        if (chosenGroupKey == null && ("UnsupportedProtocolFeature".lowercase() == tfLower || tfLower.contains("UnsupportedProtocolFeature".lowercase()) || "UnsupportedProtocolFeature".lowercase().contains(tfLower))) { chosenGroupKey = "UnsupportedProtocolFeature" }
                        if (chosenGroupKey == null && ("InvalidDeterministicStateInitReceiver".lowercase() == tfLower || tfLower.contains("InvalidDeterministicStateInitReceiver".lowercase()) || "InvalidDeterministicStateInitReceiver".lowercase().contains(tfLower))) { chosenGroupKey = "InvalidDeterministicStateInitReceiver" }
                        if (chosenGroupKey == null && ("DeterministicStateInitKeyLengthExceeded".lowercase() == tfLower || tfLower.contains("DeterministicStateInitKeyLengthExceeded".lowercase()) || "DeterministicStateInitKeyLengthExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "DeterministicStateInitKeyLengthExceeded" }
                        if (chosenGroupKey == null && ("DeterministicStateInitValueLengthExceeded".lowercase() == tfLower || tfLower.contains("DeterministicStateInitValueLengthExceeded".lowercase()) || "DeterministicStateInitValueLengthExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "DeterministicStateInitValueLengthExceeded" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "DeleteActionMustBeFinal" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeleteActionMustBeFinal>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DeleteActionMustBeFinal' and tf='$tf'")
                                }
                                "TotalPrepaidGasExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalPrepaidGasExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'TotalPrepaidGasExceeded' and tf='$tf'")
                                }
                                "TotalNumberOfActionsExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalNumberOfActionsExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'TotalNumberOfActionsExceeded' and tf='$tf'")
                                }
                                "AddKeyMethodNamesNumberOfBytesExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNamesNumberOfBytesExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'AddKeyMethodNamesNumberOfBytesExceeded' and tf='$tf'")
                                }
                                "AddKeyMethodNameLengthExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNameLengthExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'AddKeyMethodNameLengthExceeded' and tf='$tf'")
                                }
                                "IntegerOverflow" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.IntegerOverflow>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'IntegerOverflow' and tf='$tf'")
                                }
                                "InvalidAccountId" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidAccountId>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InvalidAccountId' and tf='$tf'")
                                }
                                "ContractSizeExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.ContractSizeExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'ContractSizeExceeded' and tf='$tf'")
                                }
                                "FunctionCallMethodNameLengthExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallMethodNameLengthExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'FunctionCallMethodNameLengthExceeded' and tf='$tf'")
                                }
                                "FunctionCallArgumentsLengthExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallArgumentsLengthExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'FunctionCallArgumentsLengthExceeded' and tf='$tf'")
                                }
                                "UnsuitableStakingKey" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsuitableStakingKey>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'UnsuitableStakingKey' and tf='$tf'")
                                }
                                "FunctionCallZeroAttachedGas" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallZeroAttachedGas>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'FunctionCallZeroAttachedGas' and tf='$tf'")
                                }
                                "DelegateActionMustBeOnlyOne" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DelegateActionMustBeOnlyOne>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DelegateActionMustBeOnlyOne' and tf='$tf'")
                                }
                                "UnsupportedProtocolFeature" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsupportedProtocolFeature>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'UnsupportedProtocolFeature' and tf='$tf'")
                                }
                                "InvalidDeterministicStateInitReceiver" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidDeterministicStateInitReceiver>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InvalidDeterministicStateInitReceiver' and tf='$tf'")
                                }
                                "DeterministicStateInitKeyLengthExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitKeyLengthExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DeterministicStateInitKeyLengthExceeded' and tf='$tf'")
                                }
                                "DeterministicStateInitValueLengthExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitValueLengthExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DeterministicStateInitValueLengthExceeded' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: DeleteActionMustBeFinal
                    // group: TotalPrepaidGasExceeded
                    // group: TotalNumberOfActionsExceeded
                    // group: AddKeyMethodNamesNumberOfBytesExceeded
                    // group: AddKeyMethodNameLengthExceeded
                    // group: IntegerOverflow
                    // group: InvalidAccountId
                    // group: ContractSizeExceeded
                    // group: FunctionCallMethodNameLengthExceeded
                    // group: FunctionCallArgumentsLengthExceeded
                    // group: UnsuitableStakingKey
                    // group: FunctionCallZeroAttachedGas
                    // group: DelegateActionMustBeOnlyOne
                    // group: UnsupportedProtocolFeature
                    // group: InvalidDeterministicStateInitReceiver
                    // group: DeterministicStateInitKeyLengthExceeded
                    // group: DeterministicStateInitValueLengthExceeded

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("TotalPrepaidGasExceeded")) requiredMatches.add(1)
                    if (jobj.containsKey("TotalNumberOfActionsExceeded")) requiredMatches.add(2)
                    if (jobj.containsKey("AddKeyMethodNamesNumberOfBytesExceeded")) requiredMatches.add(3)
                    if (jobj.containsKey("AddKeyMethodNameLengthExceeded")) requiredMatches.add(4)
                    if (jobj.containsKey("InvalidAccountId")) requiredMatches.add(6)
                    if (jobj.containsKey("ContractSizeExceeded")) requiredMatches.add(7)
                    if (jobj.containsKey("FunctionCallMethodNameLengthExceeded")) requiredMatches.add(8)
                    if (jobj.containsKey("FunctionCallArgumentsLengthExceeded")) requiredMatches.add(9)
                    if (jobj.containsKey("UnsuitableStakingKey")) requiredMatches.add(10)
                    if (jobj.containsKey("UnsupportedProtocolFeature")) requiredMatches.add(13)
                    if (jobj.containsKey("InvalidDeterministicStateInitReceiver")) requiredMatches.add(14)
                    if (jobj.containsKey("DeterministicStateInitKeyLengthExceeded")) requiredMatches.add(15)
                    if (jobj.containsKey("DeterministicStateInitValueLengthExceeded")) requiredMatches.add(16)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeleteActionMustBeFinal>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalPrepaidGasExceeded>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalNumberOfActionsExceeded>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNamesNumberOfBytesExceeded>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNameLengthExceeded>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.IntegerOverflow>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidAccountId>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.ContractSizeExceeded>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallMethodNameLengthExceeded>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallArgumentsLengthExceeded>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsuitableStakingKey>(), jobj)
                            11 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallZeroAttachedGas>(), jobj)
                            12 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DelegateActionMustBeOnlyOne>(), jobj)
                            13 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsupportedProtocolFeature>(), jobj)
                            14 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidDeterministicStateInitReceiver>(), jobj)
                            15 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitKeyLengthExceeded>(), jobj)
                            16 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitValueLengthExceeded>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 0 }
                    run {
                        var matchCount = 0
                        if (jobj["TotalPrepaidGasExceeded"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["TotalNumberOfActionsExceeded"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["AddKeyMethodNamesNumberOfBytesExceeded"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 3 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["AddKeyMethodNameLengthExceeded"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 4 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 5 }
                    run {
                        var matchCount = 0
                        if (jobj["InvalidAccountId"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 6 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["ContractSizeExceeded"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 7 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["FunctionCallMethodNameLengthExceeded"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 8 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["FunctionCallArgumentsLengthExceeded"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 9 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["UnsuitableStakingKey"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 10 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 11 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 12 }
                    run {
                        var matchCount = 0
                        if (jobj["UnsupportedProtocolFeature"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 13 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["InvalidDeterministicStateInitReceiver"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 14 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["DeterministicStateInitKeyLengthExceeded"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 15 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["DeterministicStateInitValueLengthExceeded"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 16 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeleteActionMustBeFinal>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalPrepaidGasExceeded>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalNumberOfActionsExceeded>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNamesNumberOfBytesExceeded>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNameLengthExceeded>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.IntegerOverflow>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidAccountId>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.ContractSizeExceeded>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallMethodNameLengthExceeded>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallArgumentsLengthExceeded>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsuitableStakingKey>(), jobj)
                            11 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallZeroAttachedGas>(), jobj)
                            12 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DelegateActionMustBeOnlyOne>(), jobj)
                            13 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsupportedProtocolFeature>(), jobj)
                            14 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidDeterministicStateInitReceiver>(), jobj)
                            15 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitKeyLengthExceeded>(), jobj)
                            16 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitValueLengthExceeded>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalPrepaidGasExceeded>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.TotalNumberOfActionsExceeded>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNamesNumberOfBytesExceeded>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.AddKeyMethodNameLengthExceeded>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidAccountId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.ContractSizeExceeded>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallMethodNameLengthExceeded>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.FunctionCallArgumentsLengthExceeded>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsuitableStakingKey>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.UnsupportedProtocolFeature>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.InvalidDeterministicStateInitReceiver>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitKeyLengthExceeded>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.DeterministicStateInitValueLengthExceeded>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in ActionsValidationError")
                }
            }
        }
        throw SerializationException("Cannot deserialize ActionsValidationError with non-JSON decoder")
    }
}
