package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ExternalStorageConfig(
  @SerialName("external_storage_fallback_threshold")
  public val externalStorageFallbackThreshold: Long?,
  @SerialName("location")
  public val location: ExternalStorageLocation,
  @SerialName("num_concurrent_requests")
  public val numConcurrentRequests: Int?,
  @SerialName("num_concurrent_requests_during_catchup")
  public val numConcurrentRequestsDuringCatchup: Int?,
)
