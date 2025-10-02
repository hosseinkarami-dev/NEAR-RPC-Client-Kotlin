package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class FunctionCallPermission(
  @SerialName("allowance")
  public val allowance: NearToken?,
  @SerialName("method_names")
  public val methodNames: List<String>,
  @SerialName("receiver_id")
  public val receiverId: String,
)
