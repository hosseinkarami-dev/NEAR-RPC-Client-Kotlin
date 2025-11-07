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
import io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest
import kotlinx.serialization.json.*

object RpcQueryRequestSerializer : KSerializer<RpcQueryRequest> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest") {
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

    override fun serialize(encoder: Encoder, value: RpcQueryRequest) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByBlockId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>(), value.blockId)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByBlockId.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByBlockId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>(), value.blockId)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByBlockId.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByBlockId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>(), value.blockId)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    if (value.includeProof != null) {
                        map["include_proof"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.Boolean?>(), value.includeProof)
                    }
                    map["prefix_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StoreKey>(), value.prefixBase64)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByBlockId.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByBlockId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>(), value.blockId)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["public_key"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PublicKey>(), value.publicKey)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByBlockId.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByBlockId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>(), value.blockId)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByBlockId.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByBlockId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>(), value.blockId)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["args_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionArgs>(), value.argsBase64)
                    map["method_name"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.String>(), value.methodName)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByBlockId.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByBlockId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>(), value.blockId)
                    map["code_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.codeHash)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByBlockId.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByBlockId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>(), value.blockId)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByBlockId.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByFinality -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.Finality>(), value.finality)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByFinality.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByFinality -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.Finality>(), value.finality)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByFinality.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByFinality -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.Finality>(), value.finality)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    if (value.includeProof != null) {
                        map["include_proof"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.Boolean?>(), value.includeProof)
                    }
                    map["prefix_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StoreKey>(), value.prefixBase64)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByFinality.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByFinality -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.Finality>(), value.finality)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["public_key"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PublicKey>(), value.publicKey)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByFinality.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByFinality -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.Finality>(), value.finality)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByFinality.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByFinality -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.Finality>(), value.finality)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["args_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionArgs>(), value.argsBase64)
                    map["method_name"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.String>(), value.methodName)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByFinality.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByFinality -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.Finality>(), value.finality)
                    map["code_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.codeHash)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByFinality.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByFinality -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.Finality>(), value.finality)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByFinality.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountBySyncCheckpoint -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint>(), value.syncCheckpoint)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountBySyncCheckpoint.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeBySyncCheckpoint -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint>(), value.syncCheckpoint)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeBySyncCheckpoint.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateBySyncCheckpoint -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint>(), value.syncCheckpoint)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    if (value.includeProof != null) {
                        map["include_proof"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.Boolean?>(), value.includeProof)
                    }
                    map["prefix_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StoreKey>(), value.prefixBase64)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateBySyncCheckpoint.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyBySyncCheckpoint -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint>(), value.syncCheckpoint)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["public_key"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.PublicKey>(), value.publicKey)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyBySyncCheckpoint.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListBySyncCheckpoint -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint>(), value.syncCheckpoint)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListBySyncCheckpoint.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionBySyncCheckpoint -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint>(), value.syncCheckpoint)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["args_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionArgs>(), value.argsBase64)
                    map["method_name"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.String>(), value.methodName)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionBySyncCheckpoint.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeBySyncCheckpoint -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint>(), value.syncCheckpoint)
                    map["code_hash"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.codeHash)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeBySyncCheckpoint.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdBySyncCheckpoint -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint>(), value.syncCheckpoint)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["request_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdBySyncCheckpoint.RequestType>(), value.requestType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByBlockId -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByBlockId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByBlockId -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByBlockId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByBlockId -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByBlockId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByBlockId -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByBlockId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByBlockId -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByBlockId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByBlockId -> out.encodeSerializableElement(descriptor, 5, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByBlockId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByBlockId -> out.encodeSerializableElement(descriptor, 6, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByBlockId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByBlockId -> out.encodeSerializableElement(descriptor, 7, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByBlockId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByFinality -> out.encodeSerializableElement(descriptor, 8, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByFinality>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByFinality -> out.encodeSerializableElement(descriptor, 9, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByFinality>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByFinality -> out.encodeSerializableElement(descriptor, 10, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByFinality>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByFinality -> out.encodeSerializableElement(descriptor, 11, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByFinality>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByFinality -> out.encodeSerializableElement(descriptor, 12, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByFinality>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByFinality -> out.encodeSerializableElement(descriptor, 13, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByFinality>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByFinality -> out.encodeSerializableElement(descriptor, 14, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByFinality>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByFinality -> out.encodeSerializableElement(descriptor, 15, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByFinality>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 16, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountBySyncCheckpoint>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 17, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeBySyncCheckpoint>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 18, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateBySyncCheckpoint>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 19, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyBySyncCheckpoint>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 20, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListBySyncCheckpoint>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 21, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionBySyncCheckpoint>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 22, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeBySyncCheckpoint>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 23, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdBySyncCheckpoint>(), value)
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
                    }
                    throw SerializationException("Unknown discriminator (primitive) for RpcQueryRequest")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing RpcQueryRequest")

                is JsonObject -> {
                    val jobj = element
                    val knownVariantNames = setOf("view_account_by_block_id", "view_code_by_block_id", "view_state_by_block_id", "view_access_key_by_block_id", "view_access_key_list_by_block_id", "call_function_by_block_id", "view_global_contract_code_by_block_id", "view_global_contract_code_by_account_id_by_block_id", "view_account_by_finality", "view_code_by_finality", "view_state_by_finality", "view_access_key_by_finality", "view_access_key_list_by_finality", "call_function_by_finality", "view_global_contract_code_by_finality", "view_global_contract_code_by_account_id_by_finality", "view_account_by_sync_checkpoint", "view_code_by_sync_checkpoint", "view_state_by_sync_checkpoint", "view_access_key_by_sync_checkpoint", "view_access_key_list_by_sync_checkpoint", "call_function_by_sync_checkpoint", "view_global_contract_code_by_sync_checkpoint", "view_global_contract_code_by_account_id_by_sync_checkpoint")
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        if (knownVariantNames.contains(key)) {
                            when (key) {
                            "view_account_by_block_id" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant view_account_by_block_id: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByBlockId>(), obj)
                            }
                            "view_code_by_block_id" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant view_code_by_block_id: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByBlockId>(), obj)
                            }
                            "view_state_by_block_id" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant view_state_by_block_id: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByBlockId>(), obj)
                            }
                            "view_access_key_by_block_id" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant view_access_key_by_block_id: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByBlockId>(), obj)
                            }
                            "view_access_key_list_by_block_id" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant view_access_key_list_by_block_id: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByBlockId>(), obj)
                            }
                            "call_function_by_block_id" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant call_function_by_block_id: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByBlockId>(), obj)
                            }
                            "view_global_contract_code_by_block_id" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant view_global_contract_code_by_block_id: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByBlockId>(), obj)
                            }
                            "view_global_contract_code_by_account_id_by_block_id" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant view_global_contract_code_by_account_id_by_block_id: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByBlockId>(), obj)
                            }
                            "view_account_by_finality" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant view_account_by_finality: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByFinality>(), obj)
                            }
                            "view_code_by_finality" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant view_code_by_finality: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByFinality>(), obj)
                            }
                            "view_state_by_finality" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant view_state_by_finality: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByFinality>(), obj)
                            }
                            "view_access_key_by_finality" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant view_access_key_by_finality: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByFinality>(), obj)
                            }
                            "view_access_key_list_by_finality" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant view_access_key_list_by_finality: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByFinality>(), obj)
                            }
                            "call_function_by_finality" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant call_function_by_finality: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByFinality>(), obj)
                            }
                            "view_global_contract_code_by_finality" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant view_global_contract_code_by_finality: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByFinality>(), obj)
                            }
                            "view_global_contract_code_by_account_id_by_finality" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant view_global_contract_code_by_account_id_by_finality: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByFinality>(), obj)
                            }
                            "view_account_by_sync_checkpoint" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant view_account_by_sync_checkpoint: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountBySyncCheckpoint>(), obj)
                            }
                            "view_code_by_sync_checkpoint" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant view_code_by_sync_checkpoint: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeBySyncCheckpoint>(), obj)
                            }
                            "view_state_by_sync_checkpoint" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant view_state_by_sync_checkpoint: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateBySyncCheckpoint>(), obj)
                            }
                            "view_access_key_by_sync_checkpoint" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant view_access_key_by_sync_checkpoint: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyBySyncCheckpoint>(), obj)
                            }
                            "view_access_key_list_by_sync_checkpoint" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant view_access_key_list_by_sync_checkpoint: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListBySyncCheckpoint>(), obj)
                            }
                            "call_function_by_sync_checkpoint" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant call_function_by_sync_checkpoint: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionBySyncCheckpoint>(), obj)
                            }
                            "view_global_contract_code_by_sync_checkpoint" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant view_global_contract_code_by_sync_checkpoint: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeBySyncCheckpoint>(), obj)
                            }
                            "view_global_contract_code_by_account_id_by_sync_checkpoint" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant view_global_contract_code_by_account_id_by_sync_checkpoint: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdBySyncCheckpoint>(), obj)
                            }
                            else -> { /* knownVariantNames.contains(key) guards this branch; shouldn't reach here */ }
                            }
                        }
                    }
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
                            "view_account_by_block_id" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByBlockId>(), jobj)
                            "view_code_by_block_id" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByBlockId>(), jobj)
                            "view_state_by_block_id" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByBlockId>(), jobj)
                            "view_access_key_by_block_id" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByBlockId>(), jobj)
                            "view_access_key_list_by_block_id" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByBlockId>(), jobj)
                            "call_function_by_block_id" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByBlockId>(), jobj)
                            "view_global_contract_code_by_block_id" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByBlockId>(), jobj)
                            "view_global_contract_code_by_account_id_by_block_id" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByBlockId>(), jobj)
                            "view_account_by_finality" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByFinality>(), jobj)
                            "view_code_by_finality" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByFinality>(), jobj)
                            "view_state_by_finality" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByFinality>(), jobj)
                            "view_access_key_by_finality" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByFinality>(), jobj)
                            "view_access_key_list_by_finality" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByFinality>(), jobj)
                            "call_function_by_finality" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByFinality>(), jobj)
                            "view_global_contract_code_by_finality" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByFinality>(), jobj)
                            "view_global_contract_code_by_account_id_by_finality" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByFinality>(), jobj)
                            "view_account_by_sync_checkpoint" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountBySyncCheckpoint>(), jobj)
                            "view_code_by_sync_checkpoint" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeBySyncCheckpoint>(), jobj)
                            "view_state_by_sync_checkpoint" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateBySyncCheckpoint>(), jobj)
                            "view_access_key_by_sync_checkpoint" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyBySyncCheckpoint>(), jobj)
                            "view_access_key_list_by_sync_checkpoint" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListBySyncCheckpoint>(), jobj)
                            "call_function_by_sync_checkpoint" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionBySyncCheckpoint>(), jobj)
                            "view_global_contract_code_by_sync_checkpoint" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeBySyncCheckpoint>(), jobj)
                            "view_global_contract_code_by_account_id_by_sync_checkpoint" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdBySyncCheckpoint>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("view_account".lowercase() == tfLower || tfLower.contains("view_account".lowercase()) || "view_account".lowercase().contains(tfLower))) { chosenGroupKey = "view_account" }
                        if (chosenGroupKey == null && ("view_code".lowercase() == tfLower || tfLower.contains("view_code".lowercase()) || "view_code".lowercase().contains(tfLower))) { chosenGroupKey = "view_code" }
                        if (chosenGroupKey == null && ("view_state".lowercase() == tfLower || tfLower.contains("view_state".lowercase()) || "view_state".lowercase().contains(tfLower))) { chosenGroupKey = "view_state" }
                        if (chosenGroupKey == null && ("view_access_key".lowercase() == tfLower || tfLower.contains("view_access_key".lowercase()) || "view_access_key".lowercase().contains(tfLower))) { chosenGroupKey = "view_access_key" }
                        if (chosenGroupKey == null && ("view_access_key_list".lowercase() == tfLower || tfLower.contains("view_access_key_list".lowercase()) || "view_access_key_list".lowercase().contains(tfLower))) { chosenGroupKey = "view_access_key_list" }
                        if (chosenGroupKey == null && ("call_function".lowercase() == tfLower || tfLower.contains("call_function".lowercase()) || "call_function".lowercase().contains(tfLower))) { chosenGroupKey = "call_function" }
                        if (chosenGroupKey == null && ("view_global_contract_code".lowercase() == tfLower || tfLower.contains("view_global_contract_code".lowercase()) || "view_global_contract_code".lowercase().contains(tfLower))) { chosenGroupKey = "view_global_contract_code" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "view_account" -> {
                                    if (jobj["block_id"] != null) {
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByBlockId>(), jobj) } catch (_: Exception) { }
                                    }
                                    if (jobj["finality"] != null) {
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByFinality>(), jobj) } catch (_: Exception) { }
                                    }
                                    if (jobj["sync_checkpoint"] != null) {
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                    }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByBlockId>(), jobj) } catch (_: Exception) { }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByFinality>(), jobj) } catch (_: Exception) { }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'view_account' and tf='\$tf'")
                                }
                                "view_code" -> {
                                    if (jobj["block_id"] != null) {
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByBlockId>(), jobj) } catch (_: Exception) { }
                                    }
                                    if (jobj["finality"] != null) {
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByFinality>(), jobj) } catch (_: Exception) { }
                                    }
                                    if (jobj["sync_checkpoint"] != null) {
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                    }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByBlockId>(), jobj) } catch (_: Exception) { }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByFinality>(), jobj) } catch (_: Exception) { }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'view_code' and tf='\$tf'")
                                }
                                "view_state" -> {
                                    if (jobj["block_id"] != null) {
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByBlockId>(), jobj) } catch (_: Exception) { }
                                    }
                                    if (jobj["finality"] != null) {
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByFinality>(), jobj) } catch (_: Exception) { }
                                    }
                                    if (jobj["sync_checkpoint"] != null) {
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                    }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByBlockId>(), jobj) } catch (_: Exception) { }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByFinality>(), jobj) } catch (_: Exception) { }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'view_state' and tf='\$tf'")
                                }
                                "view_access_key" -> {
                                    if (jobj["block_id"] != null) {
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByBlockId>(), jobj) } catch (_: Exception) { }
                                    }
                                    if (jobj["finality"] != null) {
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByFinality>(), jobj) } catch (_: Exception) { }
                                    }
                                    if (jobj["sync_checkpoint"] != null) {
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                    }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByBlockId>(), jobj) } catch (_: Exception) { }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByFinality>(), jobj) } catch (_: Exception) { }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'view_access_key' and tf='\$tf'")
                                }
                                "view_access_key_list" -> {
                                    if (jobj["block_id"] != null) {
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByBlockId>(), jobj) } catch (_: Exception) { }
                                    }
                                    if (jobj["finality"] != null) {
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByFinality>(), jobj) } catch (_: Exception) { }
                                    }
                                    if (jobj["sync_checkpoint"] != null) {
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                    }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByBlockId>(), jobj) } catch (_: Exception) { }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByFinality>(), jobj) } catch (_: Exception) { }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'view_access_key_list' and tf='\$tf'")
                                }
                                "call_function" -> {
                                    if (jobj["block_id"] != null) {
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByBlockId>(), jobj) } catch (_: Exception) { }
                                    }
                                    if (jobj["finality"] != null) {
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByFinality>(), jobj) } catch (_: Exception) { }
                                    }
                                    if (jobj["sync_checkpoint"] != null) {
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                    }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByBlockId>(), jobj) } catch (_: Exception) { }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByFinality>(), jobj) } catch (_: Exception) { }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'call_function' and tf='\$tf'")
                                }
                                "view_global_contract_code" -> {
                                    if (jobj["block_id"] != null) {
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByBlockId>(), jobj) } catch (_: Exception) { }
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByBlockId>(), jobj) } catch (_: Exception) { }
                                    }
                                    if (jobj["finality"] != null) {
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByFinality>(), jobj) } catch (_: Exception) { }
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByFinality>(), jobj) } catch (_: Exception) { }
                                    }
                                    if (jobj["sync_checkpoint"] != null) {
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                    }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByBlockId>(), jobj) } catch (_: Exception) { }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByBlockId>(), jobj) } catch (_: Exception) { }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByFinality>(), jobj) } catch (_: Exception) { }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByFinality>(), jobj) } catch (_: Exception) { }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'view_global_contract_code' and tf='\$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: view_account
                    if (jobj["block_id"] != null) {
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByBlockId>(), jobj) } catch (_: Exception) { }
                    }
                    if (jobj["finality"] != null) {
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByFinality>(), jobj) } catch (_: Exception) { }
                    }
                    if (jobj["sync_checkpoint"] != null) {
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    }
                    // group: view_code
                    if (jobj["block_id"] != null) {
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByBlockId>(), jobj) } catch (_: Exception) { }
                    }
                    if (jobj["finality"] != null) {
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByFinality>(), jobj) } catch (_: Exception) { }
                    }
                    if (jobj["sync_checkpoint"] != null) {
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    }
                    // group: view_state
                    if (jobj["block_id"] != null) {
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByBlockId>(), jobj) } catch (_: Exception) { }
                    }
                    if (jobj["finality"] != null) {
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByFinality>(), jobj) } catch (_: Exception) { }
                    }
                    if (jobj["sync_checkpoint"] != null) {
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    }
                    // group: view_access_key
                    if (jobj["block_id"] != null) {
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByBlockId>(), jobj) } catch (_: Exception) { }
                    }
                    if (jobj["finality"] != null) {
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByFinality>(), jobj) } catch (_: Exception) { }
                    }
                    if (jobj["sync_checkpoint"] != null) {
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    }
                    // group: view_access_key_list
                    if (jobj["block_id"] != null) {
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByBlockId>(), jobj) } catch (_: Exception) { }
                    }
                    if (jobj["finality"] != null) {
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByFinality>(), jobj) } catch (_: Exception) { }
                    }
                    if (jobj["sync_checkpoint"] != null) {
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    }
                    // group: call_function
                    if (jobj["block_id"] != null) {
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByBlockId>(), jobj) } catch (_: Exception) { }
                    }
                    if (jobj["finality"] != null) {
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByFinality>(), jobj) } catch (_: Exception) { }
                    }
                    if (jobj["sync_checkpoint"] != null) {
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    }
                    // group: view_global_contract_code
                    if (jobj["block_id"] != null) {
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByBlockId>(), jobj) } catch (_: Exception) { }
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByBlockId>(), jobj) } catch (_: Exception) { }
                    }
                    if (jobj["finality"] != null) {
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByFinality>(), jobj) } catch (_: Exception) { }
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByFinality>(), jobj) } catch (_: Exception) { }
                    }
                    if (jobj["sync_checkpoint"] != null) {
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                        try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    }

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("block_id") && jobj.containsKey("account_id") && jobj.containsKey("request_type")) requiredMatches.add(0)
                    if (jobj.containsKey("block_id") && jobj.containsKey("account_id") && jobj.containsKey("request_type")) requiredMatches.add(1)
                    if (jobj.containsKey("block_id") && jobj.containsKey("account_id") && jobj.containsKey("prefix_base64") && jobj.containsKey("request_type")) requiredMatches.add(2)
                    if (jobj.containsKey("block_id") && jobj.containsKey("account_id") && jobj.containsKey("public_key") && jobj.containsKey("request_type")) requiredMatches.add(3)
                    if (jobj.containsKey("block_id") && jobj.containsKey("account_id") && jobj.containsKey("request_type")) requiredMatches.add(4)
                    if (jobj.containsKey("block_id") && jobj.containsKey("account_id") && jobj.containsKey("args_base64") && jobj.containsKey("method_name") && jobj.containsKey("request_type")) requiredMatches.add(5)
                    if (jobj.containsKey("block_id") && jobj.containsKey("code_hash") && jobj.containsKey("request_type")) requiredMatches.add(6)
                    if (jobj.containsKey("block_id") && jobj.containsKey("account_id") && jobj.containsKey("request_type")) requiredMatches.add(7)
                    if (jobj.containsKey("finality") && jobj.containsKey("account_id") && jobj.containsKey("request_type")) requiredMatches.add(8)
                    if (jobj.containsKey("finality") && jobj.containsKey("account_id") && jobj.containsKey("request_type")) requiredMatches.add(9)
                    if (jobj.containsKey("finality") && jobj.containsKey("account_id") && jobj.containsKey("prefix_base64") && jobj.containsKey("request_type")) requiredMatches.add(10)
                    if (jobj.containsKey("finality") && jobj.containsKey("account_id") && jobj.containsKey("public_key") && jobj.containsKey("request_type")) requiredMatches.add(11)
                    if (jobj.containsKey("finality") && jobj.containsKey("account_id") && jobj.containsKey("request_type")) requiredMatches.add(12)
                    if (jobj.containsKey("finality") && jobj.containsKey("account_id") && jobj.containsKey("args_base64") && jobj.containsKey("method_name") && jobj.containsKey("request_type")) requiredMatches.add(13)
                    if (jobj.containsKey("finality") && jobj.containsKey("code_hash") && jobj.containsKey("request_type")) requiredMatches.add(14)
                    if (jobj.containsKey("finality") && jobj.containsKey("account_id") && jobj.containsKey("request_type")) requiredMatches.add(15)
                    if (jobj.containsKey("sync_checkpoint") && jobj.containsKey("account_id") && jobj.containsKey("request_type")) requiredMatches.add(16)
                    if (jobj.containsKey("sync_checkpoint") && jobj.containsKey("account_id") && jobj.containsKey("request_type")) requiredMatches.add(17)
                    if (jobj.containsKey("sync_checkpoint") && jobj.containsKey("account_id") && jobj.containsKey("prefix_base64") && jobj.containsKey("request_type")) requiredMatches.add(18)
                    if (jobj.containsKey("sync_checkpoint") && jobj.containsKey("account_id") && jobj.containsKey("public_key") && jobj.containsKey("request_type")) requiredMatches.add(19)
                    if (jobj.containsKey("sync_checkpoint") && jobj.containsKey("account_id") && jobj.containsKey("request_type")) requiredMatches.add(20)
                    if (jobj.containsKey("sync_checkpoint") && jobj.containsKey("account_id") && jobj.containsKey("args_base64") && jobj.containsKey("method_name") && jobj.containsKey("request_type")) requiredMatches.add(21)
                    if (jobj.containsKey("sync_checkpoint") && jobj.containsKey("code_hash") && jobj.containsKey("request_type")) requiredMatches.add(22)
                    if (jobj.containsKey("sync_checkpoint") && jobj.containsKey("account_id") && jobj.containsKey("request_type")) requiredMatches.add(23)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByBlockId>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByBlockId>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByBlockId>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByBlockId>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByBlockId>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByBlockId>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByBlockId>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByBlockId>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByFinality>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByFinality>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByFinality>(), jobj)
                            11 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByFinality>(), jobj)
                            12 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByFinality>(), jobj)
                            13 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByFinality>(), jobj)
                            14 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByFinality>(), jobj)
                            15 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByFinality>(), jobj)
                            16 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountBySyncCheckpoint>(), jobj)
                            17 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeBySyncCheckpoint>(), jobj)
                            18 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateBySyncCheckpoint>(), jobj)
                            19 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyBySyncCheckpoint>(), jobj)
                            20 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListBySyncCheckpoint>(), jobj)
                            21 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionBySyncCheckpoint>(), jobj)
                            22 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeBySyncCheckpoint>(), jobj)
                            23 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdBySyncCheckpoint>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["block_id"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["block_id"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["block_id"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["include_proof"] != null) matchCount++
                        if (jobj["prefix_base64"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 5.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["block_id"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["public_key"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 4.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 3 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["block_id"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 4 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["block_id"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["args_base64"] != null) matchCount++
                        if (jobj["method_name"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 5.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 5 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["block_id"] != null) matchCount++
                        if (jobj["code_hash"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 6 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["block_id"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 7 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["finality"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 8 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["finality"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 9 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["finality"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["include_proof"] != null) matchCount++
                        if (jobj["prefix_base64"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 5.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 10 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["finality"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["public_key"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 4.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 11 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["finality"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 12 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["finality"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["args_base64"] != null) matchCount++
                        if (jobj["method_name"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 5.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 13 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["finality"] != null) matchCount++
                        if (jobj["code_hash"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 14 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["finality"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 15 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["sync_checkpoint"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 16 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["sync_checkpoint"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 17 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["sync_checkpoint"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["include_proof"] != null) matchCount++
                        if (jobj["prefix_base64"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 5.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 18 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["sync_checkpoint"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["public_key"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 4.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 19 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["sync_checkpoint"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 20 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["sync_checkpoint"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["args_base64"] != null) matchCount++
                        if (jobj["method_name"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 5.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 21 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["sync_checkpoint"] != null) matchCount++
                        if (jobj["code_hash"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 22 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["sync_checkpoint"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["request_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 23 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByBlockId>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByBlockId>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByBlockId>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByBlockId>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByBlockId>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByBlockId>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByBlockId>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByBlockId>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByFinality>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByFinality>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByFinality>(), jobj)
                            11 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByFinality>(), jobj)
                            12 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByFinality>(), jobj)
                            13 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByFinality>(), jobj)
                            14 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByFinality>(), jobj)
                            15 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByFinality>(), jobj)
                            16 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountBySyncCheckpoint>(), jobj)
                            17 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeBySyncCheckpoint>(), jobj)
                            18 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateBySyncCheckpoint>(), jobj)
                            19 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyBySyncCheckpoint>(), jobj)
                            20 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListBySyncCheckpoint>(), jobj)
                            21 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionBySyncCheckpoint>(), jobj)
                            22 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeBySyncCheckpoint>(), jobj)
                            23 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdBySyncCheckpoint>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByBlockId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByBlockId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByBlockId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByBlockId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByBlockId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByBlockId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByBlockId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByBlockId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountByFinality>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeByFinality>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateByFinality>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyByFinality>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListByFinality>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionByFinality>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByFinality>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdByFinality>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccountBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewCodeBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewStateBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewAccessKeyListBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.CallFunctionBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.ViewGlobalContractCodeByAccountIdBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in RpcQueryRequest")
                }
            }
        }
        throw SerializationException("Cannot deserialize RpcQueryRequest with non-JSON decoder")
    }
}
