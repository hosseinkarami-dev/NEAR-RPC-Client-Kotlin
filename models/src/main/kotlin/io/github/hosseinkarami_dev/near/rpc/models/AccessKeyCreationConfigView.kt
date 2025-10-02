package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class AccessKeyCreationConfigView(
  @SerialName("full_access_cost")
  public val fullAccessCost: Fee,
  @SerialName("function_call_cost")
  public val functionCallCost: Fee,
  @SerialName("function_call_cost_per_byte")
  public val functionCallCostPerByte: Fee,
)
