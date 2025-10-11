package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcStateChangesInBlockByTypeResponse(
  @SerialName("block_hash")
  public val blockHash: CryptoHash,
  @SerialName("changes")
  public val changes: List<StateChangeKindView>,
)
