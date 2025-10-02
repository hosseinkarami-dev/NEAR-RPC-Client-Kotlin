package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class CostGasUsed(
  @SerialName("cost")
  public val cost: String,
  @SerialName("cost_category")
  public val costCategory: String,
  @SerialName("gas_used")
  public val gasUsed: String,
)
