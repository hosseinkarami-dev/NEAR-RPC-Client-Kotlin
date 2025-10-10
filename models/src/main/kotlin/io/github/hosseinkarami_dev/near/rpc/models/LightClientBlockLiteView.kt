package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class LightClientBlockLiteView(
  @SerialName("inner_lite")
  public val innerLite: BlockHeaderInnerLiteView,
  @SerialName("inner_rest_hash")
  public val innerRestHash: CryptoHash,
  @SerialName("prev_block_hash")
  public val prevBlockHash: CryptoHash,
)
