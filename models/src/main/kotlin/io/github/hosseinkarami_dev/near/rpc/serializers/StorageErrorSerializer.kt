package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValue
import io.github.hosseinkarami_dev.near.rpc.models.StorageError
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

public object StorageErrorSerializer : KSerializer<StorageError> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.StorageError") {
        element("StorageInternalError", serializer<JsonElement>().descriptor)
        element("MissingTrieValue", serializer<JsonElement>().descriptor)
        element("UnexpectedTrieValue", serializer<JsonElement>().descriptor)
        element("StorageInconsistentState", serializer<JsonElement>().descriptor)
        element("FlatStorageBlockNotSupported", serializer<JsonElement>().descriptor)
        element("MemTrieLoadingError", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: StorageError) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        StorageError.StorageInternalError -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("StorageInternalError"))
        }
        StorageError.UnexpectedTrieValue -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("UnexpectedTrieValue"))
        }
        is StorageError.MissingTrieValue -> {
          val map = mutableMapOf<String, JsonElement>()
          map["MissingTrieValue"] = jsonEncoder.json.encodeToJsonElement(serializer<MissingTrieValue>(), value.missingTrieValue)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StorageError.StorageInconsistentState -> {
          val map = mutableMapOf<String, JsonElement>()
          map["StorageInconsistentState"] = jsonEncoder.json.encodeToJsonElement(serializer<String>(), value.storageInconsistentState)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StorageError.FlatStorageBlockNotSupported -> {
          val map = mutableMapOf<String, JsonElement>()
          map["FlatStorageBlockNotSupported"] = jsonEncoder.json.encodeToJsonElement(serializer<String>(), value.flatStorageBlockNotSupported)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StorageError.MemTrieLoadingError -> {
          val map = mutableMapOf<String, JsonElement>()
          map["MemTrieLoadingError"] = jsonEncoder.json.encodeToJsonElement(serializer<String>(), value.memTrieLoadingError)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is StorageError.StorageInternalError -> out.encodeSerializableElement(descriptor, 0, serializer<StorageError.StorageInternalError>(), value)
      is StorageError.MissingTrieValue -> out.encodeSerializableElement(descriptor, 1, serializer<StorageError.MissingTrieValue>(), value)
      is StorageError.UnexpectedTrieValue -> out.encodeSerializableElement(descriptor, 2, serializer<StorageError.UnexpectedTrieValue>(), value)
      is StorageError.StorageInconsistentState -> out.encodeSerializableElement(descriptor, 3, serializer<StorageError.StorageInconsistentState>(), value)
      is StorageError.FlatStorageBlockNotSupported -> out.encodeSerializableElement(descriptor, 4, serializer<StorageError.FlatStorageBlockNotSupported>(), value)
      is StorageError.MemTrieLoadingError -> out.encodeSerializableElement(descriptor, 5, serializer<StorageError.MemTrieLoadingError>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): StorageError {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            if (s == "StorageInternalError") return StorageError.StorageInternalError
            if (s == "UnexpectedTrieValue") return StorageError.UnexpectedTrieValue
            throw SerializationException("Unknown discriminator string for StorageError: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing StorageError")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["MissingTrieValue"] != null) {
            val missingTrieValueVal = decoder.json.decodeFromJsonElement(serializer<MissingTrieValue>(), jobj["MissingTrieValue"] ?: throw SerializationException("Missing field 'MissingTrieValue' for variant " + "MissingTrieValue"))
            return StorageError.MissingTrieValue(missingTrieValueVal)
          }
          if (jobj["StorageInconsistentState"] != null) {
            val storageInconsistentStateVal = decoder.json.decodeFromJsonElement(serializer<String>(), jobj["StorageInconsistentState"] ?: throw SerializationException("Missing field 'StorageInconsistentState' for variant " + "StorageInconsistentState"))
            return StorageError.StorageInconsistentState(storageInconsistentStateVal)
          }
          if (jobj["FlatStorageBlockNotSupported"] != null) {
            val flatStorageBlockNotSupportedVal = decoder.json.decodeFromJsonElement(serializer<String>(), jobj["FlatStorageBlockNotSupported"] ?: throw SerializationException("Missing field 'FlatStorageBlockNotSupported' for variant " + "FlatStorageBlockNotSupported"))
            return StorageError.FlatStorageBlockNotSupported(flatStorageBlockNotSupportedVal)
          }
          if (jobj["MemTrieLoadingError"] != null) {
            val memTrieLoadingErrorVal = decoder.json.decodeFromJsonElement(serializer<String>(), jobj["MemTrieLoadingError"] ?: throw SerializationException("Missing field 'MemTrieLoadingError' for variant " + "MemTrieLoadingError"))
            return StorageError.MemTrieLoadingError(memTrieLoadingErrorVal)
          }
          if (listOf("MissingTrieValue").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<StorageError.MissingTrieValue>(), jobj)
          }
          if (listOf("StorageInconsistentState").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<StorageError.StorageInconsistentState>(), jobj)
          }
          if (listOf("FlatStorageBlockNotSupported").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<StorageError.FlatStorageBlockNotSupported>(), jobj)
          }
          if (listOf("MemTrieLoadingError").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<StorageError.MemTrieLoadingError>(), jobj)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "MissingTrieValue" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val missingTrieValueVal = decoder.json.decodeFromJsonElement(serializer<MissingTrieValue>(), obj["MissingTrieValue"] ?: throw SerializationException("Missing field 'MissingTrieValue' for variant " + key))
                return StorageError.MissingTrieValue(missingTrieValueVal)
              }
              "StorageInconsistentState" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val storageInconsistentStateVal = decoder.json.decodeFromJsonElement(serializer<String>(), obj["StorageInconsistentState"] ?: throw SerializationException("Missing field 'StorageInconsistentState' for variant " + key))
                return StorageError.StorageInconsistentState(storageInconsistentStateVal)
              }
              "FlatStorageBlockNotSupported" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val flatStorageBlockNotSupportedVal = decoder.json.decodeFromJsonElement(serializer<String>(), obj["FlatStorageBlockNotSupported"] ?: throw SerializationException("Missing field 'FlatStorageBlockNotSupported' for variant " + key))
                return StorageError.FlatStorageBlockNotSupported(flatStorageBlockNotSupportedVal)
              }
              "MemTrieLoadingError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val memTrieLoadingErrorVal = decoder.json.decodeFromJsonElement(serializer<String>(), obj["MemTrieLoadingError"] ?: throw SerializationException("Missing field 'MemTrieLoadingError' for variant " + key))
                return StorageError.MemTrieLoadingError(memTrieLoadingErrorVal)
              }
              "StorageInternalError" -> {
                return StorageError.StorageInternalError
              }
              "UnexpectedTrieValue" -> {
                return StorageError.UnexpectedTrieValue
              }
              else -> throw SerializationException("Unknown discriminator key for StorageError: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("StorageInternalError", "MissingTrieValue", "UnexpectedTrieValue", "StorageInconsistentState", "FlatStorageBlockNotSupported", "MemTrieLoadingError")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in StorageError")
            val tf = typeField.trim()
            when (tf) {
              "MissingTrieValue" -> {
                return decoder.json.decodeFromJsonElement(serializer<StorageError.MissingTrieValue>(), jobj)
              }
              "StorageInconsistentState" -> {
                return decoder.json.decodeFromJsonElement(serializer<StorageError.StorageInconsistentState>(), jobj)
              }
              "FlatStorageBlockNotSupported" -> {
                return decoder.json.decodeFromJsonElement(serializer<StorageError.FlatStorageBlockNotSupported>(), jobj)
              }
              "MemTrieLoadingError" -> {
                return decoder.json.decodeFromJsonElement(serializer<StorageError.MemTrieLoadingError>(), jobj)
              }
              "StorageInternalError" -> return StorageError.StorageInternalError
              "UnexpectedTrieValue" -> return StorageError.UnexpectedTrieValue
              else -> throw SerializationException("Unknown type discriminator for StorageError: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize StorageError with non-JSON decoder")
  }
}
