package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class RpcLightClientExecutionProofRequest {
  @Serializable
  public class Transaction(
    @SerialName("sender_id")
    public val senderId: AccountId,
    @SerialName("transaction_hash")
    public val transactionHash: CryptoHash,
    @SerialName("type")
    public val type: Type,
    @SerialName("light_client_head")
    public val lightClientHead: CryptoHash,
  ) : RpcLightClientExecutionProofRequest() {
    @Serializable
    public enum class Type {
      @SerialName("transaction")
      TRANSACTION,
    }
  }

  @Serializable
  public class Receipt(
    @SerialName("receipt_id")
    public val receiptId: CryptoHash,
    @SerialName("receiver_id")
    public val receiverId: AccountId,
    @SerialName("type")
    public val type: Type,
    @SerialName("light_client_head")
    public val lightClientHead: CryptoHash,
  ) : RpcLightClientExecutionProofRequest() {
    @Serializable
    public enum class Type {
      @SerialName("receipt")
      RECEIPT,
    }
  }
}
