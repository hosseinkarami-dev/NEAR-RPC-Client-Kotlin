package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Execution outcome of the transaction and all the subsequent receipts.
 * Could be not finalized yet
 */
@Serializable
public data class FinalExecutionOutcomeView(
  /**
   *  * The execution outcome of receipts.
   */
  @SerialName("receipts_outcome")
  public val receiptsOutcome: List<ExecutionOutcomeWithIdView>,
  /**
   *  * Execution status defined by chain.rs:get_final_transaction_result
   * FinalExecutionStatus::NotStarted - the tx is not converted to the receipt yet
   * FinalExecutionStatus::Started - we have at least 1 receipt, but the first leaf receipt_id (using dfs) hasn't finished the execution
   * FinalExecutionStatus::Failure - the result of the first leaf receipt_id
   * FinalExecutionStatus::SuccessValue - the result of the first leaf receipt_id
   */
  @SerialName("status")
  public val status: FinalExecutionStatus,
  /**
   *  * Signed Transaction
   */
  @SerialName("transaction")
  public val transaction: SignedTransactionView,
  /**
   *  * The execution outcome of the signed transaction.
   */
  @SerialName("transaction_outcome")
  public val transactionOutcome: ExecutionOutcomeWithIdView,
)
