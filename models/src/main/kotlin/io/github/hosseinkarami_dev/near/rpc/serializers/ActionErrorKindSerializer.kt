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
      buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind")

  override fun serialize(encoder: Encoder, `value`: ActionErrorKind) {
    if (encoder is JsonEncoder) {
      val jsonEncoder = encoder
      when (value) {
        ActionErrorKind.DelegateActionInvalidSignature -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("DelegateActionInvalidSignature"))
        }
        ActionErrorKind.DelegateActionExpired -> {
          jsonEncoder.encodeJsonElement(JsonPrimitive("DelegateActionExpired"))
        }
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
        is ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver -> {
          val map = mutableMapOf<String, JsonElement>()
          map["DelegateActionSenderDoesNotMatchTxReceiver"] = jsonEncoder.json.encodeToJsonElement(serializer<ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver.DelegateActionSenderDoesNotMatchTxReceiverPayload>(), value.delegateActionSenderDoesNotMatchTxReceiver)
          val payload = JsonObject(map)
          jsonEncoder.encodeJsonElement(payload)
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
      is ActionErrorKind.AccountAlreadyExists -> out.encodeSerializableElement(descriptor, 0, serializer<ActionErrorKind.AccountAlreadyExists.AccountAlreadyExistsPayload>(), value.accountAlreadyExists)
      is ActionErrorKind.AccountDoesNotExist -> out.encodeSerializableElement(descriptor, 1, serializer<ActionErrorKind.AccountDoesNotExist.AccountDoesNotExistPayload>(), value.accountDoesNotExist)
      is ActionErrorKind.CreateAccountOnlyByRegistrar -> out.encodeSerializableElement(descriptor, 2, serializer<ActionErrorKind.CreateAccountOnlyByRegistrar.CreateAccountOnlyByRegistrarPayload>(), value.createAccountOnlyByRegistrar)
      is ActionErrorKind.CreateAccountNotAllowed -> out.encodeSerializableElement(descriptor, 3, serializer<ActionErrorKind.CreateAccountNotAllowed.CreateAccountNotAllowedPayload>(), value.createAccountNotAllowed)
      is ActionErrorKind.ActorNoPermission -> out.encodeSerializableElement(descriptor, 4, serializer<ActionErrorKind.ActorNoPermission.ActorNoPermissionPayload>(), value.actorNoPermission)
      is ActionErrorKind.DeleteKeyDoesNotExist -> out.encodeSerializableElement(descriptor, 5, serializer<ActionErrorKind.DeleteKeyDoesNotExist.DeleteKeyDoesNotExistPayload>(), value.deleteKeyDoesNotExist)
      is ActionErrorKind.AddKeyAlreadyExists -> out.encodeSerializableElement(descriptor, 6, serializer<ActionErrorKind.AddKeyAlreadyExists.AddKeyAlreadyExistsPayload>(), value.addKeyAlreadyExists)
      is ActionErrorKind.DeleteAccountStaking -> out.encodeSerializableElement(descriptor, 7, serializer<ActionErrorKind.DeleteAccountStaking.DeleteAccountStakingPayload>(), value.deleteAccountStaking)
      is ActionErrorKind.LackBalanceForState -> out.encodeSerializableElement(descriptor, 8, serializer<ActionErrorKind.LackBalanceForState.LackBalanceForStatePayload>(), value.lackBalanceForState)
      is ActionErrorKind.TriesToUnstake -> out.encodeSerializableElement(descriptor, 9, serializer<ActionErrorKind.TriesToUnstake.TriesToUnstakePayload>(), value.triesToUnstake)
      is ActionErrorKind.TriesToStake -> out.encodeSerializableElement(descriptor, 10, serializer<ActionErrorKind.TriesToStake.TriesToStakePayload>(), value.triesToStake)
      is ActionErrorKind.InsufficientStake -> out.encodeSerializableElement(descriptor, 11, serializer<ActionErrorKind.InsufficientStake.InsufficientStakePayload>(), value.insufficientStake)
      is ActionErrorKind.FunctionCallError -> out.encodeSerializableElement(descriptor, 12, serializer<FunctionCallError>(), value.functionCallError)
      is ActionErrorKind.NewReceiptValidationError -> out.encodeSerializableElement(descriptor, 13, serializer<ReceiptValidationError>(), value.newReceiptValidationError)
      is ActionErrorKind.OnlyImplicitAccountCreationAllowed -> out.encodeSerializableElement(descriptor, 14, serializer<ActionErrorKind.OnlyImplicitAccountCreationAllowed.OnlyImplicitAccountCreationAllowedPayload>(), value.onlyImplicitAccountCreationAllowed)
      is ActionErrorKind.DeleteAccountWithLargeState -> out.encodeSerializableElement(descriptor, 15, serializer<ActionErrorKind.DeleteAccountWithLargeState.DeleteAccountWithLargeStatePayload>(), value.deleteAccountWithLargeState)
      ActionErrorKind.DelegateActionInvalidSignature -> out.encodeStringElement(descriptor, 16, "DelegateActionInvalidSignature")
      is ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver -> out.encodeSerializableElement(descriptor, 17, serializer<ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver.DelegateActionSenderDoesNotMatchTxReceiverPayload>(), value.delegateActionSenderDoesNotMatchTxReceiver)
      ActionErrorKind.DelegateActionExpired -> out.encodeStringElement(descriptor, 18, "DelegateActionExpired")
      is ActionErrorKind.DelegateActionAccessKeyError -> out.encodeSerializableElement(descriptor, 19, serializer<InvalidAccessKeyError>(), value.delegateActionAccessKeyError)
      is ActionErrorKind.DelegateActionInvalidNonce -> out.encodeSerializableElement(descriptor, 20, serializer<ActionErrorKind.DelegateActionInvalidNonce.DelegateActionInvalidNoncePayload>(), value.delegateActionInvalidNonce)
      is ActionErrorKind.DelegateActionNonceTooLarge -> out.encodeSerializableElement(descriptor, 21, serializer<ActionErrorKind.DelegateActionNonceTooLarge.DelegateActionNonceTooLargePayload>(), value.delegateActionNonceTooLarge)
      is ActionErrorKind.GlobalContractDoesNotExist -> out.encodeSerializableElement(descriptor, 22, serializer<ActionErrorKind.GlobalContractDoesNotExist.GlobalContractDoesNotExistPayload>(), value.globalContractDoesNotExist)
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
            if (s == "DelegateActionInvalidSignature") return ActionErrorKind.DelegateActionInvalidSignature
            if (s == "DelegateActionExpired") return ActionErrorKind.DelegateActionExpired
            throw SerializationException("Unknown discriminator string for ActionErrorKind: " + s)
          }
        }
        is JsonArray -> {
          throw SerializationException("Unexpected JSON array while deserializing ActionErrorKind")
        }
        is JsonObject -> {
          val jobj = element
          // fieldBased union: detect variant by unique field presence
          if (jobj["AccountAlreadyExists"] != null) {
            val accountAlreadyExistsVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.AccountAlreadyExists.AccountAlreadyExistsPayload>(), jobj["AccountAlreadyExists"] ?: throw SerializationException("Missing field 'AccountAlreadyExists' for variant " + "AccountAlreadyExists"))
            return ActionErrorKind.AccountAlreadyExists(accountAlreadyExistsVal)
          }
          if (jobj["AccountDoesNotExist"] != null) {
            val accountDoesNotExistVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.AccountDoesNotExist.AccountDoesNotExistPayload>(), jobj["AccountDoesNotExist"] ?: throw SerializationException("Missing field 'AccountDoesNotExist' for variant " + "AccountDoesNotExist"))
            return ActionErrorKind.AccountDoesNotExist(accountDoesNotExistVal)
          }
          if (jobj["CreateAccountOnlyByRegistrar"] != null) {
            val createAccountOnlyByRegistrarVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.CreateAccountOnlyByRegistrar.CreateAccountOnlyByRegistrarPayload>(), jobj["CreateAccountOnlyByRegistrar"] ?: throw SerializationException("Missing field 'CreateAccountOnlyByRegistrar' for variant " + "CreateAccountOnlyByRegistrar"))
            return ActionErrorKind.CreateAccountOnlyByRegistrar(createAccountOnlyByRegistrarVal)
          }
          if (jobj["CreateAccountNotAllowed"] != null) {
            val createAccountNotAllowedVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.CreateAccountNotAllowed.CreateAccountNotAllowedPayload>(), jobj["CreateAccountNotAllowed"] ?: throw SerializationException("Missing field 'CreateAccountNotAllowed' for variant " + "CreateAccountNotAllowed"))
            return ActionErrorKind.CreateAccountNotAllowed(createAccountNotAllowedVal)
          }
          if (jobj["ActorNoPermission"] != null) {
            val actorNoPermissionVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.ActorNoPermission.ActorNoPermissionPayload>(), jobj["ActorNoPermission"] ?: throw SerializationException("Missing field 'ActorNoPermission' for variant " + "ActorNoPermission"))
            return ActionErrorKind.ActorNoPermission(actorNoPermissionVal)
          }
          if (jobj["DeleteKeyDoesNotExist"] != null) {
            val deleteKeyDoesNotExistVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DeleteKeyDoesNotExist.DeleteKeyDoesNotExistPayload>(), jobj["DeleteKeyDoesNotExist"] ?: throw SerializationException("Missing field 'DeleteKeyDoesNotExist' for variant " + "DeleteKeyDoesNotExist"))
            return ActionErrorKind.DeleteKeyDoesNotExist(deleteKeyDoesNotExistVal)
          }
          if (jobj["AddKeyAlreadyExists"] != null) {
            val addKeyAlreadyExistsVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.AddKeyAlreadyExists.AddKeyAlreadyExistsPayload>(), jobj["AddKeyAlreadyExists"] ?: throw SerializationException("Missing field 'AddKeyAlreadyExists' for variant " + "AddKeyAlreadyExists"))
            return ActionErrorKind.AddKeyAlreadyExists(addKeyAlreadyExistsVal)
          }
          if (jobj["DeleteAccountStaking"] != null) {
            val deleteAccountStakingVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DeleteAccountStaking.DeleteAccountStakingPayload>(), jobj["DeleteAccountStaking"] ?: throw SerializationException("Missing field 'DeleteAccountStaking' for variant " + "DeleteAccountStaking"))
            return ActionErrorKind.DeleteAccountStaking(deleteAccountStakingVal)
          }
          if (jobj["LackBalanceForState"] != null) {
            val lackBalanceForStateVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.LackBalanceForState.LackBalanceForStatePayload>(), jobj["LackBalanceForState"] ?: throw SerializationException("Missing field 'LackBalanceForState' for variant " + "LackBalanceForState"))
            return ActionErrorKind.LackBalanceForState(lackBalanceForStateVal)
          }
          if (jobj["TriesToUnstake"] != null) {
            val triesToUnstakeVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.TriesToUnstake.TriesToUnstakePayload>(), jobj["TriesToUnstake"] ?: throw SerializationException("Missing field 'TriesToUnstake' for variant " + "TriesToUnstake"))
            return ActionErrorKind.TriesToUnstake(triesToUnstakeVal)
          }
          if (jobj["TriesToStake"] != null) {
            val triesToStakeVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.TriesToStake.TriesToStakePayload>(), jobj["TriesToStake"] ?: throw SerializationException("Missing field 'TriesToStake' for variant " + "TriesToStake"))
            return ActionErrorKind.TriesToStake(triesToStakeVal)
          }
          if (jobj["InsufficientStake"] != null) {
            val insufficientStakeVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.InsufficientStake.InsufficientStakePayload>(), jobj["InsufficientStake"] ?: throw SerializationException("Missing field 'InsufficientStake' for variant " + "InsufficientStake"))
            return ActionErrorKind.InsufficientStake(insufficientStakeVal)
          }
          if (jobj["FunctionCallError"] != null) {
            val functionCallErrorVal = decoder.json.decodeFromJsonElement(serializer<FunctionCallError>(), jobj["FunctionCallError"] ?: throw SerializationException("Missing field 'FunctionCallError' for variant " + "FunctionCallError"))
            return ActionErrorKind.FunctionCallError(functionCallErrorVal)
          }
          if (jobj["NewReceiptValidationError"] != null) {
            val newReceiptValidationErrorVal = decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError>(), jobj["NewReceiptValidationError"] ?: throw SerializationException("Missing field 'NewReceiptValidationError' for variant " + "NewReceiptValidationError"))
            return ActionErrorKind.NewReceiptValidationError(newReceiptValidationErrorVal)
          }
          if (jobj["OnlyImplicitAccountCreationAllowed"] != null) {
            val onlyImplicitAccountCreationAllowedVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.OnlyImplicitAccountCreationAllowed.OnlyImplicitAccountCreationAllowedPayload>(), jobj["OnlyImplicitAccountCreationAllowed"] ?: throw SerializationException("Missing field 'OnlyImplicitAccountCreationAllowed' for variant " + "OnlyImplicitAccountCreationAllowed"))
            return ActionErrorKind.OnlyImplicitAccountCreationAllowed(onlyImplicitAccountCreationAllowedVal)
          }
          if (jobj["DeleteAccountWithLargeState"] != null) {
            val deleteAccountWithLargeStateVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DeleteAccountWithLargeState.DeleteAccountWithLargeStatePayload>(), jobj["DeleteAccountWithLargeState"] ?: throw SerializationException("Missing field 'DeleteAccountWithLargeState' for variant " + "DeleteAccountWithLargeState"))
            return ActionErrorKind.DeleteAccountWithLargeState(deleteAccountWithLargeStateVal)
          }
          if (jobj["DelegateActionSenderDoesNotMatchTxReceiver"] != null) {
            val delegateActionSenderDoesNotMatchTxReceiverVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver.DelegateActionSenderDoesNotMatchTxReceiverPayload>(), jobj["DelegateActionSenderDoesNotMatchTxReceiver"] ?: throw SerializationException("Missing field 'DelegateActionSenderDoesNotMatchTxReceiver' for variant " + "DelegateActionSenderDoesNotMatchTxReceiver"))
            return ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver(delegateActionSenderDoesNotMatchTxReceiverVal)
          }
          if (jobj["DelegateActionAccessKeyError"] != null) {
            val delegateActionAccessKeyErrorVal = decoder.json.decodeFromJsonElement(serializer<InvalidAccessKeyError>(), jobj["DelegateActionAccessKeyError"] ?: throw SerializationException("Missing field 'DelegateActionAccessKeyError' for variant " + "DelegateActionAccessKeyError"))
            return ActionErrorKind.DelegateActionAccessKeyError(delegateActionAccessKeyErrorVal)
          }
          if (jobj["DelegateActionInvalidNonce"] != null) {
            val delegateActionInvalidNonceVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DelegateActionInvalidNonce.DelegateActionInvalidNoncePayload>(), jobj["DelegateActionInvalidNonce"] ?: throw SerializationException("Missing field 'DelegateActionInvalidNonce' for variant " + "DelegateActionInvalidNonce"))
            return ActionErrorKind.DelegateActionInvalidNonce(delegateActionInvalidNonceVal)
          }
          if (jobj["DelegateActionNonceTooLarge"] != null) {
            val delegateActionNonceTooLargeVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DelegateActionNonceTooLarge.DelegateActionNonceTooLargePayload>(), jobj["DelegateActionNonceTooLarge"] ?: throw SerializationException("Missing field 'DelegateActionNonceTooLarge' for variant " + "DelegateActionNonceTooLarge"))
            return ActionErrorKind.DelegateActionNonceTooLarge(delegateActionNonceTooLargeVal)
          }
          if (jobj["GlobalContractDoesNotExist"] != null) {
            val globalContractDoesNotExistVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.GlobalContractDoesNotExist.GlobalContractDoesNotExistPayload>(), jobj["GlobalContractDoesNotExist"] ?: throw SerializationException("Missing field 'GlobalContractDoesNotExist' for variant " + "GlobalContractDoesNotExist"))
            return ActionErrorKind.GlobalContractDoesNotExist(globalContractDoesNotExistVal)
          }
          if (jobj.size == 1) {
            val entry = jobj.entries.first()
            val key = entry.key
            val valueElem = entry.value
            when (key) {
              "AccountAlreadyExists" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val accountAlreadyExistsVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.AccountAlreadyExists.AccountAlreadyExistsPayload>(), obj["AccountAlreadyExists"] ?: throw SerializationException("Missing field 'AccountAlreadyExists' for variant " + key))
                return ActionErrorKind.AccountAlreadyExists(accountAlreadyExistsVal)
              }
              "AccountDoesNotExist" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val accountDoesNotExistVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.AccountDoesNotExist.AccountDoesNotExistPayload>(), obj["AccountDoesNotExist"] ?: throw SerializationException("Missing field 'AccountDoesNotExist' for variant " + key))
                return ActionErrorKind.AccountDoesNotExist(accountDoesNotExistVal)
              }
              "CreateAccountOnlyByRegistrar" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val createAccountOnlyByRegistrarVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.CreateAccountOnlyByRegistrar.CreateAccountOnlyByRegistrarPayload>(), obj["CreateAccountOnlyByRegistrar"] ?: throw SerializationException("Missing field 'CreateAccountOnlyByRegistrar' for variant " + key))
                return ActionErrorKind.CreateAccountOnlyByRegistrar(createAccountOnlyByRegistrarVal)
              }
              "CreateAccountNotAllowed" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val createAccountNotAllowedVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.CreateAccountNotAllowed.CreateAccountNotAllowedPayload>(), obj["CreateAccountNotAllowed"] ?: throw SerializationException("Missing field 'CreateAccountNotAllowed' for variant " + key))
                return ActionErrorKind.CreateAccountNotAllowed(createAccountNotAllowedVal)
              }
              "ActorNoPermission" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val actorNoPermissionVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.ActorNoPermission.ActorNoPermissionPayload>(), obj["ActorNoPermission"] ?: throw SerializationException("Missing field 'ActorNoPermission' for variant " + key))
                return ActionErrorKind.ActorNoPermission(actorNoPermissionVal)
              }
              "DeleteKeyDoesNotExist" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val deleteKeyDoesNotExistVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DeleteKeyDoesNotExist.DeleteKeyDoesNotExistPayload>(), obj["DeleteKeyDoesNotExist"] ?: throw SerializationException("Missing field 'DeleteKeyDoesNotExist' for variant " + key))
                return ActionErrorKind.DeleteKeyDoesNotExist(deleteKeyDoesNotExistVal)
              }
              "AddKeyAlreadyExists" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val addKeyAlreadyExistsVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.AddKeyAlreadyExists.AddKeyAlreadyExistsPayload>(), obj["AddKeyAlreadyExists"] ?: throw SerializationException("Missing field 'AddKeyAlreadyExists' for variant " + key))
                return ActionErrorKind.AddKeyAlreadyExists(addKeyAlreadyExistsVal)
              }
              "DeleteAccountStaking" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val deleteAccountStakingVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DeleteAccountStaking.DeleteAccountStakingPayload>(), obj["DeleteAccountStaking"] ?: throw SerializationException("Missing field 'DeleteAccountStaking' for variant " + key))
                return ActionErrorKind.DeleteAccountStaking(deleteAccountStakingVal)
              }
              "LackBalanceForState" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val lackBalanceForStateVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.LackBalanceForState.LackBalanceForStatePayload>(), obj["LackBalanceForState"] ?: throw SerializationException("Missing field 'LackBalanceForState' for variant " + key))
                return ActionErrorKind.LackBalanceForState(lackBalanceForStateVal)
              }
              "TriesToUnstake" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val triesToUnstakeVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.TriesToUnstake.TriesToUnstakePayload>(), obj["TriesToUnstake"] ?: throw SerializationException("Missing field 'TriesToUnstake' for variant " + key))
                return ActionErrorKind.TriesToUnstake(triesToUnstakeVal)
              }
              "TriesToStake" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val triesToStakeVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.TriesToStake.TriesToStakePayload>(), obj["TriesToStake"] ?: throw SerializationException("Missing field 'TriesToStake' for variant " + key))
                return ActionErrorKind.TriesToStake(triesToStakeVal)
              }
              "InsufficientStake" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val insufficientStakeVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.InsufficientStake.InsufficientStakePayload>(), obj["InsufficientStake"] ?: throw SerializationException("Missing field 'InsufficientStake' for variant " + key))
                return ActionErrorKind.InsufficientStake(insufficientStakeVal)
              }
              "FunctionCallError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val functionCallErrorVal = decoder.json.decodeFromJsonElement(serializer<FunctionCallError>(), obj["FunctionCallError"] ?: throw SerializationException("Missing field 'FunctionCallError' for variant " + key))
                return ActionErrorKind.FunctionCallError(functionCallErrorVal)
              }
              "NewReceiptValidationError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val newReceiptValidationErrorVal = decoder.json.decodeFromJsonElement(serializer<ReceiptValidationError>(), obj["NewReceiptValidationError"] ?: throw SerializationException("Missing field 'NewReceiptValidationError' for variant " + key))
                return ActionErrorKind.NewReceiptValidationError(newReceiptValidationErrorVal)
              }
              "OnlyImplicitAccountCreationAllowed" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val onlyImplicitAccountCreationAllowedVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.OnlyImplicitAccountCreationAllowed.OnlyImplicitAccountCreationAllowedPayload>(), obj["OnlyImplicitAccountCreationAllowed"] ?: throw SerializationException("Missing field 'OnlyImplicitAccountCreationAllowed' for variant " + key))
                return ActionErrorKind.OnlyImplicitAccountCreationAllowed(onlyImplicitAccountCreationAllowedVal)
              }
              "DeleteAccountWithLargeState" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val deleteAccountWithLargeStateVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DeleteAccountWithLargeState.DeleteAccountWithLargeStatePayload>(), obj["DeleteAccountWithLargeState"] ?: throw SerializationException("Missing field 'DeleteAccountWithLargeState' for variant " + key))
                return ActionErrorKind.DeleteAccountWithLargeState(deleteAccountWithLargeStateVal)
              }
              "DelegateActionSenderDoesNotMatchTxReceiver" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val delegateActionSenderDoesNotMatchTxReceiverVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver.DelegateActionSenderDoesNotMatchTxReceiverPayload>(), obj["DelegateActionSenderDoesNotMatchTxReceiver"] ?: throw SerializationException("Missing field 'DelegateActionSenderDoesNotMatchTxReceiver' for variant " + key))
                return ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver(delegateActionSenderDoesNotMatchTxReceiverVal)
              }
              "DelegateActionAccessKeyError" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val delegateActionAccessKeyErrorVal = decoder.json.decodeFromJsonElement(serializer<InvalidAccessKeyError>(), obj["DelegateActionAccessKeyError"] ?: throw SerializationException("Missing field 'DelegateActionAccessKeyError' for variant " + key))
                return ActionErrorKind.DelegateActionAccessKeyError(delegateActionAccessKeyErrorVal)
              }
              "DelegateActionInvalidNonce" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val delegateActionInvalidNonceVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DelegateActionInvalidNonce.DelegateActionInvalidNoncePayload>(), obj["DelegateActionInvalidNonce"] ?: throw SerializationException("Missing field 'DelegateActionInvalidNonce' for variant " + key))
                return ActionErrorKind.DelegateActionInvalidNonce(delegateActionInvalidNonceVal)
              }
              "DelegateActionNonceTooLarge" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val delegateActionNonceTooLargeVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DelegateActionNonceTooLarge.DelegateActionNonceTooLargePayload>(), obj["DelegateActionNonceTooLarge"] ?: throw SerializationException("Missing field 'DelegateActionNonceTooLarge' for variant " + key))
                return ActionErrorKind.DelegateActionNonceTooLarge(delegateActionNonceTooLargeVal)
              }
              "GlobalContractDoesNotExist" -> {
                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant " + key)
                val globalContractDoesNotExistVal = decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.GlobalContractDoesNotExist.GlobalContractDoesNotExistPayload>(), obj["GlobalContractDoesNotExist"] ?: throw SerializationException("Missing field 'GlobalContractDoesNotExist' for variant " + key))
                return ActionErrorKind.GlobalContractDoesNotExist(globalContractDoesNotExistVal)
              }
              "DelegateActionInvalidSignature" -> {
                return ActionErrorKind.DelegateActionInvalidSignature
              }
              "DelegateActionExpired" -> {
                return ActionErrorKind.DelegateActionExpired
              }
              else -> throw SerializationException("Unknown discriminator key for ActionErrorKind: " + key)
            }
          }
          else {
            val typeField = jobj["type"]?.jsonPrimitive?.contentOrNull ?: throw SerializationException("Missing 'type' discriminator in ActionErrorKind")
            when (typeField) {
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
              "DelegateActionInvalidSignature" -> return ActionErrorKind.DelegateActionInvalidSignature
              "DelegateActionExpired" -> return ActionErrorKind.DelegateActionExpired
              else -> throw SerializationException("Unknown type discriminator for ActionErrorKind: " + typeField)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize ActionErrorKind with non-JSON decoder")
  }
}
