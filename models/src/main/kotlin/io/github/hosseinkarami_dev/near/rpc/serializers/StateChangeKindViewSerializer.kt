package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.AccountId
import io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView
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

public object StateChangeKindViewSerializer : KSerializer<StateChangeKindView> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView") {
        element("account_touched", serializer<JsonElement>().descriptor)
        element("access_key_touched", serializer<JsonElement>().descriptor)
        element("data_touched", serializer<JsonElement>().descriptor)
        element("contract_code_touched", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: StateChangeKindView) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is StateChangeKindView.AccountTouched -> {
          val map = mutableMapOf<String, JsonElement>()
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeKindView.AccountTouched.Type>(), value.type)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeKindView.AccessKeyTouched -> {
          val map = mutableMapOf<String, JsonElement>()
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeKindView.AccessKeyTouched.Type>(), value.type)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeKindView.DataTouched -> {
          val map = mutableMapOf<String, JsonElement>()
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeKindView.DataTouched.Type>(), value.type)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeKindView.ContractCodeTouched -> {
          val map = mutableMapOf<String, JsonElement>()
          map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<AccountId>(), value.accountId)
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeKindView.ContractCodeTouched.Type>(), value.type)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is StateChangeKindView.AccountTouched -> out.encodeSerializableElement(descriptor, 0, serializer<StateChangeKindView.AccountTouched>(), value)
      is StateChangeKindView.AccessKeyTouched -> out.encodeSerializableElement(descriptor, 1, serializer<StateChangeKindView.AccessKeyTouched>(), value)
      is StateChangeKindView.DataTouched -> out.encodeSerializableElement(descriptor, 2, serializer<StateChangeKindView.DataTouched>(), value)
      is StateChangeKindView.ContractCodeTouched -> out.encodeSerializableElement(descriptor, 3, serializer<StateChangeKindView.ContractCodeTouched>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): StateChangeKindView {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            throw SerializationException("Unknown discriminator string for StateChangeKindView: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing StateChangeKindView")
        }
        is JsonObject -> {
          val jobj = element
          if (listOf("account_id", "type").all { jobj[it] != null }) {
            val tfElem = jobj["type"]
            if (tfElem is JsonPrimitive) {
              val tfVal = tfElem.content
              when (tfVal) {
                "account_touched" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeKindView.AccountTouched>(), jobj)
                }
                "access_key_touched" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeKindView.AccessKeyTouched>(), jobj)
                }
                "data_touched" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeKindView.DataTouched>(), jobj)
                }
                "contract_code_touched" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeKindView.ContractCodeTouched>(), jobj)
                }
                else -> { /* not recognized by type field, fallthrough */ }
              }
            }
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "account_touched" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeKindView.AccountTouched.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                return StateChangeKindView.AccountTouched(accountIdVal, typeVal)
              }
              "access_key_touched" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeKindView.AccessKeyTouched.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                return StateChangeKindView.AccessKeyTouched(accountIdVal, typeVal)
              }
              "data_touched" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeKindView.DataTouched.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                return StateChangeKindView.DataTouched(accountIdVal, typeVal)
              }
              "contract_code_touched" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val accountIdVal = decoder.json.decodeFromJsonElement(serializer<AccountId>(), obj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant " + key))
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeKindView.ContractCodeTouched.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                return StateChangeKindView.ContractCodeTouched(accountIdVal, typeVal)
              }
              else -> throw SerializationException("Unknown discriminator key for StateChangeKindView: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("account_touched", "access_key_touched", "data_touched", "contract_code_touched")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in StateChangeKindView")
            val tf = typeField.trim()
            when (tf) {
              "account_touched" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeKindView.AccountTouched>(), jobj)
              }
              "access_key_touched" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeKindView.AccessKeyTouched>(), jobj)
              }
              "data_touched" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeKindView.DataTouched>(), jobj)
              }
              "contract_code_touched" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeKindView.ContractCodeTouched>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for StateChangeKindView: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize StateChangeKindView with non-JSON decoder")
  }
}
