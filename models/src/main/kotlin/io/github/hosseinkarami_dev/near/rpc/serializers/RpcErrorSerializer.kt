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
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcError") {
        element("REQUEST_VALIDATION_ERROR", serializer<JsonElement>().descriptor)
        element("HANDLER_ERROR", serializer<JsonElement>().descriptor)
        element("INTERNAL_ERROR", serializer<JsonElement>().descriptor)
      }

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
      is RpcError.RequestValidationError -> out.encodeSerializableElement(descriptor, 0, serializer<RpcError.RequestValidationError>(), value)
      is RpcError.HandlerError -> out.encodeSerializableElement(descriptor, 1, serializer<RpcError.HandlerError>(), value)
      is RpcError.InternalError -> out.encodeSerializableElement(descriptor, 2, serializer<RpcError.InternalError>(), value)
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
          }
          throw SerializationException("Unknown discriminator (primitive) for RpcError")
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
                return decoder.json.decodeFromJsonElement(serializer<RpcError.RequestValidationError>(), obj)
              }
              "HANDLER_ERROR" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcError.HandlerError>(), obj)
              }
              "INTERNAL_ERROR" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcError.InternalError>(), obj)
              }
              else -> throw SerializationException("Unknown discriminator key for RpcError: " + key)
            }
          }
          else {
            var typeField: String? = null
            val discriminatorCandidates = listOf("name")
            for (cand in discriminatorCandidates) {
              val candElem = jobj[cand]
              if (candElem is JsonPrimitive) {
                typeField = candElem.contentOrNull
                if (typeField != null) break
              }
            }
            if (typeField == null) {
              val knownVariantNames = setOf("REQUEST_VALIDATION_ERROR", "HANDLER_ERROR", "INTERNAL_ERROR")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator (one of name) or recognizable variant in RpcError")
            val tf = typeField.trim()
            when (tf) {
              "REQUEST_VALIDATION_ERROR" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcError.RequestValidationError>(), jobj)
              }
              "HANDLER_ERROR" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcError.HandlerError>(), jobj)
              }
              "INTERNAL_ERROR" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcError.InternalError>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for RpcError: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize RpcError with non-JSON decoder")
  }
}
