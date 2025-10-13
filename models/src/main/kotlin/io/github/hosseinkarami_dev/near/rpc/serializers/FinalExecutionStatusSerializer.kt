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
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus") {
        element("NotStarted", serializer<JsonElement>().descriptor)
        element("Started", serializer<JsonElement>().descriptor)
        element("Failure", serializer<JsonElement>().descriptor)
        element("SuccessValue", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: FinalExecutionStatus) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is FinalExecutionStatus.NotStarted -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("NotStarted"))
        }
        is FinalExecutionStatus.Started -> {
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
      is FinalExecutionStatus.NotStarted -> out.encodeSerializableElement(descriptor, 0, serializer<FinalExecutionStatus.NotStarted>(), value)
      is FinalExecutionStatus.Started -> out.encodeSerializableElement(descriptor, 1, serializer<FinalExecutionStatus.Started>(), value)
      is FinalExecutionStatus.Failure -> out.encodeSerializableElement(descriptor, 2, serializer<FinalExecutionStatus.Failure>(), value)
      is FinalExecutionStatus.SuccessValue -> out.encodeSerializableElement(descriptor, 3, serializer<FinalExecutionStatus.SuccessValue>(), value)
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
            if (s == "NotStarted") return FinalExecutionStatus.NotStarted()
            if (s == "Started") return FinalExecutionStatus.Started()
          }
          throw SerializationException("Unknown discriminator (primitive) for FinalExecutionStatus")
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing FinalExecutionStatus")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj["Failure"] != null) {
            return FinalExecutionStatus.Failure(decoder.json.decodeFromJsonElement(serializer<TxExecutionError>(), jobj["Failure"]!!))
          }
          if (jobj["SuccessValue"] != null) {
            return FinalExecutionStatus.SuccessValue(decoder.json.decodeFromJsonElement(serializer<String>(), jobj["SuccessValue"]!!))
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "Failure" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<FinalExecutionStatus.Failure>(), obj)
              }
              "SuccessValue" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<FinalExecutionStatus.SuccessValue>(), obj)
              }
              "NotStarted" -> {
                return FinalExecutionStatus.NotStarted()
              }
              "Started" -> {
                return FinalExecutionStatus.Started()
              }
              else -> throw SerializationException("Unknown discriminator key for FinalExecutionStatus: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("NotStarted", "Started", "Failure", "SuccessValue")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in FinalExecutionStatus")
            val tf = typeField.trim()
            when (tf) {
              "Failure" -> {
                return decoder.json.decodeFromJsonElement(serializer<FinalExecutionStatus.Failure>(), jobj)
              }
              "SuccessValue" -> {
                return decoder.json.decodeFromJsonElement(serializer<FinalExecutionStatus.SuccessValue>(), jobj)
              }
              "NotStarted" -> return FinalExecutionStatus.NotStarted()
              "Started" -> return FinalExecutionStatus.Started()
              else -> throw SerializationException("Unknown type discriminator for FinalExecutionStatus: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize FinalExecutionStatus with non-JSON decoder")
  }
}
