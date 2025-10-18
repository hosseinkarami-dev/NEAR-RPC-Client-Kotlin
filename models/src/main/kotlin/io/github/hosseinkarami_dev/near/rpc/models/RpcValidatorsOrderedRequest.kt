package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcValidatorsOrderedRequest(
  @SerialName("block_id")
  public val blockId: BlockId? = null,
)
