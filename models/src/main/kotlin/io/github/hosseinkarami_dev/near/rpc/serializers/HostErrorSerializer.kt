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
        HostError.BadUTF16 -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("BadUTF16"))
        }
        HostError.BadUTF8 -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("BadUTF8"))
        }
        HostError.GasExceeded -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("GasExceeded"))
        }
        HostError.GasLimitExceeded -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("GasLimitExceeded"))
        }
        HostError.BalanceExceeded -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("BalanceExceeded"))
        }
        HostError.EmptyMethodName -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("EmptyMethodName"))
        }
        HostError.IntegerOverflow -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("IntegerOverflow"))
        }
        HostError.CannotAppendActionToJointPromise -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("CannotAppendActionToJointPromise"))
        }
        HostError.CannotReturnJointPromise -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("CannotReturnJointPromise"))
        }
        HostError.MemoryAccessViolation -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("MemoryAccessViolation"))
        }
        HostError.InvalidAccountId -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("InvalidAccountId"))
        }
        HostError.InvalidMethodName -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("InvalidMethodName"))
        }
        HostError.InvalidPublicKey -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("InvalidPublicKey"))
        }
        is HostError.GuestPanic -> {
          val map = mutableMapOf<String, JsonElement>()
          map["GuestPanic"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError.GuestPanic.GuestPanicPayload>(), value.guestPanic)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is HostError.InvalidPromiseIndex -> {
          val map = mutableMapOf<String, JsonElement>()
          map["InvalidPromiseIndex"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError.InvalidPromiseIndex.InvalidPromiseIndexPayload>(), value.invalidPromiseIndex)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
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
            throw SerializationException("Unknown discriminator string for HostError: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing HostError")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["GuestPanic"] != null) {
            val guestPanicVal = decoder.json.decodeFromJsonElement(serializer<HostError.GuestPanic.GuestPanicPayload>(), jobj["GuestPanic"] ?: throw SerializationException("Missing field 'GuestPanic' for variant " + "GuestPanic"))
            return HostError.GuestPanic(guestPanicVal)
          }
          if (jobj["InvalidPromiseIndex"] != null) {
            val invalidPromiseIndexVal = decoder.json.decodeFromJsonElement(serializer<HostError.InvalidPromiseIndex.InvalidPromiseIndexPayload>(), jobj["InvalidPromiseIndex"] ?: throw SerializationException("Missing field 'InvalidPromiseIndex' for variant " + "InvalidPromiseIndex"))
            return HostError.InvalidPromiseIndex(invalidPromiseIndexVal)
          }
          if (jobj["InvalidPromiseResultIndex"] != null) {
            val invalidPromiseResultIndexVal = decoder.json.decodeFromJsonElement(serializer<HostError.InvalidPromiseResultIndex.InvalidPromiseResultIndexPayload>(), jobj["InvalidPromiseResultIndex"] ?: throw SerializationException("Missing field 'InvalidPromiseResultIndex' for variant " + "InvalidPromiseResultIndex"))
            return HostError.InvalidPromiseResultIndex(invalidPromiseResultIndexVal)
          }
          if (jobj["InvalidRegisterId"] != null) {
            val invalidRegisterIdVal = decoder.json.decodeFromJsonElement(serializer<HostError.InvalidRegisterId.InvalidRegisterIdPayload>(), jobj["InvalidRegisterId"] ?: throw SerializationException("Missing field 'InvalidRegisterId' for variant " + "InvalidRegisterId"))
            return HostError.InvalidRegisterId(invalidRegisterIdVal)
          }
          if (jobj["IteratorWasInvalidated"] != null) {
            val iteratorWasInvalidatedVal = decoder.json.decodeFromJsonElement(serializer<HostError.IteratorWasInvalidated.IteratorWasInvalidatedPayload>(), jobj["IteratorWasInvalidated"] ?: throw SerializationException("Missing field 'IteratorWasInvalidated' for variant " + "IteratorWasInvalidated"))
            return HostError.IteratorWasInvalidated(iteratorWasInvalidatedVal)
          }
          if (jobj["InvalidReceiptIndex"] != null) {
            val invalidReceiptIndexVal = decoder.json.decodeFromJsonElement(serializer<HostError.InvalidReceiptIndex.InvalidReceiptIndexPayload>(), jobj["InvalidReceiptIndex"] ?: throw SerializationException("Missing field 'InvalidReceiptIndex' for variant " + "InvalidReceiptIndex"))
            return HostError.InvalidReceiptIndex(invalidReceiptIndexVal)
          }
          if (jobj["InvalidIteratorIndex"] != null) {
            val invalidIteratorIndexVal = decoder.json.decodeFromJsonElement(serializer<HostError.InvalidIteratorIndex.InvalidIteratorIndexPayload>(), jobj["InvalidIteratorIndex"] ?: throw SerializationException("Missing field 'InvalidIteratorIndex' for variant " + "InvalidIteratorIndex"))
            return HostError.InvalidIteratorIndex(invalidIteratorIndexVal)
          }
          if (jobj["ProhibitedInView"] != null) {
            val prohibitedInViewVal = decoder.json.decodeFromJsonElement(serializer<HostError.ProhibitedInView.ProhibitedInViewPayload>(), jobj["ProhibitedInView"] ?: throw SerializationException("Missing field 'ProhibitedInView' for variant " + "ProhibitedInView"))
            return HostError.ProhibitedInView(prohibitedInViewVal)
          }
          if (jobj["NumberOfLogsExceeded"] != null) {
            val numberOfLogsExceededVal = decoder.json.decodeFromJsonElement(serializer<HostError.NumberOfLogsExceeded.NumberOfLogsExceededPayload>(), jobj["NumberOfLogsExceeded"] ?: throw SerializationException("Missing field 'NumberOfLogsExceeded' for variant " + "NumberOfLogsExceeded"))
            return HostError.NumberOfLogsExceeded(numberOfLogsExceededVal)
          }
          if (jobj["KeyLengthExceeded"] != null) {
            val keyLengthExceededVal = decoder.json.decodeFromJsonElement(serializer<HostError.KeyLengthExceeded.KeyLengthExceededPayload>(), jobj["KeyLengthExceeded"] ?: throw SerializationException("Missing field 'KeyLengthExceeded' for variant " + "KeyLengthExceeded"))
            return HostError.KeyLengthExceeded(keyLengthExceededVal)
          }
          if (jobj["ValueLengthExceeded"] != null) {
            val valueLengthExceededVal = decoder.json.decodeFromJsonElement(serializer<HostError.ValueLengthExceeded.ValueLengthExceededPayload>(), jobj["ValueLengthExceeded"] ?: throw SerializationException("Missing field 'ValueLengthExceeded' for variant " + "ValueLengthExceeded"))
            return HostError.ValueLengthExceeded(valueLengthExceededVal)
          }
          if (jobj["TotalLogLengthExceeded"] != null) {
            val totalLogLengthExceededVal = decoder.json.decodeFromJsonElement(serializer<HostError.TotalLogLengthExceeded.TotalLogLengthExceededPayload>(), jobj["TotalLogLengthExceeded"] ?: throw SerializationException("Missing field 'TotalLogLengthExceeded' for variant " + "TotalLogLengthExceeded"))
            return HostError.TotalLogLengthExceeded(totalLogLengthExceededVal)
          }
          if (jobj["NumberPromisesExceeded"] != null) {
            val numberPromisesExceededVal = decoder.json.decodeFromJsonElement(serializer<HostError.NumberPromisesExceeded.NumberPromisesExceededPayload>(), jobj["NumberPromisesExceeded"] ?: throw SerializationException("Missing field 'NumberPromisesExceeded' for variant " + "NumberPromisesExceeded"))
            return HostError.NumberPromisesExceeded(numberPromisesExceededVal)
          }
          if (jobj["NumberInputDataDependenciesExceeded"] != null) {
            val numberInputDataDependenciesExceededVal = decoder.json.decodeFromJsonElement(serializer<HostError.NumberInputDataDependenciesExceeded.NumberInputDataDependenciesExceededPayload>(), jobj["NumberInputDataDependenciesExceeded"] ?: throw SerializationException("Missing field 'NumberInputDataDependenciesExceeded' for variant " + "NumberInputDataDependenciesExceeded"))
            return HostError.NumberInputDataDependenciesExceeded(numberInputDataDependenciesExceededVal)
          }
          if (jobj["ReturnedValueLengthExceeded"] != null) {
            val returnedValueLengthExceededVal = decoder.json.decodeFromJsonElement(serializer<HostError.ReturnedValueLengthExceeded.ReturnedValueLengthExceededPayload>(), jobj["ReturnedValueLengthExceeded"] ?: throw SerializationException("Missing field 'ReturnedValueLengthExceeded' for variant " + "ReturnedValueLengthExceeded"))
            return HostError.ReturnedValueLengthExceeded(returnedValueLengthExceededVal)
          }
          if (jobj["ContractSizeExceeded"] != null) {
            val contractSizeExceededVal = decoder.json.decodeFromJsonElement(serializer<HostError.ContractSizeExceeded.ContractSizeExceededPayload>(), jobj["ContractSizeExceeded"] ?: throw SerializationException("Missing field 'ContractSizeExceeded' for variant " + "ContractSizeExceeded"))
            return HostError.ContractSizeExceeded(contractSizeExceededVal)
          }
          if (jobj["Deprecated"] != null) {
            val deprecatedVal = decoder.json.decodeFromJsonElement(serializer<HostError.Deprecated.DeprecatedPayload>(), jobj["Deprecated"] ?: throw SerializationException("Missing field 'Deprecated' for variant " + "Deprecated"))
            return HostError.Deprecated(deprecatedVal)
          }
          if (jobj["ECRecoverError"] != null) {
            val eCRecoverErrorVal = decoder.json.decodeFromJsonElement(serializer<HostError.ECRecoverError.ECRecoverErrorPayload>(), jobj["ECRecoverError"] ?: throw SerializationException("Missing field 'ECRecoverError' for variant " + "ECRecoverError"))
            return HostError.ECRecoverError(eCRecoverErrorVal)
          }
          if (jobj["AltBn128InvalidInput"] != null) {
            val altBn128InvalidInputVal = decoder.json.decodeFromJsonElement(serializer<HostError.AltBn128InvalidInput.AltBn128InvalidInputPayload>(), jobj["AltBn128InvalidInput"] ?: throw SerializationException("Missing field 'AltBn128InvalidInput' for variant " + "AltBn128InvalidInput"))
            return HostError.AltBn128InvalidInput(altBn128InvalidInputVal)
          }
          if (jobj["Ed25519VerifyInvalidInput"] != null) {
            val ed25519VerifyInvalidInputVal = decoder.json.decodeFromJsonElement(serializer<HostError.Ed25519VerifyInvalidInput.Ed25519VerifyInvalidInputPayload>(), jobj["Ed25519VerifyInvalidInput"] ?: throw SerializationException("Missing field 'Ed25519VerifyInvalidInput' for variant " + "Ed25519VerifyInvalidInput"))
            return HostError.Ed25519VerifyInvalidInput(ed25519VerifyInvalidInputVal)
          }
          if (listOf("GuestPanic").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<HostError.GuestPanic>(), jobj)
          }
          if (listOf("InvalidPromiseIndex").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<HostError.InvalidPromiseIndex>(), jobj)
          }
          if (listOf("InvalidPromiseResultIndex").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<HostError.InvalidPromiseResultIndex>(), jobj)
          }
          if (listOf("InvalidRegisterId").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<HostError.InvalidRegisterId>(), jobj)
          }
          if (listOf("IteratorWasInvalidated").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<HostError.IteratorWasInvalidated>(), jobj)
          }
          if (listOf("InvalidReceiptIndex").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<HostError.InvalidReceiptIndex>(), jobj)
          }
          if (listOf("InvalidIteratorIndex").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<HostError.InvalidIteratorIndex>(), jobj)
          }
          if (listOf("ProhibitedInView").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<HostError.ProhibitedInView>(), jobj)
          }
          if (listOf("NumberOfLogsExceeded").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<HostError.NumberOfLogsExceeded>(), jobj)
          }
          if (listOf("KeyLengthExceeded").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<HostError.KeyLengthExceeded>(), jobj)
          }
          if (listOf("ValueLengthExceeded").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<HostError.ValueLengthExceeded>(), jobj)
          }
          if (listOf("TotalLogLengthExceeded").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<HostError.TotalLogLengthExceeded>(), jobj)
          }
          if (listOf("NumberPromisesExceeded").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<HostError.NumberPromisesExceeded>(), jobj)
          }
          if (listOf("NumberInputDataDependenciesExceeded").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<HostError.NumberInputDataDependenciesExceeded>(), jobj)
          }
          if (listOf("ReturnedValueLengthExceeded").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<HostError.ReturnedValueLengthExceeded>(), jobj)
          }
          if (listOf("ContractSizeExceeded").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<HostError.ContractSizeExceeded>(), jobj)
          }
          if (listOf("Deprecated").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<HostError.Deprecated>(), jobj)
          }
          if (listOf("ECRecoverError").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<HostError.ECRecoverError>(), jobj)
          }
          if (listOf("AltBn128InvalidInput").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<HostError.AltBn128InvalidInput>(), jobj)
          }
          if (listOf("Ed25519VerifyInvalidInput").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<HostError.Ed25519VerifyInvalidInput>(), jobj)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "GuestPanic" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val guestPanicVal = decoder.json.decodeFromJsonElement(serializer<HostError.GuestPanic.GuestPanicPayload>(), obj["GuestPanic"] ?: throw SerializationException("Missing field 'GuestPanic' for variant " + key))
                return HostError.GuestPanic(guestPanicVal)
              }
              "InvalidPromiseIndex" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val invalidPromiseIndexVal = decoder.json.decodeFromJsonElement(serializer<HostError.InvalidPromiseIndex.InvalidPromiseIndexPayload>(), obj["InvalidPromiseIndex"] ?: throw SerializationException("Missing field 'InvalidPromiseIndex' for variant " + key))
                return HostError.InvalidPromiseIndex(invalidPromiseIndexVal)
              }
              "InvalidPromiseResultIndex" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val invalidPromiseResultIndexVal = decoder.json.decodeFromJsonElement(serializer<HostError.InvalidPromiseResultIndex.InvalidPromiseResultIndexPayload>(), obj["InvalidPromiseResultIndex"] ?: throw SerializationException("Missing field 'InvalidPromiseResultIndex' for variant " + key))
                return HostError.InvalidPromiseResultIndex(invalidPromiseResultIndexVal)
              }
              "InvalidRegisterId" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val invalidRegisterIdVal = decoder.json.decodeFromJsonElement(serializer<HostError.InvalidRegisterId.InvalidRegisterIdPayload>(), obj["InvalidRegisterId"] ?: throw SerializationException("Missing field 'InvalidRegisterId' for variant " + key))
                return HostError.InvalidRegisterId(invalidRegisterIdVal)
              }
              "IteratorWasInvalidated" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val iteratorWasInvalidatedVal = decoder.json.decodeFromJsonElement(serializer<HostError.IteratorWasInvalidated.IteratorWasInvalidatedPayload>(), obj["IteratorWasInvalidated"] ?: throw SerializationException("Missing field 'IteratorWasInvalidated' for variant " + key))
                return HostError.IteratorWasInvalidated(iteratorWasInvalidatedVal)
              }
              "InvalidReceiptIndex" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val invalidReceiptIndexVal = decoder.json.decodeFromJsonElement(serializer<HostError.InvalidReceiptIndex.InvalidReceiptIndexPayload>(), obj["InvalidReceiptIndex"] ?: throw SerializationException("Missing field 'InvalidReceiptIndex' for variant " + key))
                return HostError.InvalidReceiptIndex(invalidReceiptIndexVal)
              }
              "InvalidIteratorIndex" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val invalidIteratorIndexVal = decoder.json.decodeFromJsonElement(serializer<HostError.InvalidIteratorIndex.InvalidIteratorIndexPayload>(), obj["InvalidIteratorIndex"] ?: throw SerializationException("Missing field 'InvalidIteratorIndex' for variant " + key))
                return HostError.InvalidIteratorIndex(invalidIteratorIndexVal)
              }
              "ProhibitedInView" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val prohibitedInViewVal = decoder.json.decodeFromJsonElement(serializer<HostError.ProhibitedInView.ProhibitedInViewPayload>(), obj["ProhibitedInView"] ?: throw SerializationException("Missing field 'ProhibitedInView' for variant " + key))
                return HostError.ProhibitedInView(prohibitedInViewVal)
              }
              "NumberOfLogsExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val numberOfLogsExceededVal = decoder.json.decodeFromJsonElement(serializer<HostError.NumberOfLogsExceeded.NumberOfLogsExceededPayload>(), obj["NumberOfLogsExceeded"] ?: throw SerializationException("Missing field 'NumberOfLogsExceeded' for variant " + key))
                return HostError.NumberOfLogsExceeded(numberOfLogsExceededVal)
              }
              "KeyLengthExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val keyLengthExceededVal = decoder.json.decodeFromJsonElement(serializer<HostError.KeyLengthExceeded.KeyLengthExceededPayload>(), obj["KeyLengthExceeded"] ?: throw SerializationException("Missing field 'KeyLengthExceeded' for variant " + key))
                return HostError.KeyLengthExceeded(keyLengthExceededVal)
              }
              "ValueLengthExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val valueLengthExceededVal = decoder.json.decodeFromJsonElement(serializer<HostError.ValueLengthExceeded.ValueLengthExceededPayload>(), obj["ValueLengthExceeded"] ?: throw SerializationException("Missing field 'ValueLengthExceeded' for variant " + key))
                return HostError.ValueLengthExceeded(valueLengthExceededVal)
              }
              "TotalLogLengthExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val totalLogLengthExceededVal = decoder.json.decodeFromJsonElement(serializer<HostError.TotalLogLengthExceeded.TotalLogLengthExceededPayload>(), obj["TotalLogLengthExceeded"] ?: throw SerializationException("Missing field 'TotalLogLengthExceeded' for variant " + key))
                return HostError.TotalLogLengthExceeded(totalLogLengthExceededVal)
              }
              "NumberPromisesExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val numberPromisesExceededVal = decoder.json.decodeFromJsonElement(serializer<HostError.NumberPromisesExceeded.NumberPromisesExceededPayload>(), obj["NumberPromisesExceeded"] ?: throw SerializationException("Missing field 'NumberPromisesExceeded' for variant " + key))
                return HostError.NumberPromisesExceeded(numberPromisesExceededVal)
              }
              "NumberInputDataDependenciesExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val numberInputDataDependenciesExceededVal = decoder.json.decodeFromJsonElement(serializer<HostError.NumberInputDataDependenciesExceeded.NumberInputDataDependenciesExceededPayload>(), obj["NumberInputDataDependenciesExceeded"] ?: throw SerializationException("Missing field 'NumberInputDataDependenciesExceeded' for variant " + key))
                return HostError.NumberInputDataDependenciesExceeded(numberInputDataDependenciesExceededVal)
              }
              "ReturnedValueLengthExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val returnedValueLengthExceededVal = decoder.json.decodeFromJsonElement(serializer<HostError.ReturnedValueLengthExceeded.ReturnedValueLengthExceededPayload>(), obj["ReturnedValueLengthExceeded"] ?: throw SerializationException("Missing field 'ReturnedValueLengthExceeded' for variant " + key))
                return HostError.ReturnedValueLengthExceeded(returnedValueLengthExceededVal)
              }
              "ContractSizeExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val contractSizeExceededVal = decoder.json.decodeFromJsonElement(serializer<HostError.ContractSizeExceeded.ContractSizeExceededPayload>(), obj["ContractSizeExceeded"] ?: throw SerializationException("Missing field 'ContractSizeExceeded' for variant " + key))
                return HostError.ContractSizeExceeded(contractSizeExceededVal)
              }
              "Deprecated" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val deprecatedVal = decoder.json.decodeFromJsonElement(serializer<HostError.Deprecated.DeprecatedPayload>(), obj["Deprecated"] ?: throw SerializationException("Missing field 'Deprecated' for variant " + key))
                return HostError.Deprecated(deprecatedVal)
              }
              "ECRecoverError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val eCRecoverErrorVal = decoder.json.decodeFromJsonElement(serializer<HostError.ECRecoverError.ECRecoverErrorPayload>(), obj["ECRecoverError"] ?: throw SerializationException("Missing field 'ECRecoverError' for variant " + key))
                return HostError.ECRecoverError(eCRecoverErrorVal)
              }
              "AltBn128InvalidInput" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val altBn128InvalidInputVal = decoder.json.decodeFromJsonElement(serializer<HostError.AltBn128InvalidInput.AltBn128InvalidInputPayload>(), obj["AltBn128InvalidInput"] ?: throw SerializationException("Missing field 'AltBn128InvalidInput' for variant " + key))
                return HostError.AltBn128InvalidInput(altBn128InvalidInputVal)
              }
              "Ed25519VerifyInvalidInput" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val ed25519VerifyInvalidInputVal = decoder.json.decodeFromJsonElement(serializer<HostError.Ed25519VerifyInvalidInput.Ed25519VerifyInvalidInputPayload>(), obj["Ed25519VerifyInvalidInput"] ?: throw SerializationException("Missing field 'Ed25519VerifyInvalidInput' for variant " + key))
                return HostError.Ed25519VerifyInvalidInput(ed25519VerifyInvalidInputVal)
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
