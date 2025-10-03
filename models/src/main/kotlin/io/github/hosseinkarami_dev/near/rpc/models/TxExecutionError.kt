package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Error returned in the ExecutionOutcome in case of failure
 */
@Serializable
public sealed class TxExecutionError {
  /**
   *  * An error happened during Action execution
   */
  @Serializable
  public data class ActionError(
    @SerialName("ActionError")
    public val actionError: io.github.hosseinkarami_dev.near.rpc.models.ActionError,
  ) : TxExecutionError()

  /**
   *  * An error happened during Transaction execution
   */
  @Serializable
  public data class InvalidTxError(
    @SerialName("InvalidTxError")
    public val invalidTxError: io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError,
  ) : TxExecutionError()
}
