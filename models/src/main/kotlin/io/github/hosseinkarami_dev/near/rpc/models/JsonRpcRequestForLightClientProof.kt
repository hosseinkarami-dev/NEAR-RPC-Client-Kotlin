package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForLightClientProof(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: light_client_proof
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcLightClientExecutionProofRequest,
) {
  /**
   *  * Possible values: light_client_proof
   */
  @Serializable
  public enum class Method {
    @SerialName("light_client_proof")
    LIGHT_CLIENT_PROOF,
  }
}
