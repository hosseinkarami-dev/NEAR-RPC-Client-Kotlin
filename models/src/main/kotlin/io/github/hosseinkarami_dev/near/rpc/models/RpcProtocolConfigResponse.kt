package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcProtocolConfigResponse(
  @SerialName("avg_hidden_validator_seats_per_shard")
  public val avgHiddenValidatorSeatsPerShard: List<Long>,
  @SerialName("block_producer_kickout_threshold")
  public val blockProducerKickoutThreshold: Int,
  @SerialName("chain_id")
  public val chainId: String,
  @SerialName("chunk_producer_kickout_threshold")
  public val chunkProducerKickoutThreshold: Int,
  @SerialName("chunk_validator_only_kickout_threshold")
  public val chunkValidatorOnlyKickoutThreshold: Int,
  @SerialName("dynamic_resharding")
  public val dynamicResharding: Boolean,
  @SerialName("epoch_length")
  public val epochLength: Long,
  @SerialName("fishermen_threshold")
  public val fishermenThreshold: NearToken,
  @SerialName("gas_limit")
  public val gasLimit: NearGas,
  @SerialName("gas_price_adjustment_rate")
  public val gasPriceAdjustmentRate: List<Int>,
  @SerialName("genesis_height")
  public val genesisHeight: Long,
  @SerialName("genesis_time")
  public val genesisTime: String,
  @SerialName("max_gas_price")
  public val maxGasPrice: NearToken,
  @SerialName("max_inflation_rate")
  public val maxInflationRate: List<Int>,
  @SerialName("max_kickout_stake_perc")
  public val maxKickoutStakePerc: Int,
  @SerialName("min_gas_price")
  public val minGasPrice: NearToken,
  @SerialName("minimum_stake_divisor")
  public val minimumStakeDivisor: Long,
  @SerialName("minimum_stake_ratio")
  public val minimumStakeRatio: List<Int>,
  @SerialName("minimum_validators_per_shard")
  public val minimumValidatorsPerShard: Long,
  @SerialName("num_block_producer_seats")
  public val numBlockProducerSeats: Long,
  @SerialName("num_block_producer_seats_per_shard")
  public val numBlockProducerSeatsPerShard: List<Long>,
  @SerialName("num_blocks_per_year")
  public val numBlocksPerYear: Long,
  @SerialName("online_max_threshold")
  public val onlineMaxThreshold: List<Int>,
  @SerialName("online_min_threshold")
  public val onlineMinThreshold: List<Int>,
  @SerialName("protocol_reward_rate")
  public val protocolRewardRate: List<Int>,
  @SerialName("protocol_treasury_account")
  public val protocolTreasuryAccount: AccountId,
  @SerialName("protocol_upgrade_stake_threshold")
  public val protocolUpgradeStakeThreshold: List<Int>,
  @SerialName("protocol_version")
  public val protocolVersion: Int,
  @SerialName("runtime_config")
  public val runtimeConfig: RuntimeConfigView,
  @SerialName("shard_layout")
  public val shardLayout: ShardLayout,
  @SerialName("shuffle_shard_assignment_for_chunk_producers")
  public val shuffleShardAssignmentForChunkProducers: Boolean,
  @SerialName("target_validator_mandates_per_shard")
  public val targetValidatorMandatesPerShard: Long,
  @SerialName("transaction_validity_period")
  public val transactionValidityPeriod: Long,
)
