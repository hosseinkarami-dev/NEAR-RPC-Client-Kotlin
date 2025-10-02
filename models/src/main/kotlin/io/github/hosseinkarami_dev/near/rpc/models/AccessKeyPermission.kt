package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class AccessKeyPermission {
  @Serializable
  public class FunctionCall(
    @SerialName("FunctionCall")
    public val functionCall: FunctionCallPermission,
  ) : AccessKeyPermission()

  @Serializable
  @SerialName("FullAccess")
  public object FullAccess : AccessKeyPermission()
}
