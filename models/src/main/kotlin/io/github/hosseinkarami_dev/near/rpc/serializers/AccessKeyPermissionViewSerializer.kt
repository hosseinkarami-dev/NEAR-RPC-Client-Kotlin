package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView
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

public object AccessKeyPermissionViewSerializer : KSerializer<AccessKeyPermissionView> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView")

  override fun serialize(encoder: Encoder, `value`: AccessKeyPermissionView) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        AccessKeyPermissionView.FullAccess -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("FullAccess"))
        }
        is AccessKeyPermissionView.FunctionCall -> {
          val map = mutableMapOf<String, JsonElement>()
          map["FunctionCall"] = jsonEncoder.json.encodeToJsonElement(serializer<AccessKeyPermissionView.FunctionCall.FunctionCallPayload>(), value.functionCall)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      AccessKeyPermissionView.FullAccess -> out.encodeStringElement(descriptor, 0, "FullAccess")
      is AccessKeyPermissionView.FunctionCall -> out.encodeSerializableElement(descriptor, 1, serializer<AccessKeyPermissionView.FunctionCall.FunctionCallPayload>(), value.functionCall)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): AccessKeyPermissionView {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            if (s == "FullAccess") return AccessKeyPermissionView.FullAccess
            throw SerializationException("Unknown discriminator string for AccessKeyPermissionView: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing AccessKeyPermissionView")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["FunctionCall"] != null) {
            val functionCallVal = decoder.json.decodeFromJsonElement(serializer<AccessKeyPermissionView.FunctionCall.FunctionCallPayload>(), jobj["FunctionCall"] ?: throw SerializationException("Missing field 'FunctionCall' for variant " + "FunctionCall"))
            return AccessKeyPermissionView.FunctionCall(functionCallVal)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "FunctionCall" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val functionCallVal = decoder.json.decodeFromJsonElement(serializer<AccessKeyPermissionView.FunctionCall.FunctionCallPayload>(), obj["FunctionCall"] ?: throw SerializationException("Missing field 'FunctionCall' for variant " + key))
                return AccessKeyPermissionView.FunctionCall(functionCallVal)
              }
              "FullAccess" -> {
                return AccessKeyPermissionView.FullAccess
              }
              else -> throw SerializationException("Unknown discriminator key for AccessKeyPermissionView: " + key)
            }
          }
          else {
            val typeField = jobj["type"]?.jsonPrimitive?.contentOrNull ?: throw SerializationException("Missing 'type' discriminator in AccessKeyPermissionView")
            when (typeField) {
              "FunctionCall" -> {
                return decoder.json.decodeFromJsonElement(serializer<AccessKeyPermissionView.FunctionCall>(), jobj)
              }
              "FullAccess" -> return AccessKeyPermissionView.FullAccess
              else -> throw SerializationException("Unknown type discriminator for AccessKeyPermissionView: " + typeField)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize AccessKeyPermissionView with non-JSON decoder")
  }
}
