package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Data structure for semver version and github tag or commit.
 */
@Serializable
public data class Version(
  @SerialName("build")
  public val build: String,
  @SerialName("commit")
  public val commit: String,
  @SerialName("rustc_version")
  public val rustcVersion: String? = "",
  @SerialName("version")
  public val version: String,
)
