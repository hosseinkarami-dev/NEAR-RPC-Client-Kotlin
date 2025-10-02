package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcBlockResponse(
  @SerialName("author")
  public val author: AccountId,
  @SerialName("chunks")
  public val chunks: List<ChunkHeaderView>,
  @SerialName("header")
  public val `header`: BlockHeaderView,
)
