package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RuntimeFeesConfigView(
  @SerialName("action_creation_config")
  public val actionCreationConfig: ActionCreationConfigView,
  @SerialName("action_receipt_creation_config")
  public val actionReceiptCreationConfig: Fee,
  @SerialName("burnt_gas_reward")
  public val burntGasReward: List<Int>,
  @SerialName("data_receipt_creation_config")
  public val dataReceiptCreationConfig: DataReceiptCreationConfigView,
  @SerialName("pessimistic_gas_price_inflation_ratio")
  public val pessimisticGasPriceInflationRatio: List<Int>,
  @SerialName("storage_usage_config")
  public val storageUsageConfig: StorageUsageConfigView,
)
