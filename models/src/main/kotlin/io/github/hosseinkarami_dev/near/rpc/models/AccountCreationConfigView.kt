package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.UByte
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * The structure describes configuration for creation of new accounts.
 */
@Serializable
public data class AccountCreationConfigView(
  /**
   *  * The minimum length of the top-level account ID that is allowed to be created by any account.
   *  * Minimum: 0.0
   *  * Maximum: 255.0
   *  * Format: uint8
   */
  @SerialName("min_allowed_top_level_account_length")
  public val minAllowedTopLevelAccountLength: UByte? = null,
  /**
   *  * The account ID of the account registrar. This account ID allowed to create top-level
   * accounts of any valid length.
   */
  @SerialName("registrar_account_id")
  public val registrarAccountId: AccountId? = null,
)
