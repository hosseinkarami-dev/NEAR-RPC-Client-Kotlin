package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlin.UInt
import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class VMConfigView(
  /**
   *  * See [VMConfig::deterministic_account_ids](crate::vm::Config::deterministic_account_ids).
   */
  @SerialName("deterministic_account_ids")
  public val deterministicAccountIds: Boolean? = null,
  /**
   *  * See [VMConfig::discard_custom_sections](crate::vm::Config::discard_custom_sections).
   */
  @SerialName("discard_custom_sections")
  public val discardCustomSections: Boolean? = null,
  /**
   *  * See [VMConfig::eth_implicit_accounts](crate::vm::Config::eth_implicit_accounts).
   */
  @SerialName("eth_implicit_accounts")
  public val ethImplicitAccounts: Boolean? = null,
  /**
   *  * Costs for runtime externals
   */
  @SerialName("ext_costs")
  public val extCosts: ExtCostsConfigView? = null,
  /**
   *  * See [VMConfig::fix_contract_loading_cost](crate::vm::Config::fix_contract_loading_cost).
   */
  @SerialName("fix_contract_loading_cost")
  public val fixContractLoadingCost: Boolean? = null,
  /**
   *  * See [VMConfig::global_contract_host_fns](crate::vm::Config::global_contract_host_fns).
   */
  @SerialName("global_contract_host_fns")
  public val globalContractHostFns: Boolean? = null,
  /**
   *  * Gas cost of a growing memory by single page.
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("grow_mem_cost")
  public val growMemCost: UInt? = null,
  /**
   *  * Deprecated
   */
  @SerialName("implicit_account_creation")
  public val implicitAccountCreation: Boolean? = null,
  /**
   *  * Describes limits for VM and Runtime.
   *
   * TODO: Consider changing this to `VMLimitConfigView` to avoid dependency
   * on runtime.
   */
  @SerialName("limit_config")
  public val limitConfig: LimitConfig? = null,
  /**
   *  * Base gas cost of a linear operation
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("linear_op_base_cost")
  public val linearOpBaseCost: ULong? = null,
  /**
   *  * Unit gas cost of a linear operation
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("linear_op_unit_cost")
  public val linearOpUnitCost: ULong? = null,
  /**
   *  * See [VMConfig::reftypes_bulk_memory](crate::vm::Config::reftypes_bulk_memory).
   */
  @SerialName("reftypes_bulk_memory")
  public val reftypesBulkMemory: Boolean? = null,
  /**
   *  * Gas cost of a regular operation.
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("regular_op_cost")
  public val regularOpCost: UInt? = null,
  /**
   *  * See [VMConfig::saturating_float_to_int](crate::vm::Config::saturating_float_to_int).
   */
  @SerialName("saturating_float_to_int")
  public val saturatingFloatToInt: Boolean? = null,
  /**
   *  * See [VMConfig::storage_get_mode](crate::vm::Config::storage_get_mode).
   */
  @SerialName("storage_get_mode")
  public val storageGetMode: StorageGetMode? = null,
  /**
   *  * See [VMConfig::vm_kind](crate::vm::Config::vm_kind).
   */
  @SerialName("vm_kind")
  public val vmKind: VMKind? = null,
)
