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
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ShardLayout")

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
      is ShardLayout.V0 -> out.encodeSerializableElement(descriptor, 0, serializer<ShardLayoutV0>(), value.v0)
      is ShardLayout.V1 -> out.encodeSerializableElement(descriptor, 1, serializer<ShardLayoutV1>(), value.v1)
      is ShardLayout.V2 -> out.encodeSerializableElement(descriptor, 2, serializer<ShardLayoutV2>(), value.v2)
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
            throw SerializationException("Unknown discriminator string for ShardLayout: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing ShardLayout")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["V0"] != null) {
            val v0Val = decoder.json.decodeFromJsonElement(serializer<ShardLayoutV0>(), jobj["V0"] ?: throw SerializationException("Missing field 'V0' for variant " + "V0"))
            return ShardLayout.V0(v0Val)
          }
          if (jobj["V1"] != null) {
            val v1Val = decoder.json.decodeFromJsonElement(serializer<ShardLayoutV1>(), jobj["V1"] ?: throw SerializationException("Missing field 'V1' for variant " + "V1"))
            return ShardLayout.V1(v1Val)
          }
          if (jobj["V2"] != null) {
            val v2Val = decoder.json.decodeFromJsonElement(serializer<ShardLayoutV2>(), jobj["V2"] ?: throw SerializationException("Missing field 'V2' for variant " + "V2"))
            return ShardLayout.V2(v2Val)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "V0" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val v0Val = decoder.json.decodeFromJsonElement(serializer<ShardLayoutV0>(), obj["V0"] ?: throw SerializationException("Missing field 'V0' for variant " + key))
                return ShardLayout.V0(v0Val)
              }
              "V1" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val v1Val = decoder.json.decodeFromJsonElement(serializer<ShardLayoutV1>(), obj["V1"] ?: throw SerializationException("Missing field 'V1' for variant " + key))
                return ShardLayout.V1(v1Val)
              }
              "V2" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val v2Val = decoder.json.decodeFromJsonElement(serializer<ShardLayoutV2>(), obj["V2"] ?: throw SerializationException("Missing field 'V2' for variant " + key))
                return ShardLayout.V2(v2Val)
              }
              else -> throw SerializationException("Unknown discriminator key for ShardLayout: " + key)
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
              val knownVariantNames = setOf("V0", "V1", "V2")
              for ((k, v) in jobj.entries) {
                if (v is JsonElement && v.jsonPrimitive.isString) {
                    val s = (v as JsonElement).jsonPrimitive.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator (one of type/name) or recognizable variant in ShardLayout")
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
