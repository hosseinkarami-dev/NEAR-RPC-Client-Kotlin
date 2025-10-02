package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * An error happened during TX execution
 */
@Serializable
public sealed class InvalidTxError {
  /**
   *  * Happens if a wrong AccessKey used or AccessKey has not enough permissions
   */
  @Serializable
  public class InvalidAccessKeyError(
    @SerialName("InvalidAccessKeyError")
    public val invalidAccessKeyError:
        io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError,
  ) : InvalidTxError()

  /**
   *  * TX signer_id is not a valid [`AccountId`]
   */
  @Serializable
  public class InvalidSignerId(
    @SerialName("InvalidSignerId")
    public val invalidSignerId: InvalidSignerIdPayload,
  ) : InvalidTxError() {
    @Serializable
    public data class InvalidSignerIdPayload(
      @SerialName("signer_id")
      public val signerId: String,
    )
  }

  /**
   *  * TX signer_id is not found in a storage
   */
  @Serializable
  public class SignerDoesNotExist(
    @SerialName("SignerDoesNotExist")
    public val signerDoesNotExist: SignerDoesNotExistPayload,
  ) : InvalidTxError() {
    @Serializable
    public data class SignerDoesNotExistPayload(
      @SerialName("signer_id")
      public val signerId: AccountId,
    )
  }

  /**
   *  * Transaction nonce must be strictly greater than `account[access_key].nonce`.
   */
  @Serializable
  public class InvalidNonce(
    @SerialName("InvalidNonce")
    public val invalidNonce: InvalidNoncePayload,
  ) : InvalidTxError() {
    @Serializable
    public data class InvalidNoncePayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("ak_nonce")
      public val akNonce: Long,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("tx_nonce")
      public val txNonce: Long,
    )
  }

  /**
   *  * Transaction nonce is larger than the upper bound given by the block height
   */
  @Serializable
  public class NonceTooLarge(
    @SerialName("NonceTooLarge")
    public val nonceTooLarge: NonceTooLargePayload,
  ) : InvalidTxError() {
    @Serializable
    public data class NonceTooLargePayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("tx_nonce")
      public val txNonce: Long,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("upper_bound")
      public val upperBound: Long,
    )
  }

  /**
   *  * TX receiver_id is not a valid AccountId
   */
  @Serializable
  public class InvalidReceiverId(
    @SerialName("InvalidReceiverId")
    public val invalidReceiverId: InvalidReceiverIdPayload,
  ) : InvalidTxError() {
    @Serializable
    public data class InvalidReceiverIdPayload(
      @SerialName("receiver_id")
      public val receiverId: String,
    )
  }

  /**
   *  * TX signature is not valid
   *  * Possible values: InvalidSignature
   */
  @Serializable
  @SerialName("InvalidSignature")
  public object InvalidSignature : InvalidTxError()

  /**
   *  * Account does not have enough balance to cover TX cost
   */
  @Serializable
  public class NotEnoughBalance(
    @SerialName("NotEnoughBalance")
    public val notEnoughBalance: NotEnoughBalancePayload,
  ) : InvalidTxError() {
    @Serializable
    public data class NotEnoughBalancePayload(
      @SerialName("balance")
      public val balance: NearToken,
      @SerialName("cost")
      public val cost: NearToken,
      @SerialName("signer_id")
      public val signerId: AccountId,
    )
  }

  /**
   *  * Signer account doesn't have enough balance after transaction.
   */
  @Serializable
  public class LackBalanceForState(
    @SerialName("LackBalanceForState")
    public val lackBalanceForState: LackBalanceForStatePayload,
  ) : InvalidTxError() {
    @Serializable
    public data class LackBalanceForStatePayload(
      /**
       *  * Required balance to cover the state.
       */
      @SerialName("amount")
      public val amount: NearToken,
      /**
       *  * An account which doesn't have enough balance to cover storage.
       */
      @SerialName("signer_id")
      public val signerId: AccountId,
    )
  }

  /**
   *  * An integer overflow occurred during transaction cost estimation.
   *  * Possible values: CostOverflow
   */
  @Serializable
  @SerialName("CostOverflow")
  public object CostOverflow : InvalidTxError()

  /**
   *  * Transaction parent block hash doesn't belong to the current chain
   *  * Possible values: InvalidChain
   */
  @Serializable
  @SerialName("InvalidChain")
  public object InvalidChain : InvalidTxError()

  /**
   *  * Transaction has expired
   *  * Possible values: Expired
   */
  @Serializable
  @SerialName("Expired")
  public object Expired : InvalidTxError()

  /**
   *  * An error occurred while validating actions of a Transaction.
   */
  @Serializable
  public class ActionsValidation(
    @SerialName("ActionsValidation")
    public val actionsValidation: ActionsValidationError,
  ) : InvalidTxError()

  /**
   *  * The size of serialized transaction exceeded the limit.
   */
  @Serializable
  public class TransactionSizeExceeded(
    @SerialName("TransactionSizeExceeded")
    public val transactionSizeExceeded: TransactionSizeExceededPayload,
  ) : InvalidTxError() {
    @Serializable
    public data class TransactionSizeExceededPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("limit")
      public val limit: Long,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("size")
      public val size: Long,
    )
  }

  /**
   *  * Transaction version is invalid.
   *  * Possible values: InvalidTransactionVersion
   */
  @Serializable
  @SerialName("InvalidTransactionVersion")
  public object InvalidTransactionVersion : InvalidTxError()

  @Serializable
  public class StorageError(
    @SerialName("StorageError")
    public val storageError: io.github.hosseinkarami_dev.near.rpc.models.StorageError,
  ) : InvalidTxError()

  /**
   *  * The receiver shard of the transaction is too congested to accept new
   * transactions at the moment.
   */
  @Serializable
  public class ShardCongested(
    @SerialName("ShardCongested")
    public val shardCongested: ShardCongestedPayload,
  ) : InvalidTxError() {
    @Serializable
    public data class ShardCongestedPayload(
      /**
       *  * A value between 0 (no congestion) and 1 (max congestion).
       *  * Format: double
       */
      @SerialName("congestion_level")
      public val congestionLevel: Double,
      /**
       *  * The congested shard.
       *  * Minimum: 0.0
       *  * Format: uint32
       */
      @SerialName("shard_id")
      public val shardId: Int,
    )
  }

  /**
   *  * The receiver shard of the transaction missed several chunks and rejects
   * new transaction until it can make progress again.
   */
  @Serializable
  public class ShardStuck(
    @SerialName("ShardStuck")
    public val shardStuck: ShardStuckPayload,
  ) : InvalidTxError() {
    @Serializable
    public data class ShardStuckPayload(
      /**
       *  * The number of blocks since the last included chunk of the shard.
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("missed_chunks")
      public val missedChunks: Long,
      /**
       *  * The shard that fails making progress.
       *  * Minimum: 0.0
       *  * Format: uint32
       */
      @SerialName("shard_id")
      public val shardId: Int,
    )
  }
}
