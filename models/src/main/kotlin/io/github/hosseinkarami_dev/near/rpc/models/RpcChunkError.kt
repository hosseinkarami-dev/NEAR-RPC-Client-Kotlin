package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcChunkErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable(with = RpcChunkErrorSerializer::class)
public sealed class RpcChunkError {
  @Serializable
  public data class InternalError(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: INTERNAL_ERROR
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcChunkError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("error_message")
      public val errorMessage: String,
    )

    /**
     *  * Possible values: INTERNAL_ERROR
     */
    @Serializable
    public enum class Name {
      @SerialName("INTERNAL_ERROR")
      INTERNAL_ERROR,
    }
  }

  @Serializable
  public data class UnknownBlock(
    @SerialName("info")
    public val info: JsonElement,
    /**
     *  * Possible values: UNKNOWN_BLOCK
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcChunkError() {
    /**
     *  * Possible values: UNKNOWN_BLOCK
     */
    @Serializable
    public enum class Name {
      @SerialName("UNKNOWN_BLOCK")
      UNKNOWN_BLOCK,
    }
  }

  @Serializable
  public data class InvalidShardId(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: INVALID_SHARD_ID
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcChunkError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("shard_id")
      public val shardId: ShardId,
    )

    /**
     *  * Possible values: INVALID_SHARD_ID
     */
    @Serializable
    public enum class Name {
      @SerialName("INVALID_SHARD_ID")
      INVALID_SHARD_ID,
    }
  }

  @Serializable
  public data class UnknownChunk(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: UNKNOWN_CHUNK
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcChunkError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("chunk_hash")
      public val chunkHash: ChunkHash,
    )

    /**
     *  * Possible values: UNKNOWN_CHUNK
     */
    @Serializable
    public enum class Name {
      @SerialName("UNKNOWN_CHUNK")
      UNKNOWN_CHUNK,
    }
  }
}
