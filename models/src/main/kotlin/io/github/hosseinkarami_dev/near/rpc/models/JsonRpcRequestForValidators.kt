package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForValidators(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: validators
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcValidatorRequest,
) {
  /**
   *  * Possible values: validators
   */
  @Serializable
  public enum class Method {
    @SerialName("validators")
    VALIDATORS,
  }
}
