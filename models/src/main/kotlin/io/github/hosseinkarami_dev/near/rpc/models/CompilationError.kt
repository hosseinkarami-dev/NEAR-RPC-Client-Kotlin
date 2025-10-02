package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class CompilationError {
  @Serializable
  public class CodeDoesNotExist(
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
  public class PrepareError(
    @SerialName("PrepareError")
    public val prepareError: io.github.hosseinkarami_dev.near.rpc.models.PrepareError,
  ) : CompilationError()

  @Serializable
  public class WasmerCompileError(
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
