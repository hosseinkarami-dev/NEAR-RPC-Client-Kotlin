package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class FunctionCallError {
  @Serializable
  @SerialName("WasmUnknownError")
  public object WasmUnknownError : FunctionCallError()

  @Serializable
  @SerialName("_EVMError")
  public object EVMError : FunctionCallError()

  @Serializable
  public class CompilationError(
    @SerialName("CompilationError")
    public val compilationError: io.github.hosseinkarami_dev.near.rpc.models.CompilationError,
  ) : FunctionCallError()

  @Serializable
  public class LinkError(
    @SerialName("LinkError")
    public val linkError: LinkErrorPayload,
  ) : FunctionCallError() {
    @Serializable
    public data class LinkErrorPayload(
      @SerialName("msg")
      public val msg: String,
    )
  }

  @Serializable
  public class MethodResolveError(
    @SerialName("MethodResolveError")
    public val methodResolveError: io.github.hosseinkarami_dev.near.rpc.models.MethodResolveError,
  ) : FunctionCallError()

  @Serializable
  public class WasmTrap(
    @SerialName("WasmTrap")
    public val wasmTrap: io.github.hosseinkarami_dev.near.rpc.models.WasmTrap,
  ) : FunctionCallError()

  @Serializable
  public class HostError(
    @SerialName("HostError")
    public val hostError: io.github.hosseinkarami_dev.near.rpc.models.HostError,
  ) : FunctionCallError()

  @Serializable
  public class ExecutionError(
    @SerialName("ExecutionError")
    public val executionError: String,
  ) : FunctionCallError()
}
