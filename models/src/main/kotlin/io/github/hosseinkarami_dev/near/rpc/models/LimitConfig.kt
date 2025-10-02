package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class LimitConfig(
  @SerialName("account_id_validity_rules_version")
  public val accountIdValidityRulesVersion: AccountIdValidityRulesVersion?,
  @SerialName("initial_memory_pages")
  public val initialMemoryPages: Int,
  @SerialName("max_actions_per_receipt")
  public val maxActionsPerReceipt: Long,
  @SerialName("max_arguments_length")
  public val maxArgumentsLength: Long,
  @SerialName("max_contract_size")
  public val maxContractSize: Long,
  @SerialName("max_elements_per_contract_table")
  public val maxElementsPerContractTable: Int?,
  @SerialName("max_functions_number_per_contract")
  public val maxFunctionsNumberPerContract: Long?,
  @SerialName("max_gas_burnt")
  public val maxGasBurnt: NearGas,
  @SerialName("max_length_method_name")
  public val maxLengthMethodName: Long,
  @SerialName("max_length_returned_data")
  public val maxLengthReturnedData: Long,
  @SerialName("max_length_storage_key")
  public val maxLengthStorageKey: Long,
  @SerialName("max_length_storage_value")
  public val maxLengthStorageValue: Long,
  @SerialName("max_locals_per_contract")
  public val maxLocalsPerContract: Long?,
  @SerialName("max_memory_pages")
  public val maxMemoryPages: Int,
  @SerialName("max_number_bytes_method_names")
  public val maxNumberBytesMethodNames: Long,
  @SerialName("max_number_input_data_dependencies")
  public val maxNumberInputDataDependencies: Long,
  @SerialName("max_number_logs")
  public val maxNumberLogs: Long,
  @SerialName("max_number_registers")
  public val maxNumberRegisters: Long,
  @SerialName("max_promises_per_function_call_action")
  public val maxPromisesPerFunctionCallAction: Long,
  @SerialName("max_receipt_size")
  public val maxReceiptSize: Long,
  @SerialName("max_register_size")
  public val maxRegisterSize: Long,
  @SerialName("max_stack_height")
  public val maxStackHeight: Int,
  @SerialName("max_tables_per_contract")
  public val maxTablesPerContract: Int?,
  @SerialName("max_total_log_length")
  public val maxTotalLogLength: Long,
  @SerialName("max_total_prepaid_gas")
  public val maxTotalPrepaidGas: NearGas,
  @SerialName("max_transaction_size")
  public val maxTransactionSize: Long,
  @SerialName("max_yield_payload_size")
  public val maxYieldPayloadSize: Long,
  @SerialName("per_receipt_storage_proof_size_limit")
  public val perReceiptStorageProofSizeLimit: Int,
  @SerialName("registers_memory_limit")
  public val registersMemoryLimit: Long,
  @SerialName("yield_timeout_length_in_blocks")
  public val yieldTimeoutLengthInBlocks: Long,
)
