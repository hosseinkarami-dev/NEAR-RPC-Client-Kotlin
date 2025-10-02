package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class StorageUsageConfigView(
  @SerialName("num_bytes_account")
  public val numBytesAccount: Long,
  @SerialName("num_extra_bytes_record")
  public val numExtraBytesRecord: Long,
)
