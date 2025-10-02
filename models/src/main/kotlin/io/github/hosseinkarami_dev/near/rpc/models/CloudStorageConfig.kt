package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class CloudStorageConfig(
  @SerialName("credentials_file")
  public val credentialsFile: String?,
  @SerialName("storage")
  public val storage: ExternalStorageLocation,
)
