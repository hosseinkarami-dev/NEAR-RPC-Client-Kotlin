package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.BlockId
import io.github.hosseinkarami_dev.near.rpc.models.EpochId
import io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest
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

public object RpcValidatorRequestSerializer : KSerializer<RpcValidatorRequest> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest") {
        element("latest", serializer<JsonElement>().descriptor)
        element("epoch_id", serializer<JsonElement>().descriptor)
        element("block_id", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: RpcValidatorRequest) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        RpcValidatorRequest.Latest -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("latest"))
        }
        is RpcValidatorRequest.EpochId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["epoch_id"] = jsonEncoder.json.encodeToJsonElement(serializer<EpochId>(), value.epochId)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is RpcValidatorRequest.BlockId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<BlockId>(), value.blockId)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is RpcValidatorRequest.Latest -> out.encodeSerializableElement(descriptor, 0, serializer<RpcValidatorRequest.Latest>(), value)
      is RpcValidatorRequest.EpochId -> out.encodeSerializableElement(descriptor, 1, serializer<RpcValidatorRequest.EpochId>(), value)
      is RpcValidatorRequest.BlockId -> out.encodeSerializableElement(descriptor, 2, serializer<RpcValidatorRequest.BlockId>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): RpcValidatorRequest {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            if (s == "latest") return RpcValidatorRequest.Latest
            throw SerializationException("Unknown discriminator string for RpcValidatorRequest: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing RpcValidatorRequest")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["epoch_id"] != null) {
            val epochIdVal = decoder.json.decodeFromJsonElement(serializer<EpochId>(), jobj["epoch_id"] ?: throw SerializationException("Missing field 'epoch_id' for variant " + "EpochId"))
            return RpcValidatorRequest.EpochId(epochIdVal)
          }
          if (jobj["block_id"] != null) {
            val blockIdVal = decoder.json.decodeFromJsonElement(serializer<BlockId>(), jobj["block_id"] ?: throw SerializationException("Missing field 'block_id' for variant " + "BlockId"))
            return RpcValidatorRequest.BlockId(blockIdVal)
          }
          if (listOf("epoch_id").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcValidatorRequest.EpochId>(), jobj)
          }
          if (listOf("block_id").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<RpcValidatorRequest.BlockId>(), jobj)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "epoch_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcValidatorRequest.EpochId>(), obj)
              }
              "block_id" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<RpcValidatorRequest.BlockId>(), obj)
              }
              "latest" -> {
                return RpcValidatorRequest.Latest
              }
              else -> throw SerializationException("Unknown discriminator key for RpcValidatorRequest: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("latest", "epoch_id", "block_id")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in RpcValidatorRequest")
            val tf = typeField.trim()
            when (tf) {
              "epoch_id" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcValidatorRequest.EpochId>(), jobj)
              }
              "block_id" -> {
                return decoder.json.decodeFromJsonElement(serializer<RpcValidatorRequest.BlockId>(), jobj)
              }
              "latest" -> return RpcValidatorRequest.Latest
              else -> throw SerializationException("Unknown type discriminator for RpcValidatorRequest: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize RpcValidatorRequest with non-JSON decoder")
  }
}
