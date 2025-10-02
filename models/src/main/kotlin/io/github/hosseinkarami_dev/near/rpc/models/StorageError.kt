package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class StorageError {
  @Serializable
  @SerialName("StorageInternalError")
  public object StorageInternalError : StorageError()

  @Serializable
  public class MissingTrieValue(
    @SerialName("MissingTrieValue")
    public val missingTrieValue: io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValue,
  ) : StorageError()

  @Serializable
  @SerialName("UnexpectedTrieValue")
  public object UnexpectedTrieValue : StorageError()

  @Serializable
  public class StorageInconsistentState(
    @SerialName("StorageInconsistentState")
    public val storageInconsistentState: String,
  ) : StorageError()

  @Serializable
  public class FlatStorageBlockNotSupported(
    @SerialName("FlatStorageBlockNotSupported")
    public val flatStorageBlockNotSupported: String,
  ) : StorageError()

  @Serializable
  public class MemTrieLoadingError(
    @SerialName("MemTrieLoadingError")
    public val memTrieLoadingError: String,
  ) : StorageError()
}
