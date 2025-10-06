package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.ActionError
import io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError
import io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError
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

public object TxExecutionErrorSerializer : KSerializer<TxExecutionError> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError")

  override fun serialize(encoder: Encoder, `value`: TxExecutionError) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is TxExecutionError.ActionError -> {
          val map = mutableMapOf<String, JsonElement>()
          map["ActionError"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionError>(), value.actionError)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is TxExecutionError.InvalidTxError -> {
          val map = mutableMapOf<String, JsonElement>()
          map["InvalidTxError"] = jsonEncoder.json.encodeToJsonElement(serializer<InvalidTxError>(), value.invalidTxError)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is TxExecutionError.ActionError -> out.encodeSerializableElement(descriptor, 0, serializer<ActionError>(), value.actionError)
      is TxExecutionError.InvalidTxError -> out.encodeSerializableElement(descriptor, 1, serializer<InvalidTxError>(), value.invalidTxError)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): TxExecutionError {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            throw SerializationException("Unknown discriminator string for TxExecutionError: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing TxExecutionError")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["ActionError"] != null) {
            val actionErrorVal = decoder.json.decodeFromJsonElement(serializer<ActionError>(), jobj["ActionError"] ?: throw SerializationException("Missing field 'ActionError' for variant " + "ActionError"))
            return TxExecutionError.ActionError(actionErrorVal)
          }
          if (jobj["InvalidTxError"] != null) {
            val invalidTxErrorVal = decoder.json.decodeFromJsonElement(serializer<InvalidTxError>(), jobj["InvalidTxError"] ?: throw SerializationException("Missing field 'InvalidTxError' for variant " + "InvalidTxError"))
            return TxExecutionError.InvalidTxError(invalidTxErrorVal)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "ActionError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val actionErrorVal = decoder.json.decodeFromJsonElement(serializer<ActionError>(), obj["ActionError"] ?: throw SerializationException("Missing field 'ActionError' for variant " + key))
                return TxExecutionError.ActionError(actionErrorVal)
              }
              "InvalidTxError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val invalidTxErrorVal = decoder.json.decodeFromJsonElement(serializer<InvalidTxError>(), obj["InvalidTxError"] ?: throw SerializationException("Missing field 'InvalidTxError' for variant " + key))
                return TxExecutionError.InvalidTxError(invalidTxErrorVal)
              }
              else -> throw SerializationException("Unknown discriminator key for TxExecutionError: " + key)
            }
          }
          else {
            val typeField = jobj["type"]?.jsonPrimitive?.contentOrNull ?: throw SerializationException("Missing 'type' discriminator in TxExecutionError")
            when (typeField) {
              "ActionError" -> {
                return decoder.json.decodeFromJsonElement(serializer<TxExecutionError.ActionError>(), jobj)
              }
              "InvalidTxError" -> {
                return decoder.json.decodeFromJsonElement(serializer<TxExecutionError.InvalidTxError>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for TxExecutionError: " + typeField)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize TxExecutionError with non-JSON decoder")
  }
}
