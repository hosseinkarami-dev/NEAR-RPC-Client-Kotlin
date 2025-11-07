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
import io.github.hosseinkarami_dev.near.rpc.models.ActionView
import kotlinx.serialization.json.*

object ActionViewSerializer : KSerializer<ActionView> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ActionView") {
        element("CreateAccount", serializer<JsonElement>().descriptor)
        element("DeployContract", serializer<JsonElement>().descriptor)
        element("FunctionCall", serializer<JsonElement>().descriptor)
        element("Transfer", serializer<JsonElement>().descriptor)
        element("Stake", serializer<JsonElement>().descriptor)
        element("AddKey", serializer<JsonElement>().descriptor)
        element("DeleteKey", serializer<JsonElement>().descriptor)
        element("DeleteAccount", serializer<JsonElement>().descriptor)
        element("Delegate", serializer<JsonElement>().descriptor)
        element("DeployGlobalContract", serializer<JsonElement>().descriptor)
        element("DeployGlobalContractByAccountId", serializer<JsonElement>().descriptor)
        element("UseGlobalContract", serializer<JsonElement>().descriptor)
        element("UseGlobalContractByAccountId", serializer<JsonElement>().descriptor)
        element("DeterministicStateInit", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: ActionView) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.ActionView.CreateAccount -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("CreateAccount"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployContract -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["DeployContract"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployContract.DeployContractPayload>(), value.deployContract)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionView.FunctionCall -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["FunctionCall"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.FunctionCall.FunctionCallPayload>(), value.functionCall)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionView.Transfer -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["Transfer"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Transfer.TransferPayload>(), value.transfer)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionView.Stake -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["Stake"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Stake.StakePayload>(), value.stake)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionView.AddKey -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["AddKey"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.AddKey.AddKeyPayload>(), value.addKey)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteKey -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["DeleteKey"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteKey.DeleteKeyPayload>(), value.deleteKey)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteAccount -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["DeleteAccount"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteAccount.DeleteAccountPayload>(), value.deleteAccount)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionView.Delegate -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["Delegate"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Delegate.DelegatePayload>(), value.delegate)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContract -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["DeployGlobalContract"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContract.DeployGlobalContractPayload>(), value.deployGlobalContract)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContractByAccountId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["DeployGlobalContractByAccountId"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContractByAccountId.DeployGlobalContractByAccountIdPayload>(), value.deployGlobalContractByAccountId)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContract -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["UseGlobalContract"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContract.UseGlobalContractPayload>(), value.useGlobalContract)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContractByAccountId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["UseGlobalContractByAccountId"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContractByAccountId.UseGlobalContractByAccountIdPayload>(), value.useGlobalContractByAccountId)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeterministicStateInit -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["DeterministicStateInit"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeterministicStateInit.DeterministicStateInitPayload>(), value.deterministicStateInit)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.ActionView.CreateAccount -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.CreateAccount>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployContract -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployContract>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionView.FunctionCall -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.FunctionCall>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionView.Transfer -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Transfer>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionView.Stake -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Stake>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionView.AddKey -> out.encodeSerializableElement(descriptor, 5, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.AddKey>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteKey -> out.encodeSerializableElement(descriptor, 6, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteKey>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteAccount -> out.encodeSerializableElement(descriptor, 7, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteAccount>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionView.Delegate -> out.encodeSerializableElement(descriptor, 8, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Delegate>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContract -> out.encodeSerializableElement(descriptor, 9, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContract>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContractByAccountId -> out.encodeSerializableElement(descriptor, 10, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContractByAccountId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContract -> out.encodeSerializableElement(descriptor, 11, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContract>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContractByAccountId -> out.encodeSerializableElement(descriptor, 12, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContractByAccountId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeterministicStateInit -> out.encodeSerializableElement(descriptor, 13, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeterministicStateInit>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): ActionView {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                        if (s == "CreateAccount") return io.github.hosseinkarami_dev.near.rpc.models.ActionView.CreateAccount
                    }
                    throw SerializationException("Unknown discriminator (primitive) for ActionView")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing ActionView")

                is JsonObject -> {
                    val jobj = element
                    val knownVariantNames = setOf("CreateAccount", "DeployContract", "FunctionCall", "Transfer", "Stake", "AddKey", "DeleteKey", "DeleteAccount", "Delegate", "DeployGlobalContract", "DeployGlobalContractByAccountId", "UseGlobalContract", "UseGlobalContractByAccountId", "DeterministicStateInit")
                    if (jobj["DeployContract"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployContract(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployContract.DeployContractPayload>(), jobj["DeployContract"]!!))
                    }
                    if (jobj["FunctionCall"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionView.FunctionCall(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.FunctionCall.FunctionCallPayload>(), jobj["FunctionCall"]!!))
                    }
                    if (jobj["Transfer"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionView.Transfer(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Transfer.TransferPayload>(), jobj["Transfer"]!!))
                    }
                    if (jobj["Stake"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionView.Stake(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Stake.StakePayload>(), jobj["Stake"]!!))
                    }
                    if (jobj["AddKey"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionView.AddKey(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.AddKey.AddKeyPayload>(), jobj["AddKey"]!!))
                    }
                    if (jobj["DeleteKey"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteKey(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteKey.DeleteKeyPayload>(), jobj["DeleteKey"]!!))
                    }
                    if (jobj["DeleteAccount"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteAccount(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteAccount.DeleteAccountPayload>(), jobj["DeleteAccount"]!!))
                    }
                    if (jobj["Delegate"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionView.Delegate(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Delegate.DelegatePayload>(), jobj["Delegate"]!!))
                    }
                    if (jobj["DeployGlobalContract"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContract(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContract.DeployGlobalContractPayload>(), jobj["DeployGlobalContract"]!!))
                    }
                    if (jobj["DeployGlobalContractByAccountId"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContractByAccountId(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContractByAccountId.DeployGlobalContractByAccountIdPayload>(), jobj["DeployGlobalContractByAccountId"]!!))
                    }
                    if (jobj["UseGlobalContract"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContract(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContract.UseGlobalContractPayload>(), jobj["UseGlobalContract"]!!))
                    }
                    if (jobj["UseGlobalContractByAccountId"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContractByAccountId(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContractByAccountId.UseGlobalContractByAccountIdPayload>(), jobj["UseGlobalContractByAccountId"]!!))
                    }
                    if (jobj["DeterministicStateInit"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeterministicStateInit(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeterministicStateInit.DeterministicStateInitPayload>(), jobj["DeterministicStateInit"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        if (knownVariantNames.contains(key)) {
                            when (key) {
                            "DeployContract" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant DeployContract: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployContract>(), obj)
                            }
                            "FunctionCall" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant FunctionCall: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.FunctionCall>(), obj)
                            }
                            "Transfer" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant Transfer: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Transfer>(), obj)
                            }
                            "Stake" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant Stake: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Stake>(), obj)
                            }
                            "AddKey" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant AddKey: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.AddKey>(), obj)
                            }
                            "DeleteKey" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant DeleteKey: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteKey>(), obj)
                            }
                            "DeleteAccount" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant DeleteAccount: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteAccount>(), obj)
                            }
                            "Delegate" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant Delegate: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Delegate>(), obj)
                            }
                            "DeployGlobalContract" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant DeployGlobalContract: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContract>(), obj)
                            }
                            "DeployGlobalContractByAccountId" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant DeployGlobalContractByAccountId: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContractByAccountId>(), obj)
                            }
                            "UseGlobalContract" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant UseGlobalContract: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContract>(), obj)
                            }
                            "UseGlobalContractByAccountId" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant UseGlobalContractByAccountId: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContractByAccountId>(), obj)
                            }
                            "DeterministicStateInit" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant DeterministicStateInit: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeterministicStateInit>(), obj)
                            }
                            "CreateAccount" -> return io.github.hosseinkarami_dev.near.rpc.models.ActionView.CreateAccount
                            else -> { /* knownVariantNames.contains(key) guards this branch; shouldn't reach here */ }
                            }
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("DeployContract")
                    for (cand in discriminatorCandidates) {
                        val candElem = jobj[cand]
                        if (candElem is JsonPrimitive) {
                            typeField = candElem.contentOrNull
                            if (typeField != null) break
                        }
                    }
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
                            "CreateAccount" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.CreateAccount>(), jobj)
                            "DeployContract" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployContract>(), jobj)
                            "FunctionCall" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.FunctionCall>(), jobj)
                            "Transfer" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Transfer>(), jobj)
                            "Stake" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Stake>(), jobj)
                            "AddKey" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.AddKey>(), jobj)
                            "DeleteKey" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteKey>(), jobj)
                            "DeleteAccount" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteAccount>(), jobj)
                            "Delegate" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Delegate>(), jobj)
                            "DeployGlobalContract" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContract>(), jobj)
                            "DeployGlobalContractByAccountId" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContractByAccountId>(), jobj)
                            "UseGlobalContract" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContract>(), jobj)
                            "UseGlobalContractByAccountId" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContractByAccountId>(), jobj)
                            "DeterministicStateInit" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeterministicStateInit>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("CreateAccount".lowercase() == tfLower || tfLower.contains("CreateAccount".lowercase()) || "CreateAccount".lowercase().contains(tfLower))) { chosenGroupKey = "CreateAccount" }
                        if (chosenGroupKey == null && ("DeployContract".lowercase() == tfLower || tfLower.contains("DeployContract".lowercase()) || "DeployContract".lowercase().contains(tfLower))) { chosenGroupKey = "DeployContract" }
                        if (chosenGroupKey == null && ("FunctionCall".lowercase() == tfLower || tfLower.contains("FunctionCall".lowercase()) || "FunctionCall".lowercase().contains(tfLower))) { chosenGroupKey = "FunctionCall" }
                        if (chosenGroupKey == null && ("Transfer".lowercase() == tfLower || tfLower.contains("Transfer".lowercase()) || "Transfer".lowercase().contains(tfLower))) { chosenGroupKey = "Transfer" }
                        if (chosenGroupKey == null && ("Stake".lowercase() == tfLower || tfLower.contains("Stake".lowercase()) || "Stake".lowercase().contains(tfLower))) { chosenGroupKey = "Stake" }
                        if (chosenGroupKey == null && ("AddKey".lowercase() == tfLower || tfLower.contains("AddKey".lowercase()) || "AddKey".lowercase().contains(tfLower))) { chosenGroupKey = "AddKey" }
                        if (chosenGroupKey == null && ("DeleteKey".lowercase() == tfLower || tfLower.contains("DeleteKey".lowercase()) || "DeleteKey".lowercase().contains(tfLower))) { chosenGroupKey = "DeleteKey" }
                        if (chosenGroupKey == null && ("DeleteAccount".lowercase() == tfLower || tfLower.contains("DeleteAccount".lowercase()) || "DeleteAccount".lowercase().contains(tfLower))) { chosenGroupKey = "DeleteAccount" }
                        if (chosenGroupKey == null && ("Delegate".lowercase() == tfLower || tfLower.contains("Delegate".lowercase()) || "Delegate".lowercase().contains(tfLower))) { chosenGroupKey = "Delegate" }
                        if (chosenGroupKey == null && ("DeployGlobalContract".lowercase() == tfLower || tfLower.contains("DeployGlobalContract".lowercase()) || "DeployGlobalContract".lowercase().contains(tfLower))) { chosenGroupKey = "DeployGlobalContract" }
                        if (chosenGroupKey == null && ("DeployGlobalContractByAccountId".lowercase() == tfLower || tfLower.contains("DeployGlobalContractByAccountId".lowercase()) || "DeployGlobalContractByAccountId".lowercase().contains(tfLower))) { chosenGroupKey = "DeployGlobalContractByAccountId" }
                        if (chosenGroupKey == null && ("UseGlobalContract".lowercase() == tfLower || tfLower.contains("UseGlobalContract".lowercase()) || "UseGlobalContract".lowercase().contains(tfLower))) { chosenGroupKey = "UseGlobalContract" }
                        if (chosenGroupKey == null && ("UseGlobalContractByAccountId".lowercase() == tfLower || tfLower.contains("UseGlobalContractByAccountId".lowercase()) || "UseGlobalContractByAccountId".lowercase().contains(tfLower))) { chosenGroupKey = "UseGlobalContractByAccountId" }
                        if (chosenGroupKey == null && ("DeterministicStateInit".lowercase() == tfLower || tfLower.contains("DeterministicStateInit".lowercase()) || "DeterministicStateInit".lowercase().contains(tfLower))) { chosenGroupKey = "DeterministicStateInit" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "CreateAccount" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.CreateAccount>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'CreateAccount' and tf='\$tf'")
                                }
                                "DeployContract" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployContract>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DeployContract' and tf='\$tf'")
                                }
                                "FunctionCall" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.FunctionCall>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'FunctionCall' and tf='\$tf'")
                                }
                                "Transfer" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Transfer>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Transfer' and tf='\$tf'")
                                }
                                "Stake" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Stake>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Stake' and tf='\$tf'")
                                }
                                "AddKey" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.AddKey>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'AddKey' and tf='\$tf'")
                                }
                                "DeleteKey" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteKey>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DeleteKey' and tf='\$tf'")
                                }
                                "DeleteAccount" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteAccount>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DeleteAccount' and tf='\$tf'")
                                }
                                "Delegate" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Delegate>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Delegate' and tf='\$tf'")
                                }
                                "DeployGlobalContract" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContract>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DeployGlobalContract' and tf='\$tf'")
                                }
                                "DeployGlobalContractByAccountId" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContractByAccountId>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DeployGlobalContractByAccountId' and tf='\$tf'")
                                }
                                "UseGlobalContract" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContract>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'UseGlobalContract' and tf='\$tf'")
                                }
                                "UseGlobalContractByAccountId" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContractByAccountId>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'UseGlobalContractByAccountId' and tf='\$tf'")
                                }
                                "DeterministicStateInit" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeterministicStateInit>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DeterministicStateInit' and tf='\$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: CreateAccount
                    // group: DeployContract
                    // group: FunctionCall
                    // group: Transfer
                    // group: Stake
                    // group: AddKey
                    // group: DeleteKey
                    // group: DeleteAccount
                    // group: Delegate
                    // group: DeployGlobalContract
                    // group: DeployGlobalContractByAccountId
                    // group: UseGlobalContract
                    // group: UseGlobalContractByAccountId
                    // group: DeterministicStateInit

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("DeployContract")) requiredMatches.add(1)
                    if (jobj.containsKey("FunctionCall")) requiredMatches.add(2)
                    if (jobj.containsKey("Transfer")) requiredMatches.add(3)
                    if (jobj.containsKey("Stake")) requiredMatches.add(4)
                    if (jobj.containsKey("AddKey")) requiredMatches.add(5)
                    if (jobj.containsKey("DeleteKey")) requiredMatches.add(6)
                    if (jobj.containsKey("DeleteAccount")) requiredMatches.add(7)
                    if (jobj.containsKey("Delegate")) requiredMatches.add(8)
                    if (jobj.containsKey("DeployGlobalContract")) requiredMatches.add(9)
                    if (jobj.containsKey("DeployGlobalContractByAccountId")) requiredMatches.add(10)
                    if (jobj.containsKey("UseGlobalContract")) requiredMatches.add(11)
                    if (jobj.containsKey("UseGlobalContractByAccountId")) requiredMatches.add(12)
                    if (jobj.containsKey("DeterministicStateInit")) requiredMatches.add(13)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.CreateAccount>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployContract>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.FunctionCall>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Transfer>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Stake>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.AddKey>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteKey>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteAccount>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Delegate>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContract>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContractByAccountId>(), jobj)
                            11 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContract>(), jobj)
                            12 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContractByAccountId>(), jobj)
                            13 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeterministicStateInit>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 0 }
                    run {
                        var matchCount = 0
                        if (jobj["DeployContract"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["FunctionCall"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["Transfer"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 3 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["Stake"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 4 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["AddKey"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 5 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["DeleteKey"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 6 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["DeleteAccount"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 7 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["Delegate"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 8 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["DeployGlobalContract"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 9 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["DeployGlobalContractByAccountId"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 10 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["UseGlobalContract"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 11 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["UseGlobalContractByAccountId"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 12 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["DeterministicStateInit"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 13 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.CreateAccount>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployContract>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.FunctionCall>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Transfer>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Stake>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.AddKey>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteKey>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteAccount>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Delegate>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContract>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContractByAccountId>(), jobj)
                            11 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContract>(), jobj)
                            12 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContractByAccountId>(), jobj)
                            13 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeterministicStateInit>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployContract>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.FunctionCall>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Transfer>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Stake>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.AddKey>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteKey>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeleteAccount>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.Delegate>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContract>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeployGlobalContractByAccountId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContract>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.UseGlobalContractByAccountId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionView.DeterministicStateInit>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in ActionView")
                }
            }
        }
        throw SerializationException("Cannot deserialize ActionView with non-JSON decoder")
    }
}
