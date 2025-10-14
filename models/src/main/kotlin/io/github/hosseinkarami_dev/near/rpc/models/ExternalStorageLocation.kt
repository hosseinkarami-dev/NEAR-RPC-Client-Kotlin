package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.ExternalStorageLocationSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Supported external storage backends and their minimal config.
 */
@Serializable(with = ExternalStorageLocationSerializer::class)
public sealed class ExternalStorageLocation {
  @Serializable
  public data class S3(
    @SerialName("S3")
    public val s3: S3Payload,
  ) : ExternalStorageLocation() {
    @Serializable
    public data class S3Payload(
      /**
       *  * Location on S3.
       */
      @SerialName("bucket")
      public val bucket: String,
      /**
       *  * Data may only be available in certain locations.
       */
      @SerialName("region")
      public val region: String,
    )
  }

  /**
   *  * Local filesystem root for storing data.
   */
  @Serializable
  public data class Filesystem(
    @SerialName("Filesystem")
    public val filesystem: FilesystemPayload,
  ) : ExternalStorageLocation() {
    @Serializable
    public data class FilesystemPayload(
      @SerialName("root_dir")
      public val rootDir: String,
    )
  }

  /**
   *  * Google Cloud Storage bucket name.
   */
  @Serializable
  public data class Gcs(
    @SerialName("GCS")
    public val gcs: GcsPayload,
  ) : ExternalStorageLocation() {
    @Serializable
    public data class GcsPayload(
      @SerialName("bucket")
      public val bucket: String,
    )
  }
}
