package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.AccountId
import io.github.hosseinkarami_dev.near.rpc.models.ShardId
import io.github.hosseinkarami_dev.near.rpc.models.ShardUId
import io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig
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

public object TrackedShardsConfigSerializer : KSerializer<TrackedShardsConfig> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig") {
        element("NoShards", serializer<JsonElement>().descriptor)
        element("Shards", serializer<JsonElement>().descriptor)
        element("AllShards", serializer<JsonElement>().descriptor)
        element("ShadowValidator", serializer<JsonElement>().descriptor)
        element("Schedule", serializer<JsonElement>().descriptor)
        element("Accounts", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: TrackedShardsConfig) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        TrackedShardsConfig.NoShards -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("NoShards"))
        }
        TrackedShardsConfig.AllShards -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("AllShards"))
        }
        is TrackedShardsConfig.Shards -> {
          val map = mutableMapOf<String, JsonElement>()
          map["Shards"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<ShardUId>()), value.shards)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is TrackedShardsConfig.ShadowValidator -> {
          val map = mutableMapOf<String, JsonElement>()
          map["ShadowValidator"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.shadowValidator)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is TrackedShardsConfig.Schedule -> {
          val map = mutableMapOf<String, JsonElement>()
          map["Schedule"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(ListSerializer(serializer<ShardId>())), value.schedule)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is TrackedShardsConfig.Accounts -> {
          val map = mutableMapOf<String, JsonElement>()
          map["Accounts"] = jsonEncoder.json.encodeToJsonElement(ListSerializer(serializer<AccountId>()), value.accounts)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is TrackedShardsConfig.NoShards -> out.encodeSerializableElement(descriptor, 0, serializer<TrackedShardsConfig.NoShards>(), value)
      is TrackedShardsConfig.Shards -> out.encodeSerializableElement(descriptor, 1, serializer<TrackedShardsConfig.Shards>(), value)
      is TrackedShardsConfig.AllShards -> out.encodeSerializableElement(descriptor, 2, serializer<TrackedShardsConfig.AllShards>(), value)
      is TrackedShardsConfig.ShadowValidator -> out.encodeSerializableElement(descriptor, 3, serializer<TrackedShardsConfig.ShadowValidator>(), value)
      is TrackedShardsConfig.Schedule -> out.encodeSerializableElement(descriptor, 4, serializer<TrackedShardsConfig.Schedule>(), value)
      is TrackedShardsConfig.Accounts -> out.encodeSerializableElement(descriptor, 5, serializer<TrackedShardsConfig.Accounts>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): TrackedShardsConfig {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            if (s == "NoShards") return TrackedShardsConfig.NoShards
            if (s == "AllShards") return TrackedShardsConfig.AllShards
            throw SerializationException("Unknown discriminator string for TrackedShardsConfig: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing TrackedShardsConfig")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["Shards"] != null) {
            val shardsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<ShardUId>()), jobj["Shards"] ?: throw SerializationException("Missing field 'Shards' for variant " + "Shards"))
            return TrackedShardsConfig.Shards(shardsVal)
          }
          if (jobj["ShadowValidator"] != null) {
            val shadowValidatorVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), jobj["ShadowValidator"] ?: throw SerializationException("Missing field 'ShadowValidator' for variant " + "ShadowValidator"))
            return TrackedShardsConfig.ShadowValidator(shadowValidatorVal)
          }
          if (jobj["Schedule"] != null) {
            val scheduleVal = decoder.json.decodeFromJsonElement(ListSerializer(ListSerializer(serializer<ShardId>())), jobj["Schedule"] ?: throw SerializationException("Missing field 'Schedule' for variant " + "Schedule"))
            return TrackedShardsConfig.Schedule(scheduleVal)
          }
          if (jobj["Accounts"] != null) {
            val accountsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountId>()), jobj["Accounts"] ?: throw SerializationException("Missing field 'Accounts' for variant " + "Accounts"))
            return TrackedShardsConfig.Accounts(accountsVal)
          }
          if (listOf("Shards").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<TrackedShardsConfig.Shards>(), jobj)
          }
          if (listOf("ShadowValidator").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<TrackedShardsConfig.ShadowValidator>(), jobj)
          }
          if (listOf("Schedule").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<TrackedShardsConfig.Schedule>(), jobj)
          }
          if (listOf("Accounts").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<TrackedShardsConfig.Accounts>(), jobj)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "Shards" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val shardsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<ShardUId>()), obj["Shards"] ?: throw SerializationException("Missing field 'Shards' for variant " + key))
                return TrackedShardsConfig.Shards(shardsVal)
              }
              "ShadowValidator" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val shadowValidatorVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["ShadowValidator"] ?: throw SerializationException("Missing field 'ShadowValidator' for variant " + key))
                return TrackedShardsConfig.ShadowValidator(shadowValidatorVal)
              }
              "Schedule" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val scheduleVal = decoder.json.decodeFromJsonElement(ListSerializer(ListSerializer(serializer<ShardId>())), obj["Schedule"] ?: throw SerializationException("Missing field 'Schedule' for variant " + key))
                return TrackedShardsConfig.Schedule(scheduleVal)
              }
              "Accounts" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val accountsVal = decoder.json.decodeFromJsonElement(ListSerializer(serializer<AccountId>()), obj["Accounts"] ?: throw SerializationException("Missing field 'Accounts' for variant " + key))
                return TrackedShardsConfig.Accounts(accountsVal)
              }
              "NoShards" -> {
                return TrackedShardsConfig.NoShards
              }
              "AllShards" -> {
                return TrackedShardsConfig.AllShards
              }
              else -> throw SerializationException("Unknown discriminator key for TrackedShardsConfig: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("NoShards", "Shards", "AllShards", "ShadowValidator", "Schedule", "Accounts")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in TrackedShardsConfig")
            val tf = typeField.trim()
            when (tf) {
              "Shards" -> {
                return decoder.json.decodeFromJsonElement(serializer<TrackedShardsConfig.Shards>(), jobj)
              }
              "ShadowValidator" -> {
                return decoder.json.decodeFromJsonElement(serializer<TrackedShardsConfig.ShadowValidator>(), jobj)
              }
              "Schedule" -> {
                return decoder.json.decodeFromJsonElement(serializer<TrackedShardsConfig.Schedule>(), jobj)
              }
              "Accounts" -> {
                return decoder.json.decodeFromJsonElement(serializer<TrackedShardsConfig.Accounts>(), jobj)
              }
              "NoShards" -> return TrackedShardsConfig.NoShards
              "AllShards" -> return TrackedShardsConfig.AllShards
              else -> throw SerializationException("Unknown type discriminator for TrackedShardsConfig: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize TrackedShardsConfig with non-JSON decoder")
  }
}
