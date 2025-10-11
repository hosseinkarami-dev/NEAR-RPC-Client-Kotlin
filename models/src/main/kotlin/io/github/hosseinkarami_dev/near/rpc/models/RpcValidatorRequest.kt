package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcValidatorRequestSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = RpcValidatorRequestSerializer::class)
public sealed class RpcValidatorRequest {
  /**
   *  * Possible values: latest
   */
  @Serializable
  @SerialName("latest")
  public object Latest : RpcValidatorRequest()

  @Serializable
  public data class EpochId(
    @SerialName("epoch_id")
    public val epochId: io.github.hosseinkarami_dev.near.rpc.models.EpochId,
  ) : RpcValidatorRequest()

  @Serializable
  public data class BlockId(
    @SerialName("block_id")
    public val blockId: io.github.hosseinkarami_dev.near.rpc.models.BlockId,
  ) : RpcValidatorRequest()
}
