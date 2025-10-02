package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class VMConfigView(
  @SerialName("deterministic_account_ids")
  public val deterministicAccountIds: Boolean,
  @SerialName("discard_custom_sections")
  public val discardCustomSections: Boolean,
  @SerialName("eth_implicit_accounts")
  public val ethImplicitAccounts: Boolean,
  @SerialName("ext_costs")
  public val extCosts: ExtCostsConfigView,
  @SerialName("fix_contract_loading_cost")
  public val fixContractLoadingCost: Boolean,
  @SerialName("global_contract_host_fns")
  public val globalContractHostFns: Boolean,
  @SerialName("grow_mem_cost")
  public val growMemCost: Int,
  @SerialName("implicit_account_creation")
  public val implicitAccountCreation: Boolean,
  @SerialName("limit_config")
  public val limitConfig: LimitConfig,
  @SerialName("reftypes_bulk_memory")
  public val reftypesBulkMemory: Boolean,
  @SerialName("regular_op_cost")
  public val regularOpCost: Int,
  @SerialName("saturating_float_to_int")
  public val saturatingFloatToInt: Boolean,
  @SerialName("storage_get_mode")
  public val storageGetMode: StorageGetMode,
  @SerialName("vm_kind")
  public val vmKind: VMKind,
)
