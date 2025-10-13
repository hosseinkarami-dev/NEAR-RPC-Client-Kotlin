package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Describes the cost of creating an access key.
 */
@Serializable
public data class AccessKeyCreationConfigView(
  /**
   *  * Base cost of creating a full access access-key.
   */
  @SerialName("full_access_cost")
  public val fullAccessCost: Fee,
  /**
   *  * Base cost of creating an access-key restricted to specific functions.
   */
  @SerialName("function_call_cost")
  public val functionCallCost: Fee,
  /**
   *  * Cost per byte of method_names of creating a restricted access-key.
   */
  @SerialName("function_call_cost_per_byte")
  public val functionCallCostPerByte: Fee,
)
