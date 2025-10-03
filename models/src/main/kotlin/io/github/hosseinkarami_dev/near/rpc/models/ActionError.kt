package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * An error happened during Action execution
 */
@Serializable
public data class ActionError(
  /**
   *  * Index of the failed action in the transaction.
   * Action index is not defined if ActionError.kind is `ActionErrorKind::LackBalanceForState`
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("index")
  public val index: Long? = null,
  /**
   *  * The kind of ActionError happened
   */
  @SerialName("kind")
  public val kind: ActionErrorKind,
)
