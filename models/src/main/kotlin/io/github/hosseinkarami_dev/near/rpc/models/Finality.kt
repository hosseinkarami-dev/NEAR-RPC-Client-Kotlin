package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Different types of finality.
 *  * Possible values: optimistic, near-final, final
 */
@Serializable
public enum class Finality {
  @SerialName("optimistic")
  OPTIMISTIC,
  @SerialName("near-final")
  NEAR_FINAL,
  @SerialName("final")
  FINAL,
}
