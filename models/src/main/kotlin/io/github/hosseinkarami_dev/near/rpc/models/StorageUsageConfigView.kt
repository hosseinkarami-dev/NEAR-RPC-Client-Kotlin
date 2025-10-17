package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Describes cost of storage per block
 */
@Serializable
public data class StorageUsageConfigView(
  /**
   *  * Number of bytes for an account record, including rounding up for account id.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("num_bytes_account")
  public val numBytesAccount: ULong,
  /**
   *  * Additional number of bytes for a k/v record
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("num_extra_bytes_record")
  public val numExtraBytesRecord: ULong,
)
