package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class DataReceiptCreationConfigView(
  @SerialName("base_cost")
  public val baseCost: Fee,
  @SerialName("cost_per_byte")
  public val costPerByte: Fee,
)
