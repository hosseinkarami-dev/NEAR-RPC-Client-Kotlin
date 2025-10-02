package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class InvalidTxError {
  @Serializable
  public class InvalidAccessKeyError(
    @SerialName("InvalidAccessKeyError")
    public val invalidAccessKeyError:
        io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError,
  ) : InvalidTxError()

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

  @Serializable
  public class InvalidNonce(
    @SerialName("InvalidNonce")
    public val invalidNonce: InvalidNoncePayload,
  ) : InvalidTxError() {
    @Serializable
    public data class InvalidNoncePayload(
      @SerialName("ak_nonce")
      public val akNonce: Long,
      @SerialName("tx_nonce")
      public val txNonce: Long,
    )
  }

  @Serializable
  public class NonceTooLarge(
    @SerialName("NonceTooLarge")
    public val nonceTooLarge: NonceTooLargePayload,
  ) : InvalidTxError() {
    @Serializable
    public data class NonceTooLargePayload(
      @SerialName("tx_nonce")
      public val txNonce: Long,
      @SerialName("upper_bound")
      public val upperBound: Long,
    )
  }

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

  @Serializable
  @SerialName("InvalidSignature")
  public object InvalidSignature : InvalidTxError()

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

  @Serializable
  public class LackBalanceForState(
    @SerialName("LackBalanceForState")
    public val lackBalanceForState: LackBalanceForStatePayload,
  ) : InvalidTxError() {
    @Serializable
    public data class LackBalanceForStatePayload(
      @SerialName("amount")
      public val amount: NearToken,
      @SerialName("signer_id")
      public val signerId: AccountId,
    )
  }

  @Serializable
  @SerialName("CostOverflow")
  public object CostOverflow : InvalidTxError()

  @Serializable
  @SerialName("InvalidChain")
  public object InvalidChain : InvalidTxError()

  @Serializable
  @SerialName("Expired")
  public object Expired : InvalidTxError()

  @Serializable
  public class ActionsValidation(
    @SerialName("ActionsValidation")
    public val actionsValidation: ActionsValidationError,
  ) : InvalidTxError()

  @Serializable
  public class TransactionSizeExceeded(
    @SerialName("TransactionSizeExceeded")
    public val transactionSizeExceeded: TransactionSizeExceededPayload,
  ) : InvalidTxError() {
    @Serializable
    public data class TransactionSizeExceededPayload(
      @SerialName("limit")
      public val limit: Long,
      @SerialName("size")
      public val size: Long,
    )
  }

  @Serializable
  @SerialName("InvalidTransactionVersion")
  public object InvalidTransactionVersion : InvalidTxError()

  @Serializable
  public class StorageError(
    @SerialName("StorageError")
    public val storageError: io.github.hosseinkarami_dev.near.rpc.models.StorageError,
  ) : InvalidTxError()

  @Serializable
  public class ShardCongested(
    @SerialName("ShardCongested")
    public val shardCongested: ShardCongestedPayload,
  ) : InvalidTxError() {
    @Serializable
    public data class ShardCongestedPayload(
      @SerialName("congestion_level")
      public val congestionLevel: Double,
      @SerialName("shard_id")
      public val shardId: Int,
    )
  }

  @Serializable
  public class ShardStuck(
    @SerialName("ShardStuck")
    public val shardStuck: ShardStuckPayload,
  ) : InvalidTxError() {
    @Serializable
    public data class ShardStuckPayload(
      @SerialName("missed_chunks")
      public val missedChunks: Long,
      @SerialName("shard_id")
      public val shardId: Int,
    )
  }
}
