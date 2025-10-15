package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.CompilationError
import io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError
import io.github.hosseinkarami_dev.near.rpc.models.HostError
import io.github.hosseinkarami_dev.near.rpc.models.MethodResolveError
import io.github.hosseinkarami_dev.near.rpc.models.WasmTrap
import kotlin.String
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

public object FunctionCallErrorSerializer : KSerializer<FunctionCallError> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError") {
        element("WasmUnknownError", serializer<JsonElement>().descriptor)
        element("_EVMError", serializer<JsonElement>().descriptor)
        element("CompilationError", serializer<JsonElement>().descriptor)
        element("LinkError", serializer<JsonElement>().descriptor)
        element("MethodResolveError", serializer<JsonElement>().descriptor)
        element("WasmTrap", serializer<JsonElement>().descriptor)
        element("HostError", serializer<JsonElement>().descriptor)
        element("ExecutionError", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: FunctionCallError) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is FunctionCallError.WasmUnknownError -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("WasmUnknownError"))
        }
        is FunctionCallError.EVMError -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("_EVMError"))
        }
        is FunctionCallError.CompilationError -> {
          val map = mutableMapOf<String, JsonElement>()
          map["CompilationError"] = jsonEncoder.json.encodeToJsonElement(serializer<CompilationError>(), value.compilationError)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is FunctionCallError.LinkError -> {
          val map = mutableMapOf<String, JsonElement>()
          map["LinkError"] = jsonEncoder.json.encodeToJsonElement(serializer<FunctionCallError.LinkError.LinkErrorPayload>(), value.linkError)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is FunctionCallError.MethodResolveError -> {
          val map = mutableMapOf<String, JsonElement>()
          map["MethodResolveError"] = jsonEncoder.json.encodeToJsonElement(serializer<MethodResolveError>(), value.methodResolveError)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is FunctionCallError.WasmTrap -> {
          val map = mutableMapOf<String, JsonElement>()
          map["WasmTrap"] = jsonEncoder.json.encodeToJsonElement(serializer<WasmTrap>(), value.wasmTrap)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is FunctionCallError.HostError -> {
          val map = mutableMapOf<String, JsonElement>()
          map["HostError"] = jsonEncoder.json.encodeToJsonElement(serializer<HostError>(), value.hostError)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is FunctionCallError.ExecutionError -> {
          val map = mutableMapOf<String, JsonElement>()
          map["ExecutionError"] = jsonEncoder.json.encodeToJsonElement(serializer<String>(), value.executionError)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is FunctionCallError.WasmUnknownError -> out.encodeSerializableElement(descriptor, 0, serializer<FunctionCallError.WasmUnknownError>(), value)
      is FunctionCallError.EVMError -> out.encodeSerializableElement(descriptor, 1, serializer<FunctionCallError.EVMError>(), value)
      is FunctionCallError.CompilationError -> out.encodeSerializableElement(descriptor, 2, serializer<FunctionCallError.CompilationError>(), value)
      is FunctionCallError.LinkError -> out.encodeSerializableElement(descriptor, 3, serializer<FunctionCallError.LinkError>(), value)
      is FunctionCallError.MethodResolveError -> out.encodeSerializableElement(descriptor, 4, serializer<FunctionCallError.MethodResolveError>(), value)
      is FunctionCallError.WasmTrap -> out.encodeSerializableElement(descriptor, 5, serializer<FunctionCallError.WasmTrap>(), value)
      is FunctionCallError.HostError -> out.encodeSerializableElement(descriptor, 6, serializer<FunctionCallError.HostError>(), value)
      is FunctionCallError.ExecutionError -> out.encodeSerializableElement(descriptor, 7, serializer<FunctionCallError.ExecutionError>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): FunctionCallError {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            if (s == "WasmUnknownError") return FunctionCallError.WasmUnknownError
            if (s == "_EVMError") return FunctionCallError.EVMError
          }
          throw SerializationException("Unknown discriminator (primitive) for FunctionCallError")
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing FunctionCallError")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj["CompilationError"] != null) {
            return FunctionCallError.CompilationError(decoder.json.decodeFromJsonElement(serializer<CompilationError>(), jobj["CompilationError"]!!))
          }
          if (jobj["LinkError"] != null) {
            return FunctionCallError.LinkError(decoder.json.decodeFromJsonElement(serializer<FunctionCallError.LinkError.LinkErrorPayload>(), jobj["LinkError"]!!))
          }
          if (jobj["MethodResolveError"] != null) {
            return FunctionCallError.MethodResolveError(decoder.json.decodeFromJsonElement(serializer<MethodResolveError>(), jobj["MethodResolveError"]!!))
          }
          if (jobj["WasmTrap"] != null) {
            return FunctionCallError.WasmTrap(decoder.json.decodeFromJsonElement(serializer<WasmTrap>(), jobj["WasmTrap"]!!))
          }
          if (jobj["HostError"] != null) {
            return FunctionCallError.HostError(decoder.json.decodeFromJsonElement(serializer<HostError>(), jobj["HostError"]!!))
          }
          if (jobj["ExecutionError"] != null) {
            return FunctionCallError.ExecutionError(decoder.json.decodeFromJsonElement(serializer<String>(), jobj["ExecutionError"]!!))
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "CompilationError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<FunctionCallError.CompilationError>(), obj)
              }
              "LinkError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<FunctionCallError.LinkError>(), obj)
              }
              "MethodResolveError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<FunctionCallError.MethodResolveError>(), obj)
              }
              "WasmTrap" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<FunctionCallError.WasmTrap>(), obj)
              }
              "HostError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<FunctionCallError.HostError>(), obj)
              }
              "ExecutionError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<FunctionCallError.ExecutionError>(), obj)
              }
              "WasmUnknownError" -> {
                return FunctionCallError.WasmUnknownError
              }
              "_EVMError" -> {
                return FunctionCallError.EVMError
              }
              else -> throw SerializationException("Unknown discriminator key for FunctionCallError: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("WasmUnknownError", "_EVMError", "CompilationError", "LinkError", "MethodResolveError", "WasmTrap", "HostError", "ExecutionError")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in FunctionCallError")
            val tf = typeField.trim()
            when (tf) {
              "CompilationError" -> {
                return decoder.json.decodeFromJsonElement(serializer<FunctionCallError.CompilationError>(), jobj)
              }
              "LinkError" -> {
                return decoder.json.decodeFromJsonElement(serializer<FunctionCallError.LinkError>(), jobj)
              }
              "MethodResolveError" -> {
                return decoder.json.decodeFromJsonElement(serializer<FunctionCallError.MethodResolveError>(), jobj)
              }
              "WasmTrap" -> {
                return decoder.json.decodeFromJsonElement(serializer<FunctionCallError.WasmTrap>(), jobj)
              }
              "HostError" -> {
                return decoder.json.decodeFromJsonElement(serializer<FunctionCallError.HostError>(), jobj)
              }
              "ExecutionError" -> {
                return decoder.json.decodeFromJsonElement(serializer<FunctionCallError.ExecutionError>(), jobj)
              }
              "WasmUnknownError" -> return FunctionCallError.WasmUnknownError
              "_EVMError" -> return FunctionCallError.EVMError
              else -> throw SerializationException("Unknown type discriminator for FunctionCallError: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize FunctionCallError with non-JSON decoder")
  }
}
