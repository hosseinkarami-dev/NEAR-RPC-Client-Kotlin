package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcTransactionResponseAndRpcError
import io.github.hosseinkarami_dev.near.rpc.models.RpcError
import io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse
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

public object JsonRpcResponseForRpcTransactionResponseAndRpcErrorSerializer : KSerializer<JsonRpcResponseForRpcTransactionResponseAndRpcError> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcTransactionResponseAndRpcError")

  override fun serialize(encoder: Encoder, `value`: JsonRpcResponseForRpcTransactionResponseAndRpcError) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is JsonRpcResponseForRpcTransactionResponseAndRpcError.Result -> {
          val map = mutableMapOf<String, JsonElement>()
          map["result"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcTransactionResponse>(), value.result)
          map["id"] = jsonEncoder.json.encodeToJsonElement(serializer<String>(), value.id)
          map["jsonrpc"] = jsonEncoder.json.encodeToJsonElement(serializer<String>(), value.jsonrpc)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is JsonRpcResponseForRpcTransactionResponseAndRpcError.Error -> {
          val map = mutableMapOf<String, JsonElement>()
          map["error"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcError>(), value.error)
          map["id"] = jsonEncoder.json.encodeToJsonElement(serializer<String>(), value.id)
          map["jsonrpc"] = jsonEncoder.json.encodeToJsonElement(serializer<String>(), value.jsonrpc)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is JsonRpcResponseForRpcTransactionResponseAndRpcError.Result -> out.encodeSerializableElement(descriptor, 0, serializer<RpcTransactionResponse>(), value.result)
      is JsonRpcResponseForRpcTransactionResponseAndRpcError.Error -> out.encodeSerializableElement(descriptor, 1, serializer<RpcError>(), value.error)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): JsonRpcResponseForRpcTransactionResponseAndRpcError {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            throw SerializationException("Unknown discriminator string for JsonRpcResponseForRpcTransactionResponseAndRpcError: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing JsonRpcResponseForRpcTransactionResponseAndRpcError")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["result"] != null) {
            val resultVal = decoder.json.decodeFromJsonElement(serializer<RpcTransactionResponse>(), jobj["result"] ?: throw SerializationException("Missing field 'result' for variant " + "Result"))
            val idVal = decoder.json.decodeFromJsonElement(serializer<String>(), jobj["id"] ?: throw SerializationException("Missing field 'id' for variant " + "Result"))
            val jsonrpcVal = decoder.json.decodeFromJsonElement(serializer<String>(), jobj["jsonrpc"] ?: throw SerializationException("Missing field 'jsonrpc' for variant " + "Result"))
            return JsonRpcResponseForRpcTransactionResponseAndRpcError.Result(resultVal, idVal, jsonrpcVal)
          }
          if (jobj["error"] != null) {
            val errorVal = decoder.json.decodeFromJsonElement(serializer<RpcError>(), jobj["error"] ?: throw SerializationException("Missing field 'error' for variant " + "Error"))
            val idVal = decoder.json.decodeFromJsonElement(serializer<String>(), jobj["id"] ?: throw SerializationException("Missing field 'id' for variant " + "Error"))
            val jsonrpcVal = decoder.json.decodeFromJsonElement(serializer<String>(), jobj["jsonrpc"] ?: throw SerializationException("Missing field 'jsonrpc' for variant " + "Error"))
            return JsonRpcResponseForRpcTransactionResponseAndRpcError.Error(errorVal, idVal, jsonrpcVal)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "result" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val resultVal = decoder.json.decodeFromJsonElement(serializer<RpcTransactionResponse>(), obj["result"] ?: throw SerializationException("Missing field 'result' for variant " + key))
                val idVal = decoder.json.decodeFromJsonElement(serializer<String>(), obj["id"] ?: throw SerializationException("Missing field 'id' for variant " + key))
                val jsonrpcVal = decoder.json.decodeFromJsonElement(serializer<String>(), obj["jsonrpc"] ?: throw SerializationException("Missing field 'jsonrpc' for variant " + key))
                return JsonRpcResponseForRpcTransactionResponseAndRpcError.Result(resultVal, idVal, jsonrpcVal)
              }
              "error" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val errorVal = decoder.json.decodeFromJsonElement(serializer<RpcError>(), obj["error"] ?: throw SerializationException("Missing field 'error' for variant " + key))
                val idVal = decoder.json.decodeFromJsonElement(serializer<String>(), obj["id"] ?: throw SerializationException("Missing field 'id' for variant " + key))
                val jsonrpcVal = decoder.json.decodeFromJsonElement(serializer<String>(), obj["jsonrpc"] ?: throw SerializationException("Missing field 'jsonrpc' for variant " + key))
                return JsonRpcResponseForRpcTransactionResponseAndRpcError.Error(errorVal, idVal, jsonrpcVal)
              }
              else -> throw SerializationException("Unknown discriminator key for JsonRpcResponseForRpcTransactionResponseAndRpcError: " + key)
            }
          }
          else {
            val typeField = jobj["type"]?.jsonPrimitive?.contentOrNull ?: throw SerializationException("Missing 'type' discriminator in JsonRpcResponseForRpcTransactionResponseAndRpcError")
            when (typeField) {
              "result" -> {
                return decoder.json.decodeFromJsonElement(serializer<JsonRpcResponseForRpcTransactionResponseAndRpcError.Result>(), jobj)
              }
              "error" -> {
                return decoder.json.decodeFromJsonElement(serializer<JsonRpcResponseForRpcTransactionResponseAndRpcError.Error>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for JsonRpcResponseForRpcTransactionResponseAndRpcError: " + typeField)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize JsonRpcResponseForRpcTransactionResponseAndRpcError with non-JSON decoder")
  }
}
