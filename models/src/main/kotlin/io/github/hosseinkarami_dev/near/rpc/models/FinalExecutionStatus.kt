package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class FinalExecutionStatus {
  /**
   *  * The execution has not yet started.
   *  * Possible values: NotStarted
   */
  @Serializable
  @SerialName("NotStarted")
  public object NotStarted : FinalExecutionStatus()

  /**
   *  * The execution has started and still going.
   *  * Possible values: Started
   */
  @Serializable
  @SerialName("Started")
  public object Started : FinalExecutionStatus()

  /**
   *  * The execution has failed with the given error.
   */
  @Serializable
  public class Failure(
    @SerialName("Failure")
    public val failure: TxExecutionError,
  ) : FinalExecutionStatus()

  /**
   *  * The execution has succeeded and returned some value or an empty vec encoded in base64.
   */
  @Serializable
  public class SuccessValue(
    @SerialName("SuccessValue")
    public val successValue: String,
  ) : FinalExecutionStatus()
}
