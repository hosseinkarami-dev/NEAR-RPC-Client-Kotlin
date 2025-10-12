package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.WasmTrapSerializer
import kotlin.String
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
  public data class Unreachable(
    public val `value`: String = "Unreachable",
  ) : WasmTrap()

  /**
   *  * Call indirect incorrect signature trap.
   *  * Possible values: IncorrectCallIndirectSignature
   */
  @Serializable
  @SerialName("IncorrectCallIndirectSignature")
  public data class IncorrectCallIndirectSignature(
    public val `value`: String = "IncorrectCallIndirectSignature",
  ) : WasmTrap()

  /**
   *  * Memory out of bounds trap.
   *  * Possible values: MemoryOutOfBounds
   */
  @Serializable
  @SerialName("MemoryOutOfBounds")
  public data class MemoryOutOfBounds(
    public val `value`: String = "MemoryOutOfBounds",
  ) : WasmTrap()

  /**
   *  * Call indirect out of bounds trap.
   *  * Possible values: CallIndirectOOB
   */
  @Serializable
  @SerialName("CallIndirectOOB")
  public data class CallIndirectOOB(
    public val `value`: String = "CallIndirectOOB",
  ) : WasmTrap()

  /**
   *  * An arithmetic exception, e.g. divided by zero.
   *  * Possible values: IllegalArithmetic
   */
  @Serializable
  @SerialName("IllegalArithmetic")
  public data class IllegalArithmetic(
    public val `value`: String = "IllegalArithmetic",
  ) : WasmTrap()

  /**
   *  * Misaligned atomic access trap.
   *  * Possible values: MisalignedAtomicAccess
   */
  @Serializable
  @SerialName("MisalignedAtomicAccess")
  public data class MisalignedAtomicAccess(
    public val `value`: String = "MisalignedAtomicAccess",
  ) : WasmTrap()

  /**
   *  * Indirect call to null.
   *  * Possible values: IndirectCallToNull
   */
  @Serializable
  @SerialName("IndirectCallToNull")
  public data class IndirectCallToNull(
    public val `value`: String = "IndirectCallToNull",
  ) : WasmTrap()

  /**
   *  * Stack overflow.
   *  * Possible values: StackOverflow
   */
  @Serializable
  @SerialName("StackOverflow")
  public data class StackOverflow(
    public val `value`: String = "StackOverflow",
  ) : WasmTrap()

  /**
   *  * Generic trap.
   *  * Possible values: GenericTrap
   */
  @Serializable
  @SerialName("GenericTrap")
  public data class GenericTrap(
    public val `value`: String = "GenericTrap",
  ) : WasmTrap()
}
