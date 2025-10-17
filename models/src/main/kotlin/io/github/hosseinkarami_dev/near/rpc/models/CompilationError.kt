package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.CompilationErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = CompilationErrorSerializer::class)
public sealed class CompilationError {
  @Serializable
  public data class CodeDoesNotExist(
    @SerialName("CodeDoesNotExist")
    public val codeDoesNotExist: CodeDoesNotExistPayload,
  ) : CompilationError() {
    @Serializable
    public data class CodeDoesNotExistPayload(
      @SerialName("account_id")
      public val accountId: AccountId,
    )
  }

  @Serializable
  public data class PrepareError(
    @SerialName("PrepareError")
    public val prepareError: io.github.hosseinkarami_dev.near.rpc.models.PrepareError,
  ) : CompilationError()

  /**
   *  * This is for defense in depth.
   * We expect our runtime-independent preparation code to fully catch all invalid wasms,
   * but, if it ever misses something we’ll emit this error
   */
  @Serializable
  public data class WasmerCompileError(
    @SerialName("WasmerCompileError")
    public val wasmerCompileError: WasmerCompileErrorPayload,
  ) : CompilationError() {
    @Serializable
    public data class WasmerCompileErrorPayload(
      @SerialName("msg")
      public val msg: String,
    )
  }
}
