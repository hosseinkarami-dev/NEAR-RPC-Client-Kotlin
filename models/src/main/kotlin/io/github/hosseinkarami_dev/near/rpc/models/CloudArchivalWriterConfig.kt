package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Configuration for a cloud-based archival writer. If this config is present, the writer is enabled and
 * writes chunk-related data based on the tracked shards. This config also controls additional archival
 * behavior such as block data and polling interval.
 */
@Serializable
public data class CloudArchivalWriterConfig(
  /**
   *  * Determines whether block-related data should be written to cloud storage.
   */
  @SerialName("archive_block_data")
  public val archiveBlockData: Boolean? = false,
  /**
   *  * Interval at which the system checks for new blocks or chunks to archive.
   */
  @SerialName("polling_interval")
  public val pollingInterval:
      DurationAsStdSchemaProvider? = DurationAsStdSchemaProvider(nanos = 0.toInt(), secs = 1L),
)
