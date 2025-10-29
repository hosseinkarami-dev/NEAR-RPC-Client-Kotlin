import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import io.github.hosseinkarami_dev.near.rpc.models.*
import io.github.hosseinkarami_dev.near.rpc.serializers.RpcTransactionResponseSerializer
import io.github.hosseinkarami_dev.near.rpc.serializers.RpcTransactionStatusRequestSerializer

class RpcTransactionSerializationTest {

    private val json = Json {
        encodeDefaults = true
        prettyPrint = true
        ignoreUnknownKeys = false
    }

    // --------------------------
    // RpcTransactionStatusRequest tests
    // --------------------------
    @Test
    fun `SignedTxBase64 serialization and deserialization`() {
        val request = RpcTransactionStatusRequest.SignedTxBase64(
            signedTxBase64 = SignedTransaction("signed_tx_123"),
            waitUntil = TxExecutionStatus.ExecutedOptimistic
        )

        val serialized = json.encodeToString(RpcTransactionStatusRequestSerializer, request)
        val deserialized = json.decodeFromString(RpcTransactionStatusRequestSerializer, serialized)
        assertEquals(request, deserialized)
    }

    @Test
    fun `SenderAccountId serialization and deserialization`() {
        val request = RpcTransactionStatusRequest.SenderAccountId(
            senderAccountId = AccountId("alice"),
            txHash = CryptoHash("hash123"),
            waitUntil = TxExecutionStatus.Executed
        )

        val serialized = json.encodeToString(RpcTransactionStatusRequestSerializer, request)
        val deserialized = json.decodeFromString(RpcTransactionStatusRequestSerializer, serialized)
        assertEquals(request, deserialized)
    }

    // --------------------------
    // RpcTransactionResponse tests
    // --------------------------
    @Test
    fun `FinalExecutionOutcomeWithReceiptView serialization and deserialization`() {
        val outcomeView = ExecutionOutcomeView(
            executorId = AccountId("alice"),
            gasBurnt = NearGas(1000u),
            logs = listOf("log1", "log2"),
            metadata = ExecutionMetadataView(
                gasProfile = listOf(
                    CostGasUsed("100", "ACTION_COST", "100"),
                    CostGasUsed("200", "WASM_HOST_COST", "200")
                ),
                version = 1u
            ),
            receiptIds = listOf(CryptoHash("receipt1")),
            status = ExecutionStatusView.SuccessValue("ok"),
            tokensBurnt = NearToken("10")
        )

        val request = RpcTransactionResponse.FinalExecutionOutcomeWithReceiptView(
            receipts = emptyList(),
            receiptsOutcome = listOf(
                ExecutionOutcomeWithIdView(
                    blockHash = CryptoHash("block1"),
                    id = CryptoHash("outcome1"),
                    outcome = outcomeView,
                    proof = emptyList()
                )
            ),
            status = FinalExecutionStatus.SuccessValue("VGhpcyBpcyBhIHZhbHVl"),
            transaction = SignedTransactionView(
                actions = emptyList(),
                hash = CryptoHash("tx1"),
                nonce = 1u,
                publicKey = PublicKey("ed25519:pk1"),
                receiverId = AccountId("bob"),
                signature = Signature("sig1"),
                signerId = AccountId("alice")
            ),
            transactionOutcome = ExecutionOutcomeWithIdView(
                blockHash = CryptoHash("block1"),
                id = CryptoHash("txout1"),
                outcome = outcomeView,
                proof = emptyList()
            ),
            finalExecutionStatus = TxExecutionStatus.ExecutedOptimistic
        )

        val serialized = json.encodeToString(RpcTransactionResponseSerializer, request)
        val deserialized = json.decodeFromString(RpcTransactionResponseSerializer, serialized)
        assertEquals(request, deserialized)
    }

    @Test
    fun `FinalExecutionOutcomeView serialization and deserialization`() {
        val outcomeView = ExecutionOutcomeView(
            executorId = AccountId("bob"),
            gasBurnt = NearGas(500u),
            logs = listOf("logA"),
            metadata = ExecutionMetadataView(version = 1u),
            receiptIds = listOf(),
            status = ExecutionStatusView.Failure(
                failure = TxExecutionError.ActionError(
                    ActionError(
                        index = 1u, kind = ActionErrorKind.TriesToStake(
                            ActionErrorKind.TriesToStake.TriesToStakePayload(
                                accountId = AccountId("0xrr"),
                                balance = NearToken("0"),
                                locked = NearToken("1"),
                                stake = NearToken("2"),
                            )
                        )
                    )
                )
            ),
            tokensBurnt = NearToken("5")
        )

        val request = RpcTransactionResponse.FinalExecutionOutcomeView(
            receiptsOutcome = listOf(
                ExecutionOutcomeWithIdView(
                    blockHash = CryptoHash("block2"),
                    id = CryptoHash("outcome2"),
                    outcome = outcomeView,
                    proof = emptyList()
                )
            ),
            status = FinalExecutionStatus.Started,
            transaction = SignedTransactionView(
                actions = emptyList(),
                hash = CryptoHash("tx2"),
                nonce = 2u,
                publicKey = PublicKey("ed25519:pk2"),
                receiverId = AccountId("carol"),
                signature = Signature("sig2"),
                signerId = AccountId("bob")
            ),
            transactionOutcome = ExecutionOutcomeWithIdView(
                blockHash = CryptoHash("block2"),
                id = CryptoHash("txout2"),
                outcome = outcomeView,
                proof = emptyList()
            ),
            finalExecutionStatus = TxExecutionStatus.Included
        )

        val serialized = json.encodeToString(RpcTransactionResponseSerializer, request)
        val deserialized = json.decodeFromString(RpcTransactionResponseSerializer, serialized)
        assertEquals(request, deserialized)
    }
}
