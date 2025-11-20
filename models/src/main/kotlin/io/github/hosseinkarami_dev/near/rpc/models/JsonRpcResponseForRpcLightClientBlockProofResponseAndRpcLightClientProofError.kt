package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcLightClientBlockProofResponseAndRpcLightClientProofErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcLightClientBlockProofResponseAndRpcLightClientProofErrorSerializer::class)
public sealed class JsonRpcResponseForRpcLightClientBlockProofResponseAndRpcLightClientProofError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcLightClientBlockProofResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcLightClientBlockProofResponseAndRpcLightClientProofError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcLightClientProofError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcLightClientBlockProofResponseAndRpcLightClientProofError()
}
