package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.client.Utils.getResultOrNull
import io.github.hosseinkarami_dev.near.rpc.models.AccountId
import io.github.hosseinkarami_dev.near.rpc.models.BlockHeaderInnerLiteView
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.NearToken
import io.github.hosseinkarami_dev.near.rpc.models.PublicKey
import io.github.hosseinkarami_dev.near.rpc.models.RpcError
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientNextBlockRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientNextBlockResponse
import io.github.hosseinkarami_dev.near.rpc.models.Signature
import io.github.hosseinkarami_dev.near.rpc.models.ValidatorStakeView
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class NextLightClientBlockTest {

    private lateinit var httpClient: HttpClient
    private lateinit var nearClient: NearClient

    @BeforeTest
    fun setup() {
        httpClient = HttpClient(CIO) {
            install(ContentNegotiation) {
                json()
            }
        }

        nearClient = NearClient(
            httpClient = httpClient,
            baseUrl = "https://rpc.mainnet.near.org"
        )
    }

    @AfterTest
    fun teardown() {
        httpClient.close()
    }

    @Test
    fun testStatus() = runTest {
        val response = nearClient.nextLightClientBlock(
            RpcLightClientNextBlockRequest(
                lastBlockHash = CryptoHash("4GoYYrySh93RJZmTnKo7mFnXi2PMPXUJ6GW2sU4xt4MB")
            )
        )
        val result = response.getResultOrNull<RpcLightClientNextBlockResponse>()
        println("nextLightClientBlock Response: $result")
        assertTrue { response is RpcResponse.Success || (response is RpcResponse.Failure && response.error is RpcError.InternalError && response.error.code == -1002L) }
    }

    @Test
    fun `test RpcLightClientNextBlockResponse serialization and deserialization`() {
        val signatureList = listOf(Signature("sig1"), Signature("sig2"), null)

        val blockHeader = BlockHeaderInnerLiteView(
            blockMerkleRoot = CryptoHash("rootHash"),
            epochId = CryptoHash("epochHash"),
            height = 1234uL,
            nextBpHash = CryptoHash("bpHash"),
            nextEpochId = CryptoHash("nextEpochHash"),
            outcomeRoot = CryptoHash("outcomeRoot"),
            prevStateRoot = CryptoHash("stateRoot"),
            timestamp = 987654321uL,
            timestampNanosec = "987654321000000"
        )

        val validator1 = ValidatorStakeView(
            accountId = AccountId("validator1.near"),
            publicKey = PublicKey("ed25519:abc"),
            stake = NearToken("1000"),
            validatorStakeStructVersion = ValidatorStakeView.ValidatorStakeStructVersion.V1
        )

        val validator2 = ValidatorStakeView(
            accountId = AccountId("validator2.near"),
            publicKey = PublicKey("ed25519:def"),
            stake = NearToken("2000"),
            validatorStakeStructVersion = ValidatorStakeView.ValidatorStakeStructVersion.V1
        )

        val model = RpcLightClientNextBlockResponse(
            approvalsAfterNext = signatureList,
            innerLite = blockHeader,
            innerRestHash = CryptoHash("restHash"),
            nextBlockInnerHash = CryptoHash("nextInnerHash"),
            nextBps = listOf(validator1, validator2),
            prevBlockHash = CryptoHash("prevHash")
        )

        val encoded = json.encodeToString<RpcLightClientNextBlockResponse>(model)
        val decoded = json.decodeFromString<RpcLightClientNextBlockResponse>(encoded)

        // ✅ Ensure object equality
        assertEquals(model, decoded)

        // ✅ Check list sizes
        assertNotNull(decoded.approvalsAfterNext)
        assertEquals(3, decoded.approvalsAfterNext!!.size)

        assertNotNull(decoded.nextBps)
        assertEquals(2, decoded.nextBps!!.size)

        // ✅ Ensure nested data remains correct
        assertEquals("rootHash", decoded.innerLite!!.blockMerkleRoot.value)
        assertEquals("validator1.near", decoded.nextBps!![0].accountId.value)
    }

    private val json = Json {
        encodeDefaults = true
        prettyPrint = true
        ignoreUnknownKeys = false
    }
}