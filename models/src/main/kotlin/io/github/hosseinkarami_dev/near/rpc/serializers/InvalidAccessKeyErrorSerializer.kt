package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError
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

public object InvalidAccessKeyErrorSerializer : KSerializer<InvalidAccessKeyError> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError") {
        element("AccessKeyNotFound", serializer<JsonElement>().descriptor)
        element("ReceiverMismatch", serializer<JsonElement>().descriptor)
        element("MethodNameMismatch", serializer<JsonElement>().descriptor)
        element("RequiresFullAccess", serializer<JsonElement>().descriptor)
        element("NotEnoughAllowance", serializer<JsonElement>().descriptor)
        element("DepositWithFunctionCall", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: InvalidAccessKeyError) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        InvalidAccessKeyError.RequiresFullAccess -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("RequiresFullAccess"))
        }
        InvalidAccessKeyError.DepositWithFunctionCall -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("DepositWithFunctionCall"))
        }
        is InvalidAccessKeyError.AccessKeyNotFound -> {
          val map = mutableMapOf<String, JsonElement>()
          map["AccessKeyNotFound"] = jsonEncoder.json.encodeToJsonElement(serializer<InvalidAccessKeyError.AccessKeyNotFound.AccessKeyNotFoundPayload>(), value.accessKeyNotFound)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is InvalidAccessKeyError.ReceiverMismatch -> {
          val map = mutableMapOf<String, JsonElement>()
          map["ReceiverMismatch"] = jsonEncoder.json.encodeToJsonElement(serializer<InvalidAccessKeyError.ReceiverMismatch.ReceiverMismatchPayload>(), value.receiverMismatch)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is InvalidAccessKeyError.MethodNameMismatch -> {
          val map = mutableMapOf<String, JsonElement>()
          map["MethodNameMismatch"] = jsonEncoder.json.encodeToJsonElement(serializer<InvalidAccessKeyError.MethodNameMismatch.MethodNameMismatchPayload>(), value.methodNameMismatch)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is InvalidAccessKeyError.NotEnoughAllowance -> {
          val map = mutableMapOf<String, JsonElement>()
          map["NotEnoughAllowance"] = jsonEncoder.json.encodeToJsonElement(serializer<InvalidAccessKeyError.NotEnoughAllowance.NotEnoughAllowancePayload>(), value.notEnoughAllowance)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is InvalidAccessKeyError.AccessKeyNotFound -> out.encodeSerializableElement(descriptor, 0, serializer<InvalidAccessKeyError.AccessKeyNotFound>(), value)
      is InvalidAccessKeyError.ReceiverMismatch -> out.encodeSerializableElement(descriptor, 1, serializer<InvalidAccessKeyError.ReceiverMismatch>(), value)
      is InvalidAccessKeyError.MethodNameMismatch -> out.encodeSerializableElement(descriptor, 2, serializer<InvalidAccessKeyError.MethodNameMismatch>(), value)
      is InvalidAccessKeyError.RequiresFullAccess -> out.encodeSerializableElement(descriptor, 3, serializer<InvalidAccessKeyError.RequiresFullAccess>(), value)
      is InvalidAccessKeyError.NotEnoughAllowance -> out.encodeSerializableElement(descriptor, 4, serializer<InvalidAccessKeyError.NotEnoughAllowance>(), value)
      is InvalidAccessKeyError.DepositWithFunctionCall -> out.encodeSerializableElement(descriptor, 5, serializer<InvalidAccessKeyError.DepositWithFunctionCall>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): InvalidAccessKeyError {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            if (s == "RequiresFullAccess") return InvalidAccessKeyError.RequiresFullAccess
            if (s == "DepositWithFunctionCall") return InvalidAccessKeyError.DepositWithFunctionCall
            throw SerializationException("Unknown discriminator string for InvalidAccessKeyError: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing InvalidAccessKeyError")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["AccessKeyNotFound"] != null) {
            val accessKeyNotFoundVal = decoder.json.decodeFromJsonElement(serializer<InvalidAccessKeyError.AccessKeyNotFound.AccessKeyNotFoundPayload>(), jobj["AccessKeyNotFound"] ?: throw SerializationException("Missing field 'AccessKeyNotFound' for variant " + "AccessKeyNotFound"))
            return InvalidAccessKeyError.AccessKeyNotFound(accessKeyNotFoundVal)
          }
          if (jobj["ReceiverMismatch"] != null) {
            val receiverMismatchVal = decoder.json.decodeFromJsonElement(serializer<InvalidAccessKeyError.ReceiverMismatch.ReceiverMismatchPayload>(), jobj["ReceiverMismatch"] ?: throw SerializationException("Missing field 'ReceiverMismatch' for variant " + "ReceiverMismatch"))
            return InvalidAccessKeyError.ReceiverMismatch(receiverMismatchVal)
          }
          if (jobj["MethodNameMismatch"] != null) {
            val methodNameMismatchVal = decoder.json.decodeFromJsonElement(serializer<InvalidAccessKeyError.MethodNameMismatch.MethodNameMismatchPayload>(), jobj["MethodNameMismatch"] ?: throw SerializationException("Missing field 'MethodNameMismatch' for variant " + "MethodNameMismatch"))
            return InvalidAccessKeyError.MethodNameMismatch(methodNameMismatchVal)
          }
          if (jobj["NotEnoughAllowance"] != null) {
            val notEnoughAllowanceVal = decoder.json.decodeFromJsonElement(serializer<InvalidAccessKeyError.NotEnoughAllowance.NotEnoughAllowancePayload>(), jobj["NotEnoughAllowance"] ?: throw SerializationException("Missing field 'NotEnoughAllowance' for variant " + "NotEnoughAllowance"))
            return InvalidAccessKeyError.NotEnoughAllowance(notEnoughAllowanceVal)
          }
          if (listOf("AccessKeyNotFound").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<InvalidAccessKeyError.AccessKeyNotFound>(), jobj)
          }
          if (listOf("ReceiverMismatch").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<InvalidAccessKeyError.ReceiverMismatch>(), jobj)
          }
          if (listOf("MethodNameMismatch").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<InvalidAccessKeyError.MethodNameMismatch>(), jobj)
          }
          if (listOf("NotEnoughAllowance").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<InvalidAccessKeyError.NotEnoughAllowance>(), jobj)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "AccessKeyNotFound" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val accessKeyNotFoundVal = decoder.json.decodeFromJsonElement(serializer<InvalidAccessKeyError.AccessKeyNotFound.AccessKeyNotFoundPayload>(), obj["AccessKeyNotFound"] ?: throw SerializationException("Missing field 'AccessKeyNotFound' for variant " + key))
                return InvalidAccessKeyError.AccessKeyNotFound(accessKeyNotFoundVal)
              }
              "ReceiverMismatch" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val receiverMismatchVal = decoder.json.decodeFromJsonElement(serializer<InvalidAccessKeyError.ReceiverMismatch.ReceiverMismatchPayload>(), obj["ReceiverMismatch"] ?: throw SerializationException("Missing field 'ReceiverMismatch' for variant " + key))
                return InvalidAccessKeyError.ReceiverMismatch(receiverMismatchVal)
              }
              "MethodNameMismatch" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val methodNameMismatchVal = decoder.json.decodeFromJsonElement(serializer<InvalidAccessKeyError.MethodNameMismatch.MethodNameMismatchPayload>(), obj["MethodNameMismatch"] ?: throw SerializationException("Missing field 'MethodNameMismatch' for variant " + key))
                return InvalidAccessKeyError.MethodNameMismatch(methodNameMismatchVal)
              }
              "NotEnoughAllowance" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val notEnoughAllowanceVal = decoder.json.decodeFromJsonElement(serializer<InvalidAccessKeyError.NotEnoughAllowance.NotEnoughAllowancePayload>(), obj["NotEnoughAllowance"] ?: throw SerializationException("Missing field 'NotEnoughAllowance' for variant " + key))
                return InvalidAccessKeyError.NotEnoughAllowance(notEnoughAllowanceVal)
              }
              "RequiresFullAccess" -> {
                return InvalidAccessKeyError.RequiresFullAccess
              }
              "DepositWithFunctionCall" -> {
                return InvalidAccessKeyError.DepositWithFunctionCall
              }
              else -> throw SerializationException("Unknown discriminator key for InvalidAccessKeyError: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("AccessKeyNotFound", "ReceiverMismatch", "MethodNameMismatch", "RequiresFullAccess", "NotEnoughAllowance", "DepositWithFunctionCall")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in InvalidAccessKeyError")
            val tf = typeField.trim()
            when (tf) {
              "AccessKeyNotFound" -> {
                return decoder.json.decodeFromJsonElement(serializer<InvalidAccessKeyError.AccessKeyNotFound>(), jobj)
              }
              "ReceiverMismatch" -> {
                return decoder.json.decodeFromJsonElement(serializer<InvalidAccessKeyError.ReceiverMismatch>(), jobj)
              }
              "MethodNameMismatch" -> {
                return decoder.json.decodeFromJsonElement(serializer<InvalidAccessKeyError.MethodNameMismatch>(), jobj)
              }
              "NotEnoughAllowance" -> {
                return decoder.json.decodeFromJsonElement(serializer<InvalidAccessKeyError.NotEnoughAllowance>(), jobj)
              }
              "RequiresFullAccess" -> return InvalidAccessKeyError.RequiresFullAccess
              "DepositWithFunctionCall" -> return InvalidAccessKeyError.DepositWithFunctionCall
              else -> throw SerializationException("Unknown type discriminator for InvalidAccessKeyError: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize InvalidAccessKeyError with non-JSON decoder")
  }
}
