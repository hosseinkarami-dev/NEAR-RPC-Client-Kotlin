package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class ExecutionStatusView {
  @Serializable
  @SerialName("Unknown")
  public object Unknown : ExecutionStatusView()

  @Serializable
  public class Failure(
    @SerialName("Failure")
    public val failure: TxExecutionError,
  ) : ExecutionStatusView()

  @Serializable
  public class SuccessValue(
    @SerialName("SuccessValue")
    public val successValue: String,
  ) : ExecutionStatusView()

  @Serializable
  public class SuccessReceiptId(
    @SerialName("SuccessReceiptId")
    public val successReceiptId: CryptoHash,
  ) : ExecutionStatusView()
}
