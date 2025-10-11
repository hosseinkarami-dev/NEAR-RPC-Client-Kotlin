package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForGasPrice(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: gas_price
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcGasPriceRequest,
) {
  /**
   *  * Possible values: gas_price
   */
  @Serializable
  public enum class Method {
    @SerialName("gas_price")
    GAS_PRICE,
  }
}
