package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.AccessKeyPermissionViewSerializer
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Describes the permission scope for an access key. Whether it is a function call or a full access key.
 */
@Serializable(with = AccessKeyPermissionViewSerializer::class)
public sealed class AccessKeyPermissionView {
  /**
   *  * Possible values: FullAccess
   */
  @Serializable
  @SerialName("FullAccess")
  public object FullAccess : AccessKeyPermissionView()

  @Serializable
  public data class FunctionCall(
    @SerialName("FunctionCall")
    public val functionCall: FunctionCallPayload,
  ) : AccessKeyPermissionView() {
    @Serializable
    public data class FunctionCallPayload(
      @SerialName("allowance")
      public val allowance: NearToken? = null,
      @SerialName("method_names")
      public val methodNames: List<String>,
      @SerialName("receiver_id")
      public val receiverId: String,
    )
  }
}
