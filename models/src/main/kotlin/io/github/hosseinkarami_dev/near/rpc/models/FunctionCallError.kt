package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.FunctionCallErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Serializable version of `near-vm-runner::FunctionCallError`.
 *
 * Must never reorder/remove elements, can only add new variants at the end (but do that very
 * carefully). It describes stable serialization format, and only used by serialization logic.
 */
@Serializable(with = FunctionCallErrorSerializer::class)
public sealed class FunctionCallError {
  /**
   *  * Possible values: WasmUnknownError, _EVMError
   */
  @Serializable
  @SerialName("WasmUnknownError")
  public data class WasmUnknownError(
    public val `value`: String = "WasmUnknownError",
  ) : FunctionCallError()

  /**
   *  * Possible values: WasmUnknownError, _EVMError
   */
  @Serializable
  @SerialName("_EVMError")
  public data class EVMError(
    public val `value`: String = "_EVMError",
  ) : FunctionCallError()

  /**
   *  * Wasm compilation error
   */
  @Serializable
  public data class CompilationError(
    @SerialName("CompilationError")
    public val compilationError: io.github.hosseinkarami_dev.near.rpc.models.CompilationError,
  ) : FunctionCallError()

  /**
   *  * Wasm binary env link error
   *
   * Note: this is only to deserialize old data, use execution error for new data
   */
  @Serializable
  public data class LinkError(
    @SerialName("LinkError")
    public val linkError: LinkErrorPayload,
  ) : FunctionCallError() {
    @Serializable
    public data class LinkErrorPayload(
      @SerialName("msg")
      public val msg: String,
    )
  }

  /**
   *  * Import/export resolve error
   */
  @Serializable
  public data class MethodResolveError(
    @SerialName("MethodResolveError")
    public val methodResolveError: io.github.hosseinkarami_dev.near.rpc.models.MethodResolveError,
  ) : FunctionCallError()

  /**
   *  * A trap happened during execution of a binary
   *
   * Note: this is only to deserialize old data, use execution error for new data
   */
  @Serializable
  public data class WasmTrap(
    @SerialName("WasmTrap")
    public val wasmTrap: io.github.hosseinkarami_dev.near.rpc.models.WasmTrap,
  ) : FunctionCallError()

  /**
   *  * Note: this is only to deserialize old data, use execution error for new data
   */
  @Serializable
  public data class HostError(
    @SerialName("HostError")
    public val hostError: io.github.hosseinkarami_dev.near.rpc.models.HostError,
  ) : FunctionCallError()

  @Serializable
  public data class ExecutionError(
    @SerialName("ExecutionError")
    public val executionError: String,
  ) : FunctionCallError()
}
