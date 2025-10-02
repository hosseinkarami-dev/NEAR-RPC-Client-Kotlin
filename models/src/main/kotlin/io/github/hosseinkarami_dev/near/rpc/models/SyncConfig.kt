package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class SyncConfig {
  @Serializable
  @SerialName("Peers")
  public object Peers : SyncConfig()

  @Serializable
  public class ExternalStorage(
    @SerialName("ExternalStorage")
    public val externalStorage: ExternalStorageConfig,
  ) : SyncConfig()
}
