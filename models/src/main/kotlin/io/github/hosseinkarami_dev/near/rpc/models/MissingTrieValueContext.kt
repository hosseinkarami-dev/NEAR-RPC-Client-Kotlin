package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class MissingTrieValueContext {
  @Serializable
  @SerialName("TrieIterator")
  public object TrieIterator : MissingTrieValueContext()

  @Serializable
  @SerialName("TriePrefetchingStorage")
  public object TriePrefetchingStorage : MissingTrieValueContext()

  @Serializable
  @SerialName("TrieMemoryPartialStorage")
  public object TrieMemoryPartialStorage : MissingTrieValueContext()

  @Serializable
  @SerialName("TrieStorage")
  public object TrieStorage : MissingTrieValueContext()
}
