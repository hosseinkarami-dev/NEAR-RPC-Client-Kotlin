package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class MethodResolveError {
  @SerialName("MethodEmptyName")
  METHOD_EMPTY_NAME,
  @SerialName("MethodNotFound")
  METHOD_NOT_FOUND,
  @SerialName("MethodInvalidSignature")
  METHOD_INVALID_SIGNATURE,
}
