package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class LogSummaryStyle {
  @SerialName("plain")
  PLAIN,
  @SerialName("colored")
  COLORED,
}
