package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * It is a [serializable view] of [`StateChangeKind`].
 *
 * [serializable view]: ./index.html
 * [`StateChangeKind`]: ../types/struct.StateChangeKind.html
 */
@Serializable
public sealed class StateChangeKindView {
  @Serializable
  public data class AccountTouched(
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Possible values: account_touched
     */
    @SerialName("type")
    public val type: Type,
  ) : StateChangeKindView() {
    /**
     *  * Possible values: account_touched
     */
    @Serializable
    public enum class Type {
      @SerialName("account_touched")
      ACCOUNT_TOUCHED,
    }
  }

  @Serializable
  public data class AccessKeyTouched(
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Possible values: access_key_touched
     */
    @SerialName("type")
    public val type: Type,
  ) : StateChangeKindView() {
    /**
     *  * Possible values: access_key_touched
     */
    @Serializable
    public enum class Type {
      @SerialName("access_key_touched")
      ACCESS_KEY_TOUCHED,
    }
  }

  @Serializable
  public data class DataTouched(
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Possible values: data_touched
     */
    @SerialName("type")
    public val type: Type,
  ) : StateChangeKindView() {
    /**
     *  * Possible values: data_touched
     */
    @Serializable
    public enum class Type {
      @SerialName("data_touched")
      DATA_TOUCHED,
    }
  }

  @Serializable
  public data class ContractCodeTouched(
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Possible values: contract_code_touched
     */
    @SerialName("type")
    public val type: Type,
  ) : StateChangeKindView() {
    /**
     *  * Possible values: contract_code_touched
     */
    @Serializable
    public enum class Type {
      @SerialName("contract_code_touched")
      CONTRACT_CODE_TOUCHED,
    }
  }
}
