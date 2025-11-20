package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcTransactionErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable(with = RpcTransactionErrorSerializer::class)
public sealed class RpcTransactionError {
  @Serializable
  public data class InvalidTransaction(
    @SerialName("info")
    public val info: JsonElement,
    /**
     *  * Possible values: INVALID_TRANSACTION
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcTransactionError() {
    /**
     *  * Possible values: INVALID_TRANSACTION
     */
    @Serializable
    public enum class Name {
      @SerialName("INVALID_TRANSACTION")
      INVALID_TRANSACTION,
    }
  }

  @Serializable
  public data class DoesNotTrackShard(
    /**
     *  * Possible values: DOES_NOT_TRACK_SHARD
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcTransactionError() {
    /**
     *  * Possible values: DOES_NOT_TRACK_SHARD
     */
    @Serializable
    public enum class Name {
      @SerialName("DOES_NOT_TRACK_SHARD")
      DOES_NOT_TRACK_SHARD,
    }
  }

  @Serializable
  public data class RequestRouted(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: REQUEST_ROUTED
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcTransactionError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("transaction_hash")
      public val transactionHash: CryptoHash,
    )

    /**
     *  * Possible values: REQUEST_ROUTED
     */
    @Serializable
    public enum class Name {
      @SerialName("REQUEST_ROUTED")
      REQUEST_ROUTED,
    }
  }

  @Serializable
  public data class UnknownTransaction(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: UNKNOWN_TRANSACTION
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcTransactionError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("requested_transaction_hash")
      public val requestedTransactionHash: CryptoHash,
    )

    /**
     *  * Possible values: UNKNOWN_TRANSACTION
     */
    @Serializable
    public enum class Name {
      @SerialName("UNKNOWN_TRANSACTION")
      UNKNOWN_TRANSACTION,
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
  ) : RpcTransactionError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("debug_info")
      public val debugInfo: String,
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
  public data class TimeoutError(
    /**
     *  * Possible values: TIMEOUT_ERROR
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcTransactionError() {
    /**
     *  * Possible values: TIMEOUT_ERROR
     */
    @Serializable
    public enum class Name {
      @SerialName("TIMEOUT_ERROR")
      TIMEOUT_ERROR,
    }
  }
}
