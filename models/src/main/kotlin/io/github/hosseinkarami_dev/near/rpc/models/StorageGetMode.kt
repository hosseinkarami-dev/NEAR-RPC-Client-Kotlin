package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class StorageGetMode {
  @SerialName("FlatStorage")
  FLAT_STORAGE,
  @SerialName("Trie")
  TRIE,
}
