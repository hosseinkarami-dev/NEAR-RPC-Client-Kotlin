package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class DeleteAccountAction(
  @SerialName("beneficiary_id")
  public val beneficiaryId: AccountId,
)
