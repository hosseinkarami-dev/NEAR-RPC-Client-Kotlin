package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class ExternalStorageLocation {
  @Serializable
  public class S3(
    @SerialName("S3")
    public val s3: S3Payload,
  ) : ExternalStorageLocation() {
    @Serializable
    public data class S3Payload(
      /**
       *  * Location of state dumps on S3.
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

  @Serializable
  public class Filesystem(
    @SerialName("Filesystem")
    public val filesystem: FilesystemPayload,
  ) : ExternalStorageLocation() {
    @Serializable
    public data class FilesystemPayload(
      @SerialName("root_dir")
      public val rootDir: String,
    )
  }

  @Serializable
  public class Gcs(
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
