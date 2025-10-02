package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class DeployGlobalContractAction(
  @SerialName("code")
  public val code: String,
  @SerialName("deploy_mode")
  public val deployMode: GlobalContractDeployMode,
)
