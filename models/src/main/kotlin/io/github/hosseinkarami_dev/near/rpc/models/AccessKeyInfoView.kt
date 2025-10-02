package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class AccessKeyInfoView(
  @SerialName("access_key")
  public val accessKey: AccessKeyView,
  @SerialName("public_key")
  public val publicKey: PublicKey,
)
