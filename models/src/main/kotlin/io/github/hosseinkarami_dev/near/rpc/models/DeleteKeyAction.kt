package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class DeleteKeyAction(
  /**
   *  * A public key associated with the access_key to be deleted.
   */
  @SerialName("public_key")
  public val publicKey: PublicKey,
)
