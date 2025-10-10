package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.AccountId
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest
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

public object RpcLightClientExecutionProofRequestSerializer : KSerializer<RpcLightClientExecutionProofRequest> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest") {
        element("transaction", serializer<JsonElement>().descriptor)
        element("receipt", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: RpcLightClientExecutionProofRequest) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is RpcLightClientExecutionProofRequest.Transaction -> {
          val map = mutableMapOf<String, JsonElement>()
          map["sender_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.senderId)
          map["transaction_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.transactionHash)
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcLightClientExecutionProofRequest.Transaction.Type>(), value.type)
          map["light_client_head"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.lightClientHead)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcLightClientExecutionProofRequest.Receipt -> {
          val map = mutableMapOf<String, JsonElement>()
          map["receipt_id"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.receiptId)
          map["receiver_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.receiverId)
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcLightClientExecutionProofRequest.Receipt.Type>(), value.type)
          map["light_client_head"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.lightClientHead)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is RpcLightClientExecutionProofRequest.Transaction -> out.encodeSerializableElement(descriptor, 0, serializer<RpcLightClientExecutionProofRequest.Transaction>(), value)
      is RpcLightClientExecutionProofRequest.Receipt -> out.encodeSerializableElement(descriptor, 1, serializer<RpcLightClientExecutionProofRequest.Receipt>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): RpcLightClientExecutionProofRequest {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            throw SerializationException("Unknown discriminator string for RpcLightClientExecutionProofRequest: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing RpcLightClientExecutionProofRequest")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["sender_id"] != null) {
            val senderIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), jobj["sender_id"] ?: throw SerializationException("Missing field 'sender_id' for variant " + "Transaction"))
            val transactionHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), jobj["transaction_hash"] ?: throw SerializationException("Missing field 'transaction_hash' for variant " + "Transaction"))
            val typeVal = decoder.json.decodeFromJsonElement(serializer<RpcLightClientExecutionProofRequest.Transaction.Type>(), jobj["type"] ?: throw SerializationException("Missing field 'type' for variant " + "Transaction"))
            val lightClientHeadVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), jobj["light_client_head"] ?: throw SerializationException("Missing field 'light_client_head' for variant " + "Transaction"))
            return RpcLightClientExecutionProofRequest.Transaction(senderIdVal, transactionHashVal, typeVal, lightClientHeadVal)
          }
          if (jobj["receipt_id"] != null) {
            val receiptIdVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), jobj["receipt_id"] ?: throw SerializationException("Missing field 'receipt_id' for variant " + "Receipt"))
            val receiverIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), jobj["receiver_id"] ?: throw SerializationException("Missing field 'receiver_id' for variant " + "Receipt"))
            val typeVal = decoder.json.decodeFromJsonElement(serializer<RpcLightClientExecutionProofRequest.Receipt.Type>(), jobj["type"] ?: throw SerializationException("Missing field 'type' for variant " + "Receipt"))
            val lightClientHeadVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), jobj["light_client_head"] ?: throw SerializationException("Missing field 'light_client_head' for variant " + "Receipt"))
            return RpcLightClientExecutionProofRequest.Receipt(receiptIdVal, receiverIdVal, typeVal, lightClientHeadVal)
          }
          if (listOf("light_client_head", "sender_id", "transaction_hash", "type").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcLightClientExecutionProofRequest.Transaction>(), jobj)
          }
          if (listOf("light_client_head", "receipt_id", "receiver_id", "type").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcLightClientExecutionProofRequest.Receipt>(), jobj)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "transaction" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val senderIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["sender_id"] ?: throw SerializationException("Missing field 'sender_id' for variant " + key))
                val transactionHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), obj["transaction_hash"] ?: throw SerializationException("Missing field 'transaction_hash' for variant " + key))
                val typeVal = decoder.json.decodeFromJsonElement(serializer<RpcLightClientExecutionProofRequest.Transaction.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                val lightClientHeadVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), obj["light_client_head"] ?: throw SerializationException("Missing field 'light_client_head' for variant " + key))
                return RpcLightClientExecutionProofRequest.Transaction(senderIdVal, transactionHashVal, typeVal, lightClientHeadVal)
              }
              "receipt" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val receiptIdVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), obj["receipt_id"] ?: throw SerializationException("Missing field 'receipt_id' for variant " + key))
                val receiverIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["receiver_id"] ?: throw SerializationException("Missing field 'receiver_id' for variant " + key))
                val typeVal = decoder.json.decodeFromJsonElement(serializer<RpcLightClientExecutionProofRequest.Receipt.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                val lightClientHeadVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), obj["light_client_head"] ?: throw SerializationException("Missing field 'light_client_head' for variant " + key))
                return RpcLightClientExecutionProofRequest.Receipt(receiptIdVal, receiverIdVal, typeVal, lightClientHeadVal)
              }
              else -> throw SerializationException("Unknown discriminator key for RpcLightClientExecutionProofRequest: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("transaction", "receipt")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in RpcLightClientExecutionProofRequest")
            val tf = typeField.trim()
            when (tf) {
              "transaction" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcLightClientExecutionProofRequest.Transaction>(), jobj)
              }
              "receipt" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcLightClientExecutionProofRequest.Receipt>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for RpcLightClientExecutionProofRequest: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize RpcLightClientExecutionProofRequest with non-JSON decoder")
  }
}
