package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView
import io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError
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

public object ExecutionStatusViewSerializer : KSerializer<ExecutionStatusView> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView") {
        element("Unknown", serializer<JsonElement>().descriptor)
        element("Failure", serializer<JsonElement>().descriptor)
        element("SuccessValue", serializer<JsonElement>().descriptor)
        element("SuccessReceiptId", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: ExecutionStatusView) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is ExecutionStatusView.Unknown -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("Unknown"))
        }
        is ExecutionStatusView.Failure -> {
          val map = mutableMapOf<String, JsonElement>()
          map["Failure"] = jsonEncoder.json.encodeToJsonElement(serializer<TxExecutionError>(), value.failure)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ExecutionStatusView.SuccessValue -> {
          val map = mutableMapOf<String, JsonElement>()
          map["SuccessValue"] = jsonEncoder.json.encodeToJsonElement(serializer<String>(), value.successValue)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ExecutionStatusView.SuccessReceiptId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["SuccessReceiptId"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.successReceiptId)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is ExecutionStatusView.Unknown -> out.encodeSerializableElement(descriptor, 0, serializer<ExecutionStatusView.Unknown>(), value)
      is ExecutionStatusView.Failure -> out.encodeSerializableElement(descriptor, 1, serializer<ExecutionStatusView.Failure>(), value)
      is ExecutionStatusView.SuccessValue -> out.encodeSerializableElement(descriptor, 2, serializer<ExecutionStatusView.SuccessValue>(), value)
      is ExecutionStatusView.SuccessReceiptId -> out.encodeSerializableElement(descriptor, 3, serializer<ExecutionStatusView.SuccessReceiptId>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): ExecutionStatusView {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            if (s == "Unknown") return ExecutionStatusView.Unknown
          }
          throw SerializationException("Unknown discriminator (primitive) for ExecutionStatusView")
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing ExecutionStatusView")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj["Failure"] != null) {
            return ExecutionStatusView.Failure(decoder.json.decodeFromJsonElement(serializer<TxExecutionError>(), jobj["Failure"]!!))
          }
          if (jobj["SuccessValue"] != null) {
            return ExecutionStatusView.SuccessValue(decoder.json.decodeFromJsonElement(serializer<String>(), jobj["SuccessValue"]!!))
          }
          if (jobj["SuccessReceiptId"] != null) {
            return ExecutionStatusView.SuccessReceiptId(decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), jobj["SuccessReceiptId"]!!))
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "Failure" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ExecutionStatusView.Failure>(), obj)
              }
              "SuccessValue" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ExecutionStatusView.SuccessValue>(), obj)
              }
              "SuccessReceiptId" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ExecutionStatusView.SuccessReceiptId>(), obj)
              }
              "Unknown" -> {
                return ExecutionStatusView.Unknown
              }
              else -> throw SerializationException("Unknown discriminator key for ExecutionStatusView: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("Unknown", "Failure", "SuccessValue", "SuccessReceiptId")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in ExecutionStatusView")
            val tf = typeField.trim()
            when (tf) {
              "Failure" -> {
                return decoder.json.decodeFromJsonElement(serializer<ExecutionStatusView.Failure>(), jobj)
              }
              "SuccessValue" -> {
                return decoder.json.decodeFromJsonElement(serializer<ExecutionStatusView.SuccessValue>(), jobj)
              }
              "SuccessReceiptId" -> {
                return decoder.json.decodeFromJsonElement(serializer<ExecutionStatusView.SuccessReceiptId>(), jobj)
              }
              "Unknown" -> return ExecutionStatusView.Unknown
              else -> throw SerializationException("Unknown type discriminator for ExecutionStatusView: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize ExecutionStatusView with non-JSON decoder")
  }
}
