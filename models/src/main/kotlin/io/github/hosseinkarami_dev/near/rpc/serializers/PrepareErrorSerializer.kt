package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.PrepareError
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

public object PrepareErrorSerializer : KSerializer<PrepareError> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.PrepareError")

  override fun serialize(encoder: Encoder, `value`: PrepareError) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        PrepareError.Serialization -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("Serialization"))
        }
        PrepareError.Deserialization -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("Deserialization"))
        }
        PrepareError.InternalMemoryDeclared -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("InternalMemoryDeclared"))
        }
        PrepareError.GasInstrumentation -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("GasInstrumentation"))
        }
        PrepareError.StackHeightInstrumentation -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("StackHeightInstrumentation"))
        }
        PrepareError.Instantiate -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("Instantiate"))
        }
        PrepareError.Memory -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("Memory"))
        }
        PrepareError.TooManyFunctions -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("TooManyFunctions"))
        }
        PrepareError.TooManyLocals -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("TooManyLocals"))
        }
        PrepareError.TooManyTables -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("TooManyTables"))
        }
        PrepareError.TooManyTableElements -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("TooManyTableElements"))
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      PrepareError.Serialization -> out.encodeStringElement(descriptor, 0, "Serialization")
      PrepareError.Deserialization -> out.encodeStringElement(descriptor, 1, "Deserialization")
      PrepareError.InternalMemoryDeclared -> out.encodeStringElement(descriptor, 2, "InternalMemoryDeclared")
      PrepareError.GasInstrumentation -> out.encodeStringElement(descriptor, 3, "GasInstrumentation")
      PrepareError.StackHeightInstrumentation -> out.encodeStringElement(descriptor, 4, "StackHeightInstrumentation")
      PrepareError.Instantiate -> out.encodeStringElement(descriptor, 5, "Instantiate")
      PrepareError.Memory -> out.encodeStringElement(descriptor, 6, "Memory")
      PrepareError.TooManyFunctions -> out.encodeStringElement(descriptor, 7, "TooManyFunctions")
      PrepareError.TooManyLocals -> out.encodeStringElement(descriptor, 8, "TooManyLocals")
      PrepareError.TooManyTables -> out.encodeStringElement(descriptor, 9, "TooManyTables")
      PrepareError.TooManyTableElements -> out.encodeStringElement(descriptor, 10, "TooManyTableElements")
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): PrepareError {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            if (s == "Serialization") return PrepareError.Serialization
            if (s == "Deserialization") return PrepareError.Deserialization
            if (s == "InternalMemoryDeclared") return PrepareError.InternalMemoryDeclared
            if (s == "GasInstrumentation") return PrepareError.GasInstrumentation
            if (s == "StackHeightInstrumentation") return PrepareError.StackHeightInstrumentation
            if (s == "Instantiate") return PrepareError.Instantiate
            if (s == "Memory") return PrepareError.Memory
            if (s == "TooManyFunctions") return PrepareError.TooManyFunctions
            if (s == "TooManyLocals") return PrepareError.TooManyLocals
            if (s == "TooManyTables") return PrepareError.TooManyTables
            if (s == "TooManyTableElements") return PrepareError.TooManyTableElements
            throw SerializationException("Unknown discriminator string for PrepareError: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing PrepareError")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "Serialization" -> {
                return PrepareError.Serialization
              }
              "Deserialization" -> {
                return PrepareError.Deserialization
              }
              "InternalMemoryDeclared" -> {
                return PrepareError.InternalMemoryDeclared
              }
              "GasInstrumentation" -> {
                return PrepareError.GasInstrumentation
              }
              "StackHeightInstrumentation" -> {
                return PrepareError.StackHeightInstrumentation
              }
              "Instantiate" -> {
                return PrepareError.Instantiate
              }
              "Memory" -> {
                return PrepareError.Memory
              }
              "TooManyFunctions" -> {
                return PrepareError.TooManyFunctions
              }
              "TooManyLocals" -> {
                return PrepareError.TooManyLocals
              }
              "TooManyTables" -> {
                return PrepareError.TooManyTables
              }
              "TooManyTableElements" -> {
                return PrepareError.TooManyTableElements
              }
              else -> throw SerializationException("Unknown discriminator key for PrepareError: " + key)
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
              val knownVariantNames = setOf("Serialization", "Deserialization", "InternalMemoryDeclared", "GasInstrumentation", "StackHeightInstrumentation", "Instantiate", "Memory", "TooManyFunctions", "TooManyLocals", "TooManyTables", "TooManyTableElements")
              for ((k, v) in jobj.entries) {
                if (v is JsonElement && v.jsonPrimitive.isString) {
                    val s = (v as JsonElement).jsonPrimitive.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator (one of type/name) or recognizable variant in PrepareError")
            val tf = typeField.trim()
            when (tf) {
              "Serialization" -> return PrepareError.Serialization
              "Deserialization" -> return PrepareError.Deserialization
              "InternalMemoryDeclared" -> return PrepareError.InternalMemoryDeclared
              "GasInstrumentation" -> return PrepareError.GasInstrumentation
              "StackHeightInstrumentation" -> return PrepareError.StackHeightInstrumentation
              "Instantiate" -> return PrepareError.Instantiate
              "Memory" -> return PrepareError.Memory
              "TooManyFunctions" -> return PrepareError.TooManyFunctions
              "TooManyLocals" -> return PrepareError.TooManyLocals
              "TooManyTables" -> return PrepareError.TooManyTables
              "TooManyTableElements" -> return PrepareError.TooManyTableElements
              else -> throw SerializationException("Unknown type discriminator for PrepareError: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize PrepareError with non-JSON decoder")
  }
}
