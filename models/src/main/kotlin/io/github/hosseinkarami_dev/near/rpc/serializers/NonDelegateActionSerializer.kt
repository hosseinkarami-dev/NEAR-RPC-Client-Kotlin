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
            throw SerializationException("Unknown discriminator string for NonDelegateAction: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing NonDelegateAction")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["CreateAccount"] != null) {
            val createAccountVal = decoder.json.decodeFromJsonElement(serializer<CreateAccountAction>(), jobj["CreateAccount"] ?: throw SerializationException("Missing field 'CreateAccount' for variant " + "CreateAccount"))
            return NonDelegateAction.CreateAccount(createAccountVal)
          }
          if (jobj["DeployContract"] != null) {
            val deployContractVal = decoder.json.decodeFromJsonElement(serializer<DeployContractAction>(), jobj["DeployContract"] ?: throw SerializationException("Missing field 'DeployContract' for variant " + "DeployContract"))
            return NonDelegateAction.DeployContract(deployContractVal)
          }
          if (jobj["FunctionCall"] != null) {
            val functionCallVal = decoder.json.decodeFromJsonElement(serializer<FunctionCallAction>(), jobj["FunctionCall"] ?: throw SerializationException("Missing field 'FunctionCall' for variant " + "FunctionCall"))
            return NonDelegateAction.FunctionCall(functionCallVal)
          }
          if (jobj["Transfer"] != null) {
            val transferVal = decoder.json.decodeFromJsonElement(serializer<TransferAction>(), jobj["Transfer"] ?: throw SerializationException("Missing field 'Transfer' for variant " + "Transfer"))
            return NonDelegateAction.Transfer(transferVal)
          }
          if (jobj["Stake"] != null) {
            val stakeVal = decoder.json.decodeFromJsonElement(serializer<StakeAction>(), jobj["Stake"] ?: throw SerializationException("Missing field 'Stake' for variant " + "Stake"))
            return NonDelegateAction.Stake(stakeVal)
          }
          if (jobj["AddKey"] != null) {
            val addKeyVal = decoder.json.decodeFromJsonElement(serializer<AddKeyAction>(), jobj["AddKey"] ?: throw SerializationException("Missing field 'AddKey' for variant " + "AddKey"))
            return NonDelegateAction.AddKey(addKeyVal)
          }
          if (jobj["DeleteKey"] != null) {
            val deleteKeyVal = decoder.json.decodeFromJsonElement(serializer<DeleteKeyAction>(), jobj["DeleteKey"] ?: throw SerializationException("Missing field 'DeleteKey' for variant " + "DeleteKey"))
            return NonDelegateAction.DeleteKey(deleteKeyVal)
          }
          if (jobj["DeleteAccount"] != null) {
            val deleteAccountVal = decoder.json.decodeFromJsonElement(serializer<DeleteAccountAction>(), jobj["DeleteAccount"] ?: throw SerializationException("Missing field 'DeleteAccount' for variant " + "DeleteAccount"))
            return NonDelegateAction.DeleteAccount(deleteAccountVal)
          }
          if (jobj["DeployGlobalContract"] != null) {
            val deployGlobalContractVal = decoder.json.decodeFromJsonElement(serializer<DeployGlobalContractAction>(), jobj["DeployGlobalContract"] ?: throw SerializationException("Missing field 'DeployGlobalContract' for variant " + "DeployGlobalContract"))
            return NonDelegateAction.DeployGlobalContract(deployGlobalContractVal)
          }
          if (jobj["UseGlobalContract"] != null) {
            val useGlobalContractVal = decoder.json.decodeFromJsonElement(serializer<UseGlobalContractAction>(), jobj["UseGlobalContract"] ?: throw SerializationException("Missing field 'UseGlobalContract' for variant " + "UseGlobalContract"))
            return NonDelegateAction.UseGlobalContract(useGlobalContractVal)
          }
          if (jobj["DeterministicStateInit"] != null) {
            val deterministicStateInitVal = decoder.json.decodeFromJsonElement(serializer<DeterministicStateInitAction>(), jobj["DeterministicStateInit"] ?: throw SerializationException("Missing field 'DeterministicStateInit' for variant " + "DeterministicStateInit"))
            return NonDelegateAction.DeterministicStateInit(deterministicStateInitVal)
          }
          if (listOf("CreateAccount").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.CreateAccount>(), jobj)
          }
          if (listOf("DeployContract").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.DeployContract>(), jobj)
          }
          if (listOf("FunctionCall").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.FunctionCall>(), jobj)
          }
          if (listOf("Transfer").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.Transfer>(), jobj)
          }
          if (listOf("Stake").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.Stake>(), jobj)
          }
          if (listOf("AddKey").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.AddKey>(), jobj)
          }
          if (listOf("DeleteKey").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.DeleteKey>(), jobj)
          }
          if (listOf("DeleteAccount").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.DeleteAccount>(), jobj)
          }
          if (listOf("DeployGlobalContract").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.DeployGlobalContract>(), jobj)
          }
          if (listOf("UseGlobalContract").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.UseGlobalContract>(), jobj)
          }
          if (listOf("DeterministicStateInit").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<NonDelegateAction.DeterministicStateInit>(), jobj)
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
