package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.CompilationError
import io.github.hosseinkarami_dev.near.rpc.models.PrepareError
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

public object CompilationErrorSerializer : KSerializer<CompilationError> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.CompilationError") {
        element("CodeDoesNotExist", serializer<JsonElement>().descriptor)
        element("PrepareError", serializer<JsonElement>().descriptor)
        element("WasmerCompileError", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: CompilationError) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is CompilationError.CodeDoesNotExist -> {
          val map = mutableMapOf<String, JsonElement>()
          map["CodeDoesNotExist"] = jsonEncoder.json.encodeToJsonElement(serializer<CompilationError.CodeDoesNotExist.CodeDoesNotExistPayload>(), value.codeDoesNotExist)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is CompilationError.PrepareError -> {
          val map = mutableMapOf<String, JsonElement>()
          map["PrepareError"] = jsonEncoder.json.encodeToJsonElement(serializer<PrepareError>(), value.prepareError)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is CompilationError.WasmerCompileError -> {
          val map = mutableMapOf<String, JsonElement>()
          map["WasmerCompileError"] = jsonEncoder.json.encodeToJsonElement(serializer<CompilationError.WasmerCompileError.WasmerCompileErrorPayload>(), value.wasmerCompileError)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is CompilationError.CodeDoesNotExist -> out.encodeSerializableElement(descriptor, 0, serializer<CompilationError.CodeDoesNotExist>(), value)
      is CompilationError.PrepareError -> out.encodeSerializableElement(descriptor, 1, serializer<CompilationError.PrepareError>(), value)
      is CompilationError.WasmerCompileError -> out.encodeSerializableElement(descriptor, 2, serializer<CompilationError.WasmerCompileError>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): CompilationError {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            throw SerializationException("Unknown discriminator string for CompilationError: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing CompilationError")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["CodeDoesNotExist"] != null) {
            val codeDoesNotExistVal = decoder.json.decodeFromJsonElement(serializer<CompilationError.CodeDoesNotExist.CodeDoesNotExistPayload>(), jobj["CodeDoesNotExist"] ?: throw SerializationException("Missing field 'CodeDoesNotExist' for variant " + "CodeDoesNotExist"))
            return CompilationError.CodeDoesNotExist(codeDoesNotExistVal)
          }
          if (jobj["PrepareError"] != null) {
            val prepareErrorVal = decoder.json.decodeFromJsonElement(serializer<PrepareError>(), jobj["PrepareError"] ?: throw SerializationException("Missing field 'PrepareError' for variant " + "PrepareError"))
            return CompilationError.PrepareError(prepareErrorVal)
          }
          if (jobj["WasmerCompileError"] != null) {
            val wasmerCompileErrorVal = decoder.json.decodeFromJsonElement(serializer<CompilationError.WasmerCompileError.WasmerCompileErrorPayload>(), jobj["WasmerCompileError"] ?: throw SerializationException("Missing field 'WasmerCompileError' for variant " + "WasmerCompileError"))
            return CompilationError.WasmerCompileError(wasmerCompileErrorVal)
          }
          if (listOf("CodeDoesNotExist").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<CompilationError.CodeDoesNotExist>(), jobj)
          }
          if (listOf("PrepareError").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<CompilationError.PrepareError>(), jobj)
          }
          if (listOf("WasmerCompileError").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<CompilationError.WasmerCompileError>(), jobj)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "CodeDoesNotExist" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val codeDoesNotExistVal = decoder.json.decodeFromJsonElement(serializer<CompilationError.CodeDoesNotExist.CodeDoesNotExistPayload>(), obj["CodeDoesNotExist"] ?: throw SerializationException("Missing field 'CodeDoesNotExist' for variant " + key))
                return CompilationError.CodeDoesNotExist(codeDoesNotExistVal)
              }
              "PrepareError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val prepareErrorVal = decoder.json.decodeFromJsonElement(serializer<PrepareError>(), obj["PrepareError"] ?: throw SerializationException("Missing field 'PrepareError' for variant " + key))
                return CompilationError.PrepareError(prepareErrorVal)
              }
              "WasmerCompileError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val wasmerCompileErrorVal = decoder.json.decodeFromJsonElement(serializer<CompilationError.WasmerCompileError.WasmerCompileErrorPayload>(), obj["WasmerCompileError"] ?: throw SerializationException("Missing field 'WasmerCompileError' for variant " + key))
                return CompilationError.WasmerCompileError(wasmerCompileErrorVal)
              }
              else -> throw SerializationException("Unknown discriminator key for CompilationError: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("CodeDoesNotExist", "PrepareError", "WasmerCompileError")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in CompilationError")
            val tf = typeField.trim()
            when (tf) {
              "CodeDoesNotExist" -> {
                return decoder.json.decodeFromJsonElement(serializer<CompilationError.CodeDoesNotExist>(), jobj)
              }
              "PrepareError" -> {
                return decoder.json.decodeFromJsonElement(serializer<CompilationError.PrepareError>(), jobj)
              }
              "WasmerCompileError" -> {
                return decoder.json.decodeFromJsonElement(serializer<CompilationError.WasmerCompileError>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for CompilationError: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize CompilationError with non-JSON decoder")
  }
}
