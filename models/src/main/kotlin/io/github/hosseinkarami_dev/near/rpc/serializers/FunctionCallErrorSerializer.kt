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
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError")

  override fun serialize(encoder: Encoder, `value`: FunctionCallError) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        FunctionCallError.WasmUnknownError -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("WasmUnknownError"))
        }
        FunctionCallError.EVMError -> {
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
      FunctionCallError.WasmUnknownError -> out.encodeStringElement(descriptor, 0, "WasmUnknownError")
      FunctionCallError.EVMError -> out.encodeStringElement(descriptor, 1, "_EVMError")
      is FunctionCallError.CompilationError -> out.encodeSerializableElement(descriptor, 2, serializer<CompilationError>(), value.compilationError)
      is FunctionCallError.LinkError -> out.encodeSerializableElement(descriptor, 3, serializer<FunctionCallError.LinkError.LinkErrorPayload>(), value.linkError)
      is FunctionCallError.MethodResolveError -> out.encodeSerializableElement(descriptor, 4, serializer<MethodResolveError>(), value.methodResolveError)
      is FunctionCallError.WasmTrap -> out.encodeSerializableElement(descriptor, 5, serializer<WasmTrap>(), value.wasmTrap)
      is FunctionCallError.HostError -> out.encodeSerializableElement(descriptor, 6, serializer<HostError>(), value.hostError)
      is FunctionCallError.ExecutionError -> out.encodeSerializableElement(descriptor, 7, serializer<String>(), value.executionError)
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
            throw SerializationException("Unknown discriminator string for FunctionCallError: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing FunctionCallError")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["CompilationError"] != null) {
            val compilationErrorVal = decoder.json.decodeFromJsonElement(serializer<CompilationError>(), jobj["CompilationError"] ?: throw SerializationException("Missing field 'CompilationError' for variant " + "CompilationError"))
            return FunctionCallError.CompilationError(compilationErrorVal)
          }
          if (jobj["LinkError"] != null) {
            val linkErrorVal = decoder.json.decodeFromJsonElement(serializer<FunctionCallError.LinkError.LinkErrorPayload>(), jobj["LinkError"] ?: throw SerializationException("Missing field 'LinkError' for variant " + "LinkError"))
            return FunctionCallError.LinkError(linkErrorVal)
          }
          if (jobj["MethodResolveError"] != null) {
            val methodResolveErrorVal = decoder.json.decodeFromJsonElement(serializer<MethodResolveError>(), jobj["MethodResolveError"] ?: throw SerializationException("Missing field 'MethodResolveError' for variant " + "MethodResolveError"))
            return FunctionCallError.MethodResolveError(methodResolveErrorVal)
          }
          if (jobj["WasmTrap"] != null) {
            val wasmTrapVal = decoder.json.decodeFromJsonElement(serializer<WasmTrap>(), jobj["WasmTrap"] ?: throw SerializationException("Missing field 'WasmTrap' for variant " + "WasmTrap"))
            return FunctionCallError.WasmTrap(wasmTrapVal)
          }
          if (jobj["HostError"] != null) {
            val hostErrorVal = decoder.json.decodeFromJsonElement(serializer<HostError>(), jobj["HostError"] ?: throw SerializationException("Missing field 'HostError' for variant " + "HostError"))
            return FunctionCallError.HostError(hostErrorVal)
          }
          if (jobj["ExecutionError"] != null) {
            val executionErrorVal = decoder.json.decodeFromJsonElement(serializer<String>(), jobj["ExecutionError"] ?: throw SerializationException("Missing field 'ExecutionError' for variant " + "ExecutionError"))
            return FunctionCallError.ExecutionError(executionErrorVal)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "CompilationError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val compilationErrorVal = decoder.json.decodeFromJsonElement(serializer<CompilationError>(), obj["CompilationError"] ?: throw SerializationException("Missing field 'CompilationError' for variant " + key))
                return FunctionCallError.CompilationError(compilationErrorVal)
              }
              "LinkError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val linkErrorVal = decoder.json.decodeFromJsonElement(serializer<FunctionCallError.LinkError.LinkErrorPayload>(), obj["LinkError"] ?: throw SerializationException("Missing field 'LinkError' for variant " + key))
                return FunctionCallError.LinkError(linkErrorVal)
              }
              "MethodResolveError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val methodResolveErrorVal = decoder.json.decodeFromJsonElement(serializer<MethodResolveError>(), obj["MethodResolveError"] ?: throw SerializationException("Missing field 'MethodResolveError' for variant " + key))
                return FunctionCallError.MethodResolveError(methodResolveErrorVal)
              }
              "WasmTrap" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val wasmTrapVal = decoder.json.decodeFromJsonElement(serializer<WasmTrap>(), obj["WasmTrap"] ?: throw SerializationException("Missing field 'WasmTrap' for variant " + key))
                return FunctionCallError.WasmTrap(wasmTrapVal)
              }
              "HostError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val hostErrorVal = decoder.json.decodeFromJsonElement(serializer<HostError>(), obj["HostError"] ?: throw SerializationException("Missing field 'HostError' for variant " + key))
                return FunctionCallError.HostError(hostErrorVal)
              }
              "ExecutionError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val executionErrorVal = decoder.json.decodeFromJsonElement(serializer<String>(), obj["ExecutionError"] ?: throw SerializationException("Missing field 'ExecutionError' for variant " + key))
                return FunctionCallError.ExecutionError(executionErrorVal)
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
            val discriminatorCandidates = listOf("type", "name")
            var typeField: String? = null
            for (cand in discriminatorCandidates) {
              typeField = jobj[cand]?.jsonPrimitive?.contentOrNull
              if (typeField != null) break
            }
            if (typeField == null) {
              val knownVariantNames = setOf("WasmUnknownError", "_EVMError", "CompilationError", "LinkError", "MethodResolveError", "WasmTrap", "HostError", "ExecutionError")
              for ((k, v) in jobj.entries) {
                if (v is JsonElement && v.jsonPrimitive.isString) {
                    val s = (v as JsonElement).jsonPrimitive.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator (one of type/name) or recognizable variant in FunctionCallError")
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
