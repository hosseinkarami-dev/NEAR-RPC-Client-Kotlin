package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * A view of the account
 */
@Serializable
public data class AccountView(
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
  public val storagePaidAt: Long?,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("storage_usage")
  public val storageUsage: Long,
)
