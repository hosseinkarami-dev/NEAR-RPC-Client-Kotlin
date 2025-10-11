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
  public object Serialization : PrepareError()

  /**
   *  * Error happened while deserializing the module.
   *  * Possible values: Deserialization
   */
  @Serializable
  @SerialName("Deserialization")
  public object Deserialization : PrepareError()

  /**
   *  * Internal memory declaration has been found in the module.
   *  * Possible values: InternalMemoryDeclared
   */
  @Serializable
  @SerialName("InternalMemoryDeclared")
  public object InternalMemoryDeclared : PrepareError()

  /**
   *  * Gas instrumentation failed.
   *
   * This most likely indicates the module isn't valid.
   *  * Possible values: GasInstrumentation
   */
  @Serializable
  @SerialName("GasInstrumentation")
  public object GasInstrumentation : PrepareError()

  /**
   *  * Stack instrumentation failed.
   *
   * This  most likely indicates the module isn't valid.
   *  * Possible values: StackHeightInstrumentation
   */
  @Serializable
  @SerialName("StackHeightInstrumentation")
  public object StackHeightInstrumentation : PrepareError()

  /**
   *  * Error happened during instantiation.
   *
   * This might indicate that `start` function trapped, or module isn't
   * instantiable and/or un-linkable.
   *  * Possible values: Instantiate
   */
  @Serializable
  @SerialName("Instantiate")
  public object Instantiate : PrepareError()

  /**
   *  * Error creating memory.
   *  * Possible values: Memory
   */
  @Serializable
  @SerialName("Memory")
  public object Memory : PrepareError()

  /**
   *  * Contract contains too many functions.
   *  * Possible values: TooManyFunctions
   */
  @Serializable
  @SerialName("TooManyFunctions")
  public object TooManyFunctions : PrepareError()

  /**
   *  * Contract contains too many locals.
   *  * Possible values: TooManyLocals
   */
  @Serializable
  @SerialName("TooManyLocals")
  public object TooManyLocals : PrepareError()

  /**
   *  * Contract contains too many tables.
   *  * Possible values: TooManyTables
   */
  @Serializable
  @SerialName("TooManyTables")
  public object TooManyTables : PrepareError()

  /**
   *  * Contract contains too many table elements.
   *  * Possible values: TooManyTableElements
   */
  @Serializable
  @SerialName("TooManyTableElements")
  public object TooManyTableElements : PrepareError()
}
