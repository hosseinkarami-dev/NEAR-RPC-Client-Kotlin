package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Fee(
  @SerialName("execution")
  public val execution: NearGas,
  @SerialName("send_not_sir")
  public val sendNotSir: NearGas,
  @SerialName("send_sir")
  public val sendSir: NearGas,
)
