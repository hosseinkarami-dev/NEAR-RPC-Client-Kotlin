package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView
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

public object StateChangeCauseViewSerializer : KSerializer<StateChangeCauseView> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView") {
        element("not_writable_to_disk", serializer<JsonElement>().descriptor)
        element("initial_state", serializer<JsonElement>().descriptor)
        element("transaction_processing", serializer<JsonElement>().descriptor)
        element("action_receipt_processing_started", serializer<JsonElement>().descriptor)
        element("action_receipt_gas_reward", serializer<JsonElement>().descriptor)
        element("receipt_processing", serializer<JsonElement>().descriptor)
        element("postponed_receipt", serializer<JsonElement>().descriptor)
        element("updated_delayed_receipts", serializer<JsonElement>().descriptor)
        element("validator_accounts_update", serializer<JsonElement>().descriptor)
        element("migration", serializer<JsonElement>().descriptor)
        element("bandwidth_scheduler_state_update", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: StateChangeCauseView) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is StateChangeCauseView.NotWritableToDisk -> {
          val map = mutableMapOf<String, JsonElement>()
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeCauseView.NotWritableToDisk.Type>(), value.type)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeCauseView.InitialState -> {
          val map = mutableMapOf<String, JsonElement>()
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeCauseView.InitialState.Type>(), value.type)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeCauseView.TransactionProcessing -> {
          val map = mutableMapOf<String, JsonElement>()
          map["tx_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.txHash)
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeCauseView.TransactionProcessing.Type>(), value.type)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeCauseView.ActionReceiptProcessingStarted -> {
          val map = mutableMapOf<String, JsonElement>()
          map["receipt_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.receiptHash)
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeCauseView.ActionReceiptProcessingStarted.Type>(), value.type)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeCauseView.ActionReceiptGasReward -> {
          val map = mutableMapOf<String, JsonElement>()
          map["receipt_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.receiptHash)
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeCauseView.ActionReceiptGasReward.Type>(), value.type)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeCauseView.ReceiptProcessing -> {
          val map = mutableMapOf<String, JsonElement>()
          map["receipt_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.receiptHash)
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeCauseView.ReceiptProcessing.Type>(), value.type)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeCauseView.PostponedReceipt -> {
          val map = mutableMapOf<String, JsonElement>()
          map["receipt_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.receiptHash)
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeCauseView.PostponedReceipt.Type>(), value.type)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeCauseView.UpdatedDelayedReceipts -> {
          val map = mutableMapOf<String, JsonElement>()
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeCauseView.UpdatedDelayedReceipts.Type>(), value.type)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeCauseView.ValidatorAccountsUpdate -> {
          val map = mutableMapOf<String, JsonElement>()
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeCauseView.ValidatorAccountsUpdate.Type>(), value.type)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeCauseView.Migration -> {
          val map = mutableMapOf<String, JsonElement>()
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeCauseView.Migration.Type>(), value.type)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeCauseView.BandwidthSchedulerStateUpdate -> {
          val map = mutableMapOf<String, JsonElement>()
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeCauseView.BandwidthSchedulerStateUpdate.Type>(), value.type)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is StateChangeCauseView.NotWritableToDisk -> out.encodeSerializableElement(descriptor, 0, serializer<StateChangeCauseView.NotWritableToDisk>(), value)
      is StateChangeCauseView.InitialState -> out.encodeSerializableElement(descriptor, 1, serializer<StateChangeCauseView.InitialState>(), value)
      is StateChangeCauseView.TransactionProcessing -> out.encodeSerializableElement(descriptor, 2, serializer<StateChangeCauseView.TransactionProcessing>(), value)
      is StateChangeCauseView.ActionReceiptProcessingStarted -> out.encodeSerializableElement(descriptor, 3, serializer<StateChangeCauseView.ActionReceiptProcessingStarted>(), value)
      is StateChangeCauseView.ActionReceiptGasReward -> out.encodeSerializableElement(descriptor, 4, serializer<StateChangeCauseView.ActionReceiptGasReward>(), value)
      is StateChangeCauseView.ReceiptProcessing -> out.encodeSerializableElement(descriptor, 5, serializer<StateChangeCauseView.ReceiptProcessing>(), value)
      is StateChangeCauseView.PostponedReceipt -> out.encodeSerializableElement(descriptor, 6, serializer<StateChangeCauseView.PostponedReceipt>(), value)
      is StateChangeCauseView.UpdatedDelayedReceipts -> out.encodeSerializableElement(descriptor, 7, serializer<StateChangeCauseView.UpdatedDelayedReceipts>(), value)
      is StateChangeCauseView.ValidatorAccountsUpdate -> out.encodeSerializableElement(descriptor, 8, serializer<StateChangeCauseView.ValidatorAccountsUpdate>(), value)
      is StateChangeCauseView.Migration -> out.encodeSerializableElement(descriptor, 9, serializer<StateChangeCauseView.Migration>(), value)
      is StateChangeCauseView.BandwidthSchedulerStateUpdate -> out.encodeSerializableElement(descriptor, 10, serializer<StateChangeCauseView.BandwidthSchedulerStateUpdate>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): StateChangeCauseView {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            throw SerializationException("Unknown discriminator string for StateChangeCauseView: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing StateChangeCauseView")
        }
        is JsonObject -> {
          val jobj = element
          if (listOf("type").all { jobj[it] != null }) {
            val tfElem = jobj["type"]
            if (tfElem is JsonPrimitive) {
              val tfVal = tfElem.content
              when (tfVal) {
                "not_writable_to_disk" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.NotWritableToDisk>(), jobj)
                }
                "initial_state" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.InitialState>(), jobj)
                }
                "updated_delayed_receipts" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.UpdatedDelayedReceipts>(), jobj)
                }
                "validator_accounts_update" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.ValidatorAccountsUpdate>(), jobj)
                }
                "migration" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.Migration>(), jobj)
                }
                "bandwidth_scheduler_state_update" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.BandwidthSchedulerStateUpdate>(), jobj)
                }
                else -> { /* not recognized by type field, fallthrough */ }
              }
            }
          }
          if (listOf("tx_hash", "type").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.TransactionProcessing>(), jobj)
          }
          if (listOf("receipt_hash", "type").all { jobj[it] != null }) {
            val tfElem = jobj["type"]
            if (tfElem is JsonPrimitive) {
              val tfVal = tfElem.content
              when (tfVal) {
                "action_receipt_processing_started" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.ActionReceiptProcessingStarted>(), jobj)
                }
                "action_receipt_gas_reward" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.ActionReceiptGasReward>(), jobj)
                }
                "receipt_processing" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.ReceiptProcessing>(), jobj)
                }
                "postponed_receipt" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.PostponedReceipt>(), jobj)
                }
                else -> { /* not recognized by type field, fallthrough */ }
              }
            }
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "not_writable_to_disk" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.NotWritableToDisk.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                return StateChangeCauseView.NotWritableToDisk(typeVal)
              }
              "initial_state" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.InitialState.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                return StateChangeCauseView.InitialState(typeVal)
              }
              "transaction_processing" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val txHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), obj["tx_hash"] ?: throw SerializationException("Missing field 'tx_hash' for variant " + key))
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.TransactionProcessing.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                return StateChangeCauseView.TransactionProcessing(txHashVal, typeVal)
              }
              "action_receipt_processing_started" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val receiptHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), obj["receipt_hash"] ?: throw SerializationException("Missing field 'receipt_hash' for variant " + key))
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.ActionReceiptProcessingStarted.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                return StateChangeCauseView.ActionReceiptProcessingStarted(receiptHashVal, typeVal)
              }
              "action_receipt_gas_reward" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val receiptHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), obj["receipt_hash"] ?: throw SerializationException("Missing field 'receipt_hash' for variant " + key))
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.ActionReceiptGasReward.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                return StateChangeCauseView.ActionReceiptGasReward(receiptHashVal, typeVal)
              }
              "receipt_processing" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val receiptHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), obj["receipt_hash"] ?: throw SerializationException("Missing field 'receipt_hash' for variant " + key))
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.ReceiptProcessing.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                return StateChangeCauseView.ReceiptProcessing(receiptHashVal, typeVal)
              }
              "postponed_receipt" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val receiptHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), obj["receipt_hash"] ?: throw SerializationException("Missing field 'receipt_hash' for variant " + key))
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.PostponedReceipt.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                return StateChangeCauseView.PostponedReceipt(receiptHashVal, typeVal)
              }
              "updated_delayed_receipts" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.UpdatedDelayedReceipts.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                return StateChangeCauseView.UpdatedDelayedReceipts(typeVal)
              }
              "validator_accounts_update" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.ValidatorAccountsUpdate.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                return StateChangeCauseView.ValidatorAccountsUpdate(typeVal)
              }
              "migration" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.Migration.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                return StateChangeCauseView.Migration(typeVal)
              }
              "bandwidth_scheduler_state_update" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.BandwidthSchedulerStateUpdate.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                return StateChangeCauseView.BandwidthSchedulerStateUpdate(typeVal)
              }
              else -> throw SerializationException("Unknown discriminator key for StateChangeCauseView: " + key)
            }
          }
          else {
            var typeField: String? = null
            val discriminatorCandidates = listOf("type")
            for (cand in discriminatorCandidates) {
              val candElem = jobj[cand]
              if (candElem is JsonPrimitive) {
                typeField = candElem.contentOrNull
                if (typeField != null) break
              }
            }
            if (typeField == null) {
              val knownVariantNames = setOf("not_writable_to_disk", "initial_state", "transaction_processing", "action_receipt_processing_started", "action_receipt_gas_reward", "receipt_processing", "postponed_receipt", "updated_delayed_receipts", "validator_accounts_update", "migration", "bandwidth_scheduler_state_update")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator (one of type) or recognizable variant in StateChangeCauseView")
            val tf = typeField.trim()
            when (tf) {
              "not_writable_to_disk" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.NotWritableToDisk>(), jobj)
              }
              "initial_state" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.InitialState>(), jobj)
              }
              "transaction_processing" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.TransactionProcessing>(), jobj)
              }
              "action_receipt_processing_started" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.ActionReceiptProcessingStarted>(), jobj)
              }
              "action_receipt_gas_reward" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.ActionReceiptGasReward>(), jobj)
              }
              "receipt_processing" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.ReceiptProcessing>(), jobj)
              }
              "postponed_receipt" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.PostponedReceipt>(), jobj)
              }
              "updated_delayed_receipts" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.UpdatedDelayedReceipts>(), jobj)
              }
              "validator_accounts_update" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.ValidatorAccountsUpdate>(), jobj)
              }
              "migration" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.Migration>(), jobj)
              }
              "bandwidth_scheduler_state_update" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView.BandwidthSchedulerStateUpdate>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for StateChangeCauseView: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize StateChangeCauseView with non-JSON decoder")
  }
}
