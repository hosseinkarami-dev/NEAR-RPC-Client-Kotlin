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
import io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse
import kotlinx.serialization.json.*

object RpcQueryResponseSerializer : KSerializer<RpcQueryResponse> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse") {
        element("AccountView", serializer<JsonElement>().descriptor)
        element("ContractCodeView", serializer<JsonElement>().descriptor)
        element("ViewStateResult", serializer<JsonElement>().descriptor)
        element("CallResult", serializer<JsonElement>().descriptor)
        element("AccessKeyView", serializer<JsonElement>().descriptor)
        element("AccessKeyList", serializer<JsonElement>().descriptor)
    }

    // --- helper functions ---
    private fun <T> tryDecode(json: Json, serExpr: KSerializer<T>, elem: JsonElement): T = json.decodeFromJsonElement(serExpr, elem)

    override fun serialize(encoder: Encoder, value: RpcQueryResponse) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccountView -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["amount"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NearToken>(), value.amount)
                    map["code_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.codeHash)
                    if (value.globalContractAccountId != null) {
                        map["global_contract_account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId?>(), value.globalContractAccountId)
                    }
                    if (value.globalContractHash != null) {
                        map["global_contract_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash?>(), value.globalContractHash)
                    }
                    map["locked"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NearToken>(), value.locked)
                    if (value.storagePaidAt != null) {
                        map["storage_paid_at"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.ULong?>(), value.storagePaidAt)
                    }
                    map["storage_usage"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.ULong>(), value.storageUsage)
                    map["block_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.blockHash)
                    map["block_height"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.ULong>(), value.blockHeight)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ContractCodeView -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["code_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.String>(), value.codeBase64)
                    map["hash"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.hash)
                    map["block_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.blockHash)
                    map["block_height"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.ULong>(), value.blockHeight)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ViewStateResult -> {
                    val map = mutableMapOf<String, JsonElement>()
                    if (value.proof != null) {
                        map["proof"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.collections.List<kotlin.String>?>(), value.proof)
                    }
                    map["values"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateItem>()), value.values)
                    map["block_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.blockHash)
                    map["block_height"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.ULong>(), value.blockHeight)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.CallResult -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["logs"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<kotlin.String>()), value.logs)
                    map["result"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<kotlin.UByte>()), value.result)
                    map["block_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.blockHash)
                    map["block_height"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.ULong>(), value.blockHeight)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyView -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["nonce"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.ULong>(), value.nonce)
                    map["permission"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView>(), value.permission)
                    map["block_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.blockHash)
                    map["block_height"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.ULong>(), value.blockHeight)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyList -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["keys"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyInfoView>()), value.keys)
                    map["block_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.blockHash)
                    map["block_height"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.ULong>(), value.blockHeight)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccountView -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccountView>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ContractCodeView -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ContractCodeView>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ViewStateResult -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ViewStateResult>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.CallResult -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.CallResult>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyView -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyView>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyList -> out.encodeSerializableElement(descriptor, 5, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyList>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): RpcQueryResponse {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    throw SerializationException("Unknown discriminator (primitive) for RpcQueryResponse")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing RpcQueryResponse")

                is JsonObject -> {
                    val jobj = element
                    if (jobj["amount"] != null) {
                        val amountVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NearToken>(), jobj["amount"] ?: throw SerializationException("Missing field 'amount' for variant AccountView"))
                        val codeHashVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), jobj["code_hash"] ?: throw SerializationException("Missing field 'code_hash' for variant AccountView"))
                        val globalContractAccountIdVal = jobj["global_contract_account_id"]?.let { decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId?>(), it) }
                        val globalContractHashVal = jobj["global_contract_hash"]?.let { decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash?>(), it) }
                        val lockedVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NearToken>(), jobj["locked"] ?: throw SerializationException("Missing field 'locked' for variant AccountView"))
                        val storagePaidAtVal = jobj["storage_paid_at"]?.let { decoder.json.decodeFromJsonElement(serializer<kotlin.ULong?>(), it) }
                        val storageUsageVal = decoder.json.decodeFromJsonElement(serializer<kotlin.ULong>(), jobj["storage_usage"] ?: throw SerializationException("Missing field 'storage_usage' for variant AccountView"))
                        val blockHashVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), jobj["block_hash"] ?: throw SerializationException("Missing field 'block_hash' for variant AccountView"))
                        val blockHeightVal = decoder.json.decodeFromJsonElement(serializer<kotlin.ULong>(), jobj["block_height"] ?: throw SerializationException("Missing field 'block_height' for variant AccountView"))
                        return io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccountView(amountVal, codeHashVal, globalContractAccountIdVal, globalContractHashVal, lockedVal, storagePaidAtVal, storageUsageVal, blockHashVal, blockHeightVal)
                    }
                    if (jobj["code_base64"] != null) {
                        val codeBase64Val = decoder.json.decodeFromJsonElement(serializer<kotlin.String>(), jobj["code_base64"] ?: throw SerializationException("Missing field 'code_base64' for variant ContractCodeView"))
                        val hashVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), jobj["hash"] ?: throw SerializationException("Missing field 'hash' for variant ContractCodeView"))
                        val blockHashVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), jobj["block_hash"] ?: throw SerializationException("Missing field 'block_hash' for variant ContractCodeView"))
                        val blockHeightVal = decoder.json.decodeFromJsonElement(serializer<kotlin.ULong>(), jobj["block_height"] ?: throw SerializationException("Missing field 'block_height' for variant ContractCodeView"))
                        return io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ContractCodeView(codeBase64Val, hashVal, blockHashVal, blockHeightVal)
                    }
                    if (jobj["proof"] != null) {
                        val proofVal = jobj["proof"]?.let { decoder.json.decodeFromJsonElement(serializer<kotlin.collections.List<kotlin.String>?>(), it) }
                        val valuesVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateItem>()), jobj["values"] ?: throw SerializationException("Missing field 'values' for variant ViewStateResult"))
                        val blockHashVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), jobj["block_hash"] ?: throw SerializationException("Missing field 'block_hash' for variant ViewStateResult"))
                        val blockHeightVal = decoder.json.decodeFromJsonElement(serializer<kotlin.ULong>(), jobj["block_height"] ?: throw SerializationException("Missing field 'block_height' for variant ViewStateResult"))
                        return io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ViewStateResult(proofVal, valuesVal, blockHashVal, blockHeightVal)
                    }
                    if (jobj["logs"] != null) {
                        val logsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<kotlin.String>()), jobj["logs"] ?: throw SerializationException("Missing field 'logs' for variant CallResult"))
                        val resultVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<kotlin.UByte>()), jobj["result"] ?: throw SerializationException("Missing field 'result' for variant CallResult"))
                        val blockHashVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), jobj["block_hash"] ?: throw SerializationException("Missing field 'block_hash' for variant CallResult"))
                        val blockHeightVal = decoder.json.decodeFromJsonElement(serializer<kotlin.ULong>(), jobj["block_height"] ?: throw SerializationException("Missing field 'block_height' for variant CallResult"))
                        return io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.CallResult(logsVal, resultVal, blockHashVal, blockHeightVal)
                    }
                    if (jobj["nonce"] != null) {
                        val nonceVal = decoder.json.decodeFromJsonElement(serializer<kotlin.ULong>(), jobj["nonce"] ?: throw SerializationException("Missing field 'nonce' for variant AccessKeyView"))
                        val permissionVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView>(), jobj["permission"] ?: throw SerializationException("Missing field 'permission' for variant AccessKeyView"))
                        val blockHashVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), jobj["block_hash"] ?: throw SerializationException("Missing field 'block_hash' for variant AccessKeyView"))
                        val blockHeightVal = decoder.json.decodeFromJsonElement(serializer<kotlin.ULong>(), jobj["block_height"] ?: throw SerializationException("Missing field 'block_height' for variant AccessKeyView"))
                        return io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyView(nonceVal, permissionVal, blockHashVal, blockHeightVal)
                    }
                    if (jobj["keys"] != null) {
                        val keysVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyInfoView>()), jobj["keys"] ?: throw SerializationException("Missing field 'keys' for variant AccessKeyList"))
                        val blockHashVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), jobj["block_hash"] ?: throw SerializationException("Missing field 'block_hash' for variant AccessKeyList"))
                        val blockHeightVal = decoder.json.decodeFromJsonElement(serializer<kotlin.ULong>(), jobj["block_height"] ?: throw SerializationException("Missing field 'block_height' for variant AccessKeyList"))
                        return io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyList(keysVal, blockHashVal, blockHeightVal)
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "AccountView" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant AccountView: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccountView>(), obj)
                            }
                            "ContractCodeView" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant ContractCodeView: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ContractCodeView>(), obj)
                            }
                            "ViewStateResult" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant ViewStateResult: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ViewStateResult>(), obj)
                            }
                            "CallResult" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant CallResult: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.CallResult>(), obj)
                            }
                            "AccessKeyView" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant AccessKeyView: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyView>(), obj)
                            }
                            "AccessKeyList" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant AccessKeyList: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyList>(), obj)
                            }
                            else -> throw SerializationException("Unknown discriminator key for RpcQueryResponse: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("code_base64")
                    for (cand in discriminatorCandidates) {
                        val candElem = jobj[cand]
                        if (candElem is JsonPrimitive) {
                            typeField = candElem.contentOrNull
                            if (typeField != null) break
                        }
                    }
                    if (typeField == null) {
                        val knownVariantNames = setOf("AccountView", "ContractCodeView", "ViewStateResult", "CallResult", "AccessKeyView", "AccessKeyList")
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
                            "AccountView" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccountView>(), jobj)
                            "ContractCodeView" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ContractCodeView>(), jobj)
                            "ViewStateResult" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ViewStateResult>(), jobj)
                            "CallResult" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.CallResult>(), jobj)
                            "AccessKeyView" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyView>(), jobj)
                            "AccessKeyList" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyList>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("AccountView".lowercase() == tfLower || tfLower.contains("AccountView".lowercase()) || "AccountView".lowercase().contains(tfLower))) { chosenGroupKey = "AccountView" }
                        if (chosenGroupKey == null && ("ContractCodeView".lowercase() == tfLower || tfLower.contains("ContractCodeView".lowercase()) || "ContractCodeView".lowercase().contains(tfLower))) { chosenGroupKey = "ContractCodeView" }
                        if (chosenGroupKey == null && ("ViewStateResult".lowercase() == tfLower || tfLower.contains("ViewStateResult".lowercase()) || "ViewStateResult".lowercase().contains(tfLower))) { chosenGroupKey = "ViewStateResult" }
                        if (chosenGroupKey == null && ("CallResult".lowercase() == tfLower || tfLower.contains("CallResult".lowercase()) || "CallResult".lowercase().contains(tfLower))) { chosenGroupKey = "CallResult" }
                        if (chosenGroupKey == null && ("AccessKeyView".lowercase() == tfLower || tfLower.contains("AccessKeyView".lowercase()) || "AccessKeyView".lowercase().contains(tfLower))) { chosenGroupKey = "AccessKeyView" }
                        if (chosenGroupKey == null && ("AccessKeyList".lowercase() == tfLower || tfLower.contains("AccessKeyList".lowercase()) || "AccessKeyList".lowercase().contains(tfLower))) { chosenGroupKey = "AccessKeyList" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "AccountView" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccountView>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'AccountView' and tf='$tf'")
                                }
                                "ContractCodeView" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ContractCodeView>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'ContractCodeView' and tf='$tf'")
                                }
                                "ViewStateResult" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ViewStateResult>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'ViewStateResult' and tf='$tf'")
                                }
                                "CallResult" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.CallResult>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'CallResult' and tf='$tf'")
                                }
                                "AccessKeyView" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyView>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'AccessKeyView' and tf='$tf'")
                                }
                                "AccessKeyList" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyList>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'AccessKeyList' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: AccountView
                    // group: ContractCodeView
                    // group: ViewStateResult
                    // group: CallResult
                    // group: AccessKeyView
                    // group: AccessKeyList

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("amount") && jobj.containsKey("code_hash") && jobj.containsKey("locked") && jobj.containsKey("storage_usage") && jobj.containsKey("block_hash") && jobj.containsKey("block_height")) requiredMatches.add(0)
                    if (jobj.containsKey("code_base64") && jobj.containsKey("hash") && jobj.containsKey("block_hash") && jobj.containsKey("block_height")) requiredMatches.add(1)
                    if (jobj.containsKey("values") && jobj.containsKey("block_hash") && jobj.containsKey("block_height")) requiredMatches.add(2)
                    if (jobj.containsKey("logs") && jobj.containsKey("result") && jobj.containsKey("block_hash") && jobj.containsKey("block_height")) requiredMatches.add(3)
                    if (jobj.containsKey("nonce") && jobj.containsKey("permission") && jobj.containsKey("block_hash") && jobj.containsKey("block_height")) requiredMatches.add(4)
                    if (jobj.containsKey("keys") && jobj.containsKey("block_hash") && jobj.containsKey("block_height")) requiredMatches.add(5)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccountView>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ContractCodeView>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ViewStateResult>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.CallResult>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyView>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyList>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["amount"] != null) matchCount++
                        if (jobj["code_hash"] != null) matchCount++
                        if (jobj["global_contract_account_id"] != null) matchCount++
                        if (jobj["global_contract_hash"] != null) matchCount++
                        if (jobj["locked"] != null) matchCount++
                        if (jobj["storage_paid_at"] != null) matchCount++
                        if (jobj["storage_usage"] != null) matchCount++
                        if (jobj["block_hash"] != null) matchCount++
                        if (jobj["block_height"] != null) matchCount++
                        val score = matchCount.toDouble() / 9.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["code_base64"] != null) matchCount++
                        if (jobj["hash"] != null) matchCount++
                        if (jobj["block_hash"] != null) matchCount++
                        if (jobj["block_height"] != null) matchCount++
                        val score = matchCount.toDouble() / 4.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["proof"] != null) matchCount++
                        if (jobj["values"] != null) matchCount++
                        if (jobj["block_hash"] != null) matchCount++
                        if (jobj["block_height"] != null) matchCount++
                        val score = matchCount.toDouble() / 4.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["logs"] != null) matchCount++
                        if (jobj["result"] != null) matchCount++
                        if (jobj["block_hash"] != null) matchCount++
                        if (jobj["block_height"] != null) matchCount++
                        val score = matchCount.toDouble() / 4.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 3 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["nonce"] != null) matchCount++
                        if (jobj["permission"] != null) matchCount++
                        if (jobj["block_hash"] != null) matchCount++
                        if (jobj["block_height"] != null) matchCount++
                        val score = matchCount.toDouble() / 4.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 4 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["keys"] != null) matchCount++
                        if (jobj["block_hash"] != null) matchCount++
                        if (jobj["block_height"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 5 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccountView>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ContractCodeView>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ViewStateResult>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.CallResult>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyView>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyList>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccountView>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ContractCodeView>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ViewStateResult>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.CallResult>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyView>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyList>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in RpcQueryResponse")
                }
            }
        }
        throw SerializationException("Cannot deserialize RpcQueryResponse with non-JSON decoder")
    }
}
