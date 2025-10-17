package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Configures whether the node checks the next or the next next epoch for network version compatibility.
 *  * Possible values: Next, NextNext
 */
@Serializable
public enum class ProtocolVersionCheckConfig {
  @SerialName("Next")
  NEXT,
  @SerialName("NextNext")
  NEXT_NEXT,
}
