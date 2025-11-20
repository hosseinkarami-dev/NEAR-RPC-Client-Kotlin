package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForCryptoHashAndRpcTransactionErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForCryptoHashAndRpcTransactionErrorSerializer::class)
public sealed class JsonRpcResponseForCryptoHashAndRpcTransactionError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: CryptoHash,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForCryptoHashAndRpcTransactionError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcTransactionError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForCryptoHashAndRpcTransactionError()
}
