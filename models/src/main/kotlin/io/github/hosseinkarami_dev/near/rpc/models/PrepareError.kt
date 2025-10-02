package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class PrepareError {
  @Serializable
  @SerialName("Serialization")
  public object Serialization : PrepareError()

  @Serializable
  @SerialName("Deserialization")
  public object Deserialization : PrepareError()

  @Serializable
  @SerialName("InternalMemoryDeclared")
  public object InternalMemoryDeclared : PrepareError()

  @Serializable
  @SerialName("GasInstrumentation")
  public object GasInstrumentation : PrepareError()

  @Serializable
  @SerialName("StackHeightInstrumentation")
  public object StackHeightInstrumentation : PrepareError()

  @Serializable
  @SerialName("Instantiate")
  public object Instantiate : PrepareError()

  @Serializable
  @SerialName("Memory")
  public object Memory : PrepareError()

  @Serializable
  @SerialName("TooManyFunctions")
  public object TooManyFunctions : PrepareError()

  @Serializable
  @SerialName("TooManyLocals")
  public object TooManyLocals : PrepareError()

  @Serializable
  @SerialName("TooManyTables")
  public object TooManyTables : PrepareError()

  @Serializable
  @SerialName("TooManyTableElements")
  public object TooManyTableElements : PrepareError()
}
