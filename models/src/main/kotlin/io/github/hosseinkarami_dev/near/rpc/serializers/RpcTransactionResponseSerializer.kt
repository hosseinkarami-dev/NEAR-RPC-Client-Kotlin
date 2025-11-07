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
import io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse
import kotlinx.serialization.json.*

object RpcTransactionResponseSerializer : KSerializer<RpcTransactionResponse> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse") {
        element("FinalExecutionOutcomeWithReceiptView", serializer<JsonElement>().descriptor)
        element("FinalExecutionOutcomeView", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: RpcTransactionResponse) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeWithReceiptView -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["receipts"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptView>()), value.receipts)
                    map["receipts_outcome"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionOutcomeWithIdView>()), value.receiptsOutcome)
                    map["status"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus>(), value.status)
                    map["transaction"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SignedTransactionView>(), value.transaction)
                    map["transaction_outcome"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionOutcomeWithIdView>(), value.transactionOutcome)
                    map["final_execution_status"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus>(), value.finalExecutionStatus)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeView -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["receipts_outcome"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionOutcomeWithIdView>()), value.receiptsOutcome)
                    map["status"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus>(), value.status)
                    map["transaction"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SignedTransactionView>(), value.transaction)
                    map["transaction_outcome"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionOutcomeWithIdView>(), value.transactionOutcome)
                    map["final_execution_status"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus>(), value.finalExecutionStatus)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeWithReceiptView -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeWithReceiptView>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeView -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeView>(), value)
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

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing RpcTransactionResponse")

                is JsonObject -> {
                    val jobj = element
                    val knownVariantNames = setOf("FinalExecutionOutcomeWithReceiptView", "FinalExecutionOutcomeView")
                    if (jobj["receipts"] != null) {
                        val receiptsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptView>()), jobj["receipts"] ?: throw SerializationException("Missing field 'receipts' for variant FinalExecutionOutcomeWithReceiptView"))
                        val receiptsOutcomeVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionOutcomeWithIdView>()), jobj["receipts_outcome"] ?: throw SerializationException("Missing field 'receipts_outcome' for variant FinalExecutionOutcomeWithReceiptView"))
                        val statusVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus>(), jobj["status"] ?: throw SerializationException("Missing field 'status' for variant FinalExecutionOutcomeWithReceiptView"))
                        val transactionVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SignedTransactionView>(), jobj["transaction"] ?: throw SerializationException("Missing field 'transaction' for variant FinalExecutionOutcomeWithReceiptView"))
                        val transactionOutcomeVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionOutcomeWithIdView>(), jobj["transaction_outcome"] ?: throw SerializationException("Missing field 'transaction_outcome' for variant FinalExecutionOutcomeWithReceiptView"))
                        val finalExecutionStatusVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus>(), jobj["final_execution_status"] ?: throw SerializationException("Missing field 'final_execution_status' for variant FinalExecutionOutcomeWithReceiptView"))
                        return io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeWithReceiptView(receiptsVal, receiptsOutcomeVal, statusVal, transactionVal, transactionOutcomeVal, finalExecutionStatusVal)
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        if (knownVariantNames.contains(key)) {
                            when (key) {
                            "FinalExecutionOutcomeWithReceiptView" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant FinalExecutionOutcomeWithReceiptView: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeWithReceiptView>(), obj)
                            }
                            "FinalExecutionOutcomeView" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant FinalExecutionOutcomeView: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeView>(), obj)
                            }
                            else -> { /* knownVariantNames.contains(key) guards this branch; shouldn't reach here */ }
                            }
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = emptyList<String>()
                    if (typeField == null) {
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
                            "FinalExecutionOutcomeWithReceiptView" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeWithReceiptView>(), jobj)
                            "FinalExecutionOutcomeView" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeView>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("FinalExecutionOutcomeWithReceiptView".lowercase() == tfLower || tfLower.contains("FinalExecutionOutcomeWithReceiptView".lowercase()) || "FinalExecutionOutcomeWithReceiptView".lowercase().contains(tfLower))) { chosenGroupKey = "FinalExecutionOutcomeWithReceiptView" }
                        if (chosenGroupKey == null && ("FinalExecutionOutcomeView".lowercase() == tfLower || tfLower.contains("FinalExecutionOutcomeView".lowercase()) || "FinalExecutionOutcomeView".lowercase().contains(tfLower))) { chosenGroupKey = "FinalExecutionOutcomeView" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "FinalExecutionOutcomeWithReceiptView" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeWithReceiptView>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'FinalExecutionOutcomeWithReceiptView' and tf='\$tf'")
                                }
                                "FinalExecutionOutcomeView" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeView>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'FinalExecutionOutcomeView' and tf='\$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: FinalExecutionOutcomeWithReceiptView
                    // group: FinalExecutionOutcomeView

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("receipts") && jobj.containsKey("receipts_outcome") && jobj.containsKey("status") && jobj.containsKey("transaction") && jobj.containsKey("transaction_outcome") && jobj.containsKey("final_execution_status")) requiredMatches.add(0)
                    if (jobj.containsKey("receipts_outcome") && jobj.containsKey("status") && jobj.containsKey("transaction") && jobj.containsKey("transaction_outcome") && jobj.containsKey("final_execution_status")) requiredMatches.add(1)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeWithReceiptView>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeView>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["receipts"] != null) matchCount++
                        if (jobj["receipts_outcome"] != null) matchCount++
                        if (jobj["status"] != null) matchCount++
                        if (jobj["transaction"] != null) matchCount++
                        if (jobj["transaction_outcome"] != null) matchCount++
                        if (jobj["final_execution_status"] != null) matchCount++
                        val score = matchCount.toDouble() / 6.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["receipts_outcome"] != null) matchCount++
                        if (jobj["status"] != null) matchCount++
                        if (jobj["transaction"] != null) matchCount++
                        if (jobj["transaction_outcome"] != null) matchCount++
                        if (jobj["final_execution_status"] != null) matchCount++
                        val score = matchCount.toDouble() / 5.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeWithReceiptView>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeView>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeWithReceiptView>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeView>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in RpcTransactionResponse")
                }
            }
        }
        throw SerializationException("Cannot deserialize RpcTransactionResponse with non-JSON decoder")
    }
}
