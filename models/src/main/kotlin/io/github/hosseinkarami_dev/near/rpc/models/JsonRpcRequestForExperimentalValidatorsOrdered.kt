package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForExperimentalValidatorsOrdered(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: EXPERIMENTAL_validators_ordered
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcValidatorsOrderedRequest,
) {
  /**
   *  * Possible values: EXPERIMENTAL_validators_ordered
   */
  @Serializable
  public enum class Method {
    @SerialName("EXPERIMENTAL_validators_ordered")
    EXPERIMENTAL_VALIDATORS_ORDERED,
  }
}
