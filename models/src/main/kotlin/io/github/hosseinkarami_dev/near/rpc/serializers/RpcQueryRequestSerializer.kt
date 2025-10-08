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
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest")

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
      is RpcQueryRequest.ViewAccountByBlockId -> out.encodeSerializableElement(descriptor, 0, serializer<BlockId>(), value.blockId)
      is RpcQueryRequest.ViewCodeByBlockId -> out.encodeSerializableElement(descriptor, 1, serializer<BlockId>(), value.blockId)
      is RpcQueryRequest.ViewStateByBlockId -> out.encodeSerializableElement(descriptor, 2, serializer<BlockId>(), value.blockId)
      is RpcQueryRequest.ViewAccessKeyByBlockId -> out.encodeSerializableElement(descriptor, 3, serializer<BlockId>(), value.blockId)
      is RpcQueryRequest.ViewAccessKeyListByBlockId -> out.encodeSerializableElement(descriptor, 4, serializer<BlockId>(), value.blockId)
      is RpcQueryRequest.CallFunctionByBlockId -> out.encodeSerializableElement(descriptor, 5, serializer<BlockId>(), value.blockId)
      is RpcQueryRequest.ViewGlobalContractCodeByBlockId -> out.encodeSerializableElement(descriptor, 6, serializer<BlockId>(), value.blockId)
      is RpcQueryRequest.ViewGlobalContractCodeByAccountIdByBlockId -> out.encodeSerializableElement(descriptor, 7, serializer<BlockId>(), value.blockId)
      is RpcQueryRequest.ViewAccountByFinality -> out.encodeSerializableElement(descriptor, 8, serializer<Finality>(), value.finality)
      is RpcQueryRequest.ViewCodeByFinality -> out.encodeSerializableElement(descriptor, 9, serializer<Finality>(), value.finality)
      is RpcQueryRequest.ViewStateByFinality -> out.encodeSerializableElement(descriptor, 10, serializer<Finality>(), value.finality)
      is RpcQueryRequest.ViewAccessKeyByFinality -> out.encodeSerializableElement(descriptor, 11, serializer<Finality>(), value.finality)
      is RpcQueryRequest.ViewAccessKeyListByFinality -> out.encodeSerializableElement(descriptor, 12, serializer<Finality>(), value.finality)
      is RpcQueryRequest.CallFunctionByFinality -> out.encodeSerializableElement(descriptor, 13, serializer<Finality>(), value.finality)
      is RpcQueryRequest.ViewGlobalContractCodeByFinality -> out.encodeSerializableElement(descriptor, 14, serializer<Finality>(), value.finality)
      is RpcQueryRequest.ViewGlobalContractCodeByAccountIdByFinality -> out.encodeSerializableElement(descriptor, 15, serializer<Finality>(), value.finality)
      is RpcQueryRequest.ViewAccountBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 16, serializer<SyncCheckpoint>(), value.syncCheckpoint)
      is RpcQueryRequest.ViewCodeBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 17, serializer<SyncCheckpoint>(), value.syncCheckpoint)
      is RpcQueryRequest.ViewStateBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 18, serializer<SyncCheckpoint>(), value.syncCheckpoint)
      is RpcQueryRequest.ViewAccessKeyBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 19, serializer<SyncCheckpoint>(), value.syncCheckpoint)
      is RpcQueryRequest.ViewAccessKeyListBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 20, serializer<SyncCheckpoint>(), value.syncCheckpoint)
      is RpcQueryRequest.CallFunctionBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 21, serializer<SyncCheckpoint>(), value.syncCheckpoint)
      is RpcQueryRequest.ViewGlobalContractCodeBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 22, serializer<SyncCheckpoint>(), value.syncCheckpoint)
      is RpcQueryRequest.ViewGlobalContractCodeByAccountIdBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 23, serializer<SyncCheckpoint>(), value.syncCheckpoint)
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
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "view_account_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val blockIdVal = decoder.json.decodeFromJsonElement(serializer<BlockId>(), obj["block_id"] ?: throw SerializationException("Missing field 'block_id' for variant " + key))
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccountByBlockId.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.ViewAccountByBlockId(blockIdVal, accountIdVal, requestTypeVal)
              }
              "view_code_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val blockIdVal = decoder.json.decodeFromJsonElement(serializer<BlockId>(), obj["block_id"] ?: throw SerializationException("Missing field 'block_id' for variant " + key))
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewCodeByBlockId.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.ViewCodeByBlockId(blockIdVal, accountIdVal, requestTypeVal)
              }
              "view_state_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val blockIdVal = decoder.json.decodeFromJsonElement(serializer<BlockId>(), obj["block_id"] ?: throw SerializationException("Missing field 'block_id' for variant " + key))
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val includeProofVal = obj["include_proof"]?.let { decoder.json.decodeFromJsonElement(serializer<Boolean?>(), it) }
                val prefixBase64Val = decoder.json.decodeFromJsonElement(serializer<StoreKey>(), obj["prefix_base64"] ?: throw SerializationException("Missing field 'prefix_base64' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewStateByBlockId.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.ViewStateByBlockId(blockIdVal, accountIdVal, includeProofVal, prefixBase64Val, requestTypeVal)
              }
              "view_access_key_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val blockIdVal = decoder.json.decodeFromJsonElement(serializer<BlockId>(), obj["block_id"] ?: throw SerializationException("Missing field 'block_id' for variant " + key))
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val publicKeyVal = decoder.json.decodeFromJsonElement(serializer<PublicKey>(), obj["public_key"] ?: throw SerializationException("Missing field 'public_key' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccessKeyByBlockId.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.ViewAccessKeyByBlockId(blockIdVal, accountIdVal, publicKeyVal, requestTypeVal)
              }
              "view_access_key_list_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val blockIdVal = decoder.json.decodeFromJsonElement(serializer<BlockId>(), obj["block_id"] ?: throw SerializationException("Missing field 'block_id' for variant " + key))
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccessKeyListByBlockId.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.ViewAccessKeyListByBlockId(blockIdVal, accountIdVal, requestTypeVal)
              }
              "call_function_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val blockIdVal = decoder.json.decodeFromJsonElement(serializer<BlockId>(), obj["block_id"] ?: throw SerializationException("Missing field 'block_id' for variant " + key))
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val argsBase64Val = decoder.json.decodeFromJsonElement(serializer<FunctionArgs>(), obj["args_base64"] ?: throw SerializationException("Missing field 'args_base64' for variant " + key))
                val methodNameVal = decoder.json.decodeFromJsonElement(serializer<String>(), obj["method_name"] ?: throw SerializationException("Missing field 'method_name' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.CallFunctionByBlockId.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.CallFunctionByBlockId(blockIdVal, accountIdVal, argsBase64Val, methodNameVal, requestTypeVal)
              }
              "view_global_contract_code_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val blockIdVal = decoder.json.decodeFromJsonElement(serializer<BlockId>(), obj["block_id"] ?: throw SerializationException("Missing field 'block_id' for variant " + key))
                val codeHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), obj["code_hash"] ?: throw SerializationException("Missing field 'code_hash' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeByBlockId.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.ViewGlobalContractCodeByBlockId(blockIdVal, codeHashVal, requestTypeVal)
              }
              "view_global_contract_code_by_account_id_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val blockIdVal = decoder.json.decodeFromJsonElement(serializer<BlockId>(), obj["block_id"] ?: throw SerializationException("Missing field 'block_id' for variant " + key))
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeByAccountIdByBlockId.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.ViewGlobalContractCodeByAccountIdByBlockId(blockIdVal, accountIdVal, requestTypeVal)
              }
              "view_account_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val finalityVal = decoder.json.decodeFromJsonElement(serializer<Finality>(), obj["finality"] ?: throw SerializationException("Missing field 'finality' for variant " + key))
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccountByFinality.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.ViewAccountByFinality(finalityVal, accountIdVal, requestTypeVal)
              }
              "view_code_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val finalityVal = decoder.json.decodeFromJsonElement(serializer<Finality>(), obj["finality"] ?: throw SerializationException("Missing field 'finality' for variant " + key))
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewCodeByFinality.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.ViewCodeByFinality(finalityVal, accountIdVal, requestTypeVal)
              }
              "view_state_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val finalityVal = decoder.json.decodeFromJsonElement(serializer<Finality>(), obj["finality"] ?: throw SerializationException("Missing field 'finality' for variant " + key))
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val includeProofVal = obj["include_proof"]?.let { decoder.json.decodeFromJsonElement(serializer<Boolean?>(), it) }
                val prefixBase64Val = decoder.json.decodeFromJsonElement(serializer<StoreKey>(), obj["prefix_base64"] ?: throw SerializationException("Missing field 'prefix_base64' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewStateByFinality.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.ViewStateByFinality(finalityVal, accountIdVal, includeProofVal, prefixBase64Val, requestTypeVal)
              }
              "view_access_key_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val finalityVal = decoder.json.decodeFromJsonElement(serializer<Finality>(), obj["finality"] ?: throw SerializationException("Missing field 'finality' for variant " + key))
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val publicKeyVal = decoder.json.decodeFromJsonElement(serializer<PublicKey>(), obj["public_key"] ?: throw SerializationException("Missing field 'public_key' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccessKeyByFinality.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.ViewAccessKeyByFinality(finalityVal, accountIdVal, publicKeyVal, requestTypeVal)
              }
              "view_access_key_list_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val finalityVal = decoder.json.decodeFromJsonElement(serializer<Finality>(), obj["finality"] ?: throw SerializationException("Missing field 'finality' for variant " + key))
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccessKeyListByFinality.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.ViewAccessKeyListByFinality(finalityVal, accountIdVal, requestTypeVal)
              }
              "call_function_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val finalityVal = decoder.json.decodeFromJsonElement(serializer<Finality>(), obj["finality"] ?: throw SerializationException("Missing field 'finality' for variant " + key))
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val argsBase64Val = decoder.json.decodeFromJsonElement(serializer<FunctionArgs>(), obj["args_base64"] ?: throw SerializationException("Missing field 'args_base64' for variant " + key))
                val methodNameVal = decoder.json.decodeFromJsonElement(serializer<String>(), obj["method_name"] ?: throw SerializationException("Missing field 'method_name' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.CallFunctionByFinality.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.CallFunctionByFinality(finalityVal, accountIdVal, argsBase64Val, methodNameVal, requestTypeVal)
              }
              "view_global_contract_code_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val finalityVal = decoder.json.decodeFromJsonElement(serializer<Finality>(), obj["finality"] ?: throw SerializationException("Missing field 'finality' for variant " + key))
                val codeHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), obj["code_hash"] ?: throw SerializationException("Missing field 'code_hash' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeByFinality.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.ViewGlobalContractCodeByFinality(finalityVal, codeHashVal, requestTypeVal)
              }
              "view_global_contract_code_by_account_id_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val finalityVal = decoder.json.decodeFromJsonElement(serializer<Finality>(), obj["finality"] ?: throw SerializationException("Missing field 'finality' for variant " + key))
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeByAccountIdByFinality.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.ViewGlobalContractCodeByAccountIdByFinality(finalityVal, accountIdVal, requestTypeVal)
              }
              "view_account_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val syncCheckpointVal = decoder.json.decodeFromJsonElement(serializer<SyncCheckpoint>(), obj["sync_checkpoint"] ?: throw SerializationException("Missing field 'sync_checkpoint' for variant " + key))
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccountBySyncCheckpoint.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.ViewAccountBySyncCheckpoint(syncCheckpointVal, accountIdVal, requestTypeVal)
              }
              "view_code_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val syncCheckpointVal = decoder.json.decodeFromJsonElement(serializer<SyncCheckpoint>(), obj["sync_checkpoint"] ?: throw SerializationException("Missing field 'sync_checkpoint' for variant " + key))
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewCodeBySyncCheckpoint.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.ViewCodeBySyncCheckpoint(syncCheckpointVal, accountIdVal, requestTypeVal)
              }
              "view_state_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val syncCheckpointVal = decoder.json.decodeFromJsonElement(serializer<SyncCheckpoint>(), obj["sync_checkpoint"] ?: throw SerializationException("Missing field 'sync_checkpoint' for variant " + key))
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val includeProofVal = obj["include_proof"]?.let { decoder.json.decodeFromJsonElement(serializer<Boolean?>(), it) }
                val prefixBase64Val = decoder.json.decodeFromJsonElement(serializer<StoreKey>(), obj["prefix_base64"] ?: throw SerializationException("Missing field 'prefix_base64' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewStateBySyncCheckpoint.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.ViewStateBySyncCheckpoint(syncCheckpointVal, accountIdVal, includeProofVal, prefixBase64Val, requestTypeVal)
              }
              "view_access_key_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val syncCheckpointVal = decoder.json.decodeFromJsonElement(serializer<SyncCheckpoint>(), obj["sync_checkpoint"] ?: throw SerializationException("Missing field 'sync_checkpoint' for variant " + key))
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val publicKeyVal = decoder.json.decodeFromJsonElement(serializer<PublicKey>(), obj["public_key"] ?: throw SerializationException("Missing field 'public_key' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccessKeyBySyncCheckpoint.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.ViewAccessKeyBySyncCheckpoint(syncCheckpointVal, accountIdVal, publicKeyVal, requestTypeVal)
              }
              "view_access_key_list_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val syncCheckpointVal = decoder.json.decodeFromJsonElement(serializer<SyncCheckpoint>(), obj["sync_checkpoint"] ?: throw SerializationException("Missing field 'sync_checkpoint' for variant " + key))
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewAccessKeyListBySyncCheckpoint.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.ViewAccessKeyListBySyncCheckpoint(syncCheckpointVal, accountIdVal, requestTypeVal)
              }
              "call_function_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val syncCheckpointVal = decoder.json.decodeFromJsonElement(serializer<SyncCheckpoint>(), obj["sync_checkpoint"] ?: throw SerializationException("Missing field 'sync_checkpoint' for variant " + key))
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val argsBase64Val = decoder.json.decodeFromJsonElement(serializer<FunctionArgs>(), obj["args_base64"] ?: throw SerializationException("Missing field 'args_base64' for variant " + key))
                val methodNameVal = decoder.json.decodeFromJsonElement(serializer<String>(), obj["method_name"] ?: throw SerializationException("Missing field 'method_name' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.CallFunctionBySyncCheckpoint.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.CallFunctionBySyncCheckpoint(syncCheckpointVal, accountIdVal, argsBase64Val, methodNameVal, requestTypeVal)
              }
              "view_global_contract_code_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val syncCheckpointVal = decoder.json.decodeFromJsonElement(serializer<SyncCheckpoint>(), obj["sync_checkpoint"] ?: throw SerializationException("Missing field 'sync_checkpoint' for variant " + key))
                val codeHashVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), obj["code_hash"] ?: throw SerializationException("Missing field 'code_hash' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeBySyncCheckpoint.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.ViewGlobalContractCodeBySyncCheckpoint(syncCheckpointVal, codeHashVal, requestTypeVal)
              }
              "view_global_contract_code_by_account_id_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val syncCheckpointVal = decoder.json.decodeFromJsonElement(serializer<SyncCheckpoint>(), obj["sync_checkpoint"] ?: throw SerializationException("Missing field 'sync_checkpoint' for variant " + key))
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val requestTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcQueryRequest.ViewGlobalContractCodeByAccountIdBySyncCheckpoint.RequestType>(), obj["request_type"] ?: throw SerializationException("Missing field 'request_type' for variant " + key))
                return RpcQueryRequest.ViewGlobalContractCodeByAccountIdBySyncCheckpoint(syncCheckpointVal, accountIdVal, requestTypeVal)
              }
              else -> throw SerializationException("Unknown discriminator key for RpcQueryRequest: " + key)
            }
          }
          else {
            val discriminatorCandidates = listOf("type", "name")
            var typeField: String? = null
            for (cand in discriminatorCandidates) {
              typeField = jobj[cand]?.jsonPrimitive?.contentOrNull
              if (typeField != null) break
            }
            if (typeField == null) {
              val knownVariantNames = setOf("view_account_by_block_id", "view_code_by_block_id", "view_state_by_block_id", "view_access_key_by_block_id", "view_access_key_list_by_block_id", "call_function_by_block_id", "view_global_contract_code_by_block_id", "view_global_contract_code_by_account_id_by_block_id", "view_account_by_finality", "view_code_by_finality", "view_state_by_finality", "view_access_key_by_finality", "view_access_key_list_by_finality", "call_function_by_finality", "view_global_contract_code_by_finality", "view_global_contract_code_by_account_id_by_finality", "view_account_by_sync_checkpoint", "view_code_by_sync_checkpoint", "view_state_by_sync_checkpoint", "view_access_key_by_sync_checkpoint", "view_access_key_list_by_sync_checkpoint", "call_function_by_sync_checkpoint", "view_global_contract_code_by_sync_checkpoint", "view_global_contract_code_by_account_id_by_sync_checkpoint")
              for ((k, v) in jobj.entries) {
                if (v is JsonElement && v.jsonPrimitive.isString) {
                    val s = (v as JsonElement).jsonPrimitive.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator (one of type/name) or recognizable variant in RpcQueryRequest")
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
