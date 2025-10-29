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
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest
import kotlinx.serialization.json.*

object RpcLightClientExecutionProofRequestSerializer : KSerializer<RpcLightClientExecutionProofRequest> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest") {
        element("transaction", serializer<JsonElement>().descriptor)
        element("receipt", serializer<JsonElement>().descriptor)
    }

    // --- helper functions ---
    private fun <T> tryDecode(json: Json, serExpr: KSerializer<T>, elem: JsonElement): T = json.decodeFromJsonElement(serExpr, elem)

    override fun serialize(encoder: Encoder, value: RpcLightClientExecutionProofRequest) {
        if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Transaction -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["sender_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.senderId)
                    map["transaction_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.transactionHash)
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Transaction.Type>(), value.type)
                    map["light_client_head"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.lightClientHead)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Receipt -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["receipt_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.receiptId)
                    map["receiver_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.receiverId)
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Receipt.Type>(), value.type)
                    map["light_client_head"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.lightClientHead)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Transaction -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Transaction>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Receipt -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Receipt>(), value)
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
                    }
                    throw SerializationException("Unknown discriminator (primitive) for RpcLightClientExecutionProofRequest")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing RpcLightClientExecutionProofRequest")

                is JsonObject -> {
                    val jobj = element
                    if (jobj["sender_id"] != null) {
                        val senderIdVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), jobj["sender_id"] ?: throw SerializationException("Missing field 'sender_id' for variant Transaction"))
                        val transactionHashVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), jobj["transaction_hash"] ?: throw SerializationException("Missing field 'transaction_hash' for variant Transaction"))
                        val typeVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Transaction.Type>(), jobj["type"] ?: throw SerializationException("Missing field 'type' for variant Transaction"))
                        val lightClientHeadVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), jobj["light_client_head"] ?: throw SerializationException("Missing field 'light_client_head' for variant Transaction"))
                        return io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Transaction(senderIdVal, transactionHashVal, typeVal, lightClientHeadVal)
                    }
                    if (jobj["receipt_id"] != null) {
                        val receiptIdVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), jobj["receipt_id"] ?: throw SerializationException("Missing field 'receipt_id' for variant Receipt"))
                        val receiverIdVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), jobj["receiver_id"] ?: throw SerializationException("Missing field 'receiver_id' for variant Receipt"))
                        val typeVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Receipt.Type>(), jobj["type"] ?: throw SerializationException("Missing field 'type' for variant Receipt"))
                        val lightClientHeadVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), jobj["light_client_head"] ?: throw SerializationException("Missing field 'light_client_head' for variant Receipt"))
                        return io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Receipt(receiptIdVal, receiverIdVal, typeVal, lightClientHeadVal)
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "transaction" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant transaction: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Transaction>(), obj)
                            }
                            "receipt" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant receipt: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Receipt>(), obj)
                            }
                            else -> throw SerializationException("Unknown discriminator key for RpcLightClientExecutionProofRequest: " + key)
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
                        val knownVariantNames = setOf("transaction", "receipt")
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
                            "transaction" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Transaction>(), jobj)
                            "receipt" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Receipt>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("transaction".lowercase() == tfLower || tfLower.contains("transaction".lowercase()) || "transaction".lowercase().contains(tfLower))) { chosenGroupKey = "transaction" }
                        if (chosenGroupKey == null && ("receipt".lowercase() == tfLower || tfLower.contains("receipt".lowercase()) || "receipt".lowercase().contains(tfLower))) { chosenGroupKey = "receipt" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "transaction" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Transaction>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'transaction' and tf='$tf'")
                                }
                                "receipt" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Receipt>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'receipt' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: transaction
                    // group: receipt

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("sender_id") && jobj.containsKey("transaction_hash") && jobj.containsKey("type") && jobj.containsKey("light_client_head")) requiredMatches.add(0)
                    if (jobj.containsKey("receipt_id") && jobj.containsKey("receiver_id") && jobj.containsKey("type") && jobj.containsKey("light_client_head")) requiredMatches.add(1)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Transaction>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Receipt>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["sender_id"] != null) matchCount++
                        if (jobj["transaction_hash"] != null) matchCount++
                        if (jobj["type"] != null) matchCount++
                        if (jobj["light_client_head"] != null) matchCount++
                        val score = matchCount.toDouble() / 4.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["receipt_id"] != null) matchCount++
                        if (jobj["receiver_id"] != null) matchCount++
                        if (jobj["type"] != null) matchCount++
                        if (jobj["light_client_head"] != null) matchCount++
                        val score = matchCount.toDouble() / 4.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Transaction>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Receipt>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Transaction>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Receipt>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in RpcLightClientExecutionProofRequest")
                }
            }
        }
        throw SerializationException("Cannot deserialize RpcLightClientExecutionProofRequest with non-JSON decoder")
    }
}
