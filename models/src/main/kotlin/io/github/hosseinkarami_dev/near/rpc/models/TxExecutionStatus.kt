package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.TxExecutionStatusSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = TxExecutionStatusSerializer::class)
public sealed class TxExecutionStatus {
  /**
   *  * Transaction is waiting to be included into the block
   *  * Possible values: NONE
   */
  @Serializable
  @SerialName("NONE")
  public data object None : TxExecutionStatus()

  /**
   *  * Transaction is included into the block. The block may be not finalized yet
   *  * Possible values: INCLUDED
   */
  @Serializable
  @SerialName("INCLUDED")
  public data object Included : TxExecutionStatus()

  /**
   *  * Transaction is included into the block +
   * All non-refund transaction receipts finished their execution.
   * The corresponding blocks for tx and each receipt may be not finalized yet
   *  * Possible values: EXECUTED_OPTIMISTIC
   */
  @Serializable
  @SerialName("EXECUTED_OPTIMISTIC")
  public data object ExecutedOptimistic : TxExecutionStatus()

  /**
   *  * Transaction is included into finalized block
   *  * Possible values: INCLUDED_FINAL
   */
  @Serializable
  @SerialName("INCLUDED_FINAL")
  public data object IncludedFinal : TxExecutionStatus()

  /**
   *  * Transaction is included into finalized block +
   * All non-refund transaction receipts finished their execution.
   * The corresponding blocks for each receipt may be not finalized yet
   *  * Possible values: EXECUTED
   */
  @Serializable
  @SerialName("EXECUTED")
  public data object Executed : TxExecutionStatus()

  /**
   *  * Transaction is included into finalized block +
   * Execution of all transaction receipts is finalized, including refund receipts
   *  * Possible values: FINAL
   */
  @Serializable
  @SerialName("FINAL")
  public data object Final : TxExecutionStatus()
}
