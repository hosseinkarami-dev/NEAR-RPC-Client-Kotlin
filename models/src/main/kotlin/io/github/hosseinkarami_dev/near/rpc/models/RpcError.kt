package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 *  * This struct may be returned from JSON RPC server in case of error
 * It is expected that this struct has impl From<_> all other RPC errors
 * like [RpcBlockError](crate::types::blocks::RpcBlockError)
 */
@Serializable
public sealed class RpcError {
  @Serializable
  public class RequestValidationError(
    @SerialName("cause")
    public val cause: RpcRequestValidationErrorKind,
    /**
     *  * Possible values: REQUEST_VALIDATION_ERROR
     */
    @SerialName("name")
    public val name: Name,
    /**
     *  * Deprecated please use the `error_struct` instead
     *  * Format: int64
     */
    @SerialName("code")
    public val code: Long,
    /**
     *  * Deprecated please use the `error_struct` instead
     */
    @SerialName("data")
    public val `data`: JsonElement?,
    /**
     *  * Deprecated please use the `error_struct` instead
     */
    @SerialName("message")
    public val message: String,
  ) : RpcError() {
    /**
     *  * Possible values: REQUEST_VALIDATION_ERROR
     */
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
    /**
     *  * Possible values: HANDLER_ERROR
     */
    @SerialName("name")
    public val name: Name,
    /**
     *  * Deprecated please use the `error_struct` instead
     *  * Format: int64
     */
    @SerialName("code")
    public val code: Long,
    /**
     *  * Deprecated please use the `error_struct` instead
     */
    @SerialName("data")
    public val `data`: JsonElement?,
    /**
     *  * Deprecated please use the `error_struct` instead
     */
    @SerialName("message")
    public val message: String,
  ) : RpcError() {
    /**
     *  * Possible values: HANDLER_ERROR
     */
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
    /**
     *  * Possible values: INTERNAL_ERROR
     */
    @SerialName("name")
    public val name: Name,
    /**
     *  * Deprecated please use the `error_struct` instead
     *  * Format: int64
     */
    @SerialName("code")
    public val code: Long,
    /**
     *  * Deprecated please use the `error_struct` instead
     */
    @SerialName("data")
    public val `data`: JsonElement?,
    /**
     *  * Deprecated please use the `error_struct` instead
     */
    @SerialName("message")
    public val message: String,
  ) : RpcError() {
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
