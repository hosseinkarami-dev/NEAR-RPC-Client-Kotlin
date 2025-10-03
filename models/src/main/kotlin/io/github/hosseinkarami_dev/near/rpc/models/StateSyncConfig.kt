package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class StateSyncConfig(
  @SerialName("concurrency")
  public val concurrency: SyncConcurrency? = null,
  /**
   *  * `none` value disables state dump to external storage.
   */
  @SerialName("dump")
  public val dump: DumpConfig? = null,
  /**
   *  * Zstd compression level for state parts.
   *  * Format: int32
   */
  @SerialName("parts_compression_lvl")
  public val partsCompressionLvl: Int? = 1,
  @SerialName("sync")
  public val sync: SyncConfig? = null,
)
