package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcErrorSerializer::class)
public sealed class JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcLightClientExecutionProofResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: RpcError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcError()
}
