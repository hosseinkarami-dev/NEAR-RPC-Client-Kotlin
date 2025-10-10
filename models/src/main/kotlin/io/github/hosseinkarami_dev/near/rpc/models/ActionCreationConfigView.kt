package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Describes the cost of creating a specific action, `Action`. Includes all variants.
 */
@Serializable
public data class ActionCreationConfigView(
  /**
   *  * Base cost of adding a key.
   */
  @SerialName("add_key_cost")
  public val addKeyCost: AccessKeyCreationConfigView,
  /**
   *  * Base cost of creating an account.
   */
  @SerialName("create_account_cost")
  public val createAccountCost: Fee,
  /**
   *  * Base cost for processing a delegate action.
   *
   * This is on top of the costs for the actions inside the delegate action.
   */
  @SerialName("delegate_cost")
  public val delegateCost: Fee,
  /**
   *  * Base cost of deleting an account.
   */
  @SerialName("delete_account_cost")
  public val deleteAccountCost: Fee,
  /**
   *  * Base cost of deleting a key.
   */
  @SerialName("delete_key_cost")
  public val deleteKeyCost: Fee,
  /**
   *  * Base cost of deploying a contract.
   */
  @SerialName("deploy_contract_cost")
  public val deployContractCost: Fee,
  /**
   *  * Cost per byte of deploying a contract.
   */
  @SerialName("deploy_contract_cost_per_byte")
  public val deployContractCostPerByte: Fee,
  /**
   *  * Base cost of calling a function.
   */
  @SerialName("function_call_cost")
  public val functionCallCost: Fee,
  /**
   *  * Cost per byte of method name and arguments of calling a function.
   */
  @SerialName("function_call_cost_per_byte")
  public val functionCallCostPerByte: Fee,
  /**
   *  * Base cost of staking.
   */
  @SerialName("stake_cost")
  public val stakeCost: Fee,
  /**
   *  * Base cost of making a transfer.
   */
  @SerialName("transfer_cost")
  public val transferCost: Fee,
)
