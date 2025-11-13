package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class SignedDelegateAction(
  @SerialName("delegate_action")
  public val delegateAction: DelegateAction,
  @SerialName("signature")
  public val signature: Signature,
)
