package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind
import io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError
import io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError
import io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError
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

public object ActionErrorKindSerializer : KSerializer<ActionErrorKind> {
  override val descriptor: SerialDescriptor =
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind") {
        element("AccountAlreadyExists", serializer<JsonElement>().descriptor)
        element("AccountDoesNotExist", serializer<JsonElement>().descriptor)
        element("CreateAccountOnlyByRegistrar", serializer<JsonElement>().descriptor)
        element("CreateAccountNotAllowed", serializer<JsonElement>().descriptor)
        element("ActorNoPermission", serializer<JsonElement>().descriptor)
        element("DeleteKeyDoesNotExist", serializer<JsonElement>().descriptor)
        element("AddKeyAlreadyExists", serializer<JsonElement>().descriptor)
        element("DeleteAccountStaking", serializer<JsonElement>().descriptor)
        element("LackBalanceForState", serializer<JsonElement>().descriptor)
        element("TriesToUnstake", serializer<JsonElement>().descriptor)
        element("TriesToStake", serializer<JsonElement>().descriptor)
        element("InsufficientStake", serializer<JsonElement>().descriptor)
        element("FunctionCallError", serializer<JsonElement>().descriptor)
        element("NewReceiptValidationError", serializer<JsonElement>().descriptor)
        element("OnlyImplicitAccountCreationAllowed", serializer<JsonElement>().descriptor)
        element("DeleteAccountWithLargeState", serializer<JsonElement>().descriptor)
        element("DelegateActionInvalidSignature", serializer<JsonElement>().descriptor)
        element("DelegateActionSenderDoesNotMatchTxReceiver", serializer<JsonElement>().descriptor)
        element("DelegateActionExpired", serializer<JsonElement>().descriptor)
        element("DelegateActionAccessKeyError", serializer<JsonElement>().descriptor)
        element("DelegateActionInvalidNonce", serializer<JsonElement>().descriptor)
        element("DelegateActionNonceTooLarge", serializer<JsonElement>().descriptor)
        element("GlobalContractDoesNotExist", serializer<JsonElement>().descriptor)
      }

  override fun serialize(encoder: Encoder, `value`: ActionErrorKind) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        is ActionErrorKind.AccountAlreadyExists -> {
          val map = mutableMapOf<String, JsonElement>()
          map["AccountAlreadyExists"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionErrorKind.AccountAlreadyExists.AccountAlreadyExistsPayload>(), value.accountAlreadyExists)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionErrorKind.AccountDoesNotExist -> {
          val map = mutableMapOf<String, JsonElement>()
          map["AccountDoesNotExist"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionErrorKind.AccountDoesNotExist.AccountDoesNotExistPayload>(), value.accountDoesNotExist)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionErrorKind.CreateAccountOnlyByRegistrar -> {
          val map = mutableMapOf<String, JsonElement>()
          map["CreateAccountOnlyByRegistrar"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionErrorKind.CreateAccountOnlyByRegistrar.CreateAccountOnlyByRegistrarPayload>(), value.createAccountOnlyByRegistrar)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionErrorKind.CreateAccountNotAllowed -> {
          val map = mutableMapOf<String, JsonElement>()
          map["CreateAccountNotAllowed"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionErrorKind.CreateAccountNotAllowed.CreateAccountNotAllowedPayload>(), value.createAccountNotAllowed)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionErrorKind.ActorNoPermission -> {
          val map = mutableMapOf<String, JsonElement>()
          map["ActorNoPermission"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionErrorKind.ActorNoPermission.ActorNoPermissionPayload>(), value.actorNoPermission)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionErrorKind.DeleteKeyDoesNotExist -> {
          val map = mutableMapOf<String, JsonElement>()
          map["DeleteKeyDoesNotExist"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionErrorKind.DeleteKeyDoesNotExist.DeleteKeyDoesNotExistPayload>(), value.deleteKeyDoesNotExist)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionErrorKind.AddKeyAlreadyExists -> {
          val map = mutableMapOf<String, JsonElement>()
          map["AddKeyAlreadyExists"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionErrorKind.AddKeyAlreadyExists.AddKeyAlreadyExistsPayload>(), value.addKeyAlreadyExists)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionErrorKind.DeleteAccountStaking -> {
          val map = mutableMapOf<String, JsonElement>()
          map["DeleteAccountStaking"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionErrorKind.DeleteAccountStaking.DeleteAccountStakingPayload>(), value.deleteAccountStaking)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionErrorKind.LackBalanceForState -> {
          val map = mutableMapOf<String, JsonElement>()
          map["LackBalanceForState"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionErrorKind.LackBalanceForState.LackBalanceForStatePayload>(), value.lackBalanceForState)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionErrorKind.TriesToUnstake -> {
          val map = mutableMapOf<String, JsonElement>()
          map["TriesToUnstake"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionErrorKind.TriesToUnstake.TriesToUnstakePayload>(), value.triesToUnstake)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionErrorKind.TriesToStake -> {
          val map = mutableMapOf<String, JsonElement>()
          map["TriesToStake"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionErrorKind.TriesToStake.TriesToStakePayload>(), value.triesToStake)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionErrorKind.InsufficientStake -> {
          val map = mutableMapOf<String, JsonElement>()
          map["InsufficientStake"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionErrorKind.InsufficientStake.InsufficientStakePayload>(), value.insufficientStake)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionErrorKind.FunctionCallError -> {
          val map = mutableMapOf<String, JsonElement>()
          map["FunctionCallError"] = jsonEncoder.json.encodeToJsonElement(serializer<FunctionCallError>(), value.functionCallError)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionErrorKind.NewReceiptValidationError -> {
          val map = mutableMapOf<String, JsonElement>()
          map["NewReceiptValidationError"] = jsonEncoder.json.encodeToJsonElement(serializer<ReceiptValidationError>(), value.newReceiptValidationError)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionErrorKind.OnlyImplicitAccountCreationAllowed -> {
          val map = mutableMapOf<String, JsonElement>()
          map["OnlyImplicitAccountCreationAllowed"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionErrorKind.OnlyImplicitAccountCreationAllowed.OnlyImplicitAccountCreationAllowedPayload>(), value.onlyImplicitAccountCreationAllowed)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionErrorKind.DeleteAccountWithLargeState -> {
          val map = mutableMapOf<String, JsonElement>()
          map["DeleteAccountWithLargeState"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionErrorKind.DeleteAccountWithLargeState.DeleteAccountWithLargeStatePayload>(), value.deleteAccountWithLargeState)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionErrorKind.DelegateActionInvalidSignature -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("DelegateActionInvalidSignature"))
        }
        is ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver -> {
          val map = mutableMapOf<String, JsonElement>()
          map["DelegateActionSenderDoesNotMatchTxReceiver"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver.DelegateActionSenderDoesNotMatchTxReceiverPayload>(), value.delegateActionSenderDoesNotMatchTxReceiver)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionErrorKind.DelegateActionExpired -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("DelegateActionExpired"))
        }
        is ActionErrorKind.DelegateActionAccessKeyError -> {
          val map = mutableMapOf<String, JsonElement>()
          map["DelegateActionAccessKeyError"] = jsonEncoder.json.encodeToJsonElement(serializer<InvalidAccessKeyError>(), value.delegateActionAccessKeyError)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionErrorKind.DelegateActionInvalidNonce -> {
          val map = mutableMapOf<String, JsonElement>()
          map["DelegateActionInvalidNonce"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionErrorKind.DelegateActionInvalidNonce.DelegateActionInvalidNoncePayload>(), value.delegateActionInvalidNonce)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionErrorKind.DelegateActionNonceTooLarge -> {
          val map = mutableMapOf<String, JsonElement>()
          map["DelegateActionNonceTooLarge"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionErrorKind.DelegateActionNonceTooLarge.DelegateActionNonceTooLargePayload>(), value.delegateActionNonceTooLarge)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
        is ActionErrorKind.GlobalContractDoesNotExist -> {
          val map = mutableMapOf<String, JsonElement>()
          map["GlobalContractDoesNotExist"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionErrorKind.GlobalContractDoesNotExist.GlobalContractDoesNotExistPayload>(), value.globalContractDoesNotExist)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
        }
      }
      return
    }
    val out = encoder.beginStructure(descriptor)
    when (value) {
      is ActionErrorKind.AccountAlreadyExists -> out.encodeSerializableElement(descriptor, 0, serializer<ActionErrorKind.AccountAlreadyExists>(), value)
      is ActionErrorKind.AccountDoesNotExist -> out.encodeSerializableElement(descriptor, 1, serializer<ActionErrorKind.AccountDoesNotExist>(), value)
      is ActionErrorKind.CreateAccountOnlyByRegistrar -> out.encodeSerializableElement(descriptor, 2, serializer<ActionErrorKind.CreateAccountOnlyByRegistrar>(), value)
      is ActionErrorKind.CreateAccountNotAllowed -> out.encodeSerializableElement(descriptor, 3, serializer<ActionErrorKind.CreateAccountNotAllowed>(), value)
      is ActionErrorKind.ActorNoPermission -> out.encodeSerializableElement(descriptor, 4, serializer<ActionErrorKind.ActorNoPermission>(), value)
      is ActionErrorKind.DeleteKeyDoesNotExist -> out.encodeSerializableElement(descriptor, 5, serializer<ActionErrorKind.DeleteKeyDoesNotExist>(), value)
      is ActionErrorKind.AddKeyAlreadyExists -> out.encodeSerializableElement(descriptor, 6, serializer<ActionErrorKind.AddKeyAlreadyExists>(), value)
      is ActionErrorKind.DeleteAccountStaking -> out.encodeSerializableElement(descriptor, 7, serializer<ActionErrorKind.DeleteAccountStaking>(), value)
      is ActionErrorKind.LackBalanceForState -> out.encodeSerializableElement(descriptor, 8, serializer<ActionErrorKind.LackBalanceForState>(), value)
      is ActionErrorKind.TriesToUnstake -> out.encodeSerializableElement(descriptor, 9, serializer<ActionErrorKind.TriesToUnstake>(), value)
      is ActionErrorKind.TriesToStake -> out.encodeSerializableElement(descriptor, 10, serializer<ActionErrorKind.TriesToStake>(), value)
      is ActionErrorKind.InsufficientStake -> out.encodeSerializableElement(descriptor, 11, serializer<ActionErrorKind.InsufficientStake>(), value)
      is ActionErrorKind.FunctionCallError -> out.encodeSerializableElement(descriptor, 12, serializer<ActionErrorKind.FunctionCallError>(), value)
      is ActionErrorKind.NewReceiptValidationError -> out.encodeSerializableElement(descriptor, 13, serializer<ActionErrorKind.NewReceiptValidationError>(), value)
      is ActionErrorKind.OnlyImplicitAccountCreationAllowed -> out.encodeSerializableElement(descriptor, 14, serializer<ActionErrorKind.OnlyImplicitAccountCreationAllowed>(), value)
      is ActionErrorKind.DeleteAccountWithLargeState -> out.encodeSerializableElement(descriptor, 15, serializer<ActionErrorKind.DeleteAccountWithLargeState>(), value)
      is ActionErrorKind.DelegateActionInvalidSignature -> out.encodeSerializableElement(descriptor, 16, serializer<ActionErrorKind.DelegateActionInvalidSignature>(), value)
      is ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver -> out.encodeSerializableElement(descriptor, 17, serializer<ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver>(), value)
      is ActionErrorKind.DelegateActionExpired -> out.encodeSerializableElement(descriptor, 18, serializer<ActionErrorKind.DelegateActionExpired>(), value)
      is ActionErrorKind.DelegateActionAccessKeyError -> out.encodeSerializableElement(descriptor, 19, serializer<ActionErrorKind.DelegateActionAccessKeyError>(), value)
      is ActionErrorKind.DelegateActionInvalidNonce -> out.encodeSerializableElement(descriptor, 20, serializer<ActionErrorKind.DelegateActionInvalidNonce>(), value)
      is ActionErrorKind.DelegateActionNonceTooLarge -> out.encodeSerializableElement(descriptor, 21, serializer<ActionErrorKind.DelegateActionNonceTooLarge>(), value)
      is ActionErrorKind.GlobalContractDoesNotExist -> out.encodeSerializableElement(descriptor, 22, serializer<ActionErrorKind.GlobalContractDoesNotExist>(), value)
    }
    out.endStructure(descriptor)
  }

  override fun deserialize(decoder: Decoder): ActionErrorKind {
    if (decoder is JsonDecoder) {
      val element = decoder.decodeJsonElement()
      when (element) {
        is JsonPrimitive -> {
          if (element.isString) {
            val s = element.content
            if (s == "DelegateActionInvalidSignature") return ActionErrorKind.DelegateActionInvalidSignature()
            if (s == "DelegateActionExpired") return ActionErrorKind.DelegateActionExpired()
          }
          throw SerializationException("Unknown discriminator (primitive) for ActionErrorKind")
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing ActionErrorKind")
        }
        is JsonObject -> {
          val jobj = element
          if (jobj["AccountAlreadyExists"] != null) {
            return ActionErrorKind.AccountAlreadyExists(decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.AccountAlreadyExists.AccountAlreadyExistsPayload>(), jobj["AccountAlreadyExists"]!!))
          }
          if (jobj["AccountDoesNotExist"] != null) {
            return ActionErrorKind.AccountDoesNotExist(decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.AccountDoesNotExist.AccountDoesNotExistPayload>(), jobj["AccountDoesNotExist"]!!))
          }
          if (jobj["CreateAccountOnlyByRegistrar"] != null) {
            return ActionErrorKind.CreateAccountOnlyByRegistrar(decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.CreateAccountOnlyByRegistrar.CreateAccountOnlyByRegistrarPayload>(), jobj["CreateAccountOnlyByRegistrar"]!!))
          }
          if (jobj["CreateAccountNotAllowed"] != null) {
            return ActionErrorKind.CreateAccountNotAllowed(decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.CreateAccountNotAllowed.CreateAccountNotAllowedPayload>(), jobj["CreateAccountNotAllowed"]!!))
          }
          if (jobj["ActorNoPermission"] != null) {
            return ActionErrorKind.ActorNoPermission(decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.ActorNoPermission.ActorNoPermissionPayload>(), jobj["ActorNoPermission"]!!))
          }
          if (jobj["DeleteKeyDoesNotExist"] != null) {
            return ActionErrorKind.DeleteKeyDoesNotExist(decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DeleteKeyDoesNotExist.DeleteKeyDoesNotExistPayload>(), jobj["DeleteKeyDoesNotExist"]!!))
          }
          if (jobj["AddKeyAlreadyExists"] != null) {
            return ActionErrorKind.AddKeyAlreadyExists(decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.AddKeyAlreadyExists.AddKeyAlreadyExistsPayload>(), jobj["AddKeyAlreadyExists"]!!))
          }
          if (jobj["DeleteAccountStaking"] != null) {
            return ActionErrorKind.DeleteAccountStaking(decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DeleteAccountStaking.DeleteAccountStakingPayload>(), jobj["DeleteAccountStaking"]!!))
          }
          if (jobj["LackBalanceForState"] != null) {
            return ActionErrorKind.LackBalanceForState(decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.LackBalanceForState.LackBalanceForStatePayload>(), jobj["LackBalanceForState"]!!))
          }
          if (jobj["TriesToUnstake"] != null) {
            return ActionErrorKind.TriesToUnstake(decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.TriesToUnstake.TriesToUnstakePayload>(), jobj["TriesToUnstake"]!!))
          }
          if (jobj["TriesToStake"] != null) {
            return ActionErrorKind.TriesToStake(decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.TriesToStake.TriesToStakePayload>(), jobj["TriesToStake"]!!))
          }
          if (jobj["InsufficientStake"] != null) {
            return ActionErrorKind.InsufficientStake(decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.InsufficientStake.InsufficientStakePayload>(), jobj["InsufficientStake"]!!))
          }
          if (jobj["FunctionCallError"] != null) {
            return ActionErrorKind.FunctionCallError(decoder.json.decodeFromJsonElement(serializer<FunctionCallError>(), jobj["FunctionCallError"]!!))
          }
          if (jobj["NewReceiptValidationError"] != null) {
            return ActionErrorKind.NewReceiptValidationError(decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError>(), jobj["NewReceiptValidationError"]!!))
          }
          if (jobj["OnlyImplicitAccountCreationAllowed"] != null) {
            return ActionErrorKind.OnlyImplicitAccountCreationAllowed(decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.OnlyImplicitAccountCreationAllowed.OnlyImplicitAccountCreationAllowedPayload>(), jobj["OnlyImplicitAccountCreationAllowed"]!!))
          }
          if (jobj["DeleteAccountWithLargeState"] != null) {
            return ActionErrorKind.DeleteAccountWithLargeState(decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DeleteAccountWithLargeState.DeleteAccountWithLargeStatePayload>(), jobj["DeleteAccountWithLargeState"]!!))
          }
          if (jobj["DelegateActionSenderDoesNotMatchTxReceiver"] != null) {
            return ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver(decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver.DelegateActionSenderDoesNotMatchTxReceiverPayload>(), jobj["DelegateActionSenderDoesNotMatchTxReceiver"]!!))
          }
          if (jobj["DelegateActionAccessKeyError"] != null) {
            return ActionErrorKind.DelegateActionAccessKeyError(decoder.json.decodeFromJsonElement(serializer<InvalidAccessKeyError>(), jobj["DelegateActionAccessKeyError"]!!))
          }
          if (jobj["DelegateActionInvalidNonce"] != null) {
            return ActionErrorKind.DelegateActionInvalidNonce(decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DelegateActionInvalidNonce.DelegateActionInvalidNoncePayload>(), jobj["DelegateActionInvalidNonce"]!!))
          }
          if (jobj["DelegateActionNonceTooLarge"] != null) {
            return ActionErrorKind.DelegateActionNonceTooLarge(decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DelegateActionNonceTooLarge.DelegateActionNonceTooLargePayload>(), jobj["DelegateActionNonceTooLarge"]!!))
          }
          if (jobj["GlobalContractDoesNotExist"] != null) {
            return ActionErrorKind.GlobalContractDoesNotExist(decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.GlobalContractDoesNotExist.GlobalContractDoesNotExistPayload>(), jobj["GlobalContractDoesNotExist"]!!))
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "AccountAlreadyExists" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.AccountAlreadyExists>(), obj)
              }
              "AccountDoesNotExist" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.AccountDoesNotExist>(), obj)
              }
              "CreateAccountOnlyByRegistrar" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.CreateAccountOnlyByRegistrar>(), obj)
              }
              "CreateAccountNotAllowed" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.CreateAccountNotAllowed>(), obj)
              }
              "ActorNoPermission" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.ActorNoPermission>(), obj)
              }
              "DeleteKeyDoesNotExist" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DeleteKeyDoesNotExist>(), obj)
              }
              "AddKeyAlreadyExists" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.AddKeyAlreadyExists>(), obj)
              }
              "DeleteAccountStaking" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DeleteAccountStaking>(), obj)
              }
              "LackBalanceForState" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.LackBalanceForState>(), obj)
              }
              "TriesToUnstake" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.TriesToUnstake>(), obj)
              }
              "TriesToStake" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.TriesToStake>(), obj)
              }
              "InsufficientStake" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.InsufficientStake>(), obj)
              }
              "FunctionCallError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.FunctionCallError>(), obj)
              }
              "NewReceiptValidationError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.NewReceiptValidationError>(), obj)
              }
              "OnlyImplicitAccountCreationAllowed" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.OnlyImplicitAccountCreationAllowed>(), obj)
              }
              "DeleteAccountWithLargeState" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DeleteAccountWithLargeState>(), obj)
              }
              "DelegateActionSenderDoesNotMatchTxReceiver" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver>(), obj)
              }
              "DelegateActionAccessKeyError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DelegateActionAccessKeyError>(), obj)
              }
              "DelegateActionInvalidNonce" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DelegateActionInvalidNonce>(), obj)
              }
              "DelegateActionNonceTooLarge" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DelegateActionNonceTooLarge>(), obj)
              }
              "GlobalContractDoesNotExist" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.GlobalContractDoesNotExist>(), obj)
              }
              "DelegateActionInvalidSignature" -> {
                return ActionErrorKind.DelegateActionInvalidSignature()
              }
              "DelegateActionExpired" -> {
                return ActionErrorKind.DelegateActionExpired()
              }
              else -> throw SerializationException("Unknown discriminator key for ActionErrorKind: " + key)
            }
          }
          else {
            var typeField: String? = null
            if (typeField == null) {
              val knownVariantNames = setOf("AccountAlreadyExists", "AccountDoesNotExist", "CreateAccountOnlyByRegistrar", "CreateAccountNotAllowed", "ActorNoPermission", "DeleteKeyDoesNotExist", "AddKeyAlreadyExists", "DeleteAccountStaking", "LackBalanceForState", "TriesToUnstake", "TriesToStake", "InsufficientStake", "FunctionCallError", "NewReceiptValidationError", "OnlyImplicitAccountCreationAllowed", "DeleteAccountWithLargeState", "DelegateActionInvalidSignature", "DelegateActionSenderDoesNotMatchTxReceiver", "DelegateActionExpired", "DelegateActionAccessKeyError", "DelegateActionInvalidNonce", "DelegateActionNonceTooLarge", "GlobalContractDoesNotExist")
              for ((k, v) in jobj.entries) {
                if (v is JsonPrimitive && v.isString) {
                    val s = v.content
                    if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
            }
              }
            }
            if (typeField == null) throw SerializationException("Missing discriminator or recognizable variant in ActionErrorKind")
            val tf = typeField.trim()
            when (tf) {
              "AccountAlreadyExists" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.AccountAlreadyExists>(), jobj)
              }
              "AccountDoesNotExist" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.AccountDoesNotExist>(), jobj)
              }
              "CreateAccountOnlyByRegistrar" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.CreateAccountOnlyByRegistrar>(), jobj)
              }
              "CreateAccountNotAllowed" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.CreateAccountNotAllowed>(), jobj)
              }
              "ActorNoPermission" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.ActorNoPermission>(), jobj)
              }
              "DeleteKeyDoesNotExist" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DeleteKeyDoesNotExist>(), jobj)
              }
              "AddKeyAlreadyExists" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.AddKeyAlreadyExists>(), jobj)
              }
              "DeleteAccountStaking" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DeleteAccountStaking>(), jobj)
              }
              "LackBalanceForState" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.LackBalanceForState>(), jobj)
              }
              "TriesToUnstake" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.TriesToUnstake>(), jobj)
              }
              "TriesToStake" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.TriesToStake>(), jobj)
              }
              "InsufficientStake" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.InsufficientStake>(), jobj)
              }
              "FunctionCallError" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.FunctionCallError>(), jobj)
              }
              "NewReceiptValidationError" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.NewReceiptValidationError>(), jobj)
              }
              "OnlyImplicitAccountCreationAllowed" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.OnlyImplicitAccountCreationAllowed>(), jobj)
              }
              "DeleteAccountWithLargeState" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DeleteAccountWithLargeState>(), jobj)
              }
              "DelegateActionSenderDoesNotMatchTxReceiver" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver>(), jobj)
              }
              "DelegateActionAccessKeyError" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DelegateActionAccessKeyError>(), jobj)
              }
              "DelegateActionInvalidNonce" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DelegateActionInvalidNonce>(), jobj)
              }
              "DelegateActionNonceTooLarge" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DelegateActionNonceTooLarge>(), jobj)
              }
              "GlobalContractDoesNotExist" -> {
                return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.GlobalContractDoesNotExist>(), jobj)
              }
              "DelegateActionInvalidSignature" -> return ActionErrorKind.DelegateActionInvalidSignature()
              "DelegateActionExpired" -> return ActionErrorKind.DelegateActionExpired()
              else -> throw SerializationException("Unknown type discriminator for ActionErrorKind: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize ActionErrorKind with non-JSON decoder")
  }
}
