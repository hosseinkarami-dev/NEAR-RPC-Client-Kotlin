package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcClientConfigResponse(
  @SerialName("archive")
  public val archive: Boolean,
  @SerialName("block_fetch_horizon")
  public val blockFetchHorizon: Long,
  @SerialName("block_header_fetch_horizon")
  public val blockHeaderFetchHorizon: Long,
  @SerialName("block_production_tracking_delay")
  public val blockProductionTrackingDelay: List<Long>,
  @SerialName("catchup_step_period")
  public val catchupStepPeriod: List<Long>,
  @SerialName("chain_id")
  public val chainId: String,
  @SerialName("chunk_distribution_network")
  public val chunkDistributionNetwork: ChunkDistributionNetworkConfig?,
  @SerialName("chunk_request_retry_period")
  public val chunkRequestRetryPeriod: List<Long>,
  @SerialName("chunk_validation_threads")
  public val chunkValidationThreads: Int,
  @SerialName("chunk_wait_mult")
  public val chunkWaitMult: List<Int>,
  @SerialName("client_background_migration_threads")
  public val clientBackgroundMigrationThreads: Int,
  @SerialName("cloud_archival_reader")
  public val cloudArchivalReader: CloudArchivalReaderConfig?,
  @SerialName("cloud_archival_writer")
  public val cloudArchivalWriter: CloudArchivalWriterConfig?,
  @SerialName("doomslug_step_period")
  public val doomslugStepPeriod: List<Long>,
  @SerialName("enable_multiline_logging")
  public val enableMultilineLogging: Boolean,
  @SerialName("enable_statistics_export")
  public val enableStatisticsExport: Boolean,
  @SerialName("epoch_length")
  public val epochLength: Long,
  @SerialName("epoch_sync")
  public val epochSync: EpochSyncConfig,
  @SerialName("expected_shutdown")
  public val expectedShutdown: MutableConfigValue,
  @SerialName("gc")
  public val gc: GCConfig,
  @SerialName("header_sync_expected_height_per_second")
  public val headerSyncExpectedHeightPerSecond: Long,
  @SerialName("header_sync_initial_timeout")
  public val headerSyncInitialTimeout: List<Long>,
  @SerialName("header_sync_progress_timeout")
  public val headerSyncProgressTimeout: List<Long>,
  @SerialName("header_sync_stall_ban_timeout")
  public val headerSyncStallBanTimeout: List<Long>,
  @SerialName("log_summary_period")
  public val logSummaryPeriod: List<Long>,
  @SerialName("log_summary_style")
  public val logSummaryStyle: LogSummaryStyle,
  @SerialName("max_block_production_delay")
  public val maxBlockProductionDelay: List<Long>,
  @SerialName("max_block_wait_delay")
  public val maxBlockWaitDelay: List<Long>,
  @SerialName("max_gas_burnt_view")
  public val maxGasBurntView: NearGas?,
  @SerialName("min_block_production_delay")
  public val minBlockProductionDelay: List<Long>,
  @SerialName("min_num_peers")
  public val minNumPeers: Int,
  @SerialName("num_block_producer_seats")
  public val numBlockProducerSeats: Long,
  @SerialName("orphan_state_witness_max_size")
  public val orphanStateWitnessMaxSize: Long,
  @SerialName("orphan_state_witness_pool_size")
  public val orphanStateWitnessPoolSize: Int,
  @SerialName("produce_chunk_add_transactions_time_limit")
  public val produceChunkAddTransactionsTimeLimit: String,
  @SerialName("produce_empty_blocks")
  public val produceEmptyBlocks: Boolean,
  @SerialName("protocol_version_check")
  public val protocolVersionCheck: ProtocolVersionCheckConfig,
  @SerialName("resharding_config")
  public val reshardingConfig: MutableConfigValue,
  @SerialName("rpc_addr")
  public val rpcAddr: String?,
  @SerialName("save_invalid_witnesses")
  public val saveInvalidWitnesses: Boolean,
  @SerialName("save_latest_witnesses")
  public val saveLatestWitnesses: Boolean,
  @SerialName("save_trie_changes")
  public val saveTrieChanges: Boolean,
  @SerialName("save_tx_outcomes")
  public val saveTxOutcomes: Boolean,
  @SerialName("save_untracked_partial_chunks_parts")
  public val saveUntrackedPartialChunksParts: Boolean,
  @SerialName("skip_sync_wait")
  public val skipSyncWait: Boolean,
  @SerialName("state_request_server_threads")
  public val stateRequestServerThreads: Int,
  @SerialName("state_request_throttle_period")
  public val stateRequestThrottlePeriod: List<Long>,
  @SerialName("state_requests_per_throttle_period")
  public val stateRequestsPerThrottlePeriod: Int,
  @SerialName("state_sync")
  public val stateSync: StateSyncConfig,
  @SerialName("state_sync_enabled")
  public val stateSyncEnabled: Boolean,
  @SerialName("state_sync_external_backoff")
  public val stateSyncExternalBackoff: List<Long>,
  @SerialName("state_sync_external_timeout")
  public val stateSyncExternalTimeout: List<Long>,
  @SerialName("state_sync_p2p_timeout")
  public val stateSyncP2pTimeout: List<Long>,
  @SerialName("state_sync_retry_backoff")
  public val stateSyncRetryBackoff: List<Long>,
  @SerialName("sync_check_period")
  public val syncCheckPeriod: List<Long>,
  @SerialName("sync_height_threshold")
  public val syncHeightThreshold: Long,
  @SerialName("sync_max_block_requests")
  public val syncMaxBlockRequests: Int,
  @SerialName("sync_step_period")
  public val syncStepPeriod: List<Long>,
  @SerialName("tracked_shards_config")
  public val trackedShardsConfig: TrackedShardsConfig,
  @SerialName("transaction_pool_size_limit")
  public val transactionPoolSizeLimit: Long?,
  @SerialName("transaction_request_handler_threads")
  public val transactionRequestHandlerThreads: Int,
  @SerialName("trie_viewer_state_size_limit")
  public val trieViewerStateSizeLimit: Long?,
  @SerialName("ttl_account_id_router")
  public val ttlAccountIdRouter: List<Long>,
  @SerialName("tx_routing_height_horizon")
  public val txRoutingHeightHorizon: Long,
  @SerialName("version")
  public val version: Version,
  @SerialName("view_client_threads")
  public val viewClientThreads: Int,
)
