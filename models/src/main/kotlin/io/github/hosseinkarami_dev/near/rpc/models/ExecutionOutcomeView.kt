package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ExecutionOutcomeView(
  @SerialName("executor_id")
  public val executorId: AccountId,
  @SerialName("gas_burnt")
  public val gasBurnt: NearGas,
  @SerialName("logs")
  public val logs: List<String>,
  @SerialName("metadata")
  public val metadata: ExecutionMetadataView?,
  @SerialName("receipt_ids")
  public val receiptIds: List<CryptoHash>,
  @SerialName("status")
  public val status: ExecutionStatusView,
  @SerialName("tokens_burnt")
  public val tokensBurnt: NearToken,
)
