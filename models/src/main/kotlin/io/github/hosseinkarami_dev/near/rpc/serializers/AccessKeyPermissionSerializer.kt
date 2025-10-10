package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission
import io.github.hosseinkarami_dev.near.rpc.models.FunctionCallPermission
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

public object AccessKeyPermissionSerializer : KSerializer<AccessKeyPermission> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission")

  override fun serialize(encoder: Encoder, `value`: AccessKeyPermission) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        AccessKeyPermission.FullAccess -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("FullAccess"))
        }
        is AccessKeyPermission.FunctionCall -> {
          val map = mutableMapOf<String, JsonElement>()
          map["FunctionCall"] = jsonEncoder.json.encodeToJsonElement(serializer<FunctionCallPermission>(), value.functionCall)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is AccessKeyPermission.FunctionCall -> out.encodeSerializableElement(descriptor, 0, serializer<FunctionCallPermission>(), value.functionCall)
      AccessKeyPermission.FullAccess -> out.encodeStringElement(descriptor, 1, "FullAccess")
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): AccessKeyPermission {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            if (s == "FullAccess") return AccessKeyPermission.FullAccess
            throw SerializationException("Unknown discriminator string for AccessKeyPermission: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing AccessKeyPermission")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["FunctionCall"] != null) {
            val functionCallVal = decoder.json.decodeFromJsonElement(serializer<FunctionCallPermission>(), jobj["FunctionCall"] ?: throw SerializationException("Missing field 'FunctionCall' for variant " + "FunctionCall"))
            return AccessKeyPermission.FunctionCall(functionCallVal)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "FunctionCall" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val functionCallVal = decoder.json.decodeFromJsonElement(serializer<FunctionCallPermission>(), obj["FunctionCall"] ?: throw SerializationException("Missing field 'FunctionCall' for variant " + key))
                return AccessKeyPermission.FunctionCall(functionCallVal)
              }
              "FullAccess" -> {
                return AccessKeyPermission.FullAccess
              }
              else -> throw SerializationException("Unknown discriminator key for AccessKeyPermission: " + key)
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
              val knownVariantNames = setOf("FunctionCall", "FullAccess")
              for ((k, v) in jobj.entries) {
                if (v is JsonElement && v.jsonPrimitive.isString) {
                    val s = (v as JsonElement).jsonPrimitive.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator (one of type/name) or recognizable variant in AccessKeyPermission")
            val tf = typeField.trim()
            when (tf) {
              "FunctionCall" -> {
                return decoder.json.decodeFromJsonElement(serializer<AccessKeyPermission.FunctionCall>(), jobj)
              }
              "FullAccess" -> return AccessKeyPermission.FullAccess
              else -> throw SerializationException("Unknown type discriminator for AccessKeyPermission: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize AccessKeyPermission with non-JSON decoder")
  }
}
