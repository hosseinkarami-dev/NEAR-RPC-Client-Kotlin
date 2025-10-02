package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class TrackedShardsConfig {
  @Serializable
  @SerialName("NoShards")
  public object NoShards : TrackedShardsConfig()

  @Serializable
  public class Shards(
    @SerialName("Shards")
    public val shards: List<ShardUId>,
  ) : TrackedShardsConfig()

  @Serializable
  @SerialName("AllShards")
  public object AllShards : TrackedShardsConfig()

  @Serializable
  public class ShadowValidator(
    @SerialName("ShadowValidator")
    public val shadowValidator: AccountId,
  ) : TrackedShardsConfig()

  @Serializable
  public class Schedule(
    @SerialName("Schedule")
    public val schedule: List<List<ShardId>>,
  ) : TrackedShardsConfig()

  @Serializable
  public class Accounts(
    @SerialName("Accounts")
    public val accounts: List<AccountId>,
  ) : TrackedShardsConfig()
}
