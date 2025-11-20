package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * An action which stakes signer_id tokens and setup's validator public key
 */
@Serializable
public data class StakeAction(
  /**
   *  * Validator key which will be used to sign transactions on behalf of signer_id
   */
  @SerialName("public_key")
  public val publicKey: PublicKey,
  /**
   *  * Amount of tokens to stake.
   */
  @SerialName("stake")
  public val stake: NearToken,
)
