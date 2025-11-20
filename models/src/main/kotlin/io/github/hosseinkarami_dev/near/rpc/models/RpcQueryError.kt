package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcQueryErrorSerializer
import kotlin.String
import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = RpcQueryErrorSerializer::class)
public sealed class RpcQueryError {
  @Serializable
  public data class NoSyncedBlocks(
    /**
     *  * Possible values: NO_SYNCED_BLOCKS
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcQueryError() {
    /**
     *  * Possible values: NO_SYNCED_BLOCKS
     */
    @Serializable
    public enum class Name {
      @SerialName("NO_SYNCED_BLOCKS")
      NO_SYNCED_BLOCKS,
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
  ) : RpcQueryError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("requested_shard_id")
      public val requestedShardId: ShardId,
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
  public data class GarbageCollectedBlock(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: GARBAGE_COLLECTED_BLOCK
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcQueryError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("block_hash")
      public val blockHash: CryptoHash,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("block_height")
      public val blockHeight: ULong,
    )

    /**
     *  * Possible values: GARBAGE_COLLECTED_BLOCK
     */
    @Serializable
    public enum class Name {
      @SerialName("GARBAGE_COLLECTED_BLOCK")
      GARBAGE_COLLECTED_BLOCK,
    }
  }

  @Serializable
  public data class UnknownBlock(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: UNKNOWN_BLOCK
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcQueryError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("block_reference")
      public val blockReference: BlockReference,
    )

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
  public data class InvalidAccount(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: INVALID_ACCOUNT
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcQueryError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("block_hash")
      public val blockHash: CryptoHash,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("block_height")
      public val blockHeight: ULong,
      @SerialName("requested_account_id")
      public val requestedAccountId: AccountId,
    )

    /**
     *  * Possible values: INVALID_ACCOUNT
     */
    @Serializable
    public enum class Name {
      @SerialName("INVALID_ACCOUNT")
      INVALID_ACCOUNT,
    }
  }

  @Serializable
  public data class UnknownAccount(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: UNKNOWN_ACCOUNT
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcQueryError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("block_hash")
      public val blockHash: CryptoHash,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("block_height")
      public val blockHeight: ULong,
      @SerialName("requested_account_id")
      public val requestedAccountId: AccountId,
    )

    /**
     *  * Possible values: UNKNOWN_ACCOUNT
     */
    @Serializable
    public enum class Name {
      @SerialName("UNKNOWN_ACCOUNT")
      UNKNOWN_ACCOUNT,
    }
  }

  @Serializable
  public data class NoContractCode(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: NO_CONTRACT_CODE
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcQueryError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("block_hash")
      public val blockHash: CryptoHash,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("block_height")
      public val blockHeight: ULong,
      @SerialName("contract_account_id")
      public val contractAccountId: AccountId,
    )

    /**
     *  * Possible values: NO_CONTRACT_CODE
     */
    @Serializable
    public enum class Name {
      @SerialName("NO_CONTRACT_CODE")
      NO_CONTRACT_CODE,
    }
  }

  @Serializable
  public data class TooLargeContractState(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: TOO_LARGE_CONTRACT_STATE
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcQueryError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("block_hash")
      public val blockHash: CryptoHash,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("block_height")
      public val blockHeight: ULong,
      @SerialName("contract_account_id")
      public val contractAccountId: AccountId,
    )

    /**
     *  * Possible values: TOO_LARGE_CONTRACT_STATE
     */
    @Serializable
    public enum class Name {
      @SerialName("TOO_LARGE_CONTRACT_STATE")
      TOO_LARGE_CONTRACT_STATE,
    }
  }

  @Serializable
  public data class UnknownAccessKey(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: UNKNOWN_ACCESS_KEY
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcQueryError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("block_hash")
      public val blockHash: CryptoHash,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("block_height")
      public val blockHeight: ULong,
      @SerialName("public_key")
      public val publicKey: PublicKey,
    )

    /**
     *  * Possible values: UNKNOWN_ACCESS_KEY
     */
    @Serializable
    public enum class Name {
      @SerialName("UNKNOWN_ACCESS_KEY")
      UNKNOWN_ACCESS_KEY,
    }
  }

  @Serializable
  public data class UnknownGasKey(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: UNKNOWN_GAS_KEY
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcQueryError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("block_hash")
      public val blockHash: CryptoHash,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("block_height")
      public val blockHeight: ULong,
      @SerialName("public_key")
      public val publicKey: PublicKey,
    )

    /**
     *  * Possible values: UNKNOWN_GAS_KEY
     */
    @Serializable
    public enum class Name {
      @SerialName("UNKNOWN_GAS_KEY")
      UNKNOWN_GAS_KEY,
    }
  }

  @Serializable
  public data class ContractExecutionError(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: CONTRACT_EXECUTION_ERROR
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcQueryError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("block_hash")
      public val blockHash: CryptoHash,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("block_height")
      public val blockHeight: ULong,
      @SerialName("vm_error")
      public val vmError: String,
    )

    /**
     *  * Possible values: CONTRACT_EXECUTION_ERROR
     */
    @Serializable
    public enum class Name {
      @SerialName("CONTRACT_EXECUTION_ERROR")
      CONTRACT_EXECUTION_ERROR,
    }
  }

  @Serializable
  public data class NoGlobalContractCode(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: NO_GLOBAL_CONTRACT_CODE
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcQueryError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("block_hash")
      public val blockHash: CryptoHash,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("block_height")
      public val blockHeight: ULong,
      @SerialName("identifier")
      public val identifier: GlobalContractIdentifier,
    )

    /**
     *  * Possible values: NO_GLOBAL_CONTRACT_CODE
     */
    @Serializable
    public enum class Name {
      @SerialName("NO_GLOBAL_CONTRACT_CODE")
      NO_GLOBAL_CONTRACT_CODE,
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
  ) : RpcQueryError() {
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
