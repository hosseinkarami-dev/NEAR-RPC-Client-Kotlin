package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class StateChangeCauseView {
  @Serializable
  public class NotWritableToDisk(
    @SerialName("type")
    public val type: Type,
  ) : StateChangeCauseView() {
    @Serializable
    public enum class Type {
      @SerialName("not_writable_to_disk")
      NOT_WRITABLE_TO_DISK,
    }
  }

  @Serializable
  public class InitialState(
    @SerialName("type")
    public val type: Type,
  ) : StateChangeCauseView() {
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
    @SerialName("type")
    public val type: Type,
  ) : StateChangeCauseView() {
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
    @SerialName("type")
    public val type: Type,
  ) : StateChangeCauseView() {
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
    @SerialName("type")
    public val type: Type,
  ) : StateChangeCauseView() {
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
    @SerialName("type")
    public val type: Type,
  ) : StateChangeCauseView() {
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
    @SerialName("type")
    public val type: Type,
  ) : StateChangeCauseView() {
    @Serializable
    public enum class Type {
      @SerialName("postponed_receipt")
      POSTPONED_RECEIPT,
    }
  }

  @Serializable
  public class UpdatedDelayedReceipts(
    @SerialName("type")
    public val type: Type,
  ) : StateChangeCauseView() {
    @Serializable
    public enum class Type {
      @SerialName("updated_delayed_receipts")
      UPDATED_DELAYED_RECEIPTS,
    }
  }

  @Serializable
  public class ValidatorAccountsUpdate(
    @SerialName("type")
    public val type: Type,
  ) : StateChangeCauseView() {
    @Serializable
    public enum class Type {
      @SerialName("validator_accounts_update")
      VALIDATOR_ACCOUNTS_UPDATE,
    }
  }

  @Serializable
  public class Migration(
    @SerialName("type")
    public val type: Type,
  ) : StateChangeCauseView() {
    @Serializable
    public enum class Type {
      @SerialName("migration")
      MIGRATION,
    }
  }

  @Serializable
  public class BandwidthSchedulerStateUpdate(
    @SerialName("type")
    public val type: Type,
  ) : StateChangeCauseView() {
    @Serializable
    public enum class Type {
      @SerialName("bandwidth_scheduler_state_update")
      BANDWIDTH_SCHEDULER_STATE_UPDATE,
    }
  }
}
