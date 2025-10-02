package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcSplitStorageInfoResponse(
  @SerialName("cold_head_height")
  public val coldHeadHeight: Long?,
  @SerialName("final_head_height")
  public val finalHeadHeight: Long?,
  @SerialName("head_height")
  public val headHeight: Long?,
  @SerialName("hot_db_kind")
  public val hotDbKind: String?,
)
