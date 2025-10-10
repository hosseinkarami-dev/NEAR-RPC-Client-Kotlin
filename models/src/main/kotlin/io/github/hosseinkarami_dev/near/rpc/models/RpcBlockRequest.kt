package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcBlockRequestSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = RpcBlockRequestSerializer::class)
public sealed class RpcBlockRequest {
  @Serializable
  public data class BlockId(
    @SerialName("block_id")
    public val blockId: io.github.hosseinkarami_dev.near.rpc.models.BlockId,
  ) : RpcBlockRequest()

  @Serializable
  public data class Finality(
    @SerialName("finality")
    public val finality: io.github.hosseinkarami_dev.near.rpc.models.Finality,
  ) : RpcBlockRequest()

  @Serializable
  public data class SyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint,
  ) : RpcBlockRequest()
}
