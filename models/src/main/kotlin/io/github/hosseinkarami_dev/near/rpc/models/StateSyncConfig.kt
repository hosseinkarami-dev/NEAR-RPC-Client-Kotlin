package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class StateSyncConfig(
  @SerialName("concurrency")
  public val concurrency: SyncConcurrency?,
  @SerialName("dump")
  public val dump: DumpConfig?,
  @SerialName("parts_compression_lvl")
  public val partsCompressionLvl: Int?,
  @SerialName("sync")
  public val sync: SyncConfig?,
)
