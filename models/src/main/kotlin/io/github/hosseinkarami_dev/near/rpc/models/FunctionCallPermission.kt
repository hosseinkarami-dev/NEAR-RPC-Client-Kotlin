package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Grants limited permission to make transactions with FunctionCallActions
 * The permission can limit the allowed balance to be spent on the prepaid gas.
 * It also restrict the account ID of the receiver for this function call.
 * It also can restrict the method name for the allowed function calls.
 */
@Serializable
public data class FunctionCallPermission(
  /**
   *  * Allowance is a balance limit to use by this access key to pay for function call gas and
   * transaction fees. When this access key is used, both account balance and the allowance is
   * decreased by the same value.
   * `None` means unlimited allowance.
   * NOTE: To change or increase the allowance, the old access key needs to be deleted and a new
   * access key should be created.
   */
  @SerialName("allowance")
  public val allowance: NearToken? = null,
  /**
   *  * A list of method names that can be used. The access key only allows transactions with the
   * function call of one of the given method names.
   * Empty list means any method name can be used.
   */
  @SerialName("method_names")
  public val methodNames: List<String>,
  /**
   *  * The access key only allows transactions with the given receiver's account id.
   */
  @SerialName("receiver_id")
  public val receiverId: String,
)
