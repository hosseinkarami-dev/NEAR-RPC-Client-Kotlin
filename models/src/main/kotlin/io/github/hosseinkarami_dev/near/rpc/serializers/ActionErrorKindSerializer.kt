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
          if (listOf("AccountAlreadyExists").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.AccountAlreadyExists>(), jobj)
          }
          if (listOf("AccountDoesNotExist").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.AccountDoesNotExist>(), jobj)
          }
          if (listOf("CreateAccountOnlyByRegistrar").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.CreateAccountOnlyByRegistrar>(), jobj)
          }
          if (listOf("CreateAccountNotAllowed").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.CreateAccountNotAllowed>(), jobj)
          }
          if (listOf("ActorNoPermission").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.ActorNoPermission>(), jobj)
          }
          if (listOf("DeleteKeyDoesNotExist").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DeleteKeyDoesNotExist>(), jobj)
          }
          if (listOf("AddKeyAlreadyExists").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.AddKeyAlreadyExists>(), jobj)
          }
          if (listOf("DeleteAccountStaking").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DeleteAccountStaking>(), jobj)
          }
          if (listOf("LackBalanceForState").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.LackBalanceForState>(), jobj)
          }
          if (listOf("TriesToUnstake").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.TriesToUnstake>(), jobj)
          }
          if (listOf("TriesToStake").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.TriesToStake>(), jobj)
          }
          if (listOf("InsufficientStake").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.InsufficientStake>(), jobj)
          }
          if (listOf("FunctionCallError").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.FunctionCallError>(), jobj)
          }
          if (listOf("NewReceiptValidationError").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.NewReceiptValidationError>(), jobj)
          }
          if (listOf("OnlyImplicitAccountCreationAllowed").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.OnlyImplicitAccountCreationAllowed>(), jobj)
          }
          if (listOf("DeleteAccountWithLargeState").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DeleteAccountWithLargeState>(), jobj)
          }
          if (listOf("DelegateActionSenderDoesNotMatchTxReceiver").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver>(), jobj)
          }
          if (listOf("DelegateActionAccessKeyError").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DelegateActionAccessKeyError>(), jobj)
          }
          if (listOf("DelegateActionInvalidNonce").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DelegateActionInvalidNonce>(), jobj)
          }
          if (listOf("DelegateActionNonceTooLarge").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.DelegateActionNonceTooLarge>(), jobj)
          }
          if (listOf("GlobalContractDoesNotExist").all { jobj[it] != null }) {
            return decoder.json.decodeFromJsonElement(serializer<ActionErrorKind.GlobalContractDoesNotExist>(), jobj)
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
                return ActionErrorKind.DelegateActionInvalidSignature
              }
              "DelegateActionExpired" -> {
                return ActionErrorKind.DelegateActionExpired
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
              "DelegateActionInvalidSignature" -> return ActionErrorKind.DelegateActionInvalidSignature
              "DelegateActionExpired" -> return ActionErrorKind.DelegateActionExpired
              else -> throw SerializationException("Unknown type discriminator for ActionErrorKind: " + tf)
            }
          }
        }
      }
    }
    throw SerializationException("Cannot deserialize ActionErrorKind with non-JSON decoder")
  }
}
