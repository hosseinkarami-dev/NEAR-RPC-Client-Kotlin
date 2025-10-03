package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcStatusResponse(
  /**
   *  * Unique chain id.
   */
  @SerialName("chain_id")
  public val chainId: String,
  /**
   *  * Information about last blocks, network, epoch and chain & chunk info.
   */
  @SerialName("detailed_debug_status")
  public val detailedDebugStatus: DetailedDebugStatus? = null,
  /**
   *  * Genesis hash of the chain.
   */
  @SerialName("genesis_hash")
  public val genesisHash: CryptoHash,
  /**
   *  * Latest protocol version that this client supports.
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("latest_protocol_version")
  public val latestProtocolVersion: Int,
  /**
   *  * Deprecated; same as `validator_public_key` which you should use instead.
   */
  @SerialName("node_key")
  public val nodeKey: PublicKey? = null,
  /**
   *  * Public key of the node.
   */
  @SerialName("node_public_key")
  public val nodePublicKey: PublicKey,
  /**
   *  * Currently active protocol version.
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("protocol_version")
  public val protocolVersion: Int,
  /**
   *  * Address for RPC server.  None if node doesn't have RPC endpoint enabled.
   *  * Nullable: true
   */
  @SerialName("rpc_addr")
  public val rpcAddr: String? = null,
  /**
   *  * Sync status of the node.
   */
  @SerialName("sync_info")
  public val syncInfo: StatusSyncInfo,
  /**
   *  * Uptime of the node.
   *  * Format: int64
   */
  @SerialName("uptime_sec")
  public val uptimeSec: Long,
  /**
   *  * Validator id of the node
   */
  @SerialName("validator_account_id")
  public val validatorAccountId: AccountId? = null,
  /**
   *  * Public key of the validator.
   */
  @SerialName("validator_public_key")
  public val validatorPublicKey: PublicKey? = null,
  /**
   *  * Current epoch validators.
   */
  @SerialName("validators")
  public val validators: List<ValidatorInfo>,
  /**
   *  * Binary version.
   */
  @SerialName("version")
  public val version: Version,
) {
  init {
    require((latestProtocolVersion?.toDouble() ?: 0.0) >= 0.0) { "RpcStatusResponse.latestProtocolVersion must be >= 0.0" }}
  init {
    require((protocolVersion?.toDouble() ?: 0.0) >= 0.0) { "RpcStatusResponse.protocolVersion must be >= 0.0" }}
}
