package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class DataReceiverView(
  @SerialName("data_id")
  public val dataId: CryptoHash,
  @SerialName("receiver_id")
  public val receiverId: AccountId,
)
