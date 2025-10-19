package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.ExecutionOutcomeWithIdView
import io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus
import io.github.hosseinkarami_dev.near.rpc.models.ReceiptView
import io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse
import io.github.hosseinkarami_dev.near.rpc.models.SignedTransactionView
import io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus
import kotlin.collections.mutableMapOf
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
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

public object RpcTransactionResponseSerializer : KSerializer<RpcTransactionResponse> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse") {
        element("FinalExecutionOutcomeWithReceiptView", serializer<JsonElement>().descriptor)
        element("FinalExecutionOutcomeView", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: RpcTransactionResponse) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is RpcTransactionResponse.FinalExecutionOutcomeWithReceiptView -> {
          val map = mutableMapOf<String, JsonElement>()
          map["receipts"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<ReceiptView>()), value.receipts)
          map["receipts_outcome"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<ExecutionOutcomeWithIdView>()), value.receiptsOutcome)
          map["status"] = jsonEncoder.json.encodeToJsonElement(serializer<FinalExecutionStatus>(), value.status)
          map["transaction"] = jsonEncoder.json.encodeToJsonElement(serializer<SignedTransactionView>(), value.transaction)
          map["transaction_outcome"] = jsonEncoder.json.encodeToJsonElement(serializer<ExecutionOutcomeWithIdView>(), value.transactionOutcome)
          map["final_execution_status"] = jsonEncoder.json.encodeToJsonElement(serializer<TxExecutionStatus>(), value.finalExecutionStatus)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcTransactionResponse.FinalExecutionOutcomeView -> {
          val map = mutableMapOf<String, JsonElement>()
          map["receipts_outcome"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<ExecutionOutcomeWithIdView>()), value.receiptsOutcome)
          map["status"] = jsonEncoder.json.encodeToJsonElement(serializer<FinalExecutionStatus>(), value.status)
          map["transaction"] = jsonEncoder.json.encodeToJsonElement(serializer<SignedTransactionView>(), value.transaction)
          map["transaction_outcome"] = jsonEncoder.json.encodeToJsonElement(serializer<ExecutionOutcomeWithIdView>(), value.transactionOutcome)
          map["final_execution_status"] = jsonEncoder.json.encodeToJsonElement(serializer<TxExecutionStatus>(), value.finalExecutionStatus)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is RpcTransactionResponse.FinalExecutionOutcomeWithReceiptView -> out.encodeSerializableElement(descriptor, 0, serializer<RpcTransactionResponse.FinalExecutionOutcomeWithReceiptView>(), value)
      is RpcTransactionResponse.FinalExecutionOutcomeView -> out.encodeSerializableElement(descriptor, 1, serializer<RpcTransactionResponse.FinalExecutionOutcomeView>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): RpcTransactionResponse {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
          }
          throw SerializationException("Unknown discriminator (primitive) for RpcTransactionResponse")
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing RpcTransactionResponse")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj["receipts"] != null) {
            val receiptsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<ReceiptView>()), jobj["receipts"] ?: throw SerializationException("Missing field 'receipts' for variant " + "FinalExecutionOutcomeWithReceiptView"))
            val receiptsOutcomeVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<ExecutionOutcomeWithIdView>()), jobj["receipts_outcome"] ?: throw SerializationException("Missing field 'receipts_outcome' for variant " + "FinalExecutionOutcomeWithReceiptView"))
            val statusVal = decoder.json.decodeFromJsonElement(serializer<FinalExecutionStatus>(), jobj["status"] ?: throw SerializationException("Missing field 'status' for variant " + "FinalExecutionOutcomeWithReceiptView"))
            val transactionVal = decoder.json.decodeFromJsonElement(serializer<SignedTransactionView>(), jobj["transaction"] ?: throw SerializationException("Missing field 'transaction' for variant " + "FinalExecutionOutcomeWithReceiptView"))
            val transactionOutcomeVal = decoder.json.decodeFromJsonElement(serializer<ExecutionOutcomeWithIdView>(), jobj["transaction_outcome"] ?: throw SerializationException("Missing field 'transaction_outcome' for variant " + "FinalExecutionOutcomeWithReceiptView"))
            val finalExecutionStatusVal = decoder.json.decodeFromJsonElement(serializer<TxExecutionStatus>(), jobj["final_execution_status"] ?: throw SerializationException("Missing field 'final_execution_status' for variant " + "FinalExecutionOutcomeWithReceiptView"))
            return RpcTransactionResponse.FinalExecutionOutcomeWithReceiptView(receiptsVal, receiptsOutcomeVal, statusVal, transactionVal, transactionOutcomeVal, finalExecutionStatusVal)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "FinalExecutionOutcomeWithReceiptView" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcTransactionResponse.FinalExecutionOutcomeWithReceiptView>(), obj)
              }
              "FinalExecutionOutcomeView" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcTransactionResponse.FinalExecutionOutcomeView>(), obj)
              }
              else -> throw SerializationException("Unknown discriminator key for RpcTransactionResponse: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("FinalExecutionOutcomeWithReceiptView", "FinalExecutionOutcomeView")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in RpcTransactionResponse")
            val tf = typeField.trim()
            when (tf) {
              "FinalExecutionOutcomeWithReceiptView" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcTransactionResponse.FinalExecutionOutcomeWithReceiptView>(), jobj)
              }
              "FinalExecutionOutcomeView" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcTransactionResponse.FinalExecutionOutcomeView>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for RpcTransactionResponse: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize RpcTransactionResponse with non-JSON decoder")
  }
}
