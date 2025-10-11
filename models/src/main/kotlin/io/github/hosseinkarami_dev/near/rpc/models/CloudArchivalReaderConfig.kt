package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Configuration for a cloud-based archival reader.
 */
@Serializable
public data class CloudArchivalReaderConfig(
  /**
   *  * Configures the external storage used by the archival node.
   */
  @SerialName("cloud_storage")
  public val cloudStorage: CloudStorageConfig,
)
