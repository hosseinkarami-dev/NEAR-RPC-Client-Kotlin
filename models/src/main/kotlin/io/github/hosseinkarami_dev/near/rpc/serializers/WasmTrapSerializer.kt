package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.WasmTrap
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

public object WasmTrapSerializer : KSerializer<WasmTrap> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.WasmTrap") {
        element("Unreachable", serializer<JsonElement>().descriptor)
        element("IncorrectCallIndirectSignature", serializer<JsonElement>().descriptor)
        element("MemoryOutOfBounds", serializer<JsonElement>().descriptor)
        element("CallIndirectOOB", serializer<JsonElement>().descriptor)
        element("IllegalArithmetic", serializer<JsonElement>().descriptor)
        element("MisalignedAtomicAccess", serializer<JsonElement>().descriptor)
        element("IndirectCallToNull", serializer<JsonElement>().descriptor)
        element("StackOverflow", serializer<JsonElement>().descriptor)
        element("GenericTrap", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: WasmTrap) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is WasmTrap.Unreachable -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("Unreachable"))
        }
        is WasmTrap.IncorrectCallIndirectSignature -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("IncorrectCallIndirectSignature"))
        }
        is WasmTrap.MemoryOutOfBounds -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("MemoryOutOfBounds"))
        }
        is WasmTrap.CallIndirectOOB -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("CallIndirectOOB"))
        }
        is WasmTrap.IllegalArithmetic -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("IllegalArithmetic"))
        }
        is WasmTrap.MisalignedAtomicAccess -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("MisalignedAtomicAccess"))
        }
        is WasmTrap.IndirectCallToNull -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("IndirectCallToNull"))
        }
        is WasmTrap.StackOverflow -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("StackOverflow"))
        }
        is WasmTrap.GenericTrap -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("GenericTrap"))
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is WasmTrap.Unreachable -> out.encodeSerializableElement(descriptor, 0, serializer<WasmTrap.Unreachable>(), value)
      is WasmTrap.IncorrectCallIndirectSignature -> out.encodeSerializableElement(descriptor, 1, serializer<WasmTrap.IncorrectCallIndirectSignature>(), value)
      is WasmTrap.MemoryOutOfBounds -> out.encodeSerializableElement(descriptor, 2, serializer<WasmTrap.MemoryOutOfBounds>(), value)
      is WasmTrap.CallIndirectOOB -> out.encodeSerializableElement(descriptor, 3, serializer<WasmTrap.CallIndirectOOB>(), value)
      is WasmTrap.IllegalArithmetic -> out.encodeSerializableElement(descriptor, 4, serializer<WasmTrap.IllegalArithmetic>(), value)
      is WasmTrap.MisalignedAtomicAccess -> out.encodeSerializableElement(descriptor, 5, serializer<WasmTrap.MisalignedAtomicAccess>(), value)
      is WasmTrap.IndirectCallToNull -> out.encodeSerializableElement(descriptor, 6, serializer<WasmTrap.IndirectCallToNull>(), value)
      is WasmTrap.StackOverflow -> out.encodeSerializableElement(descriptor, 7, serializer<WasmTrap.StackOverflow>(), value)
      is WasmTrap.GenericTrap -> out.encodeSerializableElement(descriptor, 8, serializer<WasmTrap.GenericTrap>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): WasmTrap {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            if (s == "Unreachable") return WasmTrap.Unreachable()
            if (s == "IncorrectCallIndirectSignature") return WasmTrap.IncorrectCallIndirectSignature()
            if (s == "MemoryOutOfBounds") return WasmTrap.MemoryOutOfBounds()
            if (s == "CallIndirectOOB") return WasmTrap.CallIndirectOOB()
            if (s == "IllegalArithmetic") return WasmTrap.IllegalArithmetic()
            if (s == "MisalignedAtomicAccess") return WasmTrap.MisalignedAtomicAccess()
            if (s == "IndirectCallToNull") return WasmTrap.IndirectCallToNull()
            if (s == "StackOverflow") return WasmTrap.StackOverflow()
            if (s == "GenericTrap") return WasmTrap.GenericTrap()
          }
          throw SerializationException("Unknown discriminator (primitive) for WasmTrap")
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing WasmTrap")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "Unreachable" -> {
                return WasmTrap.Unreachable()
              }
              "IncorrectCallIndirectSignature" -> {
                return WasmTrap.IncorrectCallIndirectSignature()
              }
              "MemoryOutOfBounds" -> {
                return WasmTrap.MemoryOutOfBounds()
              }
              "CallIndirectOOB" -> {
                return WasmTrap.CallIndirectOOB()
              }
              "IllegalArithmetic" -> {
                return WasmTrap.IllegalArithmetic()
              }
              "MisalignedAtomicAccess" -> {
                return WasmTrap.MisalignedAtomicAccess()
              }
              "IndirectCallToNull" -> {
                return WasmTrap.IndirectCallToNull()
              }
              "StackOverflow" -> {
                return WasmTrap.StackOverflow()
              }
              "GenericTrap" -> {
                return WasmTrap.GenericTrap()
              }
              else -> throw SerializationException("Unknown discriminator key for WasmTrap: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("Unreachable", "IncorrectCallIndirectSignature", "MemoryOutOfBounds", "CallIndirectOOB", "IllegalArithmetic", "MisalignedAtomicAccess", "IndirectCallToNull", "StackOverflow", "GenericTrap")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in WasmTrap")
            val tf = typeField.trim()
            when (tf) {
              "Unreachable" -> return WasmTrap.Unreachable()
              "IncorrectCallIndirectSignature" -> return WasmTrap.IncorrectCallIndirectSignature()
              "MemoryOutOfBounds" -> return WasmTrap.MemoryOutOfBounds()
              "CallIndirectOOB" -> return WasmTrap.CallIndirectOOB()
              "IllegalArithmetic" -> return WasmTrap.IllegalArithmetic()
              "MisalignedAtomicAccess" -> return WasmTrap.MisalignedAtomicAccess()
              "IndirectCallToNull" -> return WasmTrap.IndirectCallToNull()
              "StackOverflow" -> return WasmTrap.StackOverflow()
              "GenericTrap" -> return WasmTrap.GenericTrap()
              else -> throw SerializationException("Unknown type discriminator for WasmTrap: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize WasmTrap with non-JSON decoder")
  }
}
