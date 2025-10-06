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
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ActionView")

  override fun serialize(encoder: Encoder, `value`: ActionView) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        ActionView.CreateAccount -> {
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
      ActionView.CreateAccount -> out.encodeStringElement(descriptor, 0, "CreateAccount")
      is ActionView.DeployContract -> out.encodeSerializableElement(descriptor, 1, serializer<ActionView.DeployContract.DeployContractPayload>(), value.deployContract)
      is ActionView.FunctionCall -> out.encodeSerializableElement(descriptor, 2, serializer<ActionView.FunctionCall.FunctionCallPayload>(), value.functionCall)
      is ActionView.Transfer -> out.encodeSerializableElement(descriptor, 3, serializer<ActionView.Transfer.TransferPayload>(), value.transfer)
      is ActionView.Stake -> out.encodeSerializableElement(descriptor, 4, serializer<ActionView.Stake.StakePayload>(), value.stake)
      is ActionView.AddKey -> out.encodeSerializableElement(descriptor, 5, serializer<ActionView.AddKey.AddKeyPayload>(), value.addKey)
      is ActionView.DeleteKey -> out.encodeSerializableElement(descriptor, 6, serializer<ActionView.DeleteKey.DeleteKeyPayload>(), value.deleteKey)
      is ActionView.DeleteAccount -> out.encodeSerializableElement(descriptor, 7, serializer<ActionView.DeleteAccount.DeleteAccountPayload>(), value.deleteAccount)
      is ActionView.Delegate -> out.encodeSerializableElement(descriptor, 8, serializer<ActionView.Delegate.DelegatePayload>(), value.delegate)
      is ActionView.DeployGlobalContract -> out.encodeSerializableElement(descriptor, 9, serializer<ActionView.DeployGlobalContract.DeployGlobalContractPayload>(), value.deployGlobalContract)
      is ActionView.DeployGlobalContractByAccountId -> out.encodeSerializableElement(descriptor, 10, serializer<ActionView.DeployGlobalContractByAccountId.DeployGlobalContractByAccountIdPayload>(), value.deployGlobalContractByAccountId)
      is ActionView.UseGlobalContract -> out.encodeSerializableElement(descriptor, 11, serializer<ActionView.UseGlobalContract.UseGlobalContractPayload>(), value.useGlobalContract)
      is ActionView.UseGlobalContractByAccountId -> out.encodeSerializableElement(descriptor, 12, serializer<ActionView.UseGlobalContractByAccountId.UseGlobalContractByAccountIdPayload>(), value.useGlobalContractByAccountId)
      is ActionView.DeterministicStateInit -> out.encodeSerializableElement(descriptor, 13, serializer<ActionView.DeterministicStateInit.DeterministicStateInitPayload>(), value.deterministicStateInit)
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
            throw SerializationException("Unknown discriminator string for ActionView: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing ActionView")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["DeployContract"] != null) {
            val deployContractVal = decoder.json.decodeFromJsonElement(serializer<ActionView.DeployContract.DeployContractPayload>(), jobj["DeployContract"] ?: throw SerializationException("Missing field 'DeployContract' for variant " + "DeployContract"))
            return ActionView.DeployContract(deployContractVal)
          }
          if (jobj["FunctionCall"] != null) {
            val functionCallVal = decoder.json.decodeFromJsonElement(serializer<ActionView.FunctionCall.FunctionCallPayload>(), jobj["FunctionCall"] ?: throw SerializationException("Missing field 'FunctionCall' for variant " + "FunctionCall"))
            return ActionView.FunctionCall(functionCallVal)
          }
          if (jobj["Transfer"] != null) {
            val transferVal = decoder.json.decodeFromJsonElement(serializer<ActionView.Transfer.TransferPayload>(), jobj["Transfer"] ?: throw SerializationException("Missing field 'Transfer' for variant " + "Transfer"))
            return ActionView.Transfer(transferVal)
          }
          if (jobj["Stake"] != null) {
            val stakeVal = decoder.json.decodeFromJsonElement(serializer<ActionView.Stake.StakePayload>(), jobj["Stake"] ?: throw SerializationException("Missing field 'Stake' for variant " + "Stake"))
            return ActionView.Stake(stakeVal)
          }
          if (jobj["AddKey"] != null) {
            val addKeyVal = decoder.json.decodeFromJsonElement(serializer<ActionView.AddKey.AddKeyPayload>(), jobj["AddKey"] ?: throw SerializationException("Missing field 'AddKey' for variant " + "AddKey"))
            return ActionView.AddKey(addKeyVal)
          }
          if (jobj["DeleteKey"] != null) {
            val deleteKeyVal = decoder.json.decodeFromJsonElement(serializer<ActionView.DeleteKey.DeleteKeyPayload>(), jobj["DeleteKey"] ?: throw SerializationException("Missing field 'DeleteKey' for variant " + "DeleteKey"))
            return ActionView.DeleteKey(deleteKeyVal)
          }
          if (jobj["DeleteAccount"] != null) {
            val deleteAccountVal = decoder.json.decodeFromJsonElement(serializer<ActionView.DeleteAccount.DeleteAccountPayload>(), jobj["DeleteAccount"] ?: throw SerializationException("Missing field 'DeleteAccount' for variant " + "DeleteAccount"))
            return ActionView.DeleteAccount(deleteAccountVal)
          }
          if (jobj["Delegate"] != null) {
            val delegateVal = decoder.json.decodeFromJsonElement(serializer<ActionView.Delegate.DelegatePayload>(), jobj["Delegate"] ?: throw SerializationException("Missing field 'Delegate' for variant " + "Delegate"))
            return ActionView.Delegate(delegateVal)
          }
          if (jobj["DeployGlobalContract"] != null) {
            val deployGlobalContractVal = decoder.json.decodeFromJsonElement(serializer<ActionView.DeployGlobalContract.DeployGlobalContractPayload>(), jobj["DeployGlobalContract"] ?: throw SerializationException("Missing field 'DeployGlobalContract' for variant " + "DeployGlobalContract"))
            return ActionView.DeployGlobalContract(deployGlobalContractVal)
          }
          if (jobj["DeployGlobalContractByAccountId"] != null) {
            val deployGlobalContractByAccountIdVal = decoder.json.decodeFromJsonElement(serializer<ActionView.DeployGlobalContractByAccountId.DeployGlobalContractByAccountIdPayload>(), jobj["DeployGlobalContractByAccountId"] ?: throw SerializationException("Missing field 'DeployGlobalContractByAccountId' for variant " + "DeployGlobalContractByAccountId"))
            return ActionView.DeployGlobalContractByAccountId(deployGlobalContractByAccountIdVal)
          }
          if (jobj["UseGlobalContract"] != null) {
            val useGlobalContractVal = decoder.json.decodeFromJsonElement(serializer<ActionView.UseGlobalContract.UseGlobalContractPayload>(), jobj["UseGlobalContract"] ?: throw SerializationException("Missing field 'UseGlobalContract' for variant " + "UseGlobalContract"))
            return ActionView.UseGlobalContract(useGlobalContractVal)
          }
          if (jobj["UseGlobalContractByAccountId"] != null) {
            val useGlobalContractByAccountIdVal = decoder.json.decodeFromJsonElement(serializer<ActionView.UseGlobalContractByAccountId.UseGlobalContractByAccountIdPayload>(), jobj["UseGlobalContractByAccountId"] ?: throw SerializationException("Missing field 'UseGlobalContractByAccountId' for variant " + "UseGlobalContractByAccountId"))
            return ActionView.UseGlobalContractByAccountId(useGlobalContractByAccountIdVal)
          }
          if (jobj["DeterministicStateInit"] != null) {
            val deterministicStateInitVal = decoder.json.decodeFromJsonElement(serializer<ActionView.DeterministicStateInit.DeterministicStateInitPayload>(), jobj["DeterministicStateInit"] ?: throw SerializationException("Missing field 'DeterministicStateInit' for variant " + "DeterministicStateInit"))
            return ActionView.DeterministicStateInit(deterministicStateInitVal)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "DeployContract" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val deployContractVal = decoder.json.decodeFromJsonElement(serializer<ActionView.DeployContract.DeployContractPayload>(), obj["DeployContract"] ?: throw SerializationException("Missing field 'DeployContract' for variant " + key))
                return ActionView.DeployContract(deployContractVal)
              }
              "FunctionCall" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val functionCallVal = decoder.json.decodeFromJsonElement(serializer<ActionView.FunctionCall.FunctionCallPayload>(), obj["FunctionCall"] ?: throw SerializationException("Missing field 'FunctionCall' for variant " + key))
                return ActionView.FunctionCall(functionCallVal)
              }
              "Transfer" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val transferVal = decoder.json.decodeFromJsonElement(serializer<ActionView.Transfer.TransferPayload>(), obj["Transfer"] ?: throw SerializationException("Missing field 'Transfer' for variant " + key))
                return ActionView.Transfer(transferVal)
              }
              "Stake" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val stakeVal = decoder.json.decodeFromJsonElement(serializer<ActionView.Stake.StakePayload>(), obj["Stake"] ?: throw SerializationException("Missing field 'Stake' for variant " + key))
                return ActionView.Stake(stakeVal)
              }
              "AddKey" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val addKeyVal = decoder.json.decodeFromJsonElement(serializer<ActionView.AddKey.AddKeyPayload>(), obj["AddKey"] ?: throw SerializationException("Missing field 'AddKey' for variant " + key))
                return ActionView.AddKey(addKeyVal)
              }
              "DeleteKey" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val deleteKeyVal = decoder.json.decodeFromJsonElement(serializer<ActionView.DeleteKey.DeleteKeyPayload>(), obj["DeleteKey"] ?: throw SerializationException("Missing field 'DeleteKey' for variant " + key))
                return ActionView.DeleteKey(deleteKeyVal)
              }
              "DeleteAccount" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val deleteAccountVal = decoder.json.decodeFromJsonElement(serializer<ActionView.DeleteAccount.DeleteAccountPayload>(), obj["DeleteAccount"] ?: throw SerializationException("Missing field 'DeleteAccount' for variant " + key))
                return ActionView.DeleteAccount(deleteAccountVal)
              }
              "Delegate" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val delegateVal = decoder.json.decodeFromJsonElement(serializer<ActionView.Delegate.DelegatePayload>(), obj["Delegate"] ?: throw SerializationException("Missing field 'Delegate' for variant " + key))
                return ActionView.Delegate(delegateVal)
              }
              "DeployGlobalContract" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val deployGlobalContractVal = decoder.json.decodeFromJsonElement(serializer<ActionView.DeployGlobalContract.DeployGlobalContractPayload>(), obj["DeployGlobalContract"] ?: throw SerializationException("Missing field 'DeployGlobalContract' for variant " + key))
                return ActionView.DeployGlobalContract(deployGlobalContractVal)
              }
              "DeployGlobalContractByAccountId" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val deployGlobalContractByAccountIdVal = decoder.json.decodeFromJsonElement(serializer<ActionView.DeployGlobalContractByAccountId.DeployGlobalContractByAccountIdPayload>(), obj["DeployGlobalContractByAccountId"] ?: throw SerializationException("Missing field 'DeployGlobalContractByAccountId' for variant " + key))
                return ActionView.DeployGlobalContractByAccountId(deployGlobalContractByAccountIdVal)
              }
              "UseGlobalContract" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val useGlobalContractVal = decoder.json.decodeFromJsonElement(serializer<ActionView.UseGlobalContract.UseGlobalContractPayload>(), obj["UseGlobalContract"] ?: throw SerializationException("Missing field 'UseGlobalContract' for variant " + key))
                return ActionView.UseGlobalContract(useGlobalContractVal)
              }
              "UseGlobalContractByAccountId" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val useGlobalContractByAccountIdVal = decoder.json.decodeFromJsonElement(serializer<ActionView.UseGlobalContractByAccountId.UseGlobalContractByAccountIdPayload>(), obj["UseGlobalContractByAccountId"] ?: throw SerializationException("Missing field 'UseGlobalContractByAccountId' for variant " + key))
                return ActionView.UseGlobalContractByAccountId(useGlobalContractByAccountIdVal)
              }
              "DeterministicStateInit" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val deterministicStateInitVal = decoder.json.decodeFromJsonElement(serializer<ActionView.DeterministicStateInit.DeterministicStateInitPayload>(), obj["DeterministicStateInit"] ?: throw SerializationException("Missing field 'DeterministicStateInit' for variant " + key))
                return ActionView.DeterministicStateInit(deterministicStateInitVal)
              }
              "CreateAccount" -> {
                return ActionView.CreateAccount
              }
              else -> throw SerializationException("Unknown discriminator key for ActionView: " + key)
            }
          }
          else {
            val typeField = jobj["type"]?.jsonPrimitive?.contentOrNull ?: throw SerializationException("Missing 'type' discriminator in ActionView")
            when (typeField) {
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
              else -> throw SerializationException("Unknown type discriminator for ActionView: " + typeField)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize ActionView with non-JSON decoder")
  }
}
