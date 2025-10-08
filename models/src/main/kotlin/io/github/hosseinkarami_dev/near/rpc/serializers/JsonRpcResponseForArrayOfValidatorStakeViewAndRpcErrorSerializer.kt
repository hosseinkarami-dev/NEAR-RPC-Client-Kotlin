package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError
import io.github.hosseinkarami_dev.near.rpc.models.RpcError
import io.github.hosseinkarami_dev.near.rpc.models.ValidatorStakeView
import kotlin.String
import kotlin.collections.mutableMapOf
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
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

public object JsonRpcResponseForArrayOfValidatorStakeViewAndRpcErrorSerializer : KSerializer<JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError")

  override fun serialize(encoder: Encoder, `value`: JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError.Result -> {
          val map = mutableMapOf<String, JsonElement>()
          map["result"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<ValidatorStakeView>()), value.result)
          map["id"] = jsonEncoder.json.encodeToJsonElement(serializer<String>(), value.id)
          map["jsonrpc"] = jsonEncoder.json.encodeToJsonElement(serializer<String>(), value.jsonrpc)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError.Error -> {
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
      is JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError.Result -> out.encodeSerializableElement(descriptor, 0, ListSerializer(serializer<ValidatorStakeView>()), value.result)
      is JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError.Error -> out.encodeSerializableElement(descriptor, 1, serializer<RpcError>(), value.error)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            throw SerializationException("Unknown discriminator string for JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["result"] != null) {
            val resultVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<ValidatorStakeView>()), jobj["result"] ?: throw SerializationException("Missing field 'result' for variant " + "Result"))
            val idVal = decoder.json.decodeFromJsonElement(serializer<String>(), jobj["id"] ?: throw SerializationException("Missing field 'id' for variant " + "Result"))
            val jsonrpcVal = decoder.json.decodeFromJsonElement(serializer<String>(), jobj["jsonrpc"] ?: throw SerializationException("Missing field 'jsonrpc' for variant " + "Result"))
            return JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError.Result(resultVal, idVal, jsonrpcVal)
          }
          if (jobj["error"] != null) {
            val errorVal = decoder.json.decodeFromJsonElement(serializer<RpcError>(), jobj["error"] ?: throw SerializationException("Missing field 'error' for variant " + "Error"))
            val idVal = decoder.json.decodeFromJsonElement(serializer<String>(), jobj["id"] ?: throw SerializationException("Missing field 'id' for variant " + "Error"))
            val jsonrpcVal = decoder.json.decodeFromJsonElement(serializer<String>(), jobj["jsonrpc"] ?: throw SerializationException("Missing field 'jsonrpc' for variant " + "Error"))
            return JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError.Error(errorVal, idVal, jsonrpcVal)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "result" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val resultVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<ValidatorStakeView>()), obj["result"] ?: throw SerializationException("Missing field 'result' for variant " + key))
                val idVal = decoder.json.decodeFromJsonElement(serializer<String>(), obj["id"] ?: throw SerializationException("Missing field 'id' for variant " + key))
                val jsonrpcVal = decoder.json.decodeFromJsonElement(serializer<String>(), obj["jsonrpc"] ?: throw SerializationException("Missing field 'jsonrpc' for variant " + key))
                return JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError.Result(resultVal, idVal, jsonrpcVal)
              }
              "error" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val errorVal = decoder.json.decodeFromJsonElement(serializer<RpcError>(), obj["error"] ?: throw SerializationException("Missing field 'error' for variant " + key))
                val idVal = decoder.json.decodeFromJsonElement(serializer<String>(), obj["id"] ?: throw SerializationException("Missing field 'id' for variant " + key))
                val jsonrpcVal = decoder.json.decodeFromJsonElement(serializer<String>(), obj["jsonrpc"] ?: throw SerializationException("Missing field 'jsonrpc' for variant " + key))
                return JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError.Error(errorVal, idVal, jsonrpcVal)
              }
              else -> throw SerializationException("Unknown discriminator key for JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError: " + key)
            }
          }
          else {
            val discriminatorCandidates = listOf("type", "name")
            var typeField: String? = null
            for (cand in discriminatorCandidates) {
              typeField = jobj[cand]?.jsonPrimitive?.contentOrNull
              if (typeField != null) break
            }
            if (typeField == null) {
              val knownVariantNames = setOf("result", "error")
              for ((k, v) in jobj.entries) {
                if (v is JsonElement && v.jsonPrimitive.isString) {
                    val s = (v as JsonElement).jsonPrimitive.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator (one of type/name) or recognizable variant in JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError")
            val tf = typeField.trim()
            when (tf) {
              "result" -> {
                return decoder.json.decodeFromJsonElement(serializer<JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError.Result>(), jobj)
              }
              "error" -> {
                return decoder.json.decodeFromJsonElement(serializer<JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError.Error>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError with non-JSON decoder")
  }
}
