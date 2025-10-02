package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class TxExecutionStatus {
  @Serializable
  @SerialName("NONE")
  public object None : TxExecutionStatus()

  @Serializable
  @SerialName("INCLUDED")
  public object Included : TxExecutionStatus()

  @Serializable
  @SerialName("EXECUTED_OPTIMISTIC")
  public object ExecutedOptimistic : TxExecutionStatus()

  @Serializable
  @SerialName("INCLUDED_FINAL")
  public object IncludedFinal : TxExecutionStatus()

  @Serializable
  @SerialName("EXECUTED")
  public object Executed : TxExecutionStatus()

  @Serializable
  @SerialName("FINAL")
  public object Final : TxExecutionStatus()
}
