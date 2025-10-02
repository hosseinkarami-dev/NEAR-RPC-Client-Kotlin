package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ActionError(
  @SerialName("index")
  public val index: Long?,
  @SerialName("kind")
  public val kind: ActionErrorKind,
)
