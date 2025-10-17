package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcReceiptRequest(
  @SerialName("receipt_id")
  public val receiptId: CryptoHash,
)
