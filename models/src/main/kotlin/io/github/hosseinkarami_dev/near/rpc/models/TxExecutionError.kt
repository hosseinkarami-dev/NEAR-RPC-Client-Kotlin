package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class TxExecutionError {
  @Serializable
  public class ActionError(
    @SerialName("ActionError")
    public val actionError: io.github.hosseinkarami_dev.near.rpc.models.ActionError,
  ) : TxExecutionError()

  @Serializable
  public class InvalidTxError(
    @SerialName("InvalidTxError")
    public val invalidTxError: io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError,
  ) : TxExecutionError()
}
