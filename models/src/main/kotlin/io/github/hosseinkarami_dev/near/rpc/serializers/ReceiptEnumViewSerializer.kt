package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView
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

public object ReceiptEnumViewSerializer : KSerializer<ReceiptEnumView> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView") {
        element("Action", serializer<JsonElement>().descriptor)
        element("Data", serializer<JsonElement>().descriptor)
        element("GlobalContractDistribution", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: ReceiptEnumView) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is ReceiptEnumView.Action -> {
          val map = mutableMapOf<String, JsonElement>()
          map["Action"] = jsonEncoder.json.encodeToJsonElement(serializer<ReceiptEnumView.Action.ActionPayload>(), value.action)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ReceiptEnumView.Data -> {
          val map = mutableMapOf<String, JsonElement>()
          map["Data"] = jsonEncoder.json.encodeToJsonElement(serializer<ReceiptEnumView.Data.DataPayload>(), value.data)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ReceiptEnumView.GlobalContractDistribution -> {
          val map = mutableMapOf<String, JsonElement>()
          map["GlobalContractDistribution"] = jsonEncoder.json.encodeToJsonElement(serializer<ReceiptEnumView.GlobalContractDistribution.GlobalContractDistributionPayload>(), value.globalContractDistribution)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is ReceiptEnumView.Action -> out.encodeSerializableElement(descriptor, 0, serializer<ReceiptEnumView.Action>(), value)
      is ReceiptEnumView.Data -> out.encodeSerializableElement(descriptor, 1, serializer<ReceiptEnumView.Data>(), value)
      is ReceiptEnumView.GlobalContractDistribution -> out.encodeSerializableElement(descriptor, 2, serializer<ReceiptEnumView.GlobalContractDistribution>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): ReceiptEnumView {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            throw SerializationException("Unknown discriminator string for ReceiptEnumView: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing ReceiptEnumView")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["Action"] != null) {
            val actionVal = decoder.json.decodeFromJsonElement(serializer<ReceiptEnumView.Action.ActionPayload>(), jobj["Action"] ?: throw SerializationException("Missing field 'Action' for variant " + "Action"))
            return ReceiptEnumView.Action(actionVal)
          }
          if (jobj["Data"] != null) {
            val dataVal = decoder.json.decodeFromJsonElement(serializer<ReceiptEnumView.Data.DataPayload>(), jobj["Data"] ?: throw SerializationException("Missing field 'Data' for variant " + "Data"))
            return ReceiptEnumView.Data(dataVal)
          }
          if (jobj["GlobalContractDistribution"] != null) {
            val globalContractDistributionVal = decoder.json.decodeFromJsonElement(serializer<ReceiptEnumView.GlobalContractDistribution.GlobalContractDistributionPayload>(), jobj["GlobalContractDistribution"] ?: throw SerializationException("Missing field 'GlobalContractDistribution' for variant " + "GlobalContractDistribution"))
            return ReceiptEnumView.GlobalContractDistribution(globalContractDistributionVal)
          }
          if (listOf("Action").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ReceiptEnumView.Action>(), jobj)
          }
          if (listOf("Data").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ReceiptEnumView.Data>(), jobj)
          }
          if (listOf("GlobalContractDistribution").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ReceiptEnumView.GlobalContractDistribution>(), jobj)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "Action" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ReceiptEnumView.Action>(), obj)
              }
              "Data" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ReceiptEnumView.Data>(), obj)
              }
              "GlobalContractDistribution" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ReceiptEnumView.GlobalContractDistribution>(), obj)
              }
              else -> throw SerializationException("Unknown discriminator key for ReceiptEnumView: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("Action", "Data", "GlobalContractDistribution")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in ReceiptEnumView")
            val tf = typeField.trim()
            when (tf) {
              "Action" -> {
                return decoder.json.decodeFromJsonElement(serializer<ReceiptEnumView.Action>(), jobj)
              }
              "Data" -> {
                return decoder.json.decodeFromJsonElement(serializer<ReceiptEnumView.Data>(), jobj)
              }
              "GlobalContractDistribution" -> {
                return decoder.json.decodeFromJsonElement(serializer<ReceiptEnumView.GlobalContractDistribution>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for ReceiptEnumView: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize ReceiptEnumView with non-JSON decoder")
  }
}
