package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class StateChangeWithCauseView {
  @Serializable
  public class AccountUpdate(
    @SerialName("change")
    public val change: ChangePayload,
    @SerialName("type")
    public val type: Type,
    @SerialName("cause")
    public val cause: StateChangeCauseView,
  ) : StateChangeWithCauseView() {
    @Serializable
    public data class ChangePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("amount")
      public val amount: NearToken,
      @SerialName("code_hash")
      public val codeHash: CryptoHash,
      @SerialName("global_contract_account_id")
      public val globalContractAccountId: AccountId?,
      @SerialName("global_contract_hash")
      public val globalContractHash: CryptoHash?,
      @SerialName("locked")
      public val locked: NearToken,
      @SerialName("storage_paid_at")
      public val storagePaidAt: Long?,
      @SerialName("storage_usage")
      public val storageUsage: Long,
    )

    @Serializable
    public enum class Type {
      @SerialName("account_update")
      ACCOUNT_UPDATE,
    }
  }

  @Serializable
  public class AccountDeletion(
    @SerialName("change")
    public val change: ChangePayload,
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

    @Serializable
    public enum class Type {
      @SerialName("account_deletion")
      ACCOUNT_DELETION,
    }
  }

  @Serializable
  public class AccessKeyUpdate(
    @SerialName("change")
    public val change: ChangePayload,
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

    @Serializable
    public enum class Type {
      @SerialName("access_key_update")
      ACCESS_KEY_UPDATE,
    }
  }

  @Serializable
  public class AccessKeyDeletion(
    @SerialName("change")
    public val change: ChangePayload,
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

    @Serializable
    public enum class Type {
      @SerialName("access_key_deletion")
      ACCESS_KEY_DELETION,
    }
  }

  @Serializable
  public class GasKeyUpdate(
    @SerialName("change")
    public val change: ChangePayload,
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

    @Serializable
    public enum class Type {
      @SerialName("gas_key_update")
      GAS_KEY_UPDATE,
    }
  }

  @Serializable
  public class GasKeyNonceUpdate(
    @SerialName("change")
    public val change: ChangePayload,
    @SerialName("type")
    public val type: Type,
    @SerialName("cause")
    public val cause: StateChangeCauseView,
  ) : StateChangeWithCauseView() {
    @Serializable
    public data class ChangePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("index")
      public val index: Int,
      @SerialName("nonce")
      public val nonce: Long,
      @SerialName("public_key")
      public val publicKey: PublicKey,
    )

    @Serializable
    public enum class Type {
      @SerialName("gas_key_nonce_update")
      GAS_KEY_NONCE_UPDATE,
    }
  }

  @Serializable
  public class GasKeyDeletion(
    @SerialName("change")
    public val change: ChangePayload,
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

    @Serializable
    public enum class Type {
      @SerialName("gas_key_deletion")
      GAS_KEY_DELETION,
    }
  }

  @Serializable
  public class DataUpdate(
    @SerialName("change")
    public val change: ChangePayload,
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

    @Serializable
    public enum class Type {
      @SerialName("data_update")
      DATA_UPDATE,
    }
  }

  @Serializable
  public class DataDeletion(
    @SerialName("change")
    public val change: ChangePayload,
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

    @Serializable
    public enum class Type {
      @SerialName("data_deletion")
      DATA_DELETION,
    }
  }

  @Serializable
  public class ContractCodeUpdate(
    @SerialName("change")
    public val change: ChangePayload,
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

    @Serializable
    public enum class Type {
      @SerialName("contract_code_update")
      CONTRACT_CODE_UPDATE,
    }
  }

  @Serializable
  public class ContractCodeDeletion(
    @SerialName("change")
    public val change: ChangePayload,
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

    @Serializable
    public enum class Type {
      @SerialName("contract_code_deletion")
      CONTRACT_CODE_DELETION,
    }
  }
}
