package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.PrepareErrorSerializer
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
  public data object Serialization : PrepareError()

  /**
   *  * Error happened while deserializing the module.
   *  * Possible values: Deserialization
   */
  @Serializable
  @SerialName("Deserialization")
  public data object Deserialization : PrepareError()

  /**
   *  * Internal memory declaration has been found in the module.
   *  * Possible values: InternalMemoryDeclared
   */
  @Serializable
  @SerialName("InternalMemoryDeclared")
  public data object InternalMemoryDeclared : PrepareError()

  /**
   *  * Gas instrumentation failed.
   *
   * This most likely indicates the module isn't valid.
   *  * Possible values: GasInstrumentation
   */
  @Serializable
  @SerialName("GasInstrumentation")
  public data object GasInstrumentation : PrepareError()

  /**
   *  * Stack instrumentation failed.
   *
   * This  most likely indicates the module isn't valid.
   *  * Possible values: StackHeightInstrumentation
   */
  @Serializable
  @SerialName("StackHeightInstrumentation")
  public data object StackHeightInstrumentation : PrepareError()

  /**
   *  * Error happened during instantiation.
   *
   * This might indicate that `start` function trapped, or module isn't
   * instantiable and/or un-linkable.
   *  * Possible values: Instantiate
   */
  @Serializable
  @SerialName("Instantiate")
  public data object Instantiate : PrepareError()

  /**
   *  * Error creating memory.
   *  * Possible values: Memory
   */
  @Serializable
  @SerialName("Memory")
  public data object Memory : PrepareError()

  /**
   *  * Contract contains too many functions.
   *  * Possible values: TooManyFunctions
   */
  @Serializable
  @SerialName("TooManyFunctions")
  public data object TooManyFunctions : PrepareError()

  /**
   *  * Contract contains too many locals.
   *  * Possible values: TooManyLocals
   */
  @Serializable
  @SerialName("TooManyLocals")
  public data object TooManyLocals : PrepareError()

  /**
   *  * Contract contains too many tables.
   *  * Possible values: TooManyTables
   */
  @Serializable
  @SerialName("TooManyTables")
  public data object TooManyTables : PrepareError()

  /**
   *  * Contract contains too many table elements.
   *  * Possible values: TooManyTableElements
   */
  @Serializable
  @SerialName("TooManyTableElements")
  public data object TooManyTableElements : PrepareError()
}
