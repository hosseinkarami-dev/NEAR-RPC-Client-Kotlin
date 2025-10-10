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
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation")

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
      is ExternalStorageLocation.S3 -> out.encodeSerializableElement(descriptor, 0, serializer<ExternalStorageLocation.S3.S3Payload>(), value.s3)
      is ExternalStorageLocation.Filesystem -> out.encodeSerializableElement(descriptor, 1, serializer<ExternalStorageLocation.Filesystem.FilesystemPayload>(), value.filesystem)
      is ExternalStorageLocation.Gcs -> out.encodeSerializableElement(descriptor, 2, serializer<ExternalStorageLocation.Gcs.GcsPayload>(), value.gcs)
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
            throw SerializationException("Unknown discriminator string for ExternalStorageLocation: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing ExternalStorageLocation")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["S3"] != null) {
            val s3Val = decoder.json.decodeFromJsonElement(serializer<ExternalStorageLocation.S3.S3Payload>(), jobj["S3"] ?: throw SerializationException("Missing field 'S3' for variant " + "S3"))
            return ExternalStorageLocation.S3(s3Val)
          }
          if (jobj["Filesystem"] != null) {
            val filesystemVal = decoder.json.decodeFromJsonElement(serializer<ExternalStorageLocation.Filesystem.FilesystemPayload>(), jobj["Filesystem"] ?: throw SerializationException("Missing field 'Filesystem' for variant " + "Filesystem"))
            return ExternalStorageLocation.Filesystem(filesystemVal)
          }
          if (jobj["GCS"] != null) {
            val gcsVal = decoder.json.decodeFromJsonElement(serializer<ExternalStorageLocation.Gcs.GcsPayload>(), jobj["GCS"] ?: throw SerializationException("Missing field 'GCS' for variant " + "Gcs"))
            return ExternalStorageLocation.Gcs(gcsVal)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "S3" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val s3Val = decoder.json.decodeFromJsonElement(serializer<ExternalStorageLocation.S3.S3Payload>(), obj["S3"] ?: throw SerializationException("Missing field 'S3' for variant " + key))
                return ExternalStorageLocation.S3(s3Val)
              }
              "Filesystem" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val filesystemVal = decoder.json.decodeFromJsonElement(serializer<ExternalStorageLocation.Filesystem.FilesystemPayload>(), obj["Filesystem"] ?: throw SerializationException("Missing field 'Filesystem' for variant " + key))
                return ExternalStorageLocation.Filesystem(filesystemVal)
              }
              "GCS" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val gcsVal = decoder.json.decodeFromJsonElement(serializer<ExternalStorageLocation.Gcs.GcsPayload>(), obj["GCS"] ?: throw SerializationException("Missing field 'GCS' for variant " + key))
                return ExternalStorageLocation.Gcs(gcsVal)
              }
              else -> throw SerializationException("Unknown discriminator key for ExternalStorageLocation: " + key)
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
              val knownVariantNames = setOf("S3", "Filesystem", "GCS")
              for ((k, v) in jobj.entries) {
                if (v is JsonElement && v.jsonPrimitive.isString) {
                    val s = (v as JsonElement).jsonPrimitive.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator (one of type/name) or recognizable variant in ExternalStorageLocation")
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
