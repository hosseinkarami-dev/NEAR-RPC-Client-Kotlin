package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcLightClientProofErrorSerializer
import kotlin.String
import kotlin.UInt
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable(with = RpcLightClientProofErrorSerializer::class)
public sealed class RpcLightClientProofError {
  @Serializable
  public data class UnknownBlock(
    @SerialName("info")
    public val info: JsonElement,
    /**
     *  * Possible values: UNKNOWN_BLOCK
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcLightClientProofError() {
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
  public data class InconsistentState(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: INCONSISTENT_STATE
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcLightClientProofError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("execution_outcome_shard_id")
      public val executionOutcomeShardId: ShardId,
      /**
       *  * Minimum: 0.0
       *  * Format: uint
       */
      @SerialName("number_or_shards")
      public val numberOrShards: UInt,
    )

    /**
     *  * Possible values: INCONSISTENT_STATE
     */
    @Serializable
    public enum class Name {
      @SerialName("INCONSISTENT_STATE")
      INCONSISTENT_STATE,
    }
  }

  @Serializable
  public data class NotConfirmed(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: NOT_CONFIRMED
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcLightClientProofError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("transaction_or_receipt_id")
      public val transactionOrReceiptId: CryptoHash,
    )

    /**
     *  * Possible values: NOT_CONFIRMED
     */
    @Serializable
    public enum class Name {
      @SerialName("NOT_CONFIRMED")
      NOT_CONFIRMED,
    }
  }

  @Serializable
  public data class UnknownTransactionOrReceipt(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: UNKNOWN_TRANSACTION_OR_RECEIPT
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcLightClientProofError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("transaction_or_receipt_id")
      public val transactionOrReceiptId: CryptoHash,
    )

    /**
     *  * Possible values: UNKNOWN_TRANSACTION_OR_RECEIPT
     */
    @Serializable
    public enum class Name {
      @SerialName("UNKNOWN_TRANSACTION_OR_RECEIPT")
      UNKNOWN_TRANSACTION_OR_RECEIPT,
    }
  }

  @Serializable
  public data class UnavailableShard(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: UNAVAILABLE_SHARD
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcLightClientProofError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("shard_id")
      public val shardId: ShardId,
      @SerialName("transaction_or_receipt_id")
      public val transactionOrReceiptId: CryptoHash,
    )

    /**
     *  * Possible values: UNAVAILABLE_SHARD
     */
    @Serializable
    public enum class Name {
      @SerialName("UNAVAILABLE_SHARD")
      UNAVAILABLE_SHARD,
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
  ) : RpcLightClientProofError() {
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
