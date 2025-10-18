package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Deploy contract action
 */
@Serializable
public data class DeployContractAction(
  /**
   *  * WebAssembly binary
   */
  @SerialName("code")
  public val code: String,
)
