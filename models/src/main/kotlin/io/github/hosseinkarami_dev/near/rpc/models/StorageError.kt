package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.StorageErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Errors which may occur during working with trie storages, storing
 * trie values (trie nodes and state values) by their hashes.
 */
@Serializable(with = StorageErrorSerializer::class)
public sealed class StorageError {
  /**
   *  * Key-value db internal failure
   *  * Possible values: StorageInternalError
   */
  @Serializable
  @SerialName("StorageInternalError")
  public object StorageInternalError : StorageError()

  /**
   *  * Requested trie value by its hash which is missing in storage.
   */
  @Serializable
  public data class MissingTrieValue(
    @SerialName("MissingTrieValue")
    public val missingTrieValue: io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValue,
  ) : StorageError()

  /**
   *  * Found trie node which shouldn't be part of state. Raised during
   * validation of state sync parts where incorrect node was passed.
   * TODO (#8997): consider including hash of trie node.
   *  * Possible values: UnexpectedTrieValue
   */
  @Serializable
  @SerialName("UnexpectedTrieValue")
  public object UnexpectedTrieValue : StorageError()

  /**
   *  * Either invalid state or key-value db is corrupted.
   * For PartialStorage it cannot be corrupted.
   * Error message is unreliable and for debugging purposes only. It's also probably ok to
   * panic in every place that produces this error.
   * We can check if db is corrupted by verifying everything in the state trie.
   */
  @Serializable
  public data class StorageInconsistentState(
    @SerialName("StorageInconsistentState")
    public val storageInconsistentState: String,
  ) : StorageError()

  /**
   *  * Flat storage error, meaning that it doesn't support some block anymore.
   * We guarantee that such block cannot become final, thus block processing
   * must resume normally.
   */
  @Serializable
  public data class FlatStorageBlockNotSupported(
    @SerialName("FlatStorageBlockNotSupported")
    public val flatStorageBlockNotSupported: String,
  ) : StorageError()

  /**
   *  * In-memory trie could not be loaded for some reason.
   */
  @Serializable
  public data class MemTrieLoadingError(
    @SerialName("MemTrieLoadingError")
    public val memTrieLoadingError: String,
  ) : StorageError()
}
