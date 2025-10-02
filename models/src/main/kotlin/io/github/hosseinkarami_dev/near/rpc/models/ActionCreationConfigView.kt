package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ActionCreationConfigView(
  @SerialName("add_key_cost")
  public val addKeyCost: AccessKeyCreationConfigView,
  @SerialName("create_account_cost")
  public val createAccountCost: Fee,
  @SerialName("delegate_cost")
  public val delegateCost: Fee,
  @SerialName("delete_account_cost")
  public val deleteAccountCost: Fee,
  @SerialName("delete_key_cost")
  public val deleteKeyCost: Fee,
  @SerialName("deploy_contract_cost")
  public val deployContractCost: Fee,
  @SerialName("deploy_contract_cost_per_byte")
  public val deployContractCostPerByte: Fee,
  @SerialName("function_call_cost")
  public val functionCallCost: Fee,
  @SerialName("function_call_cost_per_byte")
  public val functionCallCostPerByte: Fee,
  @SerialName("stake_cost")
  public val stakeCost: Fee,
  @SerialName("transfer_cost")
  public val transferCost: Fee,
)
