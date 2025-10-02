package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Describes different fees for the runtime
 */
@Serializable
public data class RuntimeFeesConfigView(
  /**
   *  * Describes the cost of creating a certain action, `Action`. Includes all variants.
   */
  @SerialName("action_creation_config")
  public val actionCreationConfig: ActionCreationConfigView,
  /**
   *  * Describes the cost of creating an action receipt, `ActionReceipt`, excluding the actual cost
   * of actions.
   * - `send` cost is burned when a receipt is created using `promise_create` or
   *     `promise_batch_create`
   * - `exec` cost is burned when the receipt is being executed.
   */
  @SerialName("action_receipt_creation_config")
  public val actionReceiptCreationConfig: Fee,
  /**
   *  * Fraction of the burnt gas to reward to the contract account for execution.
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("burnt_gas_reward")
  public val burntGasReward: List<Int>,
  /**
   *  * Describes the cost of creating a data receipt, `DataReceipt`.
   */
  @SerialName("data_receipt_creation_config")
  public val dataReceiptCreationConfig: DataReceiptCreationConfigView,
  /**
   *  * Pessimistic gas price inflation ratio.
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("pessimistic_gas_price_inflation_ratio")
  public val pessimisticGasPriceInflationRatio: List<Int>,
  /**
   *  * Describes fees for storage.
   */
  @SerialName("storage_usage_config")
  public val storageUsageConfig: StorageUsageConfigView,
)
