package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ExecutionOutcomeWithIdView(
  @SerialName("block_hash")
  public val blockHash: CryptoHash,
  @SerialName("id")
  public val id: CryptoHash,
  @SerialName("outcome")
  public val outcome: ExecutionOutcomeView,
  @SerialName("proof")
  public val proof: List<MerklePathItem>,
)
