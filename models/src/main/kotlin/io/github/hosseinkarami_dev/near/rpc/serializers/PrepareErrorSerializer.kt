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
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.PrepareError") {
        element("Serialization", serializer<JsonElement>().descriptor)
        element("Deserialization", serializer<JsonElement>().descriptor)
        element("InternalMemoryDeclared", serializer<JsonElement>().descriptor)
        element("GasInstrumentation", serializer<JsonElement>().descriptor)
        element("StackHeightInstrumentation", serializer<JsonElement>().descriptor)
        element("Instantiate", serializer<JsonElement>().descriptor)
        element("Memory", serializer<JsonElement>().descriptor)
        element("TooManyFunctions", serializer<JsonElement>().descriptor)
        element("TooManyLocals", serializer<JsonElement>().descriptor)
        element("TooManyTables", serializer<JsonElement>().descriptor)
        element("TooManyTableElements", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: PrepareError) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is PrepareError.Serialization -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("Serialization"))
        }
        is PrepareError.Deserialization -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("Deserialization"))
        }
        is PrepareError.InternalMemoryDeclared -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("InternalMemoryDeclared"))
        }
        is PrepareError.GasInstrumentation -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("GasInstrumentation"))
        }
        is PrepareError.StackHeightInstrumentation -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("StackHeightInstrumentation"))
        }
        is PrepareError.Instantiate -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("Instantiate"))
        }
        is PrepareError.Memory -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("Memory"))
        }
        is PrepareError.TooManyFunctions -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("TooManyFunctions"))
        }
        is PrepareError.TooManyLocals -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("TooManyLocals"))
        }
        is PrepareError.TooManyTables -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("TooManyTables"))
        }
        is PrepareError.TooManyTableElements -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("TooManyTableElements"))
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is PrepareError.Serialization -> out.encodeSerializableElement(descriptor, 0, serializer<PrepareError.Serialization>(), value)
      is PrepareError.Deserialization -> out.encodeSerializableElement(descriptor, 1, serializer<PrepareError.Deserialization>(), value)
      is PrepareError.InternalMemoryDeclared -> out.encodeSerializableElement(descriptor, 2, serializer<PrepareError.InternalMemoryDeclared>(), value)
      is PrepareError.GasInstrumentation -> out.encodeSerializableElement(descriptor, 3, serializer<PrepareError.GasInstrumentation>(), value)
      is PrepareError.StackHeightInstrumentation -> out.encodeSerializableElement(descriptor, 4, serializer<PrepareError.StackHeightInstrumentation>(), value)
      is PrepareError.Instantiate -> out.encodeSerializableElement(descriptor, 5, serializer<PrepareError.Instantiate>(), value)
      is PrepareError.Memory -> out.encodeSerializableElement(descriptor, 6, serializer<PrepareError.Memory>(), value)
      is PrepareError.TooManyFunctions -> out.encodeSerializableElement(descriptor, 7, serializer<PrepareError.TooManyFunctions>(), value)
      is PrepareError.TooManyLocals -> out.encodeSerializableElement(descriptor, 8, serializer<PrepareError.TooManyLocals>(), value)
      is PrepareError.TooManyTables -> out.encodeSerializableElement(descriptor, 9, serializer<PrepareError.TooManyTables>(), value)
      is PrepareError.TooManyTableElements -> out.encodeSerializableElement(descriptor, 10, serializer<PrepareError.TooManyTableElements>(), value)
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
          }
          throw SerializationException("Unknown discriminator (primitive) for PrepareError")
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
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("Serialization", "Deserialization", "InternalMemoryDeclared", "GasInstrumentation", "StackHeightInstrumentation", "Instantiate", "Memory", "TooManyFunctions", "TooManyLocals", "TooManyTables", "TooManyTableElements")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in PrepareError")
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
