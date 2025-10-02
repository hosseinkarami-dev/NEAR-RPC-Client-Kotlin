package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class ShardLayout {
  @Serializable
  public class V0(
    @SerialName("V0")
    public val v0: ShardLayoutV0,
  ) : ShardLayout()

  @Serializable
  public class V1(
    @SerialName("V1")
    public val v1: ShardLayoutV1,
  ) : ShardLayout()

  @Serializable
  public class V2(
    @SerialName("V2")
    public val v2: ShardLayoutV2,
  ) : ShardLayout()
}
