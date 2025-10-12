package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Costs associated with an object that can only be sent over the network (and executed
 * by the receiver).
 * NOTE: `send_sir` or `send_not_sir` fees are usually burned when the item is being created.
 * And `execution` fee is burned when the item is being executed.
 */
@Serializable
public data class Fee(
  /**
   *  * Fee for executing the object.
   */
  @SerialName("execution")
  public val execution: NearGas,
  /**
   *  * Fee for sending an object potentially across the shards.
   */
  @SerialName("send_not_sir")
  public val sendNotSir: NearGas,
  /**
   *  * Fee for sending an object from the sender to itself, guaranteeing that it does not leave
   * the shard.
   */
  @SerialName("send_sir")
  public val sendSir: NearGas,
)
