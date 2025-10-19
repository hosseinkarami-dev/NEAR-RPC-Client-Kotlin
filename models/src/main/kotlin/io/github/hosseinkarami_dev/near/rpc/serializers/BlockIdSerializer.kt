package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.BlockId
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import java.lang.Exception
import kotlin.ULong
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

public object BlockIdSerializer : KSerializer<BlockId> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.BlockId") {
        element("block_height", serializer<JsonElement>().descriptor)
        element("CryptoHash", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: BlockId) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is BlockId.BlockHeight -> {
          val innerElem = jsonEncoder.json.encodeToJsonElement(serializer<ULong>(), value.value)
          jsonEncoder.encodeJsonElement(innerElem)
        }
        is BlockId.CryptoHash -> {
          val innerElem = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.value)
          jsonEncoder.encodeJsonElement(innerElem)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is BlockId.BlockHeight -> out.encodeSerializableElement(descriptor, 0, serializer<BlockId.BlockHeight>(), value)
      is BlockId.CryptoHash -> out.encodeSerializableElement(descriptor, 1, serializer<BlockId.CryptoHash>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): BlockId {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
          }
          try {
            val payload = decoder.json.decodeFromJsonElement(serializer<ULong>(), element)
            return BlockId.BlockHeight(payload)
          } catch (_: Exception) {
            // not this variant — try next
          }
          try {
            val payload = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), element)
            return BlockId.CryptoHash(payload)
          } catch (_: Exception) {
            // not this variant — try next
          }
          throw SerializationException("Unknown discriminator (primitive) for BlockId")
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing BlockId")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj["block_height"] != null) {
            return BlockId.BlockHeight(decoder.json.decodeFromJsonElement(serializer<ULong>(), jobj["block_height"]!!))
          }
          if (jobj["CryptoHash"] != null) {
            return BlockId.CryptoHash(decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), jobj["CryptoHash"]!!))
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "block_height" -> {
                return BlockId.BlockHeight(decoder.json.decodeFromJsonElement(serializer<ULong>(), valueElem))
              }
              "CryptoHash" -> {
                return BlockId.CryptoHash(decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), valueElem))
              }
              else -> throw SerializationException("Unknown discriminator key for BlockId: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("block_height", "CryptoHash")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in BlockId")
            val tf = typeField.trim()
            when (tf) {
              "block_height" -> {
                val payloadElem = jobj["value"] ?: throw SerializationException("Missing field 'value' for variant " + tf)
                return BlockId.BlockHeight(decoder.json.decodeFromJsonElement(serializer<ULong>(), payloadElem))
              }
              "CryptoHash" -> {
                val payloadElem = jobj["value"] ?: throw SerializationException("Missing field 'value' for variant " + tf)
                return BlockId.CryptoHash(decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), payloadElem))
              }
              else -> throw SerializationException("Unknown type discriminator for BlockId: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize BlockId with non-JSON decoder")
  }
}
