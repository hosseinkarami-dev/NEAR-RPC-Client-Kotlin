package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * It is a [serializable view] of [`StateChangesRequest`].
 *
 * [serializable view]: ./index.html
 * [`StateChangesRequest`]: ../types/struct.StateChangesRequest.html
 */
@Serializable
public sealed class RpcStateChangesInBlockByTypeRequest {
  @Serializable
  public class AccountChangesByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    @SerialName("account_ids")
    public val accountIds: List<AccountId>,
    /**
     *  * Possible values: account_changes
     */
    @SerialName("changes_type")
    public val changesType: ChangesType,
  ) : RpcStateChangesInBlockByTypeRequest() {
    /**
     *  * Possible values: account_changes
     */
    @Serializable
    public enum class ChangesType {
      @SerialName("account_changes")
      ACCOUNT_CHANGES,
    }
  }

  @Serializable
  public class SingleAccessKeyChangesByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    /**
     *  * Possible values: single_access_key_changes
     */
    @SerialName("changes_type")
    public val changesType: ChangesType,
    @SerialName("keys")
    public val keys: List<AccountWithPublicKey>,
  ) : RpcStateChangesInBlockByTypeRequest() {
    /**
     *  * Possible values: single_access_key_changes
     */
    @Serializable
    public enum class ChangesType {
      @SerialName("single_access_key_changes")
      SINGLE_ACCESS_KEY_CHANGES,
    }
  }

  @Serializable
  public class SingleGasKeyChangesByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    /**
     *  * Possible values: single_gas_key_changes
     */
    @SerialName("changes_type")
    public val changesType: ChangesType,
    @SerialName("keys")
    public val keys: List<AccountWithPublicKey>,
  ) : RpcStateChangesInBlockByTypeRequest() {
    /**
     *  * Possible values: single_gas_key_changes
     */
    @Serializable
    public enum class ChangesType {
      @SerialName("single_gas_key_changes")
      SINGLE_GAS_KEY_CHANGES,
    }
  }

  @Serializable
  public class AllAccessKeyChangesByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    @SerialName("account_ids")
    public val accountIds: List<AccountId>,
    /**
     *  * Possible values: all_access_key_changes
     */
    @SerialName("changes_type")
    public val changesType: ChangesType,
  ) : RpcStateChangesInBlockByTypeRequest() {
    /**
     *  * Possible values: all_access_key_changes
     */
    @Serializable
    public enum class ChangesType {
      @SerialName("all_access_key_changes")
      ALL_ACCESS_KEY_CHANGES,
    }
  }

  @Serializable
  public class AllGasKeyChangesByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    @SerialName("account_ids")
    public val accountIds: List<AccountId>,
    /**
     *  * Possible values: all_gas_key_changes
     */
    @SerialName("changes_type")
    public val changesType: ChangesType,
  ) : RpcStateChangesInBlockByTypeRequest() {
    /**
     *  * Possible values: all_gas_key_changes
     */
    @Serializable
    public enum class ChangesType {
      @SerialName("all_gas_key_changes")
      ALL_GAS_KEY_CHANGES,
    }
  }

  @Serializable
  public class ContractCodeChangesByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    @SerialName("account_ids")
    public val accountIds: List<AccountId>,
    /**
     *  * Possible values: contract_code_changes
     */
    @SerialName("changes_type")
    public val changesType: ChangesType,
  ) : RpcStateChangesInBlockByTypeRequest() {
    /**
     *  * Possible values: contract_code_changes
     */
    @Serializable
    public enum class ChangesType {
      @SerialName("contract_code_changes")
      CONTRACT_CODE_CHANGES,
    }
  }

  @Serializable
  public class DataChangesByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    @SerialName("account_ids")
    public val accountIds: List<AccountId>,
    /**
     *  * Possible values: data_changes
     */
    @SerialName("changes_type")
    public val changesType: ChangesType,
    @SerialName("key_prefix_base64")
    public val keyPrefixBase64: StoreKey,
  ) : RpcStateChangesInBlockByTypeRequest() {
    /**
     *  * Possible values: data_changes
     */
    @Serializable
    public enum class ChangesType {
      @SerialName("data_changes")
      DATA_CHANGES,
    }
  }

  @Serializable
  public class AccountChangesByFinality(
    @SerialName("finality")
    public val finality: Finality,
    @SerialName("account_ids")
    public val accountIds: List<AccountId>,
    /**
     *  * Possible values: account_changes
     */
    @SerialName("changes_type")
    public val changesType: ChangesType,
  ) : RpcStateChangesInBlockByTypeRequest() {
    /**
     *  * Possible values: account_changes
     */
    @Serializable
    public enum class ChangesType {
      @SerialName("account_changes")
      ACCOUNT_CHANGES,
    }
  }

  @Serializable
  public class SingleAccessKeyChangesByFinality(
    @SerialName("finality")
    public val finality: Finality,
    /**
     *  * Possible values: single_access_key_changes
     */
    @SerialName("changes_type")
    public val changesType: ChangesType,
    @SerialName("keys")
    public val keys: List<AccountWithPublicKey>,
  ) : RpcStateChangesInBlockByTypeRequest() {
    /**
     *  * Possible values: single_access_key_changes
     */
    @Serializable
    public enum class ChangesType {
      @SerialName("single_access_key_changes")
      SINGLE_ACCESS_KEY_CHANGES,
    }
  }

  @Serializable
  public class SingleGasKeyChangesByFinality(
    @SerialName("finality")
    public val finality: Finality,
    /**
     *  * Possible values: single_gas_key_changes
     */
    @SerialName("changes_type")
    public val changesType: ChangesType,
    @SerialName("keys")
    public val keys: List<AccountWithPublicKey>,
  ) : RpcStateChangesInBlockByTypeRequest() {
    /**
     *  * Possible values: single_gas_key_changes
     */
    @Serializable
    public enum class ChangesType {
      @SerialName("single_gas_key_changes")
      SINGLE_GAS_KEY_CHANGES,
    }
  }

  @Serializable
  public class AllAccessKeyChangesByFinality(
    @SerialName("finality")
    public val finality: Finality,
    @SerialName("account_ids")
    public val accountIds: List<AccountId>,
    /**
     *  * Possible values: all_access_key_changes
     */
    @SerialName("changes_type")
    public val changesType: ChangesType,
  ) : RpcStateChangesInBlockByTypeRequest() {
    /**
     *  * Possible values: all_access_key_changes
     */
    @Serializable
    public enum class ChangesType {
      @SerialName("all_access_key_changes")
      ALL_ACCESS_KEY_CHANGES,
    }
  }

  @Serializable
  public class AllGasKeyChangesByFinality(
    @SerialName("finality")
    public val finality: Finality,
    @SerialName("account_ids")
    public val accountIds: List<AccountId>,
    /**
     *  * Possible values: all_gas_key_changes
     */
    @SerialName("changes_type")
    public val changesType: ChangesType,
  ) : RpcStateChangesInBlockByTypeRequest() {
    /**
     *  * Possible values: all_gas_key_changes
     */
    @Serializable
    public enum class ChangesType {
      @SerialName("all_gas_key_changes")
      ALL_GAS_KEY_CHANGES,
    }
  }

  @Serializable
  public class ContractCodeChangesByFinality(
    @SerialName("finality")
    public val finality: Finality,
    @SerialName("account_ids")
    public val accountIds: List<AccountId>,
    /**
     *  * Possible values: contract_code_changes
     */
    @SerialName("changes_type")
    public val changesType: ChangesType,
  ) : RpcStateChangesInBlockByTypeRequest() {
    /**
     *  * Possible values: contract_code_changes
     */
    @Serializable
    public enum class ChangesType {
      @SerialName("contract_code_changes")
      CONTRACT_CODE_CHANGES,
    }
  }

  @Serializable
  public class DataChangesByFinality(
    @SerialName("finality")
    public val finality: Finality,
    @SerialName("account_ids")
    public val accountIds: List<AccountId>,
    /**
     *  * Possible values: data_changes
     */
    @SerialName("changes_type")
    public val changesType: ChangesType,
    @SerialName("key_prefix_base64")
    public val keyPrefixBase64: StoreKey,
  ) : RpcStateChangesInBlockByTypeRequest() {
    /**
     *  * Possible values: data_changes
     */
    @Serializable
    public enum class ChangesType {
      @SerialName("data_changes")
      DATA_CHANGES,
    }
  }

  @Serializable
  public class AccountChangesBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    @SerialName("account_ids")
    public val accountIds: List<AccountId>,
    /**
     *  * Possible values: account_changes
     */
    @SerialName("changes_type")
    public val changesType: ChangesType,
  ) : RpcStateChangesInBlockByTypeRequest() {
    /**
     *  * Possible values: account_changes
     */
    @Serializable
    public enum class ChangesType {
      @SerialName("account_changes")
      ACCOUNT_CHANGES,
    }
  }

  @Serializable
  public class SingleAccessKeyChangesBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    /**
     *  * Possible values: single_access_key_changes
     */
    @SerialName("changes_type")
    public val changesType: ChangesType,
    @SerialName("keys")
    public val keys: List<AccountWithPublicKey>,
  ) : RpcStateChangesInBlockByTypeRequest() {
    /**
     *  * Possible values: single_access_key_changes
     */
    @Serializable
    public enum class ChangesType {
      @SerialName("single_access_key_changes")
      SINGLE_ACCESS_KEY_CHANGES,
    }
  }

  @Serializable
  public class SingleGasKeyChangesBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    /**
     *  * Possible values: single_gas_key_changes
     */
    @SerialName("changes_type")
    public val changesType: ChangesType,
    @SerialName("keys")
    public val keys: List<AccountWithPublicKey>,
  ) : RpcStateChangesInBlockByTypeRequest() {
    /**
     *  * Possible values: single_gas_key_changes
     */
    @Serializable
    public enum class ChangesType {
      @SerialName("single_gas_key_changes")
      SINGLE_GAS_KEY_CHANGES,
    }
  }

  @Serializable
  public class AllAccessKeyChangesBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    @SerialName("account_ids")
    public val accountIds: List<AccountId>,
    /**
     *  * Possible values: all_access_key_changes
     */
    @SerialName("changes_type")
    public val changesType: ChangesType,
  ) : RpcStateChangesInBlockByTypeRequest() {
    /**
     *  * Possible values: all_access_key_changes
     */
    @Serializable
    public enum class ChangesType {
      @SerialName("all_access_key_changes")
      ALL_ACCESS_KEY_CHANGES,
    }
  }

  @Serializable
  public class AllGasKeyChangesBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    @SerialName("account_ids")
    public val accountIds: List<AccountId>,
    /**
     *  * Possible values: all_gas_key_changes
     */
    @SerialName("changes_type")
    public val changesType: ChangesType,
  ) : RpcStateChangesInBlockByTypeRequest() {
    /**
     *  * Possible values: all_gas_key_changes
     */
    @Serializable
    public enum class ChangesType {
      @SerialName("all_gas_key_changes")
      ALL_GAS_KEY_CHANGES,
    }
  }

  @Serializable
  public class ContractCodeChangesBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    @SerialName("account_ids")
    public val accountIds: List<AccountId>,
    /**
     *  * Possible values: contract_code_changes
     */
    @SerialName("changes_type")
    public val changesType: ChangesType,
  ) : RpcStateChangesInBlockByTypeRequest() {
    /**
     *  * Possible values: contract_code_changes
     */
    @Serializable
    public enum class ChangesType {
      @SerialName("contract_code_changes")
      CONTRACT_CODE_CHANGES,
    }
  }

  @Serializable
  public class DataChangesBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    @SerialName("account_ids")
    public val accountIds: List<AccountId>,
    /**
     *  * Possible values: data_changes
     */
    @SerialName("changes_type")
    public val changesType: ChangesType,
    @SerialName("key_prefix_base64")
    public val keyPrefixBase64: StoreKey,
  ) : RpcStateChangesInBlockByTypeRequest() {
    /**
     *  * Possible values: data_changes
     */
    @Serializable
    public enum class ChangesType {
      @SerialName("data_changes")
      DATA_CHANGES,
    }
  }
}
