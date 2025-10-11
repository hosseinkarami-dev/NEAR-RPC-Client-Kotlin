package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Resulting state values for a view state query request
 */
@Serializable
public data class ViewStateResult(
  @SerialName("proof")
  public val proof: List<String>? = null,
  @SerialName("values")
  public val values: List<StateItem>,
)
