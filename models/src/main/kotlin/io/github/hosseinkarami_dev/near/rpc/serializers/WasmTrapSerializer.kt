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
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.WasmTrap")

  override fun serialize(encoder: Encoder, `value`: WasmTrap) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        WasmTrap.Unreachable -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("Unreachable"))
        }
        WasmTrap.IncorrectCallIndirectSignature -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("IncorrectCallIndirectSignature"))
        }
        WasmTrap.MemoryOutOfBounds -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("MemoryOutOfBounds"))
        }
        WasmTrap.CallIndirectOOB -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("CallIndirectOOB"))
        }
        WasmTrap.IllegalArithmetic -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("IllegalArithmetic"))
        }
        WasmTrap.MisalignedAtomicAccess -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("MisalignedAtomicAccess"))
        }
        WasmTrap.IndirectCallToNull -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("IndirectCallToNull"))
        }
        WasmTrap.StackOverflow -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("StackOverflow"))
        }
        WasmTrap.GenericTrap -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("GenericTrap"))
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      WasmTrap.Unreachable -> out.encodeStringElement(descriptor, 0, "Unreachable")
      WasmTrap.IncorrectCallIndirectSignature -> out.encodeStringElement(descriptor, 1, "IncorrectCallIndirectSignature")
      WasmTrap.MemoryOutOfBounds -> out.encodeStringElement(descriptor, 2, "MemoryOutOfBounds")
      WasmTrap.CallIndirectOOB -> out.encodeStringElement(descriptor, 3, "CallIndirectOOB")
      WasmTrap.IllegalArithmetic -> out.encodeStringElement(descriptor, 4, "IllegalArithmetic")
      WasmTrap.MisalignedAtomicAccess -> out.encodeStringElement(descriptor, 5, "MisalignedAtomicAccess")
      WasmTrap.IndirectCallToNull -> out.encodeStringElement(descriptor, 6, "IndirectCallToNull")
      WasmTrap.StackOverflow -> out.encodeStringElement(descriptor, 7, "StackOverflow")
      WasmTrap.GenericTrap -> out.encodeStringElement(descriptor, 8, "GenericTrap")
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
            if (s == "Unreachable") return WasmTrap.Unreachable
            if (s == "IncorrectCallIndirectSignature") return WasmTrap.IncorrectCallIndirectSignature
            if (s == "MemoryOutOfBounds") return WasmTrap.MemoryOutOfBounds
            if (s == "CallIndirectOOB") return WasmTrap.CallIndirectOOB
            if (s == "IllegalArithmetic") return WasmTrap.IllegalArithmetic
            if (s == "MisalignedAtomicAccess") return WasmTrap.MisalignedAtomicAccess
            if (s == "IndirectCallToNull") return WasmTrap.IndirectCallToNull
            if (s == "StackOverflow") return WasmTrap.StackOverflow
            if (s == "GenericTrap") return WasmTrap.GenericTrap
            throw SerializationException("Unknown discriminator string for WasmTrap: " + s)
          }
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
                return WasmTrap.Unreachable
              }
              "IncorrectCallIndirectSignature" -> {
                return WasmTrap.IncorrectCallIndirectSignature
              }
              "MemoryOutOfBounds" -> {
                return WasmTrap.MemoryOutOfBounds
              }
              "CallIndirectOOB" -> {
                return WasmTrap.CallIndirectOOB
              }
              "IllegalArithmetic" -> {
                return WasmTrap.IllegalArithmetic
              }
              "MisalignedAtomicAccess" -> {
                return WasmTrap.MisalignedAtomicAccess
              }
              "IndirectCallToNull" -> {
                return WasmTrap.IndirectCallToNull
              }
              "StackOverflow" -> {
                return WasmTrap.StackOverflow
              }
              "GenericTrap" -> {
                return WasmTrap.GenericTrap
              }
              else -> throw SerializationException("Unknown discriminator key for WasmTrap: " + key)
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
              val knownVariantNames = setOf("Unreachable", "IncorrectCallIndirectSignature", "MemoryOutOfBounds", "CallIndirectOOB", "IllegalArithmetic", "MisalignedAtomicAccess", "IndirectCallToNull", "StackOverflow", "GenericTrap")
              for ((k, v) in jobj.entries) {
                if (v is JsonElement && v.jsonPrimitive.isString) {
                    val s = (v as JsonElement).jsonPrimitive.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator (one of type/name) or recognizable variant in WasmTrap")
            val tf = typeField.trim()
            when (tf) {
              "Unreachable" -> return WasmTrap.Unreachable
              "IncorrectCallIndirectSignature" -> return WasmTrap.IncorrectCallIndirectSignature
              "MemoryOutOfBounds" -> return WasmTrap.MemoryOutOfBounds
              "CallIndirectOOB" -> return WasmTrap.CallIndirectOOB
              "IllegalArithmetic" -> return WasmTrap.IllegalArithmetic
              "MisalignedAtomicAccess" -> return WasmTrap.MisalignedAtomicAccess
              "IndirectCallToNull" -> return WasmTrap.IndirectCallToNull
              "StackOverflow" -> return WasmTrap.StackOverflow
              "GenericTrap" -> return WasmTrap.GenericTrap
              else -> throw SerializationException("Unknown type discriminator for WasmTrap: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize WasmTrap with non-JSON decoder")
  }
}
