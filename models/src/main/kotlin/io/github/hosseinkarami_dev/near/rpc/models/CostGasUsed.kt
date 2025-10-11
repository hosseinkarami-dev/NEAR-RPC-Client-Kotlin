package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Shows gas profile. More info [here](https://near.github.io/nearcore/architecture/gas/gas_profile.html?highlight=WASM_HOST_COST#example-transaction-gas-profile).
 */
@Serializable
public data class CostGasUsed(
  @SerialName("cost")
  public val cost: String,
  /**
   *  * Either ACTION_COST or WASM_HOST_COST.
   */
  @SerialName("cost_category")
  public val costCategory: String,
  @SerialName("gas_used")
  public val gasUsed: String,
)
