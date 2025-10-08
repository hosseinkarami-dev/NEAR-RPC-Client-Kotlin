package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.WasmTrapSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * A kind of a trap happened during execution of a binary
 */
@Serializable(with = WasmTrapSerializer::class)
public sealed class WasmTrap {
  /**
   *  * An `unreachable` opcode was executed.
   *  * Possible values: Unreachable
   */
  @Serializable
  @SerialName("Unreachable")
  public object Unreachable : WasmTrap()

  /**
   *  * Call indirect incorrect signature trap.
   *  * Possible values: IncorrectCallIndirectSignature
   */
  @Serializable
  @SerialName("IncorrectCallIndirectSignature")
  public object IncorrectCallIndirectSignature : WasmTrap()

  /**
   *  * Memory out of bounds trap.
   *  * Possible values: MemoryOutOfBounds
   */
  @Serializable
  @SerialName("MemoryOutOfBounds")
  public object MemoryOutOfBounds : WasmTrap()

  /**
   *  * Call indirect out of bounds trap.
   *  * Possible values: CallIndirectOOB
   */
  @Serializable
  @SerialName("CallIndirectOOB")
  public object CallIndirectOOB : WasmTrap()

  /**
   *  * An arithmetic exception, e.g. divided by zero.
   *  * Possible values: IllegalArithmetic
   */
  @Serializable
  @SerialName("IllegalArithmetic")
  public object IllegalArithmetic : WasmTrap()

  /**
   *  * Misaligned atomic access trap.
   *  * Possible values: MisalignedAtomicAccess
   */
  @Serializable
  @SerialName("MisalignedAtomicAccess")
  public object MisalignedAtomicAccess : WasmTrap()

  /**
   *  * Indirect call to null.
   *  * Possible values: IndirectCallToNull
   */
  @Serializable
  @SerialName("IndirectCallToNull")
  public object IndirectCallToNull : WasmTrap()

  /**
   *  * Stack overflow.
   *  * Possible values: StackOverflow
   */
  @Serializable
  @SerialName("StackOverflow")
  public object StackOverflow : WasmTrap()

  /**
   *  * Generic trap.
   *  * Possible values: GenericTrap
   */
  @Serializable
  @SerialName("GenericTrap")
  public object GenericTrap : WasmTrap()
}
