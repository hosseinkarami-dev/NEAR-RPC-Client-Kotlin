package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class RpcStateChangesInBlockRequest {
  @Serializable
  public class BlockId(
    @SerialName("block_id")
    public val blockId: io.github.hosseinkarami_dev.near.rpc.models.BlockId,
  ) : RpcStateChangesInBlockRequest()

  @Serializable
  public class Finality(
    @SerialName("finality")
    public val finality: io.github.hosseinkarami_dev.near.rpc.models.Finality,
  ) : RpcStateChangesInBlockRequest()

  @Serializable
  public class SyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint,
  ) : RpcStateChangesInBlockRequest()
}
