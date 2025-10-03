package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class RpcCongestionLevelRequest {
  @Serializable
  public data class BlockShardId(
    @SerialName("block_id")
    public val blockId: BlockId,
    @SerialName("shard_id")
    public val shardId: ShardId,
  ) : RpcCongestionLevelRequest()

  @Serializable
  public data class ChunkHash(
    @SerialName("chunk_id")
    public val chunkId: CryptoHash,
  ) : RpcCongestionLevelRequest()
}
