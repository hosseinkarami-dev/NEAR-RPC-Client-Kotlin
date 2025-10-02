package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError {
  @Serializable
  public class Result(
    @SerialName("result")
    public val result: List<ValidatorStakeView>,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError()

  @Serializable
  public class Error(
    @SerialName("error")
    public val error: RpcError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError()
}
