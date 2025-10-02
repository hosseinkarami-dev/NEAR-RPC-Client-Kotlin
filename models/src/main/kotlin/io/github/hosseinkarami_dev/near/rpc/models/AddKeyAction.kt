package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class AddKeyAction(
  @SerialName("access_key")
  public val accessKey: AccessKey,
  @SerialName("public_key")
  public val publicKey: PublicKey,
)
