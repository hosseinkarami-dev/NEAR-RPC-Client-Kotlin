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
import io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction
import kotlinx.serialization.json.*

object NonDelegateActionSerializer : KSerializer<NonDelegateAction> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction") {
        element("CreateAccount", serializer<JsonElement>().descriptor)
        element("DeployContract", serializer<JsonElement>().descriptor)
        element("FunctionCall", serializer<JsonElement>().descriptor)
        element("Transfer", serializer<JsonElement>().descriptor)
        element("Stake", serializer<JsonElement>().descriptor)
        element("AddKey", serializer<JsonElement>().descriptor)
        element("DeleteKey", serializer<JsonElement>().descriptor)
        element("DeleteAccount", serializer<JsonElement>().descriptor)
        element("DeployGlobalContract", serializer<JsonElement>().descriptor)
        element("UseGlobalContract", serializer<JsonElement>().descriptor)
        element("DeterministicStateInit", serializer<JsonElement>().descriptor)
        element("AddGasKey", serializer<JsonElement>().descriptor)
        element("DeleteGasKey", serializer<JsonElement>().descriptor)
        element("TransferToGasKey", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: NonDelegateAction) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.CreateAccount -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["CreateAccount"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CreateAccountAction>(), value.createAccount)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeployContract -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["DeployContract"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.DeployContractAction>(), value.deployContract)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.FunctionCall -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["FunctionCall"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallAction>(), value.functionCall)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.Transfer -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["Transfer"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TransferAction>(), value.transfer)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.Stake -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["Stake"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StakeAction>(), value.stake)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.AddKey -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["AddKey"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AddKeyAction>(), value.addKey)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteKey -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["DeleteKey"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.DeleteKeyAction>(), value.deleteKey)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteAccount -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["DeleteAccount"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.DeleteAccountAction>(), value.deleteAccount)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeployGlobalContract -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["DeployGlobalContract"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.DeployGlobalContractAction>(), value.deployGlobalContract)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.UseGlobalContract -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["UseGlobalContract"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.UseGlobalContractAction>(), value.useGlobalContract)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeterministicStateInit -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["DeterministicStateInit"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.DeterministicStateInitAction>(), value.deterministicStateInit)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.AddGasKey -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["AddGasKey"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AddGasKeyAction>(), value.addGasKey)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteGasKey -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["DeleteGasKey"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.DeleteGasKeyAction>(), value.deleteGasKey)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.TransferToGasKey -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["TransferToGasKey"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TransferToGasKeyAction>(), value.transferToGasKey)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.CreateAccount -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.CreateAccount>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeployContract -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeployContract>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.FunctionCall -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.FunctionCall>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.Transfer -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.Transfer>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.Stake -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.Stake>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.AddKey -> out.encodeSerializableElement(descriptor, 5, serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.AddKey>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteKey -> out.encodeSerializableElement(descriptor, 6, serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteKey>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteAccount -> out.encodeSerializableElement(descriptor, 7, serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteAccount>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeployGlobalContract -> out.encodeSerializableElement(descriptor, 8, serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeployGlobalContract>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.UseGlobalContract -> out.encodeSerializableElement(descriptor, 9, serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.UseGlobalContract>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeterministicStateInit -> out.encodeSerializableElement(descriptor, 10, serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeterministicStateInit>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.AddGasKey -> out.encodeSerializableElement(descriptor, 11, serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.AddGasKey>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteGasKey -> out.encodeSerializableElement(descriptor, 12, serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteGasKey>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.TransferToGasKey -> out.encodeSerializableElement(descriptor, 13, serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.TransferToGasKey>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): NonDelegateAction {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    throw SerializationException("Unknown discriminator (primitive) for NonDelegateAction")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing NonDelegateAction")

                is JsonObject -> {
                    val jobj = element
                    val knownVariantNames = setOf("CreateAccount", "DeployContract", "FunctionCall", "Transfer", "Stake", "AddKey", "DeleteKey", "DeleteAccount", "DeployGlobalContract", "UseGlobalContract", "DeterministicStateInit", "AddGasKey", "DeleteGasKey", "TransferToGasKey")
                    if (jobj["CreateAccount"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.CreateAccount(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CreateAccountAction>(), jobj["CreateAccount"]!!))
                    }
                    if (jobj["DeployContract"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeployContract(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.DeployContractAction>(), jobj["DeployContract"]!!))
                    }
                    if (jobj["FunctionCall"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.FunctionCall(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallAction>(), jobj["FunctionCall"]!!))
                    }
                    if (jobj["Transfer"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.Transfer(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TransferAction>(), jobj["Transfer"]!!))
                    }
                    if (jobj["Stake"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.Stake(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StakeAction>(), jobj["Stake"]!!))
                    }
                    if (jobj["AddKey"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.AddKey(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AddKeyAction>(), jobj["AddKey"]!!))
                    }
                    if (jobj["DeleteKey"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteKey(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.DeleteKeyAction>(), jobj["DeleteKey"]!!))
                    }
                    if (jobj["DeleteAccount"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteAccount(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.DeleteAccountAction>(), jobj["DeleteAccount"]!!))
                    }
                    if (jobj["DeployGlobalContract"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeployGlobalContract(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.DeployGlobalContractAction>(), jobj["DeployGlobalContract"]!!))
                    }
                    if (jobj["UseGlobalContract"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.UseGlobalContract(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.UseGlobalContractAction>(), jobj["UseGlobalContract"]!!))
                    }
                    if (jobj["DeterministicStateInit"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeterministicStateInit(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.DeterministicStateInitAction>(), jobj["DeterministicStateInit"]!!))
                    }
                    if (jobj["AddGasKey"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.AddGasKey(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AddGasKeyAction>(), jobj["AddGasKey"]!!))
                    }
                    if (jobj["DeleteGasKey"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteGasKey(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.DeleteGasKeyAction>(), jobj["DeleteGasKey"]!!))
                    }
                    if (jobj["TransferToGasKey"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.TransferToGasKey(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.TransferToGasKeyAction>(), jobj["TransferToGasKey"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        if (knownVariantNames.contains(key)) {
                            when (key) {
                            "CreateAccount" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant CreateAccount: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.CreateAccount>(), obj)
                            }
                            "DeployContract" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant DeployContract: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeployContract>(), obj)
                            }
                            "FunctionCall" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant FunctionCall: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.FunctionCall>(), obj)
                            }
                            "Transfer" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant Transfer: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.Transfer>(), obj)
                            }
                            "Stake" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant Stake: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.Stake>(), obj)
                            }
                            "AddKey" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant AddKey: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.AddKey>(), obj)
                            }
                            "DeleteKey" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant DeleteKey: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteKey>(), obj)
                            }
                            "DeleteAccount" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant DeleteAccount: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteAccount>(), obj)
                            }
                            "DeployGlobalContract" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant DeployGlobalContract: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeployGlobalContract>(), obj)
                            }
                            "UseGlobalContract" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant UseGlobalContract: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.UseGlobalContract>(), obj)
                            }
                            "DeterministicStateInit" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant DeterministicStateInit: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeterministicStateInit>(), obj)
                            }
                            "AddGasKey" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant AddGasKey: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.AddGasKey>(), obj)
                            }
                            "DeleteGasKey" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant DeleteGasKey: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteGasKey>(), obj)
                            }
                            "TransferToGasKey" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant TransferToGasKey: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.TransferToGasKey>(), obj)
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
                            "CreateAccount" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.CreateAccount>(), jobj)
                            "DeployContract" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeployContract>(), jobj)
                            "FunctionCall" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.FunctionCall>(), jobj)
                            "Transfer" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.Transfer>(), jobj)
                            "Stake" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.Stake>(), jobj)
                            "AddKey" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.AddKey>(), jobj)
                            "DeleteKey" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteKey>(), jobj)
                            "DeleteAccount" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteAccount>(), jobj)
                            "DeployGlobalContract" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeployGlobalContract>(), jobj)
                            "UseGlobalContract" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.UseGlobalContract>(), jobj)
                            "DeterministicStateInit" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeterministicStateInit>(), jobj)
                            "AddGasKey" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.AddGasKey>(), jobj)
                            "DeleteGasKey" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteGasKey>(), jobj)
                            "TransferToGasKey" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.TransferToGasKey>(), jobj)
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
                        if (chosenGroupKey == null && ("DeployGlobalContract".lowercase() == tfLower || tfLower.contains("DeployGlobalContract".lowercase()) || "DeployGlobalContract".lowercase().contains(tfLower))) { chosenGroupKey = "DeployGlobalContract" }
                        if (chosenGroupKey == null && ("UseGlobalContract".lowercase() == tfLower || tfLower.contains("UseGlobalContract".lowercase()) || "UseGlobalContract".lowercase().contains(tfLower))) { chosenGroupKey = "UseGlobalContract" }
                        if (chosenGroupKey == null && ("DeterministicStateInit".lowercase() == tfLower || tfLower.contains("DeterministicStateInit".lowercase()) || "DeterministicStateInit".lowercase().contains(tfLower))) { chosenGroupKey = "DeterministicStateInit" }
                        if (chosenGroupKey == null && ("AddGasKey".lowercase() == tfLower || tfLower.contains("AddGasKey".lowercase()) || "AddGasKey".lowercase().contains(tfLower))) { chosenGroupKey = "AddGasKey" }
                        if (chosenGroupKey == null && ("DeleteGasKey".lowercase() == tfLower || tfLower.contains("DeleteGasKey".lowercase()) || "DeleteGasKey".lowercase().contains(tfLower))) { chosenGroupKey = "DeleteGasKey" }
                        if (chosenGroupKey == null && ("TransferToGasKey".lowercase() == tfLower || tfLower.contains("TransferToGasKey".lowercase()) || "TransferToGasKey".lowercase().contains(tfLower))) { chosenGroupKey = "TransferToGasKey" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "CreateAccount" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.CreateAccount>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'CreateAccount' and tf='\$tf'")
                                }
                                "DeployContract" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeployContract>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DeployContract' and tf='\$tf'")
                                }
                                "FunctionCall" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.FunctionCall>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'FunctionCall' and tf='\$tf'")
                                }
                                "Transfer" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.Transfer>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Transfer' and tf='\$tf'")
                                }
                                "Stake" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.Stake>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Stake' and tf='\$tf'")
                                }
                                "AddKey" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.AddKey>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'AddKey' and tf='\$tf'")
                                }
                                "DeleteKey" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteKey>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DeleteKey' and tf='\$tf'")
                                }
                                "DeleteAccount" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteAccount>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DeleteAccount' and tf='\$tf'")
                                }
                                "DeployGlobalContract" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeployGlobalContract>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DeployGlobalContract' and tf='\$tf'")
                                }
                                "UseGlobalContract" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.UseGlobalContract>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'UseGlobalContract' and tf='\$tf'")
                                }
                                "DeterministicStateInit" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeterministicStateInit>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DeterministicStateInit' and tf='\$tf'")
                                }
                                "AddGasKey" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.AddGasKey>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'AddGasKey' and tf='\$tf'")
                                }
                                "DeleteGasKey" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteGasKey>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DeleteGasKey' and tf='\$tf'")
                                }
                                "TransferToGasKey" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.TransferToGasKey>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'TransferToGasKey' and tf='\$tf'")
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
                    // group: DeployGlobalContract
                    // group: UseGlobalContract
                    // group: DeterministicStateInit
                    // group: AddGasKey
                    // group: DeleteGasKey
                    // group: TransferToGasKey

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("CreateAccount")) requiredMatches.add(0)
                    if (jobj.containsKey("DeployContract")) requiredMatches.add(1)
                    if (jobj.containsKey("FunctionCall")) requiredMatches.add(2)
                    if (jobj.containsKey("Transfer")) requiredMatches.add(3)
                    if (jobj.containsKey("Stake")) requiredMatches.add(4)
                    if (jobj.containsKey("AddKey")) requiredMatches.add(5)
                    if (jobj.containsKey("DeleteKey")) requiredMatches.add(6)
                    if (jobj.containsKey("DeleteAccount")) requiredMatches.add(7)
                    if (jobj.containsKey("DeployGlobalContract")) requiredMatches.add(8)
                    if (jobj.containsKey("UseGlobalContract")) requiredMatches.add(9)
                    if (jobj.containsKey("DeterministicStateInit")) requiredMatches.add(10)
                    if (jobj.containsKey("AddGasKey")) requiredMatches.add(11)
                    if (jobj.containsKey("DeleteGasKey")) requiredMatches.add(12)
                    if (jobj.containsKey("TransferToGasKey")) requiredMatches.add(13)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.CreateAccount>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeployContract>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.FunctionCall>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.Transfer>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.Stake>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.AddKey>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteKey>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteAccount>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeployGlobalContract>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.UseGlobalContract>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeterministicStateInit>(), jobj)
                            11 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.AddGasKey>(), jobj)
                            12 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteGasKey>(), jobj)
                            13 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.TransferToGasKey>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["CreateAccount"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
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
                        if (jobj["DeployGlobalContract"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 8 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["UseGlobalContract"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 9 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["DeterministicStateInit"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 10 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["AddGasKey"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 11 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["DeleteGasKey"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 12 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["TransferToGasKey"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 13 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.CreateAccount>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeployContract>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.FunctionCall>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.Transfer>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.Stake>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.AddKey>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteKey>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteAccount>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeployGlobalContract>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.UseGlobalContract>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeterministicStateInit>(), jobj)
                            11 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.AddGasKey>(), jobj)
                            12 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteGasKey>(), jobj)
                            13 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.TransferToGasKey>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.CreateAccount>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeployContract>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.FunctionCall>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.Transfer>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.Stake>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.AddKey>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteKey>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteAccount>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeployGlobalContract>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.UseGlobalContract>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeterministicStateInit>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.AddGasKey>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.DeleteGasKey>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.TransferToGasKey>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in NonDelegateAction")
                }
            }
        }
        throw SerializationException("Cannot deserialize NonDelegateAction with non-JSON decoder")
    }
}
