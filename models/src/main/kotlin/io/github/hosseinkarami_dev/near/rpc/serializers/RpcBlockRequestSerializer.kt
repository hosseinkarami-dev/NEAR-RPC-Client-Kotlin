package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.BlockId
import io.github.hosseinkarami_dev.near.rpc.models.Finality
import io.github.hosseinkarami_dev.near.rpc.models.RpcBlockRequest
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

public object RpcBlockRequestSerializer : KSerializer<RpcBlockRequest> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcBlockRequest") {
        element("block_id", serializer<JsonElement>().descriptor)
        element("finality", serializer<JsonElement>().descriptor)
        element("sync_checkpoint", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: RpcBlockRequest) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is RpcBlockRequest.BlockId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<BlockId>(), value.blockId)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcBlockRequest.Finality -> {
          val map = mutableMapOf<String, JsonElement>()
          map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<Finality>(), value.finality)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcBlockRequest.SyncCheckpoint -> {
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
      is RpcBlockRequest.BlockId -> out.encodeSerializableElement(descriptor, 0, serializer<RpcBlockRequest.BlockId>(), value)
      is RpcBlockRequest.Finality -> out.encodeSerializableElement(descriptor, 1, serializer<RpcBlockRequest.Finality>(), value)
      is RpcBlockRequest.SyncCheckpoint -> out.encodeSerializableElement(descriptor, 2, serializer<RpcBlockRequest.SyncCheckpoint>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): RpcBlockRequest {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
          }
          throw SerializationException("Unknown discriminator (primitive) for RpcBlockRequest")
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing RpcBlockRequest")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj["block_id"] != null) {
            return RpcBlockRequest.BlockId(decoder.json.decodeFromJsonElement(serializer<BlockId>(), jobj["block_id"]!!))
          }
          if (jobj["finality"] != null) {
            return RpcBlockRequest.Finality(decoder.json.decodeFromJsonElement(serializer<Finality>(), jobj["finality"]!!))
          }
          if (jobj["sync_checkpoint"] != null) {
            return RpcBlockRequest.SyncCheckpoint(decoder.json.decodeFromJsonElement(serializer<SyncCheckpoint>(), jobj["sync_checkpoint"]!!))
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcBlockRequest.BlockId>(), obj)
              }
              "finality" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcBlockRequest.Finality>(), obj)
              }
              "sync_checkpoint" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcBlockRequest.SyncCheckpoint>(), obj)
              }
              else -> throw SerializationException("Unknown discriminator key for RpcBlockRequest: " + key)
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
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in RpcBlockRequest")
            val tf = typeField.trim()
            when (tf) {
              "block_id" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcBlockRequest.BlockId>(), jobj)
              }
              "finality" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcBlockRequest.Finality>(), jobj)
              }
              "sync_checkpoint" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcBlockRequest.SyncCheckpoint>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for RpcBlockRequest: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize RpcBlockRequest with non-JSON decoder")
  }
}
