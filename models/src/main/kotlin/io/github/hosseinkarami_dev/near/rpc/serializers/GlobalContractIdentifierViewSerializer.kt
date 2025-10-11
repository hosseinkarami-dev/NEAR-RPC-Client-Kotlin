package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.AccountId
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView
import java.lang.Exception
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

public object GlobalContractIdentifierViewSerializer : KSerializer<GlobalContractIdentifierView> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView") {
        element("CryptoHash", serializer<JsonElement>().descriptor)
        element("AccountId", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: GlobalContractIdentifierView) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is GlobalContractIdentifierView.CryptoHash -> {
          val payloadJson = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.value)
          jsonEncoder.encodeJsonElement(payloadJson)
        }
        is GlobalContractIdentifierView.AccountId -> {
          val payloadJson = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.value)
          jsonEncoder.encodeJsonElement(payloadJson)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is GlobalContractIdentifierView.CryptoHash -> out.encodeSerializableElement(descriptor, 0, serializer<GlobalContractIdentifierView.CryptoHash>(), value)
      is GlobalContractIdentifierView.AccountId -> out.encodeSerializableElement(descriptor, 1, serializer<GlobalContractIdentifierView.AccountId>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): GlobalContractIdentifierView {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          try {
            val payload = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), element)
            return GlobalContractIdentifierView.CryptoHash(payload)
          } catch (_: Exception) {
            // not this variant — try next
          }
          try {
            val payload = decoder.json.decodeFromJsonElement(serializer<AccountId>(), element)
            return GlobalContractIdentifierView.AccountId(payload)
          } catch (_: Exception) {
            // not this variant — try next
          }
          if (element.isString) {
            val s = element.content
            throw SerializationException("Unknown discriminator string for GlobalContractIdentifierView: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing GlobalContractIdentifierView")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["CryptoHash"] != null) {
            return GlobalContractIdentifierView.CryptoHash(decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), jobj["CryptoHash"]!!))
          }
          if (jobj["AccountId"] != null) {
            return GlobalContractIdentifierView.AccountId(decoder.json.decodeFromJsonElement(serializer<AccountId>(), jobj["AccountId"]!!))
          }
          if (listOf("CryptoHash").all { jobj[it] != null }) {
            return GlobalContractIdentifierView.CryptoHash(decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), jobj["CryptoHash"]!!))
          }
          if (listOf("AccountId").all { jobj[it] != null }) {
            return GlobalContractIdentifierView.AccountId(decoder.json.decodeFromJsonElement(serializer<AccountId>(), jobj["AccountId"]!!))
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "CryptoHash" -> {
                return GlobalContractIdentifierView.CryptoHash(decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), valueElem))
              }
              "AccountId" -> {
                return GlobalContractIdentifierView.AccountId(decoder.json.decodeFromJsonElement(serializer<AccountId>(), valueElem))
              }
              else -> throw SerializationException("Unknown discriminator key for GlobalContractIdentifierView: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("CryptoHash", "AccountId")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in GlobalContractIdentifierView")
            val tf = typeField.trim()
            when (tf) {
              "CryptoHash" -> {
                val payloadElem = jobj["value"] ?: throw SerializationException("Missing field 'value' for variant " + tf)
                return GlobalContractIdentifierView.CryptoHash(decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), payloadElem))
              }
              "AccountId" -> {
                val payloadElem = jobj["value"] ?: throw SerializationException("Missing field 'value' for variant " + tf)
                return GlobalContractIdentifierView.AccountId(decoder.json.decodeFromJsonElement(serializer<AccountId>(), payloadElem))
              }
              else -> throw SerializationException("Unknown type discriminator for GlobalContractIdentifierView: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize GlobalContractIdentifierView with non-JSON decoder")
  }
}
