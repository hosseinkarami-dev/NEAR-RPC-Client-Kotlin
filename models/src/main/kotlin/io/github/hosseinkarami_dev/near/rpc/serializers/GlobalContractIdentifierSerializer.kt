package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.AccountId
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifier
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

public object GlobalContractIdentifierSerializer : KSerializer<GlobalContractIdentifier> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifier")

  override fun serialize(encoder: Encoder, `value`: GlobalContractIdentifier) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is GlobalContractIdentifier.CodeHash -> {
          val map = mutableMapOf<String, JsonElement>()
          map["CodeHash"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.codeHash)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is GlobalContractIdentifier.AccountId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["AccountId"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is GlobalContractIdentifier.CodeHash -> out.encodeSerializableElement(descriptor, 0, serializer<CryptoHash>(), value.codeHash)
      is GlobalContractIdentifier.AccountId -> out.encodeSerializableElement(descriptor, 1, serializer<AccountId>(), value.accountId)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): GlobalContractIdentifier {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            throw SerializationException("Unknown discriminator string for GlobalContractIdentifier: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing GlobalContractIdentifier")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["CodeHash"] != null) {
            val codeHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), jobj["CodeHash"] ?: throw SerializationException("Missing field 'CodeHash' for variant " + "CodeHash"))
            return GlobalContractIdentifier.CodeHash(codeHashVal)
          }
          if (jobj["AccountId"] != null) {
            val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), jobj["AccountId"] ?: throw SerializationException("Missing field 'AccountId' for variant " + "AccountId"))
            return GlobalContractIdentifier.AccountId(accountIdVal)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "CodeHash" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val codeHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), obj["CodeHash"] ?: throw SerializationException("Missing field 'CodeHash' for variant " + key))
                return GlobalContractIdentifier.CodeHash(codeHashVal)
              }
              "AccountId" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["AccountId"] ?: throw SerializationException("Missing field 'AccountId' for variant " + key))
                return GlobalContractIdentifier.AccountId(accountIdVal)
              }
              else -> throw SerializationException("Unknown discriminator key for GlobalContractIdentifier: " + key)
            }
          }
          else {
            val typeField = jobj["type"]?.jsonPrimitive?.contentOrNull ?: throw SerializationException("Missing 'type' discriminator in GlobalContractIdentifier")
            when (typeField) {
              "CodeHash" -> {
                return decoder.json.decodeFromJsonElement(serializer<GlobalContractIdentifier.CodeHash>(), jobj)
              }
              "AccountId" -> {
                return decoder.json.decodeFromJsonElement(serializer<GlobalContractIdentifier.AccountId>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for GlobalContractIdentifier: " + typeField)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize GlobalContractIdentifier with non-JSON decoder")
  }
}
