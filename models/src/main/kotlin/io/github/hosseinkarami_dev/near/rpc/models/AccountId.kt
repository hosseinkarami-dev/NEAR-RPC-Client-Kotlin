package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.jvm.JvmInline
import kotlinx.serialization.Serializable

/**
 *  * NEAR Account Identifier.
 *
 * This is a unique, syntactically valid, human-readable account identifier on the NEAR network.
 *
 * [See the crate-level docs for information about validation.](index.html#account-id-rules)
 *
 * Also see [Error kind precedence](AccountId#error-kind-precedence).
 *
 * ## Examples
 *
 * ```
 * use near_account_id::AccountId;
 *
 * let alice: AccountId = "alice.near".parse().unwrap();
 *
 * assert!("ƒelicia.near".parse::<AccountId>().is_err()); // (ƒ is not f)
 * ```
 *  * Schema: https://json-schema.org/draft/2020-12/schema
 */
@Serializable
@JvmInline
public value class AccountId(
  public val `value`: String,
)
