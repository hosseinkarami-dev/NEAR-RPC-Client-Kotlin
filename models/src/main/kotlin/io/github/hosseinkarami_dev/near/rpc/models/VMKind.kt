package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class VMKind {
  @Serializable
  @SerialName("Wasmer0")
  public object Wasmer0 : VMKind()

  @Serializable
  @SerialName("Wasmtime")
  public object Wasmtime : VMKind()

  @Serializable
  @SerialName("Wasmer2")
  public object Wasmer2 : VMKind()

  @Serializable
  @SerialName("NearVm")
  public object NearVm : VMKind()
}
