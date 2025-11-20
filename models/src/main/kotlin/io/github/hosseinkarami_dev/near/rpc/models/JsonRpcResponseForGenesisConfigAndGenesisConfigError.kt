package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForGenesisConfigAndGenesisConfigErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForGenesisConfigAndGenesisConfigErrorSerializer::class)
public sealed class JsonRpcResponseForGenesisConfigAndGenesisConfigError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: GenesisConfig,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForGenesisConfigAndGenesisConfigError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForGenesisConfigError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForGenesisConfigAndGenesisConfigError()
}
