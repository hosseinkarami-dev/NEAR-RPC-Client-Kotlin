package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class AccountView(
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
