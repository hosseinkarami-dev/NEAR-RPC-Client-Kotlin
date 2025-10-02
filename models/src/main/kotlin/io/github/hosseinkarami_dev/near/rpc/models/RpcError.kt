package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
public sealed class RpcError {
  @Serializable
  public class RequestValidationError(
    @SerialName("cause")
    public val cause: RpcRequestValidationErrorKind,
    @SerialName("name")
    public val name: Name,
    @SerialName("code")
    public val code: Long,
    @SerialName("data")
    public val `data`: JsonElement?,
    @SerialName("message")
    public val message: String,
  ) : RpcError() {
    @Serializable
    public enum class Name {
      @SerialName("REQUEST_VALIDATION_ERROR")
      REQUEST_VALIDATION_ERROR,
    }
  }

  @Serializable
  public class HandlerError(
    @SerialName("cause")
    public val cause: JsonElement,
    @SerialName("name")
    public val name: Name,
    @SerialName("code")
    public val code: Long,
    @SerialName("data")
    public val `data`: JsonElement?,
    @SerialName("message")
    public val message: String,
  ) : RpcError() {
    @Serializable
    public enum class Name {
      @SerialName("HANDLER_ERROR")
      HANDLER_ERROR,
    }
  }

  @Serializable
  public class InternalError(
    @SerialName("cause")
    public val cause: JsonElement,
    @SerialName("name")
    public val name: Name,
    @SerialName("code")
    public val code: Long,
    @SerialName("data")
    public val `data`: JsonElement?,
    @SerialName("message")
    public val message: String,
  ) : RpcError() {
    @Serializable
    public enum class Name {
      @SerialName("INTERNAL_ERROR")
      INTERNAL_ERROR,
    }
  }
}
