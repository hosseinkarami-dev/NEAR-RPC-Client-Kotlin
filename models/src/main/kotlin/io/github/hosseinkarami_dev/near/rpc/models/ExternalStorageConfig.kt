package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ExternalStorageConfig(
  /**
   *  * The number of attempts the node will make to obtain a part from peers in
   * the network before it fetches from external storage.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("external_storage_fallback_threshold")
  public val externalStorageFallbackThreshold: Long? = 3L,
  /**
   *  * Location of state parts.
   */
  @SerialName("location")
  public val location: ExternalStorageLocation,
  /**
   *  * When fetching state parts from external storage, throttle fetch requests
   * to this many concurrent requests.
   *  * Minimum: 0.0
   *  * Maximum: 255.0
   *  * Format: uint8
   */
  @SerialName("num_concurrent_requests")
  public val numConcurrentRequests: Int? = 25,
  /**
   *  * During catchup, the node will use a different number of concurrent requests
   * to reduce the performance impact of state sync.
   *  * Minimum: 0.0
   *  * Maximum: 255.0
   *  * Format: uint8
   */
  @SerialName("num_concurrent_requests_during_catchup")
  public val numConcurrentRequestsDuringCatchup: Int? = 5,
)
