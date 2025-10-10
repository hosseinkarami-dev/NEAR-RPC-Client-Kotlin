package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.AccountId
import io.github.hosseinkarami_dev.near.rpc.models.AccountWithPublicKey
import io.github.hosseinkarami_dev.near.rpc.models.BlockId
import io.github.hosseinkarami_dev.near.rpc.models.Finality
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest
import io.github.hosseinkarami_dev.near.rpc.models.StoreKey
import io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint
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

public object RpcStateChangesInBlockByTypeRequestSerializer : KSerializer<RpcStateChangesInBlockByTypeRequest> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest") {
        element("account_changes_by_block_id", serializer<JsonElement>().descriptor)
        element("single_access_key_changes_by_block_id", serializer<JsonElement>().descriptor)
        element("single_gas_key_changes_by_block_id", serializer<JsonElement>().descriptor)
        element("all_access_key_changes_by_block_id", serializer<JsonElement>().descriptor)
        element("all_gas_key_changes_by_block_id", serializer<JsonElement>().descriptor)
        element("contract_code_changes_by_block_id", serializer<JsonElement>().descriptor)
        element("data_changes_by_block_id", serializer<JsonElement>().descriptor)
        element("account_changes_by_finality", serializer<JsonElement>().descriptor)
        element("single_access_key_changes_by_finality", serializer<JsonElement>().descriptor)
        element("single_gas_key_changes_by_finality", serializer<JsonElement>().descriptor)
        element("all_access_key_changes_by_finality", serializer<JsonElement>().descriptor)
        element("all_gas_key_changes_by_finality", serializer<JsonElement>().descriptor)
        element("contract_code_changes_by_finality", serializer<JsonElement>().descriptor)
        element("data_changes_by_finality", serializer<JsonElement>().descriptor)
        element("account_changes_by_sync_checkpoint", serializer<JsonElement>().descriptor)
        element("single_access_key_changes_by_sync_checkpoint", serializer<JsonElement>().descriptor)
        element("single_gas_key_changes_by_sync_checkpoint", serializer<JsonElement>().descriptor)
        element("all_access_key_changes_by_sync_checkpoint", serializer<JsonElement>().descriptor)
        element("all_gas_key_changes_by_sync_checkpoint", serializer<JsonElement>().descriptor)
        element("contract_code_changes_by_sync_checkpoint", serializer<JsonElement>().descriptor)
        element("data_changes_by_sync_checkpoint", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: RpcStateChangesInBlockByTypeRequest) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is RpcStateChangesInBlockByTypeRequest.AccountChangesByBlockId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<BlockId>(), value.blockId)
          map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccountId>()), value.accountIds)
          map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AccountChangesByBlockId.ChangesType>(), value.changesType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByBlockId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<BlockId>(), value.blockId)
          map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByBlockId.ChangesType>(), value.changesType)
          map["keys"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccountWithPublicKey>()), value.keys)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByBlockId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<BlockId>(), value.blockId)
          map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByBlockId.ChangesType>(), value.changesType)
          map["keys"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccountWithPublicKey>()), value.keys)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByBlockId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<BlockId>(), value.blockId)
          map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccountId>()), value.accountIds)
          map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByBlockId.ChangesType>(), value.changesType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByBlockId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<BlockId>(), value.blockId)
          map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccountId>()), value.accountIds)
          map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByBlockId.ChangesType>(), value.changesType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByBlockId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<BlockId>(), value.blockId)
          map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccountId>()), value.accountIds)
          map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByBlockId.ChangesType>(), value.changesType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcStateChangesInBlockByTypeRequest.DataChangesByBlockId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<BlockId>(), value.blockId)
          map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccountId>()), value.accountIds)
          map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.DataChangesByBlockId.ChangesType>(), value.changesType)
          map["key_prefix_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<StoreKey>(), value.keyPrefixBase64)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcStateChangesInBlockByTypeRequest.AccountChangesByFinality -> {
          val map = mutableMapOf<String, JsonElement>()
          map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<Finality>(), value.finality)
          map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccountId>()), value.accountIds)
          map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AccountChangesByFinality.ChangesType>(), value.changesType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByFinality -> {
          val map = mutableMapOf<String, JsonElement>()
          map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<Finality>(), value.finality)
          map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByFinality.ChangesType>(), value.changesType)
          map["keys"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccountWithPublicKey>()), value.keys)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByFinality -> {
          val map = mutableMapOf<String, JsonElement>()
          map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<Finality>(), value.finality)
          map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByFinality.ChangesType>(), value.changesType)
          map["keys"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccountWithPublicKey>()), value.keys)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByFinality -> {
          val map = mutableMapOf<String, JsonElement>()
          map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<Finality>(), value.finality)
          map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccountId>()), value.accountIds)
          map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByFinality.ChangesType>(), value.changesType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByFinality -> {
          val map = mutableMapOf<String, JsonElement>()
          map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<Finality>(), value.finality)
          map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccountId>()), value.accountIds)
          map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByFinality.ChangesType>(), value.changesType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByFinality -> {
          val map = mutableMapOf<String, JsonElement>()
          map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<Finality>(), value.finality)
          map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccountId>()), value.accountIds)
          map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByFinality.ChangesType>(), value.changesType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcStateChangesInBlockByTypeRequest.DataChangesByFinality -> {
          val map = mutableMapOf<String, JsonElement>()
          map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<Finality>(), value.finality)
          map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccountId>()), value.accountIds)
          map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.DataChangesByFinality.ChangesType>(), value.changesType)
          map["key_prefix_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<StoreKey>(), value.keyPrefixBase64)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcStateChangesInBlockByTypeRequest.AccountChangesBySyncCheckpoint -> {
          val map = mutableMapOf<String, JsonElement>()
          map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<SyncCheckpoint>(), value.syncCheckpoint)
          map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccountId>()), value.accountIds)
          map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AccountChangesBySyncCheckpoint.ChangesType>(), value.changesType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesBySyncCheckpoint -> {
          val map = mutableMapOf<String, JsonElement>()
          map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<SyncCheckpoint>(), value.syncCheckpoint)
          map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesBySyncCheckpoint.ChangesType>(), value.changesType)
          map["keys"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccountWithPublicKey>()), value.keys)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesBySyncCheckpoint -> {
          val map = mutableMapOf<String, JsonElement>()
          map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<SyncCheckpoint>(), value.syncCheckpoint)
          map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesBySyncCheckpoint.ChangesType>(), value.changesType)
          map["keys"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccountWithPublicKey>()), value.keys)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesBySyncCheckpoint -> {
          val map = mutableMapOf<String, JsonElement>()
          map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<SyncCheckpoint>(), value.syncCheckpoint)
          map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccountId>()), value.accountIds)
          map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesBySyncCheckpoint.ChangesType>(), value.changesType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesBySyncCheckpoint -> {
          val map = mutableMapOf<String, JsonElement>()
          map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<SyncCheckpoint>(), value.syncCheckpoint)
          map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccountId>()), value.accountIds)
          map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesBySyncCheckpoint.ChangesType>(), value.changesType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcStateChangesInBlockByTypeRequest.ContractCodeChangesBySyncCheckpoint -> {
          val map = mutableMapOf<String, JsonElement>()
          map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<SyncCheckpoint>(), value.syncCheckpoint)
          map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccountId>()), value.accountIds)
          map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.ContractCodeChangesBySyncCheckpoint.ChangesType>(), value.changesType)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcStateChangesInBlockByTypeRequest.DataChangesBySyncCheckpoint -> {
          val map = mutableMapOf<String, JsonElement>()
          map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<SyncCheckpoint>(), value.syncCheckpoint)
          map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccountId>()), value.accountIds)
          map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.DataChangesBySyncCheckpoint.ChangesType>(), value.changesType)
          map["key_prefix_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<StoreKey>(), value.keyPrefixBase64)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is RpcStateChangesInBlockByTypeRequest.AccountChangesByBlockId -> out.encodeSerializableElement(descriptor, 0, serializer<RpcStateChangesInBlockByTypeRequest.AccountChangesByBlockId>(), value)
      is RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByBlockId -> out.encodeSerializableElement(descriptor, 1, serializer<RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByBlockId>(), value)
      is RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByBlockId -> out.encodeSerializableElement(descriptor, 2, serializer<RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByBlockId>(), value)
      is RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByBlockId -> out.encodeSerializableElement(descriptor, 3, serializer<RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByBlockId>(), value)
      is RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByBlockId -> out.encodeSerializableElement(descriptor, 4, serializer<RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByBlockId>(), value)
      is RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByBlockId -> out.encodeSerializableElement(descriptor, 5, serializer<RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByBlockId>(), value)
      is RpcStateChangesInBlockByTypeRequest.DataChangesByBlockId -> out.encodeSerializableElement(descriptor, 6, serializer<RpcStateChangesInBlockByTypeRequest.DataChangesByBlockId>(), value)
      is RpcStateChangesInBlockByTypeRequest.AccountChangesByFinality -> out.encodeSerializableElement(descriptor, 7, serializer<RpcStateChangesInBlockByTypeRequest.AccountChangesByFinality>(), value)
      is RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByFinality -> out.encodeSerializableElement(descriptor, 8, serializer<RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByFinality>(), value)
      is RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByFinality -> out.encodeSerializableElement(descriptor, 9, serializer<RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByFinality>(), value)
      is RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByFinality -> out.encodeSerializableElement(descriptor, 10, serializer<RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByFinality>(), value)
      is RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByFinality -> out.encodeSerializableElement(descriptor, 11, serializer<RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByFinality>(), value)
      is RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByFinality -> out.encodeSerializableElement(descriptor, 12, serializer<RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByFinality>(), value)
      is RpcStateChangesInBlockByTypeRequest.DataChangesByFinality -> out.encodeSerializableElement(descriptor, 13, serializer<RpcStateChangesInBlockByTypeRequest.DataChangesByFinality>(), value)
      is RpcStateChangesInBlockByTypeRequest.AccountChangesBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 14, serializer<RpcStateChangesInBlockByTypeRequest.AccountChangesBySyncCheckpoint>(), value)
      is RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 15, serializer<RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesBySyncCheckpoint>(), value)
      is RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 16, serializer<RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesBySyncCheckpoint>(), value)
      is RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 17, serializer<RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesBySyncCheckpoint>(), value)
      is RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 18, serializer<RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesBySyncCheckpoint>(), value)
      is RpcStateChangesInBlockByTypeRequest.ContractCodeChangesBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 19, serializer<RpcStateChangesInBlockByTypeRequest.ContractCodeChangesBySyncCheckpoint>(), value)
      is RpcStateChangesInBlockByTypeRequest.DataChangesBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 20, serializer<RpcStateChangesInBlockByTypeRequest.DataChangesBySyncCheckpoint>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): RpcStateChangesInBlockByTypeRequest {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            throw SerializationException("Unknown discriminator string for RpcStateChangesInBlockByTypeRequest: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing RpcStateChangesInBlockByTypeRequest")
        }
        is JsonObject -> {
          val jobj = element
          if (listOf("account_ids", "block_id", "changes_type").all { jobj[it] != null }) {
            // ambiguous required-keys group; skipping disambiguation here to avoid wrong decode
          }
          if (listOf("block_id", "changes_type", "keys").all { jobj[it] != null }) {
            // ambiguous required-keys group; skipping disambiguation here to avoid wrong decode
          }
          if (listOf("account_ids", "block_id", "changes_type", "key_prefix_base64").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.DataChangesByBlockId>(), jobj)
          }
          if (listOf("account_ids", "changes_type", "finality").all { jobj[it] != null }) {
            // ambiguous required-keys group; skipping disambiguation here to avoid wrong decode
          }
          if (listOf("changes_type", "finality", "keys").all { jobj[it] != null }) {
            // ambiguous required-keys group; skipping disambiguation here to avoid wrong decode
          }
          if (listOf("account_ids", "changes_type", "finality", "key_prefix_base64").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.DataChangesByFinality>(), jobj)
          }
          if (listOf("account_ids", "changes_type", "sync_checkpoint").all { jobj[it] != null }) {
            // ambiguous required-keys group; skipping disambiguation here to avoid wrong decode
          }
          if (listOf("changes_type", "keys", "sync_checkpoint").all { jobj[it] != null }) {
            // ambiguous required-keys group; skipping disambiguation here to avoid wrong decode
          }
          if (listOf("account_ids", "changes_type", "key_prefix_base64", "sync_checkpoint").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.DataChangesBySyncCheckpoint>(), jobj)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "account_changes_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val blockIdVal = decoder.json.decodeFromJsonElement(serializer<BlockId>(), obj["block_id"] ?: throw SerializationException("Missing field 'block_id' for variant " + key))
                val accountIdsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountId>()), obj["account_ids"] ?: throw SerializationException("Missing field 'account_ids' for variant " + key))
                val changesTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AccountChangesByBlockId.ChangesType>(), obj["changes_type"] ?: throw SerializationException("Missing field 'changes_type' for variant " + key))
                return RpcStateChangesInBlockByTypeRequest.AccountChangesByBlockId(blockIdVal, accountIdsVal, changesTypeVal)
              }
              "single_access_key_changes_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val blockIdVal = decoder.json.decodeFromJsonElement(serializer<BlockId>(), obj["block_id"] ?: throw SerializationException("Missing field 'block_id' for variant " + key))
                val changesTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByBlockId.ChangesType>(), obj["changes_type"] ?: throw SerializationException("Missing field 'changes_type' for variant " + key))
                val keysVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountWithPublicKey>()), obj["keys"] ?: throw SerializationException("Missing field 'keys' for variant " + key))
                return RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByBlockId(blockIdVal, changesTypeVal, keysVal)
              }
              "single_gas_key_changes_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val blockIdVal = decoder.json.decodeFromJsonElement(serializer<BlockId>(), obj["block_id"] ?: throw SerializationException("Missing field 'block_id' for variant " + key))
                val changesTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByBlockId.ChangesType>(), obj["changes_type"] ?: throw SerializationException("Missing field 'changes_type' for variant " + key))
                val keysVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountWithPublicKey>()), obj["keys"] ?: throw SerializationException("Missing field 'keys' for variant " + key))
                return RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByBlockId(blockIdVal, changesTypeVal, keysVal)
              }
              "all_access_key_changes_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val blockIdVal = decoder.json.decodeFromJsonElement(serializer<BlockId>(), obj["block_id"] ?: throw SerializationException("Missing field 'block_id' for variant " + key))
                val accountIdsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountId>()), obj["account_ids"] ?: throw SerializationException("Missing field 'account_ids' for variant " + key))
                val changesTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByBlockId.ChangesType>(), obj["changes_type"] ?: throw SerializationException("Missing field 'changes_type' for variant " + key))
                return RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByBlockId(blockIdVal, accountIdsVal, changesTypeVal)
              }
              "all_gas_key_changes_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val blockIdVal = decoder.json.decodeFromJsonElement(serializer<BlockId>(), obj["block_id"] ?: throw SerializationException("Missing field 'block_id' for variant " + key))
                val accountIdsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountId>()), obj["account_ids"] ?: throw SerializationException("Missing field 'account_ids' for variant " + key))
                val changesTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByBlockId.ChangesType>(), obj["changes_type"] ?: throw SerializationException("Missing field 'changes_type' for variant " + key))
                return RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByBlockId(blockIdVal, accountIdsVal, changesTypeVal)
              }
              "contract_code_changes_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val blockIdVal = decoder.json.decodeFromJsonElement(serializer<BlockId>(), obj["block_id"] ?: throw SerializationException("Missing field 'block_id' for variant " + key))
                val accountIdsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountId>()), obj["account_ids"] ?: throw SerializationException("Missing field 'account_ids' for variant " + key))
                val changesTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByBlockId.ChangesType>(), obj["changes_type"] ?: throw SerializationException("Missing field 'changes_type' for variant " + key))
                return RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByBlockId(blockIdVal, accountIdsVal, changesTypeVal)
              }
              "data_changes_by_block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val blockIdVal = decoder.json.decodeFromJsonElement(serializer<BlockId>(), obj["block_id"] ?: throw SerializationException("Missing field 'block_id' for variant " + key))
                val accountIdsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountId>()), obj["account_ids"] ?: throw SerializationException("Missing field 'account_ids' for variant " + key))
                val changesTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.DataChangesByBlockId.ChangesType>(), obj["changes_type"] ?: throw SerializationException("Missing field 'changes_type' for variant " + key))
                val keyPrefixBase64Val = decoder.json.decodeFromJsonElement(serializer<StoreKey>(), obj["key_prefix_base64"] ?: throw SerializationException("Missing field 'key_prefix_base64' for variant " + key))
                return RpcStateChangesInBlockByTypeRequest.DataChangesByBlockId(blockIdVal, accountIdsVal, changesTypeVal, keyPrefixBase64Val)
              }
              "account_changes_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val finalityVal = decoder.json.decodeFromJsonElement(serializer<Finality>(), obj["finality"] ?: throw SerializationException("Missing field 'finality' for variant " + key))
                val accountIdsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountId>()), obj["account_ids"] ?: throw SerializationException("Missing field 'account_ids' for variant " + key))
                val changesTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AccountChangesByFinality.ChangesType>(), obj["changes_type"] ?: throw SerializationException("Missing field 'changes_type' for variant " + key))
                return RpcStateChangesInBlockByTypeRequest.AccountChangesByFinality(finalityVal, accountIdsVal, changesTypeVal)
              }
              "single_access_key_changes_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val finalityVal = decoder.json.decodeFromJsonElement(serializer<Finality>(), obj["finality"] ?: throw SerializationException("Missing field 'finality' for variant " + key))
                val changesTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByFinality.ChangesType>(), obj["changes_type"] ?: throw SerializationException("Missing field 'changes_type' for variant " + key))
                val keysVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountWithPublicKey>()), obj["keys"] ?: throw SerializationException("Missing field 'keys' for variant " + key))
                return RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByFinality(finalityVal, changesTypeVal, keysVal)
              }
              "single_gas_key_changes_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val finalityVal = decoder.json.decodeFromJsonElement(serializer<Finality>(), obj["finality"] ?: throw SerializationException("Missing field 'finality' for variant " + key))
                val changesTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByFinality.ChangesType>(), obj["changes_type"] ?: throw SerializationException("Missing field 'changes_type' for variant " + key))
                val keysVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountWithPublicKey>()), obj["keys"] ?: throw SerializationException("Missing field 'keys' for variant " + key))
                return RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByFinality(finalityVal, changesTypeVal, keysVal)
              }
              "all_access_key_changes_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val finalityVal = decoder.json.decodeFromJsonElement(serializer<Finality>(), obj["finality"] ?: throw SerializationException("Missing field 'finality' for variant " + key))
                val accountIdsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountId>()), obj["account_ids"] ?: throw SerializationException("Missing field 'account_ids' for variant " + key))
                val changesTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByFinality.ChangesType>(), obj["changes_type"] ?: throw SerializationException("Missing field 'changes_type' for variant " + key))
                return RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByFinality(finalityVal, accountIdsVal, changesTypeVal)
              }
              "all_gas_key_changes_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val finalityVal = decoder.json.decodeFromJsonElement(serializer<Finality>(), obj["finality"] ?: throw SerializationException("Missing field 'finality' for variant " + key))
                val accountIdsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountId>()), obj["account_ids"] ?: throw SerializationException("Missing field 'account_ids' for variant " + key))
                val changesTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByFinality.ChangesType>(), obj["changes_type"] ?: throw SerializationException("Missing field 'changes_type' for variant " + key))
                return RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByFinality(finalityVal, accountIdsVal, changesTypeVal)
              }
              "contract_code_changes_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val finalityVal = decoder.json.decodeFromJsonElement(serializer<Finality>(), obj["finality"] ?: throw SerializationException("Missing field 'finality' for variant " + key))
                val accountIdsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountId>()), obj["account_ids"] ?: throw SerializationException("Missing field 'account_ids' for variant " + key))
                val changesTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByFinality.ChangesType>(), obj["changes_type"] ?: throw SerializationException("Missing field 'changes_type' for variant " + key))
                return RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByFinality(finalityVal, accountIdsVal, changesTypeVal)
              }
              "data_changes_by_finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val finalityVal = decoder.json.decodeFromJsonElement(serializer<Finality>(), obj["finality"] ?: throw SerializationException("Missing field 'finality' for variant " + key))
                val accountIdsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountId>()), obj["account_ids"] ?: throw SerializationException("Missing field 'account_ids' for variant " + key))
                val changesTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.DataChangesByFinality.ChangesType>(), obj["changes_type"] ?: throw SerializationException("Missing field 'changes_type' for variant " + key))
                val keyPrefixBase64Val = decoder.json.decodeFromJsonElement(serializer<StoreKey>(), obj["key_prefix_base64"] ?: throw SerializationException("Missing field 'key_prefix_base64' for variant " + key))
                return RpcStateChangesInBlockByTypeRequest.DataChangesByFinality(finalityVal, accountIdsVal, changesTypeVal, keyPrefixBase64Val)
              }
              "account_changes_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val syncCheckpointVal = decoder.json.decodeFromJsonElement(serializer<SyncCheckpoint>(), obj["sync_checkpoint"] ?: throw SerializationException("Missing field 'sync_checkpoint' for variant " + key))
                val accountIdsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountId>()), obj["account_ids"] ?: throw SerializationException("Missing field 'account_ids' for variant " + key))
                val changesTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AccountChangesBySyncCheckpoint.ChangesType>(), obj["changes_type"] ?: throw SerializationException("Missing field 'changes_type' for variant " + key))
                return RpcStateChangesInBlockByTypeRequest.AccountChangesBySyncCheckpoint(syncCheckpointVal, accountIdsVal, changesTypeVal)
              }
              "single_access_key_changes_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val syncCheckpointVal = decoder.json.decodeFromJsonElement(serializer<SyncCheckpoint>(), obj["sync_checkpoint"] ?: throw SerializationException("Missing field 'sync_checkpoint' for variant " + key))
                val changesTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesBySyncCheckpoint.ChangesType>(), obj["changes_type"] ?: throw SerializationException("Missing field 'changes_type' for variant " + key))
                val keysVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountWithPublicKey>()), obj["keys"] ?: throw SerializationException("Missing field 'keys' for variant " + key))
                return RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesBySyncCheckpoint(syncCheckpointVal, changesTypeVal, keysVal)
              }
              "single_gas_key_changes_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val syncCheckpointVal = decoder.json.decodeFromJsonElement(serializer<SyncCheckpoint>(), obj["sync_checkpoint"] ?: throw SerializationException("Missing field 'sync_checkpoint' for variant " + key))
                val changesTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesBySyncCheckpoint.ChangesType>(), obj["changes_type"] ?: throw SerializationException("Missing field 'changes_type' for variant " + key))
                val keysVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountWithPublicKey>()), obj["keys"] ?: throw SerializationException("Missing field 'keys' for variant " + key))
                return RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesBySyncCheckpoint(syncCheckpointVal, changesTypeVal, keysVal)
              }
              "all_access_key_changes_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val syncCheckpointVal = decoder.json.decodeFromJsonElement(serializer<SyncCheckpoint>(), obj["sync_checkpoint"] ?: throw SerializationException("Missing field 'sync_checkpoint' for variant " + key))
                val accountIdsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountId>()), obj["account_ids"] ?: throw SerializationException("Missing field 'account_ids' for variant " + key))
                val changesTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesBySyncCheckpoint.ChangesType>(), obj["changes_type"] ?: throw SerializationException("Missing field 'changes_type' for variant " + key))
                return RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesBySyncCheckpoint(syncCheckpointVal, accountIdsVal, changesTypeVal)
              }
              "all_gas_key_changes_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val syncCheckpointVal = decoder.json.decodeFromJsonElement(serializer<SyncCheckpoint>(), obj["sync_checkpoint"] ?: throw SerializationException("Missing field 'sync_checkpoint' for variant " + key))
                val accountIdsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountId>()), obj["account_ids"] ?: throw SerializationException("Missing field 'account_ids' for variant " + key))
                val changesTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesBySyncCheckpoint.ChangesType>(), obj["changes_type"] ?: throw SerializationException("Missing field 'changes_type' for variant " + key))
                return RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesBySyncCheckpoint(syncCheckpointVal, accountIdsVal, changesTypeVal)
              }
              "contract_code_changes_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val syncCheckpointVal = decoder.json.decodeFromJsonElement(serializer<SyncCheckpoint>(), obj["sync_checkpoint"] ?: throw SerializationException("Missing field 'sync_checkpoint' for variant " + key))
                val accountIdsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountId>()), obj["account_ids"] ?: throw SerializationException("Missing field 'account_ids' for variant " + key))
                val changesTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.ContractCodeChangesBySyncCheckpoint.ChangesType>(), obj["changes_type"] ?: throw SerializationException("Missing field 'changes_type' for variant " + key))
                return RpcStateChangesInBlockByTypeRequest.ContractCodeChangesBySyncCheckpoint(syncCheckpointVal, accountIdsVal, changesTypeVal)
              }
              "data_changes_by_sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val syncCheckpointVal = decoder.json.decodeFromJsonElement(serializer<SyncCheckpoint>(), obj["sync_checkpoint"] ?: throw SerializationException("Missing field 'sync_checkpoint' for variant " + key))
                val accountIdsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountId>()), obj["account_ids"] ?: throw SerializationException("Missing field 'account_ids' for variant " + key))
                val changesTypeVal = decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.DataChangesBySyncCheckpoint.ChangesType>(), obj["changes_type"] ?: throw SerializationException("Missing field 'changes_type' for variant " + key))
                val keyPrefixBase64Val = decoder.json.decodeFromJsonElement(serializer<StoreKey>(), obj["key_prefix_base64"] ?: throw SerializationException("Missing field 'key_prefix_base64' for variant " + key))
                return RpcStateChangesInBlockByTypeRequest.DataChangesBySyncCheckpoint(syncCheckpointVal, accountIdsVal, changesTypeVal, keyPrefixBase64Val)
              }
              else -> throw SerializationException("Unknown discriminator key for RpcStateChangesInBlockByTypeRequest: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("account_changes_by_block_id", "single_access_key_changes_by_block_id", "single_gas_key_changes_by_block_id", "all_access_key_changes_by_block_id", "all_gas_key_changes_by_block_id", "contract_code_changes_by_block_id", "data_changes_by_block_id", "account_changes_by_finality", "single_access_key_changes_by_finality", "single_gas_key_changes_by_finality", "all_access_key_changes_by_finality", "all_gas_key_changes_by_finality", "contract_code_changes_by_finality", "data_changes_by_finality", "account_changes_by_sync_checkpoint", "single_access_key_changes_by_sync_checkpoint", "single_gas_key_changes_by_sync_checkpoint", "all_access_key_changes_by_sync_checkpoint", "all_gas_key_changes_by_sync_checkpoint", "contract_code_changes_by_sync_checkpoint", "data_changes_by_sync_checkpoint")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in RpcStateChangesInBlockByTypeRequest")
            val tf = typeField.trim()
            when (tf) {
              "account_changes_by_block_id" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AccountChangesByBlockId>(), jobj)
              }
              "single_access_key_changes_by_block_id" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByBlockId>(), jobj)
              }
              "single_gas_key_changes_by_block_id" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByBlockId>(), jobj)
              }
              "all_access_key_changes_by_block_id" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByBlockId>(), jobj)
              }
              "all_gas_key_changes_by_block_id" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByBlockId>(), jobj)
              }
              "contract_code_changes_by_block_id" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByBlockId>(), jobj)
              }
              "data_changes_by_block_id" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.DataChangesByBlockId>(), jobj)
              }
              "account_changes_by_finality" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AccountChangesByFinality>(), jobj)
              }
              "single_access_key_changes_by_finality" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByFinality>(), jobj)
              }
              "single_gas_key_changes_by_finality" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByFinality>(), jobj)
              }
              "all_access_key_changes_by_finality" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByFinality>(), jobj)
              }
              "all_gas_key_changes_by_finality" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByFinality>(), jobj)
              }
              "contract_code_changes_by_finality" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByFinality>(), jobj)
              }
              "data_changes_by_finality" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.DataChangesByFinality>(), jobj)
              }
              "account_changes_by_sync_checkpoint" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AccountChangesBySyncCheckpoint>(), jobj)
              }
              "single_access_key_changes_by_sync_checkpoint" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesBySyncCheckpoint>(), jobj)
              }
              "single_gas_key_changes_by_sync_checkpoint" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesBySyncCheckpoint>(), jobj)
              }
              "all_access_key_changes_by_sync_checkpoint" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesBySyncCheckpoint>(), jobj)
              }
              "all_gas_key_changes_by_sync_checkpoint" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesBySyncCheckpoint>(), jobj)
              }
              "contract_code_changes_by_sync_checkpoint" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.ContractCodeChangesBySyncCheckpoint>(), jobj)
              }
              "data_changes_by_sync_checkpoint" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockByTypeRequest.DataChangesBySyncCheckpoint>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for RpcStateChangesInBlockByTypeRequest: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize RpcStateChangesInBlockByTypeRequest with non-JSON decoder")
  }
}
