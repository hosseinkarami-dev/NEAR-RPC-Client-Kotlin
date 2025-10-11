package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcLightClientNextBlockRequest(
  @SerialName("last_block_hash")
  public val lastBlockHash: CryptoHash,
)
