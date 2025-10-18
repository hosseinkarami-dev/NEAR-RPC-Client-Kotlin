package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.AccessKeyPermissionSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Defines permissions for AccessKey
 */
@Serializable(with = AccessKeyPermissionSerializer::class)
public sealed class AccessKeyPermission {
  @Serializable
  public data class FunctionCall(
    @SerialName("FunctionCall")
    public val functionCall: FunctionCallPermission,
  ) : AccessKeyPermission()

  /**
   *  * Grants full access to the account.
   * NOTE: It's used to replace account-level public keys.
   *  * Possible values: FullAccess
   */
  @Serializable
  @SerialName("FullAccess")
  public data object FullAccess : AccessKeyPermission()
}
