package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class DeleteKeyAction(
  @SerialName("public_key")
  public val publicKey: PublicKey,
)
