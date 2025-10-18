package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * AccountData is a piece of global state that a validator
 * signs and broadcasts to the network.
 *
 * It is essentially the data that a validator wants to share with the network.
 * All the nodes in the network are collecting the account data
 * broadcasted by the validators.
 * Since the number of the validators is bounded and their
 * identity is known (and the maximal size of allowed AccountData is bounded)
 * the global state that is distributed in the form of AccountData is bounded
 * as well.
 * Find more information in the docs [here](https://github.com/near/nearcore/blob/560f7fc8f4b3106e0d5d46050688610b1f104ac6/chain/client/src/client.rs#L2232)
 */
@Serializable
public data class AccountDataView(
  /**
   *  * Account key of the validator signing this AccountData.
   */
  @SerialName("account_key")
  public val accountKey: PublicKey,
  /**
   *  * ID of the node that handles the account key (aka validator key).
   */
  @SerialName("peer_id")
  public val peerId: PublicKey,
  /**
   *  * Proxy nodes that are directly connected to the validator node
   * (this list may include the validator node itself).
   * TIER1 nodes should connect to one of the proxies to sent TIER1
   * messages to the validator.
   */
  @SerialName("proxies")
  public val proxies: List<Tier1ProxyView>,
  /**
   *  * UTC timestamp of when the AccountData has been signed.
   */
  @SerialName("timestamp")
  public val timestamp: String,
)
