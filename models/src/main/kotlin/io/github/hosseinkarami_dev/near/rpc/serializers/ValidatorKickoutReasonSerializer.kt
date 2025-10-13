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
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason") {
        element("_UnusedSlashed", serializer<JsonElement>().descriptor)
        element("NotEnoughBlocks", serializer<JsonElement>().descriptor)
        element("NotEnoughChunks", serializer<JsonElement>().descriptor)
        element("Unstaked", serializer<JsonElement>().descriptor)
        element("NotEnoughStake", serializer<JsonElement>().descriptor)
        element("DidNotGetASeat", serializer<JsonElement>().descriptor)
        element("NotEnoughChunkEndorsements", serializer<JsonElement>().descriptor)
        element("ProtocolVersionTooOld", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: ValidatorKickoutReason) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is ValidatorKickoutReason.UnusedSlashed -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("_UnusedSlashed"))
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
        is ValidatorKickoutReason.Unstaked -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("Unstaked"))
        }
        is ValidatorKickoutReason.NotEnoughStake -> {
          val map = mutableMapOf<String, JsonElement>()
          map["NotEnoughStake"] = jsonEncoder.json.encodeToJsonElement(serializer<ValidatorKickoutReason.NotEnoughStake.NotEnoughStakePayload>(), value.notEnoughStake)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ValidatorKickoutReason.DidNotGetASeat -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("DidNotGetASeat"))
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
      is ValidatorKickoutReason.UnusedSlashed -> out.encodeSerializableElement(descriptor, 0, serializer<ValidatorKickoutReason.UnusedSlashed>(), value)
      is ValidatorKickoutReason.NotEnoughBlocks -> out.encodeSerializableElement(descriptor, 1, serializer<ValidatorKickoutReason.NotEnoughBlocks>(), value)
      is ValidatorKickoutReason.NotEnoughChunks -> out.encodeSerializableElement(descriptor, 2, serializer<ValidatorKickoutReason.NotEnoughChunks>(), value)
      is ValidatorKickoutReason.Unstaked -> out.encodeSerializableElement(descriptor, 3, serializer<ValidatorKickoutReason.Unstaked>(), value)
      is ValidatorKickoutReason.NotEnoughStake -> out.encodeSerializableElement(descriptor, 4, serializer<ValidatorKickoutReason.NotEnoughStake>(), value)
      is ValidatorKickoutReason.DidNotGetASeat -> out.encodeSerializableElement(descriptor, 5, serializer<ValidatorKickoutReason.DidNotGetASeat>(), value)
      is ValidatorKickoutReason.NotEnoughChunkEndorsements -> out.encodeSerializableElement(descriptor, 6, serializer<ValidatorKickoutReason.NotEnoughChunkEndorsements>(), value)
      is ValidatorKickoutReason.ProtocolVersionTooOld -> out.encodeSerializableElement(descriptor, 7, serializer<ValidatorKickoutReason.ProtocolVersionTooOld>(), value)
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
            if (s == "_UnusedSlashed") return ValidatorKickoutReason.UnusedSlashed()
            if (s == "Unstaked") return ValidatorKickoutReason.Unstaked()
            if (s == "DidNotGetASeat") return ValidatorKickoutReason.DidNotGetASeat()
          }
          throw SerializationException("Unknown discriminator (primitive) for ValidatorKickoutReason")
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing ValidatorKickoutReason")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj["NotEnoughBlocks"] != null) {
            return ValidatorKickoutReason.NotEnoughBlocks(decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.NotEnoughBlocks.NotEnoughBlocksPayload>(), jobj["NotEnoughBlocks"]!!))
          }
          if (jobj["NotEnoughChunks"] != null) {
            return ValidatorKickoutReason.NotEnoughChunks(decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.NotEnoughChunks.NotEnoughChunksPayload>(), jobj["NotEnoughChunks"]!!))
          }
          if (jobj["NotEnoughStake"] != null) {
            return ValidatorKickoutReason.NotEnoughStake(decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.NotEnoughStake.NotEnoughStakePayload>(), jobj["NotEnoughStake"]!!))
          }
          if (jobj["NotEnoughChunkEndorsements"] != null) {
            return ValidatorKickoutReason.NotEnoughChunkEndorsements(decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.NotEnoughChunkEndorsements.NotEnoughChunkEndorsementsPayload>(), jobj["NotEnoughChunkEndorsements"]!!))
          }
          if (jobj["ProtocolVersionTooOld"] != null) {
            return ValidatorKickoutReason.ProtocolVersionTooOld(decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.ProtocolVersionTooOld.ProtocolVersionTooOldPayload>(), jobj["ProtocolVersionTooOld"]!!))
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "NotEnoughBlocks" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.NotEnoughBlocks>(), obj)
              }
              "NotEnoughChunks" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.NotEnoughChunks>(), obj)
              }
              "NotEnoughStake" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.NotEnoughStake>(), obj)
              }
              "NotEnoughChunkEndorsements" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.NotEnoughChunkEndorsements>(), obj)
              }
              "ProtocolVersionTooOld" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ValidatorKickoutReason.ProtocolVersionTooOld>(), obj)
              }
              "_UnusedSlashed" -> {
                return ValidatorKickoutReason.UnusedSlashed()
              }
              "Unstaked" -> {
                return ValidatorKickoutReason.Unstaked()
              }
              "DidNotGetASeat" -> {
                return ValidatorKickoutReason.DidNotGetASeat()
              }
              else -> throw SerializationException("Unknown discriminator key for ValidatorKickoutReason: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("_UnusedSlashed", "NotEnoughBlocks", "NotEnoughChunks", "Unstaked", "NotEnoughStake", "DidNotGetASeat", "NotEnoughChunkEndorsements", "ProtocolVersionTooOld")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in ValidatorKickoutReason")
            val tf = typeField.trim()
            when (tf) {
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
              "_UnusedSlashed" -> return ValidatorKickoutReason.UnusedSlashed()
              "Unstaked" -> return ValidatorKickoutReason.Unstaked()
              "DidNotGetASeat" -> return ValidatorKickoutReason.DidNotGetASeat()
              else -> throw SerializationException("Unknown type discriminator for ValidatorKickoutReason: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize ValidatorKickoutReason with non-JSON decoder")
  }
}
