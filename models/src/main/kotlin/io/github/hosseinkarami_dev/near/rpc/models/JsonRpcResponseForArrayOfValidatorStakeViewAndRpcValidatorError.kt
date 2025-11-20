package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForArrayOfValidatorStakeViewAndRpcValidatorErrorSerializer
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForArrayOfValidatorStakeViewAndRpcValidatorErrorSerializer::class)
public sealed class JsonRpcResponseForArrayOfValidatorStakeViewAndRpcValidatorError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: List<ValidatorStakeView>,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForArrayOfValidatorStakeViewAndRpcValidatorError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcValidatorError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForArrayOfValidatorStakeViewAndRpcValidatorError()
}
