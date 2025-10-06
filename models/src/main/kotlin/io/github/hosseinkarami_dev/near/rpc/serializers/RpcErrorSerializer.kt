package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.RpcError
import io.github.hosseinkarami_dev.near.rpc.models.RpcRequestValidationErrorKind
import kotlin.Long
import kotlin.String
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

public object RpcErrorSerializer : KSerializer<RpcError> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcError")

  override fun serialize(encoder: Encoder, `value`: RpcError) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is RpcError.RequestValidationError -> {
          val map = mutableMapOf<String, JsonElement>()
          map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcRequestValidationErrorKind>(), value.cause)
          map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcError.RequestValidationError.Name>(), value.name)
          map["code"] = jsonEncoder.json.encodeToJsonElement(serializer<Long>(), value.code)
          if (value.data != null) {
            map["data"] = jsonEncoder.json.encodeToJsonElement(serializer<JsonElement?>(), value.data)
          }
          map["message"] = jsonEncoder.json.encodeToJsonElement(serializer<String>(), value.message)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcError.HandlerError -> {
          val map = mutableMapOf<String, JsonElement>()
          map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<JsonElement>(), value.cause)
          map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcError.HandlerError.Name>(), value.name)
          map["code"] = jsonEncoder.json.encodeToJsonElement(serializer<Long>(), value.code)
          if (value.data != null) {
            map["data"] = jsonEncoder.json.encodeToJsonElement(serializer<JsonElement?>(), value.data)
          }
          map["message"] = jsonEncoder.json.encodeToJsonElement(serializer<String>(), value.message)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcError.InternalError -> {
          val map = mutableMapOf<String, JsonElement>()
          map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<JsonElement>(), value.cause)
          map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcError.InternalError.Name>(), value.name)
          map["code"] = jsonEncoder.json.encodeToJsonElement(serializer<Long>(), value.code)
          if (value.data != null) {
            map["data"] = jsonEncoder.json.encodeToJsonElement(serializer<JsonElement?>(), value.data)
          }
          map["message"] = jsonEncoder.json.encodeToJsonElement(serializer<String>(), value.message)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is RpcError.RequestValidationError -> out.encodeSerializableElement(descriptor, 0, serializer<RpcRequestValidationErrorKind>(), value.cause)
      is RpcError.HandlerError -> out.encodeSerializableElement(descriptor, 1, serializer<JsonElement>(), value.cause)
      is RpcError.InternalError -> out.encodeSerializableElement(descriptor, 2, serializer<JsonElement>(), value.cause)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): RpcError {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            throw SerializationException("Unknown discriminator string for RpcError: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing RpcError")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "REQUEST_VALIDATION_ERROR" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val causeVal = decoder.json.decodeFromJsonElement(serializer<RpcRequestValidationErrorKind>(), obj["cause"] ?: throw SerializationException("Missing field 'cause' for variant " + key))
                val nameVal = decoder.json.decodeFromJsonElement(serializer<RpcError.RequestValidationError.Name>(), obj["name"] ?: throw SerializationException("Missing field 'name' for variant " + key))
                val codeVal = decoder.json.decodeFromJsonElement(serializer<Long>(), obj["code"] ?: throw SerializationException("Missing field 'code' for variant " + key))
                val dataVal = obj["data"]?.let { decoder.json.decodeFromJsonElement(serializer<JsonElement?>(), it) }
                val messageVal = decoder.json.decodeFromJsonElement(serializer<String>(), obj["message"] ?: throw SerializationException("Missing field 'message' for variant " + key))
                return RpcError.RequestValidationError(causeVal, nameVal, codeVal, dataVal, messageVal)
              }
              "HANDLER_ERROR" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val causeVal = decoder.json.decodeFromJsonElement(serializer<JsonElement>(), obj["cause"] ?: throw SerializationException("Missing field 'cause' for variant " + key))
                val nameVal = decoder.json.decodeFromJsonElement(serializer<RpcError.HandlerError.Name>(), obj["name"] ?: throw SerializationException("Missing field 'name' for variant " + key))
                val codeVal = decoder.json.decodeFromJsonElement(serializer<Long>(), obj["code"] ?: throw SerializationException("Missing field 'code' for variant " + key))
                val dataVal = obj["data"]?.let { decoder.json.decodeFromJsonElement(serializer<JsonElement?>(), it) }
                val messageVal = decoder.json.decodeFromJsonElement(serializer<String>(), obj["message"] ?: throw SerializationException("Missing field 'message' for variant " + key))
                return RpcError.HandlerError(causeVal, nameVal, codeVal, dataVal, messageVal)
              }
              "INTERNAL_ERROR" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val causeVal = decoder.json.decodeFromJsonElement(serializer<JsonElement>(), obj["cause"] ?: throw SerializationException("Missing field 'cause' for variant " + key))
                val nameVal = decoder.json.decodeFromJsonElement(serializer<RpcError.InternalError.Name>(), obj["name"] ?: throw SerializationException("Missing field 'name' for variant " + key))
                val codeVal = decoder.json.decodeFromJsonElement(serializer<Long>(), obj["code"] ?: throw SerializationException("Missing field 'code' for variant " + key))
                val dataVal = obj["data"]?.let { decoder.json.decodeFromJsonElement(serializer<JsonElement?>(), it) }
                val messageVal = decoder.json.decodeFromJsonElement(serializer<String>(), obj["message"] ?: throw SerializationException("Missing field 'message' for variant " + key))
                return RpcError.InternalError(causeVal, nameVal, codeVal, dataVal, messageVal)
              }
              else -> throw SerializationException("Unknown discriminator key for RpcError: " + key)
            }
          }
          else {
            val typeField = jobj["type"]?.jsonPrimitive?.contentOrNull ?: throw SerializationException("Missing 'type' discriminator in RpcError")
            when (typeField) {
              "REQUEST_VALIDATION_ERROR" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcError.RequestValidationError>(), jobj)
              }
              "HANDLER_ERROR" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcError.HandlerError>(), jobj)
              }
              "INTERNAL_ERROR" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcError.InternalError>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for RpcError: " + typeField)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize RpcError with non-JSON decoder")
  }
}
