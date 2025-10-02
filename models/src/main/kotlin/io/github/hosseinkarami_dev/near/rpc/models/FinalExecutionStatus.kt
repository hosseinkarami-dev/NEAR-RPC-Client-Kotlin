package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class FinalExecutionStatus {
  @Serializable
  @SerialName("NotStarted")
  public object NotStarted : FinalExecutionStatus()

  @Serializable
  @SerialName("Started")
  public object Started : FinalExecutionStatus()

  @Serializable
  public class Failure(
    @SerialName("Failure")
    public val failure: TxExecutionError,
  ) : FinalExecutionStatus()

  @Serializable
  public class SuccessValue(
    @SerialName("SuccessValue")
    public val successValue: String,
  ) : FinalExecutionStatus()
}
