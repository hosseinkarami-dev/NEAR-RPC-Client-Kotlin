package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class RpcRequestValidationErrorKind {
  @Serializable
  public class MethodNotFound(
    @SerialName("info")
    public val info: InfoPayload,
    @SerialName("name")
    public val name: Name,
  ) : RpcRequestValidationErrorKind() {
    @Serializable
    public data class InfoPayload(
      @SerialName("method_name")
      public val methodName: String,
    )

    @Serializable
    public enum class Name {
      @SerialName("METHOD_NOT_FOUND")
      METHOD_NOT_FOUND,
    }
  }

  @Serializable
  public class ParseError(
    @SerialName("info")
    public val info: InfoPayload,
    @SerialName("name")
    public val name: Name,
  ) : RpcRequestValidationErrorKind() {
    @Serializable
    public data class InfoPayload(
      @SerialName("error_message")
      public val errorMessage: String,
    )

    @Serializable
    public enum class Name {
      @SerialName("PARSE_ERROR")
      PARSE_ERROR,
    }
  }
}
