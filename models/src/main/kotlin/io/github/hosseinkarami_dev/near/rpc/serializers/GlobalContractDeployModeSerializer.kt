package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode
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

public object GlobalContractDeployModeSerializer : KSerializer<GlobalContractDeployMode> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode") {
        element("CodeHash", serializer<JsonElement>().descriptor)
        element("AccountId", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: GlobalContractDeployMode) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is GlobalContractDeployMode.CodeHash -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("CodeHash"))
        }
        is GlobalContractDeployMode.AccountId -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("AccountId"))
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is GlobalContractDeployMode.CodeHash -> out.encodeSerializableElement(descriptor, 0, serializer<GlobalContractDeployMode.CodeHash>(), value)
      is GlobalContractDeployMode.AccountId -> out.encodeSerializableElement(descriptor, 1, serializer<GlobalContractDeployMode.AccountId>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): GlobalContractDeployMode {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            if (s == "CodeHash") return GlobalContractDeployMode.CodeHash()
            if (s == "AccountId") return GlobalContractDeployMode.AccountId()
          }
          throw SerializationException("Unknown discriminator (primitive) for GlobalContractDeployMode")
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing GlobalContractDeployMode")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "CodeHash" -> {
                return GlobalContractDeployMode.CodeHash()
              }
              "AccountId" -> {
                return GlobalContractDeployMode.AccountId()
              }
              else -> throw SerializationException("Unknown discriminator key for GlobalContractDeployMode: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("CodeHash", "AccountId")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in GlobalContractDeployMode")
            val tf = typeField.trim()
            when (tf) {
              "CodeHash" -> return GlobalContractDeployMode.CodeHash()
              "AccountId" -> return GlobalContractDeployMode.AccountId()
              else -> throw SerializationException("Unknown type discriminator for GlobalContractDeployMode: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize GlobalContractDeployMode with non-JSON decoder")
  }
}
