package io.github.hosseinkarami_dev.near.rpc.models

/**
 *  * Epoch identifier -- wrapped hash, to make it easier to distinguish.
 * EpochId of epoch T is the hash of last block in T-2
 * EpochId of first two epochs is 0
 */
public typealias EpochId = CryptoHash
