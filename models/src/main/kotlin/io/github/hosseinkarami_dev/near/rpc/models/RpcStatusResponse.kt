package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcStatusResponse(
  @SerialName("chain_id")
  public val chainId: String,
  @SerialName("detailed_debug_status")
  public val detailedDebugStatus: DetailedDebugStatus?,
  @SerialName("genesis_hash")
  public val genesisHash: CryptoHash,
  @SerialName("latest_protocol_version")
  public val latestProtocolVersion: Int,
  @SerialName("node_key")
  public val nodeKey: PublicKey?,
  @SerialName("node_public_key")
  public val nodePublicKey: PublicKey,
  @SerialName("protocol_version")
  public val protocolVersion: Int,
  @SerialName("rpc_addr")
  public val rpcAddr: String?,
  @SerialName("sync_info")
  public val syncInfo: StatusSyncInfo,
  @SerialName("uptime_sec")
  public val uptimeSec: Long,
  @SerialName("validator_account_id")
  public val validatorAccountId: AccountId?,
  @SerialName("validator_public_key")
  public val validatorPublicKey: PublicKey?,
  @SerialName("validators")
  public val validators: List<ValidatorInfo>,
  @SerialName("version")
  public val version: Version,
)
