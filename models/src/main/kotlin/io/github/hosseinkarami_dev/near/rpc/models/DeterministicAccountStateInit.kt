package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class DeterministicAccountStateInit(
  @SerialName("V1")
  public val v1: DeterministicAccountStateInitV1,
)
