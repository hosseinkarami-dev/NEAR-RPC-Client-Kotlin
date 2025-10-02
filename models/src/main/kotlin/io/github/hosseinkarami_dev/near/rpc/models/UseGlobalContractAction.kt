package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class UseGlobalContractAction(
  @SerialName("contract_identifier")
  public val contractIdentifier: GlobalContractIdentifier,
)
