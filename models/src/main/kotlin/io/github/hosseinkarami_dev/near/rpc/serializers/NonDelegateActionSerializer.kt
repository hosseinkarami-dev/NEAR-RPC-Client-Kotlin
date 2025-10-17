package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.AddKeyAction
import io.github.hosseinkarami_dev.near.rpc.models.CreateAccountAction
import io.github.hosseinkarami_dev.near.rpc.models.DeleteAccountAction
import io.github.hosseinkarami_dev.near.rpc.models.DeleteKeyAction
import io.github.hosseinkarami_dev.near.rpc.models.DeployContractAction
import io.github.hosseinkarami_dev.near.rpc.models.DeployGlobalContractAction
import io.github.hosseinkarami_dev.near.rpc.models.DeterministicStateInitAction
import io.github.hosseinkarami_dev.near.rpc.models.FunctionCallAction
import io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction
import io.github.hosseinkarami_dev.near.rpc.models.StakeAction
import io.github.hosseinkarami_dev.near.rpc.models.TransferAction
import io.github.hosseinkarami_dev.near.rpc.models.UseGlobalContractAction
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

public object NonDelegateActionSerializer : KSerializer<NonDelegateAction> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction") {
        element("CreateAccount", serializer<JsonElement>().descriptor)
        element("DeployContract", serializer<JsonElement>().descriptor)
        element("FunctionCall", serializer<JsonElement>().descriptor)
        element("Transfer", serializer<JsonElement>().descriptor)
        element("Stake", serializer<JsonElement>().descriptor)
        element("AddKey", serializer<JsonElement>().descriptor)
        element("DeleteKey", serializer<JsonElement>().descriptor)
        element("DeleteAccount", serializer<JsonElement>().descriptor)
        element("DeployGlobalContract", serializer<JsonElement>().descriptor)
        element("UseGlobalContract", serializer<JsonElement>().descriptor)
        element("DeterministicStateInit", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: NonDelegateAction) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is NonDelegateAction.CreateAccount -> {
          val map = mutableMapOf<String, JsonElement>()
          map["CreateAccount"] = jsonEncoder.json.encodeToJsonElement(serializer<CreateAccountAction>(), value.createAccount)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is NonDelegateAction.DeployContract -> {
          val map = mutableMapOf<String, JsonElement>()
          map["DeployContract"] = jsonEncoder.json.encodeToJsonElement(serializer<DeployContractAction>(), value.deployContract)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is NonDelegateAction.FunctionCall -> {
          val map = mutableMapOf<String, JsonElement>()
          map["FunctionCall"] = jsonEncoder.json.encodeToJsonElement(serializer<FunctionCallAction>(), value.functionCall)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is NonDelegateAction.Transfer -> {
          val map = mutableMapOf<String, JsonElement>()
          map["Transfer"] = jsonEncoder.json.encodeToJsonElement(serializer<TransferAction>(), value.transfer)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is NonDelegateAction.Stake -> {
          val map = mutableMapOf<String, JsonElement>()
          map["Stake"] = jsonEncoder.json.encodeToJsonElement(serializer<StakeAction>(), value.stake)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is NonDelegateAction.AddKey -> {
          val map = mutableMapOf<String, JsonElement>()
          map["AddKey"] = jsonEncoder.json.encodeToJsonElement(serializer<AddKeyAction>(), value.addKey)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is NonDelegateAction.DeleteKey -> {
          val map = mutableMapOf<String, JsonElement>()
          map["DeleteKey"] = jsonEncoder.json.encodeToJsonElement(serializer<DeleteKeyAction>(), value.deleteKey)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is NonDelegateAction.DeleteAccount -> {
          val map = mutableMapOf<String, JsonElement>()
          map["DeleteAccount"] = jsonEncoder.json.encodeToJsonElement(serializer<DeleteAccountAction>(), value.deleteAccount)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is NonDelegateAction.DeployGlobalContract -> {
          val map = mutableMapOf<String, JsonElement>()
          map["DeployGlobalContract"] = jsonEncoder.json.encodeToJsonElement(serializer<DeployGlobalContractAction>(), value.deployGlobalContract)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is NonDelegateAction.UseGlobalContract -> {
          val map = mutableMapOf<String, JsonElement>()
          map["UseGlobalContract"] = jsonEncoder.json.encodeToJsonElement(serializer<UseGlobalContractAction>(), value.useGlobalContract)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is NonDelegateAction.DeterministicStateInit -> {
          val map = mutableMapOf<String, JsonElement>()
          map["DeterministicStateInit"] = jsonEncoder.json.encodeToJsonElement(serializer<DeterministicStateInitAction>(), value.deterministicStateInit)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is NonDelegateAction.CreateAccount -> out.encodeSerializableElement(descriptor, 0, serializer<NonDelegateAction.CreateAccount>(), value)
      is NonDelegateAction.DeployContract -> out.encodeSerializableElement(descriptor, 1, serializer<NonDelegateAction.DeployContract>(), value)
      is NonDelegateAction.FunctionCall -> out.encodeSerializableElement(descriptor, 2, serializer<NonDelegateAction.FunctionCall>(), value)
      is NonDelegateAction.Transfer -> out.encodeSerializableElement(descriptor, 3, serializer<NonDelegateAction.Transfer>(), value)
      is NonDelegateAction.Stake -> out.encodeSerializableElement(descriptor, 4, serializer<NonDelegateAction.Stake>(), value)
      is NonDelegateAction.AddKey -> out.encodeSerializableElement(descriptor, 5, serializer<NonDelegateAction.AddKey>(), value)
      is NonDelegateAction.DeleteKey -> out.encodeSerializableElement(descriptor, 6, serializer<NonDelegateAction.DeleteKey>(), value)
      is NonDelegateAction.DeleteAccount -> out.encodeSerializableElement(descriptor, 7, serializer<NonDelegateAction.DeleteAccount>(), value)
      is NonDelegateAction.DeployGlobalContract -> out.encodeSerializableElement(descriptor, 8, serializer<NonDelegateAction.DeployGlobalContract>(), value)
      is NonDelegateAction.UseGlobalContract -> out.encodeSerializableElement(descriptor, 9, serializer<NonDelegateAction.UseGlobalContract>(), value)
      is NonDelegateAction.DeterministicStateInit -> out.encodeSerializableElement(descriptor, 10, serializer<NonDelegateAction.DeterministicStateInit>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): NonDelegateAction {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
          }
          throw SerializationException("Unknown discriminator (primitive) for NonDelegateAction")
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing NonDelegateAction")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj["CreateAccount"] != null) {
            return NonDelegateAction.CreateAccount(decoder.json.decodeFromJsonElement(serializer<CreateAccountAction>(), jobj["CreateAccount"]!!))
          }
          if (jobj["DeployContract"] != null) {
            return NonDelegateAction.DeployContract(decoder.json.decodeFromJsonElement(serializer<DeployContractAction>(), jobj["DeployContract"]!!))
          }
          if (jobj["FunctionCall"] != null) {
            return NonDelegateAction.FunctionCall(decoder.json.decodeFromJsonElement(serializer<FunctionCallAction>(), jobj["FunctionCall"]!!))
          }
          if (jobj["Transfer"] != null) {
            return NonDelegateAction.Transfer(decoder.json.decodeFromJsonElement(serializer<TransferAction>(), jobj["Transfer"]!!))
          }
          if (jobj["Stake"] != null) {
            return NonDelegateAction.Stake(decoder.json.decodeFromJsonElement(serializer<StakeAction>(), jobj["Stake"]!!))
          }
          if (jobj["AddKey"] != null) {
            return NonDelegateAction.AddKey(decoder.json.decodeFromJsonElement(serializer<AddKeyAction>(), jobj["AddKey"]!!))
          }
          if (jobj["DeleteKey"] != null) {
            return NonDelegateAction.DeleteKey(decoder.json.decodeFromJsonElement(serializer<DeleteKeyAction>(), jobj["DeleteKey"]!!))
          }
          if (jobj["DeleteAccount"] != null) {
            return NonDelegateAction.DeleteAccount(decoder.json.decodeFromJsonElement(serializer<DeleteAccountAction>(), jobj["DeleteAccount"]!!))
          }
          if (jobj["DeployGlobalContract"] != null) {
            return NonDelegateAction.DeployGlobalContract(decoder.json.decodeFromJsonElement(serializer<DeployGlobalContractAction>(), jobj["DeployGlobalContract"]!!))
          }
          if (jobj["UseGlobalContract"] != null) {
            return NonDelegateAction.UseGlobalContract(decoder.json.decodeFromJsonElement(serializer<UseGlobalContractAction>(), jobj["UseGlobalContract"]!!))
          }
          if (jobj["DeterministicStateInit"] != null) {
            return NonDelegateAction.DeterministicStateInit(decoder.json.decodeFromJsonElement(serializer<DeterministicStateInitAction>(), jobj["DeterministicStateInit"]!!))
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "CreateAccount" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.CreateAccount>(), obj)
              }
              "DeployContract" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.DeployContract>(), obj)
              }
              "FunctionCall" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.FunctionCall>(), obj)
              }
              "Transfer" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.Transfer>(), obj)
              }
              "Stake" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.Stake>(), obj)
              }
              "AddKey" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.AddKey>(), obj)
              }
              "DeleteKey" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.DeleteKey>(), obj)
              }
              "DeleteAccount" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.DeleteAccount>(), obj)
              }
              "DeployGlobalContract" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.DeployGlobalContract>(), obj)
              }
              "UseGlobalContract" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.UseGlobalContract>(), obj)
              }
              "DeterministicStateInit" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.DeterministicStateInit>(), obj)
              }
              else -> throw SerializationException("Unknown discriminator key for NonDelegateAction: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("CreateAccount", "DeployContract", "FunctionCall", "Transfer", "Stake", "AddKey", "DeleteKey", "DeleteAccount", "DeployGlobalContract", "UseGlobalContract", "DeterministicStateInit")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in NonDelegateAction")
            val tf = typeField.trim()
            when (tf) {
              "CreateAccount" -> {
                return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.CreateAccount>(), jobj)
              }
              "DeployContract" -> {
                return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.DeployContract>(), jobj)
              }
              "FunctionCall" -> {
                return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.FunctionCall>(), jobj)
              }
              "Transfer" -> {
                return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.Transfer>(), jobj)
              }
              "Stake" -> {
                return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.Stake>(), jobj)
              }
              "AddKey" -> {
                return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.AddKey>(), jobj)
              }
              "DeleteKey" -> {
                return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.DeleteKey>(), jobj)
              }
              "DeleteAccount" -> {
                return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.DeleteAccount>(), jobj)
              }
              "DeployGlobalContract" -> {
                return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.DeployGlobalContract>(), jobj)
              }
              "UseGlobalContract" -> {
                return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.UseGlobalContract>(), jobj)
              }
              "DeterministicStateInit" -> {
                return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.DeterministicStateInit>(), jobj)
              }
              else -> throw SerializationException("Unknown type discriminator for NonDelegateAction: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize NonDelegateAction with non-JSON decoder")
  }
}
