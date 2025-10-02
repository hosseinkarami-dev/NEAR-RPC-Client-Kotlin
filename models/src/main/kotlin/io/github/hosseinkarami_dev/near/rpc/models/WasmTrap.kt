package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class WasmTrap {
  @Serializable
  @SerialName("Unreachable")
  public object Unreachable : WasmTrap()

  @Serializable
  @SerialName("IncorrectCallIndirectSignature")
  public object IncorrectCallIndirectSignature : WasmTrap()

  @Serializable
  @SerialName("MemoryOutOfBounds")
  public object MemoryOutOfBounds : WasmTrap()

  @Serializable
  @SerialName("CallIndirectOOB")
  public object CallIndirectOOB : WasmTrap()

  @Serializable
  @SerialName("IllegalArithmetic")
  public object IllegalArithmetic : WasmTrap()

  @Serializable
  @SerialName("MisalignedAtomicAccess")
  public object MisalignedAtomicAccess : WasmTrap()

  @Serializable
  @SerialName("IndirectCallToNull")
  public object IndirectCallToNull : WasmTrap()

  @Serializable
  @SerialName("StackOverflow")
  public object StackOverflow : WasmTrap()

  @Serializable
  @SerialName("GenericTrap")
  public object GenericTrap : WasmTrap()
}
