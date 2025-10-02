package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
public data class DeterministicAccountStateInitV1(
  @SerialName("code")
  public val code: GlobalContractIdentifier,
  @SerialName("data")
  public val `data`: JsonElement,
)
