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
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.serializer

public object MissingTrieValueContextSerializer : KSerializer<MissingTrieValueContext> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext")

  override fun serialize(encoder: Encoder, `value`: MissingTrieValueContext) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        MissingTrieValueContext.TrieIterator -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("TrieIterator"))
        }
        MissingTrieValueContext.TriePrefetchingStorage -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("TriePrefetchingStorage"))
        }
        MissingTrieValueContext.TrieMemoryPartialStorage -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("TrieMemoryPartialStorage"))
        }
        MissingTrieValueContext.TrieStorage -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("TrieStorage"))
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      MissingTrieValueContext.TrieIterator -> out.encodeStringElement(descriptor, 0, "TrieIterator")
      MissingTrieValueContext.TriePrefetchingStorage -> out.encodeStringElement(descriptor, 1, "TriePrefetchingStorage")
      MissingTrieValueContext.TrieMemoryPartialStorage -> out.encodeStringElement(descriptor, 2, "TrieMemoryPartialStorage")
      MissingTrieValueContext.TrieStorage -> out.encodeStringElement(descriptor, 3, "TrieStorage")
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
            throw SerializationException("Unknown discriminator string for MissingTrieValueContext: " + s)
          }
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
            val typeField = jobj["type"]?.jsonPrimitive?.contentOrNull ?: throw SerializationException("Missing 'type' discriminator in MissingTrieValueContext")
            when (typeField) {
              "TrieIterator" -> return MissingTrieValueContext.TrieIterator
              "TriePrefetchingStorage" -> return MissingTrieValueContext.TriePrefetchingStorage
              "TrieMemoryPartialStorage" -> return MissingTrieValueContext.TrieMemoryPartialStorage
              "TrieStorage" -> return MissingTrieValueContext.TrieStorage
              else -> throw SerializationException("Unknown type discriminator for MissingTrieValueContext: " + typeField)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize MissingTrieValueContext with non-JSON decoder")
  }
}
