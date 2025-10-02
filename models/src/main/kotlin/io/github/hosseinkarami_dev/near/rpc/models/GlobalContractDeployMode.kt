package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class GlobalContractDeployMode {
  @Serializable
  @SerialName("CodeHash")
  public object CodeHash : GlobalContractDeployMode()

  @Serializable
  @SerialName("AccountId")
  public object AccountId : GlobalContractDeployMode()
}
