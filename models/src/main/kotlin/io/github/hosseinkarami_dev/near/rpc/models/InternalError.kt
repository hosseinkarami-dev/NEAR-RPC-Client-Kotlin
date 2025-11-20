package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class InternalError(
  @SerialName("info")
  public val info: InfoPayload,
  /**
   *  * Possible values: INTERNAL_ERROR
   */
  @SerialName("name")
  public val name: Name,
) {
  @Serializable
  public data class InfoPayload(
    @SerialName("error_message")
    public val errorMessage: String,
  )

  /**
   *  * Possible values: INTERNAL_ERROR
   */
  @Serializable
  public enum class Name {
    @SerialName("INTERNAL_ERROR")
    INTERNAL_ERROR,
  }
}
