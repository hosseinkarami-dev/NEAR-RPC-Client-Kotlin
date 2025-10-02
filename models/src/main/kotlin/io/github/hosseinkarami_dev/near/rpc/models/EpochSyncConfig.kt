package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class EpochSyncConfig(
  @SerialName("disable_epoch_sync_for_bootstrapping")
  public val disableEpochSyncForBootstrapping: Boolean?,
  @SerialName("epoch_sync_horizon")
  public val epochSyncHorizon: Long,
  @SerialName("ignore_epoch_sync_network_requests")
  public val ignoreEpochSyncNetworkRequests: Boolean?,
  @SerialName("timeout_for_epoch_sync")
  public val timeoutForEpochSync: DurationAsStdSchemaProvider,
)
