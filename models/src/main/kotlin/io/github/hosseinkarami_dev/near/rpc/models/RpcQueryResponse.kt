package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class RpcQueryResponse {
  @Serializable
  public class AccountView(
    @SerialName("amount")
    public val amount: NearToken,
    @SerialName("code_hash")
    public val codeHash: CryptoHash,
    @SerialName("global_contract_account_id")
    public val globalContractAccountId: AccountId?,
    @SerialName("global_contract_hash")
    public val globalContractHash: CryptoHash?,
    @SerialName("locked")
    public val locked: NearToken,
    @SerialName("storage_paid_at")
    public val storagePaidAt: Long?,
    @SerialName("storage_usage")
    public val storageUsage: Long,
    @SerialName("block_hash")
    public val blockHash: CryptoHash,
    @SerialName("block_height")
    public val blockHeight: Long,
  ) : RpcQueryResponse()

  @Serializable
  public class ContractCodeView(
    @SerialName("code_base64")
    public val codeBase64: String,
    @SerialName("hash")
    public val hash: CryptoHash,
    @SerialName("block_hash")
    public val blockHash: CryptoHash,
    @SerialName("block_height")
    public val blockHeight: Long,
  ) : RpcQueryResponse()

  @Serializable
  public class ViewStateResult(
    @SerialName("proof")
    public val proof: List<String>,
    @SerialName("values")
    public val values: List<StateItem>,
    @SerialName("block_hash")
    public val blockHash: CryptoHash,
    @SerialName("block_height")
    public val blockHeight: Long,
  ) : RpcQueryResponse()

  @Serializable
  public class CallResult(
    @SerialName("logs")
    public val logs: List<String>,
    @SerialName("result")
    public val result: List<Int>,
    @SerialName("block_hash")
    public val blockHash: CryptoHash,
    @SerialName("block_height")
    public val blockHeight: Long,
  ) : RpcQueryResponse()

  @Serializable
  public class AccessKeyView(
    @SerialName("nonce")
    public val nonce: Long,
    @SerialName("permission")
    public val permission: AccessKeyPermissionView,
    @SerialName("block_hash")
    public val blockHash: CryptoHash,
    @SerialName("block_height")
    public val blockHeight: Long,
  ) : RpcQueryResponse()

  @Serializable
  public class AccessKeyList(
    @SerialName("keys")
    public val keys: List<AccessKeyInfoView>,
    @SerialName("block_hash")
    public val blockHash: CryptoHash,
    @SerialName("block_height")
    public val blockHeight: Long,
  ) : RpcQueryResponse()
}
