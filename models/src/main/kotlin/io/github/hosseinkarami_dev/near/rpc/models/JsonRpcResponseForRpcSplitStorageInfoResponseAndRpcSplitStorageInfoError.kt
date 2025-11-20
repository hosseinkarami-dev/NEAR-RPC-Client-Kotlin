package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoErrorSerializer::class)
public sealed class JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcSplitStorageInfoResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcSplitStorageInfoError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoError()
}
