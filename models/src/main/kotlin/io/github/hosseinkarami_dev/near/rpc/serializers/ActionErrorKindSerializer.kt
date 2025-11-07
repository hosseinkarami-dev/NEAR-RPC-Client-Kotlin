package io.github.hosseinkarami_dev.near.rpc.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
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
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.serializer
import io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind
import kotlinx.serialization.json.*

object ActionErrorKindSerializer : KSerializer<ActionErrorKind> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind") {
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

    override fun serialize(encoder: Encoder, value: ActionErrorKind) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountAlreadyExists -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["AccountAlreadyExists"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountAlreadyExists.AccountAlreadyExistsPayload>(), value.accountAlreadyExists)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountDoesNotExist -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["AccountDoesNotExist"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountDoesNotExist.AccountDoesNotExistPayload>(), value.accountDoesNotExist)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountOnlyByRegistrar -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["CreateAccountOnlyByRegistrar"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountOnlyByRegistrar.CreateAccountOnlyByRegistrarPayload>(), value.createAccountOnlyByRegistrar)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountNotAllowed -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["CreateAccountNotAllowed"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountNotAllowed.CreateAccountNotAllowedPayload>(), value.createAccountNotAllowed)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.ActorNoPermission -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["ActorNoPermission"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.ActorNoPermission.ActorNoPermissionPayload>(), value.actorNoPermission)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteKeyDoesNotExist -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["DeleteKeyDoesNotExist"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteKeyDoesNotExist.DeleteKeyDoesNotExistPayload>(), value.deleteKeyDoesNotExist)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AddKeyAlreadyExists -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["AddKeyAlreadyExists"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AddKeyAlreadyExists.AddKeyAlreadyExistsPayload>(), value.addKeyAlreadyExists)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountStaking -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["DeleteAccountStaking"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountStaking.DeleteAccountStakingPayload>(), value.deleteAccountStaking)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.LackBalanceForState -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["LackBalanceForState"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.LackBalanceForState.LackBalanceForStatePayload>(), value.lackBalanceForState)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToUnstake -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["TriesToUnstake"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToUnstake.TriesToUnstakePayload>(), value.triesToUnstake)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToStake -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["TriesToStake"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToStake.TriesToStakePayload>(), value.triesToStake)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.InsufficientStake -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["InsufficientStake"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.InsufficientStake.InsufficientStakePayload>(), value.insufficientStake)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.FunctionCallError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["FunctionCallError"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError>(), value.functionCallError)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.NewReceiptValidationError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["NewReceiptValidationError"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError>(), value.newReceiptValidationError)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.OnlyImplicitAccountCreationAllowed -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["OnlyImplicitAccountCreationAllowed"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.OnlyImplicitAccountCreationAllowed.OnlyImplicitAccountCreationAllowedPayload>(), value.onlyImplicitAccountCreationAllowed)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountWithLargeState -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["DeleteAccountWithLargeState"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountWithLargeState.DeleteAccountWithLargeStatePayload>(), value.deleteAccountWithLargeState)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionInvalidSignature -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("DelegateActionInvalidSignature"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["DelegateActionSenderDoesNotMatchTxReceiver"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver.DelegateActionSenderDoesNotMatchTxReceiverPayload>(), value.delegateActionSenderDoesNotMatchTxReceiver)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionExpired -> {
                   jsonEncoder.encodeJsonElement(JsonPrimitive("DelegateActionExpired"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionAccessKeyError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["DelegateActionAccessKeyError"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError>(), value.delegateActionAccessKeyError)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionInvalidNonce -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["DelegateActionInvalidNonce"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionInvalidNonce.DelegateActionInvalidNoncePayload>(), value.delegateActionInvalidNonce)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionNonceTooLarge -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["DelegateActionNonceTooLarge"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionNonceTooLarge.DelegateActionNonceTooLargePayload>(), value.delegateActionNonceTooLarge)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.GlobalContractDoesNotExist -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["GlobalContractDoesNotExist"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.GlobalContractDoesNotExist.GlobalContractDoesNotExistPayload>(), value.globalContractDoesNotExist)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountAlreadyExists -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountAlreadyExists>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountDoesNotExist -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountDoesNotExist>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountOnlyByRegistrar -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountOnlyByRegistrar>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountNotAllowed -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountNotAllowed>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.ActorNoPermission -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.ActorNoPermission>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteKeyDoesNotExist -> out.encodeSerializableElement(descriptor, 5, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteKeyDoesNotExist>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AddKeyAlreadyExists -> out.encodeSerializableElement(descriptor, 6, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AddKeyAlreadyExists>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountStaking -> out.encodeSerializableElement(descriptor, 7, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountStaking>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.LackBalanceForState -> out.encodeSerializableElement(descriptor, 8, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.LackBalanceForState>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToUnstake -> out.encodeSerializableElement(descriptor, 9, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToUnstake>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToStake -> out.encodeSerializableElement(descriptor, 10, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToStake>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.InsufficientStake -> out.encodeSerializableElement(descriptor, 11, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.InsufficientStake>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.FunctionCallError -> out.encodeSerializableElement(descriptor, 12, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.FunctionCallError>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.NewReceiptValidationError -> out.encodeSerializableElement(descriptor, 13, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.NewReceiptValidationError>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.OnlyImplicitAccountCreationAllowed -> out.encodeSerializableElement(descriptor, 14, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.OnlyImplicitAccountCreationAllowed>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountWithLargeState -> out.encodeSerializableElement(descriptor, 15, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountWithLargeState>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionInvalidSignature -> out.encodeSerializableElement(descriptor, 16, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionInvalidSignature>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver -> out.encodeSerializableElement(descriptor, 17, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionExpired -> out.encodeSerializableElement(descriptor, 18, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionExpired>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionAccessKeyError -> out.encodeSerializableElement(descriptor, 19, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionAccessKeyError>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionInvalidNonce -> out.encodeSerializableElement(descriptor, 20, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionInvalidNonce>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionNonceTooLarge -> out.encodeSerializableElement(descriptor, 21, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionNonceTooLarge>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.GlobalContractDoesNotExist -> out.encodeSerializableElement(descriptor, 22, serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.GlobalContractDoesNotExist>(), value)
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
                        if (s == "DelegateActionInvalidSignature") return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionInvalidSignature
                        if (s == "DelegateActionExpired") return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionExpired
                    }
                    throw SerializationException("Unknown discriminator (primitive) for ActionErrorKind")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing ActionErrorKind")

                is JsonObject -> {
                    val jobj = element
                    val knownVariantNames = setOf("AccountAlreadyExists", "AccountDoesNotExist", "CreateAccountOnlyByRegistrar", "CreateAccountNotAllowed", "ActorNoPermission", "DeleteKeyDoesNotExist", "AddKeyAlreadyExists", "DeleteAccountStaking", "LackBalanceForState", "TriesToUnstake", "TriesToStake", "InsufficientStake", "FunctionCallError", "NewReceiptValidationError", "OnlyImplicitAccountCreationAllowed", "DeleteAccountWithLargeState", "DelegateActionInvalidSignature", "DelegateActionSenderDoesNotMatchTxReceiver", "DelegateActionExpired", "DelegateActionAccessKeyError", "DelegateActionInvalidNonce", "DelegateActionNonceTooLarge", "GlobalContractDoesNotExist")
                    if (jobj["AccountAlreadyExists"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountAlreadyExists(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountAlreadyExists.AccountAlreadyExistsPayload>(), jobj["AccountAlreadyExists"]!!))
                    }
                    if (jobj["AccountDoesNotExist"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountDoesNotExist(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountDoesNotExist.AccountDoesNotExistPayload>(), jobj["AccountDoesNotExist"]!!))
                    }
                    if (jobj["CreateAccountOnlyByRegistrar"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountOnlyByRegistrar(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountOnlyByRegistrar.CreateAccountOnlyByRegistrarPayload>(), jobj["CreateAccountOnlyByRegistrar"]!!))
                    }
                    if (jobj["CreateAccountNotAllowed"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountNotAllowed(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountNotAllowed.CreateAccountNotAllowedPayload>(), jobj["CreateAccountNotAllowed"]!!))
                    }
                    if (jobj["ActorNoPermission"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.ActorNoPermission(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.ActorNoPermission.ActorNoPermissionPayload>(), jobj["ActorNoPermission"]!!))
                    }
                    if (jobj["DeleteKeyDoesNotExist"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteKeyDoesNotExist(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteKeyDoesNotExist.DeleteKeyDoesNotExistPayload>(), jobj["DeleteKeyDoesNotExist"]!!))
                    }
                    if (jobj["AddKeyAlreadyExists"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AddKeyAlreadyExists(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AddKeyAlreadyExists.AddKeyAlreadyExistsPayload>(), jobj["AddKeyAlreadyExists"]!!))
                    }
                    if (jobj["DeleteAccountStaking"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountStaking(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountStaking.DeleteAccountStakingPayload>(), jobj["DeleteAccountStaking"]!!))
                    }
                    if (jobj["LackBalanceForState"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.LackBalanceForState(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.LackBalanceForState.LackBalanceForStatePayload>(), jobj["LackBalanceForState"]!!))
                    }
                    if (jobj["TriesToUnstake"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToUnstake(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToUnstake.TriesToUnstakePayload>(), jobj["TriesToUnstake"]!!))
                    }
                    if (jobj["TriesToStake"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToStake(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToStake.TriesToStakePayload>(), jobj["TriesToStake"]!!))
                    }
                    if (jobj["InsufficientStake"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.InsufficientStake(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.InsufficientStake.InsufficientStakePayload>(), jobj["InsufficientStake"]!!))
                    }
                    if (jobj["FunctionCallError"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.FunctionCallError(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError>(), jobj["FunctionCallError"]!!))
                    }
                    if (jobj["NewReceiptValidationError"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.NewReceiptValidationError(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError>(), jobj["NewReceiptValidationError"]!!))
                    }
                    if (jobj["OnlyImplicitAccountCreationAllowed"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.OnlyImplicitAccountCreationAllowed(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.OnlyImplicitAccountCreationAllowed.OnlyImplicitAccountCreationAllowedPayload>(), jobj["OnlyImplicitAccountCreationAllowed"]!!))
                    }
                    if (jobj["DeleteAccountWithLargeState"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountWithLargeState(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountWithLargeState.DeleteAccountWithLargeStatePayload>(), jobj["DeleteAccountWithLargeState"]!!))
                    }
                    if (jobj["DelegateActionSenderDoesNotMatchTxReceiver"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver.DelegateActionSenderDoesNotMatchTxReceiverPayload>(), jobj["DelegateActionSenderDoesNotMatchTxReceiver"]!!))
                    }
                    if (jobj["DelegateActionAccessKeyError"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionAccessKeyError(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError>(), jobj["DelegateActionAccessKeyError"]!!))
                    }
                    if (jobj["DelegateActionInvalidNonce"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionInvalidNonce(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionInvalidNonce.DelegateActionInvalidNoncePayload>(), jobj["DelegateActionInvalidNonce"]!!))
                    }
                    if (jobj["DelegateActionNonceTooLarge"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionNonceTooLarge(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionNonceTooLarge.DelegateActionNonceTooLargePayload>(), jobj["DelegateActionNonceTooLarge"]!!))
                    }
                    if (jobj["GlobalContractDoesNotExist"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.GlobalContractDoesNotExist(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.GlobalContractDoesNotExist.GlobalContractDoesNotExistPayload>(), jobj["GlobalContractDoesNotExist"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        if (knownVariantNames.contains(key)) {
                            when (key) {
                            "AccountAlreadyExists" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant AccountAlreadyExists: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountAlreadyExists>(), obj)
                            }
                            "AccountDoesNotExist" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant AccountDoesNotExist: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountDoesNotExist>(), obj)
                            }
                            "CreateAccountOnlyByRegistrar" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant CreateAccountOnlyByRegistrar: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountOnlyByRegistrar>(), obj)
                            }
                            "CreateAccountNotAllowed" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant CreateAccountNotAllowed: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountNotAllowed>(), obj)
                            }
                            "ActorNoPermission" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant ActorNoPermission: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.ActorNoPermission>(), obj)
                            }
                            "DeleteKeyDoesNotExist" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant DeleteKeyDoesNotExist: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteKeyDoesNotExist>(), obj)
                            }
                            "AddKeyAlreadyExists" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant AddKeyAlreadyExists: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AddKeyAlreadyExists>(), obj)
                            }
                            "DeleteAccountStaking" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant DeleteAccountStaking: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountStaking>(), obj)
                            }
                            "LackBalanceForState" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant LackBalanceForState: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.LackBalanceForState>(), obj)
                            }
                            "TriesToUnstake" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant TriesToUnstake: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToUnstake>(), obj)
                            }
                            "TriesToStake" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant TriesToStake: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToStake>(), obj)
                            }
                            "InsufficientStake" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant InsufficientStake: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.InsufficientStake>(), obj)
                            }
                            "FunctionCallError" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant FunctionCallError: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.FunctionCallError>(), obj)
                            }
                            "NewReceiptValidationError" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant NewReceiptValidationError: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.NewReceiptValidationError>(), obj)
                            }
                            "OnlyImplicitAccountCreationAllowed" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant OnlyImplicitAccountCreationAllowed: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.OnlyImplicitAccountCreationAllowed>(), obj)
                            }
                            "DeleteAccountWithLargeState" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant DeleteAccountWithLargeState: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountWithLargeState>(), obj)
                            }
                            "DelegateActionSenderDoesNotMatchTxReceiver" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant DelegateActionSenderDoesNotMatchTxReceiver: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver>(), obj)
                            }
                            "DelegateActionAccessKeyError" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant DelegateActionAccessKeyError: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionAccessKeyError>(), obj)
                            }
                            "DelegateActionInvalidNonce" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant DelegateActionInvalidNonce: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionInvalidNonce>(), obj)
                            }
                            "DelegateActionNonceTooLarge" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant DelegateActionNonceTooLarge: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionNonceTooLarge>(), obj)
                            }
                            "GlobalContractDoesNotExist" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant GlobalContractDoesNotExist: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.GlobalContractDoesNotExist>(), obj)
                            }
                            "DelegateActionInvalidSignature" -> return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionInvalidSignature
                            "DelegateActionExpired" -> return io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionExpired
                            else -> { /* knownVariantNames.contains(key) guards this branch; shouldn't reach here */ }
                            }
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("AccountAlreadyExists")
                    for (cand in discriminatorCandidates) {
                        val candElem = jobj[cand]
                        if (candElem is JsonPrimitive) {
                            typeField = candElem.contentOrNull
                            if (typeField != null) break
                        }
                    }
                    if (typeField == null) {
                        for ((k, v) in jobj.entries) {
                            if (v is JsonPrimitive && v.isString) {
                                val s = v.content
                                if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
                            }
                        }
                    }

                    if (typeField != null) {
                        val tf = typeField.trim()
                        // try exact match of full variant name first
                        when (tf) {
                            "AccountAlreadyExists" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountAlreadyExists>(), jobj)
                            "AccountDoesNotExist" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountDoesNotExist>(), jobj)
                            "CreateAccountOnlyByRegistrar" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountOnlyByRegistrar>(), jobj)
                            "CreateAccountNotAllowed" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountNotAllowed>(), jobj)
                            "ActorNoPermission" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.ActorNoPermission>(), jobj)
                            "DeleteKeyDoesNotExist" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteKeyDoesNotExist>(), jobj)
                            "AddKeyAlreadyExists" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AddKeyAlreadyExists>(), jobj)
                            "DeleteAccountStaking" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountStaking>(), jobj)
                            "LackBalanceForState" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.LackBalanceForState>(), jobj)
                            "TriesToUnstake" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToUnstake>(), jobj)
                            "TriesToStake" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToStake>(), jobj)
                            "InsufficientStake" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.InsufficientStake>(), jobj)
                            "FunctionCallError" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.FunctionCallError>(), jobj)
                            "NewReceiptValidationError" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.NewReceiptValidationError>(), jobj)
                            "OnlyImplicitAccountCreationAllowed" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.OnlyImplicitAccountCreationAllowed>(), jobj)
                            "DeleteAccountWithLargeState" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountWithLargeState>(), jobj)
                            "DelegateActionInvalidSignature" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionInvalidSignature>(), jobj)
                            "DelegateActionSenderDoesNotMatchTxReceiver" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver>(), jobj)
                            "DelegateActionExpired" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionExpired>(), jobj)
                            "DelegateActionAccessKeyError" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionAccessKeyError>(), jobj)
                            "DelegateActionInvalidNonce" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionInvalidNonce>(), jobj)
                            "DelegateActionNonceTooLarge" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionNonceTooLarge>(), jobj)
                            "GlobalContractDoesNotExist" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.GlobalContractDoesNotExist>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("AccountAlreadyExists".lowercase() == tfLower || tfLower.contains("AccountAlreadyExists".lowercase()) || "AccountAlreadyExists".lowercase().contains(tfLower))) { chosenGroupKey = "AccountAlreadyExists" }
                        if (chosenGroupKey == null && ("AccountDoesNotExist".lowercase() == tfLower || tfLower.contains("AccountDoesNotExist".lowercase()) || "AccountDoesNotExist".lowercase().contains(tfLower))) { chosenGroupKey = "AccountDoesNotExist" }
                        if (chosenGroupKey == null && ("CreateAccountOnlyByRegistrar".lowercase() == tfLower || tfLower.contains("CreateAccountOnlyByRegistrar".lowercase()) || "CreateAccountOnlyByRegistrar".lowercase().contains(tfLower))) { chosenGroupKey = "CreateAccountOnlyByRegistrar" }
                        if (chosenGroupKey == null && ("CreateAccountNotAllowed".lowercase() == tfLower || tfLower.contains("CreateAccountNotAllowed".lowercase()) || "CreateAccountNotAllowed".lowercase().contains(tfLower))) { chosenGroupKey = "CreateAccountNotAllowed" }
                        if (chosenGroupKey == null && ("ActorNoPermission".lowercase() == tfLower || tfLower.contains("ActorNoPermission".lowercase()) || "ActorNoPermission".lowercase().contains(tfLower))) { chosenGroupKey = "ActorNoPermission" }
                        if (chosenGroupKey == null && ("DeleteKeyDoesNotExist".lowercase() == tfLower || tfLower.contains("DeleteKeyDoesNotExist".lowercase()) || "DeleteKeyDoesNotExist".lowercase().contains(tfLower))) { chosenGroupKey = "DeleteKeyDoesNotExist" }
                        if (chosenGroupKey == null && ("AddKeyAlreadyExists".lowercase() == tfLower || tfLower.contains("AddKeyAlreadyExists".lowercase()) || "AddKeyAlreadyExists".lowercase().contains(tfLower))) { chosenGroupKey = "AddKeyAlreadyExists" }
                        if (chosenGroupKey == null && ("DeleteAccountStaking".lowercase() == tfLower || tfLower.contains("DeleteAccountStaking".lowercase()) || "DeleteAccountStaking".lowercase().contains(tfLower))) { chosenGroupKey = "DeleteAccountStaking" }
                        if (chosenGroupKey == null && ("LackBalanceForState".lowercase() == tfLower || tfLower.contains("LackBalanceForState".lowercase()) || "LackBalanceForState".lowercase().contains(tfLower))) { chosenGroupKey = "LackBalanceForState" }
                        if (chosenGroupKey == null && ("TriesToUnstake".lowercase() == tfLower || tfLower.contains("TriesToUnstake".lowercase()) || "TriesToUnstake".lowercase().contains(tfLower))) { chosenGroupKey = "TriesToUnstake" }
                        if (chosenGroupKey == null && ("TriesToStake".lowercase() == tfLower || tfLower.contains("TriesToStake".lowercase()) || "TriesToStake".lowercase().contains(tfLower))) { chosenGroupKey = "TriesToStake" }
                        if (chosenGroupKey == null && ("InsufficientStake".lowercase() == tfLower || tfLower.contains("InsufficientStake".lowercase()) || "InsufficientStake".lowercase().contains(tfLower))) { chosenGroupKey = "InsufficientStake" }
                        if (chosenGroupKey == null && ("FunctionCallError".lowercase() == tfLower || tfLower.contains("FunctionCallError".lowercase()) || "FunctionCallError".lowercase().contains(tfLower))) { chosenGroupKey = "FunctionCallError" }
                        if (chosenGroupKey == null && ("NewReceiptValidationError".lowercase() == tfLower || tfLower.contains("NewReceiptValidationError".lowercase()) || "NewReceiptValidationError".lowercase().contains(tfLower))) { chosenGroupKey = "NewReceiptValidationError" }
                        if (chosenGroupKey == null && ("OnlyImplicitAccountCreationAllowed".lowercase() == tfLower || tfLower.contains("OnlyImplicitAccountCreationAllowed".lowercase()) || "OnlyImplicitAccountCreationAllowed".lowercase().contains(tfLower))) { chosenGroupKey = "OnlyImplicitAccountCreationAllowed" }
                        if (chosenGroupKey == null && ("DeleteAccountWithLargeState".lowercase() == tfLower || tfLower.contains("DeleteAccountWithLargeState".lowercase()) || "DeleteAccountWithLargeState".lowercase().contains(tfLower))) { chosenGroupKey = "DeleteAccountWithLargeState" }
                        if (chosenGroupKey == null && ("DelegateActionInvalidSignature".lowercase() == tfLower || tfLower.contains("DelegateActionInvalidSignature".lowercase()) || "DelegateActionInvalidSignature".lowercase().contains(tfLower))) { chosenGroupKey = "DelegateActionInvalidSignature" }
                        if (chosenGroupKey == null && ("DelegateActionSenderDoesNotMatchTxReceiver".lowercase() == tfLower || tfLower.contains("DelegateActionSenderDoesNotMatchTxReceiver".lowercase()) || "DelegateActionSenderDoesNotMatchTxReceiver".lowercase().contains(tfLower))) { chosenGroupKey = "DelegateActionSenderDoesNotMatchTxReceiver" }
                        if (chosenGroupKey == null && ("DelegateActionExpired".lowercase() == tfLower || tfLower.contains("DelegateActionExpired".lowercase()) || "DelegateActionExpired".lowercase().contains(tfLower))) { chosenGroupKey = "DelegateActionExpired" }
                        if (chosenGroupKey == null && ("DelegateActionAccessKeyError".lowercase() == tfLower || tfLower.contains("DelegateActionAccessKeyError".lowercase()) || "DelegateActionAccessKeyError".lowercase().contains(tfLower))) { chosenGroupKey = "DelegateActionAccessKeyError" }
                        if (chosenGroupKey == null && ("DelegateActionInvalidNonce".lowercase() == tfLower || tfLower.contains("DelegateActionInvalidNonce".lowercase()) || "DelegateActionInvalidNonce".lowercase().contains(tfLower))) { chosenGroupKey = "DelegateActionInvalidNonce" }
                        if (chosenGroupKey == null && ("DelegateActionNonceTooLarge".lowercase() == tfLower || tfLower.contains("DelegateActionNonceTooLarge".lowercase()) || "DelegateActionNonceTooLarge".lowercase().contains(tfLower))) { chosenGroupKey = "DelegateActionNonceTooLarge" }
                        if (chosenGroupKey == null && ("GlobalContractDoesNotExist".lowercase() == tfLower || tfLower.contains("GlobalContractDoesNotExist".lowercase()) || "GlobalContractDoesNotExist".lowercase().contains(tfLower))) { chosenGroupKey = "GlobalContractDoesNotExist" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "AccountAlreadyExists" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountAlreadyExists>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'AccountAlreadyExists' and tf='\$tf'")
                                }
                                "AccountDoesNotExist" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountDoesNotExist>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'AccountDoesNotExist' and tf='\$tf'")
                                }
                                "CreateAccountOnlyByRegistrar" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountOnlyByRegistrar>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'CreateAccountOnlyByRegistrar' and tf='\$tf'")
                                }
                                "CreateAccountNotAllowed" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountNotAllowed>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'CreateAccountNotAllowed' and tf='\$tf'")
                                }
                                "ActorNoPermission" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.ActorNoPermission>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'ActorNoPermission' and tf='\$tf'")
                                }
                                "DeleteKeyDoesNotExist" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteKeyDoesNotExist>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DeleteKeyDoesNotExist' and tf='\$tf'")
                                }
                                "AddKeyAlreadyExists" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AddKeyAlreadyExists>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'AddKeyAlreadyExists' and tf='\$tf'")
                                }
                                "DeleteAccountStaking" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountStaking>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DeleteAccountStaking' and tf='\$tf'")
                                }
                                "LackBalanceForState" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.LackBalanceForState>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'LackBalanceForState' and tf='\$tf'")
                                }
                                "TriesToUnstake" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToUnstake>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'TriesToUnstake' and tf='\$tf'")
                                }
                                "TriesToStake" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToStake>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'TriesToStake' and tf='\$tf'")
                                }
                                "InsufficientStake" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.InsufficientStake>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'InsufficientStake' and tf='\$tf'")
                                }
                                "FunctionCallError" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.FunctionCallError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'FunctionCallError' and tf='\$tf'")
                                }
                                "NewReceiptValidationError" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.NewReceiptValidationError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'NewReceiptValidationError' and tf='\$tf'")
                                }
                                "OnlyImplicitAccountCreationAllowed" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.OnlyImplicitAccountCreationAllowed>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'OnlyImplicitAccountCreationAllowed' and tf='\$tf'")
                                }
                                "DeleteAccountWithLargeState" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountWithLargeState>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DeleteAccountWithLargeState' and tf='\$tf'")
                                }
                                "DelegateActionInvalidSignature" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionInvalidSignature>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DelegateActionInvalidSignature' and tf='\$tf'")
                                }
                                "DelegateActionSenderDoesNotMatchTxReceiver" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DelegateActionSenderDoesNotMatchTxReceiver' and tf='\$tf'")
                                }
                                "DelegateActionExpired" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionExpired>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DelegateActionExpired' and tf='\$tf'")
                                }
                                "DelegateActionAccessKeyError" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionAccessKeyError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DelegateActionAccessKeyError' and tf='\$tf'")
                                }
                                "DelegateActionInvalidNonce" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionInvalidNonce>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DelegateActionInvalidNonce' and tf='\$tf'")
                                }
                                "DelegateActionNonceTooLarge" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionNonceTooLarge>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'DelegateActionNonceTooLarge' and tf='\$tf'")
                                }
                                "GlobalContractDoesNotExist" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.GlobalContractDoesNotExist>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'GlobalContractDoesNotExist' and tf='\$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: AccountAlreadyExists
                    // group: AccountDoesNotExist
                    // group: CreateAccountOnlyByRegistrar
                    // group: CreateAccountNotAllowed
                    // group: ActorNoPermission
                    // group: DeleteKeyDoesNotExist
                    // group: AddKeyAlreadyExists
                    // group: DeleteAccountStaking
                    // group: LackBalanceForState
                    // group: TriesToUnstake
                    // group: TriesToStake
                    // group: InsufficientStake
                    // group: FunctionCallError
                    // group: NewReceiptValidationError
                    // group: OnlyImplicitAccountCreationAllowed
                    // group: DeleteAccountWithLargeState
                    // group: DelegateActionInvalidSignature
                    // group: DelegateActionSenderDoesNotMatchTxReceiver
                    // group: DelegateActionExpired
                    // group: DelegateActionAccessKeyError
                    // group: DelegateActionInvalidNonce
                    // group: DelegateActionNonceTooLarge
                    // group: GlobalContractDoesNotExist

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("AccountAlreadyExists")) requiredMatches.add(0)
                    if (jobj.containsKey("AccountDoesNotExist")) requiredMatches.add(1)
                    if (jobj.containsKey("CreateAccountOnlyByRegistrar")) requiredMatches.add(2)
                    if (jobj.containsKey("CreateAccountNotAllowed")) requiredMatches.add(3)
                    if (jobj.containsKey("ActorNoPermission")) requiredMatches.add(4)
                    if (jobj.containsKey("DeleteKeyDoesNotExist")) requiredMatches.add(5)
                    if (jobj.containsKey("AddKeyAlreadyExists")) requiredMatches.add(6)
                    if (jobj.containsKey("DeleteAccountStaking")) requiredMatches.add(7)
                    if (jobj.containsKey("LackBalanceForState")) requiredMatches.add(8)
                    if (jobj.containsKey("TriesToUnstake")) requiredMatches.add(9)
                    if (jobj.containsKey("TriesToStake")) requiredMatches.add(10)
                    if (jobj.containsKey("InsufficientStake")) requiredMatches.add(11)
                    if (jobj.containsKey("FunctionCallError")) requiredMatches.add(12)
                    if (jobj.containsKey("NewReceiptValidationError")) requiredMatches.add(13)
                    if (jobj.containsKey("OnlyImplicitAccountCreationAllowed")) requiredMatches.add(14)
                    if (jobj.containsKey("DeleteAccountWithLargeState")) requiredMatches.add(15)
                    if (jobj.containsKey("DelegateActionSenderDoesNotMatchTxReceiver")) requiredMatches.add(17)
                    if (jobj.containsKey("DelegateActionAccessKeyError")) requiredMatches.add(19)
                    if (jobj.containsKey("DelegateActionInvalidNonce")) requiredMatches.add(20)
                    if (jobj.containsKey("DelegateActionNonceTooLarge")) requiredMatches.add(21)
                    if (jobj.containsKey("GlobalContractDoesNotExist")) requiredMatches.add(22)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountAlreadyExists>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountDoesNotExist>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountOnlyByRegistrar>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountNotAllowed>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.ActorNoPermission>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteKeyDoesNotExist>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AddKeyAlreadyExists>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountStaking>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.LackBalanceForState>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToUnstake>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToStake>(), jobj)
                            11 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.InsufficientStake>(), jobj)
                            12 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.FunctionCallError>(), jobj)
                            13 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.NewReceiptValidationError>(), jobj)
                            14 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.OnlyImplicitAccountCreationAllowed>(), jobj)
                            15 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountWithLargeState>(), jobj)
                            16 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionInvalidSignature>(), jobj)
                            17 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver>(), jobj)
                            18 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionExpired>(), jobj)
                            19 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionAccessKeyError>(), jobj)
                            20 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionInvalidNonce>(), jobj)
                            21 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionNonceTooLarge>(), jobj)
                            22 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.GlobalContractDoesNotExist>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["AccountAlreadyExists"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["AccountDoesNotExist"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["CreateAccountOnlyByRegistrar"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["CreateAccountNotAllowed"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 3 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["ActorNoPermission"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 4 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["DeleteKeyDoesNotExist"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 5 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["AddKeyAlreadyExists"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 6 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["DeleteAccountStaking"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 7 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["LackBalanceForState"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 8 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["TriesToUnstake"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 9 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["TriesToStake"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 10 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["InsufficientStake"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 11 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["FunctionCallError"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 12 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["NewReceiptValidationError"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 13 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["OnlyImplicitAccountCreationAllowed"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 14 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["DeleteAccountWithLargeState"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 15 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 16 }
                    run {
                        var matchCount = 0
                        if (jobj["DelegateActionSenderDoesNotMatchTxReceiver"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 17 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 18 }
                    run {
                        var matchCount = 0
                        if (jobj["DelegateActionAccessKeyError"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 19 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["DelegateActionInvalidNonce"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 20 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["DelegateActionNonceTooLarge"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 21 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["GlobalContractDoesNotExist"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 22 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountAlreadyExists>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountDoesNotExist>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountOnlyByRegistrar>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountNotAllowed>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.ActorNoPermission>(), jobj)
                            5 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteKeyDoesNotExist>(), jobj)
                            6 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AddKeyAlreadyExists>(), jobj)
                            7 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountStaking>(), jobj)
                            8 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.LackBalanceForState>(), jobj)
                            9 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToUnstake>(), jobj)
                            10 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToStake>(), jobj)
                            11 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.InsufficientStake>(), jobj)
                            12 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.FunctionCallError>(), jobj)
                            13 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.NewReceiptValidationError>(), jobj)
                            14 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.OnlyImplicitAccountCreationAllowed>(), jobj)
                            15 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountWithLargeState>(), jobj)
                            16 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionInvalidSignature>(), jobj)
                            17 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver>(), jobj)
                            18 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionExpired>(), jobj)
                            19 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionAccessKeyError>(), jobj)
                            20 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionInvalidNonce>(), jobj)
                            21 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionNonceTooLarge>(), jobj)
                            22 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.GlobalContractDoesNotExist>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountAlreadyExists>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AccountDoesNotExist>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountOnlyByRegistrar>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.CreateAccountNotAllowed>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.ActorNoPermission>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteKeyDoesNotExist>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.AddKeyAlreadyExists>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountStaking>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.LackBalanceForState>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToUnstake>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.TriesToStake>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.InsufficientStake>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.FunctionCallError>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.NewReceiptValidationError>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.OnlyImplicitAccountCreationAllowed>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DeleteAccountWithLargeState>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionSenderDoesNotMatchTxReceiver>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionAccessKeyError>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionInvalidNonce>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.DelegateActionNonceTooLarge>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.GlobalContractDoesNotExist>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in ActionErrorKind")
                }
            }
        }
        throw SerializationException("Cannot deserialize ActionErrorKind with non-JSON decoder")
    }
}
