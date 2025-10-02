package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class StateChangeKindView {
  @Serializable
  public class AccountTouched(
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("type")
    public val type: Type,
  ) : StateChangeKindView() {
    @Serializable
    public enum class Type {
      @SerialName("account_touched")
      ACCOUNT_TOUCHED,
    }
  }

  @Serializable
  public class AccessKeyTouched(
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("type")
    public val type: Type,
  ) : StateChangeKindView() {
    @Serializable
    public enum class Type {
      @SerialName("access_key_touched")
      ACCESS_KEY_TOUCHED,
    }
  }

  @Serializable
  public class DataTouched(
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("type")
    public val type: Type,
  ) : StateChangeKindView() {
    @Serializable
    public enum class Type {
      @SerialName("data_touched")
      DATA_TOUCHED,
    }
  }

  @Serializable
  public class ContractCodeTouched(
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("type")
    public val type: Type,
  ) : StateChangeKindView() {
    @Serializable
    public enum class Type {
      @SerialName("contract_code_touched")
      CONTRACT_CODE_TOUCHED,
    }
  }
}
