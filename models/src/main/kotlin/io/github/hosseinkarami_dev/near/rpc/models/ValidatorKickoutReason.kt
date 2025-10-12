package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.ValidatorKickoutReasonSerializer
import kotlin.UInt
import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Reasons for removing a validator from the validator set.
 */
@Serializable(with = ValidatorKickoutReasonSerializer::class)
public sealed class ValidatorKickoutReason {
  /**
   *  * Deprecated
   *  * Possible values: _UnusedSlashed
   */
  @Serializable
  @SerialName("_UnusedSlashed")
  public object UnusedSlashed : ValidatorKickoutReason()

  /**
   *  * Validator didn't produce enough blocks.
   */
  @Serializable
  public data class NotEnoughBlocks(
    @SerialName("NotEnoughBlocks")
    public val notEnoughBlocks: NotEnoughBlocksPayload,
  ) : ValidatorKickoutReason() {
    @Serializable
    public data class NotEnoughBlocksPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("expected")
      public val expected: ULong,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("produced")
      public val produced: ULong,
    )
  }

  /**
   *  * Validator didn't produce enough chunks.
   */
  @Serializable
  public data class NotEnoughChunks(
    @SerialName("NotEnoughChunks")
    public val notEnoughChunks: NotEnoughChunksPayload,
  ) : ValidatorKickoutReason() {
    @Serializable
    public data class NotEnoughChunksPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("expected")
      public val expected: ULong,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("produced")
      public val produced: ULong,
    )
  }

  /**
   *  * Validator unstaked themselves.
   *  * Possible values: Unstaked
   */
  @Serializable
  @SerialName("Unstaked")
  public object Unstaked : ValidatorKickoutReason()

  /**
   *  * Validator stake is now below threshold
   */
  @Serializable
  public data class NotEnoughStake(
    @SerialName("NotEnoughStake")
    public val notEnoughStake: NotEnoughStakePayload,
  ) : ValidatorKickoutReason() {
    @Serializable
    public data class NotEnoughStakePayload(
      @SerialName("stake_u128")
      public val stakeU128: NearToken,
      @SerialName("threshold_u128")
      public val thresholdU128: NearToken,
    )
  }

  /**
   *  * Enough stake but is not chosen because of seat limits.
   *  * Possible values: DidNotGetASeat
   */
  @Serializable
  @SerialName("DidNotGetASeat")
  public object DidNotGetASeat : ValidatorKickoutReason()

  /**
   *  * Validator didn't produce enough chunk endorsements.
   */
  @Serializable
  public data class NotEnoughChunkEndorsements(
    @SerialName("NotEnoughChunkEndorsements")
    public val notEnoughChunkEndorsements: NotEnoughChunkEndorsementsPayload,
  ) : ValidatorKickoutReason() {
    @Serializable
    public data class NotEnoughChunkEndorsementsPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("expected")
      public val expected: ULong,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("produced")
      public val produced: ULong,
    )
  }

  /**
   *  * Validator's last block proposal was for a protocol version older than
   * the network's voted protocol version.
   */
  @Serializable
  public data class ProtocolVersionTooOld(
    @SerialName("ProtocolVersionTooOld")
    public val protocolVersionTooOld: ProtocolVersionTooOldPayload,
  ) : ValidatorKickoutReason() {
    @Serializable
    public data class ProtocolVersionTooOldPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint32
       */
      @SerialName("network_version")
      public val networkVersion: UInt,
      /**
       *  * Minimum: 0.0
       *  * Format: uint32
       */
      @SerialName("version")
      public val version: UInt,
    )
  }
}
