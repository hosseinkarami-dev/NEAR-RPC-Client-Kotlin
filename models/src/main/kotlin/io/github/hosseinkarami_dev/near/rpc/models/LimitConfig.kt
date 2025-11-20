package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.UInt
import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Describes limits for VM and Runtime.
 * TODO #4139: consider switching to strongly-typed wrappers instead of raw quantities
 */
@Serializable
public data class LimitConfig(
  /**
   *  * Whether to enforce account_id well-formed-ness where it wasn't enforced
   * historically.
   */
  @SerialName("account_id_validity_rules_version")
  public val accountIdValidityRulesVersion:
      AccountIdValidityRulesVersion? = AccountIdValidityRulesVersion(0.toUByte()),
  /**
   *  * The initial number of memory pages.
   * NOTE: It's not a limiter itself, but it's a value we use for initial_memory_pages.
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("initial_memory_pages")
  public val initialMemoryPages: UInt? = null,
  /**
   *  * Max number of actions per receipt.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_actions_per_receipt")
  public val maxActionsPerReceipt: ULong? = null,
  /**
   *  * Max length of arguments in a function call action.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_arguments_length")
  public val maxArgumentsLength: ULong? = null,
  /**
   *  * Max contract size
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_contract_size")
  public val maxContractSize: ULong? = null,
  /**
   *  * If present, stores max number of elements in a single contract's table
   *  * Minimum: 0.0
   *  * Format: uint
   *  * Nullable: true
   */
  @SerialName("max_elements_per_contract_table")
  public val maxElementsPerContractTable: UInt? = null,
  /**
   *  * If present, stores max number of functions in one contract
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("max_functions_number_per_contract")
  public val maxFunctionsNumberPerContract: ULong? = null,
  /**
   *  * Max amount of gas that can be used, excluding gas attached to promises.
   */
  @SerialName("max_gas_burnt")
  public val maxGasBurnt: NearGas? = null,
  /**
   *  * Max length of any method name (without terminating character).
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_length_method_name")
  public val maxLengthMethodName: ULong? = null,
  /**
   *  * Max length of returned data
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_length_returned_data")
  public val maxLengthReturnedData: ULong? = null,
  /**
   *  * Max storage key size
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_length_storage_key")
  public val maxLengthStorageKey: ULong? = null,
  /**
   *  * Max storage value size
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_length_storage_value")
  public val maxLengthStorageValue: ULong? = null,
  /**
   *  * If present, stores max number of locals declared globally in one contract
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("max_locals_per_contract")
  public val maxLocalsPerContract: ULong? = null,
  /**
   *  * What is the maximal memory pages amount is allowed to have for a contract.
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("max_memory_pages")
  public val maxMemoryPages: UInt? = null,
  /**
   *  * Max total length of all method names (including terminating character) for a function call
   * permission access key.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_number_bytes_method_names")
  public val maxNumberBytesMethodNames: ULong? = null,
  /**
   *  * Max number of input data dependencies
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_number_input_data_dependencies")
  public val maxNumberInputDataDependencies: ULong? = null,
  /**
   *  * Maximum number of log entries.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_number_logs")
  public val maxNumberLogs: ULong? = null,
  /**
   *  * Maximum number of registers that can be used simultaneously.
   *
   * Note that due to an implementation quirk [read: a bug] in VMLogic, if we
   * have this number of registers, no subsequent writes to the registers
   * will succeed even if they replace an existing register.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_number_registers")
  public val maxNumberRegisters: ULong? = null,
  /**
   *  * Max number of promises that a function call can create
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_promises_per_function_call_action")
  public val maxPromisesPerFunctionCallAction: ULong? = null,
  /**
   *  * Max receipt size
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_receipt_size")
  public val maxReceiptSize: ULong? = null,
  /**
   *  * Maximum number of bytes that can be stored in a single register.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_register_size")
  public val maxRegisterSize: ULong? = null,
  /**
   *  * How tall the stack is allowed to grow?
   *
   * See <https://wiki.parity.io/WebAssembly-StackHeight> to find out how the stack frame cost
   * is calculated.
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("max_stack_height")
  public val maxStackHeight: UInt? = null,
  /**
   *  * If present, stores max number of tables declared globally in one contract
   *  * Minimum: 0.0
   *  * Format: uint32
   *  * Nullable: true
   */
  @SerialName("max_tables_per_contract")
  public val maxTablesPerContract: UInt? = null,
  /**
   *  * Maximum total length in bytes of all log messages.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_total_log_length")
  public val maxTotalLogLength: ULong? = null,
  /**
   *  * Max total prepaid gas for all function call actions per receipt.
   */
  @SerialName("max_total_prepaid_gas")
  public val maxTotalPrepaidGas: NearGas? = null,
  /**
   *  * Max transaction size
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_transaction_size")
  public val maxTransactionSize: ULong? = null,
  /**
   *  * Maximum number of bytes for payload passed over a yield resume.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_yield_payload_size")
  public val maxYieldPayloadSize: ULong? = null,
  /**
   *  * Hard limit on the size of storage proof generated while executing a single receipt.
   *  * Minimum: 0.0
   *  * Format: uint
   */
  @SerialName("per_receipt_storage_proof_size_limit")
  public val perReceiptStorageProofSizeLimit: UInt? = null,
  /**
   *  * Limit of memory used by registers.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("registers_memory_limit")
  public val registersMemoryLimit: ULong? = null,
  /**
   *  * Number of blocks after which a yielded promise times out.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("yield_timeout_length_in_blocks")
  public val yieldTimeoutLengthInBlocks: ULong? = null,
)
