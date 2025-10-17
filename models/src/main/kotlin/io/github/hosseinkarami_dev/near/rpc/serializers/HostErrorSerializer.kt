package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.HostError
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

public object HostErrorSerializer : KSerializer<HostError> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.HostError") {
        element("BadUTF16", serializer<JsonElement>().descriptor)
        element("BadUTF8", serializer<JsonElement>().descriptor)
        element("GasExceeded", serializer<JsonElement>().descriptor)
        element("GasLimitExceeded", serializer<JsonElement>().descriptor)
        element("BalanceExceeded", serializer<JsonElement>().descriptor)
        element("EmptyMethodName", serializer<JsonElement>().descriptor)
        element("GuestPanic", serializer<JsonElement>().descriptor)
        element("IntegerOverflow", serializer<JsonElement>().descriptor)
        element("InvalidPromiseIndex", serializer<JsonElement>().descriptor)
        element("CannotAppendActionToJointPromise", serializer<JsonElement>().descriptor)
        element("CannotReturnJointPromise", serializer<JsonElement>().descriptor)
        element("InvalidPromiseResultIndex", serializer<JsonElement>().descriptor)
        element("InvalidRegisterId", serializer<JsonElement>().descriptor)
        element("IteratorWasInvalidated", serializer<JsonElement>().descriptor)
        element("MemoryAccessViolation", serializer<JsonElement>().descriptor)
        element("InvalidReceiptIndex", serializer<JsonElement>().descriptor)
        element("InvalidIteratorIndex", serializer<JsonElement>().descriptor)
        element("InvalidAccountId", serializer<JsonElement>().descriptor)
        element("InvalidMethodName", serializer<JsonElement>().descriptor)
        element("InvalidPublicKey", serializer<JsonElement>().descriptor)
        element("ProhibitedInView", serializer<JsonElement>().descriptor)
        element("NumberOfLogsExceeded", serializer<JsonElement>().descriptor)
        element("KeyLengthExceeded", serializer<JsonElement>().descriptor)
        element("ValueLengthExceeded", serializer<JsonElement>().descriptor)
        element("TotalLogLengthExceeded", serializer<JsonElement>().descriptor)
        element("NumberPromisesExceeded", serializer<JsonElement>().descriptor)
        element("NumberInputDataDependenciesExceeded", serializer<JsonElement>().descriptor)
        element("ReturnedValueLengthExceeded", serializer<JsonElement>().descriptor)
        element("ContractSizeExceeded", serializer<JsonElement>().descriptor)
        element("Deprecated", serializer<JsonElement>().descriptor)
        element("ECRecoverError", serializer<JsonElement>().descriptor)
        element("AltBn128InvalidInput", serializer<JsonElement>().descriptor)
        element("Ed25519VerifyInvalidInput", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: HostError) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is HostError.BadUTF16 -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("BadUTF16"))
        }
        is HostError.BadUTF8 -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("BadUTF8"))
        }
        is HostError.GasExceeded -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("GasExceeded"))
        }
        is HostError.GasLimitExceeded -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("GasLimitExceeded"))
        }
        is HostError.BalanceExceeded -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("BalanceExceeded"))
        }
        is HostError.EmptyMethodName -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("EmptyMethodName"))
        }
        is HostError.GuestPanic -> {
          val map = mutableMapOf<String, JsonElement>()
          map["GuestPanic"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError.GuestPanic.GuestPanicPayload>(), value.guestPanic)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is HostError.IntegerOverflow -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("IntegerOverflow"))
        }
        is HostError.InvalidPromiseIndex -> {
          val map = mutableMapOf<String, JsonElement>()
          map["InvalidPromiseIndex"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError.InvalidPromiseIndex.InvalidPromiseIndexPayload>(), value.invalidPromiseIndex)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is HostError.CannotAppendActionToJointPromise -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("CannotAppendActionToJointPromise"))
        }
        is HostError.CannotReturnJointPromise -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("CannotReturnJointPromise"))
        }
        is HostError.InvalidPromiseResultIndex -> {
          val map = mutableMapOf<String, JsonElement>()
          map["InvalidPromiseResultIndex"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError.InvalidPromiseResultIndex.InvalidPromiseResultIndexPayload>(), value.invalidPromiseResultIndex)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is HostError.InvalidRegisterId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["InvalidRegisterId"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError.InvalidRegisterId.InvalidRegisterIdPayload>(), value.invalidRegisterId)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is HostError.IteratorWasInvalidated -> {
          val map = mutableMapOf<String, JsonElement>()
          map["IteratorWasInvalidated"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError.IteratorWasInvalidated.IteratorWasInvalidatedPayload>(), value.iteratorWasInvalidated)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is HostError.MemoryAccessViolation -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("MemoryAccessViolation"))
        }
        is HostError.InvalidReceiptIndex -> {
          val map = mutableMapOf<String, JsonElement>()
          map["InvalidReceiptIndex"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError.InvalidReceiptIndex.InvalidReceiptIndexPayload>(), value.invalidReceiptIndex)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is HostError.InvalidIteratorIndex -> {
          val map = mutableMapOf<String, JsonElement>()
          map["InvalidIteratorIndex"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError.InvalidIteratorIndex.InvalidIteratorIndexPayload>(), value.invalidIteratorIndex)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is HostError.InvalidAccountId -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("InvalidAccountId"))
        }
        is HostError.InvalidMethodName -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("InvalidMethodName"))
        }
        is HostError.InvalidPublicKey -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("InvalidPublicKey"))
        }
        is HostError.ProhibitedInView -> {
          val map = mutableMapOf<String, JsonElement>()
          map["ProhibitedInView"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError.ProhibitedInView.ProhibitedInViewPayload>(), value.prohibitedInView)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is HostError.NumberOfLogsExceeded -> {
          val map = mutableMapOf<String, JsonElement>()
          map["NumberOfLogsExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError.NumberOfLogsExceeded.NumberOfLogsExceededPayload>(), value.numberOfLogsExceeded)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is HostError.KeyLengthExceeded -> {
          val map = mutableMapOf<String, JsonElement>()
          map["KeyLengthExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError.KeyLengthExceeded.KeyLengthExceededPayload>(), value.keyLengthExceeded)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is HostError.ValueLengthExceeded -> {
          val map = mutableMapOf<String, JsonElement>()
          map["ValueLengthExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError.ValueLengthExceeded.ValueLengthExceededPayload>(), value.valueLengthExceeded)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is HostError.TotalLogLengthExceeded -> {
          val map = mutableMapOf<String, JsonElement>()
          map["TotalLogLengthExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError.TotalLogLengthExceeded.TotalLogLengthExceededPayload>(), value.totalLogLengthExceeded)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is HostError.NumberPromisesExceeded -> {
          val map = mutableMapOf<String, JsonElement>()
          map["NumberPromisesExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError.NumberPromisesExceeded.NumberPromisesExceededPayload>(), value.numberPromisesExceeded)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is HostError.NumberInputDataDependenciesExceeded -> {
          val map = mutableMapOf<String, JsonElement>()
          map["NumberInputDataDependenciesExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError.NumberInputDataDependenciesExceeded.NumberInputDataDependenciesExceededPayload>(), value.numberInputDataDependenciesExceeded)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is HostError.ReturnedValueLengthExceeded -> {
          val map = mutableMapOf<String, JsonElement>()
          map["ReturnedValueLengthExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError.ReturnedValueLengthExceeded.ReturnedValueLengthExceededPayload>(), value.returnedValueLengthExceeded)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is HostError.ContractSizeExceeded -> {
          val map = mutableMapOf<String, JsonElement>()
          map["ContractSizeExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError.ContractSizeExceeded.ContractSizeExceededPayload>(), value.contractSizeExceeded)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is HostError.Deprecated -> {
          val map = mutableMapOf<String, JsonElement>()
          map["Deprecated"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError.Deprecated.DeprecatedPayload>(), value.deprecated)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is HostError.ECRecoverError -> {
          val map = mutableMapOf<String, JsonElement>()
          map["ECRecoverError"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError.ECRecoverError.ECRecoverErrorPayload>(), value.eCRecoverError)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is HostError.AltBn128InvalidInput -> {
          val map = mutableMapOf<String, JsonElement>()
          map["AltBn128InvalidInput"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError.AltBn128InvalidInput.AltBn128InvalidInputPayload>(), value.altBn128InvalidInput)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is HostError.Ed25519VerifyInvalidInput -> {
          val map = mutableMapOf<String, JsonElement>()
          map["Ed25519VerifyInvalidInput"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError.Ed25519VerifyInvalidInput.Ed25519VerifyInvalidInputPayload>(), value.ed25519VerifyInvalidInput)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is HostError.BadUTF16 -> out.encodeSerializableElement(descriptor, 0, serializer<HostError.BadUTF16>(), value)
      is HostError.BadUTF8 -> out.encodeSerializableElement(descriptor, 1, serializer<HostError.BadUTF8>(), value)
      is HostError.GasExceeded -> out.encodeSerializableElement(descriptor, 2, serializer<HostError.GasExceeded>(), value)
      is HostError.GasLimitExceeded -> out.encodeSerializableElement(descriptor, 3, serializer<HostError.GasLimitExceeded>(), value)
      is HostError.BalanceExceeded -> out.encodeSerializableElement(descriptor, 4, serializer<HostError.BalanceExceeded>(), value)
      is HostError.EmptyMethodName -> out.encodeSerializableElement(descriptor, 5, serializer<HostError.EmptyMethodName>(), value)
      is HostError.GuestPanic -> out.encodeSerializableElement(descriptor, 6, serializer<HostError.GuestPanic>(), value)
      is HostError.IntegerOverflow -> out.encodeSerializableElement(descriptor, 7, serializer<HostError.IntegerOverflow>(), value)
      is HostError.InvalidPromiseIndex -> out.encodeSerializableElement(descriptor, 8, serializer<HostError.InvalidPromiseIndex>(), value)
      is HostError.CannotAppendActionToJointPromise -> out.encodeSerializableElement(descriptor, 9, serializer<HostError.CannotAppendActionToJointPromise>(), value)
      is HostError.CannotReturnJointPromise -> out.encodeSerializableElement(descriptor, 10, serializer<HostError.CannotReturnJointPromise>(), value)
      is HostError.InvalidPromiseResultIndex -> out.encodeSerializableElement(descriptor, 11, serializer<HostError.InvalidPromiseResultIndex>(), value)
      is HostError.InvalidRegisterId -> out.encodeSerializableElement(descriptor, 12, serializer<HostError.InvalidRegisterId>(), value)
      is HostError.IteratorWasInvalidated -> out.encodeSerializableElement(descriptor, 13, serializer<HostError.IteratorWasInvalidated>(), value)
      is HostError.MemoryAccessViolation -> out.encodeSerializableElement(descriptor, 14, serializer<HostError.MemoryAccessViolation>(), value)
      is HostError.InvalidReceiptIndex -> out.encodeSerializableElement(descriptor, 15, serializer<HostError.InvalidReceiptIndex>(), value)
      is HostError.InvalidIteratorIndex -> out.encodeSerializableElement(descriptor, 16, serializer<HostError.InvalidIteratorIndex>(), value)
      is HostError.InvalidAccountId -> out.encodeSerializableElement(descriptor, 17, serializer<HostError.InvalidAccountId>(), value)
      is HostError.InvalidMethodName -> out.encodeSerializableElement(descriptor, 18, serializer<HostError.InvalidMethodName>(), value)
      is HostError.InvalidPublicKey -> out.encodeSerializableElement(descriptor, 19, serializer<HostError.InvalidPublicKey>(), value)
      is HostError.ProhibitedInView -> out.encodeSerializableElement(descriptor, 20, serializer<HostError.ProhibitedInView>(), value)
      is HostError.NumberOfLogsExceeded -> out.encodeSerializableElement(descriptor, 21, serializer<HostError.NumberOfLogsExceeded>(), value)
      is HostError.KeyLengthExceeded -> out.encodeSerializableElement(descriptor, 22, serializer<HostError.KeyLengthExceeded>(), value)
      is HostError.ValueLengthExceeded -> out.encodeSerializableElement(descriptor, 23, serializer<HostError.ValueLengthExceeded>(), value)
      is HostError.TotalLogLengthExceeded -> out.encodeSerializableElement(descriptor, 24, serializer<HostError.TotalLogLengthExceeded>(), value)
      is HostError.NumberPromisesExceeded -> out.encodeSerializableElement(descriptor, 25, serializer<HostError.NumberPromisesExceeded>(), value)
      is HostError.NumberInputDataDependenciesExceeded -> out.encodeSerializableElement(descriptor, 26, serializer<HostError.NumberInputDataDependenciesExceeded>(), value)
      is HostError.ReturnedValueLengthExceeded -> out.encodeSerializableElement(descriptor, 27, serializer<HostError.ReturnedValueLengthExceeded>(), value)
      is HostError.ContractSizeExceeded -> out.encodeSerializableElement(descriptor, 28, serializer<HostError.ContractSizeExceeded>(), value)
      is HostError.Deprecated -> out.encodeSerializableElement(descriptor, 29, serializer<HostError.Deprecated>(), value)
      is HostError.ECRecoverError -> out.encodeSerializableElement(descriptor, 30, serializer<HostError.ECRecoverError>(), value)
      is HostError.AltBn128InvalidInput -> out.encodeSerializableElement(descriptor, 31, serializer<HostError.AltBn128InvalidInput>(), value)
      is HostError.Ed25519VerifyInvalidInput -> out.encodeSerializableElement(descriptor, 32, serializer<HostError.Ed25519VerifyInvalidInput>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): HostError {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            if (s == "BadUTF16") return HostError.BadUTF16
            if (s == "BadUTF8") return HostError.BadUTF8
            if (s == "GasExceeded") return HostError.GasExceeded
            if (s == "GasLimitExceeded") return HostError.GasLimitExceeded
            if (s == "BalanceExceeded") return HostError.BalanceExceeded
            if (s == "EmptyMethodName") return HostError.EmptyMethodName
            if (s == "IntegerOverflow") return HostError.IntegerOverflow
            if (s == "CannotAppendActionToJointPromise") return HostError.CannotAppendActionToJointPromise
            if (s == "CannotReturnJointPromise") return HostError.CannotReturnJointPromise
            if (s == "MemoryAccessViolation") return HostError.MemoryAccessViolation
            if (s == "InvalidAccountId") return HostError.InvalidAccountId
            if (s == "InvalidMethodName") return HostError.InvalidMethodName
            if (s == "InvalidPublicKey") return HostError.InvalidPublicKey
          }
          throw SerializationException("Unknown discriminator (primitive) for HostError")
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing HostError")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj["GuestPanic"] != null) {
            return HostError.GuestPanic(decoder.json.decodeFromJsonElement(serializer<HostError.GuestPanic.GuestPanicPayload>(), jobj["GuestPanic"]!!))
          }
          if (jobj["InvalidPromiseIndex"] != null) {
            return HostError.InvalidPromiseIndex(decoder.json.decodeFromJsonElement(serializer<HostError.InvalidPromiseIndex.InvalidPromiseIndexPayload>(), jobj["InvalidPromiseIndex"]!!))
          }
          if (jobj["InvalidPromiseResultIndex"] != null) {
            return HostError.InvalidPromiseResultIndex(decoder.json.decodeFromJsonElement(serializer<HostError.InvalidPromiseResultIndex.InvalidPromiseResultIndexPayload>(), jobj["InvalidPromiseResultIndex"]!!))
          }
          if (jobj["InvalidRegisterId"] != null) {
            return HostError.InvalidRegisterId(decoder.json.decodeFromJsonElement(serializer<HostError.InvalidRegisterId.InvalidRegisterIdPayload>(), jobj["InvalidRegisterId"]!!))
          }
          if (jobj["IteratorWasInvalidated"] != null) {
            return HostError.IteratorWasInvalidated(decoder.json.decodeFromJsonElement(serializer<HostError.IteratorWasInvalidated.IteratorWasInvalidatedPayload>(), jobj["IteratorWasInvalidated"]!!))
          }
          if (jobj["InvalidReceiptIndex"] != null) {
            return HostError.InvalidReceiptIndex(decoder.json.decodeFromJsonElement(serializer<HostError.InvalidReceiptIndex.InvalidReceiptIndexPayload>(), jobj["InvalidReceiptIndex"]!!))
          }
          if (jobj["InvalidIteratorIndex"] != null) {
            return HostError.InvalidIteratorIndex(decoder.json.decodeFromJsonElement(serializer<HostError.InvalidIteratorIndex.InvalidIteratorIndexPayload>(), jobj["InvalidIteratorIndex"]!!))
          }
          if (jobj["ProhibitedInView"] != null) {
            return HostError.ProhibitedInView(decoder.json.decodeFromJsonElement(serializer<HostError.ProhibitedInView.ProhibitedInViewPayload>(), jobj["ProhibitedInView"]!!))
          }
          if (jobj["NumberOfLogsExceeded"] != null) {
            return HostError.NumberOfLogsExceeded(decoder.json.decodeFromJsonElement(serializer<HostError.NumberOfLogsExceeded.NumberOfLogsExceededPayload>(), jobj["NumberOfLogsExceeded"]!!))
          }
          if (jobj["KeyLengthExceeded"] != null) {
            return HostError.KeyLengthExceeded(decoder.json.decodeFromJsonElement(serializer<HostError.KeyLengthExceeded.KeyLengthExceededPayload>(), jobj["KeyLengthExceeded"]!!))
          }
          if (jobj["ValueLengthExceeded"] != null) {
            return HostError.ValueLengthExceeded(decoder.json.decodeFromJsonElement(serializer<HostError.ValueLengthExceeded.ValueLengthExceededPayload>(), jobj["ValueLengthExceeded"]!!))
          }
          if (jobj["TotalLogLengthExceeded"] != null) {
            return HostError.TotalLogLengthExceeded(decoder.json.decodeFromJsonElement(serializer<HostError.TotalLogLengthExceeded.TotalLogLengthExceededPayload>(), jobj["TotalLogLengthExceeded"]!!))
          }
          if (jobj["NumberPromisesExceeded"] != null) {
            return HostError.NumberPromisesExceeded(decoder.json.decodeFromJsonElement(serializer<HostError.NumberPromisesExceeded.NumberPromisesExceededPayload>(), jobj["NumberPromisesExceeded"]!!))
          }
          if (jobj["NumberInputDataDependenciesExceeded"] != null) {
            return HostError.NumberInputDataDependenciesExceeded(decoder.json.decodeFromJsonElement(serializer<HostError.NumberInputDataDependenciesExceeded.NumberInputDataDependenciesExceededPayload>(), jobj["NumberInputDataDependenciesExceeded"]!!))
          }
          if (jobj["ReturnedValueLengthExceeded"] != null) {
            return HostError.ReturnedValueLengthExceeded(decoder.json.decodeFromJsonElement(serializer<HostError.ReturnedValueLengthExceeded.ReturnedValueLengthExceededPayload>(), jobj["ReturnedValueLengthExceeded"]!!))
          }
          if (jobj["ContractSizeExceeded"] != null) {
            return HostError.ContractSizeExceeded(decoder.json.decodeFromJsonElement(serializer<HostError.ContractSizeExceeded.ContractSizeExceededPayload>(), jobj["ContractSizeExceeded"]!!))
          }
          if (jobj["Deprecated"] != null) {
            return HostError.Deprecated(decoder.json.decodeFromJsonElement(serializer<HostError.Deprecated.DeprecatedPayload>(), jobj["Deprecated"]!!))
          }
          if (jobj["ECRecoverError"] != null) {
            return HostError.ECRecoverError(decoder.json.decodeFromJsonElement(serializer<HostError.ECRecoverError.ECRecoverErrorPayload>(), jobj["ECRecoverError"]!!))
          }
          if (jobj["AltBn128InvalidInput"] != null) {
            return HostError.AltBn128InvalidInput(decoder.json.decodeFromJsonElement(serializer<HostError.AltBn128InvalidInput.AltBn128InvalidInputPayload>(), jobj["AltBn128InvalidInput"]!!))
          }
          if (jobj["Ed25519VerifyInvalidInput"] != null) {
            return HostError.Ed25519VerifyInvalidInput(decoder.json.decodeFromJsonElement(serializer<HostError.Ed25519VerifyInvalidInput.Ed25519VerifyInvalidInputPayload>(), jobj["Ed25519VerifyInvalidInput"]!!))
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "GuestPanic" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<HostError.GuestPanic>(), obj)
              }
              "InvalidPromiseIndex" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<HostError.InvalidPromiseIndex>(), obj)
              }
              "InvalidPromiseResultIndex" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<HostError.InvalidPromiseResultIndex>(), obj)
              }
              "InvalidRegisterId" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<HostError.InvalidRegisterId>(), obj)
              }
              "IteratorWasInvalidated" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<HostError.IteratorWasInvalidated>(), obj)
              }
              "InvalidReceiptIndex" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<HostError.InvalidReceiptIndex>(), obj)
              }
              "InvalidIteratorIndex" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<HostError.InvalidIteratorIndex>(), obj)
              }
              "ProhibitedInView" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<HostError.ProhibitedInView>(), obj)
              }
              "NumberOfLogsExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<HostError.NumberOfLogsExceeded>(), obj)
              }
              "KeyLengthExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<HostError.KeyLengthExceeded>(), obj)
              }
              "ValueLengthExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<HostError.ValueLengthExceeded>(), obj)
              }
              "TotalLogLengthExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<HostError.TotalLogLengthExceeded>(), obj)
              }
              "NumberPromisesExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<HostError.NumberPromisesExceeded>(), obj)
              }
              "NumberInputDataDependenciesExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<HostError.NumberInputDataDependenciesExceeded>(), obj)
              }
              "ReturnedValueLengthExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<HostError.ReturnedValueLengthExceeded>(), obj)
              }
              "ContractSizeExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<HostError.ContractSizeExceeded>(), obj)
              }
              "Deprecated" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<HostError.Deprecated>(), obj)
              }
              "ECRecoverError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<HostError.ECRecoverError>(), obj)
              }
              "AltBn128InvalidInput" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<HostError.AltBn128InvalidInput>(), obj)
              }
              "Ed25519VerifyInvalidInput" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<HostError.Ed25519VerifyInvalidInput>(), obj)
              }
              "BadUTF16" -> {
                return HostError.BadUTF16
              }
              "BadUTF8" -> {
                return HostError.BadUTF8
              }
              "GasExceeded" -> {
                return HostError.GasExceeded
              }
              "GasLimitExceeded" -> {
                return HostError.GasLimitExceeded
              }
              "BalanceExceeded" -> {
                return HostError.BalanceExceeded
              }
              "EmptyMethodName" -> {
                return HostError.EmptyMethodName
              }
              "IntegerOverflow" -> {
                return HostError.IntegerOverflow
              }
              "CannotAppendActionToJointPromise" -> {
                return HostError.CannotAppendActionToJointPromise
              }
              "CannotReturnJointPromise" -> {
                return HostError.CannotReturnJointPromise
              }
              "MemoryAccessViolation" -> {
                return HostError.MemoryAccessViolation
              }
              "InvalidAccountId" -> {
                return HostError.InvalidAccountId
              }
              "InvalidMethodName" -> {
                return HostError.InvalidMethodName
              }
              "InvalidPublicKey" -> {
                return HostError.InvalidPublicKey
              }
              else -> throw SerializationException("Unknown discriminator key for HostError: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("BadUTF16", "BadUTF8", "GasExceeded", "GasLimitExceeded", "BalanceExceeded", "EmptyMethodName", "GuestPanic", "IntegerOverflow", "InvalidPromiseIndex", "CannotAppendActionToJointPromise", "CannotReturnJointPromise", "InvalidPromiseResultIndex", "InvalidRegisterId", "IteratorWasInvalidated", "MemoryAccessViolation", "InvalidReceiptIndex", "InvalidIteratorIndex", "InvalidAccountId", "InvalidMethodName", "InvalidPublicKey", "ProhibitedInView", "NumberOfLogsExceeded", "KeyLengthExceeded", "ValueLengthExceeded", "TotalLogLengthExceeded", "NumberPromisesExceeded", "NumberInputDataDependenciesExceeded", "ReturnedValueLengthExceeded", "ContractSizeExceeded", "Deprecated", "ECRecoverError", "AltBn128InvalidInput", "Ed25519VerifyInvalidInput")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in HostError")
            val tf = typeField.trim()
            when (tf) {
              "GuestPanic" -> {
                return decoder.json.decodeFromJsonElement(serializer<HostError.GuestPanic>(), jobj)
              }
              "InvalidPromiseIndex" -> {
                return decoder.json.decodeFromJsonElement(serializer<HostError.InvalidPromiseIndex>(), jobj)
              }
              "InvalidPromiseResultIndex" -> {
                return decoder.json.decodeFromJsonElement(serializer<HostError.InvalidPromiseResultIndex>(), jobj)
              }
              "InvalidRegisterId" -> {
                return decoder.json.decodeFromJsonElement(serializer<HostError.InvalidRegisterId>(), jobj)
              }
              "IteratorWasInvalidated" -> {
                return decoder.json.decodeFromJsonElement(serializer<HostError.IteratorWasInvalidated>(), jobj)
              }
              "InvalidReceiptIndex" -> {
                return decoder.json.decodeFromJsonElement(serializer<HostError.InvalidReceiptIndex>(), jobj)
              }
              "InvalidIteratorIndex" -> {
                return decoder.json.decodeFromJsonElement(serializer<HostError.InvalidIteratorIndex>(), jobj)
              }
              "ProhibitedInView" -> {
                return decoder.json.decodeFromJsonElement(serializer<HostError.ProhibitedInView>(), jobj)
              }
              "NumberOfLogsExceeded" -> {
                return decoder.json.decodeFromJsonElement(serializer<HostError.NumberOfLogsExceeded>(), jobj)
              }
              "KeyLengthExceeded" -> {
                return decoder.json.decodeFromJsonElement(serializer<HostError.KeyLengthExceeded>(), jobj)
              }
              "ValueLengthExceeded" -> {
                return decoder.json.decodeFromJsonElement(serializer<HostError.ValueLengthExceeded>(), jobj)
              }
              "TotalLogLengthExceeded" -> {
                return decoder.json.decodeFromJsonElement(serializer<HostError.TotalLogLengthExceeded>(), jobj)
              }
              "NumberPromisesExceeded" -> {
                return decoder.json.decodeFromJsonElement(serializer<HostError.NumberPromisesExceeded>(), jobj)
              }
              "NumberInputDataDependenciesExceeded" -> {
                return decoder.json.decodeFromJsonElement(serializer<HostError.NumberInputDataDependenciesExceeded>(), jobj)
              }
              "ReturnedValueLengthExceeded" -> {
                return decoder.json.decodeFromJsonElement(serializer<HostError.ReturnedValueLengthExceeded>(), jobj)
              }
              "ContractSizeExceeded" -> {
                return decoder.json.decodeFromJsonElement(serializer<HostError.ContractSizeExceeded>(), jobj)
              }
              "Deprecated" -> {
                return decoder.json.decodeFromJsonElement(serializer<HostError.Deprecated>(), jobj)
              }
              "ECRecoverError" -> {
                return decoder.json.decodeFromJsonElement(serializer<HostError.ECRecoverError>(), jobj)
              }
              "AltBn128InvalidInput" -> {
                return decoder.json.decodeFromJsonElement(serializer<HostError.AltBn128InvalidInput>(), jobj)
              }
              "Ed25519VerifyInvalidInput" -> {
                return decoder.json.decodeFromJsonElement(serializer<HostError.Ed25519VerifyInvalidInput>(), jobj)
              }
              "BadUTF16" -> return HostError.BadUTF16
              "BadUTF8" -> return HostError.BadUTF8
              "GasExceeded" -> return HostError.GasExceeded
              "GasLimitExceeded" -> return HostError.GasLimitExceeded
              "BalanceExceeded" -> return HostError.BalanceExceeded
              "EmptyMethodName" -> return HostError.EmptyMethodName
              "IntegerOverflow" -> return HostError.IntegerOverflow
              "CannotAppendActionToJointPromise" -> return HostError.CannotAppendActionToJointPromise
              "CannotReturnJointPromise" -> return HostError.CannotReturnJointPromise
              "MemoryAccessViolation" -> return HostError.MemoryAccessViolation
              "InvalidAccountId" -> return HostError.InvalidAccountId
              "InvalidMethodName" -> return HostError.InvalidMethodName
              "InvalidPublicKey" -> return HostError.InvalidPublicKey
              else -> throw SerializationException("Unknown type discriminator for HostError: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize HostError with non-JSON decoder")
  }
}
