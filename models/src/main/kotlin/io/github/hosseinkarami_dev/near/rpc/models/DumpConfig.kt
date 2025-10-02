package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class DumpConfig(
  @SerialName("credentials_file")
  public val credentialsFile: String?,
  @SerialName("iteration_delay")
  public val iterationDelay: DurationAsStdSchemaProvider?,
  @SerialName("location")
  public val location: ExternalStorageLocation,
  @SerialName("restart_dump_for_shards")
  public val restartDumpForShards: List<ShardId>,
)
