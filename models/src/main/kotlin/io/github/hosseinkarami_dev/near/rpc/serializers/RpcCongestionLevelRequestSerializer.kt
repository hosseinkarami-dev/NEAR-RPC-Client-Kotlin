package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.BlockId
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.RpcCongestionLevelRequest
import io.github.hosseinkarami_dev.near.rpc.models.ShardId
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

public object RpcCongestionLevelRequestSerializer : KSerializer<RpcCongestionLevelRequest> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcCongestionLevelRequest") {
        element("block_shard_id", serializer<JsonElement>().descriptor)
        element("chunk_hash", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: RpcCongestionLevelRequest) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is RpcCongestionLevelRequest.BlockShardId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<BlockId>(), value.blockId)
          map["shard_id"] = jsonEncoder.json.encodeToJsonElement(serializer<ShardId>(), value.shardId)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcCongestionLevelRequest.ChunkHash -> {
          val map = mutableMapOf<String, JsonElement>()
          map["chunk_id"] = jsonEncoder.json.encodeToJsonElement(serializer<CryptoHash>(), value.chunkId)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is RpcCongestionLevelRequest.BlockShardId -> out.encodeSerializableElement(descriptor, 0, serializer<RpcCongestionLevelRequest.BlockShardId>(), value)
      is RpcCongestionLevelRequest.ChunkHash -> out.encodeSerializableElement(descriptor, 1, serializer<RpcCongestionLevelRequest.ChunkHash>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): RpcCongestionLevelRequest {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            throw SerializationException("Unknown discriminator string for RpcCongestionLevelRequest: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing RpcCongestionLevelRequest")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["block_id"] != null) {
            val blockIdVal = decoder.json.decodeFromJsonElement(serializer<BlockId>(), jobj["block_id"] ?: throw SerializationException("Missing field 'block_id' for variant " + "BlockShardId"))
            val shardIdVal = decoder.json.decodeFromJsonElement(serializer<ShardId>(), jobj["shard_id"] ?: throw SerializationException("Missing field 'shard_id' for variant " + "BlockShardId"))
            return RpcCongestionLevelRequest.BlockShardId(blockIdVal, shardIdVal)
          }
          if (jobj["chunk_id"] != null) {
            val chunkIdVal = decoder.json.decodeFromJsonElement(serializer<CryptoHash>(), jobj["chunk_id"] ?: throw SerializationException("Missing field 'chunk_id' for variant " + "ChunkHash"))
            return RpcCongestionLevelRequest.ChunkHash(chunkIdVal)
          }
          if (listOf("block_id", "shard_id").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcCongestionLevelRequest.BlockShardId>(), jobj)
          }
          if (listOf("chunk_id").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcCongestionLevelRequest.ChunkHash>(), jobj)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "block_shard_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcCongestionLevelRequest.BlockShardId>(), obj)
              }
              "chunk_hash" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcCongestionLevelRequest.ChunkHash>(), obj)
              }
              else -> throw SerializationException("Unknown discriminator key for RpcCongestionLevelRequest: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("block_shard_id", "chunk_hash")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in RpcCongestionLevelRequest")
            val tf = typeField.trim()
            when (tf) {
              "block_shard_id" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcCongestionLevelRequest.BlockShardId>(), jobj)
              }
              "chunk_hash" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcCongestionLevelRequest.ChunkHash>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for RpcCongestionLevelRequest: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize RpcCongestionLevelRequest with non-JSON decoder")
  }
}
