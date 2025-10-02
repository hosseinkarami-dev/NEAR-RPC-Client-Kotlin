package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * See crate::types::StateChangeCause for details.
 */
@Serializable
public sealed class StateChangeCauseView {
  @Serializable
  public class NotWritableToDisk(
    /**
     *  * Possible values: not_writable_to_disk
     */
    @SerialName("type")
    public val type: Type,
  ) : StateChangeCauseView() {
    /**
     *  * Possible values: not_writable_to_disk
     */
    @Serializable
    public enum class Type {
      @SerialName("not_writable_to_disk")
      NOT_WRITABLE_TO_DISK,
    }
  }

  @Serializable
  public class InitialState(
    /**
     *  * Possible values: initial_state
     */
    @SerialName("type")
    public val type: Type,
  ) : StateChangeCauseView() {
    /**
     *  * Possible values: initial_state
     */
    @Serializable
    public enum class Type {
      @SerialName("initial_state")
      INITIAL_STATE,
    }
  }

  @Serializable
  public class TransactionProcessing(
    @SerialName("tx_hash")
    public val txHash: CryptoHash,
    /**
     *  * Possible values: transaction_processing
     */
    @SerialName("type")
    public val type: Type,
  ) : StateChangeCauseView() {
    /**
     *  * Possible values: transaction_processing
     */
    @Serializable
    public enum class Type {
      @SerialName("transaction_processing")
      TRANSACTION_PROCESSING,
    }
  }

  @Serializable
  public class ActionReceiptProcessingStarted(
    @SerialName("receipt_hash")
    public val receiptHash: CryptoHash,
    /**
     *  * Possible values: action_receipt_processing_started
     */
    @SerialName("type")
    public val type: Type,
  ) : StateChangeCauseView() {
    /**
     *  * Possible values: action_receipt_processing_started
     */
    @Serializable
    public enum class Type {
      @SerialName("action_receipt_processing_started")
      ACTION_RECEIPT_PROCESSING_STARTED,
    }
  }

  @Serializable
  public class ActionReceiptGasReward(
    @SerialName("receipt_hash")
    public val receiptHash: CryptoHash,
    /**
     *  * Possible values: action_receipt_gas_reward
     */
    @SerialName("type")
    public val type: Type,
  ) : StateChangeCauseView() {
    /**
     *  * Possible values: action_receipt_gas_reward
     */
    @Serializable
    public enum class Type {
      @SerialName("action_receipt_gas_reward")
      ACTION_RECEIPT_GAS_REWARD,
    }
  }

  @Serializable
  public class ReceiptProcessing(
    @SerialName("receipt_hash")
    public val receiptHash: CryptoHash,
    /**
     *  * Possible values: receipt_processing
     */
    @SerialName("type")
    public val type: Type,
  ) : StateChangeCauseView() {
    /**
     *  * Possible values: receipt_processing
     */
    @Serializable
    public enum class Type {
      @SerialName("receipt_processing")
      RECEIPT_PROCESSING,
    }
  }

  @Serializable
  public class PostponedReceipt(
    @SerialName("receipt_hash")
    public val receiptHash: CryptoHash,
    /**
     *  * Possible values: postponed_receipt
     */
    @SerialName("type")
    public val type: Type,
  ) : StateChangeCauseView() {
    /**
     *  * Possible values: postponed_receipt
     */
    @Serializable
    public enum class Type {
      @SerialName("postponed_receipt")
      POSTPONED_RECEIPT,
    }
  }

  @Serializable
  public class UpdatedDelayedReceipts(
    /**
     *  * Possible values: updated_delayed_receipts
     */
    @SerialName("type")
    public val type: Type,
  ) : StateChangeCauseView() {
    /**
     *  * Possible values: updated_delayed_receipts
     */
    @Serializable
    public enum class Type {
      @SerialName("updated_delayed_receipts")
      UPDATED_DELAYED_RECEIPTS,
    }
  }

  @Serializable
  public class ValidatorAccountsUpdate(
    /**
     *  * Possible values: validator_accounts_update
     */
    @SerialName("type")
    public val type: Type,
  ) : StateChangeCauseView() {
    /**
     *  * Possible values: validator_accounts_update
     */
    @Serializable
    public enum class Type {
      @SerialName("validator_accounts_update")
      VALIDATOR_ACCOUNTS_UPDATE,
    }
  }

  @Serializable
  public class Migration(
    /**
     *  * Possible values: migration
     */
    @SerialName("type")
    public val type: Type,
  ) : StateChangeCauseView() {
    /**
     *  * Possible values: migration
     */
    @Serializable
    public enum class Type {
      @SerialName("migration")
      MIGRATION,
    }
  }

  @Serializable
  public class BandwidthSchedulerStateUpdate(
    /**
     *  * Possible values: bandwidth_scheduler_state_update
     */
    @SerialName("type")
    public val type: Type,
  ) : StateChangeCauseView() {
    /**
     *  * Possible values: bandwidth_scheduler_state_update
     */
    @Serializable
    public enum class Type {
      @SerialName("bandwidth_scheduler_state_update")
      BANDWIDTH_SCHEDULER_STATE_UPDATE,
    }
  }
}
