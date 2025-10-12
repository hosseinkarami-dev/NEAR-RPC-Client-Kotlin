package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.FinalExecutionStatusSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = FinalExecutionStatusSerializer::class)
public sealed class FinalExecutionStatus {
  /**
   *  * The execution has not yet started.
   *  * Possible values: NotStarted
   */
  @Serializable
  @SerialName("NotStarted")
  public data class NotStarted(
    public val `value`: String = "NotStarted",
  ) : FinalExecutionStatus()

  /**
   *  * The execution has started and still going.
   *  * Possible values: Started
   */
  @Serializable
  @SerialName("Started")
  public data class Started(
    public val `value`: String = "Started",
  ) : FinalExecutionStatus()

  /**
   *  * The execution has failed with the given error.
   */
  @Serializable
  public data class Failure(
    @SerialName("Failure")
    public val failure: TxExecutionError,
  ) : FinalExecutionStatus()

  /**
   *  * The execution has succeeded and returned some value or an empty vec encoded in base64.
   */
  @Serializable
  public data class SuccessValue(
    @SerialName("SuccessValue")
    public val successValue: String,
  ) : FinalExecutionStatus()
}
