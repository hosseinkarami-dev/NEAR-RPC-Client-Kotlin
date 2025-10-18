package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcLightClientExecutionProofResponse(
  @SerialName("block_header_lite")
  public val blockHeaderLite: LightClientBlockLiteView,
  @SerialName("block_proof")
  public val blockProof: List<MerklePathItem>,
  @SerialName("outcome_proof")
  public val outcomeProof: ExecutionOutcomeWithIdView,
  @SerialName("outcome_root_proof")
  public val outcomeRootProof: List<MerklePathItem>,
)
