package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * A result returned by contract method
 */
@Serializable
public data class CallResult(
  @SerialName("logs")
  public val logs: List<String>,
  @SerialName("result")
  public val result: List<Int>,
)
