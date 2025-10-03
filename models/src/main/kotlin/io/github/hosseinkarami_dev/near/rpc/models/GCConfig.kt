package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Configuration for garbage collection.
 */
@Serializable
public data class GCConfig(
  /**
   *  * Maximum number of blocks to garbage collect at every garbage collection
   * call.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("gc_blocks_limit")
  public val gcBlocksLimit: Long? = 2L,
  /**
   *  * Maximum number of height to go through at each garbage collection step
   * when cleaning forks during garbage collection.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("gc_fork_clean_step")
  public val gcForkCleanStep: Long? = 100L,
  /**
   *  * Number of epochs for which we keep store data.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("gc_num_epochs_to_keep")
  public val gcNumEpochsToKeep: Long? = 5L,
  /**
   *  * How often gc should be run
   */
  @SerialName("gc_step_period")
  public val gcStepPeriod:
      DurationAsStdSchemaProvider? = DurationAsStdSchemaProvider(nanos = 500000000.toInt(), secs = 0L),
) {
  init {
    require((gcBlocksLimit?.toDouble() ?: 0.0) >= 0.0) { "GCConfig.gcBlocksLimit must be >= 0.0" }}
  init {
    require((gcForkCleanStep?.toDouble() ?: 0.0) >= 0.0) { "GCConfig.gcForkCleanStep must be >= 0.0" }}
  init {
    require((gcNumEpochsToKeep?.toDouble() ?: 0.0) >= 0.0) { "GCConfig.gcNumEpochsToKeep must be >= 0.0" }}
}
