package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcValidatorResponseAndRpcValidatorErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcValidatorResponseAndRpcValidatorErrorSerializer::class)
public sealed class JsonRpcResponseForRpcValidatorResponseAndRpcValidatorError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcValidatorResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcValidatorResponseAndRpcValidatorError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcValidatorError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcValidatorResponseAndRpcValidatorError()
}
