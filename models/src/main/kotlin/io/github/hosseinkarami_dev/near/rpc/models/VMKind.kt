package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.VMKindSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = VMKindSerializer::class)
public sealed class VMKind {
  /**
   *  * Wasmer 0.17.x VM. Gone now.
   *  * Possible values: Wasmer0
   */
  @Serializable
  @SerialName("Wasmer0")
  public data class Wasmer0(
    public val `value`: String = "Wasmer0",
  ) : VMKind()

  /**
   *  * Wasmtime VM.
   *  * Possible values: Wasmtime
   */
  @Serializable
  @SerialName("Wasmtime")
  public data class Wasmtime(
    public val `value`: String = "Wasmtime",
  ) : VMKind()

  /**
   *  * Wasmer 2.x VM.
   *  * Possible values: Wasmer2
   */
  @Serializable
  @SerialName("Wasmer2")
  public data class Wasmer2(
    public val `value`: String = "Wasmer2",
  ) : VMKind()

  /**
   *  * NearVM.
   *  * Possible values: NearVm
   */
  @Serializable
  @SerialName("NearVm")
  public data class NearVm(
    public val `value`: String = "NearVm",
  ) : VMKind()
}
