package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Contexts in which `StorageError::MissingTrieValue` error might occur.
 */
@Serializable
public sealed class MissingTrieValueContext {
  /**
   *  * Missing trie value when reading from TrieIterator.
   *  * Possible values: TrieIterator
   */
  @Serializable
  @SerialName("TrieIterator")
  public object TrieIterator : MissingTrieValueContext()

  /**
   *  * Missing trie value when reading from TriePrefetchingStorage.
   *  * Possible values: TriePrefetchingStorage
   */
  @Serializable
  @SerialName("TriePrefetchingStorage")
  public object TriePrefetchingStorage : MissingTrieValueContext()

  /**
   *  * Missing trie value when reading from TrieMemoryPartialStorage.
   *  * Possible values: TrieMemoryPartialStorage
   */
  @Serializable
  @SerialName("TrieMemoryPartialStorage")
  public object TrieMemoryPartialStorage : MissingTrieValueContext()

  /**
   *  * Missing trie value when reading from TrieStorage.
   *  * Possible values: TrieStorage
   */
  @Serializable
  @SerialName("TrieStorage")
  public object TrieStorage : MissingTrieValueContext()
}
