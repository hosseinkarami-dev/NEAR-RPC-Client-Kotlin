package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class VMKind {
  /**
   *  * Wasmer 0.17.x VM. Gone now.
   *  * Possible values: Wasmer0
   */
  @Serializable
  @SerialName("Wasmer0")
  public object Wasmer0 : VMKind()

  /**
   *  * Wasmtime VM.
   *  * Possible values: Wasmtime
   */
  @Serializable
  @SerialName("Wasmtime")
  public object Wasmtime : VMKind()

  /**
   *  * Wasmer 2.x VM.
   *  * Possible values: Wasmer2
   */
  @Serializable
  @SerialName("Wasmer2")
  public object Wasmer2 : VMKind()

  /**
   *  * NearVM.
   *  * Possible values: NearVm
   */
  @Serializable
  @SerialName("NearVm")
  public object NearVm : VMKind()
}
