package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.SyncConfigSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Configures how to fetch state parts during state sync.
 */
@Serializable(with = SyncConfigSerializer::class)
public sealed class SyncConfig {
  /**
   *  * Syncs state from the peers without reading anything from external storage.
   *  * Possible values: Peers
   */
  @Serializable
  @SerialName("Peers")
  public data class Peers(
    public val `value`: String = "Peers",
  ) : SyncConfig()

  /**
   *  * Expects parts to be available in external storage.
   *
   * Usually as a fallback after some number of attempts to use peers.
   */
  @Serializable
  public data class ExternalStorage(
    @SerialName("ExternalStorage")
    public val externalStorage: ExternalStorageConfig,
  ) : SyncConfig()
}
