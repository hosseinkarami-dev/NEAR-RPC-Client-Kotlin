package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.TxExecutionStatusSerializer
import kotlin.String
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
  public data class None(
    public val `value`: String = "NONE",
  ) : TxExecutionStatus()

  /**
   *  * Transaction is included into the block. The block may be not finalized yet
   *  * Possible values: INCLUDED
   */
  @Serializable
  @SerialName("INCLUDED")
  public data class Included(
    public val `value`: String = "INCLUDED",
  ) : TxExecutionStatus()

  /**
   *  * Transaction is included into the block +
   * All non-refund transaction receipts finished their execution.
   * The corresponding blocks for tx and each receipt may be not finalized yet
   *  * Possible values: EXECUTED_OPTIMISTIC
   */
  @Serializable
  @SerialName("EXECUTED_OPTIMISTIC")
  public data class ExecutedOptimistic(
    public val `value`: String = "EXECUTED_OPTIMISTIC",
  ) : TxExecutionStatus()

  /**
   *  * Transaction is included into finalized block
   *  * Possible values: INCLUDED_FINAL
   */
  @Serializable
  @SerialName("INCLUDED_FINAL")
  public data class IncludedFinal(
    public val `value`: String = "INCLUDED_FINAL",
  ) : TxExecutionStatus()

  /**
   *  * Transaction is included into finalized block +
   * All non-refund transaction receipts finished their execution.
   * The corresponding blocks for each receipt may be not finalized yet
   *  * Possible values: EXECUTED
   */
  @Serializable
  @SerialName("EXECUTED")
  public data class Executed(
    public val `value`: String = "EXECUTED",
  ) : TxExecutionStatus()

  /**
   *  * Transaction is included into finalized block +
   * Execution of all transaction receipts is finalized, including refund receipts
   *  * Possible values: FINAL
   */
  @Serializable
  @SerialName("FINAL")
  public data class Final(
    public val `value`: String = "FINAL",
  ) : TxExecutionStatus()
}
