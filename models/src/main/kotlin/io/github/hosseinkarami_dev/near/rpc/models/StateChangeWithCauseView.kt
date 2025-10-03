package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class StateChangeWithCauseView {
  @Serializable
  public data class AccountUpdate(
    /**
     *  * A view of the account
     */
    @SerialName("change")
    public val change: ChangePayload,
    /**
     *  * Possible values: account_update
     */
    @SerialName("type")
    public val type: Type,
    @SerialName("cause")
    public val cause: StateChangeCauseView,
  ) : StateChangeWithCauseView() {
    /**
     *  * A view of the account
     */
    @Serializable
    public data class ChangePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("amount")
      public val amount: NearToken,
      @SerialName("code_hash")
      public val codeHash: CryptoHash,
      @SerialName("global_contract_account_id")
      public val globalContractAccountId: AccountId? = null,
      @SerialName("global_contract_hash")
      public val globalContractHash: CryptoHash? = null,
      @SerialName("locked")
      public val locked: NearToken,
      /**
       *  * TODO(2271): deprecated.
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("storage_paid_at")
      public val storagePaidAt: Long? = 0L,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("storage_usage")
      public val storageUsage: Long,
    )

    /**
     *  * Possible values: account_update
     */
    @Serializable
    public enum class Type {
      @SerialName("account_update")
      ACCOUNT_UPDATE,
    }
  }

  @Serializable
  public data class AccountDeletion(
    @SerialName("change")
    public val change: ChangePayload,
    /**
     *  * Possible values: account_deletion
     */
    @SerialName("type")
    public val type: Type,
    @SerialName("cause")
    public val cause: StateChangeCauseView,
  ) : StateChangeWithCauseView() {
    @Serializable
    public data class ChangePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
    )

    /**
     *  * Possible values: account_deletion
     */
    @Serializable
    public enum class Type {
      @SerialName("account_deletion")
      ACCOUNT_DELETION,
    }
  }

  @Serializable
  public data class AccessKeyUpdate(
    @SerialName("change")
    public val change: ChangePayload,
    /**
     *  * Possible values: access_key_update
     */
    @SerialName("type")
    public val type: Type,
    @SerialName("cause")
    public val cause: StateChangeCauseView,
  ) : StateChangeWithCauseView() {
    @Serializable
    public data class ChangePayload(
      @SerialName("access_key")
      public val accessKey: AccessKeyView,
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("public_key")
      public val publicKey: PublicKey,
    )

    /**
     *  * Possible values: access_key_update
     */
    @Serializable
    public enum class Type {
      @SerialName("access_key_update")
      ACCESS_KEY_UPDATE,
    }
  }

  @Serializable
  public data class AccessKeyDeletion(
    @SerialName("change")
    public val change: ChangePayload,
    /**
     *  * Possible values: access_key_deletion
     */
    @SerialName("type")
    public val type: Type,
    @SerialName("cause")
    public val cause: StateChangeCauseView,
  ) : StateChangeWithCauseView() {
    @Serializable
    public data class ChangePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("public_key")
      public val publicKey: PublicKey,
    )

    /**
     *  * Possible values: access_key_deletion
     */
    @Serializable
    public enum class Type {
      @SerialName("access_key_deletion")
      ACCESS_KEY_DELETION,
    }
  }

  @Serializable
  public data class GasKeyUpdate(
    @SerialName("change")
    public val change: ChangePayload,
    /**
     *  * Possible values: gas_key_update
     */
    @SerialName("type")
    public val type: Type,
    @SerialName("cause")
    public val cause: StateChangeCauseView,
  ) : StateChangeWithCauseView() {
    @Serializable
    public data class ChangePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("gas_key")
      public val gasKey: GasKeyView,
      @SerialName("public_key")
      public val publicKey: PublicKey,
    )

    /**
     *  * Possible values: gas_key_update
     */
    @Serializable
    public enum class Type {
      @SerialName("gas_key_update")
      GAS_KEY_UPDATE,
    }
  }

  @Serializable
  public data class GasKeyNonceUpdate(
    @SerialName("change")
    public val change: ChangePayload,
    /**
     *  * Possible values: gas_key_nonce_update
     */
    @SerialName("type")
    public val type: Type,
    @SerialName("cause")
    public val cause: StateChangeCauseView,
  ) : StateChangeWithCauseView() {
    @Serializable
    public data class ChangePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      /**
       *  * Minimum: 0.0
       *  * Format: uint32
       */
      @SerialName("index")
      public val index: Int,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("nonce")
      public val nonce: Long,
      @SerialName("public_key")
      public val publicKey: PublicKey,
    )

    /**
     *  * Possible values: gas_key_nonce_update
     */
    @Serializable
    public enum class Type {
      @SerialName("gas_key_nonce_update")
      GAS_KEY_NONCE_UPDATE,
    }
  }

  @Serializable
  public data class GasKeyDeletion(
    @SerialName("change")
    public val change: ChangePayload,
    /**
     *  * Possible values: gas_key_deletion
     */
    @SerialName("type")
    public val type: Type,
    @SerialName("cause")
    public val cause: StateChangeCauseView,
  ) : StateChangeWithCauseView() {
    @Serializable
    public data class ChangePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("public_key")
      public val publicKey: PublicKey,
    )

    /**
     *  * Possible values: gas_key_deletion
     */
    @Serializable
    public enum class Type {
      @SerialName("gas_key_deletion")
      GAS_KEY_DELETION,
    }
  }

  @Serializable
  public data class DataUpdate(
    @SerialName("change")
    public val change: ChangePayload,
    /**
     *  * Possible values: data_update
     */
    @SerialName("type")
    public val type: Type,
    @SerialName("cause")
    public val cause: StateChangeCauseView,
  ) : StateChangeWithCauseView() {
    @Serializable
    public data class ChangePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("key_base64")
      public val keyBase64: StoreKey,
      @SerialName("value_base64")
      public val valueBase64: StoreValue,
    )

    /**
     *  * Possible values: data_update
     */
    @Serializable
    public enum class Type {
      @SerialName("data_update")
      DATA_UPDATE,
    }
  }

  @Serializable
  public data class DataDeletion(
    @SerialName("change")
    public val change: ChangePayload,
    /**
     *  * Possible values: data_deletion
     */
    @SerialName("type")
    public val type: Type,
    @SerialName("cause")
    public val cause: StateChangeCauseView,
  ) : StateChangeWithCauseView() {
    @Serializable
    public data class ChangePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("key_base64")
      public val keyBase64: StoreKey,
    )

    /**
     *  * Possible values: data_deletion
     */
    @Serializable
    public enum class Type {
      @SerialName("data_deletion")
      DATA_DELETION,
    }
  }

  @Serializable
  public data class ContractCodeUpdate(
    @SerialName("change")
    public val change: ChangePayload,
    /**
     *  * Possible values: contract_code_update
     */
    @SerialName("type")
    public val type: Type,
    @SerialName("cause")
    public val cause: StateChangeCauseView,
  ) : StateChangeWithCauseView() {
    @Serializable
    public data class ChangePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("code_base64")
      public val codeBase64: String,
    )

    /**
     *  * Possible values: contract_code_update
     */
    @Serializable
    public enum class Type {
      @SerialName("contract_code_update")
      CONTRACT_CODE_UPDATE,
    }
  }

  @Serializable
  public data class ContractCodeDeletion(
    @SerialName("change")
    public val change: ChangePayload,
    /**
     *  * Possible values: contract_code_deletion
     */
    @SerialName("type")
    public val type: Type,
    @SerialName("cause")
    public val cause: StateChangeCauseView,
  ) : StateChangeWithCauseView() {
    @Serializable
    public data class ChangePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
    )

    /**
     *  * Possible values: contract_code_deletion
     */
    @Serializable
    public enum class Type {
      @SerialName("contract_code_deletion")
      CONTRACT_CODE_DELETION,
    }
  }
}
