package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class SyncConcurrency(
  @SerialName("apply")
  public val apply: Int,
  @SerialName("apply_during_catchup")
  public val applyDuringCatchup: Int,
  @SerialName("peer_downloads")
  public val peerDownloads: Int,
  @SerialName("per_shard")
  public val perShard: Int,
)
