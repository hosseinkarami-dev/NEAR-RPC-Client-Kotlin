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
import io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView
import kotlinx.serialization.json.*

object StateChangeWithCauseViewSerializer : KSerializer<StateChangeWithCauseView> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView") {
        element("account_update", serializer<JsonElement>().descriptor)
        element("account_deletion", serializer<JsonElement>().descriptor)
        element("access_key_update", serializer<JsonElement>().descriptor)
        element("access_key_deletion", serializer<JsonElement>().descriptor)
        element("gas_key_update", serializer<JsonElement>().descriptor)
        element("gas_key_nonce_update", serializer<JsonElement>().descriptor)
        element("gas_key_deletion", serializer<JsonElement>().descriptor)
        element("data_update", serializer<JsonElement>().descriptor)
        element("data_deletion", serializer<JsonElement>().descriptor)
        element("contract_code_update", serializer<JsonElement>().descriptor)
        element("contract_code_deletion", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: StateChangeWithCauseView) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountUpdate -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["change"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountUpdate.ChangePayload>(), value.change)
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountUpdate.Type>(), value.type)
                    map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView>(), value.cause)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountDeletion -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["change"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountDeletion.ChangePayload>(), value.change)
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountDeletion.Type>(), value.type)
                    map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView>(), value.cause)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyUpdate -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["change"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyUpdate.ChangePayload>(), value.change)
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyUpdate.Type>(), value.type)
                    map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView>(), value.cause)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyDeletion -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["change"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyDeletion.ChangePayload>(), value.change)
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyDeletion.Type>(), value.type)
                    map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView>(), value.cause)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyUpdate -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["change"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyUpdate.ChangePayload>(), value.change)
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyUpdate.Type>(), value.type)
                    map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView>(), value.cause)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyNonceUpdate -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["change"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyNonceUpdate.ChangePayload>(), value.change)
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyNonceUpdate.Type>(), value.type)
                    map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView>(), value.cause)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyDeletion -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["change"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyDeletion.ChangePayload>(), value.change)
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyDeletion.Type>(), value.type)
                    map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView>(), value.cause)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataUpdate -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["change"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataUpdate.ChangePayload>(), value.change)
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataUpdate.Type>(), value.type)
                    map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView>(), value.cause)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataDeletion -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["change"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataDeletion.ChangePayload>(), value.change)
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataDeletion.Type>(), value.type)
                    map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView>(), value.cause)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeUpdate -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["change"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeUpdate.ChangePayload>(), value.change)
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeUpdate.Type>(), value.type)
                    map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView>(), value.cause)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeDeletion -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["change"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeDeletion.ChangePayload>(), value.change)
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeDeletion.Type>(), value.type)
                    map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView>(), value.cause)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountUpdate -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountUpdate>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountDeletion -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountDeletion>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyUpdate -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyUpdate>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyDeletion -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyDeletion>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyUpdate -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyUpdate>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyNonceUpdate -> out.encodeSerializableElement(descriptor, 5, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyNonceUpdate>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyDeletion -> out.encodeSerializableElement(descriptor, 6, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyDeletion>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataUpdate -> out.encodeSerializableElement(descriptor, 7, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataUpdate>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataDeletion -> out.encodeSerializableElement(descriptor, 8, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataDeletion>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeUpdate -> out.encodeSerializableElement(descriptor, 9, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeUpdate>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeDeletion -> out.encodeSerializableElement(descriptor, 10, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeDeletion>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): StateChangeWithCauseView {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    throw SerializationException("Unknown discriminator (primitive) for StateChangeWithCauseView")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing StateChangeWithCauseView")

                is JsonObject -> {
                    val jobj = element
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "account_update" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant account_update: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountUpdate>(), obj)
                            }
                            "account_deletion" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant account_deletion: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountDeletion>(), obj)
                            }
                            "access_key_update" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant access_key_update: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyUpdate>(), obj)
                            }
                            "access_key_deletion" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant access_key_deletion: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyDeletion>(), obj)
                            }
                            "gas_key_update" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant gas_key_update: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyUpdate>(), obj)
                            }
                            "gas_key_nonce_update" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant gas_key_nonce_update: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyNonceUpdate>(), obj)
                            }
                            "gas_key_deletion" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant gas_key_deletion: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyDeletion>(), obj)
                            }
                            "data_update" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant data_update: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataUpdate>(), obj)
                            }
                            "data_deletion" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant data_deletion: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataDeletion>(), obj)
                            }
                            "contract_code_update" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant contract_code_update: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeUpdate>(), obj)
                            }
                            "contract_code_deletion" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant contract_code_deletion: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeDeletion>(), obj)
                            }
                            else -> throw SerializationException("Unknown discriminator key for StateChangeWithCauseView: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("change", "type")
                    for (cand in discriminatorCandidates) {
                        val candElem = jobj[cand]
                        if (candElem is JsonPrimitive) {
                            typeField = candElem.contentOrNull
                            if (typeField != null) break
                        }
                    }
                    if (typeField == null) {
                        val knownVariantNames = setOf("account_update", "account_deletion", "access_key_update", "access_key_deletion", "gas_key_update", "gas_key_nonce_update", "gas_key_deletion", "data_update", "data_deletion", "contract_code_update", "contract_code_deletion")
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
                            "account_update" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountUpdate>(), jobj)
                            "account_deletion" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountDeletion>(), jobj)
                            "access_key_update" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyUpdate>(), jobj)
                            "access_key_deletion" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyDeletion>(), jobj)
                            "gas_key_update" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyUpdate>(), jobj)
                            "gas_key_nonce_update" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyNonceUpdate>(), jobj)
                            "gas_key_deletion" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyDeletion>(), jobj)
                            "data_update" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataUpdate>(), jobj)
                            "data_deletion" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataDeletion>(), jobj)
                            "contract_code_update" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeUpdate>(), jobj)
                            "contract_code_deletion" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeDeletion>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("account_update".lowercase() == tfLower || tfLower.contains("account_update".lowercase()) || "account_update".lowercase().contains(tfLower))) { chosenGroupKey = "account_update" }
                        if (chosenGroupKey == null && ("account_deletion".lowercase() == tfLower || tfLower.contains("account_deletion".lowercase()) || "account_deletion".lowercase().contains(tfLower))) { chosenGroupKey = "account_deletion" }
                        if (chosenGroupKey == null && ("access_key_update".lowercase() == tfLower || tfLower.contains("access_key_update".lowercase()) || "access_key_update".lowercase().contains(tfLower))) { chosenGroupKey = "access_key_update" }
                        if (chosenGroupKey == null && ("access_key_deletion".lowercase() == tfLower || tfLower.contains("access_key_deletion".lowercase()) || "access_key_deletion".lowercase().contains(tfLower))) { chosenGroupKey = "access_key_deletion" }
                        if (chosenGroupKey == null && ("gas_key_update".lowercase() == tfLower || tfLower.contains("gas_key_update".lowercase()) || "gas_key_update".lowercase().contains(tfLower))) { chosenGroupKey = "gas_key_update" }
                        if (chosenGroupKey == null && ("gas_key_nonce_update".lowercase() == tfLower || tfLower.contains("gas_key_nonce_update".lowercase()) || "gas_key_nonce_update".lowercase().contains(tfLower))) { chosenGroupKey = "gas_key_nonce_update" }
                        if (chosenGroupKey == null && ("gas_key_deletion".lowercase() == tfLower || tfLower.contains("gas_key_deletion".lowercase()) || "gas_key_deletion".lowercase().contains(tfLower))) { chosenGroupKey = "gas_key_deletion" }
                        if (chosenGroupKey == null && ("data_update".lowercase() == tfLower || tfLower.contains("data_update".lowercase()) || "data_update".lowercase().contains(tfLower))) { chosenGroupKey = "data_update" }
                        if (chosenGroupKey == null && ("data_deletion".lowercase() == tfLower || tfLower.contains("data_deletion".lowercase()) || "data_deletion".lowercase().contains(tfLower))) { chosenGroupKey = "data_deletion" }
                        if (chosenGroupKey == null && ("contract_code_update".lowercase() == tfLower || tfLower.contains("contract_code_update".lowercase()) || "contract_code_update".lowercase().contains(tfLower))) { chosenGroupKey = "contract_code_update" }
                        if (chosenGroupKey == null && ("contract_code_deletion".lowercase() == tfLower || tfLower.contains("contract_code_deletion".lowercase()) || "contract_code_deletion".lowercase().contains(tfLower))) { chosenGroupKey = "contract_code_deletion" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "account_update" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountUpdate>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'account_update' and tf='$tf'")
                                }
                                "account_deletion" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountDeletion>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'account_deletion' and tf='$tf'")
                                }
                                "access_key_update" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyUpdate>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'access_key_update' and tf='$tf'")
                                }
                                "access_key_deletion" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyDeletion>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'access_key_deletion' and tf='$tf'")
                                }
                                "gas_key_update" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyUpdate>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'gas_key_update' and tf='$tf'")
                                }
                                "gas_key_nonce_update" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyNonceUpdate>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'gas_key_nonce_update' and tf='$tf'")
                                }
                                "gas_key_deletion" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyDeletion>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'gas_key_deletion' and tf='$tf'")
                                }
                                "data_update" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataUpdate>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'data_update' and tf='$tf'")
                                }
                                "data_deletion" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataDeletion>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'data_deletion' and tf='$tf'")
                                }
                                "contract_code_update" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeUpdate>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'contract_code_update' and tf='$tf'")
                                }
                                "contract_code_deletion" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeDeletion>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'contract_code_deletion' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: account_update
                    // group: account_deletion
                    // group: access_key_update
                    // group: access_key_deletion
                    // group: gas_key_update
                    // group: gas_key_nonce_update
                    // group: gas_key_deletion
                    // group: data_update
                    // group: data_deletion
                    // group: contract_code_update
                    // group: contract_code_deletion

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("change") && jobj.containsKey("type") && jobj.containsKey("cause")) requiredMatches.add(0)
                    if (jobj.containsKey("change") && jobj.containsKey("type") && jobj.containsKey("cause")) requiredMatches.add(1)
                    if (jobj.containsKey("change") && jobj.containsKey("type") && jobj.containsKey("cause")) requiredMatches.add(2)
                    if (jobj.containsKey("change") && jobj.containsKey("type") && jobj.containsKey("cause")) requiredMatches.add(3)
                    if (jobj.containsKey("change") && jobj.containsKey("type") && jobj.containsKey("cause")) requiredMatches.add(4)
                    if (jobj.containsKey("change") && jobj.containsKey("type") && jobj.containsKey("cause")) requiredMatches.add(5)
                    if (jobj.containsKey("change") && jobj.containsKey("type") && jobj.containsKey("cause")) requiredMatches.add(6)
                    if (jobj.containsKey("change") && jobj.containsKey("type") && jobj.containsKey("cause")) requiredMatches.add(7)
                    if (jobj.containsKey("change") && jobj.containsKey("type") && jobj.containsKey("cause")) requiredMatches.add(8)
                    if (jobj.containsKey("change") && jobj.containsKey("type") && jobj.containsKey("cause")) requiredMatches.add(9)
                    if (jobj.containsKey("change") && jobj.containsKey("type") && jobj.containsKey("cause")) requiredMatches.add(10)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountUpdate>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountDeletion>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyUpdate>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyDeletion>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyUpdate>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyNonceUpdate>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyDeletion>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataUpdate>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataDeletion>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeUpdate>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeDeletion>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["change"] != null) matchCount++
                        if (jobj["type"] != null) matchCount++
                        if (jobj["cause"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["change"] != null) matchCount++
                        if (jobj["type"] != null) matchCount++
                        if (jobj["cause"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["change"] != null) matchCount++
                        if (jobj["type"] != null) matchCount++
                        if (jobj["cause"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["change"] != null) matchCount++
                        if (jobj["type"] != null) matchCount++
                        if (jobj["cause"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 3 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["change"] != null) matchCount++
                        if (jobj["type"] != null) matchCount++
                        if (jobj["cause"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 4 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["change"] != null) matchCount++
                        if (jobj["type"] != null) matchCount++
                        if (jobj["cause"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 5 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["change"] != null) matchCount++
                        if (jobj["type"] != null) matchCount++
                        if (jobj["cause"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 6 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["change"] != null) matchCount++
                        if (jobj["type"] != null) matchCount++
                        if (jobj["cause"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 7 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["change"] != null) matchCount++
                        if (jobj["type"] != null) matchCount++
                        if (jobj["cause"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 8 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["change"] != null) matchCount++
                        if (jobj["type"] != null) matchCount++
                        if (jobj["cause"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 9 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["change"] != null) matchCount++
                        if (jobj["type"] != null) matchCount++
                        if (jobj["cause"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 10 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountUpdate>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountDeletion>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyUpdate>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyDeletion>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyUpdate>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyNonceUpdate>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyDeletion>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataUpdate>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataDeletion>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeUpdate>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeDeletion>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountUpdate>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountDeletion>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyUpdate>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyDeletion>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyUpdate>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyNonceUpdate>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyDeletion>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataUpdate>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataDeletion>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeUpdate>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeDeletion>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in StateChangeWithCauseView")
                }
            }
        }
        throw SerializationException("Cannot deserialize StateChangeWithCauseView with non-JSON decoder")
    }
}
