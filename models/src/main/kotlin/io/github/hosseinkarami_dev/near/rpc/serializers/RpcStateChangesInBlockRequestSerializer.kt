package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.BlockId
import io.github.hosseinkarami_dev.near.rpc.models.Finality
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest
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

public object RpcStateChangesInBlockRequestSerializer : KSerializer<RpcStateChangesInBlockRequest> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest") {
        element("block_id", serializer<JsonElement>().descriptor)
        element("finality", serializer<JsonElement>().descriptor)
        element("sync_checkpoint", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: RpcStateChangesInBlockRequest) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is RpcStateChangesInBlockRequest.BlockId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<BlockId>(), value.blockId)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcStateChangesInBlockRequest.Finality -> {
          val map = mutableMapOf<String, JsonElement>()
          map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<Finality>(), value.finality)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcStateChangesInBlockRequest.SyncCheckpoint -> {
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
      is RpcStateChangesInBlockRequest.BlockId -> out.encodeSerializableElement(descriptor, 0, serializer<RpcStateChangesInBlockRequest.BlockId>(), value)
      is RpcStateChangesInBlockRequest.Finality -> out.encodeSerializableElement(descriptor, 1, serializer<RpcStateChangesInBlockRequest.Finality>(), value)
      is RpcStateChangesInBlockRequest.SyncCheckpoint -> out.encodeSerializableElement(descriptor, 2, serializer<RpcStateChangesInBlockRequest.SyncCheckpoint>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): RpcStateChangesInBlockRequest {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
          }
          throw SerializationException("Unknown discriminator (primitive) for RpcStateChangesInBlockRequest")
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing RpcStateChangesInBlockRequest")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj["block_id"] != null) {
            return RpcStateChangesInBlockRequest.BlockId(decoder.json.decodeFromJsonElement(serializer<BlockId>(), jobj["block_id"]!!))
          }
          if (jobj["finality"] != null) {
            return RpcStateChangesInBlockRequest.Finality(decoder.json.decodeFromJsonElement(serializer<Finality>(), jobj["finality"]!!))
          }
          if (jobj["sync_checkpoint"] != null) {
            return RpcStateChangesInBlockRequest.SyncCheckpoint(decoder.json.decodeFromJsonElement(serializer<SyncCheckpoint>(), jobj["sync_checkpoint"]!!))
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockRequest.BlockId>(), obj)
              }
              "finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockRequest.Finality>(), obj)
              }
              "sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockRequest.SyncCheckpoint>(), obj)
              }
              else -> throw SerializationException("Unknown discriminator key for RpcStateChangesInBlockRequest: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("block_id", "finality", "sync_checkpoint")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in RpcStateChangesInBlockRequest")
            val tf = typeField.trim()
            when (tf) {
              "block_id" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockRequest.BlockId>(), jobj)
              }
              "finality" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockRequest.Finality>(), jobj)
              }
              "sync_checkpoint" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcStateChangesInBlockRequest.SyncCheckpoint>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for RpcStateChangesInBlockRequest: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize RpcStateChangesInBlockRequest with non-JSON decoder")
  }
}
