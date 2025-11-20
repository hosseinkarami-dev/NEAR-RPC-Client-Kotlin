package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcLightClientNextBlockErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable(with = RpcLightClientNextBlockErrorSerializer::class)
public sealed class RpcLightClientNextBlockError {
  @Serializable
  public data class InternalError(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: INTERNAL_ERROR
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcLightClientNextBlockError() {
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
  ) : RpcLightClientNextBlockError() {
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
  public data class EpochOutOfBounds(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: EPOCH_OUT_OF_BOUNDS
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcLightClientNextBlockError() {
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
}
