package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcValidatorErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = RpcValidatorErrorSerializer::class)
public sealed class RpcValidatorError {
  @Serializable
  public data class UnknownEpoch(
    /**
     *  * Possible values: UNKNOWN_EPOCH
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcValidatorError() {
    /**
     *  * Possible values: UNKNOWN_EPOCH
     */
    @Serializable
    public enum class Name {
      @SerialName("UNKNOWN_EPOCH")
      UNKNOWN_EPOCH,
    }
  }

  @Serializable
  public data class ValidatorInfoUnavailable(
    /**
     *  * Possible values: VALIDATOR_INFO_UNAVAILABLE
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcValidatorError() {
    /**
     *  * Possible values: VALIDATOR_INFO_UNAVAILABLE
     */
    @Serializable
    public enum class Name {
      @SerialName("VALIDATOR_INFO_UNAVAILABLE")
      VALIDATOR_INFO_UNAVAILABLE,
    }
  }

  @Serializable
  public data class InternalError(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: INTERNAL_ERROR
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcValidatorError() {
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
}
