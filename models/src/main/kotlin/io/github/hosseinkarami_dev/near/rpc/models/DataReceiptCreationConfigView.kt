package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * The fees settings for a data receipt creation
 */
@Serializable
public data class DataReceiptCreationConfigView(
  /**
   *  * Base cost of creating a data receipt.
   * Both `send` and `exec` costs are burned when a new receipt has input dependencies. The gas
   * is charged for each input dependency. The dependencies are specified when a receipt is
   * created using `promise_then` and `promise_batch_then`.
   * NOTE: Any receipt with output dependencies will produce data receipts. Even if it fails.
   * Even if the last action is not a function call (in case of success it will return empty
   * value).
   */
  @SerialName("base_cost")
  public val baseCost: Fee,
  /**
   *  * Additional cost per byte sent.
   * Both `send` and `exec` costs are burned when a function call finishes execution and returns
   * `N` bytes of data to every output dependency. For each output dependency the cost is
   * `(send(sir) + exec()) * N`.
   */
  @SerialName("cost_per_byte")
  public val costPerByte: Fee,
)
