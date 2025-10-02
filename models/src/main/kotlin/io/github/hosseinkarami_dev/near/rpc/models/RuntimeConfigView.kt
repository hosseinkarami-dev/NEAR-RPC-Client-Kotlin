package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RuntimeConfigView(
  @SerialName("account_creation_config")
  public val accountCreationConfig: AccountCreationConfigView,
  @SerialName("congestion_control_config")
  public val congestionControlConfig: CongestionControlConfigView,
  @SerialName("storage_amount_per_byte")
  public val storageAmountPerByte: NearToken,
  @SerialName("transaction_costs")
  public val transactionCosts: RuntimeFeesConfigView,
  @SerialName("wasm_config")
  public val wasmConfig: VMConfigView,
  @SerialName("witness_config")
  public val witnessConfig: WitnessConfigView,
)
