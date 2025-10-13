package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.MissingTrieValueContextSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Contexts in which `StorageError::MissingTrieValue` error might occur.
 */
@Serializable(with = MissingTrieValueContextSerializer::class)
public sealed class MissingTrieValueContext {
  /**
   *  * Missing trie value when reading from TrieIterator.
   *  * Possible values: TrieIterator
   */
  @Serializable
  @SerialName("TrieIterator")
  public data class TrieIterator(
    public val `value`: String = "TrieIterator",
  ) : MissingTrieValueContext()

  /**
   *  * Missing trie value when reading from TriePrefetchingStorage.
   *  * Possible values: TriePrefetchingStorage
   */
  @Serializable
  @SerialName("TriePrefetchingStorage")
  public data class TriePrefetchingStorage(
    public val `value`: String = "TriePrefetchingStorage",
  ) : MissingTrieValueContext()

  /**
   *  * Missing trie value when reading from TrieMemoryPartialStorage.
   *  * Possible values: TrieMemoryPartialStorage
   */
  @Serializable
  @SerialName("TrieMemoryPartialStorage")
  public data class TrieMemoryPartialStorage(
    public val `value`: String = "TrieMemoryPartialStorage",
  ) : MissingTrieValueContext()

  /**
   *  * Missing trie value when reading from TrieStorage.
   *  * Possible values: TrieStorage
   */
  @Serializable
  @SerialName("TrieStorage")
  public data class TrieStorage(
    public val `value`: String = "TrieStorage",
  ) : MissingTrieValueContext()
}
