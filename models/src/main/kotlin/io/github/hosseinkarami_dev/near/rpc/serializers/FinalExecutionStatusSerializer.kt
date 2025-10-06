package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus
import io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError
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

public object FinalExecutionStatusSerializer : KSerializer<FinalExecutionStatus> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus")

  override fun serialize(encoder: Encoder, `value`: FinalExecutionStatus) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        FinalExecutionStatus.NotStarted -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("NotStarted"))
        }
        FinalExecutionStatus.Started -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("Started"))
        }
        is FinalExecutionStatus.Failure -> {
          val map = mutableMapOf<String, JsonElement>()
          map["Failure"] = jsonEncoder.json.encodeToJsonElement(serializer<TxExecutionError>(), value.failure)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is FinalExecutionStatus.SuccessValue -> {
          val map = mutableMapOf<String, JsonElement>()
          map["SuccessValue"] = jsonEncoder.json.encodeToJsonElement(serializer<String>(), value.successValue)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      FinalExecutionStatus.NotStarted -> out.encodeStringElement(descriptor, 0, "NotStarted")
      FinalExecutionStatus.Started -> out.encodeStringElement(descriptor, 1, "Started")
      is FinalExecutionStatus.Failure -> out.encodeSerializableElement(descriptor, 2, serializer<TxExecutionError>(), value.failure)
      is FinalExecutionStatus.SuccessValue -> out.encodeSerializableElement(descriptor, 3, serializer<String>(), value.successValue)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): FinalExecutionStatus {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            if (s == "NotStarted") return FinalExecutionStatus.NotStarted
            if (s == "Started") return FinalExecutionStatus.Started
            throw SerializationException("Unknown discriminator string for FinalExecutionStatus: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing FinalExecutionStatus")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["Failure"] != null) {
            val failureVal = decoder.json.decodeFromJsonElement(serializer<TxExecutionError>(), jobj["Failure"] ?: throw SerializationException("Missing field 'Failure' for variant " + "Failure"))
            return FinalExecutionStatus.Failure(failureVal)
          }
          if (jobj["SuccessValue"] != null) {
            val successValueVal = decoder.json.decodeFromJsonElement(serializer<String>(), jobj["SuccessValue"] ?: throw SerializationException("Missing field 'SuccessValue' for variant " + "SuccessValue"))
            return FinalExecutionStatus.SuccessValue(successValueVal)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "Failure" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val failureVal = decoder.json.decodeFromJsonElement(serializer<TxExecutionError>(), obj["Failure"] ?: throw SerializationException("Missing field 'Failure' for variant " + key))
                return FinalExecutionStatus.Failure(failureVal)
              }
              "SuccessValue" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val successValueVal = decoder.json.decodeFromJsonElement(serializer<String>(), obj["SuccessValue"] ?: throw SerializationException("Missing field 'SuccessValue' for variant " + key))
                return FinalExecutionStatus.SuccessValue(successValueVal)
              }
              "NotStarted" -> {
                return FinalExecutionStatus.NotStarted
              }
              "Started" -> {
                return FinalExecutionStatus.Started
              }
              else -> throw SerializationException("Unknown discriminator key for FinalExecutionStatus: " + key)
            }
          }
          else {
            val typeField = jobj["type"]?.jsonPrimitive?.contentOrNull ?: throw SerializationException("Missing 'type' discriminator in FinalExecutionStatus")
            when (typeField) {
              "Failure" -> {
                return decoder.json.decodeFromJsonElement(serializer<FinalExecutionStatus.Failure>(), jobj)
              }
              "SuccessValue" -> {
                return decoder.json.decodeFromJsonElement(serializer<FinalExecutionStatus.SuccessValue>(), jobj)
              }
              "NotStarted" -> return FinalExecutionStatus.NotStarted
              "Started" -> return FinalExecutionStatus.Started
              else -> throw SerializationException("Unknown type discriminator for FinalExecutionStatus: " + typeField)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize FinalExecutionStatus with non-JSON decoder")
  }
}
