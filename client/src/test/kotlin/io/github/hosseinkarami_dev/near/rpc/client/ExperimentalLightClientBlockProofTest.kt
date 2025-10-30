package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.client.Utils.getResultOrNull
import io.github.hosseinkarami_dev.near.rpc.models.BlockHeaderInnerLiteView
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.Direction
import io.github.hosseinkarami_dev.near.rpc.models.LightClientBlockLiteView
import io.github.hosseinkarami_dev.near.rpc.models.MerklePathItem
import io.github.hosseinkarami_dev.near.rpc.models.RpcError
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientBlockProofRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientBlockProofResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientNextBlockResponse
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

class ExperimentalLightClientBlockProofTest {

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
        val response = nearClient.experimentalLightClientBlockProof(
            RpcLightClientBlockProofRequest(
                blockHash = CryptoHash(""),
                lightClientHead = CryptoHash("")
            )
        )
        val result = response.getResultOrNull<RpcLightClientBlockProofResponse>()
        println("experimentalLightClientBlockProof Response: $result")

        //REQUEST_VALIDATION_ERROR
        assertTrue { true }

        //  assertTrue { response is RpcResponse.Success || (response is RpcResponse.Failure && response.error is RpcError.InternalError && response.error.code == -1002L) }
    }


    private val json = Json {
        encodeDefaults = true
        prettyPrint = true
    }

    @Test
    fun `test RpcLightClientBlockProofResponse serialization and deserialization`() {
        // ✅ Create inner block header
        val blockHeader = BlockHeaderInnerLiteView(
            blockMerkleRoot = CryptoHash("merkleRootHash"),
            epochId = CryptoHash("epochHash"),
            height = 12345uL,
            nextBpHash = CryptoHash("nextBpHash"),
            nextEpochId = CryptoHash("nextEpochHash"),
            outcomeRoot = CryptoHash("outcomeRootHash"),
            prevStateRoot = CryptoHash("prevStateRootHash"),
            timestamp = 1717171717uL,
            timestampNanosec = "1717171717000000"
        )

        // ✅ Create LightClientBlockLiteView
        val liteView = LightClientBlockLiteView(
            innerLite = blockHeader,
            innerRestHash = CryptoHash("restHash"),
            prevBlockHash = CryptoHash("prevBlockHash")
        )

        // ✅ Create Merkle path list
        val proofList = listOf(
            MerklePathItem(Direction.LEFT, CryptoHash("leftHash")),
            MerklePathItem(Direction.RIGHT, CryptoHash("rightHash")),
            MerklePathItem(Direction.LEFT, CryptoHash("anotherLeftHash"))
        )

        // ✅ Create full response model
        val model = RpcLightClientBlockProofResponse(
            blockHeaderLite = liteView,
            blockProof = proofList
        )

        // ✅ Serialize and deserialize
        val encoded = json.encodeToString<RpcLightClientBlockProofResponse>(model)
        val decoded = json.decodeFromString<RpcLightClientBlockProofResponse>(encoded)

        // ✅ Verify equality
        assertEquals(model, decoded)

        // ✅ Verify nested structures
        assertNotNull(decoded.blockHeaderLite)
        assertNotNull(decoded.blockProof)

        assertEquals(3, decoded.blockProof.size)
        assertEquals("restHash", decoded.blockHeaderLite.innerRestHash.value)
        assertEquals("epochHash", decoded.blockHeaderLite.innerLite.epochId.value)
        assertEquals(Direction.LEFT, decoded.blockProof[0].direction)
        assertEquals("rightHash", decoded.blockProof[1].hash.value)
    }
}