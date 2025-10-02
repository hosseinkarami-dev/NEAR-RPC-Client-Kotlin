package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Defines permissions for AccessKey
 */
@Serializable
public sealed class AccessKeyPermission {
  @Serializable
  public class FunctionCall(
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
  public object FullAccess : AccessKeyPermission()
}
