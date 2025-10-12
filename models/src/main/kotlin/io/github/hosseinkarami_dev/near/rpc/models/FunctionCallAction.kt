package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class FunctionCallAction(
  @SerialName("args")
  public val args: String,
  @SerialName("deposit")
  public val deposit: NearToken,
  @SerialName("gas")
  public val gas: NearGas,
  @SerialName("method_name")
  public val methodName: String,
)
