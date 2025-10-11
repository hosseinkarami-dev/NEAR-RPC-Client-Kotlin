package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.AccountId
import io.github.hosseinkarami_dev.near.rpc.models.BlockId
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.Finality
import io.github.hosseinkarami_dev.near.rpc.models.FunctionArgs
import io.github.hosseinkarami_dev.near.rpc.models.PublicKey
import io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest
import io.github.hosseinkarami_dev.near.rpc.models.StoreKey
import io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint
import kotlin.Boolean
import kotlin.String
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

public object RpcQueryRequestSerializer : KSerializer<RpcQueryRequest> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest") {
        element("view_account_by_block_id", serializer<JsonElement>().descriptor)
        element("view_code_by_block_id", serializer<JsonElement>().descriptor)
        element("view_state_by_block_id", serializer<JsonElement>().descriptor)
        element("view_access_key_by_block_id", serializer<JsonElement>().descriptor)
        element("view_access_key_list_by_block_id", serializer<JsonElement>().descriptor)
        element("call_function_by_block_id", serializer<JsonElement>().descriptor)
        element("view_global_contract_code_by_block_id", serializer<JsonElement>().descriptor)
        element("view_global_contract_code_by_account_id_by_block_id", serializer<JsonElement>().descriptor)
        element("view_account_by_finality", serializer<JsonElement>().descriptor)
        element("view_code_by_finality", serializer<JsonElement>().descriptor)
        element("view_state_by_finality", serializer<JsonElement>().descriptor)
        element("view_access_key_by_finality", serializer<JsonElement>().descriptor)
        element("view_access_key_list_by_finality", serializer<JsonElement>().descriptor)
        element("call_function_by_finality", serializer<JsonElement>().descriptor)
        element("view_global_contract_code_by_finality", serializer<JsonElement>().descriptor)
        element("view_global_contract_code_by_account_id_by_finality", serializer<JsonElement>().descriptor)
        element("view_account_by_sync_checkpoint", serializer<JsonElement>().descriptor)
        element("view_code_by_sync_checkpoint", serializer<JsonElement>().descriptor)
        element("view_state_by_sync_checkpoint", serializer<JsonElement>().descriptor)
        element("view_access_key_by_sync_checkpoint", serializer<JsonElement>().descriptor)
        element("view_access_key_list_by_sync_checkpoint", serializer<JsonElement>().descriptor)
        element("call_function_by_sync_checkpoint", serializer<JsonElement>().descriptor)
        element("view_global_contract_code_by_sync_checkpoint", serializer<JsonElement>().descriptor)
        element("view_global_contract_code_by_account_id_by_sync_checkpoint", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: RpcQueryRequest) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is RpcQueryRequest.ViewAccountByBlockId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<BlockId>(), value.blockId)
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.ViewAccountByBlockId.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.ViewCodeByBlockId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<BlockId>(), value.blockId)
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.ViewCodeByBlockId.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.ViewStateByBlockId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<BlockId>(), value.blockId)
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          if (value.includeProof != null) {
            map["include_proof"] = jsonEncoder.json.encodeToJsonElement(serializer<Boolean?>(), value.includeProof)
          }
          map["prefix_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<StoreKey>(), value.prefixBase64)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.ViewStateByBlockId.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.ViewAccessKeyByBlockId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<BlockId>(), value.blockId)
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          map["public_key"] = jsonEncoder.json.encodeToJsonElement(serializer<PublicKey>(), value.publicKey)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.ViewAccessKeyByBlockId.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.ViewAccessKeyListByBlockId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<BlockId>(), value.blockId)
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.ViewAccessKeyListByBlockId.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.CallFunctionByBlockId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<BlockId>(), value.blockId)
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          map["args_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<FunctionArgs>(), value.argsBase64)
          map["method_name"] = jsonEncoder.json.encodeToJsonElement(serializer<String>(), value.methodName)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.CallFunctionByBlockId.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.ViewGlobalContractCodeByBlockId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<BlockId>(), value.blockId)
          map["code_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.codeHash)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeByBlockId.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.ViewGlobalContractCodeByAccountIdByBlockId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<BlockId>(), value.blockId)
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeByAccountIdByBlockId.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.ViewAccountByFinality -> {
          val map = mutableMapOf<String, JsonElement>()
          map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<Finality>(), value.finality)
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.ViewAccountByFinality.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.ViewCodeByFinality -> {
          val map = mutableMapOf<String, JsonElement>()
          map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<Finality>(), value.finality)
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.ViewCodeByFinality.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.ViewStateByFinality -> {
          val map = mutableMapOf<String, JsonElement>()
          map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<Finality>(), value.finality)
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          if (value.includeProof != null) {
            map["include_proof"] = jsonEncoder.json.encodeToJsonElement(serializer<Boolean?>(), value.includeProof)
          }
          map["prefix_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<StoreKey>(), value.prefixBase64)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.ViewStateByFinality.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.ViewAccessKeyByFinality -> {
          val map = mutableMapOf<String, JsonElement>()
          map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<Finality>(), value.finality)
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          map["public_key"] = jsonEncoder.json.encodeToJsonElement(serializer<PublicKey>(), value.publicKey)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.ViewAccessKeyByFinality.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.ViewAccessKeyListByFinality -> {
          val map = mutableMapOf<String, JsonElement>()
          map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<Finality>(), value.finality)
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.ViewAccessKeyListByFinality.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.CallFunctionByFinality -> {
          val map = mutableMapOf<String, JsonElement>()
          map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<Finality>(), value.finality)
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          map["args_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<FunctionArgs>(), value.argsBase64)
          map["method_name"] = jsonEncoder.json.encodeToJsonElement(serializer<String>(), value.methodName)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.CallFunctionByFinality.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.ViewGlobalContractCodeByFinality -> {
          val map = mutableMapOf<String, JsonElement>()
          map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<Finality>(), value.finality)
          map["code_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.codeHash)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeByFinality.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.ViewGlobalContractCodeByAccountIdByFinality -> {
          val map = mutableMapOf<String, JsonElement>()
          map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<Finality>(), value.finality)
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeByAccountIdByFinality.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.ViewAccountBySyncCheckpoint -> {
          val map = mutableMapOf<String, JsonElement>()
          map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<SyncCheckpoint>(), value.syncCheckpoint)
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.ViewAccountBySyncCheckpoint.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.ViewCodeBySyncCheckpoint -> {
          val map = mutableMapOf<String, JsonElement>()
          map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<SyncCheckpoint>(), value.syncCheckpoint)
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.ViewCodeBySyncCheckpoint.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.ViewStateBySyncCheckpoint -> {
          val map = mutableMapOf<String, JsonElement>()
          map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<SyncCheckpoint>(), value.syncCheckpoint)
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          if (value.includeProof != null) {
            map["include_proof"] = jsonEncoder.json.encodeToJsonElement(serializer<Boolean?>(), value.includeProof)
          }
          map["prefix_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<StoreKey>(), value.prefixBase64)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.ViewStateBySyncCheckpoint.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.ViewAccessKeyBySyncCheckpoint -> {
          val map = mutableMapOf<String, JsonElement>()
          map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<SyncCheckpoint>(), value.syncCheckpoint)
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          map["public_key"] = jsonEncoder.json.encodeToJsonElement(serializer<PublicKey>(), value.publicKey)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.ViewAccessKeyBySyncCheckpoint.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.ViewAccessKeyListBySyncCheckpoint -> {
          val map = mutableMapOf<String, JsonElement>()
          map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<SyncCheckpoint>(), value.syncCheckpoint)
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.ViewAccessKeyListBySyncCheckpoint.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.CallFunctionBySyncCheckpoint -> {
          val map = mutableMapOf<String, JsonElement>()
          map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<SyncCheckpoint>(), value.syncCheckpoint)
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          map["args_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<FunctionArgs>(), value.argsBase64)
          map["method_name"] = jsonEncoder.json.encodeToJsonElement(serializer<String>(), value.methodName)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.CallFunctionBySyncCheckpoint.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.ViewGlobalContractCodeBySyncCheckpoint -> {
          val map = mutableMapOf<String, JsonElement>()
          map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<SyncCheckpoint>(), value.syncCheckpoint)
          map["code_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.codeHash)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeBySyncCheckpoint.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcQueryRequest.ViewGlobalContractCodeByAccountIdBySyncCheckpoint -> {
          val map = mutableMapOf<String, JsonElement>()
          map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<SyncCheckpoint>(), value.syncCheckpoint)
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeByAccountIdBySyncCheckpoint.RequestType>(), value.requestType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is RpcQueryRequest.ViewAccountByBlockId -> out.encodeSerializableElement(descriptor, 0, serializer<RpcQueryRequest.ViewAccountByBlockId>(), value)
      is RpcQueryRequest.ViewCodeByBlockId -> out.encodeSerializableElement(descriptor, 1, serializer<RpcQueryRequest.ViewCodeByBlockId>(), value)
      is RpcQueryRequest.ViewStateByBlockId -> out.encodeSerializableElement(descriptor, 2, serializer<RpcQueryRequest.ViewStateByBlockId>(), value)
      is RpcQueryRequest.ViewAccessKeyByBlockId -> out.encodeSerializableElement(descriptor, 3, serializer<RpcQueryRequest.ViewAccessKeyByBlockId>(), value)
      is RpcQueryRequest.ViewAccessKeyListByBlockId -> out.encodeSerializableElement(descriptor, 4, serializer<RpcQueryRequest.ViewAccessKeyListByBlockId>(), value)
      is RpcQueryRequest.CallFunctionByBlockId -> out.encodeSerializableElement(descriptor, 5, serializer<RpcQueryRequest.CallFunctionByBlockId>(), value)
      is RpcQueryRequest.ViewGlobalContractCodeByBlockId -> out.encodeSerializableElement(descriptor, 6, serializer<RpcQueryRequest.ViewGlobalContractCodeByBlockId>(), value)
      is RpcQueryRequest.ViewGlobalContractCodeByAccountIdByBlockId -> out.encodeSerializableElement(descriptor, 7, serializer<RpcQueryRequest.ViewGlobalContractCodeByAccountIdByBlockId>(), value)
      is RpcQueryRequest.ViewAccountByFinality -> out.encodeSerializableElement(descriptor, 8, serializer<RpcQueryRequest.ViewAccountByFinality>(), value)
      is RpcQueryRequest.ViewCodeByFinality -> out.encodeSerializableElement(descriptor, 9, serializer<RpcQueryRequest.ViewCodeByFinality>(), value)
      is RpcQueryRequest.ViewStateByFinality -> out.encodeSerializableElement(descriptor, 10, serializer<RpcQueryRequest.ViewStateByFinality>(), value)
      is RpcQueryRequest.ViewAccessKeyByFinality -> out.encodeSerializableElement(descriptor, 11, serializer<RpcQueryRequest.ViewAccessKeyByFinality>(), value)
      is RpcQueryRequest.ViewAccessKeyListByFinality -> out.encodeSerializableElement(descriptor, 12, serializer<RpcQueryRequest.ViewAccessKeyListByFinality>(), value)
      is RpcQueryRequest.CallFunctionByFinality -> out.encodeSerializableElement(descriptor, 13, serializer<RpcQueryRequest.CallFunctionByFinality>(), value)
      is RpcQueryRequest.ViewGlobalContractCodeByFinality -> out.encodeSerializableElement(descriptor, 14, serializer<RpcQueryRequest.ViewGlobalContractCodeByFinality>(), value)
      is RpcQueryRequest.ViewGlobalContractCodeByAccountIdByFinality -> out.encodeSerializableElement(descriptor, 15, serializer<RpcQueryRequest.ViewGlobalContractCodeByAccountIdByFinality>(), value)
      is RpcQueryRequest.ViewAccountBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 16, serializer<RpcQueryRequest.ViewAccountBySyncCheckpoint>(), value)
      is RpcQueryRequest.ViewCodeBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 17, serializer<RpcQueryRequest.ViewCodeBySyncCheckpoint>(), value)
      is RpcQueryRequest.ViewStateBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 18, serializer<RpcQueryRequest.ViewStateBySyncCheckpoint>(), value)
      is RpcQueryRequest.ViewAccessKeyBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 19, serializer<RpcQueryRequest.ViewAccessKeyBySyncCheckpoint>(), value)
      is RpcQueryRequest.ViewAccessKeyListBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 20, serializer<RpcQueryRequest.ViewAccessKeyListBySyncCheckpoint>(), value)
      is RpcQueryRequest.CallFunctionBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 21, serializer<RpcQueryRequest.CallFunctionBySyncCheckpoint>(), value)
      is RpcQueryRequest.ViewGlobalContractCodeBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 22, serializer<RpcQueryRequest.ViewGlobalContractCodeBySyncCheckpoint>(), value)
      is RpcQueryRequest.ViewGlobalContractCodeByAccountIdBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 23, serializer<RpcQueryRequest.ViewGlobalContractCodeByAccountIdBySyncCheckpoint>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): RpcQueryRequest {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            throw SerializationException("Unknown discriminator string for RpcQueryRequest: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing RpcQueryRequest")
        }
        is JsonObject -> {
          val jobj = element
          if (listOf("account_id", "block_id", "request_type").all { jobj[it] != null }) {
            // ambiguous required-keys group; skipping disambiguation here to avoid wrong decode
          }
          if (listOf("account_id", "block_id", "prefix_base64", "request_type").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewStateByBlockId>(), jobj)
          }
          if (listOf("account_id", "block_id", "public_key", "request_type").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccessKeyByBlockId>(), jobj)
          }
          if (listOf("account_id", "args_base64", "block_id", "method_name", "request_type").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.CallFunctionByBlockId>(), jobj)
          }
          if (listOf("block_id", "code_hash", "request_type").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeByBlockId>(), jobj)
          }
          if (listOf("account_id", "finality", "request_type").all { jobj[it] != null }) {
            // ambiguous required-keys group; skipping disambiguation here to avoid wrong decode
          }
          if (listOf("account_id", "finality", "prefix_base64", "request_type").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewStateByFinality>(), jobj)
          }
          if (listOf("account_id", "finality", "public_key", "request_type").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccessKeyByFinality>(), jobj)
          }
          if (listOf("account_id", "args_base64", "finality", "method_name", "request_type").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.CallFunctionByFinality>(), jobj)
          }
          if (listOf("code_hash", "finality", "request_type").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeByFinality>(), jobj)
          }
          if (listOf("account_id", "request_type", "sync_checkpoint").all { jobj[it] != null }) {
            // ambiguous required-keys group; skipping disambiguation here to avoid wrong decode
          }
          if (listOf("account_id", "prefix_base64", "request_type", "sync_checkpoint").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewStateBySyncCheckpoint>(), jobj)
          }
          if (listOf("account_id", "public_key", "request_type", "sync_checkpoint").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccessKeyBySyncCheckpoint>(), jobj)
          }
          if (listOf("account_id", "args_base64", "method_name", "request_type", "sync_checkpoint").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.CallFunctionBySyncCheckpoint>(), jobj)
          }
          if (listOf("code_hash", "request_type", "sync_checkpoint").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeBySyncCheckpoint>(), jobj)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "view_account_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccountByBlockId>(), obj)
              }
              "view_code_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewCodeByBlockId>(), obj)
              }
              "view_state_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewStateByBlockId>(), obj)
              }
              "view_access_key_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccessKeyByBlockId>(), obj)
              }
              "view_access_key_list_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccessKeyListByBlockId>(), obj)
              }
              "call_function_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.CallFunctionByBlockId>(), obj)
              }
              "view_global_contract_code_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeByBlockId>(), obj)
              }
              "view_global_contract_code_by_account_id_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeByAccountIdByBlockId>(), obj)
              }
              "view_account_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccountByFinality>(), obj)
              }
              "view_code_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewCodeByFinality>(), obj)
              }
              "view_state_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewStateByFinality>(), obj)
              }
              "view_access_key_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccessKeyByFinality>(), obj)
              }
              "view_access_key_list_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccessKeyListByFinality>(), obj)
              }
              "call_function_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.CallFunctionByFinality>(), obj)
              }
              "view_global_contract_code_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeByFinality>(), obj)
              }
              "view_global_contract_code_by_account_id_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeByAccountIdByFinality>(), obj)
              }
              "view_account_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccountBySyncCheckpoint>(), obj)
              }
              "view_code_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewCodeBySyncCheckpoint>(), obj)
              }
              "view_state_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewStateBySyncCheckpoint>(), obj)
              }
              "view_access_key_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccessKeyBySyncCheckpoint>(), obj)
              }
              "view_access_key_list_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccessKeyListBySyncCheckpoint>(), obj)
              }
              "call_function_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.CallFunctionBySyncCheckpoint>(), obj)
              }
              "view_global_contract_code_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeBySyncCheckpoint>(), obj)
              }
              "view_global_contract_code_by_account_id_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeByAccountIdBySyncCheckpoint>(), obj)
              }
              else -> throw SerializationException("Unknown discriminator key for RpcQueryRequest: " + key)
            }
          }
          else {
            var typeField: String? = null
            val discriminatorCandidates = listOf("request_type")
            for (cand in discriminatorCandidates) {
              val candElem = jobj[cand]
              if (candElem is JsonPrimitive) {
                typeField = candElem.contentOrNull
                if (typeField != null) break
              }
            }
            if (typeField == null) {
              val knownVariantNames = setOf("view_account_by_block_id", "view_code_by_block_id", "view_state_by_block_id", "view_access_key_by_block_id", "view_access_key_list_by_block_id", "call_function_by_block_id", "view_global_contract_code_by_block_id", "view_global_contract_code_by_account_id_by_block_id", "view_account_by_finality", "view_code_by_finality", "view_state_by_finality", "view_access_key_by_finality", "view_access_key_list_by_finality", "call_function_by_finality", "view_global_contract_code_by_finality", "view_global_contract_code_by_account_id_by_finality", "view_account_by_sync_checkpoint", "view_code_by_sync_checkpoint", "view_state_by_sync_checkpoint", "view_access_key_by_sync_checkpoint", "view_access_key_list_by_sync_checkpoint", "call_function_by_sync_checkpoint", "view_global_contract_code_by_sync_checkpoint", "view_global_contract_code_by_account_id_by_sync_checkpoint")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator (one of request_type) or recognizable variant in RpcQueryRequest")
            val tf = typeField.trim()
            when (tf) {
              "view_account_by_block_id" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccountByBlockId>(), jobj)
              }
              "view_code_by_block_id" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewCodeByBlockId>(), jobj)
              }
              "view_state_by_block_id" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewStateByBlockId>(), jobj)
              }
              "view_access_key_by_block_id" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccessKeyByBlockId>(), jobj)
              }
              "view_access_key_list_by_block_id" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccessKeyListByBlockId>(), jobj)
              }
              "call_function_by_block_id" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.CallFunctionByBlockId>(), jobj)
              }
              "view_global_contract_code_by_block_id" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeByBlockId>(), jobj)
              }
              "view_global_contract_code_by_account_id_by_block_id" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeByAccountIdByBlockId>(), jobj)
              }
              "view_account_by_finality" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccountByFinality>(), jobj)
              }
              "view_code_by_finality" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewCodeByFinality>(), jobj)
              }
              "view_state_by_finality" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewStateByFinality>(), jobj)
              }
              "view_access_key_by_finality" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccessKeyByFinality>(), jobj)
              }
              "view_access_key_list_by_finality" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccessKeyListByFinality>(), jobj)
              }
              "call_function_by_finality" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.CallFunctionByFinality>(), jobj)
              }
              "view_global_contract_code_by_finality" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeByFinality>(), jobj)
              }
              "view_global_contract_code_by_account_id_by_finality" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeByAccountIdByFinality>(), jobj)
              }
              "view_account_by_sync_checkpoint" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccountBySyncCheckpoint>(), jobj)
              }
              "view_code_by_sync_checkpoint" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewCodeBySyncCheckpoint>(), jobj)
              }
              "view_state_by_sync_checkpoint" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewStateBySyncCheckpoint>(), jobj)
              }
              "view_access_key_by_sync_checkpoint" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccessKeyBySyncCheckpoint>(), jobj)
              }
              "view_access_key_list_by_sync_checkpoint" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccessKeyListBySyncCheckpoint>(), jobj)
              }
              "call_function_by_sync_checkpoint" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.CallFunctionBySyncCheckpoint>(), jobj)
              }
              "view_global_contract_code_by_sync_checkpoint" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeBySyncCheckpoint>(), jobj)
              }
              "view_global_contract_code_by_account_id_by_sync_checkpoint" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeByAccountIdBySyncCheckpoint>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for RpcQueryRequest: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize RpcQueryRequest with non-JSON decoder")
  }
}
