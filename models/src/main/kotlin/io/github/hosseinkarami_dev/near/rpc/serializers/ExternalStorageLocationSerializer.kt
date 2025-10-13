package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation
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

public object ExternalStorageLocationSerializer : KSerializer<ExternalStorageLocation> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation") {
        element("S3", serializer<JsonElement>().descriptor)
        element("Filesystem", serializer<JsonElement>().descriptor)
        element("GCS", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: ExternalStorageLocation) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is ExternalStorageLocation.S3 -> {
          val map = mutableMapOf<String, JsonElement>()
          map["S3"] = jsonEncoder.json.encodeToJsonElement(serializer<ExternalStorageLocation.S3.S3Payload>(), value.s3)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ExternalStorageLocation.Filesystem -> {
          val map = mutableMapOf<String, JsonElement>()
          map["Filesystem"] = jsonEncoder.json.encodeToJsonElement(serializer<ExternalStorageLocation.Filesystem.FilesystemPayload>(), value.filesystem)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ExternalStorageLocation.Gcs -> {
          val map = mutableMapOf<String, JsonElement>()
          map["GCS"] = jsonEncoder.json.encodeToJsonElement(serializer<ExternalStorageLocation.Gcs.GcsPayload>(), value.gcs)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is ExternalStorageLocation.S3 -> out.encodeSerializableElement(descriptor, 0, serializer<ExternalStorageLocation.S3>(), value)
      is ExternalStorageLocation.Filesystem -> out.encodeSerializableElement(descriptor, 1, serializer<ExternalStorageLocation.Filesystem>(), value)
      is ExternalStorageLocation.Gcs -> out.encodeSerializableElement(descriptor, 2, serializer<ExternalStorageLocation.Gcs>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): ExternalStorageLocation {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
          }
          throw SerializationException("Unknown discriminator (primitive) for ExternalStorageLocation")
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing ExternalStorageLocation")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj["S3"] != null) {
            return ExternalStorageLocation.S3(decoder.json.decodeFromJsonElement(serializer<ExternalStorageLocation.S3.S3Payload>(), jobj["S3"]!!))
          }
          if (jobj["Filesystem"] != null) {
            return ExternalStorageLocation.Filesystem(decoder.json.decodeFromJsonElement(serializer<ExternalStorageLocation.Filesystem.FilesystemPayload>(), jobj["Filesystem"]!!))
          }
          if (jobj["GCS"] != null) {
            return ExternalStorageLocation.Gcs(decoder.json.decodeFromJsonElement(serializer<ExternalStorageLocation.Gcs.GcsPayload>(), jobj["GCS"]!!))
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "S3" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ExternalStorageLocation.S3>(), obj)
              }
              "Filesystem" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ExternalStorageLocation.Filesystem>(), obj)
              }
              "GCS" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ExternalStorageLocation.Gcs>(), obj)
              }
              else -> throw SerializationException("Unknown discriminator key for ExternalStorageLocation: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("S3", "Filesystem", "GCS")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in ExternalStorageLocation")
            val tf = typeField.trim()
            when (tf) {
              "S3" -> {
                return decoder.json.decodeFromJsonElement(serializer<ExternalStorageLocation.S3>(), jobj)
              }
              "Filesystem" -> {
                return decoder.json.decodeFromJsonElement(serializer<ExternalStorageLocation.Filesystem>(), jobj)
              }
              "GCS" -> {
                return decoder.json.decodeFromJsonElement(serializer<ExternalStorageLocation.Gcs>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for ExternalStorageLocation: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize ExternalStorageLocation with non-JSON decoder")
  }
}
