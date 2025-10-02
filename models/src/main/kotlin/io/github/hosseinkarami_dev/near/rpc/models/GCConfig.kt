package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class GCConfig(
  @SerialName("gc_blocks_limit")
  public val gcBlocksLimit: Long?,
  @SerialName("gc_fork_clean_step")
  public val gcForkCleanStep: Long?,
  @SerialName("gc_num_epochs_to_keep")
  public val gcNumEpochsToKeep: Long?,
  @SerialName("gc_step_period")
  public val gcStepPeriod: DurationAsStdSchemaProvider?,
)
