package io.github.hosseinkarami_dev.near.rpc.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
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
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.serializer
import io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView
import kotlinx.serialization.json.*

object StateChangeCauseViewSerializer : KSerializer<StateChangeCauseView> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView") {
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

    override fun serialize(encoder: Encoder, value: StateChangeCauseView) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.NotWritableToDisk -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.NotWritableToDisk.Type>(), value.type)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.InitialState -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.InitialState.Type>(), value.type)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.TransactionProcessing -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["tx_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.txHash)
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.TransactionProcessing.Type>(), value.type)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptProcessingStarted -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["receipt_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.receiptHash)
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptProcessingStarted.Type>(), value.type)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptGasReward -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["receipt_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.receiptHash)
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptGasReward.Type>(), value.type)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ReceiptProcessing -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["receipt_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.receiptHash)
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ReceiptProcessing.Type>(), value.type)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.PostponedReceipt -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["receipt_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.receiptHash)
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.PostponedReceipt.Type>(), value.type)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.UpdatedDelayedReceipts -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.UpdatedDelayedReceipts.Type>(), value.type)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ValidatorAccountsUpdate -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ValidatorAccountsUpdate.Type>(), value.type)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.Migration -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.Migration.Type>(), value.type)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.BandwidthSchedulerStateUpdate -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.BandwidthSchedulerStateUpdate.Type>(), value.type)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.NotWritableToDisk -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.NotWritableToDisk>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.InitialState -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.InitialState>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.TransactionProcessing -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.TransactionProcessing>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptProcessingStarted -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptProcessingStarted>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptGasReward -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptGasReward>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ReceiptProcessing -> out.encodeSerializableElement(descriptor, 5, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ReceiptProcessing>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.PostponedReceipt -> out.encodeSerializableElement(descriptor, 6, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.PostponedReceipt>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.UpdatedDelayedReceipts -> out.encodeSerializableElement(descriptor, 7, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.UpdatedDelayedReceipts>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ValidatorAccountsUpdate -> out.encodeSerializableElement(descriptor, 8, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ValidatorAccountsUpdate>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.Migration -> out.encodeSerializableElement(descriptor, 9, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.Migration>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.BandwidthSchedulerStateUpdate -> out.encodeSerializableElement(descriptor, 10, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.BandwidthSchedulerStateUpdate>(), value)
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
                    }
                    throw SerializationException("Unknown discriminator (primitive) for StateChangeCauseView")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing StateChangeCauseView")

                is JsonObject -> {
                    val jobj = element
                    if (jobj["tx_hash"] != null) {
                        val txHashVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), jobj["tx_hash"] ?: throw SerializationException("Missing field 'tx_hash' for variant TransactionProcessing"))
                        val typeVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.TransactionProcessing.Type>(), jobj["type"] ?: throw SerializationException("Missing field 'type' for variant TransactionProcessing"))
                        return io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.TransactionProcessing(txHashVal, typeVal)
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "not_writable_to_disk" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant not_writable_to_disk: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.NotWritableToDisk>(), obj)
                            }
                            "initial_state" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant initial_state: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.InitialState>(), obj)
                            }
                            "transaction_processing" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant transaction_processing: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.TransactionProcessing>(), obj)
                            }
                            "action_receipt_processing_started" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant action_receipt_processing_started: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptProcessingStarted>(), obj)
                            }
                            "action_receipt_gas_reward" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant action_receipt_gas_reward: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptGasReward>(), obj)
                            }
                            "receipt_processing" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant receipt_processing: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ReceiptProcessing>(), obj)
                            }
                            "postponed_receipt" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant postponed_receipt: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.PostponedReceipt>(), obj)
                            }
                            "updated_delayed_receipts" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant updated_delayed_receipts: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.UpdatedDelayedReceipts>(), obj)
                            }
                            "validator_accounts_update" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant validator_accounts_update: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ValidatorAccountsUpdate>(), obj)
                            }
                            "migration" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant migration: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.Migration>(), obj)
                            }
                            "bandwidth_scheduler_state_update" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant bandwidth_scheduler_state_update: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.BandwidthSchedulerStateUpdate>(), obj)
                            }
                            else -> throw SerializationException("Unknown discriminator key for StateChangeCauseView: " + key)
                        }
                    }
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

                    if (typeField != null) {
                        val tf = typeField.trim()
                        // try exact match of full variant name first
                        when (tf) {
                            "not_writable_to_disk" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.NotWritableToDisk>(), jobj)
                            "initial_state" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.InitialState>(), jobj)
                            "transaction_processing" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.TransactionProcessing>(), jobj)
                            "action_receipt_processing_started" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptProcessingStarted>(), jobj)
                            "action_receipt_gas_reward" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptGasReward>(), jobj)
                            "receipt_processing" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ReceiptProcessing>(), jobj)
                            "postponed_receipt" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.PostponedReceipt>(), jobj)
                            "updated_delayed_receipts" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.UpdatedDelayedReceipts>(), jobj)
                            "validator_accounts_update" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ValidatorAccountsUpdate>(), jobj)
                            "migration" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.Migration>(), jobj)
                            "bandwidth_scheduler_state_update" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.BandwidthSchedulerStateUpdate>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("not_writable_to_disk".lowercase() == tfLower || tfLower.contains("not_writable_to_disk".lowercase()) || "not_writable_to_disk".lowercase().contains(tfLower))) { chosenGroupKey = "not_writable_to_disk" }
                        if (chosenGroupKey == null && ("initial_state".lowercase() == tfLower || tfLower.contains("initial_state".lowercase()) || "initial_state".lowercase().contains(tfLower))) { chosenGroupKey = "initial_state" }
                        if (chosenGroupKey == null && ("transaction_processing".lowercase() == tfLower || tfLower.contains("transaction_processing".lowercase()) || "transaction_processing".lowercase().contains(tfLower))) { chosenGroupKey = "transaction_processing" }
                        if (chosenGroupKey == null && ("action_receipt_processing_started".lowercase() == tfLower || tfLower.contains("action_receipt_processing_started".lowercase()) || "action_receipt_processing_started".lowercase().contains(tfLower))) { chosenGroupKey = "action_receipt_processing_started" }
                        if (chosenGroupKey == null && ("action_receipt_gas_reward".lowercase() == tfLower || tfLower.contains("action_receipt_gas_reward".lowercase()) || "action_receipt_gas_reward".lowercase().contains(tfLower))) { chosenGroupKey = "action_receipt_gas_reward" }
                        if (chosenGroupKey == null && ("receipt_processing".lowercase() == tfLower || tfLower.contains("receipt_processing".lowercase()) || "receipt_processing".lowercase().contains(tfLower))) { chosenGroupKey = "receipt_processing" }
                        if (chosenGroupKey == null && ("postponed_receipt".lowercase() == tfLower || tfLower.contains("postponed_receipt".lowercase()) || "postponed_receipt".lowercase().contains(tfLower))) { chosenGroupKey = "postponed_receipt" }
                        if (chosenGroupKey == null && ("updated_delayed_receipts".lowercase() == tfLower || tfLower.contains("updated_delayed_receipts".lowercase()) || "updated_delayed_receipts".lowercase().contains(tfLower))) { chosenGroupKey = "updated_delayed_receipts" }
                        if (chosenGroupKey == null && ("validator_accounts_update".lowercase() == tfLower || tfLower.contains("validator_accounts_update".lowercase()) || "validator_accounts_update".lowercase().contains(tfLower))) { chosenGroupKey = "validator_accounts_update" }
                        if (chosenGroupKey == null && ("migration".lowercase() == tfLower || tfLower.contains("migration".lowercase()) || "migration".lowercase().contains(tfLower))) { chosenGroupKey = "migration" }
                        if (chosenGroupKey == null && ("bandwidth_scheduler_state_update".lowercase() == tfLower || tfLower.contains("bandwidth_scheduler_state_update".lowercase()) || "bandwidth_scheduler_state_update".lowercase().contains(tfLower))) { chosenGroupKey = "bandwidth_scheduler_state_update" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "not_writable_to_disk" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.NotWritableToDisk>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'not_writable_to_disk' and tf='$tf'")
                                }
                                "initial_state" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.InitialState>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'initial_state' and tf='$tf'")
                                }
                                "transaction_processing" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.TransactionProcessing>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'transaction_processing' and tf='$tf'")
                                }
                                "action_receipt_processing_started" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptProcessingStarted>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'action_receipt_processing_started' and tf='$tf'")
                                }
                                "action_receipt_gas_reward" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptGasReward>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'action_receipt_gas_reward' and tf='$tf'")
                                }
                                "receipt_processing" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ReceiptProcessing>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'receipt_processing' and tf='$tf'")
                                }
                                "postponed_receipt" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.PostponedReceipt>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'postponed_receipt' and tf='$tf'")
                                }
                                "updated_delayed_receipts" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.UpdatedDelayedReceipts>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'updated_delayed_receipts' and tf='$tf'")
                                }
                                "validator_accounts_update" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ValidatorAccountsUpdate>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'validator_accounts_update' and tf='$tf'")
                                }
                                "migration" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.Migration>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'migration' and tf='$tf'")
                                }
                                "bandwidth_scheduler_state_update" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.BandwidthSchedulerStateUpdate>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'bandwidth_scheduler_state_update' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: not_writable_to_disk
                    // group: initial_state
                    // group: transaction_processing
                    // group: action_receipt_processing_started
                    // group: action_receipt_gas_reward
                    // group: receipt_processing
                    // group: postponed_receipt
                    // group: updated_delayed_receipts
                    // group: validator_accounts_update
                    // group: migration
                    // group: bandwidth_scheduler_state_update

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("type")) requiredMatches.add(0)
                    if (jobj.containsKey("type")) requiredMatches.add(1)
                    if (jobj.containsKey("tx_hash") && jobj.containsKey("type")) requiredMatches.add(2)
                    if (jobj.containsKey("receipt_hash") && jobj.containsKey("type")) requiredMatches.add(3)
                    if (jobj.containsKey("receipt_hash") && jobj.containsKey("type")) requiredMatches.add(4)
                    if (jobj.containsKey("receipt_hash") && jobj.containsKey("type")) requiredMatches.add(5)
                    if (jobj.containsKey("receipt_hash") && jobj.containsKey("type")) requiredMatches.add(6)
                    if (jobj.containsKey("type")) requiredMatches.add(7)
                    if (jobj.containsKey("type")) requiredMatches.add(8)
                    if (jobj.containsKey("type")) requiredMatches.add(9)
                    if (jobj.containsKey("type")) requiredMatches.add(10)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.NotWritableToDisk>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.InitialState>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.TransactionProcessing>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptProcessingStarted>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptGasReward>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ReceiptProcessing>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.PostponedReceipt>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.UpdatedDelayedReceipts>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ValidatorAccountsUpdate>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.Migration>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.BandwidthSchedulerStateUpdate>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["type"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["type"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["tx_hash"] != null) matchCount++
                        if (jobj["type"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["receipt_hash"] != null) matchCount++
                        if (jobj["type"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 3 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["receipt_hash"] != null) matchCount++
                        if (jobj["type"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 4 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["receipt_hash"] != null) matchCount++
                        if (jobj["type"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 5 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["receipt_hash"] != null) matchCount++
                        if (jobj["type"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 6 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["type"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 7 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["type"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 8 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["type"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 9 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["type"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 10 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.NotWritableToDisk>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.InitialState>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.TransactionProcessing>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptProcessingStarted>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptGasReward>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ReceiptProcessing>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.PostponedReceipt>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.UpdatedDelayedReceipts>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ValidatorAccountsUpdate>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.Migration>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.BandwidthSchedulerStateUpdate>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.NotWritableToDisk>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.InitialState>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.TransactionProcessing>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptProcessingStarted>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptGasReward>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ReceiptProcessing>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.PostponedReceipt>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.UpdatedDelayedReceipts>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ValidatorAccountsUpdate>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.Migration>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.BandwidthSchedulerStateUpdate>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in StateChangeCauseView")
                }
            }
        }
        throw SerializationException("Cannot deserialize StateChangeCauseView with non-JSON decoder")
    }
}
