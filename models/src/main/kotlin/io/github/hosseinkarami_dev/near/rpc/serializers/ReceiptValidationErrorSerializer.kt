package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError
import io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError
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

public object ReceiptValidationErrorSerializer : KSerializer<ReceiptValidationError> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError") {
        element("InvalidPredecessorId", serializer<JsonElement>().descriptor)
        element("InvalidReceiverId", serializer<JsonElement>().descriptor)
        element("InvalidSignerId", serializer<JsonElement>().descriptor)
        element("InvalidDataReceiverId", serializer<JsonElement>().descriptor)
        element("ReturnedValueLengthExceeded", serializer<JsonElement>().descriptor)
        element("NumberInputDataDependenciesExceeded", serializer<JsonElement>().descriptor)
        element("ActionsValidation", serializer<JsonElement>().descriptor)
        element("ReceiptSizeExceeded", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: ReceiptValidationError) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is ReceiptValidationError.InvalidPredecessorId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["InvalidPredecessorId"] = jsonEncoder.json.encodeToJsonElement(serializer<ReceiptValidationError.InvalidPredecessorId.InvalidPredecessorIdPayload>(), value.invalidPredecessorId)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ReceiptValidationError.InvalidReceiverId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["InvalidReceiverId"] = jsonEncoder.json.encodeToJsonElement(serializer<ReceiptValidationError.InvalidReceiverId.InvalidReceiverIdPayload>(), value.invalidReceiverId)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ReceiptValidationError.InvalidSignerId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["InvalidSignerId"] = jsonEncoder.json.encodeToJsonElement(serializer<ReceiptValidationError.InvalidSignerId.InvalidSignerIdPayload>(), value.invalidSignerId)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ReceiptValidationError.InvalidDataReceiverId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["InvalidDataReceiverId"] = jsonEncoder.json.encodeToJsonElement(serializer<ReceiptValidationError.InvalidDataReceiverId.InvalidDataReceiverIdPayload>(), value.invalidDataReceiverId)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ReceiptValidationError.ReturnedValueLengthExceeded -> {
          val map = mutableMapOf<String, JsonElement>()
          map["ReturnedValueLengthExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<ReceiptValidationError.ReturnedValueLengthExceeded.ReturnedValueLengthExceededPayload>(), value.returnedValueLengthExceeded)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ReceiptValidationError.NumberInputDataDependenciesExceeded -> {
          val map = mutableMapOf<String, JsonElement>()
          map["NumberInputDataDependenciesExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<ReceiptValidationError.NumberInputDataDependenciesExceeded.NumberInputDataDependenciesExceededPayload>(), value.numberInputDataDependenciesExceeded)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ReceiptValidationError.ActionsValidation -> {
          val map = mutableMapOf<String, JsonElement>()
          map["ActionsValidation"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionsValidationError>(), value.actionsValidation)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ReceiptValidationError.ReceiptSizeExceeded -> {
          val map = mutableMapOf<String, JsonElement>()
          map["ReceiptSizeExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<ReceiptValidationError.ReceiptSizeExceeded.ReceiptSizeExceededPayload>(), value.receiptSizeExceeded)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is ReceiptValidationError.InvalidPredecessorId -> out.encodeSerializableElement(descriptor, 0, serializer<ReceiptValidationError.InvalidPredecessorId>(), value)
      is ReceiptValidationError.InvalidReceiverId -> out.encodeSerializableElement(descriptor, 1, serializer<ReceiptValidationError.InvalidReceiverId>(), value)
      is ReceiptValidationError.InvalidSignerId -> out.encodeSerializableElement(descriptor, 2, serializer<ReceiptValidationError.InvalidSignerId>(), value)
      is ReceiptValidationError.InvalidDataReceiverId -> out.encodeSerializableElement(descriptor, 3, serializer<ReceiptValidationError.InvalidDataReceiverId>(), value)
      is ReceiptValidationError.ReturnedValueLengthExceeded -> out.encodeSerializableElement(descriptor, 4, serializer<ReceiptValidationError.ReturnedValueLengthExceeded>(), value)
      is ReceiptValidationError.NumberInputDataDependenciesExceeded -> out.encodeSerializableElement(descriptor, 5, serializer<ReceiptValidationError.NumberInputDataDependenciesExceeded>(), value)
      is ReceiptValidationError.ActionsValidation -> out.encodeSerializableElement(descriptor, 6, serializer<ReceiptValidationError.ActionsValidation>(), value)
      is ReceiptValidationError.ReceiptSizeExceeded -> out.encodeSerializableElement(descriptor, 7, serializer<ReceiptValidationError.ReceiptSizeExceeded>(), value)
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
            throw SerializationException("Unknown discriminator string for ReceiptValidationError: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing ReceiptValidationError")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["InvalidPredecessorId"] != null) {
            val invalidPredecessorIdVal = decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.InvalidPredecessorId.InvalidPredecessorIdPayload>(), jobj["InvalidPredecessorId"] ?: throw SerializationException("Missing field 'InvalidPredecessorId' for variant " + "InvalidPredecessorId"))
            return ReceiptValidationError.InvalidPredecessorId(invalidPredecessorIdVal)
          }
          if (jobj["InvalidReceiverId"] != null) {
            val invalidReceiverIdVal = decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.InvalidReceiverId.InvalidReceiverIdPayload>(), jobj["InvalidReceiverId"] ?: throw SerializationException("Missing field 'InvalidReceiverId' for variant " + "InvalidReceiverId"))
            return ReceiptValidationError.InvalidReceiverId(invalidReceiverIdVal)
          }
          if (jobj["InvalidSignerId"] != null) {
            val invalidSignerIdVal = decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.InvalidSignerId.InvalidSignerIdPayload>(), jobj["InvalidSignerId"] ?: throw SerializationException("Missing field 'InvalidSignerId' for variant " + "InvalidSignerId"))
            return ReceiptValidationError.InvalidSignerId(invalidSignerIdVal)
          }
          if (jobj["InvalidDataReceiverId"] != null) {
            val invalidDataReceiverIdVal = decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.InvalidDataReceiverId.InvalidDataReceiverIdPayload>(), jobj["InvalidDataReceiverId"] ?: throw SerializationException("Missing field 'InvalidDataReceiverId' for variant " + "InvalidDataReceiverId"))
            return ReceiptValidationError.InvalidDataReceiverId(invalidDataReceiverIdVal)
          }
          if (jobj["ReturnedValueLengthExceeded"] != null) {
            val returnedValueLengthExceededVal = decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.ReturnedValueLengthExceeded.ReturnedValueLengthExceededPayload>(), jobj["ReturnedValueLengthExceeded"] ?: throw SerializationException("Missing field 'ReturnedValueLengthExceeded' for variant " + "ReturnedValueLengthExceeded"))
            return ReceiptValidationError.ReturnedValueLengthExceeded(returnedValueLengthExceededVal)
          }
          if (jobj["NumberInputDataDependenciesExceeded"] != null) {
            val numberInputDataDependenciesExceededVal = decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.NumberInputDataDependenciesExceeded.NumberInputDataDependenciesExceededPayload>(), jobj["NumberInputDataDependenciesExceeded"] ?: throw SerializationException("Missing field 'NumberInputDataDependenciesExceeded' for variant " + "NumberInputDataDependenciesExceeded"))
            return ReceiptValidationError.NumberInputDataDependenciesExceeded(numberInputDataDependenciesExceededVal)
          }
          if (jobj["ActionsValidation"] != null) {
            val actionsValidationVal = decoder.json.decodeFromJsonElement(serializer<ActionsValidationError>(), jobj["ActionsValidation"] ?: throw SerializationException("Missing field 'ActionsValidation' for variant " + "ActionsValidation"))
            return ReceiptValidationError.ActionsValidation(actionsValidationVal)
          }
          if (jobj["ReceiptSizeExceeded"] != null) {
            val receiptSizeExceededVal = decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.ReceiptSizeExceeded.ReceiptSizeExceededPayload>(), jobj["ReceiptSizeExceeded"] ?: throw SerializationException("Missing field 'ReceiptSizeExceeded' for variant " + "ReceiptSizeExceeded"))
            return ReceiptValidationError.ReceiptSizeExceeded(receiptSizeExceededVal)
          }
          if (listOf("InvalidPredecessorId").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.InvalidPredecessorId>(), jobj)
          }
          if (listOf("InvalidReceiverId").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.InvalidReceiverId>(), jobj)
          }
          if (listOf("InvalidSignerId").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.InvalidSignerId>(), jobj)
          }
          if (listOf("InvalidDataReceiverId").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.InvalidDataReceiverId>(), jobj)
          }
          if (listOf("ReturnedValueLengthExceeded").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.ReturnedValueLengthExceeded>(), jobj)
          }
          if (listOf("NumberInputDataDependenciesExceeded").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.NumberInputDataDependenciesExceeded>(), jobj)
          }
          if (listOf("ActionsValidation").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.ActionsValidation>(), jobj)
          }
          if (listOf("ReceiptSizeExceeded").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.ReceiptSizeExceeded>(), jobj)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "InvalidPredecessorId" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val invalidPredecessorIdVal = decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.InvalidPredecessorId.InvalidPredecessorIdPayload>(), obj["InvalidPredecessorId"] ?: throw SerializationException("Missing field 'InvalidPredecessorId' for variant " + key))
                return ReceiptValidationError.InvalidPredecessorId(invalidPredecessorIdVal)
              }
              "InvalidReceiverId" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val invalidReceiverIdVal = decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.InvalidReceiverId.InvalidReceiverIdPayload>(), obj["InvalidReceiverId"] ?: throw SerializationException("Missing field 'InvalidReceiverId' for variant " + key))
                return ReceiptValidationError.InvalidReceiverId(invalidReceiverIdVal)
              }
              "InvalidSignerId" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val invalidSignerIdVal = decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.InvalidSignerId.InvalidSignerIdPayload>(), obj["InvalidSignerId"] ?: throw SerializationException("Missing field 'InvalidSignerId' for variant " + key))
                return ReceiptValidationError.InvalidSignerId(invalidSignerIdVal)
              }
              "InvalidDataReceiverId" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val invalidDataReceiverIdVal = decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.InvalidDataReceiverId.InvalidDataReceiverIdPayload>(), obj["InvalidDataReceiverId"] ?: throw SerializationException("Missing field 'InvalidDataReceiverId' for variant " + key))
                return ReceiptValidationError.InvalidDataReceiverId(invalidDataReceiverIdVal)
              }
              "ReturnedValueLengthExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val returnedValueLengthExceededVal = decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.ReturnedValueLengthExceeded.ReturnedValueLengthExceededPayload>(), obj["ReturnedValueLengthExceeded"] ?: throw SerializationException("Missing field 'ReturnedValueLengthExceeded' for variant " + key))
                return ReceiptValidationError.ReturnedValueLengthExceeded(returnedValueLengthExceededVal)
              }
              "NumberInputDataDependenciesExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val numberInputDataDependenciesExceededVal = decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.NumberInputDataDependenciesExceeded.NumberInputDataDependenciesExceededPayload>(), obj["NumberInputDataDependenciesExceeded"] ?: throw SerializationException("Missing field 'NumberInputDataDependenciesExceeded' for variant " + key))
                return ReceiptValidationError.NumberInputDataDependenciesExceeded(numberInputDataDependenciesExceededVal)
              }
              "ActionsValidation" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val actionsValidationVal = decoder.json.decodeFromJsonElement(serializer<ActionsValidationError>(), obj["ActionsValidation"] ?: throw SerializationException("Missing field 'ActionsValidation' for variant " + key))
                return ReceiptValidationError.ActionsValidation(actionsValidationVal)
              }
              "ReceiptSizeExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val receiptSizeExceededVal = decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.ReceiptSizeExceeded.ReceiptSizeExceededPayload>(), obj["ReceiptSizeExceeded"] ?: throw SerializationException("Missing field 'ReceiptSizeExceeded' for variant " + key))
                return ReceiptValidationError.ReceiptSizeExceeded(receiptSizeExceededVal)
              }
              else -> throw SerializationException("Unknown discriminator key for ReceiptValidationError: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("InvalidPredecessorId", "InvalidReceiverId", "InvalidSignerId", "InvalidDataReceiverId", "ReturnedValueLengthExceeded", "NumberInputDataDependenciesExceeded", "ActionsValidation", "ReceiptSizeExceeded")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in ReceiptValidationError")
            val tf = typeField.trim()
            when (tf) {
              "InvalidPredecessorId" -> {
                return decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.InvalidPredecessorId>(), jobj)
              }
              "InvalidReceiverId" -> {
                return decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.InvalidReceiverId>(), jobj)
              }
              "InvalidSignerId" -> {
                return decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.InvalidSignerId>(), jobj)
              }
              "InvalidDataReceiverId" -> {
                return decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.InvalidDataReceiverId>(), jobj)
              }
              "ReturnedValueLengthExceeded" -> {
                return decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.ReturnedValueLengthExceeded>(), jobj)
              }
              "NumberInputDataDependenciesExceeded" -> {
                return decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.NumberInputDataDependenciesExceeded>(), jobj)
              }
              "ActionsValidation" -> {
                return decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.ActionsValidation>(), jobj)
              }
              "ReceiptSizeExceeded" -> {
                return decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError.ReceiptSizeExceeded>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for ReceiptValidationError: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize ReceiptValidationError with non-JSON decoder")
  }
}
