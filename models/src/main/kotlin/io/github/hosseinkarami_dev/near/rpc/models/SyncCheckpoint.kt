package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Possible values: genesis, earliest_available
 */
@Serializable
public enum class SyncCheckpoint {
  @SerialName("genesis")
  GENESIS,
  @SerialName("earliest_available")
  EARLIEST_AVAILABLE,
}
