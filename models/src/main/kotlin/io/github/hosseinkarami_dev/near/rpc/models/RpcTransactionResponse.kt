package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class RpcTransactionResponse {
  @Serializable
  public class FinalExecutionOutcomeWithReceiptView(
    @SerialName("receipts")
    public val receipts: List<ReceiptView>,
    @SerialName("receipts_outcome")
    public val receiptsOutcome: List<ExecutionOutcomeWithIdView>,
    @SerialName("status")
    public val status: FinalExecutionStatus,
    @SerialName("transaction")
    public val transaction: SignedTransactionView,
    @SerialName("transaction_outcome")
    public val transactionOutcome: ExecutionOutcomeWithIdView,
    @SerialName("final_execution_status")
    public val finalExecutionStatus: TxExecutionStatus,
  ) : RpcTransactionResponse()

  @Serializable
  public class FinalExecutionOutcomeView(
    @SerialName("receipts_outcome")
    public val receiptsOutcome: List<ExecutionOutcomeWithIdView>,
    @SerialName("status")
    public val status: FinalExecutionStatus,
    @SerialName("transaction")
    public val transaction: SignedTransactionView,
    @SerialName("transaction_outcome")
    public val transactionOutcome: ExecutionOutcomeWithIdView,
    @SerialName("final_execution_status")
    public val finalExecutionStatus: TxExecutionStatus,
  ) : RpcTransactionResponse()
}
