package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * This enum represents if a storage_get call will be performed through flat storage or trie
 *  * Possible values: FlatStorage, Trie
 */
@Serializable
public enum class StorageGetMode {
  @SerialName("FlatStorage")
  FLAT_STORAGE,
  @SerialName("Trie")
  TRIE,
}
