package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class WitnessConfigView(
  @SerialName("combined_transactions_size_limit")
  public val combinedTransactionsSizeLimit: Int,
  @SerialName("main_storage_proof_size_soft_limit")
  public val mainStorageProofSizeSoftLimit: Long,
  @SerialName("new_transactions_validation_state_size_soft_limit")
  public val newTransactionsValidationStateSizeSoftLimit: Long,
)
