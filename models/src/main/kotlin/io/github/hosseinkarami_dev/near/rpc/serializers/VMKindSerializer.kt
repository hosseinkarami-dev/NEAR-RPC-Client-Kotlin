package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.VMKind
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

public object VMKindSerializer : KSerializer<VMKind> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.VMKind") {
        element("Wasmer0", serializer<JsonElement>().descriptor)
        element("Wasmtime", serializer<JsonElement>().descriptor)
        element("Wasmer2", serializer<JsonElement>().descriptor)
        element("NearVm", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: VMKind) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        VMKind.Wasmer0 -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("Wasmer0"))
        }
        VMKind.Wasmtime -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("Wasmtime"))
        }
        VMKind.Wasmer2 -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("Wasmer2"))
        }
        VMKind.NearVm -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("NearVm"))
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is VMKind.Wasmer0 -> out.encodeSerializableElement(descriptor, 0, serializer<VMKind.Wasmer0>(), value)
      is VMKind.Wasmtime -> out.encodeSerializableElement(descriptor, 1, serializer<VMKind.Wasmtime>(), value)
      is VMKind.Wasmer2 -> out.encodeSerializableElement(descriptor, 2, serializer<VMKind.Wasmer2>(), value)
      is VMKind.NearVm -> out.encodeSerializableElement(descriptor, 3, serializer<VMKind.NearVm>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): VMKind {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            if (s == "Wasmer0") return VMKind.Wasmer0
            if (s == "Wasmtime") return VMKind.Wasmtime
            if (s == "Wasmer2") return VMKind.Wasmer2
            if (s == "NearVm") return VMKind.NearVm
            throw SerializationException("Unknown discriminator string for VMKind: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing VMKind")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "Wasmer0" -> {
                return VMKind.Wasmer0
              }
              "Wasmtime" -> {
                return VMKind.Wasmtime
              }
              "Wasmer2" -> {
                return VMKind.Wasmer2
              }
              "NearVm" -> {
                return VMKind.NearVm
              }
              else -> throw SerializationException("Unknown discriminator key for VMKind: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("Wasmer0", "Wasmtime", "Wasmer2", "NearVm")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in VMKind")
            val tf = typeField.trim()
            when (tf) {
              "Wasmer0" -> return VMKind.Wasmer0
              "Wasmtime" -> return VMKind.Wasmtime
              "Wasmer2" -> return VMKind.Wasmer2
              "NearVm" -> return VMKind.NearVm
              else -> throw SerializationException("Unknown type discriminator for VMKind: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize VMKind with non-JSON decoder")
  }
}
