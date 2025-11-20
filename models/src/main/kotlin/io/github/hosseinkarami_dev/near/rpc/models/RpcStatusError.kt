package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcStatusErrorSerializer
import kotlin.String
import kotlin.ULong
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = RpcStatusErrorSerializer::class)
public sealed class RpcStatusError {
  @Serializable
  public data class NodeIsSyncing(
    /**
     *  * Possible values: NODE_IS_SYNCING
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcStatusError() {
    /**
     *  * Possible values: NODE_IS_SYNCING
     */
    @Serializable
    public enum class Name {
      @SerialName("NODE_IS_SYNCING")
      NODE_IS_SYNCING,
    }
  }

  @Serializable
  public data class NoNewBlocks(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: NO_NEW_BLOCKS
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcStatusError() {
    @Serializable
    public data class InfoPayload(
      /**
       *  * Min Items: 2
       *  * Max Items: 2
       */
      @SerialName("elapsed")
      public val elapsed: List<ULong>,
    ) {
      init {
        require((elapsed?.size ?: 0) >= 2) { "InfoPayload.elapsed must contain at least 2 items (minItems = 2)" }}
      init {
        require((elapsed?.size ?: 0) <= 2) { "InfoPayload.elapsed must contain no more than 2 items (maxItems = 2)" }}
    }

    /**
     *  * Possible values: NO_NEW_BLOCKS
     */
    @Serializable
    public enum class Name {
      @SerialName("NO_NEW_BLOCKS")
      NO_NEW_BLOCKS,
    }
  }

  @Serializable
  public data class EpochOutOfBounds(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: EPOCH_OUT_OF_BOUNDS
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcStatusError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("epoch_id")
      public val epochId: EpochId,
    )

    /**
     *  * Possible values: EPOCH_OUT_OF_BOUNDS
     */
    @Serializable
    public enum class Name {
      @SerialName("EPOCH_OUT_OF_BOUNDS")
      EPOCH_OUT_OF_BOUNDS,
    }
  }

  @Serializable
  public data class InternalError(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: INTERNAL_ERROR
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcStatusError() {
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
}
