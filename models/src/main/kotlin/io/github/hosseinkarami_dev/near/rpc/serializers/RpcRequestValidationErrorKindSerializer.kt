package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.RpcRequestValidationErrorKind
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

public object RpcRequestValidationErrorKindSerializer : KSerializer<RpcRequestValidationErrorKind> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcRequestValidationErrorKind") {
        element("METHOD_NOT_FOUND", serializer<JsonElement>().descriptor)
        element("PARSE_ERROR", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: RpcRequestValidationErrorKind) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is RpcRequestValidationErrorKind.MethodNotFound -> {
          val map = mutableMapOf<String, JsonElement>()
          map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcRequestValidationErrorKind.MethodNotFound.InfoPayload>(), value.info)
          map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcRequestValidationErrorKind.MethodNotFound.Name>(), value.name)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcRequestValidationErrorKind.ParseError -> {
          val map = mutableMapOf<String, JsonElement>()
          map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcRequestValidationErrorKind.ParseError.InfoPayload>(), value.info)
          map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcRequestValidationErrorKind.ParseError.Name>(), value.name)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is RpcRequestValidationErrorKind.MethodNotFound -> out.encodeSerializableElement(descriptor, 0, serializer<RpcRequestValidationErrorKind.MethodNotFound>(), value)
      is RpcRequestValidationErrorKind.ParseError -> out.encodeSerializableElement(descriptor, 1, serializer<RpcRequestValidationErrorKind.ParseError>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): RpcRequestValidationErrorKind {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            throw SerializationException("Unknown discriminator string for RpcRequestValidationErrorKind: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing RpcRequestValidationErrorKind")
        }
        is JsonObject -> {
          val jobj = element
          if (listOf("info", "name").all { jobj[it] != null }) {
            // ambiguous required-keys group; skipping disambiguation here to avoid wrong decode
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "METHOD_NOT_FOUND" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcRequestValidationErrorKind.MethodNotFound>(), obj)
              }
              "PARSE_ERROR" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcRequestValidationErrorKind.ParseError>(), obj)
              }
              else -> throw SerializationException("Unknown discriminator key for RpcRequestValidationErrorKind: " + key)
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
              val knownVariantNames = setOf("METHOD_NOT_FOUND", "PARSE_ERROR")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator (one of name) or recognizable variant in RpcRequestValidationErrorKind")
            val tf = typeField.trim()
            when (tf) {
              "METHOD_NOT_FOUND" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcRequestValidationErrorKind.MethodNotFound>(), jobj)
              }
              "PARSE_ERROR" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcRequestValidationErrorKind.ParseError>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for RpcRequestValidationErrorKind: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize RpcRequestValidationErrorKind with non-JSON decoder")
  }
}
