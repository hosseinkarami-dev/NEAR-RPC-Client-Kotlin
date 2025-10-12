package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.models.AccessKey
import io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission
import io.github.hosseinkarami_dev.near.rpc.models.AccountId
import io.github.hosseinkarami_dev.near.rpc.models.AddKeyAction
import io.github.hosseinkarami_dev.near.rpc.models.CreateAccountAction
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.DeleteAccountAction
import io.github.hosseinkarami_dev.near.rpc.models.DeleteKeyAction
import io.github.hosseinkarami_dev.near.rpc.models.DeployContractAction
import io.github.hosseinkarami_dev.near.rpc.models.DeployGlobalContractAction
import io.github.hosseinkarami_dev.near.rpc.models.DeterministicAccountStateInit
import io.github.hosseinkarami_dev.near.rpc.models.DeterministicAccountStateInitV1
import io.github.hosseinkarami_dev.near.rpc.models.DeterministicStateInitAction
import io.github.hosseinkarami_dev.near.rpc.models.FunctionCallAction
import io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode
import io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifier
import io.github.hosseinkarami_dev.near.rpc.models.NearGas
import io.github.hosseinkarami_dev.near.rpc.models.NearToken
import io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction
import io.github.hosseinkarami_dev.near.rpc.models.PublicKey
import io.github.hosseinkarami_dev.near.rpc.models.StakeAction
import io.github.hosseinkarami_dev.near.rpc.models.TransferAction
import io.github.hosseinkarami_dev.near.rpc.models.UseGlobalContractAction
import io.github.hosseinkarami_dev.near.rpc.serializers.NonDelegateActionSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonPrimitive
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NonDelegateActionTest {

    private val json = Json { prettyPrint = true; encodeDefaults = true }

    @Test
    fun `test CreateAccount serialization and deserialization`() {
        val action = NonDelegateAction.CreateAccount(
            createAccount = CreateAccountAction(JsonPrimitive("some_value"))
        )

        val serialized = json.encodeToString(NonDelegateActionSerializer, action)
        val deserialized = json.decodeFromString(NonDelegateActionSerializer, serialized)
        assertEquals(action, deserialized)
    }

    @Test
    fun `test DeployContract serialization and deserialization`() {
        val action = NonDelegateAction.DeployContract(
            deployContract = DeployContractAction(code = "AGFzbQE=")
        )

        val serialized = json.encodeToString(NonDelegateActionSerializer, action)
        val deserialized = json.decodeFromString(NonDelegateActionSerializer, serialized)
        assertEquals(action, deserialized)
    }

    @Test
    fun `test FunctionCall serialization and deserialization`() {
        val action = NonDelegateAction.FunctionCall(
            functionCall = FunctionCallAction(
                args = "e30=", // "{}" base64
                deposit = NearToken("1000000000000000000000000"),
                gas = NearGas(30000000000000UL),
                methodName = "foo"
            )
        )

        val serialized = json.encodeToString(NonDelegateActionSerializer, action)
        val deserialized = json.decodeFromString(NonDelegateActionSerializer, serialized)
        assertEquals(action, deserialized)
    }

    @Test
    fun `test Transfer serialization and deserialization`() {
        val action = NonDelegateAction.Transfer(
            transfer = TransferAction(deposit = NearToken("1000000000000000000000000"))
        )

        val serialized = json.encodeToString(NonDelegateActionSerializer, action)
        val deserialized = json.decodeFromString(NonDelegateActionSerializer, serialized)
        assertEquals(action, deserialized)
    }

    @Test
    fun `test Stake serialization and deserialization`() {
        val action = NonDelegateAction.Stake(
            stake = StakeAction(
                publicKey = PublicKey("ed25519:samplekey"),
                stake = NearToken("1000000000000000000000000")
            )
        )

        val serialized = json.encodeToString(NonDelegateActionSerializer, action)
        val deserialized = json.decodeFromString(NonDelegateActionSerializer, serialized)
        assertEquals(action, deserialized)
    }

    @Test
    fun `test AddKey serialization and deserialization`() {
        val action = NonDelegateAction.AddKey(
            addKey = AddKeyAction(
                accessKey = AccessKey(
                    nonce = 0UL,
                    permission = AccessKeyPermission.FullAccess()
                ),
                publicKey = PublicKey("ed25519:samplekey")
            )
        )

        val serialized = json.encodeToString(NonDelegateActionSerializer, action)
        val deserialized = json.decodeFromString(NonDelegateActionSerializer, serialized)
        assertEquals(action, deserialized)
    }

    @Test
    fun `test DeleteKey serialization and deserialization`() {
        val action = NonDelegateAction.DeleteKey(
            deleteKey = DeleteKeyAction(publicKey = PublicKey("ed25519:samplekey"))
        )

        val serialized = json.encodeToString(NonDelegateActionSerializer, action)
        val deserialized = json.decodeFromString(NonDelegateActionSerializer, serialized)
        assertEquals(action, deserialized)
    }

    @Test
    fun `test DeleteAccount serialization and deserialization`() {
        val action = NonDelegateAction.DeleteAccount(
            deleteAccount = DeleteAccountAction(
                beneficiaryId = AccountId("alice.near")
            )
        )

        val serialized = json.encodeToString(NonDelegateActionSerializer, action)
        val deserialized = json.decodeFromString(NonDelegateActionSerializer, serialized)
        assertEquals(action, deserialized)
    }

    @Test
    fun `test DeployGlobalContract serialization and deserialization`() {
        val action = NonDelegateAction.DeployGlobalContract(
            deployGlobalContract = DeployGlobalContractAction(
                code = "AGFzbQE=",
                deployMode = GlobalContractDeployMode.CodeHash()
            )
        )

        val serialized = json.encodeToString(NonDelegateActionSerializer, action)
        val deserialized = json.decodeFromString(NonDelegateActionSerializer, serialized)
        assertEquals(action, deserialized)
    }

    @Test
    fun `test UseGlobalContract serialization and deserialization`() {
        val action = NonDelegateAction.UseGlobalContract(
            useGlobalContract = UseGlobalContractAction(
                contractIdentifier = GlobalContractIdentifier.CodeHash(CryptoHash("abcdef"))
            )
        )

        val serialized = json.encodeToString(NonDelegateActionSerializer, action)
        val deserialized = json.decodeFromString(NonDelegateActionSerializer, serialized)
        assertEquals(action, deserialized)
    }

    @Test
    fun `test DeterministicStateInit serialization and deserialization`() {
        val action = NonDelegateAction.DeterministicStateInit(
            deterministicStateInit = DeterministicStateInitAction(
                deposit = NearToken("1000000000000000000000000"),
                stateInit = DeterministicAccountStateInit(
                    v1 = DeterministicAccountStateInitV1(
                        code = GlobalContractIdentifier.CodeHash(CryptoHash("abcdef")),
                        data = mapOf("key1" to "value1")
                    )
                )
            )
        )

        val serialized = json.encodeToString(NonDelegateActionSerializer, action)
        val deserialized = json.decodeFromString(NonDelegateActionSerializer, serialized)
        assertEquals(action, deserialized)
    }
}
