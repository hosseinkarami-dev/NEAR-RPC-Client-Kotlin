package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcLightClientNextBlockResponse(
  @SerialName("approvals_after_next")
  public val approvalsAfterNext: List<Signature?>,
  @SerialName("inner_lite")
  public val innerLite: BlockHeaderInnerLiteView?,
  @SerialName("inner_rest_hash")
  public val innerRestHash: CryptoHash?,
  @SerialName("next_block_inner_hash")
  public val nextBlockInnerHash: CryptoHash?,
  @SerialName("next_bps")
  public val nextBps: List<ValidatorStakeView>,
  @SerialName("prev_block_hash")
  public val prevBlockHash: CryptoHash?,
)
