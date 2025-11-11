package io.github.hosseinkarami_dev.near.rpc.client

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.fail
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.http.*
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import java.io.File

/**
 * Generated client unit tests using mock JSON from src/test/resources/mock/
 */
class NearClientUnitTests {

    private val json = Json { ignoreUnknownKeys = true }

    private fun loadMockJson(filename: String): String? {
        val f = File("src/test/resources/mock/$filename")
        return if (f.exists()) f.readText() else null
    }

    @Test
    fun testExperimentalChanges() = runTest {
        val data = loadMockJson("JsonRpcRequestForExperimentalChanges.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalChanges.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalChanges.serializer(), data)
            val response = nearClient.experimentalChanges(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for ExperimentalChanges failed: ${e.message}")
        }
    }

    @Test
    fun testExperimentalChangesInBlock() = runTest {
        val data = loadMockJson("JsonRpcRequestForExperimentalChangesInBlock.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalChangesInBlock.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalChangesInBlock.serializer(), data)
            val response = nearClient.experimentalChangesInBlock(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for ExperimentalChangesInBlock failed: ${e.message}")
        }
    }

    @Test
    fun testExperimentalCongestionLevel() = runTest {
        val data = loadMockJson("JsonRpcRequestForExperimentalCongestionLevel.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalCongestionLevel.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalCongestionLevel.serializer(), data)
            val response = nearClient.experimentalCongestionLevel(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for ExperimentalCongestionLevel failed: ${e.message}")
        }
    }

    @Test
    fun testExperimentalGenesisConfig() = runTest {
        val data = loadMockJson("JsonRpcRequestForExperimentalGenesisConfig.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalGenesisConfig.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalGenesisConfig.serializer(), data)
            val response = nearClient.experimentalGenesisConfig()
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for ExperimentalGenesisConfig failed: ${e.message}")
        }
    }

    @Test
    fun testExperimentalLightClientBlockProof() = runTest {
        val data = loadMockJson("JsonRpcRequestForExperimentalLightClientBlockProof.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalLightClientBlockProof.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalLightClientBlockProof.serializer(), data)
            val response = nearClient.experimentalLightClientBlockProof(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for ExperimentalLightClientBlockProof failed: ${e.message}")
        }
    }

    @Test
    fun testExperimentalLightClientProof() = runTest {
        val data = loadMockJson("JsonRpcRequestForExperimentalLightClientProof.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalLightClientProof.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalLightClientProof.serializer(), data)
            val response = nearClient.experimentalLightClientProof(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for ExperimentalLightClientProof failed: ${e.message}")
        }
    }

    @Test
    fun testExperimentalMaintenanceWindows() = runTest {
        val data = loadMockJson("JsonRpcRequestForExperimentalMaintenanceWindows.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalMaintenanceWindows.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalMaintenanceWindows.serializer(), data)
            val response = nearClient.experimentalMaintenanceWindows(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for ExperimentalMaintenanceWindows failed: ${e.message}")
        }
    }

    @Test
    fun testExperimentalProtocolConfig() = runTest {
        val data = loadMockJson("JsonRpcRequestForExperimentalProtocolConfig.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalProtocolConfig.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalProtocolConfig.serializer(), data)
            val response = nearClient.experimentalProtocolConfig(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for ExperimentalProtocolConfig failed: ${e.message}")
        }
    }

    @Test
    fun testExperimentalReceipt() = runTest {
        val data = loadMockJson("JsonRpcRequestForExperimentalReceipt.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalReceipt.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalReceipt.serializer(), data)
            val response = nearClient.experimentalReceipt(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for ExperimentalReceipt failed: ${e.message}")
        }
    }

    @Test
    fun testExperimentalSplitStorageInfo() = runTest {
        val data = loadMockJson("JsonRpcRequestForExperimentalSplitStorageInfo.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalSplitStorageInfo.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalSplitStorageInfo.serializer(), data)
            val response = nearClient.experimentalSplitStorageInfo()
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for ExperimentalSplitStorageInfo failed: ${e.message}")
        }
    }

    @Test
    fun testExperimentalTxStatus() = runTest {
        val data = loadMockJson("JsonRpcRequestForExperimentalTxStatus.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalTxStatus.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalTxStatus.serializer(), data)
            val response = nearClient.experimentalTxStatus(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for ExperimentalTxStatus failed: ${e.message}")
        }
    }

    @Test
    fun testExperimentalValidatorsOrdered() = runTest {
        val data = loadMockJson("JsonRpcRequestForExperimentalValidatorsOrdered.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalValidatorsOrdered.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalValidatorsOrdered.serializer(), data)
            val response = nearClient.experimentalValidatorsOrdered(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for ExperimentalValidatorsOrdered failed: ${e.message}")
        }
    }

    @Test
    fun testBlock() = runTest {
        val data = loadMockJson("JsonRpcRequestForBlock.json")
        assertNotNull(data, "Mock file JsonRpcRequestForBlock.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBlock.serializer(), data)
            val response = nearClient.block(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for Block failed: ${e.message}")
        }
    }

    @Test
    fun testBlockEffects() = runTest {
        val data = loadMockJson("JsonRpcRequestForBlockEffects.json")
        assertNotNull(data, "Mock file JsonRpcRequestForBlockEffects.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBlockEffects.serializer(), data)
            val response = nearClient.blockEffects(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for BlockEffects failed: ${e.message}")
        }
    }

    @Test
    fun testBroadcastTxAsync() = runTest {
        val data = loadMockJson("JsonRpcRequestForBroadcastTxAsync.json")
        assertNotNull(data, "Mock file JsonRpcRequestForBroadcastTxAsync.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBroadcastTxAsync.serializer(), data)
            val response = nearClient.broadcastTxAsync(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for BroadcastTxAsync failed: ${e.message}")
        }
    }

    @Test
    fun testBroadcastTxCommit() = runTest {
        val data = loadMockJson("JsonRpcRequestForBroadcastTxCommit.json")
        assertNotNull(data, "Mock file JsonRpcRequestForBroadcastTxCommit.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBroadcastTxCommit.serializer(), data)
            val response = nearClient.broadcastTxCommit(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for BroadcastTxCommit failed: ${e.message}")
        }
    }

    @Test
    fun testChanges() = runTest {
        val data = loadMockJson("JsonRpcRequestForChanges.json")
        assertNotNull(data, "Mock file JsonRpcRequestForChanges.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForChanges.serializer(), data)
            val response = nearClient.changes(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for Changes failed: ${e.message}")
        }
    }

    @Test
    fun testChunk() = runTest {
        val data = loadMockJson("JsonRpcRequestForChunk.json")
        assertNotNull(data, "Mock file JsonRpcRequestForChunk.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForChunk.serializer(), data)
            val response = nearClient.chunk(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for Chunk failed: ${e.message}")
        }
    }

    @Test
    fun testClientConfig() = runTest {
        val data = loadMockJson("JsonRpcRequestForClientConfig.json")
        assertNotNull(data, "Mock file JsonRpcRequestForClientConfig.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForClientConfig.serializer(), data)
            val response = nearClient.clientConfig()
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for ClientConfig failed: ${e.message}")
        }
    }

    @Test
    fun testGasPrice() = runTest {
        val data = loadMockJson("JsonRpcRequestForGasPrice.json")
        assertNotNull(data, "Mock file JsonRpcRequestForGasPrice.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForGasPrice.serializer(), data)
            val response = nearClient.gasPrice(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for GasPrice failed: ${e.message}")
        }
    }

    @Test
    fun testGenesisConfig() = runTest {
        val data = loadMockJson("JsonRpcRequestForGenesisConfig.json")
        assertNotNull(data, "Mock file JsonRpcRequestForGenesisConfig.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForGenesisConfig.serializer(), data)
            val response = nearClient.genesisConfig()
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for GenesisConfig failed: ${e.message}")
        }
    }

    @Test
    fun testHealth() = runTest {
        val data = loadMockJson("JsonRpcRequestForHealth.json")
        assertNotNull(data, "Mock file JsonRpcRequestForHealth.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForHealth.serializer(), data)
            val response = nearClient.health()
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for Health failed: ${e.message}")
        }
    }

    @Test
    fun testLightClientProof() = runTest {
        val data = loadMockJson("JsonRpcRequestForLightClientProof.json")
        assertNotNull(data, "Mock file JsonRpcRequestForLightClientProof.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForLightClientProof.serializer(), data)
            val response = nearClient.lightClientProof(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for LightClientProof failed: ${e.message}")
        }
    }

    @Test
    fun testMaintenanceWindows() = runTest {
        val data = loadMockJson("JsonRpcRequestForMaintenanceWindows.json")
        assertNotNull(data, "Mock file JsonRpcRequestForMaintenanceWindows.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForMaintenanceWindows.serializer(), data)
            val response = nearClient.maintenanceWindows(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for MaintenanceWindows failed: ${e.message}")
        }
    }

    @Test
    fun testNetworkInfo() = runTest {
        val data = loadMockJson("JsonRpcRequestForNetworkInfo.json")
        assertNotNull(data, "Mock file JsonRpcRequestForNetworkInfo.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForNetworkInfo.serializer(), data)
            val response = nearClient.networkInfo()
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for NetworkInfo failed: ${e.message}")
        }
    }

    @Test
    fun testNextLightClientBlock() = runTest {
        val data = loadMockJson("JsonRpcRequestForNextLightClientBlock.json")
        assertNotNull(data, "Mock file JsonRpcRequestForNextLightClientBlock.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForNextLightClientBlock.serializer(), data)
            val response = nearClient.nextLightClientBlock(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for NextLightClientBlock failed: ${e.message}")
        }
    }

    @Test
    fun testQuery() = runTest {
        val data = loadMockJson("JsonRpcRequestForQuery.json")
        assertNotNull(data, "Mock file JsonRpcRequestForQuery.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForQuery.serializer(), data)
            val response = nearClient.query(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for Query failed: ${e.message}")
        }
    }

    @Test
    fun testSendTx() = runTest {
        val data = loadMockJson("JsonRpcRequestForSendTx.json")
        assertNotNull(data, "Mock file JsonRpcRequestForSendTx.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForSendTx.serializer(), data)
            val response = nearClient.sendTx(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for SendTx failed: ${e.message}")
        }
    }

    @Test
    fun testStatus() = runTest {
        val data = loadMockJson("JsonRpcRequestForStatus.json")
        assertNotNull(data, "Mock file JsonRpcRequestForStatus.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForStatus.serializer(), data)
            val response = nearClient.status()
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for Status failed: ${e.message}")
        }
    }

    @Test
    fun testTx() = runTest {
        val data = loadMockJson("JsonRpcRequestForTx.json")
        assertNotNull(data, "Mock file JsonRpcRequestForTx.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForTx.serializer(), data)
            val response = nearClient.tx(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for Tx failed: ${e.message}")
        }
    }

    @Test
    fun testValidators() = runTest {
        val data = loadMockJson("JsonRpcRequestForValidators.json")
        assertNotNull(data, "Mock file JsonRpcRequestForValidators.json does not exist!")


        val mockEngine = MockEngine { req ->
            when (req.url.fullPath) {
                else -> respond(data, headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString())))
            }
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }

        val nearClient = io.github.hosseinkarami_dev.near.rpc.client.NearClient(client, "http://mock", json)

        try {
            val requestObj = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForValidators.serializer(), data)
            val response = nearClient.validators(requestObj.params)
            assertNotNull(response)
        } catch (e: Exception) {
            fail("Test for Validators failed: ${e.message}")
        }
    }

}
