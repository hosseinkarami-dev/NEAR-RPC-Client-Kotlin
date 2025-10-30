package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.ULong
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * ClientConfig where some fields can be updated at runtime.
 */
@Serializable
public data class RpcClientConfigResponse(
  /**
   *  * Not clear old data, set `true` for archive nodes.
   */
  @SerialName("archive")
  public val archive: Boolean,
  /**
   *  * Horizon at which instead of fetching block, fetch full state.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("block_fetch_horizon")
  public val blockFetchHorizon: ULong,
  /**
   *  * Behind this horizon header fetch kicks in.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("block_header_fetch_horizon")
  public val blockHeaderFetchHorizon: ULong,
  /**
   *  * Duration to check for producing / skipping block.
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("block_production_tracking_delay")
  public val blockProductionTrackingDelay: List<ULong>,
  /**
   *  * Time between check to perform catchup.
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("catchup_step_period")
  public val catchupStepPeriod: List<ULong>,
  /**
   *  * Chain id for status.
   */
  @SerialName("chain_id")
  public val chainId: String,
  /**
   *  * Optional config for the Chunk Distribution Network feature.
   * If set to `None` then this node does not participate in the Chunk Distribution Network.
   * Nodes not participating will still function fine, but possibly with higher
   * latency due to the need of requesting chunks over the peer-to-peer network.
   */
  @SerialName("chunk_distribution_network")
  public val chunkDistributionNetwork: ChunkDistributionNetworkConfig? = null,
  /**
   *  * Time between checking to re-request chunks.
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("chunk_request_retry_period")
  public val chunkRequestRetryPeriod: List<ULong>,
  /**
   *  * Number of threads for ChunkValidationActor pool.
   *  * Minimum: 0.0
   *  * Format: uint
   */
  @SerialName("chunk_validation_threads")
  public val chunkValidationThreads: UInt,
  /**
   *  * Multiplier for the wait time for all chunks to be received.
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("chunk_wait_mult")
  public val chunkWaitMult: List<Int>,
  /**
   *  * Number of threads to execute background migration work in client.
   *  * Minimum: 0.0
   *  * Format: uint
   */
  @SerialName("client_background_migration_threads")
  public val clientBackgroundMigrationThreads: UInt,
  /**
   *  * Configuration for a cloud-based archival writer. If this config is present, the writer is enabled and
   * writes chunk-related data based on the tracked shards.
   */
  @SerialName("cloud_archival_writer")
  public val cloudArchivalWriter: CloudArchivalWriterConfig? = null,
  /**
   *  * Time between running doomslug timer.
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("doomslug_step_period")
  public val doomslugStepPeriod: List<ULong>,
  /**
   *  * If true, the runtime will do a dynamic resharding 'dry run' at the last block of each epoch.
   * This means calculating tentative boundary accounts for splitting the tracked shards.
   */
  @SerialName("dynamic_resharding_dry_run")
  public val dynamicReshardingDryRun: Boolean,
  /**
   *  * If true, transactions for the next chunk will be prepared early, right after the previous chunk's
   * post-state is ready. This can help produce chunks faster, for high-throughput chains.
   * The current implementation increases latency on low-load chains, which will be fixed in the future.
   * The default is disabled.
   */
  @SerialName("enable_early_prepare_transactions")
  public val enableEarlyPrepareTransactions: Boolean,
  @SerialName("enable_multiline_logging")
  public val enableMultilineLogging: Boolean,
  /**
   *  * Re-export storage layer statistics as prometheus metrics.
   */
  @SerialName("enable_statistics_export")
  public val enableStatisticsExport: Boolean,
  /**
   *  * Epoch length.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("epoch_length")
  public val epochLength: ULong,
  /**
   *  * Options for epoch sync.
   */
  @SerialName("epoch_sync")
  public val epochSync: EpochSyncConfig,
  /**
   *  * Graceful shutdown at expected block height.
   */
  @SerialName("expected_shutdown")
  public val expectedShutdown: MutableConfigValue,
  /**
   *  * Garbage collection configuration.
   */
  @SerialName("gc")
  public val gc: GCConfig,
  /**
   *  * Expected increase of header head height per second during header sync
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("header_sync_expected_height_per_second")
  public val headerSyncExpectedHeightPerSecond: ULong,
  /**
   *  * How much time to wait after initial header sync
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("header_sync_initial_timeout")
  public val headerSyncInitialTimeout: List<ULong>,
  /**
   *  * How much time to wait after some progress is made in header sync
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("header_sync_progress_timeout")
  public val headerSyncProgressTimeout: List<ULong>,
  /**
   *  * How much time to wait before banning a peer in header sync if sync is too slow
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("header_sync_stall_ban_timeout")
  public val headerSyncStallBanTimeout: List<ULong>,
  /**
   *  * Period between logging summary information.
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("log_summary_period")
  public val logSummaryPeriod: List<ULong>,
  /**
   *  * Enable coloring of the logs
   */
  @SerialName("log_summary_style")
  public val logSummaryStyle: LogSummaryStyle,
  /**
   *  * Maximum wait for approvals before producing block.
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("max_block_production_delay")
  public val maxBlockProductionDelay: List<ULong>,
  /**
   *  * Maximum duration before skipping given height.
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("max_block_wait_delay")
  public val maxBlockWaitDelay: List<ULong>,
  /**
   *  * Max burnt gas per view method.  If present, overrides value stored in
   * genesis file.  The value only affects the RPCs without influencing the
   * protocol thus changing it per-node doesn’t affect the blockchain.
   */
  @SerialName("max_gas_burnt_view")
  public val maxGasBurntView: NearGas? = null,
  /**
   *  * Minimum duration before producing block.
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("min_block_production_delay")
  public val minBlockProductionDelay: List<ULong>,
  /**
   *  * Minimum number of peers to start syncing.
   *  * Minimum: 0.0
   *  * Format: uint
   */
  @SerialName("min_num_peers")
  public val minNumPeers: UInt,
  /**
   *  * Number of block producer seats
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("num_block_producer_seats")
  public val numBlockProducerSeats: ULong,
  /**
   *  * Maximum size of state witnesses in the OrphanStateWitnessPool.
   *
   * We keep only orphan witnesses which are smaller than this size.
   * This limits the maximum memory usage of OrphanStateWitnessPool.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("orphan_state_witness_max_size")
  public val orphanStateWitnessMaxSize: ULong,
  /**
   *  * OrphanStateWitnessPool keeps instances of ChunkStateWitness which can't be processed
   * because the previous block isn't available. The witnesses wait in the pool until the
   * required block appears. This variable controls how many witnesses can be stored in the pool.
   *  * Minimum: 0.0
   *  * Format: uint
   */
  @SerialName("orphan_state_witness_pool_size")
  public val orphanStateWitnessPoolSize: UInt,
  /**
   *  * Limit the time of adding transactions to a chunk.
   * A node produces a chunk by adding transactions from the transaction pool until
   * some limit is reached. This time limit ensures that adding transactions won't take
   * longer than the specified duration, which helps to produce the chunk quickly.
   */
  @SerialName("produce_chunk_add_transactions_time_limit")
  public val produceChunkAddTransactionsTimeLimit: String,
  /**
   *  * Produce empty blocks, use `false` for testing.
   */
  @SerialName("produce_empty_blocks")
  public val produceEmptyBlocks: Boolean,
  /**
   *  * Determines whether client should exit if the protocol version is not supported
   * for the next or next next epoch.
   */
  @SerialName("protocol_version_check")
  public val protocolVersionCheck: ProtocolVersionCheckConfig,
  @SerialName("resharding_config")
  public val reshardingConfig: MutableConfigValue,
  /**
   *  * Listening rpc port for status.
   *  * Nullable: true
   */
  @SerialName("rpc_addr")
  public val rpcAddr: String? = null,
  /**
   *  * Save observed instances of invalid ChunkStateWitness to the database in DBCol::InvalidChunkStateWitnesses.
   * Saving invalid witnesses is useful for analysis and debugging.
   * This option can cause extra load on the database and is not recommended for production use.
   */
  @SerialName("save_invalid_witnesses")
  public val saveInvalidWitnesses: Boolean,
  /**
   *  * Save observed instances of ChunkStateWitness to the database in DBCol::LatestChunkStateWitnesses.
   * Saving the latest witnesses is useful for analysis and debugging.
   * This option can cause extra load on the database and is not recommended for production use.
   */
  @SerialName("save_latest_witnesses")
  public val saveLatestWitnesses: Boolean,
  /**
   *  * save_trie_changes should be set to true iff
   * - archive if false - non-archival nodes need trie changes to perform garbage collection
   * - archive is true, cold_store is configured and migration to split_storage is finished - node
   * working in split storage mode needs trie changes in order to do garbage collection on hot.
   */
  @SerialName("save_trie_changes")
  public val saveTrieChanges: Boolean,
  /**
   *  * Whether to persist transaction outcomes to disk or not.
   */
  @SerialName("save_tx_outcomes")
  public val saveTxOutcomes: Boolean,
  /**
   *  * Whether to persist partial chunk parts for untracked shards or not.
   */
  @SerialName("save_untracked_partial_chunks_parts")
  public val saveUntrackedPartialChunksParts: Boolean,
  /**
   *  * Skip waiting for sync (for testing or single node testnet).
   */
  @SerialName("skip_sync_wait")
  public val skipSyncWait: Boolean,
  /**
   *  * Number of threads for StateRequestActor pool.
   *  * Minimum: 0.0
   *  * Format: uint
   */
  @SerialName("state_request_server_threads")
  public val stateRequestServerThreads: UInt,
  /**
   *  * Number of seconds between state requests for view client.
   * Throttling window for state requests (headers and parts).
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("state_request_throttle_period")
  public val stateRequestThrottlePeriod: List<ULong>,
  /**
   *  * Maximum number of state requests served per throttle period
   *  * Minimum: 0.0
   *  * Format: uint
   */
  @SerialName("state_requests_per_throttle_period")
  public val stateRequestsPerThrottlePeriod: UInt,
  /**
   *  * Options for syncing state.
   */
  @SerialName("state_sync")
  public val stateSync: StateSyncConfig,
  /**
   *  * Whether to use the State Sync mechanism.
   * If disabled, the node will do Block Sync instead of State Sync.
   */
  @SerialName("state_sync_enabled")
  public val stateSyncEnabled: Boolean,
  /**
   *  * Additional waiting period after a failed request to external storage
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("state_sync_external_backoff")
  public val stateSyncExternalBackoff: List<ULong>,
  /**
   *  * How long to wait for a response from centralized state sync
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("state_sync_external_timeout")
  public val stateSyncExternalTimeout: List<ULong>,
  /**
   *  * How long to wait for a response from p2p state sync
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("state_sync_p2p_timeout")
  public val stateSyncP2pTimeout: List<ULong>,
  /**
   *  * How long to wait after a failed state sync request
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("state_sync_retry_backoff")
  public val stateSyncRetryBackoff: List<ULong>,
  /**
   *  * How often to check that we are not out of sync.
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("sync_check_period")
  public val syncCheckPeriod: List<ULong>,
  /**
   *  * Sync height threshold: below this difference in height don't start syncing.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("sync_height_threshold")
  public val syncHeightThreshold: ULong,
  /**
   *  * Maximum number of block requests to send to peers to sync
   *  * Minimum: 0.0
   *  * Format: uint
   */
  @SerialName("sync_max_block_requests")
  public val syncMaxBlockRequests: UInt,
  /**
   *  * While syncing, how long to check for each step.
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("sync_step_period")
  public val syncStepPeriod: List<ULong>,
  @SerialName("tracked_shards_config")
  public val trackedShardsConfig: TrackedShardsConfig,
  /**
   *  * Limit of the size of per-shard transaction pool measured in bytes. If not set, the size
   * will be unbounded.
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("transaction_pool_size_limit")
  public val transactionPoolSizeLimit: ULong? = null,
  /**
   *  * Minimum: 0.0
   *  * Format: uint
   */
  @SerialName("transaction_request_handler_threads")
  public val transactionRequestHandlerThreads: UInt,
  /**
   *  * Upper bound of the byte size of contract state that is still viewable. None is no limit
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("trie_viewer_state_size_limit")
  public val trieViewerStateSizeLimit: ULong? = null,
  /**
   *  * Time to persist Accounts Id in the router without removing them.
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("ttl_account_id_router")
  public val ttlAccountIdRouter: List<ULong>,
  /**
   *  * If the node is not a chunk producer within that many blocks, then route
   * to upcoming chunk producers.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("tx_routing_height_horizon")
  public val txRoutingHeightHorizon: ULong,
  /**
   *  * Version of the binary.
   */
  @SerialName("version")
  public val version: Version,
  /**
   *  * Number of threads for ViewClientActor pool.
   *  * Minimum: 0.0
   *  * Format: uint
   */
  @SerialName("view_client_threads")
  public val viewClientThreads: UInt,
) {
  init {
    require((blockProductionTrackingDelay?.size ?: 0) >= 2) { "RpcClientConfigResponse.blockProductionTrackingDelay must contain at least 2 items (minItems = 2)" }}
  init {
    require((blockProductionTrackingDelay?.size ?: 0) <= 2) { "RpcClientConfigResponse.blockProductionTrackingDelay must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((catchupStepPeriod?.size ?: 0) >= 2) { "RpcClientConfigResponse.catchupStepPeriod must contain at least 2 items (minItems = 2)" }}
  init {
    require((catchupStepPeriod?.size ?: 0) <= 2) { "RpcClientConfigResponse.catchupStepPeriod must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((chunkRequestRetryPeriod?.size ?: 0) >= 2) { "RpcClientConfigResponse.chunkRequestRetryPeriod must contain at least 2 items (minItems = 2)" }}
  init {
    require((chunkRequestRetryPeriod?.size ?: 0) <= 2) { "RpcClientConfigResponse.chunkRequestRetryPeriod must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((chunkWaitMult?.size ?: 0) >= 2) { "RpcClientConfigResponse.chunkWaitMult must contain at least 2 items (minItems = 2)" }}
  init {
    require((chunkWaitMult?.size ?: 0) <= 2) { "RpcClientConfigResponse.chunkWaitMult must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((doomslugStepPeriod?.size ?: 0) >= 2) { "RpcClientConfigResponse.doomslugStepPeriod must contain at least 2 items (minItems = 2)" }}
  init {
    require((doomslugStepPeriod?.size ?: 0) <= 2) { "RpcClientConfigResponse.doomslugStepPeriod must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((headerSyncInitialTimeout?.size ?: 0) >= 2) { "RpcClientConfigResponse.headerSyncInitialTimeout must contain at least 2 items (minItems = 2)" }}
  init {
    require((headerSyncInitialTimeout?.size ?: 0) <= 2) { "RpcClientConfigResponse.headerSyncInitialTimeout must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((headerSyncProgressTimeout?.size ?: 0) >= 2) { "RpcClientConfigResponse.headerSyncProgressTimeout must contain at least 2 items (minItems = 2)" }}
  init {
    require((headerSyncProgressTimeout?.size ?: 0) <= 2) { "RpcClientConfigResponse.headerSyncProgressTimeout must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((headerSyncStallBanTimeout?.size ?: 0) >= 2) { "RpcClientConfigResponse.headerSyncStallBanTimeout must contain at least 2 items (minItems = 2)" }}
  init {
    require((headerSyncStallBanTimeout?.size ?: 0) <= 2) { "RpcClientConfigResponse.headerSyncStallBanTimeout must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((logSummaryPeriod?.size ?: 0) >= 2) { "RpcClientConfigResponse.logSummaryPeriod must contain at least 2 items (minItems = 2)" }}
  init {
    require((logSummaryPeriod?.size ?: 0) <= 2) { "RpcClientConfigResponse.logSummaryPeriod must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((maxBlockProductionDelay?.size ?: 0) >= 2) { "RpcClientConfigResponse.maxBlockProductionDelay must contain at least 2 items (minItems = 2)" }}
  init {
    require((maxBlockProductionDelay?.size ?: 0) <= 2) { "RpcClientConfigResponse.maxBlockProductionDelay must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((maxBlockWaitDelay?.size ?: 0) >= 2) { "RpcClientConfigResponse.maxBlockWaitDelay must contain at least 2 items (minItems = 2)" }}
  init {
    require((maxBlockWaitDelay?.size ?: 0) <= 2) { "RpcClientConfigResponse.maxBlockWaitDelay must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((minBlockProductionDelay?.size ?: 0) >= 2) { "RpcClientConfigResponse.minBlockProductionDelay must contain at least 2 items (minItems = 2)" }}
  init {
    require((minBlockProductionDelay?.size ?: 0) <= 2) { "RpcClientConfigResponse.minBlockProductionDelay must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((stateRequestThrottlePeriod?.size ?: 0) >= 2) { "RpcClientConfigResponse.stateRequestThrottlePeriod must contain at least 2 items (minItems = 2)" }}
  init {
    require((stateRequestThrottlePeriod?.size ?: 0) <= 2) { "RpcClientConfigResponse.stateRequestThrottlePeriod must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((stateSyncExternalBackoff?.size ?: 0) >= 2) { "RpcClientConfigResponse.stateSyncExternalBackoff must contain at least 2 items (minItems = 2)" }}
  init {
    require((stateSyncExternalBackoff?.size ?: 0) <= 2) { "RpcClientConfigResponse.stateSyncExternalBackoff must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((stateSyncExternalTimeout?.size ?: 0) >= 2) { "RpcClientConfigResponse.stateSyncExternalTimeout must contain at least 2 items (minItems = 2)" }}
  init {
    require((stateSyncExternalTimeout?.size ?: 0) <= 2) { "RpcClientConfigResponse.stateSyncExternalTimeout must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((stateSyncP2pTimeout?.size ?: 0) >= 2) { "RpcClientConfigResponse.stateSyncP2pTimeout must contain at least 2 items (minItems = 2)" }}
  init {
    require((stateSyncP2pTimeout?.size ?: 0) <= 2) { "RpcClientConfigResponse.stateSyncP2pTimeout must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((stateSyncRetryBackoff?.size ?: 0) >= 2) { "RpcClientConfigResponse.stateSyncRetryBackoff must contain at least 2 items (minItems = 2)" }}
  init {
    require((stateSyncRetryBackoff?.size ?: 0) <= 2) { "RpcClientConfigResponse.stateSyncRetryBackoff must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((syncCheckPeriod?.size ?: 0) >= 2) { "RpcClientConfigResponse.syncCheckPeriod must contain at least 2 items (minItems = 2)" }}
  init {
    require((syncCheckPeriod?.size ?: 0) <= 2) { "RpcClientConfigResponse.syncCheckPeriod must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((syncStepPeriod?.size ?: 0) >= 2) { "RpcClientConfigResponse.syncStepPeriod must contain at least 2 items (minItems = 2)" }}
  init {
    require((syncStepPeriod?.size ?: 0) <= 2) { "RpcClientConfigResponse.syncStepPeriod must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((ttlAccountIdRouter?.size ?: 0) >= 2) { "RpcClientConfigResponse.ttlAccountIdRouter must contain at least 2 items (minItems = 2)" }}
  init {
    require((ttlAccountIdRouter?.size ?: 0) <= 2) { "RpcClientConfigResponse.ttlAccountIdRouter must contain no more than 2 items (maxItems = 2)" }}
}
