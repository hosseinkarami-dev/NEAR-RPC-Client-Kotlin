package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcLightClientBlockProofRequest(
  @SerialName("block_hash")
  public val blockHash: CryptoHash,
  @SerialName("light_client_head")
  public val lightClientHead: CryptoHash,
)
