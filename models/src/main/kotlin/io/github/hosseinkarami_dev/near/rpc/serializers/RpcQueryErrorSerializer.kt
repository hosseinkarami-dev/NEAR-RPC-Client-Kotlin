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
import io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError
import kotlinx.serialization.json.*

object RpcQueryErrorSerializer : KSerializer<RpcQueryError> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError") {
        element("NO_SYNCED_BLOCKS", serializer<JsonElement>().descriptor)
        element("UNAVAILABLE_SHARD", serializer<JsonElement>().descriptor)
        element("GARBAGE_COLLECTED_BLOCK", serializer<JsonElement>().descriptor)
        element("UNKNOWN_BLOCK", serializer<JsonElement>().descriptor)
        element("INVALID_ACCOUNT", serializer<JsonElement>().descriptor)
        element("UNKNOWN_ACCOUNT", serializer<JsonElement>().descriptor)
        element("NO_CONTRACT_CODE", serializer<JsonElement>().descriptor)
        element("TOO_LARGE_CONTRACT_STATE", serializer<JsonElement>().descriptor)
        element("UNKNOWN_ACCESS_KEY", serializer<JsonElement>().descriptor)
        element("UNKNOWN_GAS_KEY", serializer<JsonElement>().descriptor)
        element("CONTRACT_EXECUTION_ERROR", serializer<JsonElement>().descriptor)
        element("NO_GLOBAL_CONTRACT_CODE", serializer<JsonElement>().descriptor)
        element("INTERNAL_ERROR", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: RpcQueryError) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoSyncedBlocks -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoSyncedBlocks.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnavailableShard -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnavailableShard.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnavailableShard.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.GarbageCollectedBlock -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.GarbageCollectedBlock.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.GarbageCollectedBlock.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownBlock -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownBlock.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownBlock.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InvalidAccount -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InvalidAccount.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InvalidAccount.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccount -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccount.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccount.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoContractCode -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoContractCode.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoContractCode.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.TooLargeContractState -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.TooLargeContractState.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.TooLargeContractState.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccessKey -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccessKey.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccessKey.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownGasKey -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownGasKey.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownGasKey.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.ContractExecutionError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.ContractExecutionError.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.ContractExecutionError.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoGlobalContractCode -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoGlobalContractCode.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoGlobalContractCode.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InternalError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InternalError.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InternalError.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoSyncedBlocks -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoSyncedBlocks>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnavailableShard -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnavailableShard>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.GarbageCollectedBlock -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.GarbageCollectedBlock>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownBlock -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownBlock>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InvalidAccount -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InvalidAccount>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccount -> out.encodeSerializableElement(descriptor, 5, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccount>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoContractCode -> out.encodeSerializableElement(descriptor, 6, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoContractCode>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.TooLargeContractState -> out.encodeSerializableElement(descriptor, 7, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.TooLargeContractState>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccessKey -> out.encodeSerializableElement(descriptor, 8, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccessKey>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownGasKey -> out.encodeSerializableElement(descriptor, 9, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownGasKey>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.ContractExecutionError -> out.encodeSerializableElement(descriptor, 10, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.ContractExecutionError>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoGlobalContractCode -> out.encodeSerializableElement(descriptor, 11, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoGlobalContractCode>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InternalError -> out.encodeSerializableElement(descriptor, 12, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InternalError>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): RpcQueryError {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    throw SerializationException("Unknown discriminator (primitive) for RpcQueryError")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing RpcQueryError")

                is JsonObject -> {
                    val jobj = element
                    val knownVariantNames = setOf("NO_SYNCED_BLOCKS", "UNAVAILABLE_SHARD", "GARBAGE_COLLECTED_BLOCK", "UNKNOWN_BLOCK", "INVALID_ACCOUNT", "UNKNOWN_ACCOUNT", "NO_CONTRACT_CODE", "TOO_LARGE_CONTRACT_STATE", "UNKNOWN_ACCESS_KEY", "UNKNOWN_GAS_KEY", "CONTRACT_EXECUTION_ERROR", "NO_GLOBAL_CONTRACT_CODE", "INTERNAL_ERROR")
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        if (knownVariantNames.contains(key)) {
                            when (key) {
                            "NO_SYNCED_BLOCKS" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant NO_SYNCED_BLOCKS: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoSyncedBlocks>(), obj)
                            }
                            "UNAVAILABLE_SHARD" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant UNAVAILABLE_SHARD: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnavailableShard>(), obj)
                            }
                            "GARBAGE_COLLECTED_BLOCK" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant GARBAGE_COLLECTED_BLOCK: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.GarbageCollectedBlock>(), obj)
                            }
                            "UNKNOWN_BLOCK" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant UNKNOWN_BLOCK: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownBlock>(), obj)
                            }
                            "INVALID_ACCOUNT" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant INVALID_ACCOUNT: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InvalidAccount>(), obj)
                            }
                            "UNKNOWN_ACCOUNT" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant UNKNOWN_ACCOUNT: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccount>(), obj)
                            }
                            "NO_CONTRACT_CODE" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant NO_CONTRACT_CODE: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoContractCode>(), obj)
                            }
                            "TOO_LARGE_CONTRACT_STATE" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant TOO_LARGE_CONTRACT_STATE: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.TooLargeContractState>(), obj)
                            }
                            "UNKNOWN_ACCESS_KEY" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant UNKNOWN_ACCESS_KEY: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccessKey>(), obj)
                            }
                            "UNKNOWN_GAS_KEY" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant UNKNOWN_GAS_KEY: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownGasKey>(), obj)
                            }
                            "CONTRACT_EXECUTION_ERROR" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant CONTRACT_EXECUTION_ERROR: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.ContractExecutionError>(), obj)
                            }
                            "NO_GLOBAL_CONTRACT_CODE" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant NO_GLOBAL_CONTRACT_CODE: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoGlobalContractCode>(), obj)
                            }
                            "INTERNAL_ERROR" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant INTERNAL_ERROR: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InternalError>(), obj)
                            }
                            else -> { /* knownVariantNames.contains(key) guards this branch; shouldn't reach here */ }
                            }
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("name", "info")
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
                            "NO_SYNCED_BLOCKS" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoSyncedBlocks>(), jobj)
                            "UNAVAILABLE_SHARD" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnavailableShard>(), jobj)
                            "GARBAGE_COLLECTED_BLOCK" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.GarbageCollectedBlock>(), jobj)
                            "UNKNOWN_BLOCK" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownBlock>(), jobj)
                            "INVALID_ACCOUNT" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InvalidAccount>(), jobj)
                            "UNKNOWN_ACCOUNT" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccount>(), jobj)
                            "NO_CONTRACT_CODE" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoContractCode>(), jobj)
                            "TOO_LARGE_CONTRACT_STATE" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.TooLargeContractState>(), jobj)
                            "UNKNOWN_ACCESS_KEY" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccessKey>(), jobj)
                            "UNKNOWN_GAS_KEY" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownGasKey>(), jobj)
                            "CONTRACT_EXECUTION_ERROR" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.ContractExecutionError>(), jobj)
                            "NO_GLOBAL_CONTRACT_CODE" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoGlobalContractCode>(), jobj)
                            "INTERNAL_ERROR" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InternalError>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("NO_SYNCED_BLOCKS".lowercase() == tfLower || tfLower.contains("NO_SYNCED_BLOCKS".lowercase()) || "NO_SYNCED_BLOCKS".lowercase().contains(tfLower))) { chosenGroupKey = "NO_SYNCED_BLOCKS" }
                        if (chosenGroupKey == null && ("UNAVAILABLE_SHARD".lowercase() == tfLower || tfLower.contains("UNAVAILABLE_SHARD".lowercase()) || "UNAVAILABLE_SHARD".lowercase().contains(tfLower))) { chosenGroupKey = "UNAVAILABLE_SHARD" }
                        if (chosenGroupKey == null && ("GARBAGE_COLLECTED_BLOCK".lowercase() == tfLower || tfLower.contains("GARBAGE_COLLECTED_BLOCK".lowercase()) || "GARBAGE_COLLECTED_BLOCK".lowercase().contains(tfLower))) { chosenGroupKey = "GARBAGE_COLLECTED_BLOCK" }
                        if (chosenGroupKey == null && ("UNKNOWN_BLOCK".lowercase() == tfLower || tfLower.contains("UNKNOWN_BLOCK".lowercase()) || "UNKNOWN_BLOCK".lowercase().contains(tfLower))) { chosenGroupKey = "UNKNOWN_BLOCK" }
                        if (chosenGroupKey == null && ("INVALID_ACCOUNT".lowercase() == tfLower || tfLower.contains("INVALID_ACCOUNT".lowercase()) || "INVALID_ACCOUNT".lowercase().contains(tfLower))) { chosenGroupKey = "INVALID_ACCOUNT" }
                        if (chosenGroupKey == null && ("UNKNOWN_ACCOUNT".lowercase() == tfLower || tfLower.contains("UNKNOWN_ACCOUNT".lowercase()) || "UNKNOWN_ACCOUNT".lowercase().contains(tfLower))) { chosenGroupKey = "UNKNOWN_ACCOUNT" }
                        if (chosenGroupKey == null && ("NO_CONTRACT_CODE".lowercase() == tfLower || tfLower.contains("NO_CONTRACT_CODE".lowercase()) || "NO_CONTRACT_CODE".lowercase().contains(tfLower))) { chosenGroupKey = "NO_CONTRACT_CODE" }
                        if (chosenGroupKey == null && ("TOO_LARGE_CONTRACT_STATE".lowercase() == tfLower || tfLower.contains("TOO_LARGE_CONTRACT_STATE".lowercase()) || "TOO_LARGE_CONTRACT_STATE".lowercase().contains(tfLower))) { chosenGroupKey = "TOO_LARGE_CONTRACT_STATE" }
                        if (chosenGroupKey == null && ("UNKNOWN_ACCESS_KEY".lowercase() == tfLower || tfLower.contains("UNKNOWN_ACCESS_KEY".lowercase()) || "UNKNOWN_ACCESS_KEY".lowercase().contains(tfLower))) { chosenGroupKey = "UNKNOWN_ACCESS_KEY" }
                        if (chosenGroupKey == null && ("UNKNOWN_GAS_KEY".lowercase() == tfLower || tfLower.contains("UNKNOWN_GAS_KEY".lowercase()) || "UNKNOWN_GAS_KEY".lowercase().contains(tfLower))) { chosenGroupKey = "UNKNOWN_GAS_KEY" }
                        if (chosenGroupKey == null && ("CONTRACT_EXECUTION_ERROR".lowercase() == tfLower || tfLower.contains("CONTRACT_EXECUTION_ERROR".lowercase()) || "CONTRACT_EXECUTION_ERROR".lowercase().contains(tfLower))) { chosenGroupKey = "CONTRACT_EXECUTION_ERROR" }
                        if (chosenGroupKey == null && ("NO_GLOBAL_CONTRACT_CODE".lowercase() == tfLower || tfLower.contains("NO_GLOBAL_CONTRACT_CODE".lowercase()) || "NO_GLOBAL_CONTRACT_CODE".lowercase().contains(tfLower))) { chosenGroupKey = "NO_GLOBAL_CONTRACT_CODE" }
                        if (chosenGroupKey == null && ("INTERNAL_ERROR".lowercase() == tfLower || tfLower.contains("INTERNAL_ERROR".lowercase()) || "INTERNAL_ERROR".lowercase().contains(tfLower))) { chosenGroupKey = "INTERNAL_ERROR" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "NO_SYNCED_BLOCKS" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoSyncedBlocks>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'NO_SYNCED_BLOCKS' and tf='\$tf'")
                                }
                                "UNAVAILABLE_SHARD" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnavailableShard>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'UNAVAILABLE_SHARD' and tf='\$tf'")
                                }
                                "GARBAGE_COLLECTED_BLOCK" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.GarbageCollectedBlock>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'GARBAGE_COLLECTED_BLOCK' and tf='\$tf'")
                                }
                                "UNKNOWN_BLOCK" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownBlock>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'UNKNOWN_BLOCK' and tf='\$tf'")
                                }
                                "INVALID_ACCOUNT" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InvalidAccount>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'INVALID_ACCOUNT' and tf='\$tf'")
                                }
                                "UNKNOWN_ACCOUNT" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccount>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'UNKNOWN_ACCOUNT' and tf='\$tf'")
                                }
                                "NO_CONTRACT_CODE" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoContractCode>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'NO_CONTRACT_CODE' and tf='\$tf'")
                                }
                                "TOO_LARGE_CONTRACT_STATE" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.TooLargeContractState>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'TOO_LARGE_CONTRACT_STATE' and tf='\$tf'")
                                }
                                "UNKNOWN_ACCESS_KEY" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccessKey>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'UNKNOWN_ACCESS_KEY' and tf='\$tf'")
                                }
                                "UNKNOWN_GAS_KEY" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownGasKey>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'UNKNOWN_GAS_KEY' and tf='\$tf'")
                                }
                                "CONTRACT_EXECUTION_ERROR" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.ContractExecutionError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'CONTRACT_EXECUTION_ERROR' and tf='\$tf'")
                                }
                                "NO_GLOBAL_CONTRACT_CODE" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoGlobalContractCode>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'NO_GLOBAL_CONTRACT_CODE' and tf='\$tf'")
                                }
                                "INTERNAL_ERROR" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InternalError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'INTERNAL_ERROR' and tf='\$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: NO_SYNCED_BLOCKS
                    // group: UNAVAILABLE_SHARD
                    // group: GARBAGE_COLLECTED_BLOCK
                    // group: UNKNOWN_BLOCK
                    // group: INVALID_ACCOUNT
                    // group: UNKNOWN_ACCOUNT
                    // group: NO_CONTRACT_CODE
                    // group: TOO_LARGE_CONTRACT_STATE
                    // group: UNKNOWN_ACCESS_KEY
                    // group: UNKNOWN_GAS_KEY
                    // group: CONTRACT_EXECUTION_ERROR
                    // group: NO_GLOBAL_CONTRACT_CODE
                    // group: INTERNAL_ERROR

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("name")) requiredMatches.add(0)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(1)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(2)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(3)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(4)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(5)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(6)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(7)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(8)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(9)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(10)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(11)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(12)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoSyncedBlocks>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnavailableShard>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.GarbageCollectedBlock>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownBlock>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InvalidAccount>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccount>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoContractCode>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.TooLargeContractState>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccessKey>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownGasKey>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.ContractExecutionError>(), jobj)
                            11 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoGlobalContractCode>(), jobj)
                            12 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InternalError>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["info"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["info"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["info"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 3 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["info"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 4 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["info"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 5 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["info"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 6 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["info"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 7 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["info"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 8 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["info"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 9 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["info"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 10 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["info"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 11 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["info"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 12 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoSyncedBlocks>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnavailableShard>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.GarbageCollectedBlock>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownBlock>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InvalidAccount>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccount>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoContractCode>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.TooLargeContractState>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccessKey>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownGasKey>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.ContractExecutionError>(), jobj)
                            11 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoGlobalContractCode>(), jobj)
                            12 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InternalError>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoSyncedBlocks>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnavailableShard>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.GarbageCollectedBlock>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownBlock>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InvalidAccount>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccount>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoContractCode>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.TooLargeContractState>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccessKey>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownGasKey>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.ContractExecutionError>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoGlobalContractCode>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InternalError>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in RpcQueryError")
                }
            }
        }
        throw SerializationException("Cannot deserialize RpcQueryError with non-JSON decoder")
    }
}
