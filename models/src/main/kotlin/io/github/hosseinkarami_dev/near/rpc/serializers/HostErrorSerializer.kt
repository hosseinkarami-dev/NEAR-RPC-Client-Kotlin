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
import io.github.hosseinkarami_dev.near.rpc.models.HostError
import kotlinx.serialization.json.*

object HostErrorSerializer : KSerializer<HostError> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.HostError") {
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

    override fun serialize(encoder: Encoder, value: HostError) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.BadUTF16 -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("BadUTF16"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.BadUTF8 -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("BadUTF8"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.GasExceeded -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("GasExceeded"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.GasLimitExceeded -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("GasLimitExceeded"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.BalanceExceeded -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("BalanceExceeded"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.EmptyMethodName -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("EmptyMethodName"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.GuestPanic -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["GuestPanic"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.GuestPanic.GuestPanicPayload>(), value.guestPanic)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.IntegerOverflow -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("IntegerOverflow"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseIndex -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["InvalidPromiseIndex"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseIndex.InvalidPromiseIndexPayload>(), value.invalidPromiseIndex)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.CannotAppendActionToJointPromise -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("CannotAppendActionToJointPromise"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.CannotReturnJointPromise -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("CannotReturnJointPromise"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseResultIndex -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["InvalidPromiseResultIndex"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseResultIndex.InvalidPromiseResultIndexPayload>(), value.invalidPromiseResultIndex)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidRegisterId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["InvalidRegisterId"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidRegisterId.InvalidRegisterIdPayload>(), value.invalidRegisterId)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.IteratorWasInvalidated -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["IteratorWasInvalidated"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.IteratorWasInvalidated.IteratorWasInvalidatedPayload>(), value.iteratorWasInvalidated)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.MemoryAccessViolation -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("MemoryAccessViolation"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidReceiptIndex -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["InvalidReceiptIndex"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidReceiptIndex.InvalidReceiptIndexPayload>(), value.invalidReceiptIndex)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidIteratorIndex -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["InvalidIteratorIndex"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidIteratorIndex.InvalidIteratorIndexPayload>(), value.invalidIteratorIndex)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidAccountId -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("InvalidAccountId"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidMethodName -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("InvalidMethodName"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPublicKey -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("InvalidPublicKey"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.ProhibitedInView -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["ProhibitedInView"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ProhibitedInView.ProhibitedInViewPayload>(), value.prohibitedInView)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberOfLogsExceeded -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["NumberOfLogsExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberOfLogsExceeded.NumberOfLogsExceededPayload>(), value.numberOfLogsExceeded)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.KeyLengthExceeded -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["KeyLengthExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.KeyLengthExceeded.KeyLengthExceededPayload>(), value.keyLengthExceeded)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.ValueLengthExceeded -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["ValueLengthExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ValueLengthExceeded.ValueLengthExceededPayload>(), value.valueLengthExceeded)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.TotalLogLengthExceeded -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["TotalLogLengthExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.TotalLogLengthExceeded.TotalLogLengthExceededPayload>(), value.totalLogLengthExceeded)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberPromisesExceeded -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["NumberPromisesExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberPromisesExceeded.NumberPromisesExceededPayload>(), value.numberPromisesExceeded)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberInputDataDependenciesExceeded -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["NumberInputDataDependenciesExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberInputDataDependenciesExceeded.NumberInputDataDependenciesExceededPayload>(), value.numberInputDataDependenciesExceeded)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.ReturnedValueLengthExceeded -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["ReturnedValueLengthExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ReturnedValueLengthExceeded.ReturnedValueLengthExceededPayload>(), value.returnedValueLengthExceeded)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.ContractSizeExceeded -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["ContractSizeExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ContractSizeExceeded.ContractSizeExceededPayload>(), value.contractSizeExceeded)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.Deprecated -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["Deprecated"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.Deprecated.DeprecatedPayload>(), value.deprecated)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.ECRecoverError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["ECRecoverError"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ECRecoverError.ECRecoverErrorPayload>(), value.eCRecoverError)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.AltBn128InvalidInput -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["AltBn128InvalidInput"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.AltBn128InvalidInput.AltBn128InvalidInputPayload>(), value.altBn128InvalidInput)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.HostError.Ed25519VerifyInvalidInput -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["Ed25519VerifyInvalidInput"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.Ed25519VerifyInvalidInput.Ed25519VerifyInvalidInputPayload>(), value.ed25519VerifyInvalidInput)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.BadUTF16 -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.BadUTF16>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.BadUTF8 -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.BadUTF8>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.GasExceeded -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.GasExceeded>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.GasLimitExceeded -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.GasLimitExceeded>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.BalanceExceeded -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.BalanceExceeded>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.EmptyMethodName -> out.encodeSerializableElement(descriptor, 5, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.EmptyMethodName>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.GuestPanic -> out.encodeSerializableElement(descriptor, 6, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.GuestPanic>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.IntegerOverflow -> out.encodeSerializableElement(descriptor, 7, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.IntegerOverflow>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseIndex -> out.encodeSerializableElement(descriptor, 8, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseIndex>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.CannotAppendActionToJointPromise -> out.encodeSerializableElement(descriptor, 9, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.CannotAppendActionToJointPromise>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.CannotReturnJointPromise -> out.encodeSerializableElement(descriptor, 10, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.CannotReturnJointPromise>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseResultIndex -> out.encodeSerializableElement(descriptor, 11, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseResultIndex>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidRegisterId -> out.encodeSerializableElement(descriptor, 12, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidRegisterId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.IteratorWasInvalidated -> out.encodeSerializableElement(descriptor, 13, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.IteratorWasInvalidated>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.MemoryAccessViolation -> out.encodeSerializableElement(descriptor, 14, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.MemoryAccessViolation>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidReceiptIndex -> out.encodeSerializableElement(descriptor, 15, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidReceiptIndex>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidIteratorIndex -> out.encodeSerializableElement(descriptor, 16, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidIteratorIndex>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidAccountId -> out.encodeSerializableElement(descriptor, 17, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidAccountId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidMethodName -> out.encodeSerializableElement(descriptor, 18, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidMethodName>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPublicKey -> out.encodeSerializableElement(descriptor, 19, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPublicKey>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.ProhibitedInView -> out.encodeSerializableElement(descriptor, 20, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ProhibitedInView>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberOfLogsExceeded -> out.encodeSerializableElement(descriptor, 21, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberOfLogsExceeded>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.KeyLengthExceeded -> out.encodeSerializableElement(descriptor, 22, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.KeyLengthExceeded>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.ValueLengthExceeded -> out.encodeSerializableElement(descriptor, 23, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ValueLengthExceeded>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.TotalLogLengthExceeded -> out.encodeSerializableElement(descriptor, 24, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.TotalLogLengthExceeded>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberPromisesExceeded -> out.encodeSerializableElement(descriptor, 25, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberPromisesExceeded>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberInputDataDependenciesExceeded -> out.encodeSerializableElement(descriptor, 26, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberInputDataDependenciesExceeded>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.ReturnedValueLengthExceeded -> out.encodeSerializableElement(descriptor, 27, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ReturnedValueLengthExceeded>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.ContractSizeExceeded -> out.encodeSerializableElement(descriptor, 28, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ContractSizeExceeded>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.Deprecated -> out.encodeSerializableElement(descriptor, 29, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.Deprecated>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.ECRecoverError -> out.encodeSerializableElement(descriptor, 30, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ECRecoverError>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.AltBn128InvalidInput -> out.encodeSerializableElement(descriptor, 31, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.AltBn128InvalidInput>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.HostError.Ed25519VerifyInvalidInput -> out.encodeSerializableElement(descriptor, 32, serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.Ed25519VerifyInvalidInput>(), value)
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
                        if (s == "BadUTF16") return io.github.hosseinkarami_dev.near.rpc.models.HostError.BadUTF16
                        if (s == "BadUTF8") return io.github.hosseinkarami_dev.near.rpc.models.HostError.BadUTF8
                        if (s == "GasExceeded") return io.github.hosseinkarami_dev.near.rpc.models.HostError.GasExceeded
                        if (s == "GasLimitExceeded") return io.github.hosseinkarami_dev.near.rpc.models.HostError.GasLimitExceeded
                        if (s == "BalanceExceeded") return io.github.hosseinkarami_dev.near.rpc.models.HostError.BalanceExceeded
                        if (s == "EmptyMethodName") return io.github.hosseinkarami_dev.near.rpc.models.HostError.EmptyMethodName
                        if (s == "IntegerOverflow") return io.github.hosseinkarami_dev.near.rpc.models.HostError.IntegerOverflow
                        if (s == "CannotAppendActionToJointPromise") return io.github.hosseinkarami_dev.near.rpc.models.HostError.CannotAppendActionToJointPromise
                        if (s == "CannotReturnJointPromise") return io.github.hosseinkarami_dev.near.rpc.models.HostError.CannotReturnJointPromise
                        if (s == "MemoryAccessViolation") return io.github.hosseinkarami_dev.near.rpc.models.HostError.MemoryAccessViolation
                        if (s == "InvalidAccountId") return io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidAccountId
                        if (s == "InvalidMethodName") return io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidMethodName
                        if (s == "InvalidPublicKey") return io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPublicKey
                    }
                    throw SerializationException("Unknown discriminator (primitive) for HostError")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing HostError")

                is JsonObject -> {
                    val jobj = element
                    if (jobj["GuestPanic"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.HostError.GuestPanic(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.GuestPanic.GuestPanicPayload>(), jobj["GuestPanic"]!!))
                    }
                    if (jobj["InvalidPromiseIndex"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseIndex(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseIndex.InvalidPromiseIndexPayload>(), jobj["InvalidPromiseIndex"]!!))
                    }
                    if (jobj["InvalidPromiseResultIndex"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseResultIndex(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseResultIndex.InvalidPromiseResultIndexPayload>(), jobj["InvalidPromiseResultIndex"]!!))
                    }
                    if (jobj["InvalidRegisterId"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidRegisterId(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidRegisterId.InvalidRegisterIdPayload>(), jobj["InvalidRegisterId"]!!))
                    }
                    if (jobj["IteratorWasInvalidated"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.HostError.IteratorWasInvalidated(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.IteratorWasInvalidated.IteratorWasInvalidatedPayload>(), jobj["IteratorWasInvalidated"]!!))
                    }
                    if (jobj["InvalidReceiptIndex"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidReceiptIndex(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidReceiptIndex.InvalidReceiptIndexPayload>(), jobj["InvalidReceiptIndex"]!!))
                    }
                    if (jobj["InvalidIteratorIndex"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidIteratorIndex(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidIteratorIndex.InvalidIteratorIndexPayload>(), jobj["InvalidIteratorIndex"]!!))
                    }
                    if (jobj["ProhibitedInView"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.HostError.ProhibitedInView(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ProhibitedInView.ProhibitedInViewPayload>(), jobj["ProhibitedInView"]!!))
                    }
                    if (jobj["NumberOfLogsExceeded"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberOfLogsExceeded(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberOfLogsExceeded.NumberOfLogsExceededPayload>(), jobj["NumberOfLogsExceeded"]!!))
                    }
                    if (jobj["KeyLengthExceeded"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.HostError.KeyLengthExceeded(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.KeyLengthExceeded.KeyLengthExceededPayload>(), jobj["KeyLengthExceeded"]!!))
                    }
                    if (jobj["ValueLengthExceeded"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.HostError.ValueLengthExceeded(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ValueLengthExceeded.ValueLengthExceededPayload>(), jobj["ValueLengthExceeded"]!!))
                    }
                    if (jobj["TotalLogLengthExceeded"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.HostError.TotalLogLengthExceeded(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.TotalLogLengthExceeded.TotalLogLengthExceededPayload>(), jobj["TotalLogLengthExceeded"]!!))
                    }
                    if (jobj["NumberPromisesExceeded"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberPromisesExceeded(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberPromisesExceeded.NumberPromisesExceededPayload>(), jobj["NumberPromisesExceeded"]!!))
                    }
                    if (jobj["NumberInputDataDependenciesExceeded"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberInputDataDependenciesExceeded(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberInputDataDependenciesExceeded.NumberInputDataDependenciesExceededPayload>(), jobj["NumberInputDataDependenciesExceeded"]!!))
                    }
                    if (jobj["ReturnedValueLengthExceeded"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.HostError.ReturnedValueLengthExceeded(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ReturnedValueLengthExceeded.ReturnedValueLengthExceededPayload>(), jobj["ReturnedValueLengthExceeded"]!!))
                    }
                    if (jobj["ContractSizeExceeded"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.HostError.ContractSizeExceeded(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ContractSizeExceeded.ContractSizeExceededPayload>(), jobj["ContractSizeExceeded"]!!))
                    }
                    if (jobj["Deprecated"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.HostError.Deprecated(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.Deprecated.DeprecatedPayload>(), jobj["Deprecated"]!!))
                    }
                    if (jobj["ECRecoverError"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.HostError.ECRecoverError(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ECRecoverError.ECRecoverErrorPayload>(), jobj["ECRecoverError"]!!))
                    }
                    if (jobj["AltBn128InvalidInput"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.HostError.AltBn128InvalidInput(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.AltBn128InvalidInput.AltBn128InvalidInputPayload>(), jobj["AltBn128InvalidInput"]!!))
                    }
                    if (jobj["Ed25519VerifyInvalidInput"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.HostError.Ed25519VerifyInvalidInput(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.Ed25519VerifyInvalidInput.Ed25519VerifyInvalidInputPayload>(), jobj["Ed25519VerifyInvalidInput"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "GuestPanic" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant GuestPanic: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.GuestPanic>(), obj)
                            }
                            "InvalidPromiseIndex" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant InvalidPromiseIndex: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseIndex>(), obj)
                            }
                            "InvalidPromiseResultIndex" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant InvalidPromiseResultIndex: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseResultIndex>(), obj)
                            }
                            "InvalidRegisterId" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant InvalidRegisterId: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidRegisterId>(), obj)
                            }
                            "IteratorWasInvalidated" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant IteratorWasInvalidated: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.IteratorWasInvalidated>(), obj)
                            }
                            "InvalidReceiptIndex" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant InvalidReceiptIndex: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidReceiptIndex>(), obj)
                            }
                            "InvalidIteratorIndex" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant InvalidIteratorIndex: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidIteratorIndex>(), obj)
                            }
                            "ProhibitedInView" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant ProhibitedInView: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ProhibitedInView>(), obj)
                            }
                            "NumberOfLogsExceeded" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant NumberOfLogsExceeded: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberOfLogsExceeded>(), obj)
                            }
                            "KeyLengthExceeded" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant KeyLengthExceeded: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.KeyLengthExceeded>(), obj)
                            }
                            "ValueLengthExceeded" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant ValueLengthExceeded: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ValueLengthExceeded>(), obj)
                            }
                            "TotalLogLengthExceeded" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant TotalLogLengthExceeded: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.TotalLogLengthExceeded>(), obj)
                            }
                            "NumberPromisesExceeded" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant NumberPromisesExceeded: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberPromisesExceeded>(), obj)
                            }
                            "NumberInputDataDependenciesExceeded" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant NumberInputDataDependenciesExceeded: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberInputDataDependenciesExceeded>(), obj)
                            }
                            "ReturnedValueLengthExceeded" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant ReturnedValueLengthExceeded: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ReturnedValueLengthExceeded>(), obj)
                            }
                            "ContractSizeExceeded" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant ContractSizeExceeded: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ContractSizeExceeded>(), obj)
                            }
                            "Deprecated" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant Deprecated: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.Deprecated>(), obj)
                            }
                            "ECRecoverError" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant ECRecoverError: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ECRecoverError>(), obj)
                            }
                            "AltBn128InvalidInput" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant AltBn128InvalidInput: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.AltBn128InvalidInput>(), obj)
                            }
                            "Ed25519VerifyInvalidInput" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant Ed25519VerifyInvalidInput: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.Ed25519VerifyInvalidInput>(), obj)
                            }
                            "BadUTF16" -> return io.github.hosseinkarami_dev.near.rpc.models.HostError.BadUTF16
                            "BadUTF8" -> return io.github.hosseinkarami_dev.near.rpc.models.HostError.BadUTF8
                            "GasExceeded" -> return io.github.hosseinkarami_dev.near.rpc.models.HostError.GasExceeded
                            "GasLimitExceeded" -> return io.github.hosseinkarami_dev.near.rpc.models.HostError.GasLimitExceeded
                            "BalanceExceeded" -> return io.github.hosseinkarami_dev.near.rpc.models.HostError.BalanceExceeded
                            "EmptyMethodName" -> return io.github.hosseinkarami_dev.near.rpc.models.HostError.EmptyMethodName
                            "IntegerOverflow" -> return io.github.hosseinkarami_dev.near.rpc.models.HostError.IntegerOverflow
                            "CannotAppendActionToJointPromise" -> return io.github.hosseinkarami_dev.near.rpc.models.HostError.CannotAppendActionToJointPromise
                            "CannotReturnJointPromise" -> return io.github.hosseinkarami_dev.near.rpc.models.HostError.CannotReturnJointPromise
                            "MemoryAccessViolation" -> return io.github.hosseinkarami_dev.near.rpc.models.HostError.MemoryAccessViolation
                            "InvalidAccountId" -> return io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidAccountId
                            "InvalidMethodName" -> return io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidMethodName
                            "InvalidPublicKey" -> return io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPublicKey
                            else -> throw SerializationException("Unknown discriminator key for HostError: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("GuestPanic")
                    for (cand in discriminatorCandidates) {
                        val candElem = jobj[cand]
                        if (candElem is JsonPrimitive) {
                            typeField = candElem.contentOrNull
                            if (typeField != null) break
                        }
                    }
                    if (typeField == null) {
                        val knownVariantNames = setOf("BadUTF16", "BadUTF8", "GasExceeded", "GasLimitExceeded", "BalanceExceeded", "EmptyMethodName", "GuestPanic", "IntegerOverflow", "InvalidPromiseIndex", "CannotAppendActionToJointPromise", "CannotReturnJointPromise", "InvalidPromiseResultIndex", "InvalidRegisterId", "IteratorWasInvalidated", "MemoryAccessViolation", "InvalidReceiptIndex", "InvalidIteratorIndex", "InvalidAccountId", "InvalidMethodName", "InvalidPublicKey", "ProhibitedInView", "NumberOfLogsExceeded", "KeyLengthExceeded", "ValueLengthExceeded", "TotalLogLengthExceeded", "NumberPromisesExceeded", "NumberInputDataDependenciesExceeded", "ReturnedValueLengthExceeded", "ContractSizeExceeded", "Deprecated", "ECRecoverError", "AltBn128InvalidInput", "Ed25519VerifyInvalidInput")
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
                            "BadUTF16" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.BadUTF16>(), jobj)
                            "BadUTF8" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.BadUTF8>(), jobj)
                            "GasExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.GasExceeded>(), jobj)
                            "GasLimitExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.GasLimitExceeded>(), jobj)
                            "BalanceExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.BalanceExceeded>(), jobj)
                            "EmptyMethodName" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.EmptyMethodName>(), jobj)
                            "GuestPanic" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.GuestPanic>(), jobj)
                            "IntegerOverflow" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.IntegerOverflow>(), jobj)
                            "InvalidPromiseIndex" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseIndex>(), jobj)
                            "CannotAppendActionToJointPromise" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.CannotAppendActionToJointPromise>(), jobj)
                            "CannotReturnJointPromise" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.CannotReturnJointPromise>(), jobj)
                            "InvalidPromiseResultIndex" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseResultIndex>(), jobj)
                            "InvalidRegisterId" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidRegisterId>(), jobj)
                            "IteratorWasInvalidated" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.IteratorWasInvalidated>(), jobj)
                            "MemoryAccessViolation" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.MemoryAccessViolation>(), jobj)
                            "InvalidReceiptIndex" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidReceiptIndex>(), jobj)
                            "InvalidIteratorIndex" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidIteratorIndex>(), jobj)
                            "InvalidAccountId" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidAccountId>(), jobj)
                            "InvalidMethodName" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidMethodName>(), jobj)
                            "InvalidPublicKey" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPublicKey>(), jobj)
                            "ProhibitedInView" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ProhibitedInView>(), jobj)
                            "NumberOfLogsExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberOfLogsExceeded>(), jobj)
                            "KeyLengthExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.KeyLengthExceeded>(), jobj)
                            "ValueLengthExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ValueLengthExceeded>(), jobj)
                            "TotalLogLengthExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.TotalLogLengthExceeded>(), jobj)
                            "NumberPromisesExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberPromisesExceeded>(), jobj)
                            "NumberInputDataDependenciesExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberInputDataDependenciesExceeded>(), jobj)
                            "ReturnedValueLengthExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ReturnedValueLengthExceeded>(), jobj)
                            "ContractSizeExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ContractSizeExceeded>(), jobj)
                            "Deprecated" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.Deprecated>(), jobj)
                            "ECRecoverError" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ECRecoverError>(), jobj)
                            "AltBn128InvalidInput" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.AltBn128InvalidInput>(), jobj)
                            "Ed25519VerifyInvalidInput" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.Ed25519VerifyInvalidInput>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("BadUTF16".lowercase() == tfLower || tfLower.contains("BadUTF16".lowercase()) || "BadUTF16".lowercase().contains(tfLower))) { chosenGroupKey = "BadUTF16" }
                        if (chosenGroupKey == null && ("BadUTF8".lowercase() == tfLower || tfLower.contains("BadUTF8".lowercase()) || "BadUTF8".lowercase().contains(tfLower))) { chosenGroupKey = "BadUTF8" }
                        if (chosenGroupKey == null && ("GasExceeded".lowercase() == tfLower || tfLower.contains("GasExceeded".lowercase()) || "GasExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "GasExceeded" }
                        if (chosenGroupKey == null && ("GasLimitExceeded".lowercase() == tfLower || tfLower.contains("GasLimitExceeded".lowercase()) || "GasLimitExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "GasLimitExceeded" }
                        if (chosenGroupKey == null && ("BalanceExceeded".lowercase() == tfLower || tfLower.contains("BalanceExceeded".lowercase()) || "BalanceExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "BalanceExceeded" }
                        if (chosenGroupKey == null && ("EmptyMethodName".lowercase() == tfLower || tfLower.contains("EmptyMethodName".lowercase()) || "EmptyMethodName".lowercase().contains(tfLower))) { chosenGroupKey = "EmptyMethodName" }
                        if (chosenGroupKey == null && ("GuestPanic".lowercase() == tfLower || tfLower.contains("GuestPanic".lowercase()) || "GuestPanic".lowercase().contains(tfLower))) { chosenGroupKey = "GuestPanic" }
                        if (chosenGroupKey == null && ("IntegerOverflow".lowercase() == tfLower || tfLower.contains("IntegerOverflow".lowercase()) || "IntegerOverflow".lowercase().contains(tfLower))) { chosenGroupKey = "IntegerOverflow" }
                        if (chosenGroupKey == null && ("InvalidPromiseIndex".lowercase() == tfLower || tfLower.contains("InvalidPromiseIndex".lowercase()) || "InvalidPromiseIndex".lowercase().contains(tfLower))) { chosenGroupKey = "InvalidPromiseIndex" }
                        if (chosenGroupKey == null && ("CannotAppendActionToJointPromise".lowercase() == tfLower || tfLower.contains("CannotAppendActionToJointPromise".lowercase()) || "CannotAppendActionToJointPromise".lowercase().contains(tfLower))) { chosenGroupKey = "CannotAppendActionToJointPromise" }
                        if (chosenGroupKey == null && ("CannotReturnJointPromise".lowercase() == tfLower || tfLower.contains("CannotReturnJointPromise".lowercase()) || "CannotReturnJointPromise".lowercase().contains(tfLower))) { chosenGroupKey = "CannotReturnJointPromise" }
                        if (chosenGroupKey == null && ("InvalidPromiseResultIndex".lowercase() == tfLower || tfLower.contains("InvalidPromiseResultIndex".lowercase()) || "InvalidPromiseResultIndex".lowercase().contains(tfLower))) { chosenGroupKey = "InvalidPromiseResultIndex" }
                        if (chosenGroupKey == null && ("InvalidRegisterId".lowercase() == tfLower || tfLower.contains("InvalidRegisterId".lowercase()) || "InvalidRegisterId".lowercase().contains(tfLower))) { chosenGroupKey = "InvalidRegisterId" }
                        if (chosenGroupKey == null && ("IteratorWasInvalidated".lowercase() == tfLower || tfLower.contains("IteratorWasInvalidated".lowercase()) || "IteratorWasInvalidated".lowercase().contains(tfLower))) { chosenGroupKey = "IteratorWasInvalidated" }
                        if (chosenGroupKey == null && ("MemoryAccessViolation".lowercase() == tfLower || tfLower.contains("MemoryAccessViolation".lowercase()) || "MemoryAccessViolation".lowercase().contains(tfLower))) { chosenGroupKey = "MemoryAccessViolation" }
                        if (chosenGroupKey == null && ("InvalidReceiptIndex".lowercase() == tfLower || tfLower.contains("InvalidReceiptIndex".lowercase()) || "InvalidReceiptIndex".lowercase().contains(tfLower))) { chosenGroupKey = "InvalidReceiptIndex" }
                        if (chosenGroupKey == null && ("InvalidIteratorIndex".lowercase() == tfLower || tfLower.contains("InvalidIteratorIndex".lowercase()) || "InvalidIteratorIndex".lowercase().contains(tfLower))) { chosenGroupKey = "InvalidIteratorIndex" }
                        if (chosenGroupKey == null && ("InvalidAccountId".lowercase() == tfLower || tfLower.contains("InvalidAccountId".lowercase()) || "InvalidAccountId".lowercase().contains(tfLower))) { chosenGroupKey = "InvalidAccountId" }
                        if (chosenGroupKey == null && ("InvalidMethodName".lowercase() == tfLower || tfLower.contains("InvalidMethodName".lowercase()) || "InvalidMethodName".lowercase().contains(tfLower))) { chosenGroupKey = "InvalidMethodName" }
                        if (chosenGroupKey == null && ("InvalidPublicKey".lowercase() == tfLower || tfLower.contains("InvalidPublicKey".lowercase()) || "InvalidPublicKey".lowercase().contains(tfLower))) { chosenGroupKey = "InvalidPublicKey" }
                        if (chosenGroupKey == null && ("ProhibitedInView".lowercase() == tfLower || tfLower.contains("ProhibitedInView".lowercase()) || "ProhibitedInView".lowercase().contains(tfLower))) { chosenGroupKey = "ProhibitedInView" }
                        if (chosenGroupKey == null && ("NumberOfLogsExceeded".lowercase() == tfLower || tfLower.contains("NumberOfLogsExceeded".lowercase()) || "NumberOfLogsExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "NumberOfLogsExceeded" }
                        if (chosenGroupKey == null && ("KeyLengthExceeded".lowercase() == tfLower || tfLower.contains("KeyLengthExceeded".lowercase()) || "KeyLengthExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "KeyLengthExceeded" }
                        if (chosenGroupKey == null && ("ValueLengthExceeded".lowercase() == tfLower || tfLower.contains("ValueLengthExceeded".lowercase()) || "ValueLengthExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "ValueLengthExceeded" }
                        if (chosenGroupKey == null && ("TotalLogLengthExceeded".lowercase() == tfLower || tfLower.contains("TotalLogLengthExceeded".lowercase()) || "TotalLogLengthExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "TotalLogLengthExceeded" }
                        if (chosenGroupKey == null && ("NumberPromisesExceeded".lowercase() == tfLower || tfLower.contains("NumberPromisesExceeded".lowercase()) || "NumberPromisesExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "NumberPromisesExceeded" }
                        if (chosenGroupKey == null && ("NumberInputDataDependenciesExceeded".lowercase() == tfLower || tfLower.contains("NumberInputDataDependenciesExceeded".lowercase()) || "NumberInputDataDependenciesExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "NumberInputDataDependenciesExceeded" }
                        if (chosenGroupKey == null && ("ReturnedValueLengthExceeded".lowercase() == tfLower || tfLower.contains("ReturnedValueLengthExceeded".lowercase()) || "ReturnedValueLengthExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "ReturnedValueLengthExceeded" }
                        if (chosenGroupKey == null && ("ContractSizeExceeded".lowercase() == tfLower || tfLower.contains("ContractSizeExceeded".lowercase()) || "ContractSizeExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "ContractSizeExceeded" }
                        if (chosenGroupKey == null && ("Deprecated".lowercase() == tfLower || tfLower.contains("Deprecated".lowercase()) || "Deprecated".lowercase().contains(tfLower))) { chosenGroupKey = "Deprecated" }
                        if (chosenGroupKey == null && ("ECRecoverError".lowercase() == tfLower || tfLower.contains("ECRecoverError".lowercase()) || "ECRecoverError".lowercase().contains(tfLower))) { chosenGroupKey = "ECRecoverError" }
                        if (chosenGroupKey == null && ("AltBn128InvalidInput".lowercase() == tfLower || tfLower.contains("AltBn128InvalidInput".lowercase()) || "AltBn128InvalidInput".lowercase().contains(tfLower))) { chosenGroupKey = "AltBn128InvalidInput" }
                        if (chosenGroupKey == null && ("Ed25519VerifyInvalidInput".lowercase() == tfLower || tfLower.contains("Ed25519VerifyInvalidInput".lowercase()) || "Ed25519VerifyInvalidInput".lowercase().contains(tfLower))) { chosenGroupKey = "Ed25519VerifyInvalidInput" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "BadUTF16" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.BadUTF16>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'BadUTF16' and tf='$tf'")
                                }
                                "BadUTF8" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.BadUTF8>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'BadUTF8' and tf='$tf'")
                                }
                                "GasExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.GasExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'GasExceeded' and tf='$tf'")
                                }
                                "GasLimitExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.GasLimitExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'GasLimitExceeded' and tf='$tf'")
                                }
                                "BalanceExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.BalanceExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'BalanceExceeded' and tf='$tf'")
                                }
                                "EmptyMethodName" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.EmptyMethodName>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'EmptyMethodName' and tf='$tf'")
                                }
                                "GuestPanic" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.GuestPanic>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'GuestPanic' and tf='$tf'")
                                }
                                "IntegerOverflow" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.IntegerOverflow>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'IntegerOverflow' and tf='$tf'")
                                }
                                "InvalidPromiseIndex" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseIndex>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InvalidPromiseIndex' and tf='$tf'")
                                }
                                "CannotAppendActionToJointPromise" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.CannotAppendActionToJointPromise>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'CannotAppendActionToJointPromise' and tf='$tf'")
                                }
                                "CannotReturnJointPromise" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.CannotReturnJointPromise>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'CannotReturnJointPromise' and tf='$tf'")
                                }
                                "InvalidPromiseResultIndex" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseResultIndex>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InvalidPromiseResultIndex' and tf='$tf'")
                                }
                                "InvalidRegisterId" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidRegisterId>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InvalidRegisterId' and tf='$tf'")
                                }
                                "IteratorWasInvalidated" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.IteratorWasInvalidated>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'IteratorWasInvalidated' and tf='$tf'")
                                }
                                "MemoryAccessViolation" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.MemoryAccessViolation>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'MemoryAccessViolation' and tf='$tf'")
                                }
                                "InvalidReceiptIndex" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidReceiptIndex>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InvalidReceiptIndex' and tf='$tf'")
                                }
                                "InvalidIteratorIndex" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidIteratorIndex>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InvalidIteratorIndex' and tf='$tf'")
                                }
                                "InvalidAccountId" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidAccountId>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InvalidAccountId' and tf='$tf'")
                                }
                                "InvalidMethodName" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidMethodName>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InvalidMethodName' and tf='$tf'")
                                }
                                "InvalidPublicKey" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPublicKey>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InvalidPublicKey' and tf='$tf'")
                                }
                                "ProhibitedInView" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ProhibitedInView>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'ProhibitedInView' and tf='$tf'")
                                }
                                "NumberOfLogsExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberOfLogsExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'NumberOfLogsExceeded' and tf='$tf'")
                                }
                                "KeyLengthExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.KeyLengthExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'KeyLengthExceeded' and tf='$tf'")
                                }
                                "ValueLengthExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ValueLengthExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'ValueLengthExceeded' and tf='$tf'")
                                }
                                "TotalLogLengthExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.TotalLogLengthExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'TotalLogLengthExceeded' and tf='$tf'")
                                }
                                "NumberPromisesExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberPromisesExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'NumberPromisesExceeded' and tf='$tf'")
                                }
                                "NumberInputDataDependenciesExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberInputDataDependenciesExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'NumberInputDataDependenciesExceeded' and tf='$tf'")
                                }
                                "ReturnedValueLengthExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ReturnedValueLengthExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'ReturnedValueLengthExceeded' and tf='$tf'")
                                }
                                "ContractSizeExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ContractSizeExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'ContractSizeExceeded' and tf='$tf'")
                                }
                                "Deprecated" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.Deprecated>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Deprecated' and tf='$tf'")
                                }
                                "ECRecoverError" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ECRecoverError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'ECRecoverError' and tf='$tf'")
                                }
                                "AltBn128InvalidInput" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.AltBn128InvalidInput>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'AltBn128InvalidInput' and tf='$tf'")
                                }
                                "Ed25519VerifyInvalidInput" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.Ed25519VerifyInvalidInput>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Ed25519VerifyInvalidInput' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: BadUTF16
                    // group: BadUTF8
                    // group: GasExceeded
                    // group: GasLimitExceeded
                    // group: BalanceExceeded
                    // group: EmptyMethodName
                    // group: GuestPanic
                    // group: IntegerOverflow
                    // group: InvalidPromiseIndex
                    // group: CannotAppendActionToJointPromise
                    // group: CannotReturnJointPromise
                    // group: InvalidPromiseResultIndex
                    // group: InvalidRegisterId
                    // group: IteratorWasInvalidated
                    // group: MemoryAccessViolation
                    // group: InvalidReceiptIndex
                    // group: InvalidIteratorIndex
                    // group: InvalidAccountId
                    // group: InvalidMethodName
                    // group: InvalidPublicKey
                    // group: ProhibitedInView
                    // group: NumberOfLogsExceeded
                    // group: KeyLengthExceeded
                    // group: ValueLengthExceeded
                    // group: TotalLogLengthExceeded
                    // group: NumberPromisesExceeded
                    // group: NumberInputDataDependenciesExceeded
                    // group: ReturnedValueLengthExceeded
                    // group: ContractSizeExceeded
                    // group: Deprecated
                    // group: ECRecoverError
                    // group: AltBn128InvalidInput
                    // group: Ed25519VerifyInvalidInput

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("GuestPanic")) requiredMatches.add(6)
                    if (jobj.containsKey("InvalidPromiseIndex")) requiredMatches.add(8)
                    if (jobj.containsKey("InvalidPromiseResultIndex")) requiredMatches.add(11)
                    if (jobj.containsKey("InvalidRegisterId")) requiredMatches.add(12)
                    if (jobj.containsKey("IteratorWasInvalidated")) requiredMatches.add(13)
                    if (jobj.containsKey("InvalidReceiptIndex")) requiredMatches.add(15)
                    if (jobj.containsKey("InvalidIteratorIndex")) requiredMatches.add(16)
                    if (jobj.containsKey("ProhibitedInView")) requiredMatches.add(20)
                    if (jobj.containsKey("NumberOfLogsExceeded")) requiredMatches.add(21)
                    if (jobj.containsKey("KeyLengthExceeded")) requiredMatches.add(22)
                    if (jobj.containsKey("ValueLengthExceeded")) requiredMatches.add(23)
                    if (jobj.containsKey("TotalLogLengthExceeded")) requiredMatches.add(24)
                    if (jobj.containsKey("NumberPromisesExceeded")) requiredMatches.add(25)
                    if (jobj.containsKey("NumberInputDataDependenciesExceeded")) requiredMatches.add(26)
                    if (jobj.containsKey("ReturnedValueLengthExceeded")) requiredMatches.add(27)
                    if (jobj.containsKey("ContractSizeExceeded")) requiredMatches.add(28)
                    if (jobj.containsKey("Deprecated")) requiredMatches.add(29)
                    if (jobj.containsKey("ECRecoverError")) requiredMatches.add(30)
                    if (jobj.containsKey("AltBn128InvalidInput")) requiredMatches.add(31)
                    if (jobj.containsKey("Ed25519VerifyInvalidInput")) requiredMatches.add(32)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.BadUTF16>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.BadUTF8>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.GasExceeded>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.GasLimitExceeded>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.BalanceExceeded>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.EmptyMethodName>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.GuestPanic>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.IntegerOverflow>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseIndex>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.CannotAppendActionToJointPromise>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.CannotReturnJointPromise>(), jobj)
                            11 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseResultIndex>(), jobj)
                            12 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidRegisterId>(), jobj)
                            13 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.IteratorWasInvalidated>(), jobj)
                            14 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.MemoryAccessViolation>(), jobj)
                            15 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidReceiptIndex>(), jobj)
                            16 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidIteratorIndex>(), jobj)
                            17 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidAccountId>(), jobj)
                            18 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidMethodName>(), jobj)
                            19 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPublicKey>(), jobj)
                            20 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ProhibitedInView>(), jobj)
                            21 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberOfLogsExceeded>(), jobj)
                            22 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.KeyLengthExceeded>(), jobj)
                            23 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ValueLengthExceeded>(), jobj)
                            24 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.TotalLogLengthExceeded>(), jobj)
                            25 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberPromisesExceeded>(), jobj)
                            26 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberInputDataDependenciesExceeded>(), jobj)
                            27 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ReturnedValueLengthExceeded>(), jobj)
                            28 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ContractSizeExceeded>(), jobj)
                            29 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.Deprecated>(), jobj)
                            30 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ECRecoverError>(), jobj)
                            31 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.AltBn128InvalidInput>(), jobj)
                            32 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.Ed25519VerifyInvalidInput>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 0 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 1 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 2 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 3 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 4 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 5 }
                    run {
                        var matchCount = 0
                        if (jobj["GuestPanic"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 6 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 7 }
                    run {
                        var matchCount = 0
                        if (jobj["InvalidPromiseIndex"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 8 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 9 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 10 }
                    run {
                        var matchCount = 0
                        if (jobj["InvalidPromiseResultIndex"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 11 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["InvalidRegisterId"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 12 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["IteratorWasInvalidated"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 13 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 14 }
                    run {
                        var matchCount = 0
                        if (jobj["InvalidReceiptIndex"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 15 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["InvalidIteratorIndex"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 16 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 17 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 18 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 19 }
                    run {
                        var matchCount = 0
                        if (jobj["ProhibitedInView"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 20 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["NumberOfLogsExceeded"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 21 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["KeyLengthExceeded"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 22 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["ValueLengthExceeded"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 23 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["TotalLogLengthExceeded"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 24 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["NumberPromisesExceeded"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 25 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["NumberInputDataDependenciesExceeded"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 26 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["ReturnedValueLengthExceeded"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 27 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["ContractSizeExceeded"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 28 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["Deprecated"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 29 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["ECRecoverError"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 30 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["AltBn128InvalidInput"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 31 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["Ed25519VerifyInvalidInput"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 32 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.BadUTF16>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.BadUTF8>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.GasExceeded>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.GasLimitExceeded>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.BalanceExceeded>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.EmptyMethodName>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.GuestPanic>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.IntegerOverflow>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseIndex>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.CannotAppendActionToJointPromise>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.CannotReturnJointPromise>(), jobj)
                            11 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseResultIndex>(), jobj)
                            12 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidRegisterId>(), jobj)
                            13 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.IteratorWasInvalidated>(), jobj)
                            14 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.MemoryAccessViolation>(), jobj)
                            15 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidReceiptIndex>(), jobj)
                            16 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidIteratorIndex>(), jobj)
                            17 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidAccountId>(), jobj)
                            18 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidMethodName>(), jobj)
                            19 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPublicKey>(), jobj)
                            20 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ProhibitedInView>(), jobj)
                            21 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberOfLogsExceeded>(), jobj)
                            22 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.KeyLengthExceeded>(), jobj)
                            23 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ValueLengthExceeded>(), jobj)
                            24 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.TotalLogLengthExceeded>(), jobj)
                            25 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberPromisesExceeded>(), jobj)
                            26 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberInputDataDependenciesExceeded>(), jobj)
                            27 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ReturnedValueLengthExceeded>(), jobj)
                            28 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ContractSizeExceeded>(), jobj)
                            29 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.Deprecated>(), jobj)
                            30 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ECRecoverError>(), jobj)
                            31 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.AltBn128InvalidInput>(), jobj)
                            32 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.Ed25519VerifyInvalidInput>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.GuestPanic>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseIndex>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidPromiseResultIndex>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidRegisterId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.IteratorWasInvalidated>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidReceiptIndex>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.InvalidIteratorIndex>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ProhibitedInView>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberOfLogsExceeded>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.KeyLengthExceeded>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ValueLengthExceeded>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.TotalLogLengthExceeded>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberPromisesExceeded>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.NumberInputDataDependenciesExceeded>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ReturnedValueLengthExceeded>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ContractSizeExceeded>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.Deprecated>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.ECRecoverError>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.AltBn128InvalidInput>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError.Ed25519VerifyInvalidInput>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in HostError")
                }
            }
        }
        throw SerializationException("Cannot deserialize HostError with non-JSON decoder")
    }
}
