package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError
import kotlin.collections.mutableMapOf
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
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
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.serializer

public object ActionsValidationErrorSerializer : KSerializer<ActionsValidationError> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError") {
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

  override fun serialize(encoder: Encoder, `value`: ActionsValidationError) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is ActionsValidationError.DeleteActionMustBeFinal -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("DeleteActionMustBeFinal"))
        }
        is ActionsValidationError.TotalPrepaidGasExceeded -> {
          val map = mutableMapOf<String, JsonElement>()
          map["TotalPrepaidGasExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionsValidationError.TotalPrepaidGasExceeded.TotalPrepaidGasExceededPayload>(), value.totalPrepaidGasExceeded)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionsValidationError.TotalNumberOfActionsExceeded -> {
          val map = mutableMapOf<String, JsonElement>()
          map["TotalNumberOfActionsExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionsValidationError.TotalNumberOfActionsExceeded.TotalNumberOfActionsExceededPayload>(), value.totalNumberOfActionsExceeded)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionsValidationError.AddKeyMethodNamesNumberOfBytesExceeded -> {
          val map = mutableMapOf<String, JsonElement>()
          map["AddKeyMethodNamesNumberOfBytesExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionsValidationError.AddKeyMethodNamesNumberOfBytesExceeded.AddKeyMethodNamesNumberOfBytesExceededPayload>(), value.addKeyMethodNamesNumberOfBytesExceeded)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionsValidationError.AddKeyMethodNameLengthExceeded -> {
          val map = mutableMapOf<String, JsonElement>()
          map["AddKeyMethodNameLengthExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionsValidationError.AddKeyMethodNameLengthExceeded.AddKeyMethodNameLengthExceededPayload>(), value.addKeyMethodNameLengthExceeded)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionsValidationError.IntegerOverflow -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("IntegerOverflow"))
        }
        is ActionsValidationError.InvalidAccountId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["InvalidAccountId"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionsValidationError.InvalidAccountId.InvalidAccountIdPayload>(), value.invalidAccountId)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionsValidationError.ContractSizeExceeded -> {
          val map = mutableMapOf<String, JsonElement>()
          map["ContractSizeExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionsValidationError.ContractSizeExceeded.ContractSizeExceededPayload>(), value.contractSizeExceeded)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionsValidationError.FunctionCallMethodNameLengthExceeded -> {
          val map = mutableMapOf<String, JsonElement>()
          map["FunctionCallMethodNameLengthExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionsValidationError.FunctionCallMethodNameLengthExceeded.FunctionCallMethodNameLengthExceededPayload>(), value.functionCallMethodNameLengthExceeded)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionsValidationError.FunctionCallArgumentsLengthExceeded -> {
          val map = mutableMapOf<String, JsonElement>()
          map["FunctionCallArgumentsLengthExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionsValidationError.FunctionCallArgumentsLengthExceeded.FunctionCallArgumentsLengthExceededPayload>(), value.functionCallArgumentsLengthExceeded)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionsValidationError.UnsuitableStakingKey -> {
          val map = mutableMapOf<String, JsonElement>()
          map["UnsuitableStakingKey"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionsValidationError.UnsuitableStakingKey.UnsuitableStakingKeyPayload>(), value.unsuitableStakingKey)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionsValidationError.FunctionCallZeroAttachedGas -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("FunctionCallZeroAttachedGas"))
        }
        is ActionsValidationError.DelegateActionMustBeOnlyOne -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("DelegateActionMustBeOnlyOne"))
        }
        is ActionsValidationError.UnsupportedProtocolFeature -> {
          val map = mutableMapOf<String, JsonElement>()
          map["UnsupportedProtocolFeature"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionsValidationError.UnsupportedProtocolFeature.UnsupportedProtocolFeaturePayload>(), value.unsupportedProtocolFeature)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionsValidationError.InvalidDeterministicStateInitReceiver -> {
          val map = mutableMapOf<String, JsonElement>()
          map["InvalidDeterministicStateInitReceiver"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionsValidationError.InvalidDeterministicStateInitReceiver.InvalidDeterministicStateInitReceiverPayload>(), value.invalidDeterministicStateInitReceiver)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionsValidationError.DeterministicStateInitKeyLengthExceeded -> {
          val map = mutableMapOf<String, JsonElement>()
          map["DeterministicStateInitKeyLengthExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionsValidationError.DeterministicStateInitKeyLengthExceeded.DeterministicStateInitKeyLengthExceededPayload>(), value.deterministicStateInitKeyLengthExceeded)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionsValidationError.DeterministicStateInitValueLengthExceeded -> {
          val map = mutableMapOf<String, JsonElement>()
          map["DeterministicStateInitValueLengthExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionsValidationError.DeterministicStateInitValueLengthExceeded.DeterministicStateInitValueLengthExceededPayload>(), value.deterministicStateInitValueLengthExceeded)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is ActionsValidationError.DeleteActionMustBeFinal -> out.encodeSerializableElement(descriptor, 0, serializer<ActionsValidationError.DeleteActionMustBeFinal>(), value)
      is ActionsValidationError.TotalPrepaidGasExceeded -> out.encodeSerializableElement(descriptor, 1, serializer<ActionsValidationError.TotalPrepaidGasExceeded>(), value)
      is ActionsValidationError.TotalNumberOfActionsExceeded -> out.encodeSerializableElement(descriptor, 2, serializer<ActionsValidationError.TotalNumberOfActionsExceeded>(), value)
      is ActionsValidationError.AddKeyMethodNamesNumberOfBytesExceeded -> out.encodeSerializableElement(descriptor, 3, serializer<ActionsValidationError.AddKeyMethodNamesNumberOfBytesExceeded>(), value)
      is ActionsValidationError.AddKeyMethodNameLengthExceeded -> out.encodeSerializableElement(descriptor, 4, serializer<ActionsValidationError.AddKeyMethodNameLengthExceeded>(), value)
      is ActionsValidationError.IntegerOverflow -> out.encodeSerializableElement(descriptor, 5, serializer<ActionsValidationError.IntegerOverflow>(), value)
      is ActionsValidationError.InvalidAccountId -> out.encodeSerializableElement(descriptor, 6, serializer<ActionsValidationError.InvalidAccountId>(), value)
      is ActionsValidationError.ContractSizeExceeded -> out.encodeSerializableElement(descriptor, 7, serializer<ActionsValidationError.ContractSizeExceeded>(), value)
      is ActionsValidationError.FunctionCallMethodNameLengthExceeded -> out.encodeSerializableElement(descriptor, 8, serializer<ActionsValidationError.FunctionCallMethodNameLengthExceeded>(), value)
      is ActionsValidationError.FunctionCallArgumentsLengthExceeded -> out.encodeSerializableElement(descriptor, 9, serializer<ActionsValidationError.FunctionCallArgumentsLengthExceeded>(), value)
      is ActionsValidationError.UnsuitableStakingKey -> out.encodeSerializableElement(descriptor, 10, serializer<ActionsValidationError.UnsuitableStakingKey>(), value)
      is ActionsValidationError.FunctionCallZeroAttachedGas -> out.encodeSerializableElement(descriptor, 11, serializer<ActionsValidationError.FunctionCallZeroAttachedGas>(), value)
      is ActionsValidationError.DelegateActionMustBeOnlyOne -> out.encodeSerializableElement(descriptor, 12, serializer<ActionsValidationError.DelegateActionMustBeOnlyOne>(), value)
      is ActionsValidationError.UnsupportedProtocolFeature -> out.encodeSerializableElement(descriptor, 13, serializer<ActionsValidationError.UnsupportedProtocolFeature>(), value)
      is ActionsValidationError.InvalidDeterministicStateInitReceiver -> out.encodeSerializableElement(descriptor, 14, serializer<ActionsValidationError.InvalidDeterministicStateInitReceiver>(), value)
      is ActionsValidationError.DeterministicStateInitKeyLengthExceeded -> out.encodeSerializableElement(descriptor, 15, serializer<ActionsValidationError.DeterministicStateInitKeyLengthExceeded>(), value)
      is ActionsValidationError.DeterministicStateInitValueLengthExceeded -> out.encodeSerializableElement(descriptor, 16, serializer<ActionsValidationError.DeterministicStateInitValueLengthExceeded>(), value)
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
            if (s == "DeleteActionMustBeFinal") return ActionsValidationError.DeleteActionMustBeFinal()
            if (s == "IntegerOverflow") return ActionsValidationError.IntegerOverflow()
            if (s == "FunctionCallZeroAttachedGas") return ActionsValidationError.FunctionCallZeroAttachedGas()
            if (s == "DelegateActionMustBeOnlyOne") return ActionsValidationError.DelegateActionMustBeOnlyOne()
          }
          throw SerializationException("Unknown discriminator (primitive) for ActionsValidationError")
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing ActionsValidationError")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj["TotalPrepaidGasExceeded"] != null) {
            return ActionsValidationError.TotalPrepaidGasExceeded(decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.TotalPrepaidGasExceeded.TotalPrepaidGasExceededPayload>(), jobj["TotalPrepaidGasExceeded"]!!))
          }
          if (jobj["TotalNumberOfActionsExceeded"] != null) {
            return ActionsValidationError.TotalNumberOfActionsExceeded(decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.TotalNumberOfActionsExceeded.TotalNumberOfActionsExceededPayload>(), jobj["TotalNumberOfActionsExceeded"]!!))
          }
          if (jobj["AddKeyMethodNamesNumberOfBytesExceeded"] != null) {
            return ActionsValidationError.AddKeyMethodNamesNumberOfBytesExceeded(decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.AddKeyMethodNamesNumberOfBytesExceeded.AddKeyMethodNamesNumberOfBytesExceededPayload>(), jobj["AddKeyMethodNamesNumberOfBytesExceeded"]!!))
          }
          if (jobj["AddKeyMethodNameLengthExceeded"] != null) {
            return ActionsValidationError.AddKeyMethodNameLengthExceeded(decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.AddKeyMethodNameLengthExceeded.AddKeyMethodNameLengthExceededPayload>(), jobj["AddKeyMethodNameLengthExceeded"]!!))
          }
          if (jobj["InvalidAccountId"] != null) {
            return ActionsValidationError.InvalidAccountId(decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.InvalidAccountId.InvalidAccountIdPayload>(), jobj["InvalidAccountId"]!!))
          }
          if (jobj["ContractSizeExceeded"] != null) {
            return ActionsValidationError.ContractSizeExceeded(decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.ContractSizeExceeded.ContractSizeExceededPayload>(), jobj["ContractSizeExceeded"]!!))
          }
          if (jobj["FunctionCallMethodNameLengthExceeded"] != null) {
            return ActionsValidationError.FunctionCallMethodNameLengthExceeded(decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.FunctionCallMethodNameLengthExceeded.FunctionCallMethodNameLengthExceededPayload>(), jobj["FunctionCallMethodNameLengthExceeded"]!!))
          }
          if (jobj["FunctionCallArgumentsLengthExceeded"] != null) {
            return ActionsValidationError.FunctionCallArgumentsLengthExceeded(decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.FunctionCallArgumentsLengthExceeded.FunctionCallArgumentsLengthExceededPayload>(), jobj["FunctionCallArgumentsLengthExceeded"]!!))
          }
          if (jobj["UnsuitableStakingKey"] != null) {
            return ActionsValidationError.UnsuitableStakingKey(decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.UnsuitableStakingKey.UnsuitableStakingKeyPayload>(), jobj["UnsuitableStakingKey"]!!))
          }
          if (jobj["UnsupportedProtocolFeature"] != null) {
            return ActionsValidationError.UnsupportedProtocolFeature(decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.UnsupportedProtocolFeature.UnsupportedProtocolFeaturePayload>(), jobj["UnsupportedProtocolFeature"]!!))
          }
          if (jobj["InvalidDeterministicStateInitReceiver"] != null) {
            return ActionsValidationError.InvalidDeterministicStateInitReceiver(decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.InvalidDeterministicStateInitReceiver.InvalidDeterministicStateInitReceiverPayload>(), jobj["InvalidDeterministicStateInitReceiver"]!!))
          }
          if (jobj["DeterministicStateInitKeyLengthExceeded"] != null) {
            return ActionsValidationError.DeterministicStateInitKeyLengthExceeded(decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.DeterministicStateInitKeyLengthExceeded.DeterministicStateInitKeyLengthExceededPayload>(), jobj["DeterministicStateInitKeyLengthExceeded"]!!))
          }
          if (jobj["DeterministicStateInitValueLengthExceeded"] != null) {
            return ActionsValidationError.DeterministicStateInitValueLengthExceeded(decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.DeterministicStateInitValueLengthExceeded.DeterministicStateInitValueLengthExceededPayload>(), jobj["DeterministicStateInitValueLengthExceeded"]!!))
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "TotalPrepaidGasExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.TotalPrepaidGasExceeded>(), obj)
              }
              "TotalNumberOfActionsExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.TotalNumberOfActionsExceeded>(), obj)
              }
              "AddKeyMethodNamesNumberOfBytesExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.AddKeyMethodNamesNumberOfBytesExceeded>(), obj)
              }
              "AddKeyMethodNameLengthExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.AddKeyMethodNameLengthExceeded>(), obj)
              }
              "InvalidAccountId" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.InvalidAccountId>(), obj)
              }
              "ContractSizeExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.ContractSizeExceeded>(), obj)
              }
              "FunctionCallMethodNameLengthExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.FunctionCallMethodNameLengthExceeded>(), obj)
              }
              "FunctionCallArgumentsLengthExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.FunctionCallArgumentsLengthExceeded>(), obj)
              }
              "UnsuitableStakingKey" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.UnsuitableStakingKey>(), obj)
              }
              "UnsupportedProtocolFeature" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.UnsupportedProtocolFeature>(), obj)
              }
              "InvalidDeterministicStateInitReceiver" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.InvalidDeterministicStateInitReceiver>(), obj)
              }
              "DeterministicStateInitKeyLengthExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.DeterministicStateInitKeyLengthExceeded>(), obj)
              }
              "DeterministicStateInitValueLengthExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.DeterministicStateInitValueLengthExceeded>(), obj)
              }
              "DeleteActionMustBeFinal" -> {
                return ActionsValidationError.DeleteActionMustBeFinal()
              }
              "IntegerOverflow" -> {
                return ActionsValidationError.IntegerOverflow()
              }
              "FunctionCallZeroAttachedGas" -> {
                return ActionsValidationError.FunctionCallZeroAttachedGas()
              }
              "DelegateActionMustBeOnlyOne" -> {
                return ActionsValidationError.DelegateActionMustBeOnlyOne()
              }
              else -> throw SerializationException("Unknown discriminator key for ActionsValidationError: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("DeleteActionMustBeFinal", "TotalPrepaidGasExceeded", "TotalNumberOfActionsExceeded", "AddKeyMethodNamesNumberOfBytesExceeded", "AddKeyMethodNameLengthExceeded", "IntegerOverflow", "InvalidAccountId", "ContractSizeExceeded", "FunctionCallMethodNameLengthExceeded", "FunctionCallArgumentsLengthExceeded", "UnsuitableStakingKey", "FunctionCallZeroAttachedGas", "DelegateActionMustBeOnlyOne", "UnsupportedProtocolFeature", "InvalidDeterministicStateInitReceiver", "DeterministicStateInitKeyLengthExceeded", "DeterministicStateInitValueLengthExceeded")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in ActionsValidationError")
            val tf = typeField.trim()
            when (tf) {
              "TotalPrepaidGasExceeded" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.TotalPrepaidGasExceeded>(), jobj)
              }
              "TotalNumberOfActionsExceeded" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.TotalNumberOfActionsExceeded>(), jobj)
              }
              "AddKeyMethodNamesNumberOfBytesExceeded" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.AddKeyMethodNamesNumberOfBytesExceeded>(), jobj)
              }
              "AddKeyMethodNameLengthExceeded" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.AddKeyMethodNameLengthExceeded>(), jobj)
              }
              "InvalidAccountId" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.InvalidAccountId>(), jobj)
              }
              "ContractSizeExceeded" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.ContractSizeExceeded>(), jobj)
              }
              "FunctionCallMethodNameLengthExceeded" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.FunctionCallMethodNameLengthExceeded>(), jobj)
              }
              "FunctionCallArgumentsLengthExceeded" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.FunctionCallArgumentsLengthExceeded>(), jobj)
              }
              "UnsuitableStakingKey" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.UnsuitableStakingKey>(), jobj)
              }
              "UnsupportedProtocolFeature" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.UnsupportedProtocolFeature>(), jobj)
              }
              "InvalidDeterministicStateInitReceiver" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.InvalidDeterministicStateInitReceiver>(), jobj)
              }
              "DeterministicStateInitKeyLengthExceeded" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.DeterministicStateInitKeyLengthExceeded>(), jobj)
              }
              "DeterministicStateInitValueLengthExceeded" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionsValidationError.DeterministicStateInitValueLengthExceeded>(), jobj)
              }
              "DeleteActionMustBeFinal" -> return ActionsValidationError.DeleteActionMustBeFinal()
              "IntegerOverflow" -> return ActionsValidationError.IntegerOverflow()
              "FunctionCallZeroAttachedGas" -> return ActionsValidationError.FunctionCallZeroAttachedGas()
              "DelegateActionMustBeOnlyOne" -> return ActionsValidationError.DelegateActionMustBeOnlyOne()
              else -> throw SerializationException("Unknown type discriminator for ActionsValidationError: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize ActionsValidationError with non-JSON decoder")
  }
}
