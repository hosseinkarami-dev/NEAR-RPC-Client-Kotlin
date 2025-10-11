package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcQueryResponseSerializer
import kotlin.String
import kotlin.UByte
import kotlin.ULong
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = RpcQueryResponseSerializer::class)
public sealed class RpcQueryResponse {
  @Serializable
  public data class AccountView(
    @SerialName("amount")
    public val amount: NearToken,
    @SerialName("code_hash")
    public val codeHash: CryptoHash,
    @SerialName("global_contract_account_id")
    public val globalContractAccountId: AccountId? = null,
    @SerialName("global_contract_hash")
    public val globalContractHash: CryptoHash? = null,
    @SerialName("locked")
    public val locked: NearToken,
    /**
     *  * TODO(2271): deprecated.
     *  * Minimum: 0.0
     *  * Format: uint64
     */
    @SerialName("storage_paid_at")
    public val storagePaidAt: ULong? = 0.toULong(),
    /**
     *  * Minimum: 0.0
     *  * Format: uint64
     */
    @SerialName("storage_usage")
    public val storageUsage: ULong,
    @SerialName("block_hash")
    public val blockHash: CryptoHash,
    /**
     *  * Minimum: 0.0
     *  * Format: uint64
     */
    @SerialName("block_height")
    public val blockHeight: ULong,
  ) : RpcQueryResponse()

  @Serializable
  public data class ContractCodeView(
    @SerialName("code_base64")
    public val codeBase64: String,
    @SerialName("hash")
    public val hash: CryptoHash,
    @SerialName("block_hash")
    public val blockHash: CryptoHash,
    /**
     *  * Minimum: 0.0
     *  * Format: uint64
     */
    @SerialName("block_height")
    public val blockHeight: ULong,
  ) : RpcQueryResponse()

  @Serializable
  public data class ViewStateResult(
    @SerialName("proof")
    public val proof: List<String>? = null,
    @SerialName("values")
    public val values: List<StateItem>,
    @SerialName("block_hash")
    public val blockHash: CryptoHash,
    /**
     *  * Minimum: 0.0
     *  * Format: uint64
     */
    @SerialName("block_height")
    public val blockHeight: ULong,
  ) : RpcQueryResponse()

  @Serializable
  public data class CallResult(
    @SerialName("logs")
    public val logs: List<String>,
    @SerialName("result")
    public val result: List<UByte>,
    @SerialName("block_hash")
    public val blockHash: CryptoHash,
    /**
     *  * Minimum: 0.0
     *  * Format: uint64
     */
    @SerialName("block_height")
    public val blockHeight: ULong,
  ) : RpcQueryResponse()

  @Serializable
  public data class AccessKeyView(
    /**
     *  * Minimum: 0.0
     *  * Format: uint64
     */
    @SerialName("nonce")
    public val nonce: ULong,
    @SerialName("permission")
    public val permission: AccessKeyPermissionView,
    @SerialName("block_hash")
    public val blockHash: CryptoHash,
    /**
     *  * Minimum: 0.0
     *  * Format: uint64
     */
    @SerialName("block_height")
    public val blockHeight: ULong,
  ) : RpcQueryResponse()

  @Serializable
  public data class AccessKeyList(
    @SerialName("keys")
    public val keys: List<AccessKeyInfoView>,
    @SerialName("block_hash")
    public val blockHash: CryptoHash,
    /**
     *  * Minimum: 0.0
     *  * Format: uint64
     */
    @SerialName("block_height")
    public val blockHeight: ULong,
  ) : RpcQueryResponse()
}
