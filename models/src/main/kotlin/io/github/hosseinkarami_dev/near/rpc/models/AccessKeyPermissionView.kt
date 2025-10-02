package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class AccessKeyPermissionView {
  @Serializable
  @SerialName("FullAccess")
  public object FullAccess : AccessKeyPermissionView()

  @Serializable
  public class FunctionCall(
    @SerialName("FunctionCall")
    public val functionCall: FunctionCallPayload,
  ) : AccessKeyPermissionView() {
    @Serializable
    public data class FunctionCallPayload(
      @SerialName("allowance")
      public val allowance: NearToken?,
      @SerialName("method_names")
      public val methodNames: List<String>,
      @SerialName("receiver_id")
      public val receiverId: String,
    )
  }
}
