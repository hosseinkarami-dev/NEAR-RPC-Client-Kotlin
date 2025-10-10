package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView
import io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView
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

public object StateChangeWithCauseViewSerializer : KSerializer<StateChangeWithCauseView> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView") {
        element("account_update", serializer<JsonElement>().descriptor)
        element("account_deletion", serializer<JsonElement>().descriptor)
        element("access_key_update", serializer<JsonElement>().descriptor)
        element("access_key_deletion", serializer<JsonElement>().descriptor)
        element("gas_key_update", serializer<JsonElement>().descriptor)
        element("gas_key_nonce_update", serializer<JsonElement>().descriptor)
        element("gas_key_deletion", serializer<JsonElement>().descriptor)
        element("data_update", serializer<JsonElement>().descriptor)
        element("data_deletion", serializer<JsonElement>().descriptor)
        element("contract_code_update", serializer<JsonElement>().descriptor)
        element("contract_code_deletion", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: StateChangeWithCauseView) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is StateChangeWithCauseView.AccountUpdate -> {
          val map = mutableMapOf<String, JsonElement>()
          map["change"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeWithCauseView.AccountUpdate.ChangePayload>(), value.change)
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeWithCauseView.AccountUpdate.Type>(), value.type)
          map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeCauseView>(), value.cause)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeWithCauseView.AccountDeletion -> {
          val map = mutableMapOf<String, JsonElement>()
          map["change"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeWithCauseView.AccountDeletion.ChangePayload>(), value.change)
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeWithCauseView.AccountDeletion.Type>(), value.type)
          map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeCauseView>(), value.cause)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeWithCauseView.AccessKeyUpdate -> {
          val map = mutableMapOf<String, JsonElement>()
          map["change"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeWithCauseView.AccessKeyUpdate.ChangePayload>(), value.change)
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeWithCauseView.AccessKeyUpdate.Type>(), value.type)
          map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeCauseView>(), value.cause)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeWithCauseView.AccessKeyDeletion -> {
          val map = mutableMapOf<String, JsonElement>()
          map["change"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeWithCauseView.AccessKeyDeletion.ChangePayload>(), value.change)
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeWithCauseView.AccessKeyDeletion.Type>(), value.type)
          map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeCauseView>(), value.cause)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeWithCauseView.GasKeyUpdate -> {
          val map = mutableMapOf<String, JsonElement>()
          map["change"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeWithCauseView.GasKeyUpdate.ChangePayload>(), value.change)
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeWithCauseView.GasKeyUpdate.Type>(), value.type)
          map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeCauseView>(), value.cause)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeWithCauseView.GasKeyNonceUpdate -> {
          val map = mutableMapOf<String, JsonElement>()
          map["change"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeWithCauseView.GasKeyNonceUpdate.ChangePayload>(), value.change)
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeWithCauseView.GasKeyNonceUpdate.Type>(), value.type)
          map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeCauseView>(), value.cause)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeWithCauseView.GasKeyDeletion -> {
          val map = mutableMapOf<String, JsonElement>()
          map["change"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeWithCauseView.GasKeyDeletion.ChangePayload>(), value.change)
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeWithCauseView.GasKeyDeletion.Type>(), value.type)
          map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeCauseView>(), value.cause)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeWithCauseView.DataUpdate -> {
          val map = mutableMapOf<String, JsonElement>()
          map["change"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeWithCauseView.DataUpdate.ChangePayload>(), value.change)
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeWithCauseView.DataUpdate.Type>(), value.type)
          map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeCauseView>(), value.cause)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeWithCauseView.DataDeletion -> {
          val map = mutableMapOf<String, JsonElement>()
          map["change"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeWithCauseView.DataDeletion.ChangePayload>(), value.change)
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeWithCauseView.DataDeletion.Type>(), value.type)
          map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeCauseView>(), value.cause)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeWithCauseView.ContractCodeUpdate -> {
          val map = mutableMapOf<String, JsonElement>()
          map["change"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeWithCauseView.ContractCodeUpdate.ChangePayload>(), value.change)
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeWithCauseView.ContractCodeUpdate.Type>(), value.type)
          map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeCauseView>(), value.cause)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is StateChangeWithCauseView.ContractCodeDeletion -> {
          val map = mutableMapOf<String, JsonElement>()
          map["change"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeWithCauseView.ContractCodeDeletion.ChangePayload>(), value.change)
          map["type"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeWithCauseView.ContractCodeDeletion.Type>(), value.type)
          map["cause"] = jsonEncoder.json.encodeToJsonElement(serializer<StateChangeCauseView>(), value.cause)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is StateChangeWithCauseView.AccountUpdate -> out.encodeSerializableElement(descriptor, 0, serializer<StateChangeWithCauseView.AccountUpdate>(), value)
      is StateChangeWithCauseView.AccountDeletion -> out.encodeSerializableElement(descriptor, 1, serializer<StateChangeWithCauseView.AccountDeletion>(), value)
      is StateChangeWithCauseView.AccessKeyUpdate -> out.encodeSerializableElement(descriptor, 2, serializer<StateChangeWithCauseView.AccessKeyUpdate>(), value)
      is StateChangeWithCauseView.AccessKeyDeletion -> out.encodeSerializableElement(descriptor, 3, serializer<StateChangeWithCauseView.AccessKeyDeletion>(), value)
      is StateChangeWithCauseView.GasKeyUpdate -> out.encodeSerializableElement(descriptor, 4, serializer<StateChangeWithCauseView.GasKeyUpdate>(), value)
      is StateChangeWithCauseView.GasKeyNonceUpdate -> out.encodeSerializableElement(descriptor, 5, serializer<StateChangeWithCauseView.GasKeyNonceUpdate>(), value)
      is StateChangeWithCauseView.GasKeyDeletion -> out.encodeSerializableElement(descriptor, 6, serializer<StateChangeWithCauseView.GasKeyDeletion>(), value)
      is StateChangeWithCauseView.DataUpdate -> out.encodeSerializableElement(descriptor, 7, serializer<StateChangeWithCauseView.DataUpdate>(), value)
      is StateChangeWithCauseView.DataDeletion -> out.encodeSerializableElement(descriptor, 8, serializer<StateChangeWithCauseView.DataDeletion>(), value)
      is StateChangeWithCauseView.ContractCodeUpdate -> out.encodeSerializableElement(descriptor, 9, serializer<StateChangeWithCauseView.ContractCodeUpdate>(), value)
      is StateChangeWithCauseView.ContractCodeDeletion -> out.encodeSerializableElement(descriptor, 10, serializer<StateChangeWithCauseView.ContractCodeDeletion>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): StateChangeWithCauseView {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            throw SerializationException("Unknown discriminator string for StateChangeWithCauseView: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing StateChangeWithCauseView")
        }
        is JsonObject -> {
          val jobj = element
          if (listOf("cause", "change", "type").all { jobj[it] != null }) {
            val tfElem = jobj["type"]
            if (tfElem is JsonPrimitive) {
              val tfVal = tfElem.content
              when (tfVal) {
                "account_update" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.AccountUpdate>(), jobj)
                }
                "account_deletion" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.AccountDeletion>(), jobj)
                }
                "access_key_update" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.AccessKeyUpdate>(), jobj)
                }
                "access_key_deletion" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.AccessKeyDeletion>(), jobj)
                }
                "gas_key_update" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.GasKeyUpdate>(), jobj)
                }
                "gas_key_nonce_update" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.GasKeyNonceUpdate>(), jobj)
                }
                "gas_key_deletion" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.GasKeyDeletion>(), jobj)
                }
                "data_update" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.DataUpdate>(), jobj)
                }
                "data_deletion" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.DataDeletion>(), jobj)
                }
                "contract_code_update" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.ContractCodeUpdate>(), jobj)
                }
                "contract_code_deletion" -> {
                  return decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.ContractCodeDeletion>(), jobj)
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
              "account_update" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val changeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.AccountUpdate.ChangePayload>(), obj["change"] ?: throw SerializationException("Missing field 'change' for variant " + key))
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.AccountUpdate.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                val causeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView>(), obj["cause"] ?: throw SerializationException("Missing field 'cause' for variant " + key))
                return StateChangeWithCauseView.AccountUpdate(changeVal, typeVal, causeVal)
              }
              "account_deletion" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val changeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.AccountDeletion.ChangePayload>(), obj["change"] ?: throw SerializationException("Missing field 'change' for variant " + key))
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.AccountDeletion.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                val causeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView>(), obj["cause"] ?: throw SerializationException("Missing field 'cause' for variant " + key))
                return StateChangeWithCauseView.AccountDeletion(changeVal, typeVal, causeVal)
              }
              "access_key_update" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val changeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.AccessKeyUpdate.ChangePayload>(), obj["change"] ?: throw SerializationException("Missing field 'change' for variant " + key))
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.AccessKeyUpdate.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                val causeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView>(), obj["cause"] ?: throw SerializationException("Missing field 'cause' for variant " + key))
                return StateChangeWithCauseView.AccessKeyUpdate(changeVal, typeVal, causeVal)
              }
              "access_key_deletion" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val changeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.AccessKeyDeletion.ChangePayload>(), obj["change"] ?: throw SerializationException("Missing field 'change' for variant " + key))
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.AccessKeyDeletion.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                val causeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView>(), obj["cause"] ?: throw SerializationException("Missing field 'cause' for variant " + key))
                return StateChangeWithCauseView.AccessKeyDeletion(changeVal, typeVal, causeVal)
              }
              "gas_key_update" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val changeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.GasKeyUpdate.ChangePayload>(), obj["change"] ?: throw SerializationException("Missing field 'change' for variant " + key))
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.GasKeyUpdate.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                val causeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView>(), obj["cause"] ?: throw SerializationException("Missing field 'cause' for variant " + key))
                return StateChangeWithCauseView.GasKeyUpdate(changeVal, typeVal, causeVal)
              }
              "gas_key_nonce_update" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val changeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.GasKeyNonceUpdate.ChangePayload>(), obj["change"] ?: throw SerializationException("Missing field 'change' for variant " + key))
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.GasKeyNonceUpdate.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                val causeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView>(), obj["cause"] ?: throw SerializationException("Missing field 'cause' for variant " + key))
                return StateChangeWithCauseView.GasKeyNonceUpdate(changeVal, typeVal, causeVal)
              }
              "gas_key_deletion" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val changeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.GasKeyDeletion.ChangePayload>(), obj["change"] ?: throw SerializationException("Missing field 'change' for variant " + key))
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.GasKeyDeletion.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                val causeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView>(), obj["cause"] ?: throw SerializationException("Missing field 'cause' for variant " + key))
                return StateChangeWithCauseView.GasKeyDeletion(changeVal, typeVal, causeVal)
              }
              "data_update" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val changeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.DataUpdate.ChangePayload>(), obj["change"] ?: throw SerializationException("Missing field 'change' for variant " + key))
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.DataUpdate.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                val causeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView>(), obj["cause"] ?: throw SerializationException("Missing field 'cause' for variant " + key))
                return StateChangeWithCauseView.DataUpdate(changeVal, typeVal, causeVal)
              }
              "data_deletion" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val changeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.DataDeletion.ChangePayload>(), obj["change"] ?: throw SerializationException("Missing field 'change' for variant " + key))
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.DataDeletion.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                val causeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView>(), obj["cause"] ?: throw SerializationException("Missing field 'cause' for variant " + key))
                return StateChangeWithCauseView.DataDeletion(changeVal, typeVal, causeVal)
              }
              "contract_code_update" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val changeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.ContractCodeUpdate.ChangePayload>(), obj["change"] ?: throw SerializationException("Missing field 'change' for variant " + key))
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.ContractCodeUpdate.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                val causeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView>(), obj["cause"] ?: throw SerializationException("Missing field 'cause' for variant " + key))
                return StateChangeWithCauseView.ContractCodeUpdate(changeVal, typeVal, causeVal)
              }
              "contract_code_deletion" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val changeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.ContractCodeDeletion.ChangePayload>(), obj["change"] ?: throw SerializationException("Missing field 'change' for variant " + key))
                val typeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.ContractCodeDeletion.Type>(), obj["type"] ?: throw SerializationException("Missing field 'type' for variant " + key))
                val causeVal = decoder.json.decodeFromJsonElement(serializer<StateChangeCauseView>(), obj["cause"] ?: throw SerializationException("Missing field 'cause' for variant " + key))
                return StateChangeWithCauseView.ContractCodeDeletion(changeVal, typeVal, causeVal)
              }
              else -> throw SerializationException("Unknown discriminator key for StateChangeWithCauseView: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("account_update", "account_deletion", "access_key_update", "access_key_deletion", "gas_key_update", "gas_key_nonce_update", "gas_key_deletion", "data_update", "data_deletion", "contract_code_update", "contract_code_deletion")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in StateChangeWithCauseView")
            val tf = typeField.trim()
            when (tf) {
              "account_update" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.AccountUpdate>(), jobj)
              }
              "account_deletion" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.AccountDeletion>(), jobj)
              }
              "access_key_update" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.AccessKeyUpdate>(), jobj)
              }
              "access_key_deletion" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.AccessKeyDeletion>(), jobj)
              }
              "gas_key_update" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.GasKeyUpdate>(), jobj)
              }
              "gas_key_nonce_update" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.GasKeyNonceUpdate>(), jobj)
              }
              "gas_key_deletion" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.GasKeyDeletion>(), jobj)
              }
              "data_update" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.DataUpdate>(), jobj)
              }
              "data_deletion" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.DataDeletion>(), jobj)
              }
              "contract_code_update" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.ContractCodeUpdate>(), jobj)
              }
              "contract_code_deletion" -> {
                return decoder.json.decodeFromJsonElement(serializer<StateChangeWithCauseView.ContractCodeDeletion>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for StateChangeWithCauseView: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize StateChangeWithCauseView with non-JSON decoder")
  }
}
