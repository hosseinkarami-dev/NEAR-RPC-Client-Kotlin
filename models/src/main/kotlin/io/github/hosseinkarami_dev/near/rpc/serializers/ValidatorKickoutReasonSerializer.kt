package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason
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

public object ValidatorKickoutReasonSerializer : KSerializer<ValidatorKickoutReason> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason")

  override fun serialize(encoder: Encoder, `value`: ValidatorKickoutReason) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        ValidatorKickoutReason.UnusedSlashed -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("_UnusedSlashed"))
        }
        ValidatorKickoutReason.Unstaked -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("Unstaked"))
        }
        ValidatorKickoutReason.DidNotGetASeat -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("DidNotGetASeat"))
        }
        is ValidatorKickoutReason.NotEnoughBlocks -> {
          val map = mutableMapOf<String, JsonElement>()
          map["NotEnoughBlocks"] = jsonEncoder.json.encodeToJsonElement(serializer<ValidatorKickoutReason.NotEnoughBlocks.NotEnoughBlocksPayload>(), value.notEnoughBlocks)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ValidatorKickoutReason.NotEnoughChunks -> {
          val map = mutableMapOf<String, JsonElement>()
          map["NotEnoughChunks"] = jsonEncoder.json.encodeToJsonElement(serializer<ValidatorKickoutReason.NotEnoughChunks.NotEnoughChunksPayload>(), value.notEnoughChunks)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ValidatorKickoutReason.NotEnoughStake -> {
          val map = mutableMapOf<String, JsonElement>()
          map["NotEnoughStake"] = jsonEncoder.json.encodeToJsonElement(serializer<ValidatorKickoutReason.NotEnoughStake.NotEnoughStakePayload>(), value.notEnoughStake)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ValidatorKickoutReason.NotEnoughChunkEndorsements -> {
          val map = mutableMapOf<String, JsonElement>()
          map["NotEnoughChunkEndorsements"] = jsonEncoder.json.encodeToJsonElement(serializer<ValidatorKickoutReason.NotEnoughChunkEndorsements.NotEnoughChunkEndorsementsPayload>(), value.notEnoughChunkEndorsements)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ValidatorKickoutReason.ProtocolVersionTooOld -> {
          val map = mutableMapOf<String, JsonElement>()
          map["ProtocolVersionTooOld"] = jsonEncoder.json.encodeToJsonElement(serializer<ValidatorKickoutReason.ProtocolVersionTooOld.ProtocolVersionTooOldPayload>(), value.protocolVersionTooOld)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      ValidatorKickoutReason.UnusedSlashed -> out.encodeStringElement(descriptor, 0, "_UnusedSlashed")
      is ValidatorKickoutReason.NotEnoughBlocks -> out.encodeSerializableElement(descriptor, 1, serializer<ValidatorKickoutReason.NotEnoughBlocks.NotEnoughBlocksPayload>(), value.notEnoughBlocks)
      is ValidatorKickoutReason.NotEnoughChunks -> out.encodeSerializableElement(descriptor, 2, serializer<ValidatorKickoutReason.NotEnoughChunks.NotEnoughChunksPayload>(), value.notEnoughChunks)
      ValidatorKickoutReason.Unstaked -> out.encodeStringElement(descriptor, 3, "Unstaked")
      is ValidatorKickoutReason.NotEnoughStake -> out.encodeSerializableElement(descriptor, 4, serializer<ValidatorKickoutReason.NotEnoughStake.NotEnoughStakePayload>(), value.notEnoughStake)
      ValidatorKickoutReason.DidNotGetASeat -> out.encodeStringElement(descriptor, 5, "DidNotGetASeat")
      is ValidatorKickoutReason.NotEnoughChunkEndorsements -> out.encodeSerializableElement(descriptor, 6, serializer<ValidatorKickoutReason.NotEnoughChunkEndorsements.NotEnoughChunkEndorsementsPayload>(), value.notEnoughChunkEndorsements)
      is ValidatorKickoutReason.ProtocolVersionTooOld -> out.encodeSerializableElement(descriptor, 7, serializer<ValidatorKickoutReason.ProtocolVersionTooOld.ProtocolVersionTooOldPayload>(), value.protocolVersionTooOld)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): ValidatorKickoutReason {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            if (s == "_UnusedSlashed") return ValidatorKickoutReason.UnusedSlashed
            if (s == "Unstaked") return ValidatorKickoutReason.Unstaked
            if (s == "DidNotGetASeat") return ValidatorKickoutReason.DidNotGetASeat
            throw SerializationException("Unknown discriminator string for ValidatorKickoutReason: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing ValidatorKickoutReason")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["NotEnoughBlocks"] != null) {
            val notEnoughBlocksVal = decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.NotEnoughBlocks.NotEnoughBlocksPayload>(), jobj["NotEnoughBlocks"] ?: throw SerializationException("Missing field 'NotEnoughBlocks' for variant " + "NotEnoughBlocks"))
            return ValidatorKickoutReason.NotEnoughBlocks(notEnoughBlocksVal)
          }
          if (jobj["NotEnoughChunks"] != null) {
            val notEnoughChunksVal = decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.NotEnoughChunks.NotEnoughChunksPayload>(), jobj["NotEnoughChunks"] ?: throw SerializationException("Missing field 'NotEnoughChunks' for variant " + "NotEnoughChunks"))
            return ValidatorKickoutReason.NotEnoughChunks(notEnoughChunksVal)
          }
          if (jobj["NotEnoughStake"] != null) {
            val notEnoughStakeVal = decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.NotEnoughStake.NotEnoughStakePayload>(), jobj["NotEnoughStake"] ?: throw SerializationException("Missing field 'NotEnoughStake' for variant " + "NotEnoughStake"))
            return ValidatorKickoutReason.NotEnoughStake(notEnoughStakeVal)
          }
          if (jobj["NotEnoughChunkEndorsements"] != null) {
            val notEnoughChunkEndorsementsVal = decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.NotEnoughChunkEndorsements.NotEnoughChunkEndorsementsPayload>(), jobj["NotEnoughChunkEndorsements"] ?: throw SerializationException("Missing field 'NotEnoughChunkEndorsements' for variant " + "NotEnoughChunkEndorsements"))
            return ValidatorKickoutReason.NotEnoughChunkEndorsements(notEnoughChunkEndorsementsVal)
          }
          if (jobj["ProtocolVersionTooOld"] != null) {
            val protocolVersionTooOldVal = decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.ProtocolVersionTooOld.ProtocolVersionTooOldPayload>(), jobj["ProtocolVersionTooOld"] ?: throw SerializationException("Missing field 'ProtocolVersionTooOld' for variant " + "ProtocolVersionTooOld"))
            return ValidatorKickoutReason.ProtocolVersionTooOld(protocolVersionTooOldVal)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "NotEnoughBlocks" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val notEnoughBlocksVal = decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.NotEnoughBlocks.NotEnoughBlocksPayload>(), obj["NotEnoughBlocks"] ?: throw SerializationException("Missing field 'NotEnoughBlocks' for variant " + key))
                return ValidatorKickoutReason.NotEnoughBlocks(notEnoughBlocksVal)
              }
              "NotEnoughChunks" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val notEnoughChunksVal = decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.NotEnoughChunks.NotEnoughChunksPayload>(), obj["NotEnoughChunks"] ?: throw SerializationException("Missing field 'NotEnoughChunks' for variant " + key))
                return ValidatorKickoutReason.NotEnoughChunks(notEnoughChunksVal)
              }
              "NotEnoughStake" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val notEnoughStakeVal = decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.NotEnoughStake.NotEnoughStakePayload>(), obj["NotEnoughStake"] ?: throw SerializationException("Missing field 'NotEnoughStake' for variant " + key))
                return ValidatorKickoutReason.NotEnoughStake(notEnoughStakeVal)
              }
              "NotEnoughChunkEndorsements" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val notEnoughChunkEndorsementsVal = decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.NotEnoughChunkEndorsements.NotEnoughChunkEndorsementsPayload>(), obj["NotEnoughChunkEndorsements"] ?: throw SerializationException("Missing field 'NotEnoughChunkEndorsements' for variant " + key))
                return ValidatorKickoutReason.NotEnoughChunkEndorsements(notEnoughChunkEndorsementsVal)
              }
              "ProtocolVersionTooOld" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val protocolVersionTooOldVal = decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.ProtocolVersionTooOld.ProtocolVersionTooOldPayload>(), obj["ProtocolVersionTooOld"] ?: throw SerializationException("Missing field 'ProtocolVersionTooOld' for variant " + key))
                return ValidatorKickoutReason.ProtocolVersionTooOld(protocolVersionTooOldVal)
              }
              "_UnusedSlashed" -> {
                return ValidatorKickoutReason.UnusedSlashed
              }
              "Unstaked" -> {
                return ValidatorKickoutReason.Unstaked
              }
              "DidNotGetASeat" -> {
                return ValidatorKickoutReason.DidNotGetASeat
              }
              else -> throw SerializationException("Unknown discriminator key for ValidatorKickoutReason: " + key)
            }
          }
          else {
            val typeField = jobj["type"]?.jsonPrimitive?.contentOrNull ?: throw SerializationException("Missing 'type' discriminator in ValidatorKickoutReason")
            when (typeField) {
              "NotEnoughBlocks" -> {
                return decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.NotEnoughBlocks>(), jobj)
              }
              "NotEnoughChunks" -> {
                return decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.NotEnoughChunks>(), jobj)
              }
              "NotEnoughStake" -> {
                return decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.NotEnoughStake>(), jobj)
              }
              "NotEnoughChunkEndorsements" -> {
                return decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.NotEnoughChunkEndorsements>(), jobj)
              }
              "ProtocolVersionTooOld" -> {
                return decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.ProtocolVersionTooOld>(), jobj)
              }
              "_UnusedSlashed" -> return ValidatorKickoutReason.UnusedSlashed
              "Unstaked" -> return ValidatorKickoutReason.Unstaked
              "DidNotGetASeat" -> return ValidatorKickoutReason.DidNotGetASeat
              else -> throw SerializationException("Unknown type discriminator for ValidatorKickoutReason: " + typeField)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize ValidatorKickoutReason with non-JSON decoder")
  }
}
