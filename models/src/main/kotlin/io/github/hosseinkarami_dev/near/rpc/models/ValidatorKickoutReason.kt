package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.Long
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class ValidatorKickoutReason {
  @Serializable
  @SerialName("_UnusedSlashed")
  public object UnusedSlashed : ValidatorKickoutReason()

  @Serializable
  public class NotEnoughBlocks(
    @SerialName("NotEnoughBlocks")
    public val notEnoughBlocks: NotEnoughBlocksPayload,
  ) : ValidatorKickoutReason() {
    @Serializable
    public data class NotEnoughBlocksPayload(
      @SerialName("expected")
      public val expected: Long,
      @SerialName("produced")
      public val produced: Long,
    )
  }

  @Serializable
  public class NotEnoughChunks(
    @SerialName("NotEnoughChunks")
    public val notEnoughChunks: NotEnoughChunksPayload,
  ) : ValidatorKickoutReason() {
    @Serializable
    public data class NotEnoughChunksPayload(
      @SerialName("expected")
      public val expected: Long,
      @SerialName("produced")
      public val produced: Long,
    )
  }

  @Serializable
  @SerialName("Unstaked")
  public object Unstaked : ValidatorKickoutReason()

  @Serializable
  public class NotEnoughStake(
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

  @Serializable
  @SerialName("DidNotGetASeat")
  public object DidNotGetASeat : ValidatorKickoutReason()

  @Serializable
  public class NotEnoughChunkEndorsements(
    @SerialName("NotEnoughChunkEndorsements")
    public val notEnoughChunkEndorsements: NotEnoughChunkEndorsementsPayload,
  ) : ValidatorKickoutReason() {
    @Serializable
    public data class NotEnoughChunkEndorsementsPayload(
      @SerialName("expected")
      public val expected: Long,
      @SerialName("produced")
      public val produced: Long,
    )
  }

  @Serializable
  public class ProtocolVersionTooOld(
    @SerialName("ProtocolVersionTooOld")
    public val protocolVersionTooOld: ProtocolVersionTooOldPayload,
  ) : ValidatorKickoutReason() {
    @Serializable
    public data class ProtocolVersionTooOldPayload(
      @SerialName("network_version")
      public val networkVersion: Int,
      @SerialName("version")
      public val version: Int,
    )
  }
}
