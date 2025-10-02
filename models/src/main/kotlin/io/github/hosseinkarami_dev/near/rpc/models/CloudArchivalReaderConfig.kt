package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class CloudArchivalReaderConfig(
  @SerialName("cloud_storage")
  public val cloudStorage: CloudStorageConfig,
)
