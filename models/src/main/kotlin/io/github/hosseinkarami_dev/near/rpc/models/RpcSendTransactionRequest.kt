package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcSendTransactionRequest(
  @SerialName("signed_tx_base64")
  public val signedTxBase64: SignedTransaction,
  @SerialName("wait_until")
  public val waitUntil: TxExecutionStatus? = TxExecutionStatus.ExecutedOptimistic(),
)
