package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext
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

public object MissingTrieValueContextSerializer : KSerializer<MissingTrieValueContext> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext") {
        element("TrieIterator", serializer<JsonElement>().descriptor)
        element("TriePrefetchingStorage", serializer<JsonElement>().descriptor)
        element("TrieMemoryPartialStorage", serializer<JsonElement>().descriptor)
        element("TrieStorage", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: MissingTrieValueContext) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is MissingTrieValueContext.TrieIterator -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("TrieIterator"))
        }
        is MissingTrieValueContext.TriePrefetchingStorage -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("TriePrefetchingStorage"))
        }
        is MissingTrieValueContext.TrieMemoryPartialStorage -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("TrieMemoryPartialStorage"))
        }
        is MissingTrieValueContext.TrieStorage -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("TrieStorage"))
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is MissingTrieValueContext.TrieIterator -> out.encodeSerializableElement(descriptor, 0, serializer<MissingTrieValueContext.TrieIterator>(), value)
      is MissingTrieValueContext.TriePrefetchingStorage -> out.encodeSerializableElement(descriptor, 1, serializer<MissingTrieValueContext.TriePrefetchingStorage>(), value)
      is MissingTrieValueContext.TrieMemoryPartialStorage -> out.encodeSerializableElement(descriptor, 2, serializer<MissingTrieValueContext.TrieMemoryPartialStorage>(), value)
      is MissingTrieValueContext.TrieStorage -> out.encodeSerializableElement(descriptor, 3, serializer<MissingTrieValueContext.TrieStorage>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): MissingTrieValueContext {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            if (s == "TrieIterator") return MissingTrieValueContext.TrieIterator
            if (s == "TriePrefetchingStorage") return MissingTrieValueContext.TriePrefetchingStorage
            if (s == "TrieMemoryPartialStorage") return MissingTrieValueContext.TrieMemoryPartialStorage
            if (s == "TrieStorage") return MissingTrieValueContext.TrieStorage
          }
          throw SerializationException("Unknown discriminator (primitive) for MissingTrieValueContext")
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing MissingTrieValueContext")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "TrieIterator" -> {
                return MissingTrieValueContext.TrieIterator
              }
              "TriePrefetchingStorage" -> {
                return MissingTrieValueContext.TriePrefetchingStorage
              }
              "TrieMemoryPartialStorage" -> {
                return MissingTrieValueContext.TrieMemoryPartialStorage
              }
              "TrieStorage" -> {
                return MissingTrieValueContext.TrieStorage
              }
              else -> throw SerializationException("Unknown discriminator key for MissingTrieValueContext: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("TrieIterator", "TriePrefetchingStorage", "TrieMemoryPartialStorage", "TrieStorage")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in MissingTrieValueContext")
            val tf = typeField.trim()
            when (tf) {
              "TrieIterator" -> return MissingTrieValueContext.TrieIterator
              "TriePrefetchingStorage" -> return MissingTrieValueContext.TriePrefetchingStorage
              "TrieMemoryPartialStorage" -> return MissingTrieValueContext.TrieMemoryPartialStorage
              "TrieStorage" -> return MissingTrieValueContext.TrieStorage
              else -> throw SerializationException("Unknown type discriminator for MissingTrieValueContext: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize MissingTrieValueContext with non-JSON decoder")
  }
}
