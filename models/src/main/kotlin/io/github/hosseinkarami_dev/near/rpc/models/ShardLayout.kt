package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.ShardLayoutSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * A versioned struct that contains all information needed to assign accounts to shards.
 *
 * Because of re-sharding, the chain may use different shard layout to split shards at different
 * times. Currently, `ShardLayout` is stored as part of `EpochConfig`, which is generated each
 * epoch given the epoch protocol version. In mainnet/testnet, we use two shard layouts since
 * re-sharding has only happened once. It is stored as part of genesis config, see
 * default_simple_nightshade_shard_layout() Below is an overview for some important
 * functionalities of ShardLayout interface.
 */
@Serializable(with = ShardLayoutSerializer::class)
public sealed class ShardLayout {
  @Serializable
  public data class V0(
    @SerialName("V0")
    public val v0: ShardLayoutV0,
  ) : ShardLayout()

  @Serializable
  public data class V1(
    @SerialName("V1")
    public val v1: ShardLayoutV1,
  ) : ShardLayout()

  @Serializable
  public data class V2(
    @SerialName("V2")
    public val v2: ShardLayoutV2,
  ) : ShardLayout()

  @Serializable
  public data class V3(
    @SerialName("V3")
    public val v3: ShardLayoutV3,
  ) : ShardLayout()
}
