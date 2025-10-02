package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForExperimentalLightClientBlockProof(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcLightClientBlockProofRequest,
) {
  @Serializable
  public enum class Method {
    @SerialName("EXPERIMENTAL_light_client_block_proof")
    EXPERIMENTAL_LIGHT_CLIENT_BLOCK_PROOF,
  }
}
