package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcGasPriceResponse(
  @SerialName("gas_price")
  public val gasPrice: NearToken,
)
