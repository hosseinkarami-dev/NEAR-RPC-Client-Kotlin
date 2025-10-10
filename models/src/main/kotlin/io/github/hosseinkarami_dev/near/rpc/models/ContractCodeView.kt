package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * A view of the contract code.
 */
@Serializable
public data class ContractCodeView(
  @SerialName("code_base64")
  public val codeBase64: String,
  @SerialName("hash")
  public val hash: CryptoHash,
)
