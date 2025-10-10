package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.client.Utils.getResultOrNull
import io.github.hosseinkarami_dev.near.rpc.models.AccountId
import io.github.hosseinkarami_dev.near.rpc.models.BlockId
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.Finality
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.assertTrue

class ChangesTest {

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
        var response = nearClient.changes(
            RpcStateChangesInBlockByTypeRequest.AccountChangesByBlockId(
                blockId = BlockId.BlockHeight(167697415U),
                accountIds = listOf(AccountId("relay.tg")),
                changesType = RpcStateChangesInBlockByTypeRequest.AccountChangesByBlockId.ChangesType.ACCOUNT_CHANGES
            )
        )
        val result = response.getResultOrNull<RpcStateChangesInBlockResponse>()
        println("Changes Response: $result")

        if (response !is RpcResponse.Success)
            assertTrue { false }


        response = nearClient.changes(
            RpcStateChangesInBlockByTypeRequest.AccountChangesByFinality(
                accountIds = listOf(AccountId("relay.tg")),
                changesType = RpcStateChangesInBlockByTypeRequest.AccountChangesByFinality.ChangesType.ACCOUNT_CHANGES,
                finality = Finality.FINAL
            )
        )

        println("Changes Response: $result")

        if (response !is RpcResponse.Success)
            assertTrue { false }

        assertTrue { true }
    }
}