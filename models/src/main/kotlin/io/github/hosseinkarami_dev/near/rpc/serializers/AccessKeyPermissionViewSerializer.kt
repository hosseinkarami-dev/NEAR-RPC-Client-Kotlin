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
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView") {
        element("FullAccess", serializer<JsonElement>().descriptor)
        element("FunctionCall", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: AccessKeyPermissionView) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is AccessKeyPermissionView.FullAccess -> {
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
      is AccessKeyPermissionView.FullAccess -> out.encodeSerializableElement(descriptor, 0, serializer<AccessKeyPermissionView.FullAccess>(), value)
      is AccessKeyPermissionView.FunctionCall -> out.encodeSerializableElement(descriptor, 1, serializer<AccessKeyPermissionView.FunctionCall>(), value)
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
            if (s == "FullAccess") return AccessKeyPermissionView.FullAccess()
          }
          throw SerializationException("Unknown discriminator (primitive) for AccessKeyPermissionView")
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing AccessKeyPermissionView")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj["FunctionCall"] != null) {
            return AccessKeyPermissionView.FunctionCall(decoder.json.decodeFromJsonElement(serializer<AccessKeyPermissionView.FunctionCall.FunctionCallPayload>(), jobj["FunctionCall"]!!))
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "FunctionCall" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<AccessKeyPermissionView.FunctionCall>(), obj)
              }
              "FullAccess" -> {
                return AccessKeyPermissionView.FullAccess()
              }
              else -> throw SerializationException("Unknown discriminator key for AccessKeyPermissionView: " + key)
            }
          }
          else {
            var typeField: String? = null
            val discriminatorCandidates = listOf("FunctionCall")
            for (cand in discriminatorCandidates) {
              val candElem = jobj[cand]
              if (candElem is JsonPrimitive) {
                typeField = candElem.contentOrNull
                if (typeField != null) break
              }
            }
            if (typeField == null) {
              val knownVariantNames = setOf("FullAccess", "FunctionCall")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator (one of FunctionCall) or recognizable variant in AccessKeyPermissionView")
            val tf = typeField.trim()
            when (tf) {
              "FunctionCall" -> {
                return decoder.json.decodeFromJsonElement(serializer<AccessKeyPermissionView.FunctionCall>(), jobj)
              }
              "FullAccess" -> return AccessKeyPermissionView.FullAccess()
              else -> throw SerializationException("Unknown type discriminator for AccessKeyPermissionView: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize AccessKeyPermissionView with non-JSON decoder")
  }
}
