package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError
import io.github.hosseinkarami_dev.near.rpc.models.RpcError
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientNextBlockResponse
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

public object JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcErrorSerializer : KSerializer<JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError") {
        element("result", serializer<JsonElement>().descriptor)
        element("error", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError.Result -> {
          val map = mutableMapOf<String, JsonElement>()
          map["result"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcLightClientNextBlockResponse>(), value.result)
          map["id"] = jsonEncoder.json.encodeToJsonElement(serializer<String>(), value.id)
          map["jsonrpc"] = jsonEncoder.json.encodeToJsonElement(serializer<String>(), value.jsonrpc)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError.Error -> {
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
      is JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError.Result -> out.encodeSerializableElement(descriptor, 0, serializer<JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError.Result>(), value)
      is JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError.Error -> out.encodeSerializableElement(descriptor, 1, serializer<JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError.Error>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
          }
          throw SerializationException("Unknown discriminator (primitive) for JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError")
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj["result"] != null) {
            val resultVal = decoder.json.decodeFromJsonElement(serializer<RpcLightClientNextBlockResponse>(), jobj["result"] ?: throw SerializationException("Missing field 'result' for variant " + "Result"))
            val idVal = decoder.json.decodeFromJsonElement(serializer<String>(), jobj["id"] ?: throw SerializationException("Missing field 'id' for variant " + "Result"))
            val jsonrpcVal = decoder.json.decodeFromJsonElement(serializer<String>(), jobj["jsonrpc"] ?: throw SerializationException("Missing field 'jsonrpc' for variant " + "Result"))
            return JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError.Result(resultVal, idVal, jsonrpcVal)
          }
          if (jobj["error"] != null) {
            val errorVal = decoder.json.decodeFromJsonElement(serializer<RpcError>(), jobj["error"] ?: throw SerializationException("Missing field 'error' for variant " + "Error"))
            val idVal = decoder.json.decodeFromJsonElement(serializer<String>(), jobj["id"] ?: throw SerializationException("Missing field 'id' for variant " + "Error"))
            val jsonrpcVal = decoder.json.decodeFromJsonElement(serializer<String>(), jobj["jsonrpc"] ?: throw SerializationException("Missing field 'jsonrpc' for variant " + "Error"))
            return JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError.Error(errorVal, idVal, jsonrpcVal)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "result" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError.Result>(), obj)
              }
              "error" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError.Error>(), obj)
              }
              else -> throw SerializationException("Unknown discriminator key for JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError: " + key)
            }
          }
          else {
            var typeField: String? = null
            val discriminatorCandidates = listOf("id", "jsonrpc")
            for (cand in discriminatorCandidates) {
              val candElem = jobj[cand]
              if (candElem is JsonPrimitive) {
                typeField = candElem.contentOrNull
                if (typeField != null) break
              }
            }
            if (typeField == null) {
              val knownVariantNames = setOf("result", "error")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator (one of id/jsonrpc) or recognizable variant in JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError")
            val tf = typeField.trim()
            when (tf) {
              "result" -> {
                return decoder.json.decodeFromJsonElement(serializer<JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError.Result>(), jobj)
              }
              "error" -> {
                return decoder.json.decodeFromJsonElement(serializer<JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError.Error>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError with non-JSON decoder")
  }
}
