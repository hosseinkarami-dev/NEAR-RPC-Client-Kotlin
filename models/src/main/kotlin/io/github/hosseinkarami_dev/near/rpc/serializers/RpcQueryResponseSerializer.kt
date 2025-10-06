package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.AccessKeyInfoView
import io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView
import io.github.hosseinkarami_dev.near.rpc.models.AccountId
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.NearToken
import io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse
import io.github.hosseinkarami_dev.near.rpc.models.StateItem
import kotlin.String
import kotlin.UByte
import kotlin.ULong
import kotlin.collections.List
import kotlin.collections.mutableMapOf
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
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

public object RpcQueryResponseSerializer : KSerializer<RpcQueryResponse> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse")

  override fun serialize(encoder: Encoder, `value`: RpcQueryResponse) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is RpcQueryResponse.AccountView -> {
          val map = mutableMapOf<String, JsonElement>()
          map["amount"] = jsonEncoder.json.encodeToJsonElement(serializer<NearToken>(), value.amount)
          map["code_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.codeHash)
          if (value.globalContractAccountId != null) {
            map["global_contract_account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId?>(), value.globalContractAccountId)
          }
          if (value.globalContractHash != null) {
            map["global_contract_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash?>(), value.globalContractHash)
          }
          map["locked"] = jsonEncoder.json.encodeToJsonElement(serializer<NearToken>(), value.locked)
          if (value.storagePaidAt != null) {
            map["storage_paid_at"] = jsonEncoder.json.encodeToJsonElement(serializer<ULong?>(), value.storagePaidAt)
          }
          map["storage_usage"] = jsonEncoder.json.encodeToJsonElement(serializer<ULong>(), value.storageUsage)
          map["block_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.blockHash)
          map["block_height"] = jsonEncoder.json.encodeToJsonElement(serializer<ULong>(), value.blockHeight)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryResponse.ContractCodeView -> {
          val map = mutableMapOf<String, JsonElement>()
          map["code_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<String>(), value.codeBase64)
          map["hash"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.hash)
          map["block_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.blockHash)
          map["block_height"] = jsonEncoder.json.encodeToJsonElement(serializer<ULong>(), value.blockHeight)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryResponse.ViewStateResult -> {
          val map = mutableMapOf<String, JsonElement>()
          if (value.proof != null) {
            map["proof"] = jsonEncoder.json.encodeToJsonElement(serializer<List<String>?>(), value.proof)
          }
          map["values"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<StateItem>()), value.values)
          map["block_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.blockHash)
          map["block_height"] = jsonEncoder.json.encodeToJsonElement(serializer<ULong>(), value.blockHeight)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryResponse.CallResult -> {
          val map = mutableMapOf<String, JsonElement>()
          map["logs"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<String>()), value.logs)
          map["result"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<UByte>()), value.result)
          map["block_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.blockHash)
          map["block_height"] = jsonEncoder.json.encodeToJsonElement(serializer<ULong>(), value.blockHeight)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryResponse.AccessKeyView -> {
          val map = mutableMapOf<String, JsonElement>()
          map["nonce"] = jsonEncoder.json.encodeToJsonElement(serializer<ULong>(), value.nonce)
          map["permission"] = jsonEncoder.json.encodeToJsonElement(serializer<AccessKeyPermissionView>(), value.permission)
          map["block_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.blockHash)
          map["block_height"] = jsonEncoder.json.encodeToJsonElement(serializer<ULong>(), value.blockHeight)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryResponse.AccessKeyList -> {
          val map = mutableMapOf<String, JsonElement>()
          map["keys"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccessKeyInfoView>()), value.keys)
          map["block_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.blockHash)
          map["block_height"] = jsonEncoder.json.encodeToJsonElement(serializer<ULong>(), value.blockHeight)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is RpcQueryResponse.AccountView -> out.encodeSerializableElement(descriptor, 0, serializer<NearToken>(), value.amount)
      is RpcQueryResponse.ContractCodeView -> out.encodeSerializableElement(descriptor, 1, serializer<String>(), value.codeBase64)
      is RpcQueryResponse.ViewStateResult -> out.encodeSerializableElement(descriptor, 2, serializer<List<String>?>(), value.proof)
      is RpcQueryResponse.CallResult -> out.encodeSerializableElement(descriptor, 3, ListSerializer(serializer<String>()), value.logs)
      is RpcQueryResponse.AccessKeyView -> out.encodeSerializableElement(descriptor, 4, serializer<ULong>(), value.nonce)
      is RpcQueryResponse.AccessKeyList -> out.encodeSerializableElement(descriptor, 5, ListSerializer(serializer<AccessKeyInfoView>()), value.keys)
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
            throw SerializationException("Unknown discriminator string for RpcQueryResponse: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing RpcQueryResponse")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["amount"] != null) {
            val amountVal = decoder.json.decodeFromJsonElement(serializer<NearToken>(), jobj["amount"] ?: throw SerializationException("Missing field 'amount' for variant " + "AccountView"))
            val codeHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), jobj["code_hash"] ?: throw SerializationException("Missing field 'code_hash' for variant " + "AccountView"))
            val globalContractAccountIdVal = jobj["global_contract_account_id"]?.let { decoder.json.decodeFromJsonElement(serializer<AccountId?>(), it) }
            val globalContractHashVal = jobj["global_contract_hash"]?.let { decoder.json.decodeFromJsonElement(serializer<CryptoHash?>(), it) }
            val lockedVal = decoder.json.decodeFromJsonElement(serializer<NearToken>(), jobj["locked"] ?: throw SerializationException("Missing field 'locked' for variant " + "AccountView"))
            val storagePaidAtVal = jobj["storage_paid_at"]?.let { decoder.json.decodeFromJsonElement(serializer<ULong?>(), it) }
            val storageUsageVal = decoder.json.decodeFromJsonElement(serializer<ULong>(), jobj["storage_usage"] ?: throw SerializationException("Missing field 'storage_usage' for variant " + "AccountView"))
            val blockHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), jobj["block_hash"] ?: throw SerializationException("Missing field 'block_hash' for variant " + "AccountView"))
            val blockHeightVal = decoder.json.decodeFromJsonElement(serializer<ULong>(), jobj["block_height"] ?: throw SerializationException("Missing field 'block_height' for variant " + "AccountView"))
            return RpcQueryResponse.AccountView(amountVal, codeHashVal, globalContractAccountIdVal, globalContractHashVal, lockedVal, storagePaidAtVal, storageUsageVal, blockHashVal, blockHeightVal)
          }
          if (jobj["code_base64"] != null) {
            val codeBase64Val = decoder.json.decodeFromJsonElement(serializer<String>(), jobj["code_base64"] ?: throw SerializationException("Missing field 'code_base64' for variant " + "ContractCodeView"))
            val hashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), jobj["hash"] ?: throw SerializationException("Missing field 'hash' for variant " + "ContractCodeView"))
            val blockHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), jobj["block_hash"] ?: throw SerializationException("Missing field 'block_hash' for variant " + "ContractCodeView"))
            val blockHeightVal = decoder.json.decodeFromJsonElement(serializer<ULong>(), jobj["block_height"] ?: throw SerializationException("Missing field 'block_height' for variant " + "ContractCodeView"))
            return RpcQueryResponse.ContractCodeView(codeBase64Val, hashVal, blockHashVal, blockHeightVal)
          }
          if (jobj["proof"] != null) {
            val proofVal = jobj["proof"]?.let { decoder.json.decodeFromJsonElement(serializer<List<String>?>(), it) }
            val valuesVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<StateItem>()), jobj["values"] ?: throw SerializationException("Missing field 'values' for variant " + "ViewStateResult"))
            val blockHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), jobj["block_hash"] ?: throw SerializationException("Missing field 'block_hash' for variant " + "ViewStateResult"))
            val blockHeightVal = decoder.json.decodeFromJsonElement(serializer<ULong>(), jobj["block_height"] ?: throw SerializationException("Missing field 'block_height' for variant " + "ViewStateResult"))
            return RpcQueryResponse.ViewStateResult(proofVal, valuesVal, blockHashVal, blockHeightVal)
          }
          if (jobj["logs"] != null) {
            val logsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<String>()), jobj["logs"] ?: throw SerializationException("Missing field 'logs' for variant " + "CallResult"))
            val resultVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<UByte>()), jobj["result"] ?: throw SerializationException("Missing field 'result' for variant " + "CallResult"))
            val blockHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), jobj["block_hash"] ?: throw SerializationException("Missing field 'block_hash' for variant " + "CallResult"))
            val blockHeightVal = decoder.json.decodeFromJsonElement(serializer<ULong>(), jobj["block_height"] ?: throw SerializationException("Missing field 'block_height' for variant " + "CallResult"))
            return RpcQueryResponse.CallResult(logsVal, resultVal, blockHashVal, blockHeightVal)
          }
          if (jobj["nonce"] != null) {
            val nonceVal = decoder.json.decodeFromJsonElement(serializer<ULong>(), jobj["nonce"] ?: throw SerializationException("Missing field 'nonce' for variant " + "AccessKeyView"))
            val permissionVal = decoder.json.decodeFromJsonElement(serializer<AccessKeyPermissionView>(), jobj["permission"] ?: throw SerializationException("Missing field 'permission' for variant " + "AccessKeyView"))
            val blockHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), jobj["block_hash"] ?: throw SerializationException("Missing field 'block_hash' for variant " + "AccessKeyView"))
            val blockHeightVal = decoder.json.decodeFromJsonElement(serializer<ULong>(), jobj["block_height"] ?: throw SerializationException("Missing field 'block_height' for variant " + "AccessKeyView"))
            return RpcQueryResponse.AccessKeyView(nonceVal, permissionVal, blockHashVal, blockHeightVal)
          }
          if (jobj["keys"] != null) {
            val keysVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccessKeyInfoView>()), jobj["keys"] ?: throw SerializationException("Missing field 'keys' for variant " + "AccessKeyList"))
            val blockHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), jobj["block_hash"] ?: throw SerializationException("Missing field 'block_hash' for variant " + "AccessKeyList"))
            val blockHeightVal = decoder.json.decodeFromJsonElement(serializer<ULong>(), jobj["block_height"] ?: throw SerializationException("Missing field 'block_height' for variant " + "AccessKeyList"))
            return RpcQueryResponse.AccessKeyList(keysVal, blockHashVal, blockHeightVal)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "AccountView" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val amountVal = decoder.json.decodeFromJsonElement(serializer<NearToken>(), obj["amount"] ?: throw SerializationException("Missing field 'amount' for variant " + key))
                val codeHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), obj["code_hash"] ?: throw SerializationException("Missing field 'code_hash' for variant " + key))
                val globalContractAccountIdVal = obj["global_contract_account_id"]?.let { decoder.json.decodeFromJsonElement(serializer<AccountId?>(), it) }
                val globalContractHashVal = obj["global_contract_hash"]?.let { decoder.json.decodeFromJsonElement(serializer<CryptoHash?>(), it) }
                val lockedVal = decoder.json.decodeFromJsonElement(serializer<NearToken>(), obj["locked"] ?: throw SerializationException("Missing field 'locked' for variant " + key))
                val storagePaidAtVal = obj["storage_paid_at"]?.let { decoder.json.decodeFromJsonElement(serializer<ULong?>(), it) }
                val storageUsageVal = decoder.json.decodeFromJsonElement(serializer<ULong>(), obj["storage_usage"] ?: throw SerializationException("Missing field 'storage_usage' for variant " + key))
                val blockHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), obj["block_hash"] ?: throw SerializationException("Missing field 'block_hash' for variant " + key))
                val blockHeightVal = decoder.json.decodeFromJsonElement(serializer<ULong>(), obj["block_height"] ?: throw SerializationException("Missing field 'block_height' for variant " + key))
                return RpcQueryResponse.AccountView(amountVal, codeHashVal, globalContractAccountIdVal, globalContractHashVal, lockedVal, storagePaidAtVal, storageUsageVal, blockHashVal, blockHeightVal)
              }
              "ContractCodeView" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val codeBase64Val = decoder.json.decodeFromJsonElement(serializer<String>(), obj["code_base64"] ?: throw SerializationException("Missing field 'code_base64' for variant " + key))
                val hashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), obj["hash"] ?: throw SerializationException("Missing field 'hash' for variant " + key))
                val blockHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), obj["block_hash"] ?: throw SerializationException("Missing field 'block_hash' for variant " + key))
                val blockHeightVal = decoder.json.decodeFromJsonElement(serializer<ULong>(), obj["block_height"] ?: throw SerializationException("Missing field 'block_height' for variant " + key))
                return RpcQueryResponse.ContractCodeView(codeBase64Val, hashVal, blockHashVal, blockHeightVal)
              }
              "ViewStateResult" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val proofVal = obj["proof"]?.let { decoder.json.decodeFromJsonElement(serializer<List<String>?>(), it) }
                val valuesVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<StateItem>()), obj["values"] ?: throw SerializationException("Missing field 'values' for variant " + key))
                val blockHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), obj["block_hash"] ?: throw SerializationException("Missing field 'block_hash' for variant " + key))
                val blockHeightVal = decoder.json.decodeFromJsonElement(serializer<ULong>(), obj["block_height"] ?: throw SerializationException("Missing field 'block_height' for variant " + key))
                return RpcQueryResponse.ViewStateResult(proofVal, valuesVal, blockHashVal, blockHeightVal)
              }
              "CallResult" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val logsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<String>()), obj["logs"] ?: throw SerializationException("Missing field 'logs' for variant " + key))
                val resultVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<UByte>()), obj["result"] ?: throw SerializationException("Missing field 'result' for variant " + key))
                val blockHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), obj["block_hash"] ?: throw SerializationException("Missing field 'block_hash' for variant " + key))
                val blockHeightVal = decoder.json.decodeFromJsonElement(serializer<ULong>(), obj["block_height"] ?: throw SerializationException("Missing field 'block_height' for variant " + key))
                return RpcQueryResponse.CallResult(logsVal, resultVal, blockHashVal, blockHeightVal)
              }
              "AccessKeyView" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val nonceVal = decoder.json.decodeFromJsonElement(serializer<ULong>(), obj["nonce"] ?: throw SerializationException("Missing field 'nonce' for variant " + key))
                val permissionVal = decoder.json.decodeFromJsonElement(serializer<AccessKeyPermissionView>(), obj["permission"] ?: throw SerializationException("Missing field 'permission' for variant " + key))
                val blockHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), obj["block_hash"] ?: throw SerializationException("Missing field 'block_hash' for variant " + key))
                val blockHeightVal = decoder.json.decodeFromJsonElement(serializer<ULong>(), obj["block_height"] ?: throw SerializationException("Missing field 'block_height' for variant " + key))
                return RpcQueryResponse.AccessKeyView(nonceVal, permissionVal, blockHashVal, blockHeightVal)
              }
              "AccessKeyList" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val keysVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccessKeyInfoView>()), obj["keys"] ?: throw SerializationException("Missing field 'keys' for variant " + key))
                val blockHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), obj["block_hash"] ?: throw SerializationException("Missing field 'block_hash' for variant " + key))
                val blockHeightVal = decoder.json.decodeFromJsonElement(serializer<ULong>(), obj["block_height"] ?: throw SerializationException("Missing field 'block_height' for variant " + key))
                return RpcQueryResponse.AccessKeyList(keysVal, blockHashVal, blockHeightVal)
              }
              else -> throw SerializationException("Unknown discriminator key for RpcQueryResponse: " + key)
            }
          }
          else {
            val typeField = jobj["type"]?.jsonPrimitive?.contentOrNull ?: throw SerializationException("Missing 'type' discriminator in RpcQueryResponse")
            when (typeField) {
              "AccountView" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryResponse.AccountView>(), jobj)
              }
              "ContractCodeView" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryResponse.ContractCodeView>(), jobj)
              }
              "ViewStateResult" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryResponse.ViewStateResult>(), jobj)
              }
              "CallResult" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryResponse.CallResult>(), jobj)
              }
              "AccessKeyView" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryResponse.AccessKeyView>(), jobj)
              }
              "AccessKeyList" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryResponse.AccessKeyList>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for RpcQueryResponse: " + typeField)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize RpcQueryResponse with non-JSON decoder")
  }
}
