package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.TrackedShardsConfigSerializer
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Describes the expected behavior of the node regarding shard tracking.
 * If the node is an active validator, it will also track the shards it is responsible for as a validator.
 */
@Serializable(with = TrackedShardsConfigSerializer::class)
public sealed class TrackedShardsConfig {
  /**
   *  * Tracks no shards (light client).
   *  * Possible values: NoShards
   */
  @Serializable
  @SerialName("NoShards")
  public object NoShards : TrackedShardsConfig()

  /**
   *  * Tracks arbitrary shards.
   */
  @Serializable
  public data class Shards(
    @SerialName("Shards")
    public val shards: List<ShardUId>,
  ) : TrackedShardsConfig()

  /**
   *  * Tracks all shards.
   *  * Possible values: AllShards
   */
  @Serializable
  @SerialName("AllShards")
  public object AllShards : TrackedShardsConfig()

  /**
   *  * Tracks shards that are assigned to given validator account.
   */
  @Serializable
  public data class ShadowValidator(
    @SerialName("ShadowValidator")
    public val shadowValidator: AccountId,
  ) : TrackedShardsConfig()

  /**
   *  * Rotate between these sets of tracked shards.
   * Used to simulate the behavior of chunk only producers without staking tokens.
   */
  @Serializable
  public data class Schedule(
    @SerialName("Schedule")
    public val schedule: List<List<ShardId>>,
  ) : TrackedShardsConfig()

  /**
   *  * Tracks shards that contain one of the given account.
   */
  @Serializable
  public data class Accounts(
    @SerialName("Accounts")
    public val accounts: List<AccountId>,
  ) : TrackedShardsConfig()
}
