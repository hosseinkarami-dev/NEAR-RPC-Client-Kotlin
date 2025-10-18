package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Possible values: Left, Right
 */
@Serializable
public enum class Direction {
  @SerialName("Left")
  LEFT,
  @SerialName("Right")
  RIGHT,
}
