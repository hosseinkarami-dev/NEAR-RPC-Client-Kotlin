package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcRequestValidationErrorKindSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = RpcRequestValidationErrorKindSerializer::class)
public sealed class RpcRequestValidationErrorKind {
  @Serializable
  public data class MethodNotFound(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: METHOD_NOT_FOUND
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcRequestValidationErrorKind() {
    @Serializable
    public data class InfoPayload(
      @SerialName("method_name")
      public val methodName: String,
    )

    /**
     *  * Possible values: METHOD_NOT_FOUND
     */
    @Serializable
    public enum class Name {
      @SerialName("METHOD_NOT_FOUND")
      METHOD_NOT_FOUND,
    }
  }

  @Serializable
  public data class ParseError(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: PARSE_ERROR
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcRequestValidationErrorKind() {
    @Serializable
    public data class InfoPayload(
      @SerialName("error_message")
      public val errorMessage: String,
    )

    /**
     *  * Possible values: PARSE_ERROR
     */
    @Serializable
    public enum class Name {
      @SerialName("PARSE_ERROR")
      PARSE_ERROR,
    }
  }
}
