package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.UInt
import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Configuration specific to ChunkStateWitness.
 */
@Serializable
public data class WitnessConfigView(
  /**
   *  * Maximum size of transactions contained inside ChunkStateWitness.
   *
   * A witness contains transactions from both the previous chunk and the current one.
   * This parameter limits the sum of sizes of transactions from both of those chunks.
   *  * Minimum: 0.0
   *  * Format: uint
   */
  @SerialName("combined_transactions_size_limit")
  public val combinedTransactionsSizeLimit: UInt,
  /**
   *  * Size limit for storage proof generated while executing receipts in a chunk.
   * After this limit is reached we defer execution of any new receipts.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("main_storage_proof_size_soft_limit")
  public val mainStorageProofSizeSoftLimit: ULong,
  /**
   *  * Soft size limit of storage proof used to validate new transactions in ChunkStateWitness.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("new_transactions_validation_state_size_soft_limit")
  public val newTransactionsValidationStateSizeSoftLimit: ULong,
)
