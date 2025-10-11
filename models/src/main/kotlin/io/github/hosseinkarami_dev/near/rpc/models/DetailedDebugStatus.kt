package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.ULong
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class DetailedDebugStatus(
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("block_production_delay_millis")
  public val blockProductionDelayMillis: ULong,
  @SerialName("catchup_status")
  public val catchupStatus: List<CatchupStatusView>,
  @SerialName("current_head_status")
  public val currentHeadStatus: BlockStatusView,
  @SerialName("current_header_head_status")
  public val currentHeaderHeadStatus: BlockStatusView,
  @SerialName("network_info")
  public val networkInfo: NetworkInfoView,
  @SerialName("sync_status")
  public val syncStatus: String,
)
