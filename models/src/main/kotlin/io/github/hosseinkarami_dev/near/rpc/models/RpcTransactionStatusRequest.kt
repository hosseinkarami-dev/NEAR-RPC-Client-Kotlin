package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class RpcTransactionStatusRequest {
  @Serializable
  public data class SignedTxBase64(
    @SerialName("signed_tx_base64")
    public val signedTxBase64: SignedTransaction,
    @SerialName("wait_until")
    public val waitUntil: TxExecutionStatus? = TxExecutionStatus.ExecutedOptimistic,
  ) : RpcTransactionStatusRequest()

  @Serializable
  public data class SenderAccountId(
    @SerialName("sender_account_id")
    public val senderAccountId: AccountId,
    @SerialName("tx_hash")
    public val txHash: CryptoHash,
    @SerialName("wait_until")
    public val waitUntil: TxExecutionStatus? = TxExecutionStatus.ExecutedOptimistic,
  ) : RpcTransactionStatusRequest()
}
