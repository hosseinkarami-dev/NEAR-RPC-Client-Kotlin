package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Configures the external storage used by the archival node.
 */
@Serializable
public data class CloudStorageConfig(
  /**
   *  * Location of a json file with credentials allowing access to the bucket.
   *  * Nullable: true
   */
  @SerialName("credentials_file")
  public val credentialsFile: String? = null,
  /**
   *  * The storage to persist the archival data.
   */
  @SerialName("storage")
  public val storage: ExternalStorageLocation,
)
