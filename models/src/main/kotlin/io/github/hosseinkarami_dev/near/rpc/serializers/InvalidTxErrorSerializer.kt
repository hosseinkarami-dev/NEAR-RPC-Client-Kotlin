package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError
import io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError
import io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError
import io.github.hosseinkarami_dev.near.rpc.models.StorageError
import kotlin.collections.mutableMapOf
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
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
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.serializer

public object InvalidTxErrorSerializer : KSerializer<InvalidTxError> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError") {
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

  override fun serialize(encoder: Encoder, `value`: InvalidTxError) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is InvalidTxError.InvalidAccessKeyError -> {
          val map = mutableMapOf<String, JsonElement>()
          map["InvalidAccessKeyError"] = jsonEncoder.json.encodeToJsonElement(serializer<InvalidAccessKeyError>(), value.invalidAccessKeyError)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is InvalidTxError.InvalidSignerId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["InvalidSignerId"] = jsonEncoder.json.encodeToJsonElement(serializer<InvalidTxError.InvalidSignerId.InvalidSignerIdPayload>(), value.invalidSignerId)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is InvalidTxError.SignerDoesNotExist -> {
          val map = mutableMapOf<String, JsonElement>()
          map["SignerDoesNotExist"] = jsonEncoder.json.encodeToJsonElement(serializer<InvalidTxError.SignerDoesNotExist.SignerDoesNotExistPayload>(), value.signerDoesNotExist)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is InvalidTxError.InvalidNonce -> {
          val map = mutableMapOf<String, JsonElement>()
          map["InvalidNonce"] = jsonEncoder.json.encodeToJsonElement(serializer<InvalidTxError.InvalidNonce.InvalidNoncePayload>(), value.invalidNonce)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is InvalidTxError.NonceTooLarge -> {
          val map = mutableMapOf<String, JsonElement>()
          map["NonceTooLarge"] = jsonEncoder.json.encodeToJsonElement(serializer<InvalidTxError.NonceTooLarge.NonceTooLargePayload>(), value.nonceTooLarge)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is InvalidTxError.InvalidReceiverId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["InvalidReceiverId"] = jsonEncoder.json.encodeToJsonElement(serializer<InvalidTxError.InvalidReceiverId.InvalidReceiverIdPayload>(), value.invalidReceiverId)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is InvalidTxError.InvalidSignature -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("InvalidSignature"))
        }
        is InvalidTxError.NotEnoughBalance -> {
          val map = mutableMapOf<String, JsonElement>()
          map["NotEnoughBalance"] = jsonEncoder.json.encodeToJsonElement(serializer<InvalidTxError.NotEnoughBalance.NotEnoughBalancePayload>(), value.notEnoughBalance)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is InvalidTxError.LackBalanceForState -> {
          val map = mutableMapOf<String, JsonElement>()
          map["LackBalanceForState"] = jsonEncoder.json.encodeToJsonElement(serializer<InvalidTxError.LackBalanceForState.LackBalanceForStatePayload>(), value.lackBalanceForState)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is InvalidTxError.CostOverflow -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("CostOverflow"))
        }
        is InvalidTxError.InvalidChain -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("InvalidChain"))
        }
        is InvalidTxError.Expired -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("Expired"))
        }
        is InvalidTxError.ActionsValidation -> {
          val map = mutableMapOf<String, JsonElement>()
          map["ActionsValidation"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionsValidationError>(), value.actionsValidation)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is InvalidTxError.TransactionSizeExceeded -> {
          val map = mutableMapOf<String, JsonElement>()
          map["TransactionSizeExceeded"] = jsonEncoder.json.encodeToJsonElement(serializer<InvalidTxError.TransactionSizeExceeded.TransactionSizeExceededPayload>(), value.transactionSizeExceeded)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is InvalidTxError.InvalidTransactionVersion -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("InvalidTransactionVersion"))
        }
        is InvalidTxError.StorageError -> {
          val map = mutableMapOf<String, JsonElement>()
          map["StorageError"] = jsonEncoder.json.encodeToJsonElement(serializer<StorageError>(), value.storageError)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is InvalidTxError.ShardCongested -> {
          val map = mutableMapOf<String, JsonElement>()
          map["ShardCongested"] = jsonEncoder.json.encodeToJsonElement(serializer<InvalidTxError.ShardCongested.ShardCongestedPayload>(), value.shardCongested)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is InvalidTxError.ShardStuck -> {
          val map = mutableMapOf<String, JsonElement>()
          map["ShardStuck"] = jsonEncoder.json.encodeToJsonElement(serializer<InvalidTxError.ShardStuck.ShardStuckPayload>(), value.shardStuck)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is InvalidTxError.InvalidAccessKeyError -> out.encodeSerializableElement(descriptor, 0, serializer<InvalidTxError.InvalidAccessKeyError>(), value)
      is InvalidTxError.InvalidSignerId -> out.encodeSerializableElement(descriptor, 1, serializer<InvalidTxError.InvalidSignerId>(), value)
      is InvalidTxError.SignerDoesNotExist -> out.encodeSerializableElement(descriptor, 2, serializer<InvalidTxError.SignerDoesNotExist>(), value)
      is InvalidTxError.InvalidNonce -> out.encodeSerializableElement(descriptor, 3, serializer<InvalidTxError.InvalidNonce>(), value)
      is InvalidTxError.NonceTooLarge -> out.encodeSerializableElement(descriptor, 4, serializer<InvalidTxError.NonceTooLarge>(), value)
      is InvalidTxError.InvalidReceiverId -> out.encodeSerializableElement(descriptor, 5, serializer<InvalidTxError.InvalidReceiverId>(), value)
      is InvalidTxError.InvalidSignature -> out.encodeSerializableElement(descriptor, 6, serializer<InvalidTxError.InvalidSignature>(), value)
      is InvalidTxError.NotEnoughBalance -> out.encodeSerializableElement(descriptor, 7, serializer<InvalidTxError.NotEnoughBalance>(), value)
      is InvalidTxError.LackBalanceForState -> out.encodeSerializableElement(descriptor, 8, serializer<InvalidTxError.LackBalanceForState>(), value)
      is InvalidTxError.CostOverflow -> out.encodeSerializableElement(descriptor, 9, serializer<InvalidTxError.CostOverflow>(), value)
      is InvalidTxError.InvalidChain -> out.encodeSerializableElement(descriptor, 10, serializer<InvalidTxError.InvalidChain>(), value)
      is InvalidTxError.Expired -> out.encodeSerializableElement(descriptor, 11, serializer<InvalidTxError.Expired>(), value)
      is InvalidTxError.ActionsValidation -> out.encodeSerializableElement(descriptor, 12, serializer<InvalidTxError.ActionsValidation>(), value)
      is InvalidTxError.TransactionSizeExceeded -> out.encodeSerializableElement(descriptor, 13, serializer<InvalidTxError.TransactionSizeExceeded>(), value)
      is InvalidTxError.InvalidTransactionVersion -> out.encodeSerializableElement(descriptor, 14, serializer<InvalidTxError.InvalidTransactionVersion>(), value)
      is InvalidTxError.StorageError -> out.encodeSerializableElement(descriptor, 15, serializer<InvalidTxError.StorageError>(), value)
      is InvalidTxError.ShardCongested -> out.encodeSerializableElement(descriptor, 16, serializer<InvalidTxError.ShardCongested>(), value)
      is InvalidTxError.ShardStuck -> out.encodeSerializableElement(descriptor, 17, serializer<InvalidTxError.ShardStuck>(), value)
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
            if (s == "InvalidSignature") return InvalidTxError.InvalidSignature
            if (s == "CostOverflow") return InvalidTxError.CostOverflow
            if (s == "InvalidChain") return InvalidTxError.InvalidChain
            if (s == "Expired") return InvalidTxError.Expired
            if (s == "InvalidTransactionVersion") return InvalidTxError.InvalidTransactionVersion
          }
          throw SerializationException("Unknown discriminator (primitive) for InvalidTxError")
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing InvalidTxError")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj["InvalidAccessKeyError"] != null) {
            return InvalidTxError.InvalidAccessKeyError(decoder.json.decodeFromJsonElement(serializer<InvalidAccessKeyError>(), jobj["InvalidAccessKeyError"]!!))
          }
          if (jobj["InvalidSignerId"] != null) {
            return InvalidTxError.InvalidSignerId(decoder.json.decodeFromJsonElement(serializer<InvalidTxError.InvalidSignerId.InvalidSignerIdPayload>(), jobj["InvalidSignerId"]!!))
          }
          if (jobj["SignerDoesNotExist"] != null) {
            return InvalidTxError.SignerDoesNotExist(decoder.json.decodeFromJsonElement(serializer<InvalidTxError.SignerDoesNotExist.SignerDoesNotExistPayload>(), jobj["SignerDoesNotExist"]!!))
          }
          if (jobj["InvalidNonce"] != null) {
            return InvalidTxError.InvalidNonce(decoder.json.decodeFromJsonElement(serializer<InvalidTxError.InvalidNonce.InvalidNoncePayload>(), jobj["InvalidNonce"]!!))
          }
          if (jobj["NonceTooLarge"] != null) {
            return InvalidTxError.NonceTooLarge(decoder.json.decodeFromJsonElement(serializer<InvalidTxError.NonceTooLarge.NonceTooLargePayload>(), jobj["NonceTooLarge"]!!))
          }
          if (jobj["InvalidReceiverId"] != null) {
            return InvalidTxError.InvalidReceiverId(decoder.json.decodeFromJsonElement(serializer<InvalidTxError.InvalidReceiverId.InvalidReceiverIdPayload>(), jobj["InvalidReceiverId"]!!))
          }
          if (jobj["NotEnoughBalance"] != null) {
            return InvalidTxError.NotEnoughBalance(decoder.json.decodeFromJsonElement(serializer<InvalidTxError.NotEnoughBalance.NotEnoughBalancePayload>(), jobj["NotEnoughBalance"]!!))
          }
          if (jobj["LackBalanceForState"] != null) {
            return InvalidTxError.LackBalanceForState(decoder.json.decodeFromJsonElement(serializer<InvalidTxError.LackBalanceForState.LackBalanceForStatePayload>(), jobj["LackBalanceForState"]!!))
          }
          if (jobj["ActionsValidation"] != null) {
            return InvalidTxError.ActionsValidation(decoder.json.decodeFromJsonElement(serializer<ActionsValidationError>(), jobj["ActionsValidation"]!!))
          }
          if (jobj["TransactionSizeExceeded"] != null) {
            return InvalidTxError.TransactionSizeExceeded(decoder.json.decodeFromJsonElement(serializer<InvalidTxError.TransactionSizeExceeded.TransactionSizeExceededPayload>(), jobj["TransactionSizeExceeded"]!!))
          }
          if (jobj["StorageError"] != null) {
            return InvalidTxError.StorageError(decoder.json.decodeFromJsonElement(serializer<StorageError>(), jobj["StorageError"]!!))
          }
          if (jobj["ShardCongested"] != null) {
            return InvalidTxError.ShardCongested(decoder.json.decodeFromJsonElement(serializer<InvalidTxError.ShardCongested.ShardCongestedPayload>(), jobj["ShardCongested"]!!))
          }
          if (jobj["ShardStuck"] != null) {
            return InvalidTxError.ShardStuck(decoder.json.decodeFromJsonElement(serializer<InvalidTxError.ShardStuck.ShardStuckPayload>(), jobj["ShardStuck"]!!))
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "InvalidAccessKeyError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.InvalidAccessKeyError>(), obj)
              }
              "InvalidSignerId" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.InvalidSignerId>(), obj)
              }
              "SignerDoesNotExist" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.SignerDoesNotExist>(), obj)
              }
              "InvalidNonce" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.InvalidNonce>(), obj)
              }
              "NonceTooLarge" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.NonceTooLarge>(), obj)
              }
              "InvalidReceiverId" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.InvalidReceiverId>(), obj)
              }
              "NotEnoughBalance" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.NotEnoughBalance>(), obj)
              }
              "LackBalanceForState" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.LackBalanceForState>(), obj)
              }
              "ActionsValidation" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.ActionsValidation>(), obj)
              }
              "TransactionSizeExceeded" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.TransactionSizeExceeded>(), obj)
              }
              "StorageError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.StorageError>(), obj)
              }
              "ShardCongested" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.ShardCongested>(), obj)
              }
              "ShardStuck" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.ShardStuck>(), obj)
              }
              "InvalidSignature" -> {
                return InvalidTxError.InvalidSignature
              }
              "CostOverflow" -> {
                return InvalidTxError.CostOverflow
              }
              "InvalidChain" -> {
                return InvalidTxError.InvalidChain
              }
              "Expired" -> {
                return InvalidTxError.Expired
              }
              "InvalidTransactionVersion" -> {
                return InvalidTxError.InvalidTransactionVersion
              }
              else -> throw SerializationException("Unknown discriminator key for InvalidTxError: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("InvalidAccessKeyError", "InvalidSignerId", "SignerDoesNotExist", "InvalidNonce", "NonceTooLarge", "InvalidReceiverId", "InvalidSignature", "NotEnoughBalance", "LackBalanceForState", "CostOverflow", "InvalidChain", "Expired", "ActionsValidation", "TransactionSizeExceeded", "InvalidTransactionVersion", "StorageError", "ShardCongested", "ShardStuck")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in InvalidTxError")
            val tf = typeField.trim()
            when (tf) {
              "InvalidAccessKeyError" -> {
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.InvalidAccessKeyError>(), jobj)
              }
              "InvalidSignerId" -> {
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.InvalidSignerId>(), jobj)
              }
              "SignerDoesNotExist" -> {
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.SignerDoesNotExist>(), jobj)
              }
              "InvalidNonce" -> {
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.InvalidNonce>(), jobj)
              }
              "NonceTooLarge" -> {
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.NonceTooLarge>(), jobj)
              }
              "InvalidReceiverId" -> {
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.InvalidReceiverId>(), jobj)
              }
              "NotEnoughBalance" -> {
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.NotEnoughBalance>(), jobj)
              }
              "LackBalanceForState" -> {
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.LackBalanceForState>(), jobj)
              }
              "ActionsValidation" -> {
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.ActionsValidation>(), jobj)
              }
              "TransactionSizeExceeded" -> {
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.TransactionSizeExceeded>(), jobj)
              }
              "StorageError" -> {
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.StorageError>(), jobj)
              }
              "ShardCongested" -> {
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.ShardCongested>(), jobj)
              }
              "ShardStuck" -> {
                return decoder.json.decodeFromJsonElement(serializer<InvalidTxError.ShardStuck>(), jobj)
              }
              "InvalidSignature" -> return InvalidTxError.InvalidSignature
              "CostOverflow" -> return InvalidTxError.CostOverflow
              "InvalidChain" -> return InvalidTxError.InvalidChain
              "Expired" -> return InvalidTxError.Expired
              "InvalidTransactionVersion" -> return InvalidTxError.InvalidTransactionVersion
              else -> throw SerializationException("Unknown type discriminator for InvalidTxError: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize InvalidTxError with non-JSON decoder")
  }
}
