package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcLightClientProofErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcLightClientProofErrorSerializer::class)
public sealed class JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcLightClientProofError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcLightClientExecutionProofResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcLightClientProofError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcLightClientProofError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcLightClientProofError()
}
