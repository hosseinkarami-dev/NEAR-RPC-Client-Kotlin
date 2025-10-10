package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * An action that adds key with public key associated
 */
@Serializable
public data class AddKeyAction(
  /**
   *  * An access key with the permission
   */
  @SerialName("access_key")
  public val accessKey: AccessKey,
  /**
   *  * A public key which will be associated with an access_key
   */
  @SerialName("public_key")
  public val publicKey: PublicKey,
)
