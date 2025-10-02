package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class DurationAsStdSchemaProvider(
  @SerialName("nanos")
  public val nanos: Int,
  @SerialName("secs")
  public val secs: Long,
)
