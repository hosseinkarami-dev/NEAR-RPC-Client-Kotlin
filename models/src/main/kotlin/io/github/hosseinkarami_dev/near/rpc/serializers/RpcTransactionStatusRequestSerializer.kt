package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.AccountId
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest
import io.github.hosseinkarami_dev.near.rpc.models.SignedTransaction
import io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus
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

public object RpcTransactionStatusRequestSerializer : KSerializer<RpcTransactionStatusRequest> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest") {
        element("signed_tx_base64", serializer<JsonElement>().descriptor)
        element("sender_account_id", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: RpcTransactionStatusRequest) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is RpcTransactionStatusRequest.SignedTxBase64 -> {
          val map = mutableMapOf<String, JsonElement>()
          map["signed_tx_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<SignedTransaction>(), value.signedTxBase64)
          if (value.waitUntil != null) {
            map["wait_until"] = jsonEncoder.json.encodeToJsonElement(serializer<TxExecutionStatus?>(), value.waitUntil)
          }
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcTransactionStatusRequest.SenderAccountId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["sender_account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.senderAccountId)
          map["tx_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.txHash)
          if (value.waitUntil != null) {
            map["wait_until"] = jsonEncoder.json.encodeToJsonElement(serializer<TxExecutionStatus?>(), value.waitUntil)
          }
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is RpcTransactionStatusRequest.SignedTxBase64 -> out.encodeSerializableElement(descriptor, 0, serializer<RpcTransactionStatusRequest.SignedTxBase64>(), value)
      is RpcTransactionStatusRequest.SenderAccountId -> out.encodeSerializableElement(descriptor, 1, serializer<RpcTransactionStatusRequest.SenderAccountId>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): RpcTransactionStatusRequest {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            throw SerializationException("Unknown discriminator string for RpcTransactionStatusRequest: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing RpcTransactionStatusRequest")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["signed_tx_base64"] != null) {
            val signedTxBase64Val = decoder.json.decodeFromJsonElement(serializer<SignedTransaction>(), jobj["signed_tx_base64"] ?: throw SerializationException("Missing field 'signed_tx_base64' for variant " + "SignedTxBase64"))
            val waitUntilVal = jobj["wait_until"]?.let { decoder.json.decodeFromJsonElement(serializer<TxExecutionStatus?>(), it) }
            return RpcTransactionStatusRequest.SignedTxBase64(signedTxBase64Val, waitUntilVal)
          }
          if (jobj["sender_account_id"] != null) {
            val senderAccountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), jobj["sender_account_id"] ?: throw SerializationException("Missing field 'sender_account_id' for variant " + "SenderAccountId"))
            val txHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), jobj["tx_hash"] ?: throw SerializationException("Missing field 'tx_hash' for variant " + "SenderAccountId"))
            val waitUntilVal = jobj["wait_until"]?.let { decoder.json.decodeFromJsonElement(serializer<TxExecutionStatus?>(), it) }
            return RpcTransactionStatusRequest.SenderAccountId(senderAccountIdVal, txHashVal, waitUntilVal)
          }
          if (listOf("signed_tx_base64").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcTransactionStatusRequest.SignedTxBase64>(), jobj)
          }
          if (listOf("sender_account_id", "tx_hash").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcTransactionStatusRequest.SenderAccountId>(), jobj)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "signed_tx_base64" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val signedTxBase64Val = decoder.json.decodeFromJsonElement(serializer<SignedTransaction>(), obj["signed_tx_base64"] ?: throw SerializationException("Missing field 'signed_tx_base64' for variant " + key))
                val waitUntilVal = obj["wait_until"]?.let { decoder.json.decodeFromJsonElement(serializer<TxExecutionStatus?>(), it) }
                return RpcTransactionStatusRequest.SignedTxBase64(signedTxBase64Val, waitUntilVal)
              }
              "sender_account_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val senderAccountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["sender_account_id"] ?: throw SerializationException("Missing field 'sender_account_id' for variant " + key))
                val txHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), obj["tx_hash"] ?: throw SerializationException("Missing field 'tx_hash' for variant " + key))
                val waitUntilVal = obj["wait_until"]?.let { decoder.json.decodeFromJsonElement(serializer<TxExecutionStatus?>(), it) }
                return RpcTransactionStatusRequest.SenderAccountId(senderAccountIdVal, txHashVal, waitUntilVal)
              }
              else -> throw SerializationException("Unknown discriminator key for RpcTransactionStatusRequest: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("signed_tx_base64", "sender_account_id")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in RpcTransactionStatusRequest")
            val tf = typeField.trim()
            when (tf) {
              "signed_tx_base64" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcTransactionStatusRequest.SignedTxBase64>(), jobj)
              }
              "sender_account_id" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcTransactionStatusRequest.SenderAccountId>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for RpcTransactionStatusRequest: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize RpcTransactionStatusRequest with non-JSON decoder")
  }
}
