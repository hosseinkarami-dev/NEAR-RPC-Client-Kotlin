package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class GenesisConfig(
  /**
   *  * Expected number of hidden validators per shard.
   */
  @SerialName("avg_hidden_validator_seats_per_shard")
  public val avgHiddenValidatorSeatsPerShard: List<ULong>,
  /**
   *  * Threshold for kicking out block producers, between 0 and 100.
   *  * Minimum: 0.0
   *  * Maximum: 255.0
   *  * Format: uint8
   */
  @SerialName("block_producer_kickout_threshold")
  public val blockProducerKickoutThreshold: UByte,
  /**
   *  * ID of the blockchain. This must be unique for every blockchain.
   * If your testnet blockchains do not have unique chain IDs, you will have a bad time.
   */
  @SerialName("chain_id")
  public val chainId: String,
  /**
   *  * Limits the number of shard changes in chunk producer assignments,
   * if algorithm is able to choose assignment with better balance of
   * number of chunk producers for shards.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("chunk_producer_assignment_changes_limit")
  public val chunkProducerAssignmentChangesLimit: ULong? = 5.toULong(),
  /**
   *  * Threshold for kicking out chunk producers, between 0 and 100.
   *  * Minimum: 0.0
   *  * Maximum: 255.0
   *  * Format: uint8
   */
  @SerialName("chunk_producer_kickout_threshold")
  public val chunkProducerKickoutThreshold: UByte,
  /**
   *  * Threshold for kicking out nodes which are only chunk validators, between 0 and 100.
   *  * Minimum: 0.0
   *  * Maximum: 255.0
   *  * Format: uint8
   */
  @SerialName("chunk_validator_only_kickout_threshold")
  public val chunkValidatorOnlyKickoutThreshold: UByte? = 80.toUByte(),
  /**
   *  * Enable dynamic re-sharding.
   */
  @SerialName("dynamic_resharding")
  public val dynamicResharding: Boolean,
  /**
   *  * Epoch length counted in block heights.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("epoch_length")
  public val epochLength: ULong,
  /**
   *  * Fishermen stake threshold.
   */
  @SerialName("fishermen_threshold")
  public val fishermenThreshold: NearToken,
  /**
   *  * Initial gas limit.
   */
  @SerialName("gas_limit")
  public val gasLimit: NearGas,
  /**
   *  * Gas price adjustment rate
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("gas_price_adjustment_rate")
  public val gasPriceAdjustmentRate: List<Int>,
  /**
   *  * Height of genesis block.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("genesis_height")
  public val genesisHeight: ULong,
  /**
   *  * Official time of blockchain start.
   *  * Format: date-time
   */
  @SerialName("genesis_time")
  public val genesisTime: String,
  @SerialName("max_gas_price")
  public val maxGasPrice: NearToken,
  /**
   *  * Maximum inflation on the total supply every epoch.
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("max_inflation_rate")
  public val maxInflationRate: List<Int>,
  /**
   *  * Max stake percentage of the validators we will kick out.
   *  * Minimum: 0.0
   *  * Maximum: 255.0
   *  * Format: uint8
   */
  @SerialName("max_kickout_stake_perc")
  public val maxKickoutStakePerc: UByte? = 100.toUByte(),
  /**
   *  * Minimum gas price. It is also the initial gas price.
   */
  @SerialName("min_gas_price")
  public val minGasPrice: NearToken,
  /**
   *  * The minimum stake required for staking is last seat price divided by this number.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("minimum_stake_divisor")
  public val minimumStakeDivisor: ULong? = 10.toULong(),
  /**
   *  * The lowest ratio s/s_total any block producer can have.
   * See <https://github.com/near/NEPs/pull/167> for details
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("minimum_stake_ratio")
  public val minimumStakeRatio: List<Int>? = listOf(1, 6250),
  /**
   *  * The minimum number of validators each shard must have
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("minimum_validators_per_shard")
  public val minimumValidatorsPerShard: ULong? = 1.toULong(),
  /**
   *  * Number of block producer seats at genesis.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("num_block_producer_seats")
  public val numBlockProducerSeats: ULong,
  /**
   *  * Defines number of shards and number of block producer seats per each shard at genesis.
   * Note: not used with protocol_feature_chunk_only_producers -- replaced by minimum_validators_per_shard
   * Note: not used before as all block producers produce chunks for all shards
   */
  @SerialName("num_block_producer_seats_per_shard")
  public val numBlockProducerSeatsPerShard: List<ULong>,
  /**
   *  * Expected number of blocks per year
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("num_blocks_per_year")
  public val numBlocksPerYear: ULong,
  /**
   *  * Deprecated.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("num_chunk_only_producer_seats")
  public val numChunkOnlyProducerSeats: ULong? = 300.toULong(),
  /**
   *  * Number of chunk producers.
   * Don't mess it up with chunk-only producers feature which is deprecated.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("num_chunk_producer_seats")
  public val numChunkProducerSeats: ULong? = 100.toULong(),
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("num_chunk_validator_seats")
  public val numChunkValidatorSeats: ULong? = 300.toULong(),
  /**
   *  * Online maximum threshold above which validator gets full reward.
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("online_max_threshold")
  public val onlineMaxThreshold: List<Int>? = listOf(99, 100),
  /**
   *  * Online minimum threshold below which validator doesn't receive reward.
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("online_min_threshold")
  public val onlineMinThreshold: List<Int>? = listOf(9, 10),
  /**
   *  * Protocol treasury rate
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("protocol_reward_rate")
  public val protocolRewardRate: List<Int>,
  /**
   *  * Protocol treasury account
   */
  @SerialName("protocol_treasury_account")
  public val protocolTreasuryAccount: AccountId,
  /**
   *  * Threshold of stake that needs to indicate that they ready for upgrade.
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("protocol_upgrade_stake_threshold")
  public val protocolUpgradeStakeThreshold: List<Int>? = listOf(4, 5),
  /**
   *  * Protocol version that this genesis works with.
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("protocol_version")
  public val protocolVersion: UInt,
  /**
   *  * Layout information regarding how to split accounts to shards
   */
  @SerialName("shard_layout")
  public val shardLayout: ShardLayout? = null,
  /**
   *  * If true, shuffle the chunk producers across shards. In other words, if
   * the shard assignments were `[S_0, S_1, S_2, S_3]` where `S_i` represents
   * the set of chunk producers for shard `i`, if this flag were true, the
   * shard assignments might become, for example, `[S_2, S_0, S_3, S_1]`.
   */
  @SerialName("shuffle_shard_assignment_for_chunk_producers")
  public val shuffleShardAssignmentForChunkProducers: Boolean? = false,
  /**
   *  * Number of target chunk validator mandates for each shard.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("target_validator_mandates_per_shard")
  public val targetValidatorMandatesPerShard: ULong? = 68.toULong(),
  /**
   *  * Total supply of tokens at genesis.
   */
  @SerialName("total_supply")
  public val totalSupply: NearToken,
  /**
   *  * Number of blocks for which a given transaction is valid
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("transaction_validity_period")
  public val transactionValidityPeriod: ULong,
  /**
   *  * This is only for test purposes. We hard code some configs for mainnet and testnet
   * in AllEpochConfig, and we want to have a way to test that code path. This flag is for that.
   * If set to true, the node will use the same config override path as mainnet and testnet.
   */
  @SerialName("use_production_config")
  public val useProductionConfig: Boolean? = false,
  /**
   *  * List of initial validators.
   */
  @SerialName("validators")
  public val validators: List<AccountInfo>,
) {
  init {
    require((gasPriceAdjustmentRate?.size ?: 0) >= 2) { "GenesisConfig.gasPriceAdjustmentRate must contain at least 2 items (minItems = 2)" }}
  init {
    require((gasPriceAdjustmentRate?.size ?: 0) <= 2) { "GenesisConfig.gasPriceAdjustmentRate must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((maxInflationRate?.size ?: 0) >= 2) { "GenesisConfig.maxInflationRate must contain at least 2 items (minItems = 2)" }}
  init {
    require((maxInflationRate?.size ?: 0) <= 2) { "GenesisConfig.maxInflationRate must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((minimumStakeRatio?.size ?: 0) >= 2) { "GenesisConfig.minimumStakeRatio must contain at least 2 items (minItems = 2)" }}
  init {
    require((minimumStakeRatio?.size ?: 0) <= 2) { "GenesisConfig.minimumStakeRatio must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((onlineMaxThreshold?.size ?: 0) >= 2) { "GenesisConfig.onlineMaxThreshold must contain at least 2 items (minItems = 2)" }}
  init {
    require((onlineMaxThreshold?.size ?: 0) <= 2) { "GenesisConfig.onlineMaxThreshold must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((onlineMinThreshold?.size ?: 0) >= 2) { "GenesisConfig.onlineMinThreshold must contain at least 2 items (minItems = 2)" }}
  init {
    require((onlineMinThreshold?.size ?: 0) <= 2) { "GenesisConfig.onlineMinThreshold must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((protocolRewardRate?.size ?: 0) >= 2) { "GenesisConfig.protocolRewardRate must contain at least 2 items (minItems = 2)" }}
  init {
    require((protocolRewardRate?.size ?: 0) <= 2) { "GenesisConfig.protocolRewardRate must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((protocolUpgradeStakeThreshold?.size ?: 0) >= 2) { "GenesisConfig.protocolUpgradeStakeThreshold must contain at least 2 items (minItems = 2)" }}
  init {
    require((protocolUpgradeStakeThreshold?.size ?: 0) <= 2) { "GenesisConfig.protocolUpgradeStakeThreshold must contain no more than 2 items (maxItems = 2)" }}
}
