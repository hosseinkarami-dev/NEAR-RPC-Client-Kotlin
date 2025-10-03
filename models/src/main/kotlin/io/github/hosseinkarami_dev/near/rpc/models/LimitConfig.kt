package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.Long
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
      AccountIdValidityRulesVersion? = AccountIdValidityRulesVersion(0.toInt()),
  /**
   *  * The initial number of memory pages.
   * NOTE: It's not a limiter itself, but it's a value we use for initial_memory_pages.
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("initial_memory_pages")
  public val initialMemoryPages: Int,
  /**
   *  * Max number of actions per receipt.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_actions_per_receipt")
  public val maxActionsPerReceipt: Long,
  /**
   *  * Max length of arguments in a function call action.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_arguments_length")
  public val maxArgumentsLength: Long,
  /**
   *  * Max contract size
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_contract_size")
  public val maxContractSize: Long,
  /**
   *  * If present, stores max number of elements in a single contract's table
   *  * Minimum: 0.0
   *  * Format: uint
   *  * Nullable: true
   */
  @SerialName("max_elements_per_contract_table")
  public val maxElementsPerContractTable: Int? = null,
  /**
   *  * If present, stores max number of functions in one contract
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("max_functions_number_per_contract")
  public val maxFunctionsNumberPerContract: Long? = null,
  /**
   *  * Max amount of gas that can be used, excluding gas attached to promises.
   */
  @SerialName("max_gas_burnt")
  public val maxGasBurnt: NearGas,
  /**
   *  * Max length of any method name (without terminating character).
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_length_method_name")
  public val maxLengthMethodName: Long,
  /**
   *  * Max length of returned data
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_length_returned_data")
  public val maxLengthReturnedData: Long,
  /**
   *  * Max storage key size
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_length_storage_key")
  public val maxLengthStorageKey: Long,
  /**
   *  * Max storage value size
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_length_storage_value")
  public val maxLengthStorageValue: Long,
  /**
   *  * If present, stores max number of locals declared globally in one contract
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("max_locals_per_contract")
  public val maxLocalsPerContract: Long? = null,
  /**
   *  * What is the maximal memory pages amount is allowed to have for a contract.
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("max_memory_pages")
  public val maxMemoryPages: Int,
  /**
   *  * Max total length of all method names (including terminating character) for a function call
   * permission access key.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_number_bytes_method_names")
  public val maxNumberBytesMethodNames: Long,
  /**
   *  * Max number of input data dependencies
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_number_input_data_dependencies")
  public val maxNumberInputDataDependencies: Long,
  /**
   *  * Maximum number of log entries.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_number_logs")
  public val maxNumberLogs: Long,
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
  public val maxNumberRegisters: Long,
  /**
   *  * Max number of promises that a function call can create
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_promises_per_function_call_action")
  public val maxPromisesPerFunctionCallAction: Long,
  /**
   *  * Max receipt size
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_receipt_size")
  public val maxReceiptSize: Long,
  /**
   *  * Maximum number of bytes that can be stored in a single register.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_register_size")
  public val maxRegisterSize: Long,
  /**
   *  * How tall the stack is allowed to grow?
   *
   * See <https://wiki.parity.io/WebAssembly-StackHeight> to find out how the stack frame cost
   * is calculated.
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("max_stack_height")
  public val maxStackHeight: Int,
  /**
   *  * If present, stores max number of tables declared globally in one contract
   *  * Minimum: 0.0
   *  * Format: uint32
   *  * Nullable: true
   */
  @SerialName("max_tables_per_contract")
  public val maxTablesPerContract: Int? = null,
  /**
   *  * Maximum total length in bytes of all log messages.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_total_log_length")
  public val maxTotalLogLength: Long,
  /**
   *  * Max total prepaid gas for all function call actions per receipt.
   */
  @SerialName("max_total_prepaid_gas")
  public val maxTotalPrepaidGas: NearGas,
  /**
   *  * Max transaction size
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_transaction_size")
  public val maxTransactionSize: Long,
  /**
   *  * Maximum number of bytes for payload passed over a yield resume.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_yield_payload_size")
  public val maxYieldPayloadSize: Long,
  /**
   *  * Hard limit on the size of storage proof generated while executing a single receipt.
   *  * Minimum: 0.0
   *  * Format: uint
   */
  @SerialName("per_receipt_storage_proof_size_limit")
  public val perReceiptStorageProofSizeLimit: Int,
  /**
   *  * Limit of memory used by registers.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("registers_memory_limit")
  public val registersMemoryLimit: Long,
  /**
   *  * Number of blocks after which a yielded promise times out.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("yield_timeout_length_in_blocks")
  public val yieldTimeoutLengthInBlocks: Long,
) {
  init {
    require((initialMemoryPages?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.initialMemoryPages must be >= 0.0" }}
  init {
    require((maxActionsPerReceipt?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxActionsPerReceipt must be >= 0.0" }}
  init {
    require((maxArgumentsLength?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxArgumentsLength must be >= 0.0" }}
  init {
    require((maxContractSize?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxContractSize must be >= 0.0" }}
  init {
    require((maxElementsPerContractTable?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxElementsPerContractTable must be >= 0.0" }}
  init {
    require((maxFunctionsNumberPerContract?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxFunctionsNumberPerContract must be >= 0.0" }}
  init {
    require((maxLengthMethodName?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxLengthMethodName must be >= 0.0" }}
  init {
    require((maxLengthReturnedData?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxLengthReturnedData must be >= 0.0" }}
  init {
    require((maxLengthStorageKey?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxLengthStorageKey must be >= 0.0" }}
  init {
    require((maxLengthStorageValue?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxLengthStorageValue must be >= 0.0" }}
  init {
    require((maxLocalsPerContract?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxLocalsPerContract must be >= 0.0" }}
  init {
    require((maxMemoryPages?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxMemoryPages must be >= 0.0" }}
  init {
    require((maxNumberBytesMethodNames?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxNumberBytesMethodNames must be >= 0.0" }}
  init {
    require((maxNumberInputDataDependencies?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxNumberInputDataDependencies must be >= 0.0" }}
  init {
    require((maxNumberLogs?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxNumberLogs must be >= 0.0" }}
  init {
    require((maxNumberRegisters?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxNumberRegisters must be >= 0.0" }}
  init {
    require((maxPromisesPerFunctionCallAction?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxPromisesPerFunctionCallAction must be >= 0.0" }}
  init {
    require((maxReceiptSize?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxReceiptSize must be >= 0.0" }}
  init {
    require((maxRegisterSize?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxRegisterSize must be >= 0.0" }}
  init {
    require((maxStackHeight?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxStackHeight must be >= 0.0" }}
  init {
    require((maxTablesPerContract?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxTablesPerContract must be >= 0.0" }}
  init {
    require((maxTotalLogLength?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxTotalLogLength must be >= 0.0" }}
  init {
    require((maxTransactionSize?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxTransactionSize must be >= 0.0" }}
  init {
    require((maxYieldPayloadSize?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.maxYieldPayloadSize must be >= 0.0" }}
  init {
    require((perReceiptStorageProofSizeLimit?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.perReceiptStorageProofSizeLimit must be >= 0.0" }}
  init {
    require((registersMemoryLimit?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.registersMemoryLimit must be >= 0.0" }}
  init {
    require((yieldTimeoutLengthInBlocks?.toDouble() ?: 0.0) >= 0.0) { "LimitConfig.yieldTimeoutLengthInBlocks must be >= 0.0" }}
}
