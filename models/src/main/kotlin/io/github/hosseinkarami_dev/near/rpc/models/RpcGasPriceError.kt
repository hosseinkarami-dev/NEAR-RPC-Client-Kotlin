package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcGasPriceErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable(with = RpcGasPriceErrorSerializer::class)
public sealed class RpcGasPriceError {
  @Serializable
  public data class InternalError(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: INTERNAL_ERROR
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcGasPriceError() {
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
  ) : RpcGasPriceError() {
    /**
     *  * Possible values: UNKNOWN_BLOCK
     */
    @Serializable
    public enum class Name {
      @SerialName("UNKNOWN_BLOCK")
      UNKNOWN_BLOCK,
    }
  }
}
