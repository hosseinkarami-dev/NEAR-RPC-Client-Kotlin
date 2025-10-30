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
import io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError
import kotlinx.serialization.json.*

object InvalidTxErrorSerializer : KSerializer<InvalidTxError> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError") {
        element("InvalidAccessKeyError", serializer<JsonElement>().descriptor)
        element("InvalidSignerId", serializer<JsonElement>().descriptor)
        element("SignerDoesNotExist", serializer<JsonElement>().descriptor)
        element("InvalidNonce", serializer<JsonElement>().descriptor)
        element("NonceTooLarge", serializer<JsonElement>().descriptor)
        element("InvalidReceiverId", serializer<JsonElement>().descriptor)
        element("InvalidSignature", serializer<JsonElement>().descriptor)
        element("NotEnoughBalance", serializer<JsonElement>().descriptor)
        element("LackBalanceForState", serializer<JsonElement>().descriptor)
        element("CostOverflow", serializer<JsonElement>().descriptor)
        element("InvalidChain", serializer<JsonElement>().descriptor)
        element("Expired", serializer<JsonElement>().descriptor)
        element("ActionsValidation", serializer<JsonElement>().descriptor)
        element("TransactionSizeExceeded", serializer<JsonElement>().descriptor)
        element("InvalidTransactionVersion", serializer<JsonElement>().descriptor)
        element("StorageError", serializer<JsonElement>().descriptor)
        element("ShardCongested", serializer<JsonElement>().descriptor)
        element("ShardStuck", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: InvalidTxError) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidAccessKeyError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["InvalidAccessKeyError"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError>(), value.invalidAccessKeyError)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidSignerId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["InvalidSignerId"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidSignerId.InvalidSignerIdPayload>(), value.invalidSignerId)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.SignerDoesNotExist -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["SignerDoesNotExist"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.SignerDoesNotExist.SignerDoesNotExistPayload>(), value.signerDoesNotExist)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidNonce -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["InvalidNonce"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidNonce.InvalidNoncePayload>(), value.invalidNonce)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NonceTooLarge -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["NonceTooLarge"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NonceTooLarge.NonceTooLargePayload>(), value.nonceTooLarge)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidReceiverId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["InvalidReceiverId"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidReceiverId.InvalidReceiverIdPayload>(), value.invalidReceiverId)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidSignature -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("InvalidSignature"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NotEnoughBalance -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["NotEnoughBalance"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NotEnoughBalance.NotEnoughBalancePayload>(), value.notEnoughBalance)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.LackBalanceForState -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["LackBalanceForState"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.LackBalanceForState.LackBalanceForStatePayload>(), value.lackBalanceForState)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.CostOverflow -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("CostOverflow"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidChain -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("InvalidChain"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.Expired -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("Expired"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ActionsValidation -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["ActionsValidation"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError>(), value.actionsValidation)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.TransactionSizeExceeded -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["TransactionSizeExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.TransactionSizeExceeded.TransactionSizeExceededPayload>(), value.transactionSizeExceeded)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidTransactionVersion -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("InvalidTransactionVersion"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.StorageError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["StorageError"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError>(), value.storageError)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardCongested -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["ShardCongested"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardCongested.ShardCongestedPayload>(), value.shardCongested)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardStuck -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["ShardStuck"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardStuck.ShardStuckPayload>(), value.shardStuck)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidAccessKeyError -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidAccessKeyError>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidSignerId -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidSignerId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.SignerDoesNotExist -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.SignerDoesNotExist>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidNonce -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidNonce>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NonceTooLarge -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NonceTooLarge>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidReceiverId -> out.encodeSerializableElement(descriptor, 5, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidReceiverId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidSignature -> out.encodeSerializableElement(descriptor, 6, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidSignature>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NotEnoughBalance -> out.encodeSerializableElement(descriptor, 7, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NotEnoughBalance>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.LackBalanceForState -> out.encodeSerializableElement(descriptor, 8, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.LackBalanceForState>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.CostOverflow -> out.encodeSerializableElement(descriptor, 9, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.CostOverflow>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidChain -> out.encodeSerializableElement(descriptor, 10, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidChain>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.Expired -> out.encodeSerializableElement(descriptor, 11, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.Expired>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ActionsValidation -> out.encodeSerializableElement(descriptor, 12, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ActionsValidation>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.TransactionSizeExceeded -> out.encodeSerializableElement(descriptor, 13, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.TransactionSizeExceeded>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidTransactionVersion -> out.encodeSerializableElement(descriptor, 14, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidTransactionVersion>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.StorageError -> out.encodeSerializableElement(descriptor, 15, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.StorageError>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardCongested -> out.encodeSerializableElement(descriptor, 16, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardCongested>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardStuck -> out.encodeSerializableElement(descriptor, 17, serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardStuck>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): InvalidTxError {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                        if (s == "InvalidSignature") return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidSignature
                        if (s == "CostOverflow") return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.CostOverflow
                        if (s == "InvalidChain") return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidChain
                        if (s == "Expired") return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.Expired
                        if (s == "InvalidTransactionVersion") return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidTransactionVersion
                    }
                    throw SerializationException("Unknown discriminator (primitive) for InvalidTxError")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing InvalidTxError")

                is JsonObject -> {
                    val jobj = element
                    if (jobj["InvalidAccessKeyError"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidAccessKeyError(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError>(), jobj["InvalidAccessKeyError"]!!))
                    }
                    if (jobj["InvalidSignerId"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidSignerId(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidSignerId.InvalidSignerIdPayload>(), jobj["InvalidSignerId"]!!))
                    }
                    if (jobj["SignerDoesNotExist"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.SignerDoesNotExist(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.SignerDoesNotExist.SignerDoesNotExistPayload>(), jobj["SignerDoesNotExist"]!!))
                    }
                    if (jobj["InvalidNonce"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidNonce(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidNonce.InvalidNoncePayload>(), jobj["InvalidNonce"]!!))
                    }
                    if (jobj["NonceTooLarge"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NonceTooLarge(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NonceTooLarge.NonceTooLargePayload>(), jobj["NonceTooLarge"]!!))
                    }
                    if (jobj["InvalidReceiverId"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidReceiverId(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidReceiverId.InvalidReceiverIdPayload>(), jobj["InvalidReceiverId"]!!))
                    }
                    if (jobj["NotEnoughBalance"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NotEnoughBalance(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NotEnoughBalance.NotEnoughBalancePayload>(), jobj["NotEnoughBalance"]!!))
                    }
                    if (jobj["LackBalanceForState"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.LackBalanceForState(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.LackBalanceForState.LackBalanceForStatePayload>(), jobj["LackBalanceForState"]!!))
                    }
                    if (jobj["ActionsValidation"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ActionsValidation(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError>(), jobj["ActionsValidation"]!!))
                    }
                    if (jobj["TransactionSizeExceeded"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.TransactionSizeExceeded(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.TransactionSizeExceeded.TransactionSizeExceededPayload>(), jobj["TransactionSizeExceeded"]!!))
                    }
                    if (jobj["StorageError"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.StorageError(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError>(), jobj["StorageError"]!!))
                    }
                    if (jobj["ShardCongested"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardCongested(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardCongested.ShardCongestedPayload>(), jobj["ShardCongested"]!!))
                    }
                    if (jobj["ShardStuck"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardStuck(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardStuck.ShardStuckPayload>(), jobj["ShardStuck"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "InvalidAccessKeyError" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant InvalidAccessKeyError: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidAccessKeyError>(), obj)
                            }
                            "InvalidSignerId" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant InvalidSignerId: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidSignerId>(), obj)
                            }
                            "SignerDoesNotExist" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant SignerDoesNotExist: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.SignerDoesNotExist>(), obj)
                            }
                            "InvalidNonce" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant InvalidNonce: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidNonce>(), obj)
                            }
                            "NonceTooLarge" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant NonceTooLarge: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NonceTooLarge>(), obj)
                            }
                            "InvalidReceiverId" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant InvalidReceiverId: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidReceiverId>(), obj)
                            }
                            "NotEnoughBalance" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant NotEnoughBalance: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NotEnoughBalance>(), obj)
                            }
                            "LackBalanceForState" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant LackBalanceForState: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.LackBalanceForState>(), obj)
                            }
                            "ActionsValidation" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant ActionsValidation: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ActionsValidation>(), obj)
                            }
                            "TransactionSizeExceeded" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant TransactionSizeExceeded: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.TransactionSizeExceeded>(), obj)
                            }
                            "StorageError" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant StorageError: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.StorageError>(), obj)
                            }
                            "ShardCongested" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant ShardCongested: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardCongested>(), obj)
                            }
                            "ShardStuck" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant ShardStuck: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardStuck>(), obj)
                            }
                            "InvalidSignature" -> return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidSignature
                            "CostOverflow" -> return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.CostOverflow
                            "InvalidChain" -> return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidChain
                            "Expired" -> return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.Expired
                            "InvalidTransactionVersion" -> return io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidTransactionVersion
                            else -> throw SerializationException("Unknown discriminator key for InvalidTxError: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("InvalidSignerId")
                    for (cand in discriminatorCandidates) {
                        val candElem = jobj[cand]
                        if (candElem is JsonPrimitive) {
                            typeField = candElem.contentOrNull
                            if (typeField != null) break
                        }
                    }
                    if (typeField == null) {
                        val knownVariantNames = setOf("InvalidAccessKeyError", "InvalidSignerId", "SignerDoesNotExist", "InvalidNonce", "NonceTooLarge", "InvalidReceiverId", "InvalidSignature", "NotEnoughBalance", "LackBalanceForState", "CostOverflow", "InvalidChain", "Expired", "ActionsValidation", "TransactionSizeExceeded", "InvalidTransactionVersion", "StorageError", "ShardCongested", "ShardStuck")
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
                            "InvalidAccessKeyError" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidAccessKeyError>(), jobj)
                            "InvalidSignerId" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidSignerId>(), jobj)
                            "SignerDoesNotExist" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.SignerDoesNotExist>(), jobj)
                            "InvalidNonce" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidNonce>(), jobj)
                            "NonceTooLarge" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NonceTooLarge>(), jobj)
                            "InvalidReceiverId" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidReceiverId>(), jobj)
                            "InvalidSignature" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidSignature>(), jobj)
                            "NotEnoughBalance" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NotEnoughBalance>(), jobj)
                            "LackBalanceForState" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.LackBalanceForState>(), jobj)
                            "CostOverflow" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.CostOverflow>(), jobj)
                            "InvalidChain" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidChain>(), jobj)
                            "Expired" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.Expired>(), jobj)
                            "ActionsValidation" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ActionsValidation>(), jobj)
                            "TransactionSizeExceeded" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.TransactionSizeExceeded>(), jobj)
                            "InvalidTransactionVersion" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidTransactionVersion>(), jobj)
                            "StorageError" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.StorageError>(), jobj)
                            "ShardCongested" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardCongested>(), jobj)
                            "ShardStuck" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardStuck>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("InvalidAccessKeyError".lowercase() == tfLower || tfLower.contains("InvalidAccessKeyError".lowercase()) || "InvalidAccessKeyError".lowercase().contains(tfLower))) { chosenGroupKey = "InvalidAccessKeyError" }
                        if (chosenGroupKey == null && ("InvalidSignerId".lowercase() == tfLower || tfLower.contains("InvalidSignerId".lowercase()) || "InvalidSignerId".lowercase().contains(tfLower))) { chosenGroupKey = "InvalidSignerId" }
                        if (chosenGroupKey == null && ("SignerDoesNotExist".lowercase() == tfLower || tfLower.contains("SignerDoesNotExist".lowercase()) || "SignerDoesNotExist".lowercase().contains(tfLower))) { chosenGroupKey = "SignerDoesNotExist" }
                        if (chosenGroupKey == null && ("InvalidNonce".lowercase() == tfLower || tfLower.contains("InvalidNonce".lowercase()) || "InvalidNonce".lowercase().contains(tfLower))) { chosenGroupKey = "InvalidNonce" }
                        if (chosenGroupKey == null && ("NonceTooLarge".lowercase() == tfLower || tfLower.contains("NonceTooLarge".lowercase()) || "NonceTooLarge".lowercase().contains(tfLower))) { chosenGroupKey = "NonceTooLarge" }
                        if (chosenGroupKey == null && ("InvalidReceiverId".lowercase() == tfLower || tfLower.contains("InvalidReceiverId".lowercase()) || "InvalidReceiverId".lowercase().contains(tfLower))) { chosenGroupKey = "InvalidReceiverId" }
                        if (chosenGroupKey == null && ("InvalidSignature".lowercase() == tfLower || tfLower.contains("InvalidSignature".lowercase()) || "InvalidSignature".lowercase().contains(tfLower))) { chosenGroupKey = "InvalidSignature" }
                        if (chosenGroupKey == null && ("NotEnoughBalance".lowercase() == tfLower || tfLower.contains("NotEnoughBalance".lowercase()) || "NotEnoughBalance".lowercase().contains(tfLower))) { chosenGroupKey = "NotEnoughBalance" }
                        if (chosenGroupKey == null && ("LackBalanceForState".lowercase() == tfLower || tfLower.contains("LackBalanceForState".lowercase()) || "LackBalanceForState".lowercase().contains(tfLower))) { chosenGroupKey = "LackBalanceForState" }
                        if (chosenGroupKey == null && ("CostOverflow".lowercase() == tfLower || tfLower.contains("CostOverflow".lowercase()) || "CostOverflow".lowercase().contains(tfLower))) { chosenGroupKey = "CostOverflow" }
                        if (chosenGroupKey == null && ("InvalidChain".lowercase() == tfLower || tfLower.contains("InvalidChain".lowercase()) || "InvalidChain".lowercase().contains(tfLower))) { chosenGroupKey = "InvalidChain" }
                        if (chosenGroupKey == null && ("Expired".lowercase() == tfLower || tfLower.contains("Expired".lowercase()) || "Expired".lowercase().contains(tfLower))) { chosenGroupKey = "Expired" }
                        if (chosenGroupKey == null && ("ActionsValidation".lowercase() == tfLower || tfLower.contains("ActionsValidation".lowercase()) || "ActionsValidation".lowercase().contains(tfLower))) { chosenGroupKey = "ActionsValidation" }
                        if (chosenGroupKey == null && ("TransactionSizeExceeded".lowercase() == tfLower || tfLower.contains("TransactionSizeExceeded".lowercase()) || "TransactionSizeExceeded".lowercase().contains(tfLower))) { chosenGroupKey = "TransactionSizeExceeded" }
                        if (chosenGroupKey == null && ("InvalidTransactionVersion".lowercase() == tfLower || tfLower.contains("InvalidTransactionVersion".lowercase()) || "InvalidTransactionVersion".lowercase().contains(tfLower))) { chosenGroupKey = "InvalidTransactionVersion" }
                        if (chosenGroupKey == null && ("StorageError".lowercase() == tfLower || tfLower.contains("StorageError".lowercase()) || "StorageError".lowercase().contains(tfLower))) { chosenGroupKey = "StorageError" }
                        if (chosenGroupKey == null && ("ShardCongested".lowercase() == tfLower || tfLower.contains("ShardCongested".lowercase()) || "ShardCongested".lowercase().contains(tfLower))) { chosenGroupKey = "ShardCongested" }
                        if (chosenGroupKey == null && ("ShardStuck".lowercase() == tfLower || tfLower.contains("ShardStuck".lowercase()) || "ShardStuck".lowercase().contains(tfLower))) { chosenGroupKey = "ShardStuck" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "InvalidAccessKeyError" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidAccessKeyError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InvalidAccessKeyError' and tf='$tf'")
                                }
                                "InvalidSignerId" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidSignerId>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InvalidSignerId' and tf='$tf'")
                                }
                                "SignerDoesNotExist" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.SignerDoesNotExist>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'SignerDoesNotExist' and tf='$tf'")
                                }
                                "InvalidNonce" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidNonce>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InvalidNonce' and tf='$tf'")
                                }
                                "NonceTooLarge" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NonceTooLarge>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'NonceTooLarge' and tf='$tf'")
                                }
                                "InvalidReceiverId" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidReceiverId>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InvalidReceiverId' and tf='$tf'")
                                }
                                "InvalidSignature" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidSignature>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InvalidSignature' and tf='$tf'")
                                }
                                "NotEnoughBalance" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NotEnoughBalance>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'NotEnoughBalance' and tf='$tf'")
                                }
                                "LackBalanceForState" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.LackBalanceForState>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'LackBalanceForState' and tf='$tf'")
                                }
                                "CostOverflow" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.CostOverflow>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'CostOverflow' and tf='$tf'")
                                }
                                "InvalidChain" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidChain>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InvalidChain' and tf='$tf'")
                                }
                                "Expired" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.Expired>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'Expired' and tf='$tf'")
                                }
                                "ActionsValidation" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ActionsValidation>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'ActionsValidation' and tf='$tf'")
                                }
                                "TransactionSizeExceeded" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.TransactionSizeExceeded>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'TransactionSizeExceeded' and tf='$tf'")
                                }
                                "InvalidTransactionVersion" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidTransactionVersion>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InvalidTransactionVersion' and tf='$tf'")
                                }
                                "StorageError" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.StorageError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'StorageError' and tf='$tf'")
                                }
                                "ShardCongested" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardCongested>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'ShardCongested' and tf='$tf'")
                                }
                                "ShardStuck" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardStuck>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'ShardStuck' and tf='$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: InvalidAccessKeyError
                    // group: InvalidSignerId
                    // group: SignerDoesNotExist
                    // group: InvalidNonce
                    // group: NonceTooLarge
                    // group: InvalidReceiverId
                    // group: InvalidSignature
                    // group: NotEnoughBalance
                    // group: LackBalanceForState
                    // group: CostOverflow
                    // group: InvalidChain
                    // group: Expired
                    // group: ActionsValidation
                    // group: TransactionSizeExceeded
                    // group: InvalidTransactionVersion
                    // group: StorageError
                    // group: ShardCongested
                    // group: ShardStuck

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("InvalidAccessKeyError")) requiredMatches.add(0)
                    if (jobj.containsKey("InvalidSignerId")) requiredMatches.add(1)
                    if (jobj.containsKey("SignerDoesNotExist")) requiredMatches.add(2)
                    if (jobj.containsKey("InvalidNonce")) requiredMatches.add(3)
                    if (jobj.containsKey("NonceTooLarge")) requiredMatches.add(4)
                    if (jobj.containsKey("InvalidReceiverId")) requiredMatches.add(5)
                    if (jobj.containsKey("NotEnoughBalance")) requiredMatches.add(7)
                    if (jobj.containsKey("LackBalanceForState")) requiredMatches.add(8)
                    if (jobj.containsKey("ActionsValidation")) requiredMatches.add(12)
                    if (jobj.containsKey("TransactionSizeExceeded")) requiredMatches.add(13)
                    if (jobj.containsKey("StorageError")) requiredMatches.add(15)
                    if (jobj.containsKey("ShardCongested")) requiredMatches.add(16)
                    if (jobj.containsKey("ShardStuck")) requiredMatches.add(17)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidAccessKeyError>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidSignerId>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.SignerDoesNotExist>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidNonce>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NonceTooLarge>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidReceiverId>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidSignature>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NotEnoughBalance>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.LackBalanceForState>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.CostOverflow>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidChain>(), jobj)
                            11 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.Expired>(), jobj)
                            12 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ActionsValidation>(), jobj)
                            13 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.TransactionSizeExceeded>(), jobj)
                            14 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidTransactionVersion>(), jobj)
                            15 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.StorageError>(), jobj)
                            16 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardCongested>(), jobj)
                            17 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardStuck>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["InvalidAccessKeyError"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["InvalidSignerId"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["SignerDoesNotExist"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["InvalidNonce"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 3 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["NonceTooLarge"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 4 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["InvalidReceiverId"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 5 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 6 }
                    run {
                        var matchCount = 0
                        if (jobj["NotEnoughBalance"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 7 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["LackBalanceForState"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 8 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 9 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 10 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 11 }
                    run {
                        var matchCount = 0
                        if (jobj["ActionsValidation"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 12 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["TransactionSizeExceeded"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 13 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 14 }
                    run {
                        var matchCount = 0
                        if (jobj["StorageError"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 15 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["ShardCongested"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 16 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["ShardStuck"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 17 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidAccessKeyError>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidSignerId>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.SignerDoesNotExist>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidNonce>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NonceTooLarge>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidReceiverId>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidSignature>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NotEnoughBalance>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.LackBalanceForState>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.CostOverflow>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidChain>(), jobj)
                            11 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.Expired>(), jobj)
                            12 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ActionsValidation>(), jobj)
                            13 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.TransactionSizeExceeded>(), jobj)
                            14 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidTransactionVersion>(), jobj)
                            15 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.StorageError>(), jobj)
                            16 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardCongested>(), jobj)
                            17 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardStuck>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidAccessKeyError>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidSignerId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.SignerDoesNotExist>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidNonce>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NonceTooLarge>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.InvalidReceiverId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.NotEnoughBalance>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.LackBalanceForState>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ActionsValidation>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.TransactionSizeExceeded>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.StorageError>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardCongested>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.ShardStuck>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in InvalidTxError")
                }
            }
        }
        throw SerializationException("Cannot deserialize InvalidTxError with non-JSON decoder")
    }
}
