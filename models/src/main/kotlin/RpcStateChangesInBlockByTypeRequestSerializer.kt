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
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest
import kotlinx.serialization.json.*

object RpcStateChangesInBlockByTypeRequestSerializer : KSerializer<RpcStateChangesInBlockByTypeRequest> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest") {
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

    override fun serialize(encoder: Encoder, value: RpcStateChangesInBlockByTypeRequest) {
        if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesByBlockId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>(), value.blockId)
                    map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>()), value.accountIds)
                    map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesByBlockId.ChangesType>(), value.changesType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByBlockId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>(), value.blockId)
                    map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByBlockId.ChangesType>(), value.changesType)
                    map["keys"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountWithPublicKey>()), value.keys)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByBlockId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>(), value.blockId)
                    map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByBlockId.ChangesType>(), value.changesType)
                    map["keys"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountWithPublicKey>()), value.keys)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByBlockId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>(), value.blockId)
                    map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>()), value.accountIds)
                    map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByBlockId.ChangesType>(), value.changesType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByBlockId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>(), value.blockId)
                    map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>()), value.accountIds)
                    map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByBlockId.ChangesType>(), value.changesType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByBlockId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>(), value.blockId)
                    map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>()), value.accountIds)
                    map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByBlockId.ChangesType>(), value.changesType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesByBlockId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>(), value.blockId)
                    map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>()), value.accountIds)
                    map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesByBlockId.ChangesType>(), value.changesType)
                    map["key_prefix_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StoreKey>(), value.keyPrefixBase64)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesByFinality -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.Finality>(), value.finality)
                    map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>()), value.accountIds)
                    map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesByFinality.ChangesType>(), value.changesType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByFinality -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.Finality>(), value.finality)
                    map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByFinality.ChangesType>(), value.changesType)
                    map["keys"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountWithPublicKey>()), value.keys)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByFinality -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.Finality>(), value.finality)
                    map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByFinality.ChangesType>(), value.changesType)
                    map["keys"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountWithPublicKey>()), value.keys)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByFinality -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.Finality>(), value.finality)
                    map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>()), value.accountIds)
                    map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByFinality.ChangesType>(), value.changesType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByFinality -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.Finality>(), value.finality)
                    map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>()), value.accountIds)
                    map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByFinality.ChangesType>(), value.changesType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByFinality -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.Finality>(), value.finality)
                    map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>()), value.accountIds)
                    map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByFinality.ChangesType>(), value.changesType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesByFinality -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.Finality>(), value.finality)
                    map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>()), value.accountIds)
                    map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesByFinality.ChangesType>(), value.changesType)
                    map["key_prefix_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StoreKey>(), value.keyPrefixBase64)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesBySyncCheckpoint -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint>(), value.syncCheckpoint)
                    map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>()), value.accountIds)
                    map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesBySyncCheckpoint.ChangesType>(), value.changesType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesBySyncCheckpoint -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint>(), value.syncCheckpoint)
                    map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesBySyncCheckpoint.ChangesType>(), value.changesType)
                    map["keys"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountWithPublicKey>()), value.keys)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesBySyncCheckpoint -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint>(), value.syncCheckpoint)
                    map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesBySyncCheckpoint.ChangesType>(), value.changesType)
                    map["keys"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountWithPublicKey>()), value.keys)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesBySyncCheckpoint -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint>(), value.syncCheckpoint)
                    map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>()), value.accountIds)
                    map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesBySyncCheckpoint.ChangesType>(), value.changesType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesBySyncCheckpoint -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint>(), value.syncCheckpoint)
                    map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>()), value.accountIds)
                    map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesBySyncCheckpoint.ChangesType>(), value.changesType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesBySyncCheckpoint -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint>(), value.syncCheckpoint)
                    map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>()), value.accountIds)
                    map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesBySyncCheckpoint.ChangesType>(), value.changesType)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesBySyncCheckpoint -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint>(), value.syncCheckpoint)
                    map["account_ids"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>()), value.accountIds)
                    map["changes_type"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesBySyncCheckpoint.ChangesType>(), value.changesType)
                    map["key_prefix_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.StoreKey>(), value.keyPrefixBase64)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesByBlockId -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesByBlockId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByBlockId -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByBlockId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByBlockId -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByBlockId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByBlockId -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByBlockId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByBlockId -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByBlockId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByBlockId -> out.encodeSerializableElement(descriptor, 5, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByBlockId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesByBlockId -> out.encodeSerializableElement(descriptor, 6, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesByBlockId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesByFinality -> out.encodeSerializableElement(descriptor, 7, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesByFinality>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByFinality -> out.encodeSerializableElement(descriptor, 8, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByFinality>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByFinality -> out.encodeSerializableElement(descriptor, 9, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByFinality>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByFinality -> out.encodeSerializableElement(descriptor, 10, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByFinality>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByFinality -> out.encodeSerializableElement(descriptor, 11, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByFinality>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByFinality -> out.encodeSerializableElement(descriptor, 12, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByFinality>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesByFinality -> out.encodeSerializableElement(descriptor, 13, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesByFinality>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 14, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesBySyncCheckpoint>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 15, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesBySyncCheckpoint>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 16, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesBySyncCheckpoint>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 17, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesBySyncCheckpoint>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 18, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesBySyncCheckpoint>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 19, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesBySyncCheckpoint>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesBySyncCheckpoint -> out.encodeSerializableElement(descriptor, 20, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesBySyncCheckpoint>(), value)
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
                    }
                    throw SerializationException("Unknown discriminator (primitive) for RpcStateChangesInBlockByTypeRequest")
                }
                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing RpcStateChangesInBlockByTypeRequest")
                is JsonObject -> {
                    val jobj = element
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "account_changes_by_block_id" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant account_changes_by_block_id: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesByBlockId>(), obj)
                            }
                            "single_access_key_changes_by_block_id" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant single_access_key_changes_by_block_id: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByBlockId>(), obj)
                            }
                            "single_gas_key_changes_by_block_id" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant single_gas_key_changes_by_block_id: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByBlockId>(), obj)
                            }
                            "all_access_key_changes_by_block_id" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant all_access_key_changes_by_block_id: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByBlockId>(), obj)
                            }
                            "all_gas_key_changes_by_block_id" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant all_gas_key_changes_by_block_id: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByBlockId>(), obj)
                            }
                            "contract_code_changes_by_block_id" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant contract_code_changes_by_block_id: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByBlockId>(), obj)
                            }
                            "data_changes_by_block_id" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant data_changes_by_block_id: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesByBlockId>(), obj)
                            }
                            "account_changes_by_finality" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant account_changes_by_finality: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesByFinality>(), obj)
                            }
                            "single_access_key_changes_by_finality" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant single_access_key_changes_by_finality: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByFinality>(), obj)
                            }
                            "single_gas_key_changes_by_finality" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant single_gas_key_changes_by_finality: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByFinality>(), obj)
                            }
                            "all_access_key_changes_by_finality" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant all_access_key_changes_by_finality: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByFinality>(), obj)
                            }
                            "all_gas_key_changes_by_finality" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant all_gas_key_changes_by_finality: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByFinality>(), obj)
                            }
                            "contract_code_changes_by_finality" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant contract_code_changes_by_finality: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByFinality>(), obj)
                            }
                            "data_changes_by_finality" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant data_changes_by_finality: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesByFinality>(), obj)
                            }
                            "account_changes_by_sync_checkpoint" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant account_changes_by_sync_checkpoint: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesBySyncCheckpoint>(), obj)
                            }
                            "single_access_key_changes_by_sync_checkpoint" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant single_access_key_changes_by_sync_checkpoint: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesBySyncCheckpoint>(), obj)
                            }
                            "single_gas_key_changes_by_sync_checkpoint" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant single_gas_key_changes_by_sync_checkpoint: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesBySyncCheckpoint>(), obj)
                            }
                            "all_access_key_changes_by_sync_checkpoint" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant all_access_key_changes_by_sync_checkpoint: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesBySyncCheckpoint>(), obj)
                            }
                            "all_gas_key_changes_by_sync_checkpoint" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant all_gas_key_changes_by_sync_checkpoint: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesBySyncCheckpoint>(), obj)
                            }
                            "contract_code_changes_by_sync_checkpoint" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant contract_code_changes_by_sync_checkpoint: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesBySyncCheckpoint>(), obj)
                            }
                            "data_changes_by_sync_checkpoint" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant data_changes_by_sync_checkpoint: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesBySyncCheckpoint>(), obj)
                            }
                            else -> throw SerializationException("Unknown discriminator key for RpcStateChangesInBlockByTypeRequest: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("changes_type")
                    for (cand in discriminatorCandidates) {
                        val candElem = jobj[cand]
                        if (candElem is JsonPrimitive) {
                            typeField = candElem.contentOrNull
                            if (typeField != null) break
                        }
                    }
                    if (typeField == null) {
                        val knownVariantNames = setOf("account_changes_by_block_id", "single_access_key_changes_by_block_id", "single_gas_key_changes_by_block_id", "all_access_key_changes_by_block_id", "all_gas_key_changes_by_block_id", "contract_code_changes_by_block_id", "data_changes_by_block_id", "account_changes_by_finality", "single_access_key_changes_by_finality", "single_gas_key_changes_by_finality", "all_access_key_changes_by_finality", "all_gas_key_changes_by_finality", "contract_code_changes_by_finality", "data_changes_by_finality", "account_changes_by_sync_checkpoint", "single_access_key_changes_by_sync_checkpoint", "single_gas_key_changes_by_sync_checkpoint", "all_access_key_changes_by_sync_checkpoint", "all_gas_key_changes_by_sync_checkpoint", "contract_code_changes_by_sync_checkpoint", "data_changes_by_sync_checkpoint")
                        for ((k, v) in jobj.entries) {
                            if (v is JsonPrimitive && v.isString) {
                                val s = v.content
                                if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
                            }
                        }
                    }
                    if (typeField == null) throw SerializationException("Missing discriminator (one of changes_type) or recognizable variant in RpcStateChangesInBlockByTypeRequest")
                    val tf = typeField.trim()

                    // try exact match of full variant name first
                    val tfFull = tf
                    when (tfFull) {
                        "account_changes_by_block_id" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesByBlockId>(), jobj)
                        "single_access_key_changes_by_block_id" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByBlockId>(), jobj)
                        "single_gas_key_changes_by_block_id" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByBlockId>(), jobj)
                        "all_access_key_changes_by_block_id" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByBlockId>(), jobj)
                        "all_gas_key_changes_by_block_id" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByBlockId>(), jobj)
                        "contract_code_changes_by_block_id" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByBlockId>(), jobj)
                        "data_changes_by_block_id" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesByBlockId>(), jobj)
                        "account_changes_by_finality" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesByFinality>(), jobj)
                        "single_access_key_changes_by_finality" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByFinality>(), jobj)
                        "single_gas_key_changes_by_finality" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByFinality>(), jobj)
                        "all_access_key_changes_by_finality" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByFinality>(), jobj)
                        "all_gas_key_changes_by_finality" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByFinality>(), jobj)
                        "contract_code_changes_by_finality" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByFinality>(), jobj)
                        "data_changes_by_finality" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesByFinality>(), jobj)
                        "account_changes_by_sync_checkpoint" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesBySyncCheckpoint>(), jobj)
                        "single_access_key_changes_by_sync_checkpoint" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesBySyncCheckpoint>(), jobj)
                        "single_gas_key_changes_by_sync_checkpoint" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesBySyncCheckpoint>(), jobj)
                        "all_access_key_changes_by_sync_checkpoint" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesBySyncCheckpoint>(), jobj)
                        "all_gas_key_changes_by_sync_checkpoint" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesBySyncCheckpoint>(), jobj)
                        "contract_code_changes_by_sync_checkpoint" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesBySyncCheckpoint>(), jobj)
                        "data_changes_by_sync_checkpoint" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesBySyncCheckpoint>(), jobj)
                        else -> { /* fallthrough to grouped handling */ }
                    }

                    // grouped handling by base token (e.g. account_changes -> ...by_block_id / ...by_finality / ...by_sync_checkpoint)
                    val tfLower = tf.lowercase()
                    // select candidate group based on contains/equals heuristics
                    var chosenGroupKey: String? = null
                    if (chosenGroupKey == null && ("account_changes".lowercase() == tfLower || tfLower.contains("account_changes".lowercase()) || "account_changes".lowercase().contains(tfLower))) { chosenGroupKey = "account_changes" }
                    if (chosenGroupKey == null && ("single_access_key_changes".lowercase() == tfLower || tfLower.contains("single_access_key_changes".lowercase()) || "single_access_key_changes".lowercase().contains(tfLower))) { chosenGroupKey = "single_access_key_changes" }
                    if (chosenGroupKey == null && ("single_gas_key_changes".lowercase() == tfLower || tfLower.contains("single_gas_key_changes".lowercase()) || "single_gas_key_changes".lowercase().contains(tfLower))) { chosenGroupKey = "single_gas_key_changes" }
                    if (chosenGroupKey == null && ("all_access_key_changes".lowercase() == tfLower || tfLower.contains("all_access_key_changes".lowercase()) || "all_access_key_changes".lowercase().contains(tfLower))) { chosenGroupKey = "all_access_key_changes" }
                    if (chosenGroupKey == null && ("all_gas_key_changes".lowercase() == tfLower || tfLower.contains("all_gas_key_changes".lowercase()) || "all_gas_key_changes".lowercase().contains(tfLower))) { chosenGroupKey = "all_gas_key_changes" }
                    if (chosenGroupKey == null && ("contract_code_changes".lowercase() == tfLower || tfLower.contains("contract_code_changes".lowercase()) || "contract_code_changes".lowercase().contains(tfLower))) { chosenGroupKey = "contract_code_changes" }
                    if (chosenGroupKey == null && ("data_changes".lowercase() == tfLower || tfLower.contains("data_changes".lowercase()) || "data_changes".lowercase().contains(tfLower))) { chosenGroupKey = "data_changes" }
                    if (chosenGroupKey != null) {
                        when (chosenGroupKey) {
                            "account_changes" -> {
                                if (jobj["block_id"] != null) return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesByBlockId>(), jobj)
                                if (jobj["finality"] != null) return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesByFinality>(), jobj)
                                if (jobj["sync_checkpoint"] != null) return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesBySyncCheckpoint>(), jobj)
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesByBlockId>(), jobj) } catch (_: Exception) { }
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesByFinality>(), jobj) } catch (_: Exception) { }
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'account_changes' and tf='$tf'")
                            }
                            "single_access_key_changes" -> {
                                if (jobj["block_id"] != null) return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByBlockId>(), jobj)
                                if (jobj["finality"] != null) return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByFinality>(), jobj)
                                if (jobj["sync_checkpoint"] != null) return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesBySyncCheckpoint>(), jobj)
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByBlockId>(), jobj) } catch (_: Exception) { }
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByFinality>(), jobj) } catch (_: Exception) { }
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'single_access_key_changes' and tf='$tf'")
                            }
                            "single_gas_key_changes" -> {
                                if (jobj["block_id"] != null) return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByBlockId>(), jobj)
                                if (jobj["finality"] != null) return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByFinality>(), jobj)
                                if (jobj["sync_checkpoint"] != null) return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesBySyncCheckpoint>(), jobj)
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByBlockId>(), jobj) } catch (_: Exception) { }
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByFinality>(), jobj) } catch (_: Exception) { }
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'single_gas_key_changes' and tf='$tf'")
                            }
                            "all_access_key_changes" -> {
                                if (jobj["block_id"] != null) return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByBlockId>(), jobj)
                                if (jobj["finality"] != null) return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByFinality>(), jobj)
                                if (jobj["sync_checkpoint"] != null) return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesBySyncCheckpoint>(), jobj)
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByBlockId>(), jobj) } catch (_: Exception) { }
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByFinality>(), jobj) } catch (_: Exception) { }
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'all_access_key_changes' and tf='$tf'")
                            }
                            "all_gas_key_changes" -> {
                                if (jobj["block_id"] != null) return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByBlockId>(), jobj)
                                if (jobj["finality"] != null) return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByFinality>(), jobj)
                                if (jobj["sync_checkpoint"] != null) return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesBySyncCheckpoint>(), jobj)
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByBlockId>(), jobj) } catch (_: Exception) { }
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByFinality>(), jobj) } catch (_: Exception) { }
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'all_gas_key_changes' and tf='$tf'")
                            }
                            "contract_code_changes" -> {
                                if (jobj["block_id"] != null) return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByBlockId>(), jobj)
                                if (jobj["finality"] != null) return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByFinality>(), jobj)
                                if (jobj["sync_checkpoint"] != null) return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesBySyncCheckpoint>(), jobj)
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByBlockId>(), jobj) } catch (_: Exception) { }
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByFinality>(), jobj) } catch (_: Exception) { }
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'contract_code_changes' and tf='$tf'")
                            }
                            "data_changes" -> {
                                if (jobj["block_id"] != null) return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesByBlockId>(), jobj)
                                if (jobj["finality"] != null) return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesByFinality>(), jobj)
                                if (jobj["sync_checkpoint"] != null) return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesBySyncCheckpoint>(), jobj)
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesByBlockId>(), jobj) } catch (_: Exception) { }
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesByFinality>(), jobj) } catch (_: Exception) { }
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'data_changes' and tf='$tf'")
                            }
                            else -> { /* no group matched */ }
                        }
                    }

                    // fallback: try required-field matching and scoring heuristics
                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("block_id") && jobj.containsKey("account_ids") && jobj.containsKey("changes_type")) requiredMatches.add(0)
                    if (jobj.containsKey("block_id") && jobj.containsKey("changes_type") && jobj.containsKey("keys")) requiredMatches.add(1)
                    if (jobj.containsKey("block_id") && jobj.containsKey("changes_type") && jobj.containsKey("keys")) requiredMatches.add(2)
                    if (jobj.containsKey("block_id") && jobj.containsKey("account_ids") && jobj.containsKey("changes_type")) requiredMatches.add(3)
                    if (jobj.containsKey("block_id") && jobj.containsKey("account_ids") && jobj.containsKey("changes_type")) requiredMatches.add(4)
                    if (jobj.containsKey("block_id") && jobj.containsKey("account_ids") && jobj.containsKey("changes_type")) requiredMatches.add(5)
                    if (jobj.containsKey("block_id") && jobj.containsKey("account_ids") && jobj.containsKey("changes_type") && jobj.containsKey("key_prefix_base64")) requiredMatches.add(6)
                    if (jobj.containsKey("finality") && jobj.containsKey("account_ids") && jobj.containsKey("changes_type")) requiredMatches.add(7)
                    if (jobj.containsKey("finality") && jobj.containsKey("changes_type") && jobj.containsKey("keys")) requiredMatches.add(8)
                    if (jobj.containsKey("finality") && jobj.containsKey("changes_type") && jobj.containsKey("keys")) requiredMatches.add(9)
                    if (jobj.containsKey("finality") && jobj.containsKey("account_ids") && jobj.containsKey("changes_type")) requiredMatches.add(10)
                    if (jobj.containsKey("finality") && jobj.containsKey("account_ids") && jobj.containsKey("changes_type")) requiredMatches.add(11)
                    if (jobj.containsKey("finality") && jobj.containsKey("account_ids") && jobj.containsKey("changes_type")) requiredMatches.add(12)
                    if (jobj.containsKey("finality") && jobj.containsKey("account_ids") && jobj.containsKey("changes_type") && jobj.containsKey("key_prefix_base64")) requiredMatches.add(13)
                    if (jobj.containsKey("sync_checkpoint") && jobj.containsKey("account_ids") && jobj.containsKey("changes_type")) requiredMatches.add(14)
                    if (jobj.containsKey("sync_checkpoint") && jobj.containsKey("changes_type") && jobj.containsKey("keys")) requiredMatches.add(15)
                    if (jobj.containsKey("sync_checkpoint") && jobj.containsKey("changes_type") && jobj.containsKey("keys")) requiredMatches.add(16)
                    if (jobj.containsKey("sync_checkpoint") && jobj.containsKey("account_ids") && jobj.containsKey("changes_type")) requiredMatches.add(17)
                    if (jobj.containsKey("sync_checkpoint") && jobj.containsKey("account_ids") && jobj.containsKey("changes_type")) requiredMatches.add(18)
                    if (jobj.containsKey("sync_checkpoint") && jobj.containsKey("account_ids") && jobj.containsKey("changes_type")) requiredMatches.add(19)
                    if (jobj.containsKey("sync_checkpoint") && jobj.containsKey("account_ids") && jobj.containsKey("changes_type") && jobj.containsKey("key_prefix_base64")) requiredMatches.add(20)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesByBlockId>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByBlockId>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByBlockId>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByBlockId>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByBlockId>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByBlockId>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesByBlockId>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesByFinality>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByFinality>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByFinality>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByFinality>(), jobj)
                            11 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByFinality>(), jobj)
                            12 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByFinality>(), jobj)
                            13 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesByFinality>(), jobj)
                            14 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesBySyncCheckpoint>(), jobj)
                            15 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesBySyncCheckpoint>(), jobj)
                            16 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesBySyncCheckpoint>(), jobj)
                            17 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesBySyncCheckpoint>(), jobj)
                            18 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesBySyncCheckpoint>(), jobj)
                            19 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesBySyncCheckpoint>(), jobj)
                            20 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesBySyncCheckpoint>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["block_id"] != null) matchCount++
                        if (jobj["account_ids"] != null) matchCount++
                        if (jobj["changes_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["block_id"] != null) matchCount++
                        if (jobj["changes_type"] != null) matchCount++
                        if (jobj["keys"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["block_id"] != null) matchCount++
                        if (jobj["changes_type"] != null) matchCount++
                        if (jobj["keys"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["block_id"] != null) matchCount++
                        if (jobj["account_ids"] != null) matchCount++
                        if (jobj["changes_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 3 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["block_id"] != null) matchCount++
                        if (jobj["account_ids"] != null) matchCount++
                        if (jobj["changes_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 4 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["block_id"] != null) matchCount++
                        if (jobj["account_ids"] != null) matchCount++
                        if (jobj["changes_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 5 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["block_id"] != null) matchCount++
                        if (jobj["account_ids"] != null) matchCount++
                        if (jobj["changes_type"] != null) matchCount++
                        if (jobj["key_prefix_base64"] != null) matchCount++
                        val score = matchCount.toDouble() / 4.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 6 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["finality"] != null) matchCount++
                        if (jobj["account_ids"] != null) matchCount++
                        if (jobj["changes_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 7 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["finality"] != null) matchCount++
                        if (jobj["changes_type"] != null) matchCount++
                        if (jobj["keys"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 8 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["finality"] != null) matchCount++
                        if (jobj["changes_type"] != null) matchCount++
                        if (jobj["keys"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 9 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["finality"] != null) matchCount++
                        if (jobj["account_ids"] != null) matchCount++
                        if (jobj["changes_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 10 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["finality"] != null) matchCount++
                        if (jobj["account_ids"] != null) matchCount++
                        if (jobj["changes_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 11 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["finality"] != null) matchCount++
                        if (jobj["account_ids"] != null) matchCount++
                        if (jobj["changes_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 12 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["finality"] != null) matchCount++
                        if (jobj["account_ids"] != null) matchCount++
                        if (jobj["changes_type"] != null) matchCount++
                        if (jobj["key_prefix_base64"] != null) matchCount++
                        val score = matchCount.toDouble() / 4.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 13 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["sync_checkpoint"] != null) matchCount++
                        if (jobj["account_ids"] != null) matchCount++
                        if (jobj["changes_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 14 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["sync_checkpoint"] != null) matchCount++
                        if (jobj["changes_type"] != null) matchCount++
                        if (jobj["keys"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 15 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["sync_checkpoint"] != null) matchCount++
                        if (jobj["changes_type"] != null) matchCount++
                        if (jobj["keys"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 16 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["sync_checkpoint"] != null) matchCount++
                        if (jobj["account_ids"] != null) matchCount++
                        if (jobj["changes_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 17 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["sync_checkpoint"] != null) matchCount++
                        if (jobj["account_ids"] != null) matchCount++
                        if (jobj["changes_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 18 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["sync_checkpoint"] != null) matchCount++
                        if (jobj["account_ids"] != null) matchCount++
                        if (jobj["changes_type"] != null) matchCount++
                        val score = matchCount.toDouble() / 3.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 19 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["sync_checkpoint"] != null) matchCount++
                        if (jobj["account_ids"] != null) matchCount++
                        if (jobj["changes_type"] != null) matchCount++
                        if (jobj["key_prefix_base64"] != null) matchCount++
                        val score = matchCount.toDouble() / 4.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 20 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesByBlockId>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByBlockId>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByBlockId>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByBlockId>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByBlockId>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByBlockId>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesByBlockId>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesByFinality>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByFinality>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByFinality>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByFinality>(), jobj)
                            11 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByFinality>(), jobj)
                            12 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByFinality>(), jobj)
                            13 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesByFinality>(), jobj)
                            14 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesBySyncCheckpoint>(), jobj)
                            15 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesBySyncCheckpoint>(), jobj)
                            16 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesBySyncCheckpoint>(), jobj)
                            17 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesBySyncCheckpoint>(), jobj)
                            18 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesBySyncCheckpoint>(), jobj)
                            19 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesBySyncCheckpoint>(), jobj)
                            20 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesBySyncCheckpoint>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    // last resort: try decoding each data-class variant
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesByBlockId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByBlockId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByBlockId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByBlockId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByBlockId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByBlockId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesByBlockId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesByFinality>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesByFinality>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesByFinality>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesByFinality>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesByFinality>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesByFinality>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesByFinality>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AccountChangesBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleAccessKeyChangesBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.SingleGasKeyChangesBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllAccessKeyChangesBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.AllGasKeyChangesBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.ContractCodeChangesBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.DataChangesBySyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in RpcStateChangesInBlockByTypeRequest")
                }
            }
        }
        throw SerializationException("Cannot deserialize RpcStateChangesInBlockByTypeRequest with non-JSON decoder")
    }
}
