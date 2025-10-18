package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.ShardLayout
import io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV0
import io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV1
import io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV2
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

public object ShardLayoutSerializer : KSerializer<ShardLayout> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ShardLayout") {
        element("V0", serializer<JsonElement>().descriptor)
        element("V1", serializer<JsonElement>().descriptor)
        element("V2", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: ShardLayout) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is ShardLayout.V0 -> {
          val map = mutableMapOf<String, JsonElement>()
          map["V0"] = jsonEncoder.json.encodeToJsonElement(serializer<ShardLayoutV0>(), value.v0)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ShardLayout.V1 -> {
          val map = mutableMapOf<String, JsonElement>()
          map["V1"] = jsonEncoder.json.encodeToJsonElement(serializer<ShardLayoutV1>(), value.v1)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ShardLayout.V2 -> {
          val map = mutableMapOf<String, JsonElement>()
          map["V2"] = jsonEncoder.json.encodeToJsonElement(serializer<ShardLayoutV2>(), value.v2)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is ShardLayout.V0 -> out.encodeSerializableElement(descriptor, 0, serializer<ShardLayout.V0>(), value)
      is ShardLayout.V1 -> out.encodeSerializableElement(descriptor, 1, serializer<ShardLayout.V1>(), value)
      is ShardLayout.V2 -> out.encodeSerializableElement(descriptor, 2, serializer<ShardLayout.V2>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): ShardLayout {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
          }
          throw SerializationException("Unknown discriminator (primitive) for ShardLayout")
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing ShardLayout")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj["V0"] != null) {
            return ShardLayout.V0(decoder.json.decodeFromJsonElement(serializer<ShardLayoutV0>(), jobj["V0"]!!))
          }
          if (jobj["V1"] != null) {
            return ShardLayout.V1(decoder.json.decodeFromJsonElement(serializer<ShardLayoutV1>(), jobj["V1"]!!))
          }
          if (jobj["V2"] != null) {
            return ShardLayout.V2(decoder.json.decodeFromJsonElement(serializer<ShardLayoutV2>(), jobj["V2"]!!))
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "V0" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ShardLayout.V0>(), obj)
              }
              "V1" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ShardLayout.V1>(), obj)
              }
              "V2" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ShardLayout.V2>(), obj)
              }
              else -> throw SerializationException("Unknown discriminator key for ShardLayout: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("V0", "V1", "V2")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in ShardLayout")
            val tf = typeField.trim()
            when (tf) {
              "V0" -> {
                return decoder.json.decodeFromJsonElement(serializer<ShardLayout.V0>(), jobj)
              }
              "V1" -> {
                return decoder.json.decodeFromJsonElement(serializer<ShardLayout.V1>(), jobj)
              }
              "V2" -> {
                return decoder.json.decodeFromJsonElement(serializer<ShardLayout.V2>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for ShardLayout: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize ShardLayout with non-JSON decoder")
  }
}
