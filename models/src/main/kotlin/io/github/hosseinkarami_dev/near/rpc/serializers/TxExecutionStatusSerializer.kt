package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus
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

public object TxExecutionStatusSerializer : KSerializer<TxExecutionStatus> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus") {
        element("NONE", serializer<JsonElement>().descriptor)
        element("INCLUDED", serializer<JsonElement>().descriptor)
        element("EXECUTED_OPTIMISTIC", serializer<JsonElement>().descriptor)
        element("INCLUDED_FINAL", serializer<JsonElement>().descriptor)
        element("EXECUTED", serializer<JsonElement>().descriptor)
        element("FINAL", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: TxExecutionStatus) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        TxExecutionStatus.None -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("NONE"))
        }
        TxExecutionStatus.Included -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("INCLUDED"))
        }
        TxExecutionStatus.ExecutedOptimistic -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("EXECUTED_OPTIMISTIC"))
        }
        TxExecutionStatus.IncludedFinal -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("INCLUDED_FINAL"))
        }
        TxExecutionStatus.Executed -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("EXECUTED"))
        }
        TxExecutionStatus.Final -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("FINAL"))
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is TxExecutionStatus.None -> out.encodeSerializableElement(descriptor, 0, serializer<TxExecutionStatus.None>(), value)
      is TxExecutionStatus.Included -> out.encodeSerializableElement(descriptor, 1, serializer<TxExecutionStatus.Included>(), value)
      is TxExecutionStatus.ExecutedOptimistic -> out.encodeSerializableElement(descriptor, 2, serializer<TxExecutionStatus.ExecutedOptimistic>(), value)
      is TxExecutionStatus.IncludedFinal -> out.encodeSerializableElement(descriptor, 3, serializer<TxExecutionStatus.IncludedFinal>(), value)
      is TxExecutionStatus.Executed -> out.encodeSerializableElement(descriptor, 4, serializer<TxExecutionStatus.Executed>(), value)
      is TxExecutionStatus.Final -> out.encodeSerializableElement(descriptor, 5, serializer<TxExecutionStatus.Final>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): TxExecutionStatus {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            if (s == "NONE") return TxExecutionStatus.None
            if (s == "INCLUDED") return TxExecutionStatus.Included
            if (s == "EXECUTED_OPTIMISTIC") return TxExecutionStatus.ExecutedOptimistic
            if (s == "INCLUDED_FINAL") return TxExecutionStatus.IncludedFinal
            if (s == "EXECUTED") return TxExecutionStatus.Executed
            if (s == "FINAL") return TxExecutionStatus.Final
            throw SerializationException("Unknown discriminator string for TxExecutionStatus: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing TxExecutionStatus")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "NONE" -> {
                return TxExecutionStatus.None
              }
              "INCLUDED" -> {
                return TxExecutionStatus.Included
              }
              "EXECUTED_OPTIMISTIC" -> {
                return TxExecutionStatus.ExecutedOptimistic
              }
              "INCLUDED_FINAL" -> {
                return TxExecutionStatus.IncludedFinal
              }
              "EXECUTED" -> {
                return TxExecutionStatus.Executed
              }
              "FINAL" -> {
                return TxExecutionStatus.Final
              }
              else -> throw SerializationException("Unknown discriminator key for TxExecutionStatus: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("NONE", "INCLUDED", "EXECUTED_OPTIMISTIC", "INCLUDED_FINAL", "EXECUTED", "FINAL")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in TxExecutionStatus")
            val tf = typeField.trim()
            when (tf) {
              "NONE" -> return TxExecutionStatus.None
              "INCLUDED" -> return TxExecutionStatus.Included
              "EXECUTED_OPTIMISTIC" -> return TxExecutionStatus.ExecutedOptimistic
              "INCLUDED_FINAL" -> return TxExecutionStatus.IncludedFinal
              "EXECUTED" -> return TxExecutionStatus.Executed
              "FINAL" -> return TxExecutionStatus.Final
              else -> throw SerializationException("Unknown type discriminator for TxExecutionStatus: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize TxExecutionStatus with non-JSON decoder")
  }
}
