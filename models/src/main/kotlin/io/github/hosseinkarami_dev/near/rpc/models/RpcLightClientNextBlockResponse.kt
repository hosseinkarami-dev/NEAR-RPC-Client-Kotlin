package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * A state for the current head of a light client. More info [here](https://nomicon.io/ChainSpec/LightClient).
 */
@Serializable
public data class RpcLightClientNextBlockResponse(
  @SerialName("approvals_after_next")
  public val approvalsAfterNext: List<Signature?>? = null,
  /**
   *  * Inner part of the block header that gets hashed, split into two parts, one that is sent
   *    to light clients, and the rest
   */
  @SerialName("inner_lite")
  public val innerLite: BlockHeaderInnerLiteView? = null,
  @SerialName("inner_rest_hash")
  public val innerRestHash: CryptoHash? = null,
  @SerialName("next_block_inner_hash")
  public val nextBlockInnerHash: CryptoHash? = null,
  /**
   *  * Nullable: true
   */
  @SerialName("next_bps")
  public val nextBps: List<ValidatorStakeView>? = null,
  @SerialName("prev_block_hash")
  public val prevBlockHash: CryptoHash? = null,
)
