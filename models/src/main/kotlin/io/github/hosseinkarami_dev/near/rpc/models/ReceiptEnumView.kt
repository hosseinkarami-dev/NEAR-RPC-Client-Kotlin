package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class ReceiptEnumView {
  @Serializable
  public class Action(
    @SerialName("Action")
    public val action: ActionPayload,
  ) : ReceiptEnumView() {
    @Serializable
    public data class ActionPayload(
      @SerialName("actions")
      public val actions: List<ActionView>,
      @SerialName("gas_price")
      public val gasPrice: NearToken,
      @SerialName("input_data_ids")
      public val inputDataIds: List<CryptoHash>,
      @SerialName("is_promise_yield")
      public val isPromiseYield: Boolean?,
      @SerialName("output_data_receivers")
      public val outputDataReceivers: List<DataReceiverView>,
      @SerialName("signer_id")
      public val signerId: AccountId,
      @SerialName("signer_public_key")
      public val signerPublicKey: PublicKey,
    )
  }

  @Serializable
  public class Data(
    @SerialName("Data")
    public val `data`: DataPayload,
  ) : ReceiptEnumView() {
    @Serializable
    public data class DataPayload(
      @SerialName("data")
      public val `data`: String?,
      @SerialName("data_id")
      public val dataId: CryptoHash,
      @SerialName("is_promise_resume")
      public val isPromiseResume: Boolean?,
    )
  }

  @Serializable
  public class GlobalContractDistribution(
    @SerialName("GlobalContractDistribution")
    public val globalContractDistribution: GlobalContractDistributionPayload,
  ) : ReceiptEnumView() {
    @Serializable
    public data class GlobalContractDistributionPayload(
      @SerialName("already_delivered_shards")
      public val alreadyDeliveredShards: List<ShardId>,
      @SerialName("code")
      public val code: String,
      @SerialName("id")
      public val id: GlobalContractIdentifier,
      @SerialName("target_shard")
      public val targetShard: ShardId,
    )
  }
}
