package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Configures how to dump state to external storage.
 */
@Serializable
public data class DumpConfig(
  /**
   *  * Location of a json file with credentials allowing access to the bucket.
   *  * Nullable: true
   */
  @SerialName("credentials_file")
  public val credentialsFile: String? = null,
  /**
   *  * How often to check if a new epoch has started.
   * Feel free to set to `None`, defaults are sensible.
   */
  @SerialName("iteration_delay")
  public val iterationDelay: DurationAsStdSchemaProvider? = null,
  /**
   *  * Specifies where to write the obtained state parts.
   */
  @SerialName("location")
  public val location: ExternalStorageLocation,
  /**
   *  * Use in case a node that dumps state to the external storage
   * gets in trouble.
   *  * Nullable: true
   */
  @SerialName("restart_dump_for_shards")
  public val restartDumpForShards: List<ShardId>? = null,
)
