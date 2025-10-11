package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForCryptoHashAndRpcErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForCryptoHashAndRpcErrorSerializer::class)
public sealed class JsonRpcResponseForCryptoHashAndRpcError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: CryptoHash,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForCryptoHashAndRpcError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: RpcError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForCryptoHashAndRpcError()
}
