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
import io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView
import kotlinx.serialization.json.*

object StateChangeKindViewSerializer : KSerializer<StateChangeKindView> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView") {
        element("account_touched", serializer<JsonElement>().descriptor)
        element("access_key_touched", serializer<JsonElement>().descriptor)
        element("data_touched", serializer<JsonElement>().descriptor)
        element("contract_code_touched", serializer<JsonElement>().descriptor)
    }

    // --- helper functions ---
    private fun <T> tryDecode(json: Json, serExpr: KSerializer<T>, elem: JsonElement): T = json.decodeFromJsonElement(serExpr, elem)

    override fun serialize(encoder: Encoder, value: StateChangeKindView) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccountTouched -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccountTouched.Type>(), value.type)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccessKeyTouched -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccessKeyTouched.Type>(), value.type)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.DataTouched -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.DataTouched.Type>(), value.type)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.ContractCodeTouched -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.ContractCodeTouched.Type>(), value.type)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccountTouched -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccountTouched>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccessKeyTouched -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccessKeyTouched>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.DataTouched -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.DataTouched>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.ContractCodeTouched -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.ContractCodeTouched>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): StateChangeKindView {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    throw SerializationException("Unknown discriminator (primitive) for StateChangeKindView")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing StateChangeKindView")

                is JsonObject -> {
                    val jobj = element
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "account_touched" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant account_touched: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccountTouched>(), obj)
                            }
                            "access_key_touched" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant access_key_touched: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccessKeyTouched>(), obj)
                            }
                            "data_touched" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant data_touched: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.DataTouched>(), obj)
                            }
                            "contract_code_touched" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant contract_code_touched: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.ContractCodeTouched>(), obj)
                            }
                            else -> throw SerializationException("Unknown discriminator key for StateChangeKindView: " + key)
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
                        val knownVariantNames = setOf("account_touched", "access_key_touched", "data_touched", "contract_code_touched")
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
                            "account_touched" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccountTouched>(), jobj)
                            "access_key_touched" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccessKeyTouched>(), jobj)
                            "data_touched" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.DataTouched>(), jobj)
                            "contract_code_touched" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.ContractCodeTouched>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("account_touched".lowercase() == tfLower || tfLower.contains("account_touched".lowercase()) || "account_touched".lowercase().contains(tfLower))) { chosenGroupKey = "account_touched" }
                        if (chosenGroupKey == null && ("access_key_touched".lowercase() == tfLower || tfLower.contains("access_key_touched".lowercase()) || "access_key_touched".lowercase().contains(tfLower))) { chosenGroupKey = "access_key_touched" }
                        if (chosenGroupKey == null && ("data_touched".lowercase() == tfLower || tfLower.contains("data_touched".lowercase()) || "data_touched".lowercase().contains(tfLower))) { chosenGroupKey = "data_touched" }
                        if (chosenGroupKey == null && ("contract_code_touched".lowercase() == tfLower || tfLower.contains("contract_code_touched".lowercase()) || "contract_code_touched".lowercase().contains(tfLower))) { chosenGroupKey = "contract_code_touched" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "account_touched" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccountTouched>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'account_touched' and tf='$tf'")
                                }
                                "access_key_touched" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccessKeyTouched>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'access_key_touched' and tf='$tf'")
                                }
                                "data_touched" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.DataTouched>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'data_touched' and tf='$tf'")
                                }
                                "contract_code_touched" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.ContractCodeTouched>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'contract_code_touched' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: account_touched
                    // group: access_key_touched
                    // group: data_touched
                    // group: contract_code_touched

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("account_id") && jobj.containsKey("type")) requiredMatches.add(0)
                    if (jobj.containsKey("account_id") && jobj.containsKey("type")) requiredMatches.add(1)
                    if (jobj.containsKey("account_id") && jobj.containsKey("type")) requiredMatches.add(2)
                    if (jobj.containsKey("account_id") && jobj.containsKey("type")) requiredMatches.add(3)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccountTouched>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccessKeyTouched>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.DataTouched>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.ContractCodeTouched>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["type"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["type"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["type"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["type"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 3 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccountTouched>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccessKeyTouched>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.DataTouched>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.ContractCodeTouched>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccountTouched>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccessKeyTouched>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.DataTouched>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.ContractCodeTouched>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in StateChangeKindView")
                }
            }
        }
        throw SerializationException("Cannot deserialize StateChangeKindView with non-JSON decoder")
    }
}
