package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageConfig
import io.github.hosseinkarami_dev.near.rpc.models.SyncConfig
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

public object SyncConfigSerializer : KSerializer<SyncConfig> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.SyncConfig") {
        element("Peers", serializer<JsonElement>().descriptor)
        element("ExternalStorage", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: SyncConfig) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is SyncConfig.Peers -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("Peers"))
        }
        is SyncConfig.ExternalStorage -> {
          val map = mutableMapOf<String, JsonElement>()
          map["ExternalStorage"] = jsonEncoder.json.encodeToJsonElement(serializer<ExternalStorageConfig>(), value.externalStorage)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is SyncConfig.Peers -> out.encodeSerializableElement(descriptor, 0, serializer<SyncConfig.Peers>(), value)
      is SyncConfig.ExternalStorage -> out.encodeSerializableElement(descriptor, 1, serializer<SyncConfig.ExternalStorage>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): SyncConfig {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            if (s == "Peers") return SyncConfig.Peers
          }
          throw SerializationException("Unknown discriminator (primitive) for SyncConfig")
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing SyncConfig")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj["ExternalStorage"] != null) {
            return SyncConfig.ExternalStorage(decoder.json.decodeFromJsonElement(serializer<ExternalStorageConfig>(), jobj["ExternalStorage"]!!))
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "ExternalStorage" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<SyncConfig.ExternalStorage>(), obj)
              }
              "Peers" -> {
                return SyncConfig.Peers
              }
              else -> throw SerializationException("Unknown discriminator key for SyncConfig: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("Peers", "ExternalStorage")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in SyncConfig")
            val tf = typeField.trim()
            when (tf) {
              "ExternalStorage" -> {
                return decoder.json.decodeFromJsonElement(serializer<SyncConfig.ExternalStorage>(), jobj)
              }
              "Peers" -> return SyncConfig.Peers
              else -> throw SerializationException("Unknown type discriminator for SyncConfig: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize SyncConfig with non-JSON decoder")
  }
}
