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
import io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest
import kotlinx.serialization.json.*

object RpcTransactionStatusRequestSerializer : KSerializer<RpcTransactionStatusRequest> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest") {
        element("signed_tx_base64", serializer<JsonElement>().descriptor)
        element("sender_account_id", serializer<JsonElement>().descriptor)
    }

    // --- helper functions ---
    private fun <T> tryDecode(json: Json, serExpr: KSerializer<T>, elem: JsonElement): T = json.decodeFromJsonElement(serExpr, elem)

    override fun serialize(encoder: Encoder, value: RpcTransactionStatusRequest) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SignedTxBase64 -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["signed_tx_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SignedTransaction>(), value.signedTxBase64)
                    if (value.waitUntil != null) {
                        map["wait_until"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus?>(), value.waitUntil)
                    }
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SenderAccountId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["sender_account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.senderAccountId)
                    map["tx_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.txHash)
                    if (value.waitUntil != null) {
                        map["wait_until"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus?>(), value.waitUntil)
                    }
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SignedTxBase64 -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SignedTxBase64>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SenderAccountId -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SenderAccountId>(), value)
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
                    }
                    throw SerializationException("Unknown discriminator (primitive) for RpcTransactionStatusRequest")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing RpcTransactionStatusRequest")

                is JsonObject -> {
                    val jobj = element
                    if (jobj["signed_tx_base64"] != null) {
                        val signedTxBase64Val = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SignedTransaction>(), jobj["signed_tx_base64"] ?: throw SerializationException("Missing field 'signed_tx_base64' for variant SignedTxBase64"))
                        val waitUntilVal = jobj["wait_until"]?.let { decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus?>(), it) }
                        return io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SignedTxBase64(signedTxBase64Val, waitUntilVal)
                    }
                    if (jobj["sender_account_id"] != null) {
                        val senderAccountIdVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), jobj["sender_account_id"] ?: throw SerializationException("Missing field 'sender_account_id' for variant SenderAccountId"))
                        val txHashVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), jobj["tx_hash"] ?: throw SerializationException("Missing field 'tx_hash' for variant SenderAccountId"))
                        val waitUntilVal = jobj["wait_until"]?.let { decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus?>(), it) }
                        return io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SenderAccountId(senderAccountIdVal, txHashVal, waitUntilVal)
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "signed_tx_base64" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant signed_tx_base64: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SignedTxBase64>(), obj)
                            }
                            "sender_account_id" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant sender_account_id: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SenderAccountId>(), obj)
                            }
                            else -> throw SerializationException("Unknown discriminator key for RpcTransactionStatusRequest: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = emptyList<String>()
                    if (typeField == null) {
                        val knownVariantNames = setOf("signed_tx_base64", "sender_account_id")
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
                            "signed_tx_base64" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SignedTxBase64>(), jobj)
                            "sender_account_id" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SenderAccountId>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("signed_tx_base64".lowercase() == tfLower || tfLower.contains("signed_tx_base64".lowercase()) || "signed_tx_base64".lowercase().contains(tfLower))) { chosenGroupKey = "signed_tx_base64" }
                        if (chosenGroupKey == null && ("sender_account_id".lowercase() == tfLower || tfLower.contains("sender_account_id".lowercase()) || "sender_account_id".lowercase().contains(tfLower))) { chosenGroupKey = "sender_account_id" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "signed_tx_base64" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SignedTxBase64>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'signed_tx_base64' and tf='$tf'")
                                }
                                "sender_account_id" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SenderAccountId>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'sender_account_id' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: signed_tx_base64
                    // group: sender_account_id

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("signed_tx_base64")) requiredMatches.add(0)
                    if (jobj.containsKey("sender_account_id") && jobj.containsKey("tx_hash")) requiredMatches.add(1)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SignedTxBase64>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SenderAccountId>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["signed_tx_base64"] != null) matchCount++
                        if (jobj["wait_until"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["sender_account_id"] != null) matchCount++
                        if (jobj["tx_hash"] != null) matchCount++
                        if (jobj["wait_until"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SignedTxBase64>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SenderAccountId>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SignedTxBase64>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SenderAccountId>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in RpcTransactionStatusRequest")
                }
            }
        }
        throw SerializationException("Cannot deserialize RpcTransactionStatusRequest with non-JSON decoder")
    }
}
