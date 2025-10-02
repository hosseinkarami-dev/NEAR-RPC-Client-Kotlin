package io.github.hosseinkarami_dev.near.rpc.client

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class JsonRpcRequest(
  val jsonrpc: String = "2.0",
  val id: Long,
  val method: String,
  val params: JsonElement? = null
)