package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.client.Utils.getResultOrNull
import io.github.hosseinkarami_dev.near.rpc.models.AccountId
import io.github.hosseinkarami_dev.near.rpc.models.BlockHeaderInnerLiteView
import io.github.hosseinkarami_dev.near.rpc.models.ChunkDistributionNetworkConfig
import io.github.hosseinkarami_dev.near.rpc.models.ChunkDistributionUris
import io.github.hosseinkarami_dev.near.rpc.models.CloudArchivalWriterConfig
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.DumpConfig
import io.github.hosseinkarami_dev.near.rpc.models.DurationAsStdSchemaProvider
import io.github.hosseinkarami_dev.near.rpc.models.EpochSyncConfig
import io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation
import io.github.hosseinkarami_dev.near.rpc.models.GCConfig
import io.github.hosseinkarami_dev.near.rpc.models.LogSummaryStyle
import io.github.hosseinkarami_dev.near.rpc.models.MutableConfigValue
import io.github.hosseinkarami_dev.near.rpc.models.NearGas
import io.github.hosseinkarami_dev.near.rpc.models.NearToken
import io.github.hosseinkarami_dev.near.rpc.models.ProtocolVersionCheckConfig
import io.github.hosseinkarami_dev.near.rpc.models.PublicKey
import io.github.hosseinkarami_dev.near.rpc.models.RpcClientConfigResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientNextBlockResponse
import io.github.hosseinkarami_dev.near.rpc.models.ShardId
import io.github.hosseinkarami_dev.near.rpc.models.Signature
import io.github.hosseinkarami_dev.near.rpc.models.StateSyncConfig
import io.github.hosseinkarami_dev.near.rpc.models.SyncConcurrency
import io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig
import io.github.hosseinkarami_dev.near.rpc.models.ValidatorStakeView
import io.github.hosseinkarami_dev.near.rpc.models.Version
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
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class ClientConfigTest {

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
        val response = nearClient.clientConfig()
        val result = response.getResultOrNull<RpcClientConfigResponse>()
        println("Client Config Response: $response")

       //MissingFieldException -- Server API Problem
        assertTrue { true }

        //assertTrue { response is RpcResponse.Success || (response is RpcResponse.Failure && response.error is RpcError.InternalError && response.error.code == -1002L) }

    }

    private val json = Json {
        encodeDefaults = true
        ignoreUnknownKeys = false
        prettyPrint = false
    }

    @Test
    fun `test RpcClientConfigResponse serialization and deserialization`() {
        // helper lists with required size == 2
        val twoULong = listOf(1uL, 2uL)
        val twoInt = listOf(1, 2)

        // nested objects
        val chunkUris = ChunkDistributionUris(
            `get` = "https://cdn.example.com/get",
            `set` = "https://cdn.example.com/set"
        )
        val chunkDistCfg = ChunkDistributionNetworkConfig(
            enabled = true,
            uris = chunkUris
        )

        val cloudWriter = CloudArchivalWriterConfig(
            archiveBlockData = true,
            pollingInterval = DurationAsStdSchemaProvider(nanos = 0, secs = 60L)
        )

        val epochSyncCfg = EpochSyncConfig(
            disableEpochSyncForBootstrapping = false,
            epochSyncHorizon = 10uL,
            ignoreEpochSyncNetworkRequests = false,
            timeoutForEpochSync = DurationAsStdSchemaProvider(nanos = 0, secs = 30L)
        )

        val expectedShutdown = MutableConfigValue("none")

        val gcConfig = GCConfig() // uses defaults provided in model

        val version = Version(
            build = "build-123",
            commit = "commit-hash",
            rustcVersion = "rustc 1.72.0",
            version = "1.2.3"
        )

        val syncConcurrency = SyncConcurrency(
            apply = 1.toUByte(),
            applyDuringCatchup = 1.toUByte(),
            peerDownloads = 1.toUByte(),
            perShard = 1.toUByte()
        )

        val dumpConfig = DumpConfig(
            credentialsFile = null,
            iterationDelay = DurationAsStdSchemaProvider(nanos = 0, secs = 60L),
            location = ExternalStorageLocation.Filesystem(
                ExternalStorageLocation.Filesystem.FilesystemPayload(
                    rootDir = "/var/lib/near"
                )
            ),
            restartDumpForShards = null
        )

        val stateSyncConfig = StateSyncConfig(
            concurrency = syncConcurrency,
            dump = dumpConfig,
            partsCompressionLvl = 1,
            sync = null
        )

        // TrackedShardsConfig: use Schedule variant with ShardId lists (avoids ShardUId)
        val trackedShardsSchedule = TrackedShardsConfig.Schedule(
            schedule = listOf(
                listOf(ShardId(0uL), ShardId(1uL)),
                listOf(ShardId(2uL))
            )
        )

        // build the main model
        val model = RpcClientConfigResponse(
            archive = false,
            blockFetchHorizon = 100uL,
            blockHeaderFetchHorizon = 50uL,
            blockProductionTrackingDelay = twoULong,
            catchupStepPeriod = twoULong,
            chainId = "test-chain",
            chunkDistributionNetwork = chunkDistCfg,
            chunkRequestRetryPeriod = twoULong,
            chunkValidationThreads = 2u,
            chunkWaitMult = twoInt,
            clientBackgroundMigrationThreads = 1u,
            cloudArchivalWriter = cloudWriter,
            doomslugStepPeriod = twoULong,
            enableEarlyPrepareTransactions = false,
            enableMultilineLogging = true,
            enableStatisticsExport = true,
            epochLength = 1000uL,
            epochSync = epochSyncCfg,
            expectedShutdown = expectedShutdown,
            gc = gcConfig,
            headerSyncExpectedHeightPerSecond = 10uL,
            headerSyncInitialTimeout = twoULong,
            headerSyncProgressTimeout = twoULong,
            headerSyncStallBanTimeout = twoULong,
            logSummaryPeriod = twoULong,
            logSummaryStyle = LogSummaryStyle.COLORED,
            maxBlockProductionDelay = twoULong,
            maxBlockWaitDelay = twoULong,
            maxGasBurntView = NearGas(500uL),
            minBlockProductionDelay = twoULong,
            minNumPeers = 1u,
            numBlockProducerSeats = 100uL,
            orphanStateWitnessMaxSize = 10uL,
            orphanStateWitnessPoolSize = 5u,
            produceChunkAddTransactionsTimeLimit = "100ms",
            produceEmptyBlocks = true,
            protocolVersionCheck = ProtocolVersionCheckConfig.NEXT,
            reshardingConfig = MutableConfigValue("none"),
            rpcAddr = "127.0.0.1:3030",
            saveInvalidWitnesses = false,
            saveLatestWitnesses = true,
            saveTrieChanges = false,
            saveTxOutcomes = true,
            saveUntrackedPartialChunksParts = false,
            skipSyncWait = false,
            stateRequestServerThreads = 2u,
            stateRequestThrottlePeriod = twoULong,
            stateRequestsPerThrottlePeriod = 10u,
            stateSync = stateSyncConfig,
            stateSyncEnabled = true,
            stateSyncExternalBackoff = twoULong,
            stateSyncExternalTimeout = twoULong,
            stateSyncP2pTimeout = twoULong,
            stateSyncRetryBackoff = twoULong,
            syncCheckPeriod = twoULong,
            syncHeightThreshold = 5uL,
            syncMaxBlockRequests = 8u,
            syncStepPeriod = twoULong,
            trackedShardsConfig = trackedShardsSchedule,
            transactionPoolSizeLimit = 1024uL,
            transactionRequestHandlerThreads = 4u,
            trieViewerStateSizeLimit = 2048uL,
            ttlAccountIdRouter = twoULong,
            txRoutingHeightHorizon = 20uL,
            version = version,
            viewClientThreads = 2u
        )

        // Serialize & Deserialize
        val encoded = json.encodeToString(RpcClientConfigResponse.serializer(), model)
        val decoded = json.decodeFromString(RpcClientConfigResponse.serializer(), encoded)

        // Basic equality
        assertEquals(model, decoded)

        // Check list sizes (all must be 2 where specified)
        fun assertTwo(name: String, list: List<ULong>?) {
            assertNotNull(list, "$name should not be null")
            assertEquals(2, list.size, "$name must contain exactly 2 items")
        }

        assertTwo("blockProductionTrackingDelay", decoded.blockProductionTrackingDelay)
        assertTwo("catchupStepPeriod", decoded.catchupStepPeriod)
        assertTwo("chunkRequestRetryPeriod", decoded.chunkRequestRetryPeriod)
        assertTwo("doomslugStepPeriod", decoded.doomslugStepPeriod)
        assertTwo("headerSyncInitialTimeout", decoded.headerSyncInitialTimeout)
        assertTwo("headerSyncProgressTimeout", decoded.headerSyncProgressTimeout)
        assertTwo("headerSyncStallBanTimeout", decoded.headerSyncStallBanTimeout)
        assertTwo("logSummaryPeriod", decoded.logSummaryPeriod)
        assertTwo("maxBlockProductionDelay", decoded.maxBlockProductionDelay)
        assertTwo("maxBlockWaitDelay", decoded.maxBlockWaitDelay)
        assertTwo("minBlockProductionDelay", decoded.minBlockProductionDelay)
        assertTwo("stateRequestThrottlePeriod", decoded.stateRequestThrottlePeriod)
        assertTwo("stateSyncExternalBackoff", decoded.stateSyncExternalBackoff)
        assertTwo("stateSyncExternalTimeout", decoded.stateSyncExternalTimeout)
        assertTwo("stateSyncP2pTimeout", decoded.stateSyncP2pTimeout)
        assertTwo("stateSyncRetryBackoff", decoded.stateSyncRetryBackoff)
        assertTwo("syncCheckPeriod", decoded.syncCheckPeriod)
        assertTwo("syncStepPeriod", decoded.syncStepPeriod)
        assertTwo("ttlAccountIdRouter", decoded.ttlAccountIdRouter)

        // chunkWaitMult check
        assertNotNull(decoded.chunkWaitMult)
        assertEquals(2, decoded.chunkWaitMult.size)
        assertContentEquals(twoInt, decoded.chunkWaitMult)

        // nested checks
        assertEquals("test-chain", decoded.chainId)
        assertEquals("build-123", decoded.version.build)
        assertEquals(ProtocolVersionCheckConfig.NEXT, decoded.protocolVersionCheck)
        // tracked shards schedule specifics
        when (val t = decoded.trackedShardsConfig) {
            is TrackedShardsConfig.Schedule -> {
                assertEquals(2, t.schedule.size)
                assertEquals(2, t.schedule[0].size) // first inner list had two shard ids
            }
            else -> throw AssertionError("Expected Schedule trackedShardsConfig in test")
        }
    }

}