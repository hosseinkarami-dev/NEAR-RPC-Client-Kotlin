package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.ActionView
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

public object ActionViewSerializer : KSerializer<ActionView> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ActionView") {
        element("CreateAccount", serializer<JsonElement>().descriptor)
        element("DeployContract", serializer<JsonElement>().descriptor)
        element("FunctionCall", serializer<JsonElement>().descriptor)
        element("Transfer", serializer<JsonElement>().descriptor)
        element("Stake", serializer<JsonElement>().descriptor)
        element("AddKey", serializer<JsonElement>().descriptor)
        element("DeleteKey", serializer<JsonElement>().descriptor)
        element("DeleteAccount", serializer<JsonElement>().descriptor)
        element("Delegate", serializer<JsonElement>().descriptor)
        element("DeployGlobalContract", serializer<JsonElement>().descriptor)
        element("DeployGlobalContractByAccountId", serializer<JsonElement>().descriptor)
        element("UseGlobalContract", serializer<JsonElement>().descriptor)
        element("UseGlobalContractByAccountId", serializer<JsonElement>().descriptor)
        element("DeterministicStateInit", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: ActionView) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is ActionView.CreateAccount -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("CreateAccount"))
        }
        is ActionView.DeployContract -> {
          val map = mutableMapOf<String, JsonElement>()
          map["DeployContract"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionView.DeployContract.DeployContractPayload>(), value.deployContract)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionView.FunctionCall -> {
          val map = mutableMapOf<String, JsonElement>()
          map["FunctionCall"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionView.FunctionCall.FunctionCallPayload>(), value.functionCall)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionView.Transfer -> {
          val map = mutableMapOf<String, JsonElement>()
          map["Transfer"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionView.Transfer.TransferPayload>(), value.transfer)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionView.Stake -> {
          val map = mutableMapOf<String, JsonElement>()
          map["Stake"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionView.Stake.StakePayload>(), value.stake)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionView.AddKey -> {
          val map = mutableMapOf<String, JsonElement>()
          map["AddKey"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionView.AddKey.AddKeyPayload>(), value.addKey)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionView.DeleteKey -> {
          val map = mutableMapOf<String, JsonElement>()
          map["DeleteKey"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionView.DeleteKey.DeleteKeyPayload>(), value.deleteKey)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionView.DeleteAccount -> {
          val map = mutableMapOf<String, JsonElement>()
          map["DeleteAccount"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionView.DeleteAccount.DeleteAccountPayload>(), value.deleteAccount)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionView.Delegate -> {
          val map = mutableMapOf<String, JsonElement>()
          map["Delegate"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionView.Delegate.DelegatePayload>(), value.delegate)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionView.DeployGlobalContract -> {
          val map = mutableMapOf<String, JsonElement>()
          map["DeployGlobalContract"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionView.DeployGlobalContract.DeployGlobalContractPayload>(), value.deployGlobalContract)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionView.DeployGlobalContractByAccountId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["DeployGlobalContractByAccountId"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionView.DeployGlobalContractByAccountId.DeployGlobalContractByAccountIdPayload>(), value.deployGlobalContractByAccountId)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionView.UseGlobalContract -> {
          val map = mutableMapOf<String, JsonElement>()
          map["UseGlobalContract"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionView.UseGlobalContract.UseGlobalContractPayload>(), value.useGlobalContract)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionView.UseGlobalContractByAccountId -> {
          val map = mutableMapOf<String, JsonElement>()
          map["UseGlobalContractByAccountId"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionView.UseGlobalContractByAccountId.UseGlobalContractByAccountIdPayload>(), value.useGlobalContractByAccountId)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionView.DeterministicStateInit -> {
          val map = mutableMapOf<String, JsonElement>()
          map["DeterministicStateInit"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionView.DeterministicStateInit.DeterministicStateInitPayload>(), value.deterministicStateInit)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is ActionView.CreateAccount -> out.encodeSerializableElement(descriptor, 0, serializer<ActionView.CreateAccount>(), value)
      is ActionView.DeployContract -> out.encodeSerializableElement(descriptor, 1, serializer<ActionView.DeployContract>(), value)
      is ActionView.FunctionCall -> out.encodeSerializableElement(descriptor, 2, serializer<ActionView.FunctionCall>(), value)
      is ActionView.Transfer -> out.encodeSerializableElement(descriptor, 3, serializer<ActionView.Transfer>(), value)
      is ActionView.Stake -> out.encodeSerializableElement(descriptor, 4, serializer<ActionView.Stake>(), value)
      is ActionView.AddKey -> out.encodeSerializableElement(descriptor, 5, serializer<ActionView.AddKey>(), value)
      is ActionView.DeleteKey -> out.encodeSerializableElement(descriptor, 6, serializer<ActionView.DeleteKey>(), value)
      is ActionView.DeleteAccount -> out.encodeSerializableElement(descriptor, 7, serializer<ActionView.DeleteAccount>(), value)
      is ActionView.Delegate -> out.encodeSerializableElement(descriptor, 8, serializer<ActionView.Delegate>(), value)
      is ActionView.DeployGlobalContract -> out.encodeSerializableElement(descriptor, 9, serializer<ActionView.DeployGlobalContract>(), value)
      is ActionView.DeployGlobalContractByAccountId -> out.encodeSerializableElement(descriptor, 10, serializer<ActionView.DeployGlobalContractByAccountId>(), value)
      is ActionView.UseGlobalContract -> out.encodeSerializableElement(descriptor, 11, serializer<ActionView.UseGlobalContract>(), value)
      is ActionView.UseGlobalContractByAccountId -> out.encodeSerializableElement(descriptor, 12, serializer<ActionView.UseGlobalContractByAccountId>(), value)
      is ActionView.DeterministicStateInit -> out.encodeSerializableElement(descriptor, 13, serializer<ActionView.DeterministicStateInit>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): ActionView {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            if (s == "CreateAccount") return ActionView.CreateAccount
          }
          throw SerializationException("Unknown discriminator (primitive) for ActionView")
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing ActionView")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj["DeployContract"] != null) {
            return ActionView.DeployContract(decoder.json.decodeFromJsonElement(serializer<ActionView.DeployContract.DeployContractPayload>(), jobj["DeployContract"]!!))
          }
          if (jobj["FunctionCall"] != null) {
            return ActionView.FunctionCall(decoder.json.decodeFromJsonElement(serializer<ActionView.FunctionCall.FunctionCallPayload>(), jobj["FunctionCall"]!!))
          }
          if (jobj["Transfer"] != null) {
            return ActionView.Transfer(decoder.json.decodeFromJsonElement(serializer<ActionView.Transfer.TransferPayload>(), jobj["Transfer"]!!))
          }
          if (jobj["Stake"] != null) {
            return ActionView.Stake(decoder.json.decodeFromJsonElement(serializer<ActionView.Stake.StakePayload>(), jobj["Stake"]!!))
          }
          if (jobj["AddKey"] != null) {
            return ActionView.AddKey(decoder.json.decodeFromJsonElement(serializer<ActionView.AddKey.AddKeyPayload>(), jobj["AddKey"]!!))
          }
          if (jobj["DeleteKey"] != null) {
            return ActionView.DeleteKey(decoder.json.decodeFromJsonElement(serializer<ActionView.DeleteKey.DeleteKeyPayload>(), jobj["DeleteKey"]!!))
          }
          if (jobj["DeleteAccount"] != null) {
            return ActionView.DeleteAccount(decoder.json.decodeFromJsonElement(serializer<ActionView.DeleteAccount.DeleteAccountPayload>(), jobj["DeleteAccount"]!!))
          }
          if (jobj["Delegate"] != null) {
            return ActionView.Delegate(decoder.json.decodeFromJsonElement(serializer<ActionView.Delegate.DelegatePayload>(), jobj["Delegate"]!!))
          }
          if (jobj["DeployGlobalContract"] != null) {
            return ActionView.DeployGlobalContract(decoder.json.decodeFromJsonElement(serializer<ActionView.DeployGlobalContract.DeployGlobalContractPayload>(), jobj["DeployGlobalContract"]!!))
          }
          if (jobj["DeployGlobalContractByAccountId"] != null) {
            return ActionView.DeployGlobalContractByAccountId(decoder.json.decodeFromJsonElement(serializer<ActionView.DeployGlobalContractByAccountId.DeployGlobalContractByAccountIdPayload>(), jobj["DeployGlobalContractByAccountId"]!!))
          }
          if (jobj["UseGlobalContract"] != null) {
            return ActionView.UseGlobalContract(decoder.json.decodeFromJsonElement(serializer<ActionView.UseGlobalContract.UseGlobalContractPayload>(), jobj["UseGlobalContract"]!!))
          }
          if (jobj["UseGlobalContractByAccountId"] != null) {
            return ActionView.UseGlobalContractByAccountId(decoder.json.decodeFromJsonElement(serializer<ActionView.UseGlobalContractByAccountId.UseGlobalContractByAccountIdPayload>(), jobj["UseGlobalContractByAccountId"]!!))
          }
          if (jobj["DeterministicStateInit"] != null) {
            return ActionView.DeterministicStateInit(decoder.json.decodeFromJsonElement(serializer<ActionView.DeterministicStateInit.DeterministicStateInitPayload>(), jobj["DeterministicStateInit"]!!))
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "DeployContract" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionView.DeployContract>(), obj)
              }
              "FunctionCall" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionView.FunctionCall>(), obj)
              }
              "Transfer" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionView.Transfer>(), obj)
              }
              "Stake" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionView.Stake>(), obj)
              }
              "AddKey" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionView.AddKey>(), obj)
              }
              "DeleteKey" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionView.DeleteKey>(), obj)
              }
              "DeleteAccount" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionView.DeleteAccount>(), obj)
              }
              "Delegate" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionView.Delegate>(), obj)
              }
              "DeployGlobalContract" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionView.DeployGlobalContract>(), obj)
              }
              "DeployGlobalContractByAccountId" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionView.DeployGlobalContractByAccountId>(), obj)
              }
              "UseGlobalContract" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionView.UseGlobalContract>(), obj)
              }
              "UseGlobalContractByAccountId" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionView.UseGlobalContractByAccountId>(), obj)
              }
              "DeterministicStateInit" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionView.DeterministicStateInit>(), obj)
              }
              "CreateAccount" -> {
                return ActionView.CreateAccount
              }
              else -> throw SerializationException("Unknown discriminator key for ActionView: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("CreateAccount", "DeployContract", "FunctionCall", "Transfer", "Stake", "AddKey", "DeleteKey", "DeleteAccount", "Delegate", "DeployGlobalContract", "DeployGlobalContractByAccountId", "UseGlobalContract", "UseGlobalContractByAccountId", "DeterministicStateInit")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in ActionView")
            val tf = typeField.trim()
            when (tf) {
              "DeployContract" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionView.DeployContract>(), jobj)
              }
              "FunctionCall" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionView.FunctionCall>(), jobj)
              }
              "Transfer" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionView.Transfer>(), jobj)
              }
              "Stake" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionView.Stake>(), jobj)
              }
              "AddKey" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionView.AddKey>(), jobj)
              }
              "DeleteKey" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionView.DeleteKey>(), jobj)
              }
              "DeleteAccount" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionView.DeleteAccount>(), jobj)
              }
              "Delegate" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionView.Delegate>(), jobj)
              }
              "DeployGlobalContract" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionView.DeployGlobalContract>(), jobj)
              }
              "DeployGlobalContractByAccountId" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionView.DeployGlobalContractByAccountId>(), jobj)
              }
              "UseGlobalContract" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionView.UseGlobalContract>(), jobj)
              }
              "UseGlobalContractByAccountId" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionView.UseGlobalContractByAccountId>(), jobj)
              }
              "DeterministicStateInit" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionView.DeterministicStateInit>(), jobj)
              }
              "CreateAccount" -> return ActionView.CreateAccount
              else -> throw SerializationException("Unknown type discriminator for ActionView: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize ActionView with non-JSON decoder")
  }
}
