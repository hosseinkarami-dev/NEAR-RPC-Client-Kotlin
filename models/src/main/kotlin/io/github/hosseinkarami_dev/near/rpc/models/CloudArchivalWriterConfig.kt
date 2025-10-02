package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class CloudArchivalWriterConfig(
  @SerialName("archive_block_data")
  public val archiveBlockData: Boolean?,
  @SerialName("cloud_storage")
  public val cloudStorage: CloudStorageConfig,
  @SerialName("polling_interval")
  public val pollingInterval: DurationAsStdSchemaProvider?,
)
