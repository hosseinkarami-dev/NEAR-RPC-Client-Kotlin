package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.PrepareErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Error that can occur while preparing or executing Wasm smart-contract.
 */
@Serializable(with = PrepareErrorSerializer::class)
public sealed class PrepareError {
  /**
   *  * Error happened while serializing the module.
   *  * Possible values: Serialization
   */
  @Serializable
  @SerialName("Serialization")
  public data class Serialization(
    public val `value`: String = "Serialization",
  ) : PrepareError()

  /**
   *  * Error happened while deserializing the module.
   *  * Possible values: Deserialization
   */
  @Serializable
  @SerialName("Deserialization")
  public data class Deserialization(
    public val `value`: String = "Deserialization",
  ) : PrepareError()

  /**
   *  * Internal memory declaration has been found in the module.
   *  * Possible values: InternalMemoryDeclared
   */
  @Serializable
  @SerialName("InternalMemoryDeclared")
  public data class InternalMemoryDeclared(
    public val `value`: String = "InternalMemoryDeclared",
  ) : PrepareError()

  /**
   *  * Gas instrumentation failed.
   *
   * This most likely indicates the module isn't valid.
   *  * Possible values: GasInstrumentation
   */
  @Serializable
  @SerialName("GasInstrumentation")
  public data class GasInstrumentation(
    public val `value`: String = "GasInstrumentation",
  ) : PrepareError()

  /**
   *  * Stack instrumentation failed.
   *
   * This  most likely indicates the module isn't valid.
   *  * Possible values: StackHeightInstrumentation
   */
  @Serializable
  @SerialName("StackHeightInstrumentation")
  public data class StackHeightInstrumentation(
    public val `value`: String = "StackHeightInstrumentation",
  ) : PrepareError()

  /**
   *  * Error happened during instantiation.
   *
   * This might indicate that `start` function trapped, or module isn't
   * instantiable and/or un-linkable.
   *  * Possible values: Instantiate
   */
  @Serializable
  @SerialName("Instantiate")
  public data class Instantiate(
    public val `value`: String = "Instantiate",
  ) : PrepareError()

  /**
   *  * Error creating memory.
   *  * Possible values: Memory
   */
  @Serializable
  @SerialName("Memory")
  public data class Memory(
    public val `value`: String = "Memory",
  ) : PrepareError()

  /**
   *  * Contract contains too many functions.
   *  * Possible values: TooManyFunctions
   */
  @Serializable
  @SerialName("TooManyFunctions")
  public data class TooManyFunctions(
    public val `value`: String = "TooManyFunctions",
  ) : PrepareError()

  /**
   *  * Contract contains too many locals.
   *  * Possible values: TooManyLocals
   */
  @Serializable
  @SerialName("TooManyLocals")
  public data class TooManyLocals(
    public val `value`: String = "TooManyLocals",
  ) : PrepareError()

  /**
   *  * Contract contains too many tables.
   *  * Possible values: TooManyTables
   */
  @Serializable
  @SerialName("TooManyTables")
  public data class TooManyTables(
    public val `value`: String = "TooManyTables",
  ) : PrepareError()

  /**
   *  * Contract contains too many table elements.
   *  * Possible values: TooManyTableElements
   */
  @Serializable
  @SerialName("TooManyTableElements")
  public data class TooManyTableElements(
    public val `value`: String = "TooManyTableElements",
  ) : PrepareError()
}
