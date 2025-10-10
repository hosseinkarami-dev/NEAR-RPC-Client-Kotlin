package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.BlockId
import io.github.hosseinkarami_dev.near.rpc.models.Finality
import io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest
import io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint
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

public object RpcProtocolConfigRequestSerializer : KSerializer<RpcProtocolConfigRequest> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest")

  override fun serialize(encoder: Encoder, `value`: RpcProtocolConfigRequest) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is RpcProtocolConfigRequest.BlockId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<BlockId>(), value.blockId)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcProtocolConfigRequest.Finality -> {
          val map = mutableMapOf<String, JsonElement>()
          map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<Finality>(), value.finality)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcProtocolConfigRequest.SyncCheckpoint -> {
          val map = mutableMapOf<String, JsonElement>()
          map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<SyncCheckpoint>(), value.syncCheckpoint)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is RpcProtocolConfigRequest.BlockId -> out.encodeSerializableElement(descriptor, 0, serializer<BlockId>(), value.blockId)
      is RpcProtocolConfigRequest.Finality -> out.encodeSerializableElement(descriptor, 1, serializer<Finality>(), value.finality)
      is RpcProtocolConfigRequest.SyncCheckpoint -> out.encodeSerializableElement(descriptor, 2, serializer<SyncCheckpoint>(), value.syncCheckpoint)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): RpcProtocolConfigRequest {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            throw SerializationException("Unknown discriminator string for RpcProtocolConfigRequest: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing RpcProtocolConfigRequest")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["block_id"] != null) {
            val blockIdVal = decoder.json.decodeFromJsonElement(serializer<BlockId>(), jobj["block_id"] ?: throw SerializationException("Missing field 'block_id' for variant " + "BlockId"))
            return RpcProtocolConfigRequest.BlockId(blockIdVal)
          }
          if (jobj["finality"] != null) {
            val finalityVal = decoder.json.decodeFromJsonElement(serializer<Finality>(), jobj["finality"] ?: throw SerializationException("Missing field 'finality' for variant " + "Finality"))
            return RpcProtocolConfigRequest.Finality(finalityVal)
          }
          if (jobj["sync_checkpoint"] != null) {
            val syncCheckpointVal = decoder.json.decodeFromJsonElement(serializer<SyncCheckpoint>(), jobj["sync_checkpoint"] ?: throw SerializationException("Missing field 'sync_checkpoint' for variant " + "SyncCheckpoint"))
            return RpcProtocolConfigRequest.SyncCheckpoint(syncCheckpointVal)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val blockIdVal = decoder.json.decodeFromJsonElement(serializer<BlockId>(), obj["block_id"] ?: throw SerializationException("Missing field 'block_id' for variant " + key))
                return RpcProtocolConfigRequest.BlockId(blockIdVal)
              }
              "finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val finalityVal = decoder.json.decodeFromJsonElement(serializer<Finality>(), obj["finality"] ?: throw SerializationException("Missing field 'finality' for variant " + key))
                return RpcProtocolConfigRequest.Finality(finalityVal)
              }
              "sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val syncCheckpointVal = decoder.json.decodeFromJsonElement(serializer<SyncCheckpoint>(), obj["sync_checkpoint"] ?: throw SerializationException("Missing field 'sync_checkpoint' for variant " + key))
                return RpcProtocolConfigRequest.SyncCheckpoint(syncCheckpointVal)
              }
              else -> throw SerializationException("Unknown discriminator key for RpcProtocolConfigRequest: " + key)
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
              val knownVariantNames = setOf("block_id", "finality", "sync_checkpoint")
              for ((k, v) in jobj.entries) {
                if (v is JsonElement && v.jsonPrimitive.isString) {
                    val s = (v as JsonElement).jsonPrimitive.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator (one of type/name) or recognizable variant in RpcProtocolConfigRequest")
            val tf = typeField.trim()
            when (tf) {
              "block_id" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcProtocolConfigRequest.BlockId>(), jobj)
              }
              "finality" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcProtocolConfigRequest.Finality>(), jobj)
              }
              "sync_checkpoint" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcProtocolConfigRequest.SyncCheckpoint>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for RpcProtocolConfigRequest: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize RpcProtocolConfigRequest with non-JSON decoder")
  }
}
